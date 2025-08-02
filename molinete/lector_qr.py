import cv2
from pyzbar.pyzbar import decode
import requests

API_URL = "http://localhost:8080/api/validate-access?qr="

def main():
    cap = cv2.VideoCapture(0)
    print("Escaneando QR...")

    while True:
        ret, frame = cap.read()
        if not ret:
            continue

        qrs = decode(frame)
        for qr in qrs:
            data = qr.data.decode('utf-8')
            print(f"QR Detectado: {data}")
            response = requests.get(API_URL + data)
            if response.status_code == 200 and response.json().get("access_granted"):
                print("Acceso concedido: Abriendo molinete")
            else:
                print("Acceso denegado")

        cv2.imshow('Escaner QR', frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    main()

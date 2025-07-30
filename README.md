# club-access-system 🏋️‍♂️📱🔐

Sistema completo de control de acceso a un club mediante QR escaneado en un molinete. Proyecto de portfolio profesional que muestra integración entre software y hardware.

---

## 🧱 Estructura del Proyecto

```
club-access-system/
├── backend/      # Java Spring Boot - API REST
├── frontend/     # React - Panel de administración
├── molinete/     # Python - Lector QR
├── database/     # Script SQL (PostgreSQL)
└── README.md
```

---

## 🧰 Tecnologías Utilizadas

- **Java + Spring Boot** – Backend con endpoints REST y lógica de negocio.
- **PostgreSQL** – Base de datos relacional.
- **React** – Interfaz de administración para gestión de accesos y socios.
- **Python (OpenCV + Pyzbar)** – Lectura de códigos QR y simulación de apertura de molinete.

---

## 🚀 Funcionalidades

### Socios
- QR único por socio (estático o token temporal).
- Validación de acceso mediante API.
- Registro automático de ingresos.

### Administración
- Panel web con acceso seguro.
- Visualización y filtro de accesos.
- ABM de socios (alta, baja, modificación).

### Hardware
- Lector QR conectado a Raspberry Pi o PC.
- Escaneo en tiempo real.
- Comunicación con backend vía HTTP.

---

## ⚙️ Instalación

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

> Asegúrate de configurar `application.properties` con tus credenciales de PostgreSQL.

### Frontend

```bash
cd frontend
npm install
npm start
```

### Lector QR (Molinete)

```bash
cd molinete
pip install opencv-python pyzbar requests
python lector_qr.py
```

---

## 🗃️ Base de Datos

Script en `database/init.sql`:

```sql
CREATE TABLE socios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    estado BOOLEAN DEFAULT TRUE,
    fecha_alta DATE,
    fecha_baja DATE,
    qr_code TEXT UNIQUE
);

CREATE TABLE accesos (
    id SERIAL PRIMARY KEY,
    socio_id INTEGER REFERENCES socios(id),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    validado BOOLEAN
);
```

---

## 🗓️ Plan de Trabajo Sugerido

1. Semana 1: Diseño y estructura de datos
2. Semana 2: Backend básico
3. Semana 3: Lógica de validación y API REST
4. Semana 4: Frontend React
5. Semana 5: Script de molinete (QR + apertura)
6. Semana 6: Documentación, testing y deploy

---

## 👩‍💻 Autor

Proyecto desarrollado como parte de portfolio profesional para mostrar experiencia en:
- Desarrollo Full Stack
- Integración hardware/software
- Buenas prácticas de arquitectura

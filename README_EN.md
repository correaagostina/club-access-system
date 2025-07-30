# club-access-system 🏋️‍♂️📱🔐

Complete access control system for a sports or social club using QR codes scanned at a turnstile. This portfolio project demonstrates full integration between backend, frontend, database, and hardware simulation.

---

## 🧱 Project Structure

```
club-access-system/
├── backend/      # Java Spring Boot - REST API
├── frontend/     # React - Admin panel
├── molinete/     # Python - QR scanner
├── database/     # PostgreSQL SQL scripts
└── README.md
```

---

## 🧰 Technologies Used

- **Java + Spring Boot** – RESTful backend.
- **PostgreSQL** – Relational database.
- **React** – Admin interface.
- **Python (OpenCV + Pyzbar)** – QR code scanner and simulation.

---

## 🚀 Features

### Members
- Unique QR per member (static or tokenized).
- Access validation through backend API.
- Automatic entry logging.

### Admin Panel
- Secure login.
- Dashboard with access history.
- CRUD operations for member management.

### Hardware Simulation
- Real-time QR code scanning via webcam or USB camera.
- Integration with backend API.
- Entry simulation with logging.

---

## ⚙️ Installation

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

> Configure your `application.properties` with PostgreSQL credentials.

### Frontend

```bash
cd frontend
npm install
npm start
```

### QR Reader (Turnstile)

```bash
cd molinete
pip install opencv-python pyzbar requests
python lector_qr.py
```

---

## 🗃️ Database

Located in `database/init.sql`:

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

## 🗓️ Suggested Milestones

1. Week 1: Design and data models
2. Week 2: Backend setup
3. Week 3: QR validation and API logic
4. Week 4: React Admin Dashboard
5. Week 5: QR reader script (Python)
6. Week 6: Testing, documentation, and deployment

---

## 👩‍💻 Author

Built as a portfolio project to demonstrate:
- Full Stack Development
- Software-hardware integration
- Clean architecture & modular code

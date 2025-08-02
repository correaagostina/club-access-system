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

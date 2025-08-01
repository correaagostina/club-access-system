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


INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (1, 'Norma Fisher', 'ysullivan@yahoo.com', FALSE, '2024-02-02', '2024-11-06', '37ebdcd9-e87a-4613-a443-df789558867f');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (2, 'Diane Campos', 'kyleblair@hotmail.com', FALSE, '2023-12-07', '2024-12-07', '6f25e2a2-5a92-4187-99c7-8df48f4ff31e');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (3, 'Martin Harris', 'qgrimes@gmail.com', TRUE, '2024-06-08', NULL, '03983ca8-ea7e-4d49-8c77-8ea6eb2083e6');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (4, 'Ryan Page', 'vclayton@cross.com', FALSE, '2023-10-14', '2024-12-27', 'f7b0b7d2-cda8-456c-bd15-eef738c1962e');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (5, 'Joshua Davis', 'jrodriguez@yahoo.com', FALSE, '2024-05-01', '2024-08-05', 'ec188efb-d080-466e-952f-233a8c25166a');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (6, 'Tracey Morrison', 'zdavis@yahoo.com', FALSE, '2023-12-02', '2025-02-21', '307bf326-2f12-4554-8a53-08cc3dfabc08');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (7, 'Amanda Zavala', 'rjones@gmail.com', FALSE, '2024-07-06', '2024-10-30', '148b2758-d7ab-4928-89e4-69e6ec62b2c8');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (8, 'Tammy Fernandez', 'aimee33@hotmail.com', FALSE, '2024-03-17', '2025-02-05', '7e1ea9c5-7358-4a81-8674-37419466e472');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (9, 'Whitney Stark', 'nguyendarrell@hotmail.com', FALSE, '2024-04-01', '2024-12-17', '0426465e-3e37-452d-b0bc-ab0ed8570102');
INSERT INTO socios (id, nombre, email, estado, fecha_alta, fecha_baja, qr_code)
VALUES (10, 'Autumn Robinson', 'ronald01@wyatt.com', TRUE, '2024-06-13', NULL, 'efbfc19e-e8f6-4f32-a25b-59fd92e8e269');
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (9, '2025-05-14 07:34:06', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (5, '2025-05-27 12:20:36', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (2, '2025-06-11 17:48:02', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (9, '2025-02-13 22:52:33', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (5, '2025-02-04 18:26:29', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (2, '2025-02-23 17:58:31', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (8, '2025-06-02 21:20:22', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (6, '2025-03-08 04:35:43', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (6, '2025-05-28 07:46:02', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (9, '2025-07-10 18:30:26', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (8, '2025-05-22 10:09:39', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (1, '2025-02-22 19:50:48', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (2, '2025-04-16 13:11:36', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (1, '2025-02-17 08:35:41', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (6, '2025-04-12 11:00:09', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (6, '2025-07-11 12:01:20', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (4, '2025-02-22 02:50:23', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (4, '2025-02-06 15:37:29', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (9, '2025-05-28 03:52:46', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (2, '2025-02-03 18:51:32', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (6, '2025-03-09 08:53:06', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (2, '2025-03-07 12:03:26', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (9, '2025-06-19 00:40:34', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (2, '2025-02-23 15:25:07', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (9, '2025-05-03 15:24:58', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (10, '2025-03-12 11:22:59', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (8, '2025-06-20 18:48:52', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (10, '2025-07-05 01:46:30', FALSE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (6, '2025-02-11 10:42:06', TRUE);
INSERT INTO accesos (socio_id, timestamp, validado)
VALUES (5, '2025-07-31 12:37:05', TRUE);


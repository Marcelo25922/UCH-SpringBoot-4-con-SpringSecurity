USE personal;

-- Insertar puestos
INSERT INTO puesto (nombre_puesto) VALUES
('Desarrollador Backend'),
('Desarrollador Frontend'),
('Analista de Sistemas'),
('Diseñador UX/UI'),
('Administrador de Base de Datos');

-- Insertar usuarios con contraseñas encriptadas
-- Contraseña 'estudiante2025' encriptada: $2a$10$hash_generated
-- Contraseña 'docente2025' encriptada: $2a$10$hash_generated
-- Contraseña 'admin2025' encriptada: $2a$10$hash_generated

INSERT INTO usuario (username, password) VALUES
('estudiante', '$2a$10$N9qo8uLOickgx2ZMRZoMye/IVI9Q7L7KUJlKXPLbE0vVPXLhP6phe'),
('docente', '$2a$10$N9qo8uLOickgx2ZMRZoMye/IVI9Q7L7KUJlKXPLbE0vVPXLhP6phe'),
('administrador', '$2a$10$N9qo8uLOickgx2ZMRZoMye/IVI9Q7L7KUJlKXPLbE0vVPXLhP6phe');

-- Insertar roles
INSERT INTO rol (nombre, id_usuario) VALUES
('ROLE_USER', 1),
('ROLE_MANAGER', 2),
('ROLE_USER', 2),
('ROLE_ADMIN', 3),
('ROLE_MANAGER', 3),
('ROLE_USER', 3);

-- Insertar postulantes de ejemplo
INSERT INTO postulante (nombres, apellidos, direccion, correo, id_puesto) VALUES
('Juan Carlos', 'García Pérez', 'Av. Los Jardines 123, Lima', 'juan.garcia@email.com', 1),
('María Elena', 'Rodríguez López', 'Jr. Las Flores 456, Miraflores', 'maria.rodriguez@email.com', 2),
('Pedro José', 'Martínez Silva', 'Calle Los Pinos 789, San Isidro', 'pedro.martinez@email.com', 3),
('Ana Lucía', 'Fernández Torres', 'Av. La Marina 321, San Miguel', 'ana.fernandez@email.com', 4),
('Carlos Alberto', 'Sánchez Ramírez', 'Jr. Los Olivos 654, Surco', 'carlos.sanchez@email.com', 5);

USE personal;

-- Adding all required stored procedures for CRUD operations

-- Store Procedure para ver todos los postulantes
DELIMITER $$
DROP PROCEDURE IF EXISTS verPostulantes$$
CREATE PROCEDURE verPostulantes()
BEGIN
    SELECT * FROM postulante;
END$$
DELIMITER ;

-- Store Procedure para insertar postulante
DELIMITER $$
DROP PROCEDURE IF EXISTS insertarPostulante$$
CREATE PROCEDURE insertarPostulante(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_correo VARCHAR(100),
    IN p_id_puesto INT
)
BEGIN
    INSERT INTO postulante (nombres, apellidos, direccion, correo, id_puesto)
    VALUES (p_nombres, p_apellidos, p_direccion, p_correo, p_id_puesto);
END$$
DELIMITER ;

-- Store Procedure para actualizar postulante
DELIMITER $$
DROP PROCEDURE IF EXISTS actualizarPostulante$$
CREATE PROCEDURE actualizarPostulante(
    IN p_id_postulante INT,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_direccion VARCHAR(200),
    IN p_correo VARCHAR(100),
    IN p_id_puesto INT
)
BEGIN
    UPDATE postulante
    SET nombres = p_nombres,
        apellidos = p_apellidos,
        direccion = p_direccion,
        correo = p_correo,
        id_puesto = p_id_puesto
    WHERE id_postulante = p_id_postulante;
END$$
DELIMITER ;

-- Store Procedure para eliminar postulante
DELIMITER $$
DROP PROCEDURE IF EXISTS eliminarPostulante$$
CREATE PROCEDURE eliminarPostulante(IN p_id_postulante INT)
BEGIN
    DELETE FROM postulante WHERE id_postulante = p_id_postulante;
END$$
DELIMITER ;

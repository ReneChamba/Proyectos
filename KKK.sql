USE GALERIA_FOTOS;

SELECT * FROM USUARIOS;
INSERT INTO USUARIOS VALUES (NULL, 'Rene', 'rene@gmail.com', '454545', 'USUA', '1234');
SELECT * FROM FOTOS;
UPDATE FOTOS SET PUB_FOT = 0 WHERE IDE_FOT = 1;
SELECT * FROM CATEGORIAS;

INSERT INTO CATEGORIAS VALUES(NULL, 'naturaleza', 'para sobrevir' );

-- DELETE FROM categorias where ide_cat >2;
-- DELETE FROM USUARIOS;
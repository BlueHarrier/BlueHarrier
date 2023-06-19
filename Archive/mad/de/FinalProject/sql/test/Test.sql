INSERT INTO Foto (idFoto) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24); 

INSERT INTO Fabricante (id_Fabricante, Nombre_Fabricante) VALUES
(1, 'Fabricante1 S.A.'),
(2, 'Fabricante2 S.L.'),
(3, 'Fabricante3 S.A.');

INSERT INTO Atraccion (idAtraccion, idFoto, Descripcion, id_Fabricante, Intensidad, Valoracion, Nombre) VALUES
(1, 1, 'Tio_Vivo_1', 1, 5, 9, 'Tio_Vivo_1'),
(2, 2, 'Caida_libre', 2, 8, 7, 'Caida_libre'),
(3, 3, 'Tobogán_Acuático', 3, 6, 8, 'Tobogán_Acuático'),
(4, 4, 'Caida_Libre_2', 2, 8, 10, 'Caida_Libre_2'),
(5, 5,'Tio_Vivo_2', 3, 5, 8, 'Tio_Vivo_2'),
(6, 6,'Coches_de_choque', 2, 7, 7, 'Coches_de_choque'),
(7, 7,'Montaña_Rusa_Ferrari', 3, 10, 10, 'Montaña_Rusa_Ferrari'),
(8, 8,'Montaña_Rusa_Perro', 1, 7, 8, 'Montaña_Rusa_Perro'),
(9, 9,'Montaña_Rusa',1, 9, 8, 'Montaña_Rusa'),
(10, 10,'Rio_Bravo', 1, 7, 9, 'Rio_Bravo'),
(11, 11,'Montaña_Rusa_2', 3, 8, 8, 'Montaña_Rusa_2'),
(12, 12,'Noria', 2, 4, 7, 'Noria'),
(13, 13,'Tio_Vivo_PM', 2, 5, 8, 'Tio_Vivo_PM'),
(14, 14,'Tio_Vivo_3',2, 10, 9, 'Tio_Vivo_EXTREMO'),
(15, 15,'Autobus', 3, 6, 7, 'Autobus'),
(16, 16,'Coches_de_choque_2', 3, 8, 9, 'SUPER_COCHES_PREGUNTONES'),
(17, 17,'Montaña_Rusa_3', 1, 8, 7, 'Montaña_Rusa_3'),
(18, 18,'Mario_Kart', 3, 10, 9, 'Mario_Kart'),
(19, 19,'Montaña_Rusa_4', 1, 8, 9, 'Montaña_Rusa_4'),
(20, 20,'Araña', 2, 8, 8, 'Spiderman_No_se');


INSERT INTO Parque (idParque, Nombre_Parque, idFoto, Descripcion, Ubicacion, Fecha_Apertura, Fecha_Cierre) VALUES
(1, 'Parque de Atracciones', 21, 'Parque1', 'Calle de la Aventura, 123', '2020-01-01', NULL),
(2, 'Parque Temático', 22, 'Parque2', 'Calle del Agua, 456', '2021-06-01', NULL),
(3, 'Parque Temático', 23, 'Parque3', 'Calle de la Montaña, 673', '2021-06-01', NULL),
(4, 'Parque de la Naturaleza', 24, 'Parque4', 'Calle del Bosque, 789', '2019-01-01', NULL);

INSERT INTO `Registro de Servicios` (idAtraccion, idParque, Fecha_Apertura, Fecha_Cierre) VALUES
(1, 1, '2022-04-01', NULL),
(2, 2, '2022-05-01', NULL),
(3, 3, '2019-01-03', '2022-06-01');

INSERT INTO `Registro de incidencias` (idAtraccion, idParque, Fecha_Incidencia, Descripcion_Incidencia) VALUES
(1, 1, '2022-04-15', 'Incidencia_1'),
(2, 2, '2022-05-15', 'Incidencia_2'),
(3, 3, '2022-06-15', 'Incidencia_3');


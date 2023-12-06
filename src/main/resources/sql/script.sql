DELETE FROM atributo_producto;
DELETE FROM producto;
DELETE FROM atributo;
DELETE FROM marca;
DELETE FROM categoria;


INSERT INTO Atributo (id, nombre) VALUES (1, "Impedancia");
INSERT INTO Atributo (id, nombre) VALUES (2, "Respuesta en Frecuencia");
INSERT INTO Atributo (id, nombre) VALUES (3, "Pulgadas Woofer");
INSERT INTO Atributo (id, nombre) VALUES (4, "Pulgadas Tweeter");
INSERT INTO Atributo (id, nombre) VALUES (5, "Salidas");
INSERT INTO Atributo (id, nombre) VALUES (6, "Entradas");
INSERT INTO Atributo (id, nombre) VALUES (7, "Sampleo");
INSERT INTO Atributo (id, nombre) VALUES (8, "Cantidad Pads");
INSERT INTO Atributo (id, nombre) VALUES (9, "Conexión");

INSERT INTO Marca (id, nombre) VALUES (1, "Beyerdynamic");
INSERT INTO Marca (id, nombre) VALUES (2, "Sennheiser");
INSERT INTO Marca (id, nombre) VALUES (3, "KRK");
INSERT INTO Marca (id, nombre) VALUES (4, "Focusrite");
INSERT INTO Marca (id, nombre) VALUES (5, "ADAM");
INSERT INTO Marca (id, nombre) VALUES (6, "Behringer");
INSERT INTO Marca (id, nombre) VALUES (7, "Novation");

INSERT INTO Categoria (id, nombre, descripcion) VALUES (1, "Audífonos", "Auriculares diseñados para brindar una reproducción precisa y detallada del sonido");
INSERT INTO Categoria (id, nombre, descripcion) VALUES (2, "Monitores de Estudio", "Altavoz especializado utilizado para una reproducción precisa y neutral del sonido en entornos de grabación y producción musical");
INSERT INTO Categoria (id, nombre, descripcion) VALUES (3, "Controladores MIDI", "Dispositivo que se utiliza para enviar comandos MIDI a un equipo o software de música");
INSERT INTO Categoria (id, nombre, descripcion) VALUES (4, "Interfaces de Audio", "Dispositivo que conecta instrumentos musicales, micrófonos y otros equipos de audio a una computadora, permitiendo la grabación, reproducción y procesamiento de sonido de alta calidad");
INSERT INTO Categoria (id, nombre, descripcion) VALUES (5, "Microfonos", "Dispositivo que captura sonidos y los convierte en señales eléctricas para ser grabados");

INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (1, 1, "DT-770 Pro 80 Ohm", 170000, 5, "https://i.ibb.co/0jTPcGy/IMG-4.webp", 1);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (2, 1, "DT-990 Pro 250 Ohm", 150000, 8, "https://i.ibb.co/ZKyKX1j/IMG-6.webp", 1);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (3, 2, "HD 650", 250000, 11, "https://i.ibb.co/m9cX1J3/IMG-10.jpg", 1);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (4, 3, "Rokit RP5 G4", 150000, 5, "https://i.ibb.co/RPBtqFz/IMG-3.jpg", 2);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (5, 4, "Scarlett 2i2", 150000, 5, "https://i.ibb.co/nnpqT1X/IMG-1.webp", 4);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (6, 3, "Rokit RP7 G4", 300000, 7, "https://i.ibb.co/RPBtqFz/IMG-3.jpg", 2);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (7, 1, "T5V", 170000, 2, "https://i.ibb.co/7tN9kRD/IMG-5.jpg", 2);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (8, 2, "Scarlett 4i2", 350000, 9, "https://i.ibb.co/FhNqt6j/IMG-2.webp", 4);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (9, 3, "UMC1820", 190000, 7, "https://i.ibb.co/YWfj3V1/IMG-4.webp", 4);
INSERT INTO Producto (id, marca_id, modelo, precio, stock, imagen, categoria_id) VALUES (10, 4, "Launchpad S", 190000, 5, "https://i.ibb.co/yXsMK4Z/IMG-6.webp", 3);

INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (1, 1, 1, "80 Ohm");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (2, 1, 2, "5 Hz - 35000 Hz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (3, 2, 1, "250 Ohm");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (4, 2, 2, "5 Hz - 35000 Hz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (5, 3, 1, "300 Ohm");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (6, 3, 2, "10 Hz - 30000 Hz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (7, 4, 3, 5);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (8, 4, 4, 1);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (9, 4, 2, "43 Hz - 40000 Hz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (10, 5, 7, "24 bit / 192 Khz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (11, 5, 5, 2);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (12, 5, 6, 2);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (13, 6, 3, 7);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (14, 6, 4, 1);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (15, 6, 2, "27 Hz - 40000 Hz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (16, 7, 3, 5);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (17, 7, 4, 1);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (18, 7, 2, "45 Hz - 25000 Hz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (19, 8, 7, "24 bit / 192 Khz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (20, 8, 5, 4);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (21, 8, 6, 2);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (22, 9, 7, "24 bit / 192 Khz");
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (23, 10, 8, 64);
INSERT INTO Atributo_Producto (id, producto_id, atributo_id, valor) VALUES (24, 10, 9, "USB-MIDI");
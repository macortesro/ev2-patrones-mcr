-- MODULO CLIENTES
INSERT INTO cli_clientes(email, nombre, comuna, direccion, contrasena) VALUES
	('jperez@123.cl', 'José Pérez', 'Pudahuel', 'J.J. Pèrez 666', '$2a$10$ghyZgV7ZUV2s0YgDHd0w2euxUCm0xsCqHi76h0KQWk1YON6bkyh6G')
	,('asoto@123.cl', 'Andrea Soto', 'Quinta Normal', 'Matucana 999', '$2a$10$pdgiaHuDFKi9rHMpa4RMH.6UL5x2FAO0uc6NVIyDYpe/IhghklFC2')
;
-- jperez:1234
-- asoto:4321

-- MODULO CATALOGO
INSERT INTO cat_categorias(nombre, padre_id) VALUES	
	('Lámparas', NULL)
	,('Sillas', NULL)
	,('Clásicas', 2)
	,('Modernas', 2)
	,('Rústicas', 2)
	,('Salón', 1)
	,('Comedor', 1)
	,('Dormitorio', 1)
	,('Exterior', 1)
;

INSERT INTO cat_clasificacion(sku, categoria_id) VALUES 
	('lamp-001', 7)
	,('lamp-002', 7)
	,('lamp-003', 7)
	,('lamp-004', 8)
	,('sill-001', 4)
	,('sill-002', 3)
	
;

-- MODULO BODEGAJE
INSERT INTO bod_productos(sku, nombre, costo, imagen) VALUES
    ('lamp-001', 'Lámpara LumiGlow', 20000, 'pendant-lamp-light.jpg')
    ,('lamp-002', 'Lámpara NordicBeam', 50000, 'carrie-table-lamp2.jpg')
    ,('lamp-003', 'Lámpara Nomad Light', 45000, 'carrie-table-lamp.jpg')
    ,('lamp-004', 'Lámpara HaloTouch', 15000, 'table-lamp-14x29cm.jpg')
    ,('sill-001', 'Silla Lounge', 25000, 'wegner-lounge-chair.jpg')
    ,('sill-002', 'Silla Clásica Moderna', 20000, 'modern-classic-chairs.jpg')
;

INSERT INTO bod_bodegas(nombre, direccion) VALUES
    ('B1', 'Lo Boza 123, Pudahuel')
    ,('B2', 'Camino Renca Lampa 9000, Pudahuel')
    ,('B3', 'La Estancilla 5000, San Bernardo')
;

INSERT INTO bod_stock(producto_id, bodega_id, cantidad) VALUES 
    (1, 1, 10)
    ,(1, 2, 5)
    ,(1, 3, 3)
    ,(2, 1, 20)
    ,(2, 2, 10)
    ,(2, 3, 30)
    ,(3, 1, 2)
    ,(3, 2, 4)
    ,(3, 3, 3)
    ,(4, 1, 0)
    ,(4, 2, 1)
    ,(4, 3, 1)
    ,(5, 1, 3)
    ,(6, 2, 1)    
;
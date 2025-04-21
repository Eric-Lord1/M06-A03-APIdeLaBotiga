-- Inserts per a Categoria
INSERT INTO categoria (id_categoria, name, status_categoria, creation_at, updated_at)
VALUES 
(1, 'Begudes', 'Activa', NOW(), NOW()),
(2, 'Merchandising', 'Activa', NOW(), NOW()),
(3, 'Tecnologia', 'Activa', NOW(), NOW());

-- Inserts per a Subcategoria
INSERT INTO subcategoria (id_subcategoria, name, status_categoria, categoria_id, creation_at, updated_at)
VALUES 
(1, 'Refrescos', 'Activa', 1, NOW(), NOW()),
(2, 'Figures Acció', 'Activa', 2, NOW(), NOW()),
(3, 'Sabres Làser', 'Activa', 3, NOW(), NOW());

-- Inserts per a Productes
INSERT INTO products (product_id, name, description, company, price, units, subcategoria_id, creation_at, updated_at)
VALUES 
(1, 'Coca-Cola Galàctica', 'Refresc energètic de l’espai', 'Coca-Cola Empire', 1.50, 100, 1, NOW(), NOW()),
(2, 'Darth Vader Figura', 'Figura col·leccionista amb capa real', 'Lucasfilm Merch', 24.99, 50, 2, NOW(), NOW()),
(3, 'Sable Làser Vermell', 'Autèntic sable làser Sith', 'KyberWorks', 129.99, 15, 3, NOW(), NOW()),
(4, 'R2-D2 Miniatura', 'Figura amb sons i llums', 'Lucasfilm Merch', 19.99, 25, 2, NOW(), NOW()),
(5, 'Blue Milk', 'Llet blava de Tatooine', 'Lars Family Dairy', 2.95, 75, 1, NOW(), NOW());

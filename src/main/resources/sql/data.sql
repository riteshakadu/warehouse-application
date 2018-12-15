USE warehouse;

INSERT INTO product (name, photo, price, unit, description, added_date) VALUES 
('iPhone 5S', 'https://images-na.ssl-images-amazon.com/images/I/51ucIXFr%2BHL.jpg', '640', 'BYN', 'iPhone 5s, Apple inc.', now()),
('Threadmill Let\'s go!\'', 'https://images-na.ssl-images-amazon.com/images/I/71my9G5W72L._SL1500_.jpg', '600', 'USD',
'Multifunctional threadmill. Has pretty much compact size, hence may be placed either at home or gym', now()),
('Apple Watch Series 3', 'https://content2.onliner.by/catalog/device/header@2/bb3f593d916a78d9f9b3e8df542f1ec2.jpeg', '400', 'USD',
 'Apple Watch Series 3 from Apple inc. - multifunctional electronical watches', now()),
('Gosha', 'http://moroz.by/upload/iblock/579/5793291423177ecf2ba0779de7b60655.jpg', '1.56', 'BYN', 'Gosha ice cream', now()),
('iPhone 6S', 'https://www.euronics.ee/UserFiles/Products/Images/185289-iphone-6s-gray-0.png', '960', 'BYN', 'iPhone 6s, Apple inc.', now());

INSERT INTO company (name, registration_date, photo, country, city, street, house, added_date) VALUES 
("Apple Inc.", now(), "/assets/img/apple-logo.png", "US", "Washington", "Independence squere", "22", now()),
("Moroz Product.", now(), "/assets/img/moroz-logo.png", "Russia", "Moscow", "Lenina street", "15", now());

INSERT INTO warehouse (name, country, city, street, house, added_date) VALUES
('Warehouse #1', 'Belarus', 'Minsk', 'Karbisheva', '10', now()),
('Warehouse #2', 'Belarus', 'Gomel', 'Y. Kolosa', '11', now()),
('Warehouse #3', 'Belarus', 'Vitebsk', 'I. Kupali', '12', now()),
('Warehouse #4', 'Belarus', 'Grodno', 'M. Tanka', '13', now()),
('Warehouse #5', 'Russia', 'Moscow', 'Lenina square', '14', now()),
('Warehouse #6', 'USA', 'Washington', 'Brandon street', '1', now());

SET @warehouse1Id = (SELECT id FROM warehouse WHERE name = 'Warehouse #1');
SET @warehouse2Id = (SELECT id FROM warehouse WHERE name = 'Warehouse #2');
SET @warehouse3Id = (SELECT id FROM warehouse WHERE name = 'Warehouse #3');
SET @warehouse4Id = (SELECT id FROM warehouse WHERE name = 'Warehouse #4');
SET @warehouse5Id = (SELECT id FROM warehouse WHERE name = 'Warehouse #5');
SET @warehouse6Id = (SELECT id FROM warehouse WHERE name = 'Warehouse #6');

SET @company1Id = (SELECT id FROM company WHERE name = "Apple Inc.");
SET @company2Id = (SELECT id FROM company WHERE name = "Moroz Product.");

UPDATE warehouse SET company_id = @company1Id WHERE id = @warehouse1Id;
UPDATE warehouse SET company_id = @company1Id WHERE id = @warehouse2Id;
UPDATE warehouse SET company_id = @company1Id WHERE id = @warehouse3Id;
UPDATE warehouse SET company_id = @company1Id WHERE id = @warehouse4Id;
UPDATE warehouse SET company_id = @company1Id WHERE id = @warehouse5Id;
UPDATE warehouse SET company_id = @company2Id WHERE id = @warehouse6Id;

SET @product1Id = (SELECT id FROM product WHERE name = 'iPhone 5S');
SET @product2Id = (SELECT id FROM product WHERE name = 'Threadmill Let\'s go!\'');
SET @product3Id = (SELECT id FROM product WHERE name = 'Apple Watch Series 3');
SET @product4Id = (SELECT id FROM product WHERE name = 'Gosha');
SET @product5Id = (SELECT id FROM product WHERE name = 'iPhone 6S');

UPDATE product SET warehouse_id = @warehouse6Id WHERE id = @product1Id;
UPDATE product SET warehouse_id = @warehouse5Id WHERE id = @product2Id;
UPDATE product SET warehouse_id = @warehouse6Id WHERE id = @product3Id;
UPDATE product SET warehouse_id = @warehouse1Id WHERE id = @product4Id;
UPDATE product SET warehouse_id = @warehouse6Id WHERE id = @product5Id;

INSERT INTO employee (name, phone, photo, added_date) VALUES 
("Bogdan Shishkin", "+375 29 118 10 71", "https://pp.userapi.com/c840024/v840024579/83179/Y6XRwRciHzs.jpg?ava=1", now()),
("Mankevich Denis", "+375 29 523 10 85", "https://pp.userapi.com/c639720/v639720694/2b65f/LLSnZFOaAvc.jpg?ava=1", now()),
("Bezmenov Stas", "+375 29 168 06 20", "https://pp.userapi.com/c850016/v850016339/5f841/AzhteQcYf1Q.jpg?ava=1", now()),
("Andrew Smith", "+375 25 972 88 42", "https://pp.userapi.com/c845124/v845124498/10a877/iGwbdssCwnM.jpg?ava=1", now()),
("John McCartney", "+375 29 108 44 20", "https://pp.userapi.com/c626322/v626322788/c838/VoevJnhqfz4.jpg?ava=1", now());

UPDATE employee SET company_id = @company1Id WHERE name = "Bogdan Shishkin";
UPDATE employee SET company_id = @company2Id WHERE name = "Mankevich Denis";
UPDATE employee SET company_id = @company1Id WHERE name = "Bezmenov Stas";
UPDATE employee SET company_id = @company2Id WHERE name = "Andrew Smith";
UPDATE employee SET company_id = @company1Id WHERE name = "John McCartney";

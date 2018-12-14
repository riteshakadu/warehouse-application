INSERT INTO product (name, photo, price, unit, description, added_date) VALUES 
('iPhone 5S', 'https://images-na.ssl-images-amazon.com/images/I/51ucIXFr%2BHL.jpg', '640', 'BYN', 'iPhone 5s, Apple inc.', now()),
('Threadmill Let\'s go!\'', 'https://images-na.ssl-images-amazon.com/images/I/71my9G5W72L._SL1500_.jpg', '600', 'USD',
'Multifunctional threadmill. Has pretty much compact size, hence may be placed either at home or gym', now()),
('Apple Watch Series 3', 'https://content2.onliner.by/catalog/device/header@2/bb3f593d916a78d9f9b3e8df542f1ec2.jpeg', '400', 'USD',
 'Apple Watch Series 3 from Apple inc. - multifunctional electronical watches', now()),
('Gosha', 'http://moroz.by/upload/iblock/579/5793291423177ecf2ba0779de7b60655.jpg', '1.56', 'BYN', 'Gosha ice cream', now()),
('iPhone 6S', 'https://www.euronics.ee/UserFiles/Products/Images/185289-iphone-6s-gray-0.png', '960', 'BYN', 'iPhone 6s, Apple inc.', now());

INSERT INTO warehouse (name, country, city, street, house, added_date) VALUES
('Warehouse #1', 'Belarus', 'Minsk', 'Karbisheva', '10', now()),
('Warehouse #2', 'Belarus', 'Gomel', 'Y. Kolosa', '11', now()),
('Warehouse #3', 'Belarus', 'Vitebsk', 'I. Kupali', '12', now()),
('Warehouse #4', 'Belarus', 'Grodno', 'M. Tanka', '13', now()),
('Warehouse #5', 'Russia', 'Moscow', 'Lenina square', '14', now()),
('Warehouse #6', 'USA', 'Washington', 'Brandon street', '1', now());
INSERT INTO UserRole(id, name)
VALUES (1, 'ADMIN');
INSERT INTO UserRole(id, name)
VALUES (2, 'USER');


INSERT INTO Category(name)
VALUES ('cpu');
INSERT INTO Category(name)
VALUES ('gpu');
INSERT INTO Category(name)
VALUES ('hard_disc');
INSERT INTO Category(name)
VALUES ('mother_board');
INSERT INTO Category(name)
VALUES ('ram');


INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (1, 'Intel', 'Core i5-11400F', 700);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (1, 'AMD', 'Ryzen 5 5600X', 1000);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (1, 'Intel', 'Core i5-12400F', 900);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (1, 'AMD', 'Ryzen 5 5500', 700);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (1, 'Intel', 'Core i5-10400F', 600);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (1, 'AMD', 'Ryzen 5 5600G', 800);

INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (2, 'Gigabyte', 'GeForce GTX 1660', 1500);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (2, 'Gigabyte ', 'GeForce RTX 3060', 2000);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (2, 'MSI', 'GeForce RTX 3060', 2500);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (2, 'ASUS', 'GeForce RTX 3060', 2300);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (2, 'Zotac', 'GeForce RTX 3060', 2200);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (2, 'MSI', 'GeForce RTX 3080', 7000);

INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (3, 'WD', 'Blue SN570', 400);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (3, 'WD ', 'Blue SN570', 230);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (3, 'ADATA', 'Ultimate SU650', 130);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (3, 'ADATA', 'GAMMIX S70 Blade', 620);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (3, 'Samsung ', 'NVMe 980', 500);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (3, 'Samsung ', '870 EVO', 300);

INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (4, 'ASUS', 'TUF GAMING B550-PLUS', 650);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (4, 'ASUS', 'TUF GAMING Z690-PLUS', 1300);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (4, 'MSI', 'B560-A PRO', 540);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (4, 'MSI', 'MAG Z690 TOMAHAWK', 1300);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (4, 'Gigabyte', 'B660M DS3H', 500);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (4, 'Gigabyte', 'B560M DS3H V2', 400);

INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (5, 'Kingston', 'Beast Black', 300);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (5, 'Kingston', 'Beast RGB', 400);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (5, 'G.SKILL', 'Aegis', 300);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (5, 'G.SKILL', 'Ripjaws V Black', 300);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (5, 'Corsair', 'Vengeance LPX Black', 600);
INSERT INTO PRODUCT (category_id, manufacturer, name, price)
VALUES (5, 'Corsair', 'Vengeance RGB PRO SL', 400);


INSERT INTO Customers(email, password, userName)
VALUES ('adam', '$2a$12$ADLYIl8fWouStHP7rXE1oOPz7a6H5RTHDunLar4qnfyS0Dcs/mETG', 'adam');
INSERT INTO Customers(email, password, userName)
VALUES ('basia', '$2a$12$ADLYIl8fWouStHP7rXE1oOPz7a6H5RTHDunLar4qnfyS0Dcs/mETG', 'basia');
INSERT INTO Customers(email, password, userName)
VALUES ('kasia', '$2a$12$ADLYIl8fWouStHP7rXE1oOPz7a6H5RTHDunLar4qnfyS0Dcs/mETG', 'kasia');
INSERT INTO Customers(email, password, userName)
VALUES ('radek', '$2a$12$ADLYIl8fWouStHP7rXE1oOPz7a6H5RTHDunLar4qnfyS0Dcs/mETG', 'radek');


INSERT INTO users_roles(customers_id, userrole_id)
VALUES (1, 1);
INSERT INTO users_roles(customers_id, userrole_id)
VALUES (2, 2);
INSERT INTO users_roles(customers_id, userrole_id)
VALUES (3, 2);
INSERT INTO users_roles(customers_id, userrole_id)
VALUES (4, 2);

INSERT INTO Orders(status, customer_id)
VALUES ('ok', 1);
INSERT INTO Orders(status, customer_id)
VALUES ('ok', 2);


INSERT INTO OrderItem(quantity, product_id, orders_id)
VALUES (1, 1, 2);
INSERT INTO OrderItem(quantity, product_id, orders_id)
VALUES (1, 3, 2);
INSERT INTO OrderItem(quantity, product_id, orders_id)
VALUES (1, 4, 2);
INSERT INTO OrderItem(quantity, product_id, orders_id)
VALUES (1, 2, 1);

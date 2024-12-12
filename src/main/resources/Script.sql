

-- Use the database
USE ORDER_APP_JAVA;


-- ////////////////////////////////////////////////////////////////////////////////////////////////////

-- role
INSERT INTO role (name, description) VALUES
                                         ('Chef', 'Responsible for cooking'),
                                         ('Manager', 'Manages the restaurant operations'),
                                         ('Waiter', 'Serves customers'),
                                         ('Cashier', 'Handles payments'),
                                         ('Host', 'Welcomes guests'),
                                         ('Maintenance', 'Maintains facilities'),
                                         ('Security', 'Ensures safety'),
                                         ('Cleaner', 'Cleans the restaurant'),
                                         ('Supplier', 'Provides supplies'),
                                         ('Accountant', 'Manages finances'),
                                         ('Marketing', 'Handles promotions'),
                                         ('HR', 'Manages human resources'),
                                         ('IT Support', 'Handles technical issues');

-- user
INSERT INTO user (user_name, full_name, email, password, birthday, status) VALUES
                                                                               ('john_doe_1', 'John Doe', 'john.doe1@example.com', 'hashed_password_john1', '1995-03-15', TRUE),
                                                                               ('jane_doe_2', 'Jane Doe', 'jane.doe2@example.com', 'hashed_password_jane2', '1998-07-20', TRUE),
                                                                               ('peter_pan_3', 'Peter Pan', 'peter.pan3@example.com', 'hashed_password_peter3', '1980-10-28', TRUE),
                                                                               ('mary_jane_4', 'Mary Jane', 'mary.jane4@example.com', 'hashed_password_mary4', '1992-05-12', FALSE),
                                                                               ('david_lee_5', 'David Lee', 'david.lee5@example.com', 'hashed_password_david5', '1999-01-03', TRUE),
                                                                               ('emily_brown_6', 'Emily Brown', 'emily.brown6@example.com', 'hashed_password_emily6', '2000-09-25', TRUE),
                                                                               ('michael_kim_7', 'Michael Kim', 'michael.kim7@example.com', 'hashed_password_michael7', '1997-04-10', FALSE),
                                                                               ('sarah_chen_8', 'Sarah Chen', 'sarah.chen8@example.com', 'hashed_password_sarah8', '1996-11-05', TRUE),
                                                                               ('david_wang_9', 'David Wang', 'david.wang9@example.com', 'hashed_password_david9', '2002-08-18', TRUE),
                                                                               ('jessica_park_10', 'Jessica Park', 'jessica.park10@example.com', 'hashed_password_jessica10', '2001-03-01', FALSE),
                                                                               ('andrew_chen_11', 'Andrew Chen', 'andrew.chen11@example.com', 'hashed_password_andrew11', '1994-06-22', TRUE),
                                                                               ('olivia_kim_12', 'Olivia Kim', 'olivia.kim12@example.com', 'hashed_password_olivia12', '2005-12-15', TRUE),
                                                                               ('william_lee_13', 'William Lee', 'william.lee13@example.com', 'hashed_password_william13', '1993-02-08', FALSE),
                                                                               ('grace_wang_14', 'Grace Wang', 'grace.wang14@example.com', 'hashed_password_grace14', '2003-07-29', TRUE),
                                                                               ('daniel_park_15', 'Daniel Park', 'daniel.park15@example.com', 'hashed_password_daniel15', '1990-05-10', FALSE);

-- user<->role
INSERT INTO user_role (user_id, role_id) VALUES
                                             (3, 3),  -- Charlie Brown as Chef
                                             (4, 4),  -- David Green as Manager
                                             (5, 5),  -- Eve White as Waiter
                                             (6, 6),  -- Frank Black as Cashier
                                             (7, 7),  -- Grace Blue as Host
                                             (8, 8),  -- Hannah Pink as Maintenance
                                             (9, 9),  -- Ian Orange as Security
                                             (10, 10), -- Jack Red as Cleaner
                                             (11, 11), -- Kelly Yellow as Supplier
                                             (12, 12), -- Liam Cyan as Accountant
                                             (13, 13), -- Mia Magenta as Marketing
                                             (1, 2),  -- Alice Johnson as Customer
                                             (2, 2),  -- Bob Smith as Customer
                                             (3, 2),  -- Charlie Brown as Customer
                                             (4, 2);  -- David Green as Customer

-- ////////////////////////////////////////////////////////////////////////////////////////////////////
-- restaurant
INSERT INTO Branch (restaurant_id,name, address, phone) VALUES
                                                            (1,'Taco House', '789 Tacos Rd', '555-6789'),
                                                            (1,'Sushi Spot', '321 Sushi Ln', '555-4321'),
                                                            (1,'BBQ Barn', '654 BBQ Ave', '555-8765'),
                                                            (1,'Pasta Place', '987 Pasta Blvd', '555-9876'),
                                                            (1,'Salad Station', '159 Salad St', '555-1597'),
                                                            (1,'Seafood Shack', '753 Ocean Dr', '555-7530'),
                                                            (1,'Steakhouse', '852 Steak St', '555-8521'),
                                                            (1,'Dessert Den', '963 Sweet St', '555-9632'),
                                                            (1,'Vegan Villa', '741 Green Way', '555-7413'),
                                                            (1,'Grill & Chill', '369 Grill Rd', '555-3694'),
                                                            (1,'Breakfast Bar', '258 Morning Ave', '555-2585'),
                                                            (1,'Noodle Nook', '147 Noodle Ln', '555-1476'),
                                                            (1,'Curry Corner', '951 Spice Rd', '555-9517');


-- ////////////////////////////////////////////////////////////////////////////////////////////////////

-- area
INSERT INTO area (name, active) VALUES
                                    ('Area A', 0),
                                    ('Area B', 1),
                                    ('Area C', 1),
                                    ('Area D', 0),
                                    ('Balcony',0),
                                    ('RoofTop',0);


INSERT INTO `table` (name, status,active, area_id) VALUES
                                                       ('Table 3', 1, 1, 1),
                                                       ('Table 4', 0, 1, 1),
                                                       ('Table 5', 0, 1, 1),
                                                       ('Table 6', 1, 1, 1),
                                                       ('Table 7', 1, 1, 1),
                                                       ('Table 8', 2, 1, 2),
                                                       ('Table 9', 3, 1, 2),
                                                       ('Table 10', 1, 1, 2),
                                                       ('Table 11', 1, 1, 3),
                                                       ('Table 12', 2, 1, 3),
                                                       ('Table 13', 1, 1, 3),
                                                       ('Table 14', 1, 1, 3);

-- ////////////////////////////////////////////////////////////////////////////////////////////////////


-- Insert Categories
INSERT INTO category (name,active,type) VALUES
                                            ('Italian',1,1),
                                            ('Indian',1,1),
                                            ('American',1,1),
                                            ('Japanese',1,2),
                                            ('Mexican',1,3),
                                            ('Thai',1,3),
                                            ('French',1,1),
                                            ('Greek',1,1),
                                            ('Chinese',1,2),
                                            ('Mediterranean',1,3),
                                            ('Steakhouse',1,1),
                                            ('Seafood',1,2),
                                            ('Pizza',1,3),
                                            ('Desserts',1,3),
                                            ('Beverages',1,1);

-- Insert Units
INSERT INTO unit (name) VALUES
                            ('Each'),
                            ('Kg'),
                            ('g'),
                            ('L'),
                            ('ml'),
                            ('dozen'),
                            ('piece'),
                            ('pack'),
                            ('box'),
                            ('can'),
                            ('bottle'),
                            ('cup'),
                            ('tablespoon'),
                            ('teaspoon');

-- Insert data into the Printer table
INSERT INTO printer (name, printer_name, ip_address, port, connection_type, print_number, is_print_each_paper, is_active, type) VALUES
                                                                                                                                    ('Office Printer 1', 'HP LaserJet Pro M404', '192.168.1.100', 9100, 1, 1, 1, 1, 1),  -- Example: Network, Enabled, Laser
                                                                                                                                    ('Kitchen Printer', 'Epson TM-T20II', '192.168.1.101', 9100, 1, 1, 0, 1, 2),  -- Example: Network, Enabled, Receipt
                                                                                                                                    ('Shipping Label Printer', 'Zebra ZD420', '192.168.1.102', 9100, 1, 1, 1, 1, 3), -- Example: Network, Enabled, Label
                                                                                                                                    ('Front Desk Printer', 'Brother HL-L2395DW', '192.168.1.103', 9100, 1, 2, 1, 0, 1),  -- Example: Network, Disabled, Laser
                                                                                                                                    ('USB Printer', 'Canon Pixma TS6420', '192.168.1.103', 9100, 2, 1, 1, 1, 4);  -- Example: USB, Enabled, Inkjet



-- Additional Items
INSERT INTO item (category_id, name, price, out_of_stock, unit_id, printer_id, description) VALUES
                                                                                                (6, 'Pad Thai', 11.99, 0, 1, 1, 'Stir-fried rice noodles with eggs, tofu, and shrimp, topped with crushed peanuts.'),
                                                                                                (6, 'Green Curry', 12.99, 0, 1, 1, 'Rich and creamy green curry with chicken, bamboo shoots, and basil.'),
                                                                                                (7, 'Coq au Vin', 14.99, 0, 1, 1, 'Classic French dish featuring chicken braised in red wine with mushrooms and onions.'),
                                                                                                (7, 'Ratatouille', 10.99, 0, 1, 1, 'A vibrant dish of stewed vegetables including eggplant, zucchini, and bell peppers.'),
                                                                                                (8, 'Greek Souvlaki', 13.99, 0, 1, 1, 'Marinated and grilled chicken skewers served with pita bread, tzatziki, and vegetables.'),
                                                                                                (8, 'Moussaka', 12.99, 0, 1, 1, 'Layered eggplant and ground beef casserole with a creamy béchamel topping.'),
                                                                                                (9, 'Kung Pao Chicken', 11.99, 0, 1, 1, 'Spicy stir-fried chicken with peanuts, vegetables, and chili peppers.'),
                                                                                                (9, 'Mapo Tofu', 10.99, 0, 1, 1, 'Soft tofu in a spicy and savory sauce with ground pork.'),
                                                                                                (10, 'Falafel Wrap', 9.99, 0, 1, 1, 'Crispy falafel balls wrapped in pita with lettuce, tomatoes, and tahini sauce.'),
                                                                                                (10, 'Hummus Plate', 8.99, 0, 1, 1, 'Creamy hummus served with warm pita bread and olive oil.'),
                                                                                                (11, 'Ribeye Steak', 18.99, 0, 1, 1, 'Juicy ribeye steak grilled to perfection, served with garlic butter.'),
                                                                                                (11, 'Filet Mignon', 20.99, 0, 1, 1, 'Tender filet mignon steak with a red wine reduction.'),
                                                                                                (12, 'Grilled Salmon', 15.99, 0, 1, 1, 'Fresh salmon fillet grilled with lemon and dill sauce.'),
                                                                                                (12, 'Shrimp Scampi', 14.99, 0, 1, 1, 'Sautéed shrimp in a garlic, butter, and white wine sauce.'),
                                                                                                (13, 'BBQ Chicken Pizza', 13.99, 0, 2, 1, 'Pizza topped with BBQ sauce, grilled chicken, onions, and mozzarella.'),
                                                                                                (13, 'Hawaiian Pizza', 12.99, 0, 2, 1, 'Pizza with ham, pineapple, and mozzarella cheese.'),
                                                                                                (14, 'Apple Pie', 6.99, 0, 1, 1, 'Classic apple pie with a flaky crust and cinnamon-spiced apples.'),
                                                                                                (14, 'Ice Cream Sundae', 5.99, 0, 1, 1, 'Vanilla ice cream topped with hot fudge, whipped cream, and a cherry.'),
                                                                                                (15, 'Espresso', 2.99, 0, 4, 1, 'Rich and bold espresso shot, perfect for a quick caffeine boost.'),
                                                                                                (15, 'Cappuccino', 3.99, 0, 4, 1, 'Smooth and creamy cappuccino with a perfect balance of espresso and steamed milk.'),
                                                                                                (1, 'Spaghetti and Meatballs', 13.99, 0, 1, 1, 'Classic spaghetti with homemade meatballs in marinara sauce.'),
                                                                                                (1, 'Chicken Parmesan', 14.99, 0, 1, 1, 'Breaded chicken breast topped with marinara sauce and mozzarella cheese.'),
                                                                                                (1, 'Fettuccine Alfredo', 12.99, 0, 1, 1, 'Fettuccine pasta tossed in a creamy Alfredo sauce.'),
                                                                                                (1, 'Ravioli', 13.99, 0, 1, 1, 'Cheese-filled ravioli with your choice of sauce.'),
                                                                                                (1, 'Minestrone Soup', 6.99, 0, 1, 1, 'Hearty Italian vegetable soup.'),
                                                                                                (1, 'Garlic Bread', 4.99, 0, 1, 1, 'Toasted bread with garlic butter and herbs.'),
                                                                                                (1, 'Arancini', 7.99, 0, 1, 1, 'Fried rice balls filled with cheese and meat.'),
                                                                                                (2, 'Chicken Tikka Masala', 14.99, 0, 1, 2, 'Tender chicken in a creamy tomato sauce.'),
                                                                                                (2, 'Butter Chicken', 15.99, 0, 1, 2, 'Mild and creamy chicken curry.'),
                                                                                                (2, 'Saag Paneer', 13.99, 0, 1, 2, 'Spinach and cheese curry.'),
                                                                                                (2, 'Chana Masala', 12.99, 0, 1, 2, 'Chickpea curry.'),
                                                                                                (2, 'Dal Makhani', 11.99, 0, 1, 2, 'Creamy lentil dish.'),
                                                                                                (2, 'Naan Bread', 2.99, 0, 1, 2, 'Soft and fluffy Indian bread.'),
                                                                                                (2, 'Samosas', 5.99, 0, 1, 2, 'Fried pastries filled with potatoes and peas.'),
                                                                                                (3, 'Fried Chicken', 10.99, 0, 1, 2, 'Crispy fried chicken.'),
                                                                                                (3, 'Mac and Cheese', 8.99, 0, 1, 1, 'Creamy macaroni and cheese.'),
                                                                                                (3, 'French Fries', 4.99, 0, 1, 2, 'Classic French fries.'),
                                                                                                (3, 'Onion Rings', 5.99, 0, 1, 2, 'Crispy onion rings.'),
                                                                                                (3, 'Chicken Wings', 9.99, 0, 1, 2, 'Chicken wings with your choice of sauce.'),
                                                                                                (3, 'Cornbread', 3.99, 0, 1, 1, 'Sweet and savory cornbread.'),
                                                                                                (3, 'Coleslaw', 3.99, 0, 1, 1, 'Classic coleslaw.'),
                                                                                                (4, 'Ramen', 12.99, 0, 1, 2, 'Japanese noodle soup dish.'),
                                                                                                (4, 'Sushi Rolls (various)', 14.99, 0, 1, 2, 'Variety of sushi rolls.'),
                                                                                                (4, 'Tempura', 11.99, 0, 1, 2, 'Deep-fried seafood and vegetables.'),
                                                                                                (4, 'Teriyaki Chicken', 13.99, 0, 1, 2, 'Grilled chicken with teriyaki sauce.'),
                                                                                                (4, 'Miso Soup', 3.99, 0, 1, 2, 'Traditional Japanese soup.'),
                                                                                                (4, 'Edamame', 4.99, 0, 1, 2, 'Steamed and salted soybeans.'),
                                                                                                (4, 'Gyoza', 6.99, 0, 1, 2, 'Pan-fried dumplings.'),
                                                                                                (5, 'Enchiladas', 11.99, 0, 1, 2, 'Tortillas filled with meat and cheese, topped with sauce.'),
                                                                                                (5, 'Quesadillas', 9.99, 0, 1, 2, 'Grilled tortillas filled with cheese and your choice of fillings.'),
                                                                                                (5, 'Nachos', 8.99, 0, 1, 2, 'Tortilla chips topped with cheese, beans, and other toppings.'),
                                                                                                (5, 'Guacamole and Chips', 6.99, 0, 1, 2, 'Homemade guacamole served with tortilla chips.'),
                                                                                                (5, 'Churros', 5.99, 0, 1, 2, 'Fried dough pastries with cinnamon sugar.');






-- Ensure to adjust the IDs if they conflict with existing entries



-- Insert data into Chilren_Item table
INSERT INTO children_item (id, category_id, name, price, out_of_stock, unit_id)
VALUES
    (1, 1, 'French Fries', 2.99, 0, 1),
    (2, 1, 'Onion Rings', 3.99, 0, 1),
    (3, 2, 'Garlic Bread', 4.99, 0, 1),
    (4, 2, 'Breadsticks', 5.99, 0, 1),
    (5, 3, 'Croutons', 1.99, 0, 1),
    (6, 3, 'Extra Cheese', 2.99, 0, 1),
    (7, 4, 'Whipped Cream', 1.99, 0, 1),
    (8, 4, 'Extra Chocolate Sauce', 2.99, 0, 1),
    (9, 5, 'Extra Sugar', 0.99, 0, 1),
    (10, 5, 'Extra Cream', 1.99, 0, 1),
    (11, 1, 'Bacon', 2.99, 0, 1),
    (12, 1, 'Mushroom', 2.99, 0, 1),
    (13, 2, 'Pepperoni', 3.99, 0, 1),
    (14, 2, 'Sausage', 3.99, 0, 1),
    (15, 3, 'Grilled Chicken', 4.99, 0, 1),
    (16, 3, 'Salmon', 5.99, 0, 1),
    (17, 4, 'Strawberry Sauce', 2.99, 0, 1),
    (18, 4, 'Caramel Sauce', 2.99, 0, 1),
    (19, 5, 'Extra Ice', 0.99, 0, 1),
    (20, 5, 'Extra Lemon', 0.99, 0, 1);

-- Insert data into Parent_Item_Chilren_Item table
INSERT INTO item_on_children_item (item_id, children_item_id,quantity)
VALUES
    (1, 1,2),
    (1, 2,1),
    (2, 11,3),
    (2, 12,4),
    (3, 3,5),
    (3, 4,6),
    (4, 13,2),
    (4, 14,1),
    (5, 5,2),
    (5, 6,3),
    (6, 15,5),
    (6, 16,2),
    (7, 7,1),
    (7, 8,5),
    (8, 17,5),
    (8, 18,6),
    (9, 9,2),
    (9, 10,4),
    (10, 19,1),
    (10, 20,2),
    (11, 1,5),
    (11, 2,7),
    (12, 11,3),
    (12, 12,1),
    (13, 3,9),
    (13, 4,2),
    (14, 13,1),
    (14, 14,3),
    (15, 5,5),
    (15, 6,6),
    (16, 15,3),
    (16, 16,3),
    (17, 7,2),
    (17, 8,1),
    (18, 17,1),
    (18, 18,1),
    (19, 9,5),
    (19, 10,7),
    (20, 19,7),
    (20, 20,3);

-- ////////////////////////////////////////////////////////////////////////////////////////////////////




-- payment
INSERT INTO payment (discount, tax, surcharge, amount, net_amount, method, status) VALUES
                                                                                       (0.00, 5.00, 2.50, 100.00, 107.50, 1, 3),  -- Credit Card, Paid
                                                                                       (10.00, 2.00, 1.00, 50.00, 43.00, 2, 3),   -- Debit Card, Paid
                                                                                       (5.00, 7.00, 0.00, 75.00, 77.00, 3, 3),   -- PayPal, Paid
                                                                                       (0.00, 6.50, 3.00, 120.00, 129.50, 4, 1), -- Cash, Pending
                                                                                       (2.50, 3.50, 1.50, 60.00, 62.50, 1, 2),  -- Credit Card, Processing
                                                                                       (7.50, 1.00, 0.50, 40.00, 34.00, 2, 4),   -- Debit Card, Failed
                                                                                       (3.00, 8.00, 2.00, 90.00, 97.00, 3, 3),   -- PayPal, Paid
                                                                                       (0.00, 4.00, 1.00, 80.00, 85.00, 4, 1), -- Cash, Pending
                                                                                       (1.00, 5.50, 0.00, 70.00, 74.50, 1, 2),  -- Credit Card, Processing
                                                                                       (5.00, 2.50, 0.75, 35.00, 33.25, 2, 3),   -- Debit Card, Paid
                                                                                       (2.00, 6.00, 1.00, 110.00, 115.00, 3, 3),-- Paypal, Paid
                                                                                       (0.50, 3.00, 0.50, 95.00, 98.00, 4, 1),-- Cash, pending
                                                                                       (6.00, 2.00, 0.25, 45.00, 41.25, 2, 4), -- Debit card, Failed
                                                                                       (1.50, 4.50, 1.75, 65.00, 69.75,1, 3),-- credit card, paid
                                                                                       (0.75, 5.25, 2.25, 78.00, 84.50,3, 2),-- paypal, processing
                                                                                       (3.50, 3.75, 0.00, 88.00, 88.25, 4,3), -- cash, paid
                                                                                       (4.20, 1.50, 2.70, 55.00, 55.00,1,2),-- Credit card, processing
                                                                                       (1.20, 6.50, 0.50, 125.00, 130.80,2,1),-- Debit card, pending
                                                                                       (2.50,3.00,1.25,77.00,78.75,3, 4), -- Paypal, failed
                                                                                       (1.00, 4.75, 0.75, 90.00, 94.50,4,3), -- Cash, paid
                                                                                       (5.00, 3.30, 1.70, 110.00, 109.70, 1, 3), -- Credit card, paid
                                                                                       (2.00, 1.00, 0.50, 50.00, 48.50, 2, 2),-- Debit card, processing
                                                                                       (3.00, 2.50, 1.50, 60.00, 61.00, 3, 3), -- Paypal, Paid
                                                                                       (0.00, 1.50, 2.00, 70.00, 73.50, 4, 1);

-- ////////////////////////////////////////////////////////////////////////////////////////////////////

-- order
INSERT INTO `order` (user_id, payment_id, status) VALUES
                                                      (1, 1, 1),  -- User 1, Payment 1, Pending
                                                      (2, 2, 2),  -- User 2, Payment 2, Processing
                                                      (3, 3, 3),  -- User 3, Payment 3, Shipped
                                                      (4, 4, 4),  -- User 4, Payment 4, Completed
                                                      (5, 5, 1),  -- User 5, Payment 5, Pending
                                                      (6, 6, 2),  -- User 6, Payment 6, Processing
                                                      (7, 7, 3),  -- User 7, Payment 7, Shipped
                                                      (8, 8, 4),  -- User 8, Payment 8, Completed
                                                      (9, 9, 1),  -- User 9, Payment 9, Pending
                                                      (10, 10, 2), -- User 10, Payment 10, Processing
                                                      (1, 11, 3), -- User 1, Payment 11, Shipped
                                                      (2, 12, 4), -- User 2, Payment 12, Completed
                                                      (3, 13, 1), -- User 3, Payment 13, Pending
                                                      (4, 14, 2), -- User 4, Payment 14, Processing
                                                      (5, 15, 3), -- User 5, Payment 15, Shipped
                                                      (6, 16, 4), -- User 6, Payment 16, Completed
                                                      (7, 17, 1), -- User 7, Payment 17, Pending
                                                      (8, 18, 2), -- User 8, Payment 18, Processing
                                                      (9, 19, 3), -- User 9, Payment 19, Shipped
                                                      (10, 20, 4),-- User 10, Payment 20, Completed
                                                      (3, 21, 2),  -- User 3, Payment 21, Processing (Added one more row)
                                                      (5, 22, 3), -- User 5, Payment 22, Shipped (Added one more row)
                                                      (1,23, 4), -- User 1, Payment 23, Completed (Added one more row)
                                                      (2, 24, 1); -- User 2, payment 24, pending



-- Inserting sample data into Restaurant_Order table
INSERT INTO order_table (order_id, table_id) VALUES
                                                 (1, 1),
                                                 (2, 2),
                                                 (3, 3),
                                                 (4, 4),
                                                 (5, 5),
                                                 (6, 6),
                                                 (7, 7),
                                                 (8, 8),
                                                 (9, 9),
                                                 (10, 9),
                                                 (11, 10),
                                                 (12, 11),
                                                 (13, 12),
                                                 (14, 1),
                                                 (15, 2),
                                                 (16, 3),
                                                 (17, 4),
                                                 (18, 5),
                                                 (19, 6),
                                                 (20, 7),
                                                 (21, 8),
                                                 (22, 9),
                                                 (23, 10),
                                                 (24, 11);






-- Inserting sample data into Restaurant_Order table
INSERT INTO Branch_Order (order_id, branch_id) VALUES
                                                   (1, 3),
                                                   (2, 4),
                                                   (3, 5),
                                                   (4, 6),
                                                   (5, 7),
                                                   (6, 8),
                                                   (7, 9),
                                                   (8, 10),
                                                   (9, 11),
                                                   (10, 12),
                                                   (11, 13),
                                                   (12, 1),
                                                   (13, 2),
                                                   (14, 3);


-- ////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO order_item (order_id, item_id,quantity) VALUES
                                                        (1, 1, 10),  -- Order 1: Margherita Pizza (12.99) and Pasta Carbonara (15.99) = 28.98 + other items = 45.00
                                                        (1, 2, 2),
                                                        (1, 5, 3),
                                                        (2, 3, 2),  -- Order 2: Butter Chicken (16.99) and Biryani (14.99) and other items = 60.00
                                                        (2, 4, 10),
                                                        (2, 10, 1),
                                                        (3, 6, 6),  -- Order 3: California Roll (11.99) and other items = 30.00 ( cancelled )
                                                        (3, 7, 7),
                                                        (4, 8, 9),  -- Order 4: Pad Thai (13.99) and other items = 22.50
                                                        (4, 9, 10),
                                                        (5, 11, 2),  -- Order 5: Ribeye Steak (29.99) ( pending )
                                                        (6, 12, 4),  -- Order 6: Grilled Salmon (22.99) and other items = 40.00
                                                        (6, 1, 3),
                                                        (7, 5, 2),  -- Order 7: Classic Burger (9.99) and other items = 25.00 ( cancelled )
                                                        (7, 10, 6),
                                                        (8, 2, 6),  -- Order 8: Pasta Carbonara (15.99) and other items = 35.00
                                                        (8, 6, 9),
                                                        (9, 4, 1),  -- Order 9: Biryani (14.99) and other items = 50.00 ( pending )
                                                        (9, 3, 8),
                                                        (9, 8, 1),
                                                        (10, 9, 2),  -- Order 10: Coq au Vin (24.99) and other items = 27.50
                                                        (10, 1, 4),
                                                        (11, 7, 6),  -- Order 11: Tacos (8.99) and other items = 33.00 ( pending )
                                                        (11, 5, 8),
                                                        (11, 6, 9),
                                                        (12, 10, 2),  -- Order 12: Hummus Plate (7.99) and other items = 44.00
                                                        (12, 2, 1),
                                                        (12, 8, 2),
                                                        (13, 11, 5),  -- Order 13: Ribeye Steak (29.99) and other items = 29.99 ( pending )
                                                        (14, 1, 5),  -- Order 14: Margherita Pizza (12.99) and other items = 15.50
                                                        (14, 5, 6);


-- ////////////////////////////////////////////////////////////////////////////////////////////////////


-- rating
INSERT INTO rating (user_id, branch_id, rating) VALUES
                                                    (3, 3, 4),
                                                    (4, 4, 5),
                                                    (5, 5, 3),
                                                    (6, 6, 4),
                                                    (7, 7, 2),
                                                    (8, 8, 5),
                                                    (9, 9, 3),
                                                    (10, 10, 4),
                                                    (11, 11, 5),
                                                    (12, 12, 3),
                                                    (13, 13, 4),
                                                    (1, 1, 5),
                                                    (2, 2, 4),
                                                    (3, 3, 3);








SELECT User.name, User.email
FROM User
         JOIN `Order` ON User.id = `Order`.user_id;


SELECT * FROM `Area`;

SELECT `Order`.id, `Order`.order_total, `Order`.status
FROM `Order`
         JOIN User ON `Order`.user_id = User.id
WHERE User.email = 'johndoe@example.com';

SELECT Drivers.email, Drivers.phone, Orders.rating
FROM Drivers
         JOIN Orders ON Drivers.id = Orders.driver_id
         JOIN Rating ON Orders.id = Rating.order_id;


SELECT Menu.name, Menu.price, Payment.status
FROM Menu
         JOIN Payment ON Menu.restaurant_id = Payment.restaurant_id
WHERE Menu.restaurant_id = 1;


SELECT Address.street, Address.city, Address.state, Address.pincode
FROM Address
         JOIN Orders ON Address.user_id = Orders.user_id
WHERE Orders.id = 1;

SELECT Restaurants.name, AVG(Rating.rating) as avg_rating, COUNT(Rating.rating) as rating_count
FROM Restaurants
         JOIN Rating ON Restaurants.id = Rating.restaurant_id
GROUP BY Restaurants.name;

SELECT Menu.name, COUNT(Orders.menu_id) as times_ordered
FROM Menu
         JOIN Orders ON Menu.id = Orders.menu_id
GROUP BY Menu.name
ORDER BY times_ordered DESC
LIMIT 10;


SELECT Users.first_name, Users.last_name, Users.email, SUM(Orders.total) as total_spent
FROM Users
         JOIN Orders ON Users.id = Orders.user_id
         JOIN Restaurants ON Orders.restaurant_id = Restaurants.id
WHERE Restaurants.name = 'Pizza Palace'
GROUP BY Users.email;


SELECT Drivers.name, Drivers.phone
FROM Drivers
         JOIN Orders ON Drivers.id = Orders.driver_id
GROUP BY Drivers.id
HAVING COUNT(Orders.id) > 20;


SELECT Drivers.name, Drivers.phone
FROM Drivers
         JOIN Orders ON Drivers.id = Orders.driver_id
         JOIN Rating ON Orders.id = Rating.order_id
GROUP BY Drivers.id
HAVING COUNT(Orders.id) > 20 AND AVG(Rating.rating) >= 4;


SELECT Restaurants.name
FROM Restaurants
WHERE Restaurants.id NOT IN (
    SELECT DISTINCT Orders.restaurant_id
    FROM Orders
             JOIN Users ON Orders.user_id = Users.id
    WHERE Users.email = 'johndoe@example.com'
);
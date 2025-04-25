

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


INSERT INTO `table` (name,active, area_id) VALUES
                                               ('Table 3', 1, 1),
                                               ('Table 4', 1, 1),
                                               ('Table 5', 1, 1),
                                               ('Table 6', 1, 1),
                                               ('Table 7', 1, 1),
                                               ('Table 8', 1, 1),
                                               ('Table 9', 1, 1),
                                               ('Table 10', 1, 1),
                                               ('Table 11', 1, 1),
                                               ('Table 12', 1, 1),
                                               ('Table 13', 1, 1),
                                               ('Table 14', 1, 1),
                                               ('Table 15', 1, 1),
                                               ('Table 16', 1, 1),
                                               ('Table 17', 1, 1),
                                               ('Table 18', 1, 1),
                                               ('Table 19', 1, 1),
                                               ('Table 20', 1, 1),
                                               ('Table 21', 1, 2),
                                               ('Table 22', 1, 2),
                                               ('Table 23', 1, 2),
                                               ('Table 24', 1, 2),
                                               ('Table 25', 1, 2),
                                               ('Table 26', 1, 2),
                                               ('Table 27', 1, 2),
                                               ('Table 28', 1, 2),
                                               ('Table 29', 1, 2),
                                               ('Table 30', 1, 2),
                                               ('Table 32', 1, 2),
                                               ('Table 33', 1, 2),
                                               ('Table 34', 1, 2),
                                               ('Table 35', 1, 2),
                                               ('Table 36', 1, 2),
                                               ('Table 37', 1, 2),
                                               ('Table 38', 1, 2),
                                               ('Table 39', 1, 2),
                                               ('Table 40', 1, 2),
                                               ('Table 41', 1, 3),
                                               ('Table 42', 1, 3),
                                               ('Table 43', 1, 3),
                                               ('Table 44', 1, 3),
                                               ('Table 45', 1, 3),
                                               ('Table 46', 1, 3),
                                               ('Table 47', 1, 3),
                                               ('Table 48', 1, 3),
                                               ('Table 49', 1, 3),
                                               ('Table 50', 1, 3),
                                               ('Table 51', 1, 3),
                                               ('Table 52', 1, 3),
                                               ('Table 53', 1, 3),
                                               ('Table 54', 1, 3),
                                               ('Table 55', 1, 3),
                                               ('Table 56', 1, 3),
                                               ('Table 57', 1, 3),
                                               ('Table 58', 1, 3),
                                               ('Table 59', 1, 3),
                                               ('Table 60', 1, 3);

-- ////////////////////////////////////////////////////////////////////////////////////////////////////


-- Insert Categories
INSERT INTO category (name,active,type) VALUES
                                            ('Italian',1,1),
                                            ('Indian',1,1),
                                            ('American',1,1),
                                            ('Japanese',1,1),
                                            ('Mexican',1,1),
                                            ('Thai',1,1),
                                            ('French',1,1),
                                            ('Greek',1,1),
                                            ('Chinese',1,1),
                                            ('Steakhouse',1,1),
                                            ('Beer',1,2),
                                            ('CookTail',1,2),
                                            ('Wine',1,2),
                                            ('Soft-Drink',1,2),
                                            ('Cafe',1,2);

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
INSERT INTO printer (name, printer_name, ip_address, port, connection_type, print_number, is_print_each_paper, active , type) VALUES
                                                                                                                                  ('Office Printer 1', 'HP LaserJet Pro M404', '192.168.1.100', 9100, 1, 1, 1, 1, 1),  -- Example: Network, Enabled
                                                                                                                                  ('Kitchen Printer', 'Epson TM-T20II', '192.168.1.101', 9100, 1, 1, 0, 1, 2),  -- Example: Network, Enabled, Receipt
                                                                                                                                  ('Shipping Label Printer', 'Zebra ZD420', '192.168.1.102', 9100, 1, 1, 1, 1, 4), -- Example: Network, Enabled
                                                                                                                                  ('Front Desk Printer', 'Brother HL-L2395DW', '192.168.1.103', 9100, 1, 2, 1, 0, 1),  -- Example: Network, Disabled
                                                                                                                                  ('USB Printer', 'Canon Pixma TS6420', '192.168.1.103', 9100, 2, 1, 1, 1, 1);  -- Example: USB, Enabled



-- Additional Items
INSERT INTO item (category_type,category_id, name, price, out_of_stock, unit_id, printer_id, description) VALUES
                                                                                                              (1,6, 'Pad Thai', 11.99, 0, 1, 1, 'Stir-fried rice noodles with eggs, tofu, and shrimp, topped with crushed peanuts.'),
                                                                                                              (1,6, 'Green Curry', 12.99, 0, 1, 1, 'Rich and creamy green curry with chicken, bamboo shoots, and basil.'),
                                                                                                              (1,7, 'Coq au Vin', 14.99, 0, 1, 1, 'Classic French dish featuring chicken braised in red wine with mushrooms and onions.'),
                                                                                                              (1,7, 'Ratatouille', 10.99, 0, 1, 1, 'A vibrant dish of stewed vegetables including eggplant, zucchini, and bell peppers.'),
                                                                                                              (1,8, 'Greek Souvlaki', 13.99, 0, 1, 1, 'Marinated and grilled chicken skewers served with pita bread, tzatziki, and vegetables.'),
                                                                                                              (1,8, 'Moussaka', 12.99, 0, 1, 1, 'Layered eggplant and ground beef casserole with a creamy béchamel topping.'),
                                                                                                              (1,9, 'Kung Pao Chicken', 11.99, 0, 1, 1, 'Spicy stir-fried chicken with peanuts, vegetables, and chili peppers.'),
                                                                                                              (1,9, 'Mapo Tofu', 10.99, 0, 1, 1, 'Soft tofu in a spicy and savory sauce with ground pork.'),
                                                                                                              (1,10, 'Falafel Wrap', 9.99, 0, 1, 1, 'Crispy falafel balls wrapped in pita with lettuce, tomatoes, and tahini sauce.'),
                                                                                                              (1,10, 'Hummus Plate', 8.99, 0, 1, 1, 'Creamy hummus served with warm pita bread and olive oil.'),
                                                                                                              (1,10, 'Ribeye Steak', 18.99, 0, 1, 1, 'Juicy ribeye steak grilled to perfection, served with garlic butter.'),
                                                                                                              (1,1, 'Filet Mignon', 20.99, 0, 1, 1, 'Tender filet mignon steak with a red wine reduction.'),
                                                                                                              (1,2, 'Grilled Salmon', 15.99, 0, 1, 1, 'Fresh salmon fillet grilled with lemon and dill sauce.'),
                                                                                                              (1,2, 'Shrimp Scampi', 14.99, 0, 1, 1, 'Sautéed shrimp in a garlic, butter, and white wine sauce.'),
                                                                                                              (1,3, 'BBQ Chicken Pizza', 13.99, 0, 2, 1, 'Pizza topped with BBQ sauce, grilled chicken, onions, and mozzarella.'),
                                                                                                              (1,3, 'Hawaiian Pizza', 12.99, 0, 2, 1, 'Pizza with ham, pineapple, and mozzarella cheese.'),
                                                                                                              (1,4, 'Apple Pie', 6.99, 0, 1, 1, 'Classic apple pie with a flaky crust and cinnamon-spiced apples.'),
                                                                                                              (1,4, 'Ice Cream Sundae', 5.99, 0, 1, 1, 'Vanilla ice cream topped with hot fudge, whipped cream, and a cherry.'),
                                                                                                              (1,3, 'Spaghetti and Meatballs', 13.99, 0, 1, 1, 'Classic spaghetti with homemade meatballs in marinara sauce.'),
                                                                                                              (1,1, 'Chicken Parmesan', 14.99, 0, 1, 1, 'Breaded chicken breast topped with marinara sauce and mozzarella cheese.'),
                                                                                                              (1,1, 'Fettuccine Alfredo', 12.99, 0, 1, 1, 'Fettuccine pasta tossed in a creamy Alfredo sauce.'),
                                                                                                              (1,1, 'Ravioli', 13.99, 0, 1, 1, 'Cheese-filled ravioli with your choice of sauce.'),
                                                                                                              (1,1, 'Minestrone Soup', 6.99, 0, 1, 1, 'Hearty Italian vegetable soup.'),
                                                                                                              (1,1, 'Garlic Bread', 4.99, 0, 1, 1, 'Toasted bread with garlic butter and herbs.'),
                                                                                                              (1,1, 'Arancini', 7.99, 0, 1, 1, 'Fried rice balls filled with cheese and meat.'),
                                                                                                              (1,2, 'Chicken Tikka Masala', 14.99, 0, 1, 2, 'Tender chicken in a creamy tomato sauce.'),
                                                                                                              (1,2, 'Butter Chicken', 15.99, 0, 1, 2, 'Mild and creamy chicken curry.'),
                                                                                                              (1,2, 'Saag Paneer', 13.99, 0, 1, 2, 'Spinach and cheese curry.'),
                                                                                                              (1,2, 'Chana Masala', 12.99, 0, 1, 2, 'Chickpea curry.'),
                                                                                                              (1,2, 'Dal Makhani', 11.99, 0, 1, 2, 'Creamy lentil dish.'),
                                                                                                              (1,2, 'Naan Bread', 2.99, 0, 1, 2, 'Soft and fluffy Indian bread.'),
                                                                                                              (1,2, 'Samosas', 5.99, 0, 1, 2, 'Fried pastries filled with potatoes and peas.'),
                                                                                                              (1,3, 'Fried Chicken', 10.99, 0, 1, 2, 'Crispy fried chicken.'),
                                                                                                              (1,3, 'Mac and Cheese', 8.99, 0, 1, 1, 'Creamy macaroni and cheese.'),
                                                                                                              (1,3, 'French Fries', 4.99, 0, 1, 2, 'Classic French fries.'),
                                                                                                              (1,3, 'Onion Rings', 5.99, 0, 1, 2, 'Crispy onion rings.'),
                                                                                                              (1,3, 'Chicken Wings', 9.99, 0, 1, 2, 'Chicken wings with your choice of sauce.'),
                                                                                                              (1,3, 'Cornbread', 3.99, 0, 1, 1, 'Sweet and savory cornbread.'),
                                                                                                              (1,3, 'Coleslaw', 3.99, 0, 1, 1, 'Classic coleslaw.'),
                                                                                                              (1,4, 'Ramen', 12.99, 0, 1, 2, 'Japanese noodle soup dish.'),
                                                                                                              (1,4, 'Sushi Rolls (various)', 14.99, 0, 1, 2, 'Variety of sushi rolls.'),
                                                                                                              (1,4, 'Tempura', 11.99, 0, 1, 2, 'Deep-fried seafood and vegetables.'),
                                                                                                              (1,4, 'Teriyaki Chicken', 13.99, 0, 1, 2, 'Grilled chicken with teriyaki sauce.'),
                                                                                                              (1,4, 'Miso Soup', 3.99, 0, 1, 2, 'Traditional Japanese soup.'),
                                                                                                              (1,4, 'Edamame', 4.99, 0, 1, 2, 'Steamed and salted soybeans.'),
                                                                                                              (1,4, 'Gyoza', 6.99, 0, 1, 2, 'Pan-fried dumplings.'),
                                                                                                              (1,5, 'Enchiladas', 11.99, 0, 1, 2, 'Tortillas filled with meat and cheese, topped with sauce.'),
                                                                                                              (1,5, 'Quesadillas', 9.99, 0, 1, 2, 'Grilled tortillas filled with cheese and your choice of fillings.'),
                                                                                                              (1,5, 'Nachos', 8.99, 0, 1, 2, 'Tortilla chips topped with cheese, beans, and other toppings.'),
                                                                                                              (1,5, 'Guacamole and Chips', 6.99, 0, 1, 2, 'Homemade guacamole served with tortilla chips.'),
                                                                                                              (1,5, 'Churros', 5.99, 0, 1, 2, 'Fried dough pastries with cinnamon sugar.');

-- Add Drink Items with category_id ranging from 11 to 15
INSERT INTO item (category_type, category_id, name, price, out_of_stock, unit_id, printer_id, description) VALUES
                                                                                                               (2, 11, 'Latte', 4.49, 0, 4, 1, 'Creamy and smooth latte with steamed milk and espresso.'),
                                                                                                               (2, 11, 'Mocha', 4.99, 0, 4, 1, 'Espresso mixed with chocolate syrup and topped with steamed milk.'),
                                                                                                               (2, 11, 'Iced Coffee', 3.49, 0, 4, 1, 'Chilled coffee served over ice, perfect for a refreshing drink.'),
                                                                                                               (2, 12, 'Americano', 2.99, 0, 4, 1, 'Espresso diluted with hot water for a smooth coffee experience.'),
                                                                                                               (2, 12, 'Macchiato', 3.79, 0, 4, 1, 'Espresso topped with a small amount of foamed milk.'),
                                                                                                               (2, 12, 'Hot Chocolate', 3.49, 0, 4, 1, 'Rich and creamy hot chocolate topped with whipped cream.'),
                                                                                                               (2, 13, 'Chai Latte', 4.29, 0, 4, 1, 'Spiced black tea blended with steamed milk and chai spices.'),
                                                                                                               (2, 13, 'Iced Tea', 2.49, 0, 4, 1, 'Refreshing iced tea with a hint of lemon.'),
                                                                                                               (2, 13, 'Matcha Latte', 4.99, 0, 4, 1, 'Creamy and earthy green tea latte made with matcha powder.'),
                                                                                                               (2, 14, 'Smoothie', 5.99, 0, 4, 1, 'A blend of fresh fruits, yogurt, and ice for a healthy drink.'),
                                                                                                               (2, 14, 'Milkshake', 4.99, 0, 4, 1, 'Thick and creamy milkshake, available in chocolate, vanilla, or strawberry.'),
                                                                                                               (2, 14, 'Lemonade', 2.99, 0, 4, 1, 'Freshly squeezed lemonade with a perfect balance of sweet and tart.'),
                                                                                                               (2, 15, 'Sparkling Water', 1.99, 0, 4, 1, 'Refreshing carbonated water with no added sugar.'),
                                                                                                               (2, 15, 'Herbal Tea', 3.49, 0, 4, 1, 'Caffeine-free herbal tea with calming flavors like chamomile or peppermint.'),
                                                                                                               (2, 11, 'Energy Drink', 3.99, 0, 4, 1, 'A high-energy beverage to keep you awake and alert.'),
                                                                                                               (2, 11, 'Cold Brew Coffee', 3.99, 0, 4, 1, 'Slow-brewed coffee served chilled for a smooth, bold flavor.'),
                                                                                                               (2, 12, 'Orange Juice', 3.49, 0, 4, 1, 'Freshly squeezed orange juice packed with vitamin C.'),
                                                                                                               (2, 12, 'Iced Matcha', 4.49, 0, 4, 1, 'Chilled matcha green tea served over ice for a refreshing drink.'),
                                                                                                               (2, 12, 'Green Tea', 2.99, 0, 4, 1, 'Light and healthy green tea brewed to perfection.'),
                                                                                                               (2, 13, 'Coconut Water', 2.99, 0, 4, 1, 'Naturally hydrating coconut water, perfect for a post-workout drink.'),
                                                                                                               (2, 13, 'Flat White', 4.49, 0, 4, 1, 'A velvety espresso-based drink with steamed milk and microfoam.'),
                                                                                                               (2, 13, 'Turmeric Latte', 4.99, 0, 4, 1, 'Golden milk latte made with turmeric, spices, and steamed milk.'),
                                                                                                               (2, 14, 'Espresso Tonic', 3.99, 0, 4, 1, 'A refreshing mix of espresso and tonic water served over ice.'),
                                                                                                               (2, 14, 'Affogato', 4.99, 0, 4, 1, 'A scoop of vanilla ice cream topped with a shot of hot espresso.'),
                                                                                                               (2, 14, 'Vietnamese Iced Coffee', 3.99, 0, 4, 1, 'Strong coffee sweetened with condensed milk and served over ice.'),
                                                                                                               (2, 15, 'Iced Mocha', 4.79, 0, 4, 1, 'Chilled mocha with espresso, chocolate, and milk over ice.'),
                                                                                                               (2, 15, 'Arnold Palmer', 2.99, 0, 4, 1, 'Half iced tea, half lemonade for a perfectly balanced refreshment.'),
                                                                                                               (2, 11, 'Berry Smoothie', 5.99, 0, 4, 1, 'A blend of mixed berries, yogurt, and honey for a sweet and healthy drink.'),
                                                                                                               (2, 11, 'Protein Shake', 6.49, 0, 4, 1, 'A high-protein shake made with milk, protein powder, and bananas.'),
                                                                                                               (2, 12, 'Peach Iced Tea', 3.49, 0, 4, 1, 'Sweet iced tea infused with the flavor of ripe peaches.'),
                                                                                                               (2, 12, 'Rose Lemonade', 3.99, 0, 4, 1, 'A floral twist on classic lemonade with a hint of rose water.'),
                                                                                                               (2, 12, 'Black Tea', 2.49, 0, 4, 1, 'Classic black tea served hot or iced, strong and aromatic.'),
                                                                                                               (2, 13, 'Earl Grey Tea', 2.99, 0, 4, 1, 'Aromatic black tea infused with the citrusy flavor of bergamot.'),
                                                                                                               (2, 13, 'Chamomile Tea', 2.99, 0, 4, 1, 'A soothing herbal tea with calming chamomile flowers.'),
                                                                                                               (2, 13, 'Caramel Macchiato', 4.99, 0, 4, 1, 'Espresso with steamed milk, vanilla, and caramel drizzle.'),
                                                                                                               (2, 14, 'Espresso Martini', 7.49, 0, 4, 1, 'A sophisticated cocktail with espresso, vodka, and coffee liqueur.'),
                                                                                                               (2, 14, 'Watermelon Juice', 3.49, 0, 4, 1, 'Freshly pressed watermelon juice, naturally sweet and hydrating.'),
                                                                                                               (2, 14, 'Pineapple Smoothie', 5.49, 0, 4, 1, 'A tropical blend of pineapple, coconut milk, and ice.'),
                                                                                                               (2, 15, 'Mango Lassi', 4.49, 0, 4, 1, 'A creamy and sweet yogurt-based mango drink, popular in Indian cuisine.'),
                                                                                                               (2, 15, 'Cucumber Mint Cooler', 3.99, 0, 4, 1, 'Refreshing cucumber and mint infused sparkling water.'),
                                                                                                               (2, 11, 'Cola', 1.99, 0, 4, 1, 'Classic carbonated soft drink.'),
                                                                                                               (2, 11, 'Diet Cola', 1.99, 0, 4, 1, 'Sugar-free version of the classic cola.'),
                                                                                                               (2, 11, 'Root Beer', 2.49, 0, 4, 1, 'Sweet and fizzy root beer, perfect for a nostalgic treat.'),
                                                                                                               (2, 12, 'Ginger Ale', 2.49, 0, 4, 1, 'Crisp and spicy ginger-flavored soft drink.'),
                                                                                                               (2, 12, 'Fizzy Lemon Soda', 2.99, 0, 4, 1, 'Refreshing lemon-flavored soda with a hint of fizz.'),
                                                                                                               (2, 13, 'Strawberry Lemonade', 3.99, 0, 4, 1, 'A tangy lemonade blended with sweet strawberries.'),
                                                                                                               (2, 13, 'Cranberry Juice', 3.49, 0, 4, 1, 'Tart and refreshing cranberry juice, great on its own or as a mixer.'),
                                                                                                               (2, 14, 'Apple Cider (Hot)', 3.99, 0, 4, 1, 'Warm spiced apple cider, perfect for a cozy drink.'),
                                                                                                               (2, 14, 'Hot Toddy', 5.99, 0, 4, 1, 'A warm cocktail with whiskey, honey, lemon, and hot water.'),
                                                                                                               (2, 14, 'Mint Mojito (Non-Alcoholic)', 4.49, 0, 4, 1, 'Refreshing mix of mint, lime, and soda water without.');

-- Insert non-food items into the 'item' table with category_type = 3
INSERT INTO item (category_type, category_id, name, price, out_of_stock, unit_id, printer_id, description) VALUES
                                                                                                               (3, NULL, 'Napkins Pack', 2.99, 0, 4, 1, 'Soft and durable napkins for dining use.'),
                                                                                                               (3, NULL, 'Paper Towels', 5.49, 0, 4, 1, 'High-absorbent paper towels for cleaning.'),
                                                                                                               (3, NULL, 'Disposable Cups', 6.99, 0, 4, 1, 'Pack of 50 disposable drinking cups.'),
                                                                                                               (3, NULL, 'Plastic Utensils Set', 3.99, 0, 4, 1, 'Set of forks, knives, and spoons for single-use.'),
                                                                                                               (3, NULL, 'Hand Sanitizer', 4.99, 0, 4, 1, 'Pocket-sized hand sanitizer for hygiene.'),
                                                                                                               (3, NULL, 'Wet Wipes', 3.49, 0, 4, 1, 'Antibacterial wet wipes for cleaning.'),
                                                                                                               (3, NULL, 'Toothpicks Pack', 1.99, 0, 4, 1, 'Box of 200 wooden toothpicks.'),
                                                                                                               (3, NULL, 'Table Cloth', 9.99, 0, 4, 1, 'Reusable and easy-to-clean table cloth.'),
                                                                                                               (3, NULL, 'Serving Tray', 12.99, 0, 4, 1, 'Stainless steel serving tray for food service.'),
                                                                                                               (3, NULL, 'Condiment Dispenser', 8.99, 0, 4, 1, 'Bottle set for ketchup, mustard, and sauces.'),
                                                                                                               (3, NULL, 'Glass Cleaner Spray', 4.49, 0, 4, 1, 'Spray for cleaning glass surfaces and mirrors.'),
                                                                                                               (3, NULL, 'Dish Soap', 3.99, 0, 4, 1, 'Liquid dish soap for washing dishes.'),
                                                                                                               (3, NULL, 'Mop and Bucket Set', 19.99, 0, 4, 1, 'Cleaning set including mop and bucket.'),
                                                                                                               (3, NULL, 'Trash Bags', 5.99, 0, 4, 1, 'Pack of large black trash bags (50 count).'),
                                                                                                               (3, NULL, 'Apron', 7.99, 0, 4, 1, 'Protective apron for kitchen or dining use.'),
                                                                                                               (3, NULL, 'Cleaning Gloves', 2.99, 0, 4, 1, 'Pair of rubber gloves for cleaning tasks.'),
                                                                                                               (3, NULL, 'Table Napkin Holder', 6.49, 0, 4, 1, 'Holder for napkins, ideal for dining tables.'),
                                                                                                               (3, NULL, 'Disposable Food Containers', 10.99, 0, 4, 1, 'Pack of 25 disposable containers with lids.'),
                                                                                                               (3, NULL, 'Kitchen Towels', 8.49, 0, 4, 1, 'Pack of 5 absorbent kitchen towels.'),
                                                                                                               (3, NULL, 'Air Freshener Spray', 4.99, 0, 4, 1, 'Refreshing air freshener for dining spaces.');


-- Insert entertainment and service items into the 'item' table with category_type = 5
INSERT INTO item (category_type, category_id, name, price, out_of_stock, unit_id, printer_id, description) VALUES
                                                                                                               (5, NULL, 'Karaoke Service', 50.00, 0, 5, 1, 'Enjoy a fun-filled karaoke session with friends and family.'),
                                                                                                               (5, NULL, 'Live DJ Service', 150.00, 0, 5, 1, 'Live DJ providing music and entertainment during your event.'),
                                                                                                               (5, NULL, 'Stand-up Comedy Night', 75.00, 0, 5, 1, 'An evening of laughter with stand-up comedy performances.'),
                                                                                                               (5, NULL, 'Trivia Night Service', 30.00, 0, 5, 1, 'Interactive trivia games for groups and families.'),
                                                                                                               (5, NULL, 'Photo Booth Rental', 100.00, 0, 5, 1, 'Photo booth setup for capturing memories during your visit.'),
                                                                                                               (5, NULL, 'Game Night Package', 40.00, 0, 5, 1, 'Enjoy board games and interactive group activities.'),
                                                                                                               (5, NULL, 'Karaoke Room Rental', 75.00, 0, 5, 1, 'Private room equipped with karaoke machines and seating.'),
                                                                                                               (5, NULL, 'Dance Floor Setup', 120.00, 0, 5, 1, 'Setup of a dance floor with lighting and sound systems.'),
                                                                                                               (5, NULL, 'Live Band Performance', 200.00, 0, 5, 1, 'Live band playing music to elevate your dining experience.'),
                                                                                                               (5, NULL, 'Movie Screening Service', 100.00, 0, 5, 1, 'Private movie screening with food and beverages.'),
                                                                                                               (5, NULL, 'Magic Show', 80.00, 0, 5, 1, 'A live magician performing tricks during your meal.'),
                                                                                                               (5, NULL, 'Kids Play Area Access', 20.00, 0, 5, 1, 'Access to a supervised play area for children.'),
                                                                                                               (5, NULL, 'Virtual Reality Gaming', 50.00, 0, 5, 1, 'Virtual reality entertainment setup for guests.'),
                                                                                                               (5, NULL, 'Cooking Demonstration', 60.00, 0, 5, 1, 'Live cooking demonstration by our chefs.'),
                                                                                                               (5, NULL, 'Themed Dining Experience', 150.00, 0, 5, 1, 'Special-themed dining nights with decorations and entertainment.'),
                                                                                                               (5, NULL, 'Karaoke Night Package', 90.00, 0, 5, 1, 'Includes karaoke, private room rental, and drinks.'),
                                                                                                               (5, NULL, 'Dance Instructor Service', 70.00, 0, 5, 1, 'Professional dance instructor for group dance sessions.'),
                                                                                                               (5, NULL, 'Silent Disco Experience', 100.00, 0, 5, 1, 'Silent disco setup with wireless headphones and a live DJ.'),
                                                                                                               (5, NULL, 'VIP Booth Service', 200.00, 0, 5, 1, 'Private VIP booth with priority service and complimentary drinks.'),
                                                                                                               (5, NULL, 'Interactive Dining Show', 180.00, 0, 5, 1, 'Live performance show involving guests for an immersive experience.');

-- Add Combo Food Items
INSERT INTO item (category_type, category_id, name, price, out_of_stock, unit_id, printer_id, description) VALUES
                                                                                                               (7, NULL, 'Grilled Chicken Feast', 14.99, 0, 1, 1, 'Grilled chicken with a side of mashed potatoes and steamed vegetables.'),
                                                                                                               (7, NULL, 'BBQ Rib Platter', 15.49, 0, 1, 1, 'BBQ ribs served with baked beans, coleslaw, and cornbread.'),
                                                                                                               (7, NULL, 'Classic Burger Combo', 13.99, 0, 1, 1, 'Beef burger with fries and a soft drink.'),
                                                                                                               (7, NULL, 'Taco Duo Combo', 12.99, 0, 1, 1, 'Two tacos with rice, beans, and a side of salsa.'),
                                                                                                               (7, NULL, 'Pizza and Salad Combo', 11.99, 0, 1, 1, 'Margherita pizza slice with a Caesar salad and garlic bread.'),
                                                                                                               (7, NULL, 'Salmon Deluxe', 16.99, 0, 1, 1, 'Grilled salmon with quinoa, asparagus, and a lemon butter sauce.'),
                                                                                                               (7, NULL, 'Crispy Chicken Sandwich Combo', 10.49, 0, 1, 1, 'Fried chicken sandwich with sweet potato fries and coleslaw.'),
                                                                                                               (7, NULL, 'Steakhouse Dinner', 18.99, 0, 1, 1, 'Filet mignon with mashed potatoes, green beans, and a dinner roll.'),
                                                                                                               (7, NULL, 'Vegetarian Delight', 9.99, 0, 1, 1, 'Vegetarian wrap with a side of hummus and pita chips.'),
                                                                                                               (7, NULL, 'Shrimp Scampi Combo', 17.49, 0, 1, 1, 'Shrimp scampi served with garlic bread and a garden salad.'),
                                                                                                               (7, NULL, 'Grilled Cheese & Soup', 11.49, 0, 1, 1, 'Grilled cheese sandwich with tomato soup and a cookie.'),
                                                                                                               (7, NULL, 'Pasta Lover\'s Combo', 13.49, 0, 1, 1, 'Pasta alfredo served with a side of garlic bread and a small side salad.'),
(7, NULL, 'Cheeseburger Special', 12.49, 0, 1, 1, 'Cheeseburger with onion rings and a soft drink.'),
(7, NULL, 'Indian Curry Combo', 15.99, 0, 1, 1, 'Chicken tikka masala with basmati rice, naan bread, and raita.'),
(7, NULL, 'Lamb Chop Dinner', 16.49, 0, 1, 1, 'Grilled lamb chops with roasted potatoes and sautéed spinach.'),
(7, NULL, 'Club Sandwich Combo', 11.99, 0, 1, 1, 'Classic club sandwich with a side of fries and a pickle.'),
(7, NULL, 'Teriyaki Chicken Bowl', 13.99, 0, 1, 1, 'Teriyaki chicken with steamed rice and stir-fried vegetables.'),
(7, NULL, 'Fish and Chips Combo', 14.49, 0, 1, 1, 'Fish and chips served with tartar sauce and coleslaw.'),
(7, NULL, 'Bagel Brunch', 10.99, 0, 1, 1, 'Bagel sandwich with cream cheese, smoked salmon, and a side salad.'),
(7, NULL, 'Ribeye Steak Dinner', 16.99, 0, 1, 1, 'Ribeye steak with baked potato, sautéed mushrooms, and a dinner roll.'),
(7, NULL, 'Surf and Turf Special', 18.49, 0, 1, 1, 'Surf and turf with lobster tail, steak, and garlic mashed potatoes.'),
(7, NULL, 'Chicken Quesadilla Platter', 12.99, 0, 1, 1, 'Chicken quesadilla with guacamole, salsa, and sour cream.'),
(7, NULL, 'German Schnitzel Combo', 14.99, 0, 1, 1, 'Pork schnitzel with spaetzle, red cabbage, and a mustard sauce.'),
(7, NULL, 'Falafel Platter', 11.49, 0, 1, 1, 'Falafel platter with tabbouleh, hummus, and pita bread.'),
(7, NULL, 'Vegetable Stir-Fry Bowl', 13.49, 0, 1, 1, 'Vegetable stir-fry with tofu and steamed jasmine rice.'),
(7, NULL, 'Prime Rib Dinner', 17.99, 0, 1, 1, 'Prime rib with au jus, a baked potato, and creamed spinach.'),
(7, NULL, 'BBQ Chicken Feast', 14.49, 0, 1, 1, 'BBQ chicken with mac and cheese, green beans, and cornbread.'),
(7, NULL, 'Mediterranean Combo', 13.99, 0, 1, 1, 'Grilled chicken kabobs served with rice pilaf, tzatziki, and pita bread.'),
(7, NULL, 'Asian Noodle Combo', 12.99, 0, 1, 1, 'Lo mein noodles with chicken, stir-fried vegetables, and soy sauce.');


-- Insert food items with platters
INSERT INTO item (category_type, category_id, name, price, out_of_stock, unit_id, printer_id, description) VALUES
(8, NULL, 'Customizable Family Platter', 29.99, 0, 1, 1, 'A large platter with customizable dishes to suit family preferences.'),
(8, NULL, 'Steak and Seafood Platter', 24.99, 0, 1, 1, 'A platter featuring steak and seafood combinations.'),
(8, NULL, 'Asian Dish Platter', 21.99, 0, 1, 1, 'An Asian-inspired platter with options like tempura, sushi, or gyoza.'),
(8, NULL, 'Mediterranean Meal Platter', 19.99, 0, 1, 1, 'A Mediterranean platter with dishes such as hummus, falafel, and souvlaki.'),
(8, NULL, 'Southern Style Platter', 18.99, 0, 1, 1, 'A Southern-style platter with fried chicken, mac and cheese, or cornbread.'),
(8, NULL, 'Indian Cuisine Platter', 23.99, 0, 1, 1, 'An Indian-themed platter with naan, samosas, and curries.'),
(8, NULL, 'Build-Your-Own American Platter', 17.99, 0, 1, 1, 'An American-style platter with options like burgers, fries, and onion rings.'),
(8, NULL, 'Mexican Dish Platter', 20.99, 0, 1, 1, 'A Mexican-inspired platter with enchiladas, quesadillas, and guacamole.'),
(8, NULL, 'Seafood Platter', 25.99, 0, 1, 1, 'A platter with seafood options like grilled salmon, shrimp scampi, and garlic bread.'),
(8, NULL, 'BBQ Meal Platter', 22.99, 0, 1, 1, 'A BBQ platter featuring ribs, chicken, and cornbread with coleslaw.'),
(8, NULL, 'Italian Dish Platter', 19.99, 0, 1, 1, 'An Italian-themed platter with options such as Alfredo pasta and garlic bread.'),
(8, NULL, 'French Cuisine Platter', 21.99, 0, 1, 1, 'A French-inspired platter with ratatouille, coq au vin, and garlic bread.'),
(8, NULL, 'Japanese Meal Platter', 22.99, 0, 1, 1, 'A Japanese platter with sushi rolls, ramen, and edamame.'),
(8, NULL, 'Thai Cuisine Platter', 20.99, 0, 1, 1, 'A Thai-inspired platter featuring pad Thai, green curry, and spring rolls.'),
(8, NULL, 'Hot Pot Platter', 18.99, 0, 1, 1, 'A customizable hot pot platter with meats, vegetables, and broth.'),
(8, NULL, 'Breakfast Platter', 15.99, 0, 1, 1, 'A breakfast platter with options like scrambled eggs, sausage, and pancakes.'),
(8, NULL, 'Brunch Special Platter', 18.99, 0, 1, 1, 'A brunch platter with omelets, French toast, and fresh fruit.'),
(8, NULL, 'Kids Meal Platter', 8.99, 0, 1, 1, 'A kid-friendly platter with chicken nuggets, mac and cheese, and apple slices.'),
(8, NULL, 'Dessert Sampler Platter', 14.99, 0, 1, 1, 'A dessert platter with options like apple pie, churros, and ice cream.'),
(8, NULL, 'Protein Power Platter', 23.99, 0, 1, 1, 'A high-protein platter with grilled chicken, steak, and quinoa salad.');



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
INSERT INTO item_on_children_item (item_id, children_item_id,quantity) VALUES
   (142, 1,2),
   (143, 2,1),
   (143, 11,3),
   (142, 12,4),
   (143, 3,5),
   (143, 4,6),
   (144, 13,2),
   (144, 14,1),
   (145, 5,2),
   (145, 6,3),
   (146, 15,5),
   (146, 16,2),
   (147, 7,1),
   (147, 8,5),
   (148, 17,5),
   (148, 18,6),
   (149, 9,2),
   (149, 10,4),
   (150, 19,1),
   (150, 20,2),
   (151, 1,5),
   (151, 2,7),
   (152, 11,3),
   (152, 12,1),
   (153, 3,9),
   (153, 4,2),
   (154, 13,1),
   (154, 14,3),
   (155, 5,5),
   (155, 6,6),
   (156, 15,3),
   (156, 16,3),
   (157, 7,2),
   (157, 8,1),
   (158, 17,1),
   (158, 18,1),
   (159, 9,5),
   (159, 10,7),
   (160, 19,7),
   (160, 20,3),
   (161, 19,7),
   (161, 20,3),
   (162, 19,7),
   (162, 20,3),
	(163, 1,2),
   (163, 2,1),
   (164, 11,3),
   (164, 12,4),
   (165, 3,5),
   (165, 4,6),
   (166, 13,2),
   (166, 14,1),
   (167, 5,2),
   (167, 6,3),
   (168, 15,5),
   (168, 16,2),
   (169, 7,1),
   (169, 8,5),
   (170, 17,5),
   (170, 18,6),
   (170, 9,2);


  -- Insert data into Parent_Item_Chilren_Item table
INSERT INTO item_on_children_item (item_id, children_item_id,quantity) VALUES
   (171, 1,1),
   (171, 2,1),
   (172, 11,1),
   (172, 12,1),
   (173, 3,1),
   (173, 4,1),
   (174, 13,1),
   (174, 14,1),
   (175, 5,1),
   (175, 6,1),
   (176, 15,1),
   (176, 16,1),
   (177, 7,1),
   (177, 8,1),
   (178, 17,1),
   (178, 18,1),
   (179, 9,1),
   (179, 10,1),
   (180, 19,1),
   (180, 20,1),
   (181, 1,1),
   (181, 2,1),
   (182, 11,1),
   (182, 12,1),
   (183, 3,1),
   (183, 4,1),
   (184, 13,1),
   (184, 14,1),
   (185, 5,1),
   (185, 6,1),
   (186, 15,1),
   (186, 16,1),
   (187, 7,1),
   (187, 8,1),
   (188, 17,1),
   (188, 18,1),
   (189, 9,1),
   (189, 10,1),
   (190, 19,1),
   (190, 20,1);
-- ////////////////////////////////////////////////////////////////////////////////////////////////////



-- payment
INSERT INTO payment (discount, tax, surcharge, amount, net_amount, method, status) VALUES
   (0.00, 5.00, 2.50, 100.00, 107.50, 1, 0),  -- Credit Card, Paid
   (10.00, 2.00, 1.00, 50.00, 43.00, 2, 0),   -- Debit Card, Paid
   (5.00, 7.00, 0.00, 75.00, 77.00, 3, 0),   -- PayPal, Paid
   (0.00, 6.50, 3.00, 120.00, 129.50, 4, 0), -- Cash, Pending
   (2.50, 3.50, 1.50, 60.00, 62.50, 1, 0),  -- Credit Card, Processing
   (7.50, 1.00, 0.50, 40.00, 34.00, 2, 0),   -- Debit Card, Failed
   (3.00, 8.00, 2.00, 90.00, 97.00, 3, 0),   -- PayPal, Paid
   (0.00, 4.00, 1.00, 80.00, 85.00, 4, 0), -- Cash, Pending
   (1.00, 5.50, 0.00, 70.00, 74.50, 1, 0),  -- Credit Card, Processing
   (5.00, 2.50, 0.75, 35.00, 33.25, 2, 0),   -- Debit Card, Paid
   (2.00, 6.00, 1.00, 110.00, 115.00, 3, 0),-- Paypal, Paid
   (0.50, 3.00, 0.50, 95.00, 98.00, 4, 0),-- Cash, pending
   (6.00, 2.00, 0.25, 45.00, 41.25, 2, 0), -- Debit card, Failed
   (1.50, 4.50, 1.75, 65.00, 69.75,1, 0),-- credit card, paid
   (0.75, 5.25, 2.25, 78.00, 84.50,3, 0),-- paypal, processing
   (3.50, 3.75, 0.00, 88.00, 88.25, 4,0), -- cash, paid
   (4.20, 1.50, 2.70, 55.00, 55.00,1,0),-- Credit card, processing
   (1.20, 6.50, 0.50, 125.00, 130.80,2,0),-- Debit card, pending
   (2.50,3.00,1.25,77.00,78.75,3, 0), -- Paypal, failed
   (1.00, 4.75, 0.75, 90.00, 94.50,4,0), -- Cash, paid
   (5.00, 3.30, 1.70, 110.00, 109.70, 1, 0), -- Credit card, paid
   (2.00, 1.00, 0.50, 50.00, 48.50, 2, 0),-- Debit card, processing
   (3.00, 2.50, 1.50, 60.00, 61.00, 3, 0), -- Paypal, Paid
   (0.00, 1.50, 2.00, 70.00, 73.50, 4, 0),
   (0.00, 5.00, 2.50, 200.00, 127.50, 1, 1),  -- Credit Card, Paid
   (10.00, 2.00, 1.00, 500.00, 423.00, 2, 1),   -- Debit Card, Paid
   (5.00, 7.00, 0.00, 755.00, 727.00, 3, 1),   -- PayPal, Paid
   (0.00, 6.50, 3.00, 120.00, 2329.50, 4, 1), -- Cash, Pending
   (2.50, 3.50, 1.50, 6220.00, 622.50, 1, 1),  -- Credit Card, Processing
   (7.50, 1.00, 0.50, 4220.00, 354.00, 2, 1),   -- Debit Card, Failed
   (3.00, 8.00, 2.00, 9770.00, 937.00, 3, 1),   -- PayPal, Paid
   (0.00, 4.00, 1.00, 8750.00, 8565.00, 4, 1), -- Cash, Pending
   (1.00, 5.50, 0.00, 7560.00, 7974.50, 1, 1),  -- Credit Card, Processing
   (5.00, 2.50, 0.75, 3335.00, 3553.25, 2, 1),   -- Debit Card, Paid
   (2.00, 6.00, 1.00, 1140.00, 16515.00, 3, 1),-- Paypal, Paid
   (0.50, 3.00, 0.50, 9345.00, 9768.00, 4, 1),-- Cash, pending
   (6.00, 2.00, 0.25, 4465.00, 4741.25, 2, 1), -- Debit card, Failed
   (1.50, 4.50, 1.75, 6345.00, 6439.75,1, 1),-- credit card, paid
   (0.75, 5.25, 2.25, 7648.00, 82344.50,3, 1),-- paypal, processing
   (3.50, 3.75, 0.00, 8638.00, 85468.25, 4,1), -- cash, paid
   (4.20, 1.50, 2.70, 5335.00, 54545.00,1,1),-- Credit card, processing
   (1.20, 6.50, 0.50, 12775.00, 13440.80,2,1),-- Debit card, pending
   (2.50,3.00,1.25,7447.00,7448.75,3, 1), -- Paypal, failed
   (1.00, 4.75, 0.75, 9330.00, 9234.50,4,1), -- Cash, paid
   (5.00, 3.30, 1.70, 11430.00, 1409.70, 1, 1), -- Credit card, paid
   (2.00, 1.00, 0.50, 5330.00, 4238.50, 2, 1),-- Debit card, processing
   (3.00, 2.50, 1.50, 3460.00, 34361.00, 3, 1), -- Paypal, Paid
   (0.00, 1.50, 2.00,23270.00, 33473.50, 4, 1);

-- ////////////////////////////////////////////////////////////////////////////////////////////////////

-- order
INSERT INTO `order` (user_id, payment_id, status, type, using_slot, using_time, table_id) VALUES
  (1, 1, 0, 0, NULL, NULL, 1),  -- User 1, Payment 1, open, Table 1
  (2, 2, 0, 0, NULL, NULL, 2),  -- User 2, Payment 2, open, Table 2
  (3, 3, 0, 0, NULL, NULL, 3),  -- User 3, Payment 3, open, Table 3
  (4, 4, 0, 0, NULL, NULL, 4),  -- User 4, Payment 4, open, Table 4
  (5, 5, 0, 0, NULL, NULL, 5),  -- User 5, Payment 5, open, Table 5
  (6, 6, 0, 0, 1, '10:30', 6),  -- User 6, Payment 6, open, Table 6, With using_slot & using_time
  (7, 7, 0, 0, 2, '11:30', 7),  -- User 7, Payment 7, open, Table 7, With using_slot & using_time
  (8, 8, 0, 0, 3, '12:30', 8),  -- User 8, Payment 8, open, Table 8, With using_slot & using_time
  (9, 9, 0, 0, NULL, NULL, 9),  -- User 9, Payment 9, open, Table 9
  (10, 10, 0, 0, NULL, NULL, 10), -- User 10, Payment 10, open, Table 10
  (1, 11, 5, 0, NULL, NULL, 11), -- User 1, Payment 11, Cancel, Table 11
  (2, 12, 1, 0, NULL, NULL, 12), -- User 2, Payment 12, payment request, Table 12
  (3, 13, 1, 0, NULL, NULL, 13), -- User 3, Payment 13, complete, No Table
  (4, 14, 0, 0, NULL, NULL, 14), -- User 4, Payment 14, complete, No Table
  (5, 15, 0, 0, NULL, NULL, 15), -- User 5, Payment 15, complete, No Table
  (6, 16, 0, 0, NULL, NULL, 16), -- User 6, Payment 16, complete, No Table
  (7, 17, 0, 0, NULL, NULL, 17), -- User 7, Payment 17, complete, No Table
  (8, 18, 0, 0, NULL, NULL, 18), -- User 8, Payment 18, complete, No Table
  (9, 19, 0, 0, NULL, NULL, 19), -- User 9, Payment 19, complete, No Table
  (10, 20, 0, 0, NULL, NULL, 20),-- User 10, Payment 20, complete, No Table
  (3, 21, 0, 0, NULL, NULL, 21),  -- User 3, Payment 21, complete, No Table
  (5, 22, 0, 0, NULL, NULL, 22), -- User 5, Payment 22, complete, No Table
  (1, 23, 4, 0, NULL, NULL, 23), -- User 1, Payment 23, complete, No Table
  (2, 24, 4, 0, NULL, NULL, 24), -- User 2, payment 24, complete, No Table
   (1, 25, 2, 0, NULL, NULL, null),  -- User 1, Payment 1, open, Table 1
  (2, 26, 2, 0, NULL, NULL, null),  -- User 2, Payment 2, open, Table 2
  (3, 27, 2, 0, NULL, NULL, null),  -- User 3, Payment 3, open, Table 3
  (4, 28, 2, 0, NULL, NULL, null),  -- User 4, Payment 4, open, Table 4
  (5, 29, 2, 0, NULL, NULL, null),  -- User 5, Payment 5, open, Table 5
  (6, 30, 2, 0, 1, '10:30', null),  -- User 6, Payment 6, open, Table 6, With using_slot & using_time
  (7, 31, 2, 0, 2, '11:30', null),  -- User 7, Payment 7, open, Table 7, With using_slot & using_time
  (8, 32, 2, 0, 3, '12:30',null),  -- User 8, Payment 8, open, Table 8, With using_slot & using_time
  (9, 33, 2, 0, NULL, NULL, null),  -- User 9, Payment 9, open, Table 9
  (10, 34, 2, 0, NULL, NULL, null), -- User 10, Payment 10, open, Table 10
  (1, 35, 2, 0, NULL, NULL, null), -- User 1, Payment 11, Cancel, Table 11
  (2, 36, 2, 0, NULL, NULL, null), -- User 2, Payment 12, payment request, Table 12
  (3, 37, 2, 0, NULL, NULL, null), -- User 3, Payment 13, complete, No Table
  (4, 38, 2, 0, NULL, NULL, null), -- User 4, Payment 14, complete, No Table
  (5, 39, 2, 0, NULL, NULL, null), -- User 5, Payment 15, complete, No Table
  (6, 40, 2, 0, NULL, NULL, null), -- User 6, Payment 16, complete, No Table
  (7, 41, 2, 0, NULL, NULL, null), -- User 7, Payment 17, complete, No Table
  (8, 42, 2, 0, NULL, NULL, null), -- User 8, Payment 18, complete, No Table
  (9, 43, 2, 0, NULL, NULL, null), -- User 9, Payment 19, complete, No Table
  (10, 44,2, 0, NULL, NULL, null),-- User 10, Payment 20, complete, No Table
  (3, 45, 2, 0, NULL, NULL, null),  -- User 3, Payment 21, complete, No Table
  (5, 46, 2, 0, NULL, NULL, null), -- User 5, Payment 22, complete, No Table
  (1, 47, 2, 0, NULL, NULL, null), -- User 1, Payment 23, complete, No Table
  (2, 48, 2, 0, NULL, NULL, null); -- User 2, payment 24, complete, No Table



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

INSERT INTO item_on_order (
    item_id,
    order_id,
    allow_return,
    discount_amount,
    discount_percent,
    note,
    quantity,
    status
) VALUES
      (1, 1, b'1', NULL, 10, 'Order 1: Margherita Pizza', 10.0, 1),
      (2, 1, b'1', NULL, 0, 'Order 1: Pasta Carbonara', 2.0, 1),
      (5, 1, b'1', NULL, 5, 'Order 1: Classic Burger', 3.0, 1),
      (3, 2, b'1', NULL, 10, 'Order 2: Butter Chicken', 2.0, 1),
      (4, 2, b'1', NULL, 15, 'Order 2: Biryani', 10.0, 1),
      (10, 2, b'0', NULL, 0, 'Order 2: Hummus Plate', 1.0, 1),
      (6, 3, b'1', NULL, 0, 'Order 3: California Roll (Cancelled)', 6.0, 0),
      (7, 3, b'1', NULL, 0, 'Order 3: Tacos (Cancelled)', 7.0, 0),
      (8, 4, b'1', NULL, 5, 'Order 4: Pad Thai', 9.0, 1),
      (9, 4, b'0', NULL, 0, 'Order 4: Coq au Vin', 10.0, 1),
      (11, 5, b'1', NULL, 0, 'Order 5: Ribeye Steak (Pending)', 2.0, 0),
      (12, 6, b'1', NULL, 10, 'Order 6: Grilled Salmon', 4.0, 1),
      (1, 6, b'1', NULL, 5, 'Order 6: Margherita Pizza', 3.0, 1),
      (5, 7, b'1', NULL, 0, 'Order 7: Classic Burger (Cancelled)', 2.0, 0),
      (10, 7, b'1', NULL, 0, 'Order 7: Hummus Plate (Cancelled)', 6.0, 0),
      (2, 8, b'1', NULL, 10, 'Order 8: Pasta Carbonara', 6.0, 1),
      (6, 8, b'1', NULL, 5, 'Order 8: California Roll', 9.0, 1),
      (4, 9, b'1', NULL, 15, 'Order 9: Biryani (Pending)', 1.0, 0),
      (3, 9, b'1', NULL, 5, 'Order 9: Butter Chicken', 8.0, 0),
      (8, 9, b'1', NULL, 0, 'Order 9: Pad Thai', 1.0, 0),
      (9, 10, b'1', NULL, 10, 'Order 10: Coq au Vin', 2.0, 1),
      (1, 10, b'1', NULL, 0, 'Order 10: Margherita Pizza', 4.0, 1),
      (7, 11, b'1', NULL, 0, 'Order 11: Tacos (Pending)', 6.0, 0),
      (5, 11, b'1', NULL, 0, 'Order 11: Classic Burger (Pending)', 8.0, 0),
      (6, 11, b'1', NULL, 0, 'Order 11: California Roll (Pending)', 9.0, 0),
      (10, 12, b'1', NULL, 0, 'Order 12: Hummus Plate', 2.0, 1),
      (2, 12, b'1', NULL, 5, 'Order 12: Pasta Carbonara', 1.0, 1),
      (8, 12, b'1', NULL, 0, 'Order 12: Pad Thai', 2.0, 1),
      (11, 13, b'1', NULL, 0, 'Order 13: Ribeye Steak (Pending)', 5.0, 0),
      (1, 14, b'1', NULL, 10, 'Order 14: Margherita Pizza', 5.0, 1),
      (5, 14, b'1', NULL, 5, 'Order 14: Classic Burger', 6.0, 1);


-- ////////////////////////////////////////////////////////////////////////////////////////////////////
INSERT INTO note (active, content) VALUES
(b'1', 'This is the first note.'),
(b'0', 'This note is inactive.'),
(b'1', 'Remember to check the email.'),
(b'1', 'Prepare the report by Friday.'),
(b'0', 'Draft needs further revisions.'),
(b'1', 'Meeting scheduled at 3 PM.'),
(b'1', 'Follow up with the client tomorrow.'),
(b'0', 'Archived note.'),
(b'1', 'Complete the code review.'),
(b'0', 'This note is no longer relevant.');


INSERT INTO cancel_reason (content) VALUES
('Customer changed their mind'),
('Out of stock'),
('Delivery address issue'),
('Payment failed'),
('Order placed by mistake'),
('Customer requested cancellation'),
('Technical issue with the system'),
('Fraudulent order suspected'),
('Duplicate order'),
('Delivery delay');

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






SELECT `order`.id, `order`.status, `order`.`type`,
payment.net_amount
FROM `order`
LEFT JOIN `table` ON `table`.id = `order`.table_id
JOIN payment ON `order`.payment_id = payment.id
WHERE `order`.status IN (2,5);





-- CALL GET_ORDER_BY_CONDITION("SDA");
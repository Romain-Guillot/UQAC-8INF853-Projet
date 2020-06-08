-- uselful link to generate mock sql data : https://www.mockaroo.com/

-- Role
insert into Role (name, description) 
values ('Membre', 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.');
insert into Role (name, description) 
values ('Secretariat', 'In quis justo.');
insert into Role (name, description) 
values ('Manager', 'Donec dapibus.');
insert into Role (name, description) 
values ('Palfrenier', 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.');

-- Permission
insert into Permission (name, description) 
values ('MANAGE_ROLES', 'Ajout, visualisation, création des rôles.');
insert into Permission (name, description) 
values ('READ_ALL_PROFILES', "Lecture de tous les profils");
insert into Permission (name, description) 
values ('WRITE_ALL_PROFILES', 'Écriture (dont la suppression) des tous les profiles');

-- Assoc role - permission
insert into RolePermissionAssoc (role_name, permission_name) 
values ('Secretariat', 'MANAGE_ROLES');
insert into RolePermissionAssoc (role_name, permission_name) 
values ('Secretariat', 'READ_ALL_PROFILES');
insert into RolePermissionAssoc (role_name, permission_name) 
values ('Secretariat', 'WRITE_ALL_PROFILES');
insert into RolePermissionAssoc (role_name, permission_name) 
values ('Palfrenier', 'READ_ALL_PROFILES');
insert into RolePermissionAssoc (role_name, permission_name) 
values ('Manager', 'MANAGE_ROLES');
insert into RolePermissionAssoc (role_name, permission_name) 
values ('Manager', 'READ_ALL_PROFILES');
insert into RolePermissionAssoc (role_name, permission_name) 
values ('Manager', 'WRITE_ALL_PROFILES');


-- Member
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Yancy', 'Stave', 'manager', '59 Old Gate Alley', '2019-09-04', '2020-04-26', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Manager');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Yancy', 'Stave', 'membre', '59 Old Gate Alley', '2019-09-04', '2020-04-26', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Membre');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Yancy', 'Stave', 'palfrenier', '59 Old Gate Alley', '2019-09-04', '2020-04-26', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Palfrenier');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Maximilian', 'Fenelow', 'mfenelow1@sciencedirect.com', '4 Barnett Court', '2019-09-22', '2019-06-06', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Membre');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Trudey', 'Ashe', 'tashe2@printfriendly.com', '95 Twin Pines Street', '2019-09-08', '2020-03-06', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Palfrenier');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Shel', 'Mollett', 'smollett3@admin.ch', '1 Monica Lane', '2020-01-06', '2020-04-20', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Membre');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Binny', 'Cockrem', 'bcockrem4@miibeian.gov.cn', '67213 Harbort Pass', '2019-06-03', '2019-12-02', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Secretariat');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Amii', 'Rousell', 'arousell5@ebay.com', '8 Barnett Road', '2019-11-12', '2019-08-08', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Manager');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Adham', 'Cafe', 'acafe6@creativecommons.org', '43 Badeau Street', '2019-11-18', '2020-04-13', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Secretariat');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Davey', 'Stafford', 'dstafford7@slate.com', '19 Mosinee Crossing', '2019-06-08', '2020-01-24', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Membre');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Blinny', 'Venart', 'bvenart8@google.com', '2797 Elka Street', '2019-10-11', '2020-04-04', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Palfrenier');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Eddi', 'Penner', 'epenner9@europa.eu', '2 Lindbergh Point', '2019-11-14', '2019-08-09', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Palfrenier');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Queenie', 'Tanswill', 'qtanswilla@bravesites.com', '76875 Sauthoff Circle', '2020-03-25', '2019-10-15', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Secretariat');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Davy', 'Oylett', 'doylettb@mac.com', '90214 Cascade Avenue', '2020-05-28', '2019-07-09', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Palfrenier');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Dunstan', 'Pigford', 'dpigfordc@twitpic.com', '069 Parkside Junction', '2019-10-25', '2019-06-05', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Palfrenier');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Calypso', 'Hof', 'chofd@angelfire.com', '3727 Milwaukee Parkway', '2020-02-21', '2019-12-13', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Secretariat');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Malva', 'Moulton', 'mmoultone@studiopress.com', '69669 Oak Valley Street', '2019-06-05', '2019-06-22', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Manager');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Rogers', 'Gabbatt', 'rgabbattf@devhub.com', '5 Gulseth Terrace', '2020-05-23', '2020-03-30', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Membre');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Schuyler', 'Josselson', 'sjosselsong@cbc.ca', '214 5th Drive', '2019-11-04', '2019-06-24', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Manager');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Chalmers', 'Lampet', 'clampeth@tiny.cc', '0 Hintze Junction', '2020-01-19', '2020-04-20', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Membre');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Datha', 'Sturror', 'dsturrori@usda.gov', '17 Kings Junction', '2020-01-28', '2020-05-18', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Membre');
insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Benjamen', 'Lowsely', 'blowselyj@businesswire.com', '13 Mcguire Pass', '2020-01-12', '2019-09-08', '$2b$10$57dglqmOwykrxHAkJREIJOWExyu/modCO3kS4ryV/l0EWEJZZimbm', 'Palfrenier');

-- Horse
insert into Horse (name, birth_date, profile_member_id) 
values ('Zac', '2004-08-08', 1);
insert into Horse (name, birth_date, profile_member_id) 
values ('Tempete', '2003-02-09', 1);
insert into Horse (name, birth_date, profile_member_id) 
values ('Atila', '2005-11-04', 2);
insert into Horse (name, birth_date, profile_member_id) 
values ('Zeus', '2008-06-12', 2);
insert into Horse (name, birth_date, profile_member_id) 
values ('Tonerre', '2006-08-11', 2);
insert into Horse (name, birth_date, profile_member_id) 
values ('Rose', '2002-02-10', 3);


-- Equipment
insert into Equipment (type, model, price, profile_member_id) 
values ('Saddle', 'Selle Horze - 41', 10, 1);
insert into Equipment (type, model, price, profile_member_id) 
values ('Saddle', 'Selle Pagony - EA3', 10, 1);
insert into Equipment (type, model, price, profile_member_id) 
values ('Stirrups', 'Étriers Waldhausen 2018', 10.5, 1);
insert into Equipment (type, model, price, profile_member_id) 
values ('Stirrups', 'Étriers Waldhausen 2016', 9, 1);
insert into Equipment (type, model, price, profile_member_id) 
values ('Reins', 'Rênes CAMDGE 2015', 20, 1);
insert into Equipment (type, model, price, profile_member_id) 
values ('Bit', 'Mort Hkm - RSA 330', 10, 1);
insert into Equipment (type, model, price, profile_member_id) 
values ('Bit', 'Mort Br 18', 15, 1);

-- Booking

insert into Booking(profile_id, resource_id, begin, end) values (6, 2, '2019-10-14', '2019-12-03');
insert into Booking(profile_id, resource_id, begin, end) values (20, 2, '2019-06-19', '2020-04-07');
insert into Booking(profile_id, resource_id, begin, end) values (19, 5, '2019-06-09', '2019-09-07');
insert into Booking(profile_id, resource_id, begin, end) values (18, 4, '2019-12-12', '2020-04-30');
insert into Booking(profile_id, resource_id, begin, end) values (11, 4, '2019-07-18', '2019-09-12');
insert into Booking(profile_id, resource_id, begin, end) values (4, 3, '2019-10-30', '2020-05-19');
insert into Booking(profile_id, resource_id, begin, end) values (9, 1, '2019-08-15', '2019-12-10');
insert into Booking(profile_id, resource_id, begin, end) values (13, 3, '2019-11-30', '2020-05-21');
insert into Booking(profile_id, resource_id, begin, end) values (18, 4, '2019-12-27', '2019-12-02');
insert into Booking(profile_id, resource_id, begin, end) values (3, 4, '2019-10-13', '2020-01-30');
insert into Booking(profile_id, resource_id, begin, end) values (1, 5, '2019-05-01', '2020-04-30');
insert into Booking(profile_id, resource_id, begin, end) values (18, 3, '2019-08-07', '2019-06-13');
insert into Booking(profile_id, resource_id, begin, end) values (15, 5, '2019-09-05', '2020-05-14');
insert into Booking(profile_id, resource_id, begin, end) values (8, 4, '2019-04-18', '2020-01-25');
insert into Booking(profile_id, resource_id, begin, end) values (17, 2, '2019-11-03', '2019-10-13');
insert into Booking(profile_id, resource_id, begin, end) values (7, 3, '2020-04-26', '2019-11-09');
insert into Booking(profile_id, resource_id, begin, end) values (13, 2, '2020-03-18', '2020-03-02');
insert into Booking(profile_id, resource_id, begin, end) values (16, 3, '2020-03-10', '2019-10-31');
insert into Booking(profile_id, resource_id, begin, end) values (1, 5, '2019-04-25', '2020-02-22');
insert into Booking(profile_id, resource_id, begin, end) values (5, 5, '2020-03-10', '2019-11-16');
insert into Booking(profile_id, resource_id, begin, end) values (9, 5, '2019-11-21', '2020-05-04');
insert into Booking(profile_id, resource_id, begin, end) values (4, 4, '2020-02-09', '2019-07-11');
insert into Booking(profile_id, resource_id, begin, end) values (5, 1, '2019-07-10', '2020-01-05');
insert into Booking(profile_id, resource_id, begin, end) values (16, 4, '2019-09-06', '2019-10-09');
insert into Booking(profile_id, resource_id, begin, end) values (11, 2, '2019-04-04', '2019-11-30');
insert into Booking(profile_id, resource_id, begin, end) values (17, 4, '2019-11-23', '2019-06-14');
insert into Booking(profile_id, resource_id, begin, end) values (2, 1, '2020-01-16', '2019-11-17');
insert into Booking(profile_id, resource_id, begin, end) values (13, 2, '2019-05-14', '2020-04-25');
insert into Booking(profile_id, resource_id, begin, end) values (15, 3, '2019-09-14', '2020-01-26');
insert into Booking(profile_id, resource_id, begin, end) values (5, 2, '2019-06-24', '2019-10-28');
insert into Booking(profile_id, resource_id, begin, end) values (14, 4, '2020-05-03', '2019-07-15');
insert into Booking(profile_id, resource_id, begin, end) values (17, 1, '2019-05-30', '2020-01-02');
insert into Booking(profile_id, resource_id, begin, end) values (8, 4, '2019-07-16', '2019-06-04');
insert into Booking(profile_id, resource_id, begin, end) values (2, 1, '2019-06-30', '2019-06-14');
insert into Role (name, description) 
values ('Membre', 'Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis. Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.');
insert into Role (name, description) 
values ('Secretariat', 'In quis justo.');
insert into Role (name, description) 
values ('Manager', 'Donec dapibus.');
insert into Role (name, description) 
values ('Palfrenier', 'Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.');


insert into Permission (name, description) 
values ('MANAGE_ROLES', 'Donec dapibus. Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo. Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis. Sed ante.');
insert into Permission (name, description) 
values ('READ_ALL_PROFILES', null);
insert into Permission (name, description) 
values ('WRITE_ALL_PROFILES', 'Aenean sit amet justo.');


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


insert into ProfileMember (first_name, last_name, email, postal_address, birth_date, register_at, passwd, role_name) 
values ('Yancy', 'Stave', 'ystave0@mapy.cz', '59 Old Gate Alley', '2019-09-04', '2020-04-26', '$2a$12$eIFOisxQG4MM3XXs6GuTveQ8pITJqRX4HN9AuWKdfRiDqyE1Zoo/y', 'Palfrenier');
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


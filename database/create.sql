DROP TABLE IF EXISTS ManagerMember;
DROP TABLE IF EXISTS AdministatorMember;
DROP TABLE IF EXISTS ProfileMember;
DROP TABLE IF EXISTS RolePermissionAssoc;
DROP TABLE IF EXISTS Permission;
DROP TABLE IF EXISTS Horse;
DROP TABLE IF EXISTS Equipment;
DROP TABLE IF EXISTS Role;



CREATE TABLE Role (
    name VARCHAR(255) NOT NULL,
    description TEXT,
    PRIMARY KEY (name)
);

CREATE TABLE Permission (
    name VARCHAR(255) NOT NULL,
    description TEXT,
    PRIMARY KEY (name)
);

CREATE TABLE RolePermissionAssoc (
    role_name VARCHAR(255) NOT NULL,
    permission_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (role_name, permission_name),
    FOREIGN KEY (role_name) REFERENCES Role(name) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (permission_name) REFERENCES Permission(name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE ProfileMember (
    profile_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    postal_address VARCHAR(255),
    birth_date DATE,
    register_at DATE,
    role_name VARCHAR(255),
    passwd VARCHAR(255),
    PRIMARY KEY (profile_id),
    FOREIGN KEY (role_name) REFERENCES Role(name) ON DELETE SET NULL ON UPDATE CASCADE,
    UNIQUE(email)
);

CREATE TABLE AdministatorMember (
    admin_id INT NOT NULL AUTO_INCREMENT,
    profile_id INT NOT NULL,
    PRIMARY KEY (admin_id),
    FOREIGN KEY (profile_id) REFERENCES ProfileMember(profile_id) ON DELETE CASCADE
);

CREATE TABLE ManagerMember (
    manager_id INT NOT NULL AUTO_INCREMENT,
    admin_id INT NOT NULL,
    PRIMARY KEY (manager_id),
    FOREIGN KEY (admin_id) REFERENCES AdministatorMember(admin_id) ON DELETE CASCADE
);

CREATE TABLE Horse (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    birth_date  DATE,
    profile_member_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (profile_member_id) REFERENCES ProfileMember(profile_id) ON DELETE SET NULL
);

CREATE TABLE Equipment (
    id INT NOT NULL AUTO_INCREMENT,
    type VARCHAR(255),
    model VARCHAR(255),
    price FLOAT,
    profile_member_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (profile_member_id) REFERENCES ProfileMember(profile_id) ON DELETE SET NULL
);

CREATE TABLE Booking (
    booking_id INT NOT NULL AUTO_INCREMENT,
    profile_id INT,
    resource_id INT NOT NULL,
    begin DATE NOT NULL,
    end DATE NOT NULL,
    PRIMARY KEY (booking_id),
    FOREIGN KEY (profile_id) REFERENCES ProfileMember(profile_id) ON DELETE SET NULL, 
    FOREIGN KEY (resource_id) REFERENCES Horse(id) ON DELETE CASCADE
);
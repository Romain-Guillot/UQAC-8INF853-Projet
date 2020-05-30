DROP TABLE IF EXISTS ManagerMember;
DROP TABLE IF EXISTS AdministatorMember;
DROP TABLE IF EXISTS ProfileMember;
DROP TABLE IF EXISTS RolePermissionAssoc;
DROP TABLE IF EXISTS Permission;
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
    FOREIGN KEY (role_name) REFERENCES Role(name) ON DELETE CASCADE,
    FOREIGN KEY (permission_name) REFERENCES Permission(name)
);

CREATE TABLE ProfileMember (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    postal_address VARCHAR(255),
    birth_date DATE,
    register_at DATE,
    role_name VARCHAR(255),
    passwd VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (role_name) REFERENCES Role(name),
    UNIQUE(email)
);

CREATE TABLE AdministatorMember (
    id INT NOT NULL AUTO_INCREMENT,
    profile_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (profile_id) REFERENCES ProfileMember(id)
);

CREATE TABLE ManagerMember (
    id INT NOT NULL AUTO_INCREMENT,
    admin_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (admin_id) REFERENCES AdministatorMember(id)
);


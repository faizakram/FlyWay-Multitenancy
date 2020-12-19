CREATE TABLE car
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255),
    color  VARCHAR(255)
);

CREATE TABLE `enum_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO enum_master (id,code,name) VALUES
	 (1,'USER','User');
	 
CREATE TABLE `enum_item_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enum_id` int(11) NOT NULL,
  `code` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `enum_item_master_UN` (`enum_id`,`code`),
  CONSTRAINT `enum_item_master_FK` FOREIGN KEY (`enum_id`) REFERENCES `enum_master` (`id`)
);

INSERT INTO enum_item_master (id,enum_id,code,name) VALUES
	 (1,1,'ACTIVE','Active'),
	 (2,1,'INACTIVE','Inactive'),
	 (3,1,'LOCKED','Locked'),
	 (4,1,'EMAIL_VERIFICATION_PENDING','Email Verification Pending');
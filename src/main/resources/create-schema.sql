CREATE TABLE POST(
  ID INT PRIMARY KEY AUTO_INCREMENT,
  CONTENT VARCHAR (140),
  AUTHOR varchar_ignorecase(50) not null,

);

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `role` VALUES (1,'ROLE_USER');

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  CONSTRAINT `fk_user_role_roleid` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `LIKES` (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  POST_ID INT not null,
  AUTHOR_ID INT not null,
  UNIQUE (POST_ID, AUTHOR_ID),
  constraint fk_like_post foreign key(POST_ID) references POST(ID),
  constraint fk_like_user foreign key(AUTHOR_ID) references user(id)
);

CREATE TABLE `COMMENT` (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  POST_ID INT not null,
  AUTHOR_ID INT not null,
  CONTENT VARCHAR(255),
  constraint fk_comment_post foreign key(POST_ID) references POST(ID),
  constraint fk_comment_user foreign key(AUTHOR_ID) references user(id)
);

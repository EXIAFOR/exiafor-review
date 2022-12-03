CREATE TABLE `t_emp`
(
    `emp_id`   int(11) NOT NULL AUTO_INCREMENT,
    `emp_name` varchar(20) DEFAULT NULL,
    `age`      int(11)     DEFAULT NULL,
    `sex`      char(1)     DEFAULT NULL,
    `email`    varchar(50) DEFAULT NULL,
    PRIMARY KEY (`emp_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
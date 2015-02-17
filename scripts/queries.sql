DROP PROCEDURE IF EXISTS sp_InsertUser;
DELIMITER //
CREATE PROCEDURE sp_InsertUser(IN param_fname VARCHAR(45), IN param_lname VARCHAR(45), 
							   IN param_email VARCHAR(100), IN param_password VARCHAR(100),
							   IN param_country VARCHAR(50), IN param_status INT(1),
							   IN param_credit INT(11), IN param_companyid INT(11)
							   )
	BEGIN
		DECLARE tmp_current_time VARCHAR(15);
		
		SELECT UNIX_TIMESTAMP() INTO tmp_current_time;
	
		INSERT INTO user(firstname, lastname, email, pword, country, status, credit, companyid, lastmodified) 
				VALUES(param_fname, param_lname, param_email, param_password, param_country, 
						param_status, param_credit, param_companyid, tmp_current_time);
	END//
DELIMITER ;

call sp_InsertUser('siva','natarajan', 'nbsiva90@gmail.com', 'password','India', 1, 1,1);
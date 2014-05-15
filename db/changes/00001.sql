CREATE TABLE user_account (
   id 				INT NOT NULL AUTO_INCREMENT,
   username			VARCHAR(125) NOT NULL,
   password			VARCHAR(125) NOT NULL,
   email			VARCHAR(125),
   first_name		VARCHAR(125),
   last_name		VARCHAR(125),
   PRIMARY KEY (id)
);
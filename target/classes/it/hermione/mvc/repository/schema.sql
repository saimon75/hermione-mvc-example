CREATE TABLE products (
  ID INT NOT NULL AUTO_INCREMENT
  , description varchar(255)
  , price decimal(15,2)
  , PRIMARY KEY (ID)
);

CREATE INDEX products_description ON products(description);
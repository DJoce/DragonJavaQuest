CREATE DATABASE javaquest;
USE javaquest;

CREATE TABLE player (
id INT(10) NOT NULL AUTO_INCREMENT,
nom VARCHAR(15),
pdv INT(10),
pdvMax INT(10),
frc INT(10),
dfs INT(10),
nv INT(10),
xp INT(10),
gold INT(10),
startdate DATE,
PRIMARY KEY (id)
);

CREATE TABLE monster (
id INT(10) NOT NULL AUTO_INCREMENT,
nom VARCHAR(15),
pdv INT(10),
pdvMax INT(10),
frc INT(10),
dfs INT(10),
nv INT(10),
xp INT(10),
gold INT(10),
PRIMARY KEY (id)
);

INSERT INTO monster (nom, pdv, pdvMax, frc, dfs, nv, xp, gold)  VALUES
("Goule", 100, 100, 15, 15, 1, 30, 50),
("Momie", 200, 200, 20, 30, 2, 50, 150),
("Dragon", 500, 500, 50, 40, 5, 80, 400),
("Kraken", 1000, 1000, 80, 1, 10, 200, 1000),
("Pikachu", 1500, 1500, 15, 15, 20, 30, 50);

INSERT INTO player (nom, pdv, pdvMax, frc, dfs, nv, xp, gold, startdate) VALUES
("JB", 100, 100, 20, 10, 1, 0, 50, '2017-01-03');
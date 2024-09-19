SHOW databases;
USE countries;
SHOW tables;
DESC countries;
INSERT INTO countries VALUES (1,'Italy', 'Rome',62000000, 900000, 'IT');
INSERT INTO countries VALUES (NULL,'Germany', 'Berlin',87000000, 700000, 'DE');
INSERT INTO countries (name, captial, iso) VALUES 
	('Austria', 'Vienna', 'AT');
INSERT INTO countries (name, captial, iso, inhabitance) VALUES 
	('Rumania', 'Bukarest', 'RU', '500000');
INSERT INTO countries (name, captial, iso, area) VALUES 
	('Croatia', 'Zagreb', 'HR', 320000);
SELECT * FROM countries;
SELECT Count(*) FROM countries;
DELETE FROM countries WHERE id = 3;
SELECT * FROM countries WHERE inhabitance > 50000000;
SELECT name, captial FROM countries WHERE name Like 'G%';
SELECT Count(*) FROM countries;
SELECT captial FROM countries;
SELECT name FROM countries ORDER BY inhabitance DESC LIMIT 1;
SELECT area FROM countries ORDER BY area DESC LIMIT 1;
SELECT min(area) FROM countries;
SELECT avg(area) FROM countries;
SELECT sum(area) FROM countries;
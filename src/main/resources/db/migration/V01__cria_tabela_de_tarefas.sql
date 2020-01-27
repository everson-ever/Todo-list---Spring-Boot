CREATE TABLE tasks(
	
	id SERIAL NOT NULL,
	title VARCHAR(50),
	description VARCHAR(255)
);

INSERT INTO tasks(title, description)
VALUES('Spring Boot', 'Estudar para o estágio'),
	  ('Angular Reativo', 'Estudar uma biblioteca para reatividade');
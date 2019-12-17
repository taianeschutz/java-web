DROP TABLE IF EXISTS Jogador;

CREATE TABLE Jogador(
Id INT AUTO_INCREMENT, 
Nome VARCHAR(255),
Idade INT,
Ativo BOOL,
Nascimento DATE,
idClube INT NOT NULL,
PRIMARY KEY(Id),
FOREIGN KEY(idClube) REFERENCES Clube(Id)
);

DROP TABLE IF EXISTS Clube;

CREATE TABLE Clube(
Id INT AUTO_INCREMENT, 
Nome VARCHAR(255) DEFAULT 'Brasil',
Ativo BOOL DEFAULT true,
Fundacao DATE NOT NULL,
PRIMARY KEY(Id),
);

INSERT INTO Clube (Nome, Ativo, Fundacao) VALUES 
('Brasil', true, '1914-06-08'),
('USA', true, '1985-08-18');

SELECT * FROM Clube;

SELECT * FROM Jogador INNER JOIN Clube ON Jogador.idClube = Clube.Id;

SELECT Jogador.Nome, Idade, Jogador.Ativo, Nascimento, Clube.Nome, Clube.Ativo, Fundacao
FROM Jogador INNER JOIN Clube ON Jogador.idClube = Clube.Id;

INSERT INTO Jogador (Nome, Idade, Ativo, Nascimento, idClube) 
VALUES ('Marta', 34, true, '1986-02-19', 1);

INSERT INTO Jogador (Nome, Idade, Ativo, Nascimento, idClube) VALUES 
('Megan', 34, true, '1985-07-05', 2),
('Pelé', 79, false, '1940-10-23', 1),
('Cristiane', 34, true, '1985-05-15', 1),
('Hope', 38, false, '1981-07-21', 2);

SELECT COUNT(Jogador.Id) FROM Jogador GROUP BY idClube;

SELECT * FROM Jogador ORDER BY Nome ASC;
SELECT * FROM Jogador ORDER BY Nome DESC;

SELECT * FROM Jogador;

SELECT * FROM Jogador WHERE Ativo = true;

UPDATE Jogador SET Ativo = false WHERE Nome = 'Marta';

DELETE FROM Jogador WHERE Nome = 'Pelé';

SELECT * FROM Jogador ORDER BY Nome DESC;

SELECT * FROM Jogador ORDER BY Nome ASC;
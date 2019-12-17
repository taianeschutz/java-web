DROP TABLE IF EXISTS
CREATE TABLE Jogador( 
Id INT PRIMARY KEY, 
Nome VARCHAR(255), 
Idade INT, 
Ativo BOOL, 
Nascimento DATE 
);
INSERT INTO Jogador (id, Nome, Idade, Ativo, Nascimento) VALUES (1, 'Marta', 34, true, '1986-02-19');
INSERT INTO Jogador (id, Nome, Idade, Ativo, Nascimento) VALUES (2, 'Pelé', 79, false, '1940-10-23');

SELECT * FROM Jogador;

SELECT * FROM Jogador WHERE Ativo = true;
UPDATE Jogador SET Ativo = false WHERE Nome = 'Marta';
SELECT * FROM Jogador;
DELETE FROM Jogador WHERE Nome = 'Pelé';
SELECT * FROM Jogador;
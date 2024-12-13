-- Active: 1732054264391@@127.0.0.1@3306@sistemabibliotecario
-- Criar o banco de dados
CREATE DATABASE Biblioteca DEFAULT CHARACTER SET = 'utf8mb4';



-- Tabela Usuario (superclasse para Leitor, Bibliotecario e LoginAdm)
CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15),
    dataCadastro DATE NOT NULL,
    tipo ENUM('leitor', 'bibliotecario') NOT NULL
);

-- Tabela Multa (relacionada com Usuario)
CREATE TABLE Multa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuarioId INT NOT NULL,
    valor DOUBLE NOT NULL,
    dataMulta DATE NOT NULL,
    status ENUM('pendente', 'pago') DEFAULT 'pendente',
    FOREIGN KEY (usuarioId) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Tabela LoginAdm (herda Usuario)
CREATE TABLE LoginAdm (
    id INT PRIMARY KEY,
    senha VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id)
);

-- Tabela Categoria
CREATE TABLE Categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    descricao TEXT,
    dataCadastro DATE NOT NULL
);

-- Tabela Livro (relacionada com Categoria)
CREATE TABLE Livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    categoriaId INT NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    anoPublicacao INT,
    disponivel BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (categoriaId) REFERENCES Categoria(id) 
);

-- Tabela Emprestimo (relacionada com Usuario e Livro)
CREATE TABLE Emprestimo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    livroId INT NOT NULL,
    usuarioId INT NOT NULL,
    dataEmprestimo DATE NOT NULL,
    dataDevolucao DATE,
    disponivel BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (livroId) REFERENCES Livro(id) ON DELETE CASCADE,
    FOREIGN KEY (usuarioId) REFERENCES Usuario(id) ON DELETE CASCADE
);

-- Tabela Bibliotecario (herda Usuario)
CREATE TABLE Bibliotecario (
    id INT PRIMARY KEY,
    setor VARCHAR(50) NOT NULL,
    turno VARCHAR(20) NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id)
);

-- Tabela Leitor (herda Usuario, armazena devolução e multas pendentes)
CREATE TABLE Leitor (
    id INT PRIMARY KEY,
    dataDevolucao DATE,
    FOREIGN KEY (id) REFERENCES Usuario(id)
);

ALTER TABLE Categoria ADD livroId INT;
ALTER TABLE Categoria ADD CONSTRAINT fk_livro_categoria FOREIGN KEY (livroId) REFERENCES Livro(id) ON DELETE CASCADE;
ALTER TABLE categoria DROP FOREIGN KEY fk_livro_categoria;
ALTER TABLE categoria MODIFY COLUMN livroId INT NULL;
ALTER TABLE livro DROP FOREIGN KEY livro_ibfk_1;
ALTER TABLE livro CHANGE categoriaId categoria_nome VARCHAR(100);
ALTER TABLE categoria ADD UNIQUE(nome);
ALTER TABLE livro 
ADD CONSTRAINT fk_categoria_nome 
FOREIGN KEY (categoria_nome) REFERENCES categoria(nome);


-- Inserir livros Banco de Dados
INSERT INTO livro (titulo, autor, categoria_nome, isbn, anoPublicacao, disponivel) VALUES
('Duna', 'Frank Herbert', 'Ficção Científica', '9780441013593', 1965, true),
('Fundação', 'Isaac Asimov', 'Ficção Científica', '9780553293357', 1951, true),
('O Senhor dos Anéis', 'J.R.R. Tolkien', 'Fantasia', '9780261102385', 1954, true),
('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', 'Fantasia', '9780747532743', 1997, true),
('Orgulho e Preconceito', 'Jane Austen', 'Romance', '9780141199078', 1813, true),
('O Grande Gatsby', 'F. Scott Fitzgerald', 'Romance', '9780743273565', 1925, true),
('It: A Coisa', 'Stephen King', 'Terror', '9781501111743', 1986, true),
('O Exorcista', 'William Peter Blatty', 'Terror', '9780061007226', 1971, true),
('O Hobbit', 'J.R.R. Tolkien', 'Fantasia', '9780345339683', 1937, true),
('O Código Da Vinci', 'Dan Brown', 'Suspense', '9780307474278', 2003, true),
('1984', 'George Orwell', 'Suspense', '9780451524935', 1949, true),
('Os Miseráveis', 'Victor Hugo', 'História', '9780140444308', 1862, true),
('O Príncipe', 'Nicolau Maquiavel', 'Filosofia', '9788572324107', 1532, true),
('O Poder do Hábito', 'Charles Duhigg', 'Autoajuda', '9788539004581', 2012, true),
('Pense Simples', 'Gustavo Cerbasi', 'Negócios', '9788545208095', 2015, true),
('O Segredo', 'Rhonda Byrne', 'Autoajuda', '9788539002532', 2006, true),
('A Arte da Guerra', 'Sun Tzu', 'Filosofia', '9788572320109', 500, true),
('O Universo numa Casca de Noz', 'Stephen Hawking', 'Ciências Exatas', '9788539001931', 2001, true),
('A Origem das Espécies', 'Charles Darwin', 'Ciências Exatas', '9788535914732', 1859, true),
('O Homem que Calculava', 'Malba Tahan', 'Ciências Exatas', '9788520913127', 1930, true),
('Como Fazer Amigos e Influenciar Pessoas', 'Dale Carnegie', 'Negócios', '9788535200280', 1936, true),
('A Revolução dos Bichos', 'George Orwell', 'Suspense', '9780451526342', 1945, true),
('O Mundo de Sofia', 'Jostein Gaarder', 'Filosofia', '9788501081922', 1991, true),
('Meditações', 'Marco Aurélio', 'Filosofia', '9788525420159', 180, true),
('O Alquimista', 'Paulo Coelho', 'Romance', '9780061122415', 1988, true),
('O Caçador de Pipas', 'Khaled Hosseini', 'Romance', '9780385667214', 2003, true),
('A Culpa é das Estrelas', 'John Green', 'Romance', '9780141345659', 2012, true),
('O Cemitério', 'Stephen King', 'Terror', '9781501136248', 1983, true),
('O Iluminado', 'Stephen King', 'Terror', '9780385121675', 1977, true),
('O Príncipe das Sombras', 'Robin Hobb', 'Fantasia', '9780451452631', 1995, true),
('Percy Jackson e os Olimpianos', 'Rick Riordan', 'Fantasia', '9781423142483', 2005, true);


--Inserir um usuario para obter dados para login
INSERT INTO Usuario (nome, email, telefone, dataCadastro, tipo) 
VALUES ('admin', 'admin@example.com', '123456789', CURDATE(), 'bibliotecario');

--Ajustar tabela login 
ALTER TABLE LoginAdm DROP FOREIGN KEY LoginAdm_ibfk_1;
ALTER TABLE LoginAdm
    ADD COLUMN nome VARCHAR(100) NOT NULL;
CREATE INDEX idx_nome_usuario ON Usuario(nome);
ALTER TABLE LoginAdm
    ADD CONSTRAINT FK_LoginAdm_Nome FOREIGN KEY (nome) REFERENCES Usuario(nome);
ALTER TABLE LoginAdm 
MODIFY COLUMN id INT AUTO_INCREMENT;

--Incluir user de login
INSERT INTO LoginAdm (nome, senha) 
VALUES ('admin', 'admin');

ALTER TABLE bibliotecario DROP FOREIGN KEY bibliotecario_ibfk_1;
ALTER TABLE bibliotecario
    ADD COLUMN nome VARCHAR(100) NOT NULL;
ALTER TABLE bibliotecario
    ADD CONSTRAINT FK_bibliotecario_Nome FOREIGN KEY (nome) REFERENCES Usuario(nome);
ALTER TABLE bibliotecario 
MODIFY COLUMN id INT AUTO_INCREMENT;
ALTER TABLE bibliotecario
ADD COLUMN senha VARCHAR(255);

--Incluir bibliotecario
INSERT INTO bibliotecario (setor, turno, nome, senha) 
VALUES ('administrativo', 'Matutino', 'admin', 'admin');

--Correção tabela categoria 
ALTER TABLE categoria RENAME COLUMN nome TO categoria_nome;

--Consultas
SELECT * FROM livro WHERE id = 1;
SELECT * FROM usuario WHERE id = 6;

-- Ajustes tabela multa
INSERT INTO multa (usuarioId, valor, dataMulta, status) 
VALUES (1, 10.00, '2024-11-22', 'pendente');
ALTER TABLE multa MODIFY status ENUM('pendente', 'pago') NOT NULL DEFAULT 'pendente';
SELECT id FROM Usuario WHERE id = 5;
SELECT id FROM Usuario WHERE id = 8;
INSERT INTO Multa (usuarioId, valor, dataMulta) 
VALUES (5, 25.45, '2024-11-22');
SELECT * FROM Multa WHERE usuarioId NOT IN (SELECT id FROM Usuario);


ALTER TABLE usuario AUTO_INCREMENT = 2;
ALTER TABLE emprestimo AUTO_INCREMENT =1 ;
ALTER TABLE multa AUTO_INCREMENT = 1;


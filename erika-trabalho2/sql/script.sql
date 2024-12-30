create table livro(
	id bigint auto_increment primary key unique,
    isbn varchar(80) unique,
    titulo varchar(100),
    edicao varchar(100),
    publicacao varchar(100),
    decricao varchar(120)
    
);
create table cliente(
	id bigint auto_increment primary key unique,
    nome varchar(100) not null unique,
    idade varchar(50) unique
);


create table fornecedor(
	id bigint auto_increment primary key unique,
    nome varchar(100) not null,
    cnpj varchar(100) not null,
    telefone varchar(9) not null
);
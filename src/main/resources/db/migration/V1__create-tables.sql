create table medicos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    telefone varchar(20) not null,
    ativo tinyint not null,

    primary key(id)

);

create table pacientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    cpf varchar(14) not null unique,
    logradouro varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    telefone varchar(20) not null,
    ativo tinyint not null,

    primary key(id)

);

create table usuarios(

    id bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(255) not null,

    primary key(id)
);

create table consultas(
    id bigint not null auto_increment,
    medico_id bigint not null,
    paciente_id bigint not null,
    data date not null,
    hora time not null,

    primary key(id),
    constraint fk_consultas_medico foreign key(medico_id) references medicos(id),
    constraint fk_consultas_paciente foreign key(paciente_id) references pacientes(id)
);
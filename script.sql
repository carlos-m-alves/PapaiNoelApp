drop table evento_carta;
drop table evento;
drop table carta_padrinho;
drop table instituicao_carta;
drop table carta;
drop table brinquedo;
drop table tipo_brinquedo;
drop table endereco_crianca;
drop table crianca;
drop table instituicao;
drop table pessoa;
drop table empresa;
drop table padrinho;
drop table funcionario;
drop table usuario;
drop table agencia;
drop table endereco;
drop table bairro;
drop table cidade;


CREATE TABLE cidade(
 id_cidade serial primary key
 ,nome_cidade varchar(50) NOT NULL 
);

CREATE TABLE bairro(
 id_bairro serial primary key
 ,id_cidade integer REFERENCES cidade (id_cidade)
 ,nome_bairro varchar(50) NOT NULL 
);

CREATE TABLE endereco(
 id_endereco serial primary key
 ,rua varchar(100) NOT NULL 
 ,numero integer NOT NULL 
 ,complemento varchar(100)
 ,cep varchar(10) NOT NULL 
 ,id_bairro integer REFERENCES bairro (id_bairro)
);

CREATE TABLE agencia(
 id_agencia serial primary key
 ,nome_agencia varchar(100)
 ,id_endereco integer REFERENCES endereco (id_endereco)
);

CREATE TABLE usuario(
 id_usuario serial primary key
 ,email varchar(50) NOT NULL 
 ,senha varchar(255) NOT NULL 
 ,permissao varchar(30) CHECK (permissao SIMILAR TO 'PADRINHO|FUNCIONARIO') NOT NULL 
 ,ccpf_cnpj varchar(50) NOT NULL 
 ,telefone varchar(30)
);

CREATE TABLE funcionario(
 id_funcionario integer REFERENCES usuario (id_usuario)
 ,id_agencia integer REFERENCES agencia (id_agencia)
 ,primary key(id_funcionario)
);

CREATE TABLE padrinho(
 id_padrinho integer REFERENCES usuario (id_usuario)
 ,primary key(id_padrinho)
);

CREATE TABLE empresa(
 id_empresa integer REFERENCES padrinho (id_padrinho)
 ,nome_empresa varchar(50) NOT NULL 
 ,id_endereco integer REFERENCES endereco (id_endereco)
 ,primary key(id_empresa)
);

CREATE TABLE pessoa(
 id_pessoa integer REFERENCES padrinho (id_padrinho)
 ,nome varchar(50) NOT NULL 
 ,sexo varchar(1) CHECK (sexo SIMILAR TO 'H|F') NOT NULL 
 ,primary key(id_pessoa)
);



CREATE TABLE instituicao(
 id_instituicao serial primary key
 ,nome_instituicao varchar(100) NOT NULL 
 ,telefone varchar(30) NOT NULL 
 ,id_endereco integer REFERENCES endereco (id_endereco)
);

CREATE TABLE crianca(
 id_crianca serial primary key
 ,nome_crianca varchar(50) NOT NULL 
 ,idade integer 
);

CREATE TABLE endereco_crianca(
 id_crianca integer REFERENCES crianca (id_crianca)
 ,id_endereco integer REFERENCES endereco (id_endereco)
 ,primary key(id_crianca)
);

CREATE TABLE tipo_brinquedo(
 id_tipo_brinquedo serial primary key
 ,nome_tipo_brinquedo varchar(100) NOT NULL 
);

CREATE TABLE brinquedo(
 id_brinquedo serial primary key
 ,nome_brinquedo varchar(100) NOT NULL 
 ,id_tipo_brinquedo integer REFERENCES tipo_brinquedo (id_tipo_brinquedo)
);

CREATE TABLE carta(
 id_carta serial primary key
 ,descricao varchar(255) NOT NULL 
 ,id_brinquedo integer REFERENCES brinquedo (id_brinquedo)
 ,id_crianca integer REFERENCES crianca (id_crianca)
);

CREATE TABLE instituicao_carta(
 id_carta integer REFERENCES carta (id_carta)
 ,id_instituicao integer REFERENCES instituicao (id_instituicao)
 ,primary key(id_carta)
);

CREATE TABLE carta_padrinho(
 dt_apadrinhamento date NOT NULL
 ,entregue boolean NOT NULL 
 ,id_padrinho integer REFERENCES padrinho (id_padrinho)
 ,id_carta integer REFERENCES carta (id_carta)
 ,primary key(id_padrinho,id_carta)
);

CREATE TABLE evento(
 id_evento serial primary key
 ,nome_evento varchar(100) NOT NULL
 ,dt_evento date NOT NULL 
 ,id_endereco integer REFERENCES endereco (id_endereco)
 ,id_empresa integer REFERENCES empresa (id_empresa)
);

CREATE TABLE evento_carta(
 id_evento integer REFERENCES evento (id_evento)
 ,id_carta integer REFERENCES carta (id_carta)
 ,primary key(id_evento,id_carta)
);


insert into cidade (nome_cidade) values ('Curitiba');

insert into bairro (id_cidade,nome_bairro) values (1,'Abranches');
insert into bairro (id_cidade,nome_bairro) values (1,'Água Verde');
insert into bairro (id_cidade,nome_bairro) values (1,'Ahú');
insert into bairro (id_cidade,nome_bairro) values (1,'Alto Boqueirão');	
insert into bairro (id_cidade,nome_bairro) values (1,'Alto da Glória');
insert into bairro (id_cidade,nome_bairro) values (1,'Alto da XV');
insert into bairro (id_cidade,nome_bairro) values (1,'Atuba');
insert into bairro (id_cidade,nome_bairro) values (1,'Augusta');
insert into bairro (id_cidade,nome_bairro) values (1,'Bacacheri');
insert into bairro (id_cidade,nome_bairro) values (1,'Bairro Alto');
insert into bairro (id_cidade,nome_bairro) values (1,'Barreirinha');
insert into bairro (id_cidade,nome_bairro) values (1,'Batel');
insert into bairro (id_cidade,nome_bairro) values (1,'Bigorrilho');
insert into bairro (id_cidade,nome_bairro) values (1,'Boa Vista');
insert into bairro (id_cidade,nome_bairro) values (1,'Bom Retiro');
insert into bairro (id_cidade,nome_bairro) values (1,'Boqueirão');
insert into bairro (id_cidade,nome_bairro) values (1,'Butiatuvinha');
insert into bairro (id_cidade,nome_bairro) values (1,'Cabral');
insert into bairro (id_cidade,nome_bairro) values (1,'Cachoeira');
insert into bairro (id_cidade,nome_bairro) values (1,'Cajuru');
insert into bairro (id_cidade,nome_bairro) values (1,'Campina do Siqueira');
insert into bairro (id_cidade,nome_bairro) values (1,'Campo Comprido');
insert into bairro (id_cidade,nome_bairro) values (1,'Campo de Santana');
insert into bairro (id_cidade,nome_bairro) values (1,'Capão da Imbuia');
insert into bairro (id_cidade,nome_bairro) values (1,'Capão Raso');
insert into bairro (id_cidade,nome_bairro) values (1,'Cascatinha');
insert into bairro (id_cidade,nome_bairro) values (1,'Centro');
insert into bairro (id_cidade,nome_bairro) values (1,'Centro Histórico');
insert into bairro (id_cidade,nome_bairro) values (1,'Caximba');
insert into bairro (id_cidade,nome_bairro) values (1,'Centro Cívico');
insert into bairro (id_cidade,nome_bairro) values (1,'Cidade Industrial');
insert into bairro (id_cidade,nome_bairro) values (1,'Cristo Rei');
insert into bairro (id_cidade,nome_bairro) values (1,'Fanny');
insert into bairro (id_cidade,nome_bairro) values (1,'Fazendinha');
insert into bairro (id_cidade,nome_bairro) values (1,'Ganchinho');
insert into bairro (id_cidade,nome_bairro) values (1,'Guabirotuba');
insert into bairro (id_cidade,nome_bairro) values (1,'Guaíra');
insert into bairro (id_cidade,nome_bairro) values (1,'Hauer');
insert into bairro (id_cidade,nome_bairro) values (1,'Hugo Lange');
insert into bairro (id_cidade,nome_bairro) values (1,'Jardim Botânico');
insert into bairro (id_cidade,nome_bairro) values (1,'Jardim Social');
insert into bairro (id_cidade,nome_bairro) values (1,'Jardim das Américas');
insert into bairro (id_cidade,nome_bairro) values (1,'Juvevê');
insert into bairro (id_cidade,nome_bairro) values (1,'Lamenha Pequena');
insert into bairro (id_cidade,nome_bairro) values (1,'Lindoia');
insert into bairro (id_cidade,nome_bairro) values (1,'Mercês');
insert into bairro (id_cidade,nome_bairro) values (1,'Mossunguê (Ecoville)');
insert into bairro (id_cidade,nome_bairro) values (1,'Novo Mundo');
insert into bairro (id_cidade,nome_bairro) values (1,'Orleans');
insert into bairro (id_cidade,nome_bairro) values (1,'Parolin');
insert into bairro (id_cidade,nome_bairro) values (1,'Pilarzinho');
insert into bairro (id_cidade,nome_bairro) values (1,'Pinheirinho');
insert into bairro (id_cidade,nome_bairro) values (1,'Portão');
insert into bairro (id_cidade,nome_bairro) values (1,'Prado Velho');
insert into bairro (id_cidade,nome_bairro) values (1,'Rebouças');
insert into bairro (id_cidade,nome_bairro) values (1,'Riviera');
insert into bairro (id_cidade,nome_bairro) values (1,'Santa Cândida');
insert into bairro (id_cidade,nome_bairro) values (1,'Santa Felicidade');
insert into bairro (id_cidade,nome_bairro) values (1,'Santa Quitéria');
insert into bairro (id_cidade,nome_bairro) values (1,'Santo Inácio');
insert into bairro (id_cidade,nome_bairro) values (1,'São Braz');
insert into bairro (id_cidade,nome_bairro) values (1,'São Francisco');
insert into bairro (id_cidade,nome_bairro) values (1,'São João');
insert into bairro (id_cidade,nome_bairro) values (1,'São Lourenço');
insert into bairro (id_cidade,nome_bairro) values (1,'São Miguel');
insert into bairro (id_cidade,nome_bairro) values (1,'Seminário');
insert into bairro (id_cidade,nome_bairro) values (1,'Sítio Cercado');
insert into bairro (id_cidade,nome_bairro) values (1,'Taboão');
insert into bairro (id_cidade,nome_bairro) values (1,'Tarumã');
insert into bairro (id_cidade,nome_bairro) values (1,'Tatuquara');
insert into bairro (id_cidade,nome_bairro) values (1,'Tingui');
insert into bairro (id_cidade,nome_bairro) values (1,'Uberaba');
insert into bairro (id_cidade,nome_bairro) values (1,'Umbará');
insert into bairro (id_cidade,nome_bairro) values (1,'Vila Izabel');
insert into bairro (id_cidade,nome_bairro) values (1,'Vista Alegre');
insert into bairro (id_cidade,nome_bairro) values (1,'Xaxim');

--endereco de agencias do correio
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. João Negrão',1251,'','80230150',55);

insert into endereco (rua,numero,complemento,cep,id_bairro) values ('Rua XV de Novembro', 700,'','80020310',27);


--endereco das instituicoes
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('Travessa Rodolpho Rosenau', 157,'','80035235',18);

insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. Califórnia', 555,'','81900210',67);

insert into endereco (rua,numero,complemento,cep,id_bairro) values ('Rua Desembargador Antonio de Paula', 3451,'','81750450',16);


--endereco empresas
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. Lourenço Pinto', 299,'','80010080',27);

insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. Maestro Francisco Antonello', 1141,'','81030220',33);

insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. Dr. Bronislau Ostoja Roguski', 150,'','81540080',42);

--endereco criancas
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('Rua João Malucelli Neto', 100,'','81460170',31);
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. Dílson Luís', 56,'','81940200',70);
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. Marmelo',127,'','81550110',73);
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('R. Índia', 247,'','82960130',20);
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('Rua 21 de Junho', 483,'','82810330',24);

--endereco evento
insert into endereco (rua,numero,complemento,cep,id_bairro) values ('Rua Marechal José Bernardino Bormann', 1099,'','80730350',12);


insert into agencia (nome_agencia,id_endereco) values ('Agência João Negrão',1);
insert into agencia (nome_agencia,id_endereco) values ('Agência Marechal Deodoro',2);


insert into usuario (email,senha,permissao,ccpf_cnpj,telefone) values ('henrique@gmail.com','123456','PADRINHO','33398816002','34569010');

insert into usuario (email,senha,permissao,ccpf_cnpj,telefone) values ('mobiservicos@gmail.com','123456','PADRINHO','16744280000182','33339010');

insert into usuario (email,senha,permissao,ccpf_cnpj,telefone) values ('unipark@gmail.com','123456','PADRINHO','57745828000196','33505010');

insert into usuario (email,senha,permissao,ccpf_cnpj,telefone) values ('stark@gmail.com','123456','PADRINHO','19155957000135','33222210');


insert into usuario (email,senha,permissao,ccpf_cnpj,telefone) values ('marcelo@gmail.com','123456','FUNCIONARIO','02722864000142','33338585');

insert into padrinho (id_padrinho) values (1);
insert into padrinho (id_padrinho) values (2);
insert into padrinho (id_padrinho) values (3);
insert into padrinho (id_padrinho) values (4);

insert into empresa (id_empresa,nome_empresa,id_endereco) values (2,'Empresa Brasileira de Soluções de Mobilidade',6);

insert into empresa (id_empresa,nome_empresa,id_endereco) values (3,'Unipark Parque e Buffet Infantil',7);

insert into empresa (id_empresa,nome_empresa,id_endereco) values (4,'Stark Sport Center',8);

insert into funcionario (id_funcionario,id_agencia) values (5,1);

insert into pessoa (id_pessoa,nome,sexo) values (1,'Henrique','H');

--instituicoes
insert into instituicao(nome_instituicao,telefone,id_endereco) values ('Escola Municipal de Educação Infantil e Ensino Fundamental','30544111',3);

insert into instituicao(nome_instituicao,telefone,id_endereco) values ('Escola Municipal Antônio Vieira','33334111',4);

insert into instituicao(nome_instituicao,telefone,id_endereco) values ('Escola Ensino Fundamental Rolândia','39944111',5);



insert into crianca (nome_crianca,idade) values ('Felipe',10);
insert into crianca (nome_crianca,idade) values ('Julia',11);
insert into crianca (nome_crianca,idade) values ('Marcia',9);
insert into crianca (nome_crianca,idade) values ('Cássio',5);
insert into crianca (nome_crianca,idade) values ('Fernando',12);
insert into crianca (nome_crianca,idade) values ('Elaine',7);
insert into crianca (nome_crianca,idade) values ('Leandro',10);

--criancas que mandaram carta direto para o correio
insert into endereco_crianca(id_crianca,id_endereco) values (1,9);
insert into endereco_crianca(id_crianca,id_endereco) values (2,10);
insert into endereco_crianca(id_crianca,id_endereco) values (3,11);
insert into endereco_crianca(id_crianca,id_endereco) values (4,12);
insert into endereco_crianca(id_crianca,id_endereco) values (5,13);


insert into tipo_brinquedo (nome_tipo_brinquedo) values ('Bola');
insert into tipo_brinquedo (nome_tipo_brinquedo) values ('Boneco');
insert into tipo_brinquedo (nome_tipo_brinquedo) values ('Boneca');
insert into tipo_brinquedo (nome_tipo_brinquedo) values ('Carrinho');
insert into tipo_brinquedo (nome_tipo_brinquedo) values ('Casinha');
insert into tipo_brinquedo (nome_tipo_brinquedo) values ('Instrumento musical');

insert into brinquedo (nome_brinquedo,id_tipo_brinquedo) values ('Bola de futebol',1);
insert into brinquedo (nome_brinquedo,id_tipo_brinquedo) values ('Boneco Max Steel',2);
insert into brinquedo (nome_brinquedo,id_tipo_brinquedo) values ('Boneca Barbie',3);
insert into brinquedo (nome_brinquedo,id_tipo_brinquedo) values ('Carrinho controle remoto',4);
insert into brinquedo (nome_brinquedo,id_tipo_brinquedo) values ('Bola de basquete',1);
insert into brinquedo (nome_brinquedo,id_tipo_brinquedo) values ('Casa Barbie',5);
insert into brinquedo (nome_brinquedo,id_tipo_brinquedo) values ('Violão',6);


insert into carta (descricao,id_brinquedo,id_crianca) values ('Eu gostaria de ganhar uma bola de futebol.',1,1);

insert into carta (descricao,id_brinquedo,id_crianca) values ('Eu queria que o Papai Noel me desse um boneco do max steel.',2,2);

insert into carta (descricao,id_brinquedo,id_crianca) values ('Eu gostaria de ganhar uma boneca da barbie.',3,3);

insert into carta (descricao,id_brinquedo,id_crianca) values ('Eu quero ganhar um carrinho de controle remoto do papai noel.',4,4);

insert into carta (descricao,id_brinquedo,id_crianca) values ('Eu quero ganhar uma bola de basquete de natal.',5,5);

insert into carta (descricao,id_brinquedo,id_crianca) values ('Eu quero ganhar casa da Barbie.',6,6);

insert into carta (descricao,id_brinquedo,id_crianca) values ('Eu quero ganhar um violão do papai noel.',7,7);


insert into instituicao_carta(id_carta,id_instituicao) values (6,1);
insert into instituicao_carta(id_carta,id_instituicao) values (7,1);


insert into carta_padrinho(dt_apadrinhamento,entregue,id_padrinho,id_carta) values ('2019-11-29',false,1,1);
insert into carta_padrinho(dt_apadrinhamento,entregue,id_padrinho,id_carta) values ('2019-11-30',false,2,2);
insert into carta_padrinho(dt_apadrinhamento,entregue,id_padrinho,id_carta) values ('2019-11-30',false,3,3);


--eventos 
insert into evento (nome_evento,dt_evento,id_endereco,id_empresa) values ('Entrega de presentes de natal','2019-12-12',14,2);

insert into evento_carta(id_evento,id_carta) values (1,6);
insert into evento_carta(id_evento,id_carta) values (1,7);

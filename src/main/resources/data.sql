CREATE TABLE TB_PRODUTOS_VENDAS(
    CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    VENDA_CODIGO INT NOT NULL,
    PRODUTO_CODIGO INT NOT NULL,
    PRODUTO_QUANTIDADE INT NOT NULL,
    PRODUTO_VALOR_TOTAL DOUBLE NOT NULL,
    FOREIGN KEY (VENDA_CODIGO) REFERENCES TB_VENDAS(CODIGO),
    FOREIGN KEY (PRODUTO_CODIGO) REFERENCES TB_PRODUTOS(CODIGO)
);

CREATE TABLE TB_PRODUTOS_COMPRAS(
    CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    COMPRA_CODIGO INT NOT NULL,
    PRODUTO_CODIGO INT NOT NULL,
    FOREIGN KEY (COMPRA_CODIGO) REFERENCES TB_COMPRAS(CODIGO),
    FOREIGN KEY (PRODUTO_CODIGO) REFERENCES TB_PRODUTOS(CODIGO)
);

CREATE TABLE TB_PRODUTOS_PEDIDOS_COMPRAS(
    CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    PEDIDO_COMPRA_CODIGO INT NOT NULL,
    PRODUTO_CODIGO INT NOT NULL,
    FOREIGN KEY (PEDIDO_COMPRA_CODIGO) REFERENCES TB_PEDIDO_COMPRA(CODIGO),
    FOREIGN KEY (PRODUTO_CODIGO) REFERENCES TB_PRODUTOS(CODIGO)
);

CREATE TABLE TB_DEVOLUCOES_DEPOSITO_BANCARIO(
    CODIGO INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CLIENTE_CODIGO INT NOT NULL,
    DEVOLUCAO_CODIGO INT NOT NULL,
    BANCO_CODIGO INT NOT NULL,
    AGENCIA_NUMERO INT NOT NULL,
    CONTA_NUMERO INT NOT NULL,
    STATUS_DEVOLUCAO ENUM('EM_ABERTO','BAIXADO','CANCELADO') NOT NULL DEFAULT 'EM_ABERTO',
    FOREIGN KEY (BANCO_CODIGO) REFERENCES TB_BANCO(CODIGO),
    FOREIGN KEY (DEVOLUCAO_CODIGO) REFERENCES TB_DEVOLUCAO(CODIGO),
    FOREIGN KEY (CLIENTE_CODIGO) REFERENCES TB_CLIENTES(CODIGO)

);

INSERT INTO TB_BANCO (NOME_BANCO) VALUES ('BANCO AZUL');
INSERT INTO TB_BANCO (NOME_BANCO) VALUES ('BANCO AMARELO');
INSERT INTO TB_BANCO (NOME_BANCO) VALUES ('BANCO VERMELHO');
INSERT INTO TB_BANCO (NOME_BANCO) VALUES ('BANCO VERDE');
INSERT INTO TB_BANCO (NOME_BANCO) VALUES ('BANCO ROXO');
INSERT INTO TB_BANCO (NOME_BANCO) VALUES ('BANCO LARANJA');
INSERT INTO TB_BANCO (NOME_BANCO) VALUES ('BANCO CINZA');

INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('059.101.927-28',  'Mirella Duarte', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('413.856.540-07', 'Joaquim Castro', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('396.794.588-06', 'Regina Campos', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('712.365.506-09', 'Elias Mota', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('733.888.467-66', 'Clarice Barbosa', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('63.272.856/0001-36', 'Dio Esportes Ltda', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('07.400.271/0001-83', '??s Publicidade e Propaganda Ltda', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('033.450.050-85', 'Elza Sophia', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('17.717.039/0001-27', 'Padaria LaCa', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('751.011.512-46', 'Matheus Rocha', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('36.719.518/0001-27', 'LM Assessoria Jur??dica Ltda', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('25.716.208/0001-32', 'NLS Loca????es de Autom??veis Ltda', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('59.938.921/0001-42', 'AR Mudan??as Ltda', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('388.835.773-02', 'Eduarda Ara??jo', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);
INSERT INTO TB_CLIENTES (CPF_CNPJ, NOME, CADASTRADO, CADASTRADO_POR, ALTERADO, ALTERADO_POR, CREDITO_EM_CONTA) VALUES ('62.253.203/0001-47', 'Renac Constru????es Ltda', '2022-09-01 09:00:00', 'sistema', '2022-09-01 09:00:00', 'sistema', 0.0);

INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('md654@email.com','(43) 99848-9127', 1);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('ab124@email.com','(68) 99646-1169', 2);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('ok904@email.com','(27) 3900-5494', 3);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('mi014@email.com','(42) 98377-3597', 4);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('ra174@email.com','(28) 98733-8131', 5);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('qe661@email.com','(43) 99848-9127', 6);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('tr678@email.com','(98) 3791-2643', 7);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('td986@email.com','(98) 99109-6409', 8);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('op893@email.com','(42) 3560-3851', 9);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('gg650@email.com','(28) 3948-0182', 10);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('gl748@email.com','(83) 99263-2009', 11);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('hf845@email.com','(47) 2619-5716', 12);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('wp284@email.com','(21) 99815-8042', 13);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('bb316@email.com','(47) 98280-2994', 14);
INSERT INTO TB_CONTATOS (EMAIL, NUMERO_TELEFONE, CLIENTE_ID) VALUES ('iq541@email.com','(21) 3692-6390', 15);

INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Tabuazeiro','29043-660','Vit??ria','ES','Rua Manoel Pinto Ribeiro',921,1);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Maracan??','29142-866','Cariacica','SP','Rua Treze',333,2);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Col??nia Dona Lu??za','84046-255','Ponta Grossa','PR','Rua Maria da Rocha Mathias',756,3);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Cutim Anil','62031-222','S??o Lu??s','MA','Rua Evangelina Sab??ia',756,4);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Jardim Santo Ant??nio','74853-220','Goi??nia','GO','Rua 9',705,5);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Alice Coutinho','29043-660','Cariacica','ES','Rua S??o Jo??o Batista',129,6);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('??gua Quente','12062-714','Taubat??','SP','Rua Hildebrando Bosco Machado Coelho',420,7);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Vila Ponta Por??','94935-240','Cachoeirinha','RS','Rua Hon??rio Lemos',833,8);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Jardim dos Ip??s II','36543-660','Aragua??na','TO','Rua 43',864,9);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Padre Ibiapina','62023-030','Sobral','CE','Rua Hugo Alfredo Cavalcante',161,10);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Pricum??','29043-660','Boa Vista','RR','Rua das D??lias',906,11);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Jardim Taquari (Taquaralto)','77063-142','Palmas','TO','Quadra T 20 Avenida TLO 3',366,12);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Primavera','29043-695','V??rzea Grande','MT','Rua Bem-Me-Quer',367,13);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Ara????s','29103-240','Vila Velha','ES','Rua Berlim',238,14);
INSERT INTO TB_ENDERECO (BAIRRO,CEP,CIDADE,UF,LOGRADOURO,NUMERO,CLIENTE_ID) VALUES('Rocas','59010-663','Natal','RN','Travessa Jos??',921,15);

INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Arroz',2,12,130,16.36);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Feij??o',2,12,150,13.30);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('A??ucar',2,10,200,12.50);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Farinha',2,10,160,10.12);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Macarr??o',2,11,200,7.80);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Detergente',0,15,100,5.60);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Alvejante',0,15,100,9.00);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Sab??o em P??',0,15,130,15.00);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Xampu',4,16,75,14.50);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Sabonete',4,16,80,3.69);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Alcool',0,16,50,8.45);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Ra??ao de Gato',1,13,65,38.90);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Ra????o de Cachorro',1,13,70,35.70);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Coleira',1,13,25,25.80);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Vassoura',3,8,60,29.90);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Peneira',3,8,36,8.90);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Carregador de Celular',3,8,25,20.50);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Refrigerante',2,12,300,7.80);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Banana',2,12,150,3.36);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('P??o',2,12,80,5.36);
INSERT INTO TB_PRODUTOS (DESCRICAO,GRUPO,IMPOSTO,QUANTIDADE,VALOR) VALUES('Batata Congelada',2,12,150,15.36);

INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (2,85.60,1);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (3,185.60,2);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (5,858.60,5);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (3,95.62,3);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (1,78.95,4);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (4,96.48,6);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (0,12.63,7);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (2,16.80,8);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (5,45.69,9);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (3,58.90,11);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (1,163.60,12);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (0,258.84,10);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (2,396.25,15);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (2,186.77,4);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (1,89.60,3);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (1,67.60,1);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (3,49.60,10);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (4,33.60,5);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (5,20.60,14);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (6,105.60,6);
INSERT INTO TB_VENDAS (MODO_PAGAMENTO,VALOR_TOTAL,CLIENTE_ID) VALUES (7,85.60,7);

INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (45891,159.96);
INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (16329,648.96);
INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (94682,236.85);
INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (16346,45.16);
INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (00615,15.25);
INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (15394,136.18);
INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (87496,89.84);
INSERT INTO TB_COMPRAS (CODIGO_NOTA, VALOR_COMPRA) VALUES (00659,241.96);

INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(1,1,3,15.36);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(2,3,5,12.56);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(3,5,10,49.65);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(4,4,5,125.26);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(5,6,9,136.26);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(6,7,2,154.59);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(7,8,4,89.60);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(8,9,13,13.96);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(9,10,23,15.84);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(1,12,1,49.65);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(11,13,2,36.58);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(12,15,6,78.49);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(13,18,8,184.65);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(14,19,3,258.63);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(15,20,11,169.59);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(16,2,7,36.8);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(17,16,5,41.84);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(18,17,4,84.54);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(19,6,7,69.58);
INSERT INTO TB_PRODUTOS_VENDAS (VENDA_CODIGO,PRODUTO_CODIGO,PRODUTO_QUANTIDADE,PRODUTO_VALOR_TOTAL) VALUES(20,3,2,37.95);

INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(1,1);
INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(2,3);
INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(3,5);
INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(4,4);
INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(5,6);
INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(6,7);
INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(7,8);
INSERT INTO TB_PRODUTOS_COMPRAS (COMPRA_CODIGO,PRODUTO_CODIGO) VALUES(8,9);









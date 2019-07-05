
drop schema socasom;
create schema socasom;
use socasom;

create table cliente (
	id int not null AUTO_INCREMENT,
	cpf VARCHAR(11),
	nome VARCHAR(128),
	email VARCHAR(70),
	pontos INT default 0,
	primary key (id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

create table produto (
	id INT  NOT NULL AUTO_INCREMENT,
	album VARCHAR(50),
	compositor VARCHAR(50),
	midia VARCHAR(10),
    genero varchar(20),
	preco NUMERIC(10,2),
	primary key (id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

create table venda (
	id INT NOT NULL AUTO_INCREMENT,
    forma_pagamento varchar(20) not null,
	id_cliente int not null,
	quantidade int not null,
    data_venda DATE,
	total NUMERIC(10,2),
	FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    primary key (id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;

create table item_venda (
	id INT NOT NULL AUTO_INCREMENT,
	id_venda INT NOT NULL,
	id_produto INT NOT NULL,
	FOREIGN KEY (id_venda) REFERENCES venda(id),
	FOREIGN KEY (id_produto) REFERENCES produto(id),
	primary key (id)
)ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;


insert into cliente (cpf, nome, email, pontos) values 
	('17674224075', 'Devi Pettus', 'dpettus0@yolasite.com', 45),
	('00034853888', 'Merlina Brislane', 'mbrislane1@usda.gov', 85),
	('61519581925', 'Maureene Iley', 'miley2@macromedia.com', 28),
	('11649535552', 'Ahmed Mully', 'amully3@goo.ne.jp', 18),
	('76214366604', 'Evaleen Agnolo', 'eagnolo4@dot.gov', 14),
	('27533207794', 'Prudence Arkill', 'parkill5@samsung.com', 87),
	('85902138173', 'Reginauld Farrens', 'rfarrens6@vinaora.com', 59),
	('54590350797', 'Cosette Delacourt', 'cdelacourt7@google.co.jp', 16),
	('88373177860', 'Maryl Vedeneev', 'mvedeneev8@over-blog.com', 93),
	('00552192223', 'Moise Tuffin', 'mtuffin9@statcounter.com', 28),
	('21094735273', 'Tomaso Pook', 'tpooka@github.io', 34),
	('73119463419', 'Alica Deedes', 'adeedesb@forbes.com', 94),
	('88689379866', 'Sheba Brack', 'sbrackc@ebay.com', 5),
	('17259611408', 'Abbott Pieters', 'apietersd@state.tx.us', 50),
	('07176970907', 'Zitella Dunbleton', 'zdunbletone@walmart.com', 42),
	('71229153260', 'Ethelind Worssam', 'eworssamf@dagondesign.com', 100),
	('23915114842', 'Alvy Barrowcliffe', 'abarrowcliffeg@unesco.org', 67),
	('09175881293', 'Derwin Steventon', 'dsteventonh@biblegateway.com', 89),
	('05995998108', 'Johnathan Heam', 'jheami@skype.com', 12),
	('11469718398', 'Theodor Quene', 'tquenej@trellian.com', 30),
	('98536727011', 'Tyler Nelthropp', 'tnelthroppk@umich.edu', 50),
	('78841398169', 'Shell Kenrat', 'skenratl@unc.edu', 58),
	('97954304273', 'Erma Doogood', 'edoogoodm@unicef.org', 64),
	('68242985040', 'Merissa Langstrath', 'mlangstrathn@berkeley.edu', 37),
	('06490055939', 'Mirabel Chanson', 'mchansono@wsj.com', 74),
	('55741840583', 'Lorene Adame', 'ladamep@parallels.com', 69),
    ('27820306150', 'Mayor Normanton', 'mnormantons@flavors.me', 1),
	('75080809923', 'Giralda O''Regan', 'goregant@opera.com', 10),
	('19503151887', 'Lyn Yakunikov', 'lyakunikovu@weibo.com', 95),
	('17091397173', 'Marcella Gittens', 'mgittensv@sogou.com', 2),
	('25026799189', 'Lucian Oxtarby', 'loxtarbyw@accuweather.com', 68),
	('02089458283', 'Ana Franzel', 'afranzelq@apple.com', 58),
    ('23863530360', 'Danice Betteson', 'dbettesonx@scientificamerican.com', 96),
	('13062357914', 'Colette Ellin', 'celliny@usatoday.com', 41),
	('79715062739', 'Cathyleen Brockie', 'cbrockiez@intel.com', 68),
	('79721197903', 'Othilie Sange', 'osange10@paypal.com', 2),
	('03506963561', 'Ailee Christoffe', 'achristoffe11@narod.ru', 83),
	('56155073366', 'Torr Wolverson', 'twolverson12@163.com', 13),
	('35246456070', 'Theobald Abbots', 'tabbots13@unesco.org', 97),
	('64673962583', 'Derek Hastwall', 'dhastwall14@wiley.com', 98),
    ('12612557743', 'Linea Wallas', 'lwallas15@buzzfeed.com', 66),
	('77722374327', 'Griz Cisar', 'gcisar16@infoseek.co.jp', 15),
	('36308857349', 'Wilburt Ketchell', 'wketchell17@360.cn', 62),
	('37415718751', 'Miles Oda', 'moda18@prnewswire.com', 32),
	('45906308799', 'Deni Connealy', 'dconnealy19@phoca.cz', 68),
	('23442460811', 'Ron Goodredge', 'rgoodredge1a@hatena.ne.jp', 28),
	('06532612387', 'Anne-corinne Kmicicki', 'akmicicki1b@tamu.edu', 52);

insert into produto (album, compositor, midia, preco) values	
	('Gotta say something', 'Maugus Fatton', 'vinil', 145.50),
	('Miracle Road', 'Exceptionals', 'CD', 35.99),
	('Longshanks', 'Longshanks', 'CD', 20.00),
	('Live at NY', 'Philip Nester', 'DVD', 60.00),
	('Regorgitation', 'Ultrakill9000', 'CD', 43.22);

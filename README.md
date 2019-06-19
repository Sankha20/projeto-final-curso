# Projeto Soca Som

Projeto final do curso Técnico em Informática

## Participantes
* Victor Pontes - victor.pcs@outlook.com
* Rodrigo S.
* R. França

## Configurações Utilizadas
MySQL 5.7  
_(Na minha máquina, o MySQL 5 roda na porta 3307, mudem na máquina de vocês para 3306)_  
MySQL connector 5.1.47  
JDK 1.8  

## Como utilizar

### Arquivo conexão
* criarConexao: Cria e retorna uma conexão com o banco de dados

### Arquivo Ferramentas
* confirma(msg): Mostra caixa de texto pedindo confirmação | Retorna True / False
* alerta(msg): Mostra caixa de texto de alerta
* erro(msg): Mostra caixa de texto de erro

### Arquivo DaoClientes
* selectAll(): Retorna ArrayList com todos os clientes encontrados no banco
* delete(String cpf)
* update(Cliente cliente)
* insert(Cliente cliente)

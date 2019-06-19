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

### Arquivo Conexao
* criarConexao(): Cria e retorna uma conexão com o banco de dados

### Arquivo Ferramentas
* confirma(msg) -> (True/False): Mostra caixa de texto pedindo confirmação
* alerta(msg): Mostra caixa de texto de alerta
* erro(msg): Mostra caixa de texto de erro

### Arquivo DaoClientes
* selectAll(): Retorna ArrayList com todos os clientes encontrados no banco
* delete(String cpf)
* update(Cliente cliente)
* insert(Cliente cliente)

### Arquivo classe.Cliente
* getCpf()
* getNome()
* getEmail()
* getPontos()
* formatoTabela() -> Object[]: Retorna uma array já formatada para inserir a tabela de clientes

* setCpf(String cpf) -> (True/False): Verifica se a entrada é um CPF válido, modifica a propriedade e retorna true
* setNome(String nome)
* setEmail(String email)
* addPontos(int pontos): Add pontos ao cliente até um limite de 100
* subPontos(int pontos): Tira pontos do cliente até um limite de 0

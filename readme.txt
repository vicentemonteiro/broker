Instru��es de Execu��o.
1 - Fa�a download do projeto para seu ambiente de desenvolvimento utilizando GIT no seguinte endere�o: ?https://github.com/vicentemonteiro/broker
2 - Abra o projeto Maven e Spring Boot na IDE de sua prefer�ncia.
3 - Crie uma base de dados no PostgreSQL.
4 - Preencha o ?application.properties com as informa��es do banco.
5 - Preencha o ?application.properties com as informa��es do e-mail SMTP.
6 - Execute o projeto pelo menu de contexto de sua IDE.
A classe principal � ?com.monteiro.broker.SpringBroker.java

Observa��es
1 - Ao iniciar a aplica��o pela primeira vez ser�o exibidos algumas exce��es pela n�o exist�ncia das estrutura de banco de dados, comportamento normal.
2 - A aplica��o sempre reiniciar� as estruturas de dados ao iniciar, ou seja perder� tudo criado na �ltima execu��o.
3 - O arquivo de de relat�rio final ser� sobrescrito a cada execu��o.
4 - Ao t�rmino das 100 itera��es o sistema desligar� sozinho, neste momento algumas exce��es ser�o exibidas, comportamento normal.
5 - O diret�rio de sa�da do relat�rio (?report.txt) � o mesmo de execu��o do projeto.
6 - As empresas s�o previamente cadastradas, portanto deve-se utilizar o ID delas ao
cadastrar as ordens. ?1 - CCRO3, 2 - PETR4, 3 - CIEL3, 4 - KROT3.

Servi�os Rest.
Caso n�o queira cadastrar os dados iniciais manualmente pode chamar o servi�o que far� a
inclus�o de 1 conta e 4 ordens.
http://localhost:8080/request/mock

*Conta
1 - Criar/Atualizar ?http://localhost:8080/account/save
{id: 1, "avaiableMoney": 100000, "email": "mail@gmail.com"}

2 - Ver ?http://localhost:8080/account/view?id=1
3 - Ver todas ?http://localhost:8080/account/viewall

*Ordem de compra/venda
1 - Criar/Atualizar ?http://localhost:8080/request/save
{"id": 1, "account":{"id": 1}, "company":{"id": 1 }, "sellPrice": 12, "buyPrice": 11}
2 - Ver ?http://localhost:8080/request/view?id=1
3 - Ver todas ?http://localhost:8080/request/viewall
4 - Excluir ?http://localhost:8080/request/delete?id=1

*Ordens executadas
1 - Ver todas ?http://localhost:8080/entry/viewall
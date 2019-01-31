Instruções de Execução.
1 - Faça download do projeto para seu ambiente de desenvolvimento utilizando GIT no seguinte endereço: ?https://github.com/vicentemonteiro/broker
2 - Abra o projeto Maven e Spring Boot na IDE de sua preferência.
3 - Crie uma base de dados no PostgreSQL.
4 - Preencha o ?application.properties com as informações do banco.
5 - Preencha o ?application.properties com as informações do e-mail SMTP.
6 - Execute o projeto pelo menu de contexto de sua IDE.
A classe principal é ?com.monteiro.broker.SpringBroker.java

Observações
1 - Ao iniciar a aplicação pela primeira vez serão exibidos algumas exceções pela não existência das estrutura de banco de dados, comportamento normal.
2 - A aplicação sempre reiniciará as estruturas de dados ao iniciar, ou seja perderá tudo criado na última execução.
3 - O arquivo de de relatório final será sobrescrito a cada execução.
4 - Ao término das 100 iterações o sistema desligará sozinho, neste momento algumas exceções serão exibidas, comportamento normal.
5 - O diretório de saída do relatório (?report.txt) é o mesmo de execução do projeto.
6 - As empresas são previamente cadastradas, portanto deve-se utilizar o ID delas ao
cadastrar as ordens. ?1 - CCRO3, 2 - PETR4, 3 - CIEL3, 4 - KROT3.

Serviços Rest.
Caso não queira cadastrar os dados iniciais manualmente pode chamar o serviço que fará a
inclusão de 1 conta e 4 ordens.
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
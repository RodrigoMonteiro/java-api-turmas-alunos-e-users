<h3><strong>ATENÇÃO: Necessário alterar os dados do aplication.properties com seu banco de dados para funcionar corretamente.</strong></h3>

<strong>Passo 1:</strong> Para criar um usuário para ter acesso a API de alunos,turmas e users é necesseario se cadastrar na rota:
"http://localhost:8080/signup" <strong>(método POST)</strong>
Os campos que dever ser envaidos no body da requisição são, email, username e password.

<strong>Passo 2:</strong> Para gerar o token de acesso, é necessário utilizar a rota "http://localhost:8080/authenticate" <strong>(método POST)</strong> utilizanddo o username e password criados anteriormente. 

<strong>Passo 3:</strong> É necessaário colocar o token no header da requisição, colocamos em Authorization -> Type -> Bearer Token -> Colocamos o token gerado ou
vamos em Headers criamos um campo Authorization e no campo value escrevemos bearer + o token.

<strong>Passo 4:</strong> Com o token no header podemos utilizar a API de alunos, turmas e users atraves da URL básica "http://localhost:8080/api".

Podemos usar a API do Swagger, disponível em "http://localhost:8080/swagger-ui.html".

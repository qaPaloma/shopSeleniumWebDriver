# language: pt

@login
Funcionalidade: Login de usuários

  @login-success
  Cenário: Logar com sucesso na página da loja
    Dado que entrei na página de login
    Quando preencho o formulário com meu email e senha
    E clico em Login
    Então o login é realizado com sucesso

  @login-remember
  Cenário: Clicar em Lembrar de mim antes de logar
    Dado que entrei na página de login
    Quando preencho o formulário com meu email e senha
    E seleciono Lembrar de Mim
    E clico em Login
    Então o login é realizado com sucesso

  @login-fail @login-fail-email
  Cenário: Usuário tenta fazer login com dados errados
    Dado que entrei na página de login
    Quando preencho o formulário com email errado
    E clico em Login
    Então vejo uma mensagem de email errado

  @login-fail @login-fail-password
  Cenário: Usuário tenta fazer login com dados errados
    Dado que entrei na página de login
    Quando preencho o formulário com senha errada
    E clico em Login
    Então vejo uma mensagem de senha errada
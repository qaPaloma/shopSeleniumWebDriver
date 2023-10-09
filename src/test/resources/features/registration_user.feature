# language: pt

  @cadastro
  Funcionalidade: Cadastro de novos usuários

    @cadastro-sucesso
    Cenário: Registrar novo usuário com sucesso
      Dado que entrei na página de cadastro
      Quando eu preencho o formulário com meus dados
      E clico em Cadastrar
      Então o cadastro é realizado com sucesso

    @cadastro-login-pagina
    Cenário: Acessar página de cadastro através da página de login
      Dado que entrei na página de login
      Quando clico em Ainda não tem conta?
      Então sou encaminhado para a página de cadastro

    #@cadastro-falha
    #Cenário: Usuário tenta se cadastrar sem completar os dados
    #  Dado que entrei na página de cadastro
    #  Quando eu preencho meu cadastro sem incluir meu nome | email | senha
    #  E clico em Cadastrar
    #  Então vejo uma mensagem de erro

    #Nome: "O campo nome deve ser preenchido" #No site, está escrito "preenchido"
    #Email: "O campo e-mail deve ser preenchido corretamente" #No site, está escrito "preenchido"
    #Senha: "O campo senha deve ter pelo menos 6 dígitos"
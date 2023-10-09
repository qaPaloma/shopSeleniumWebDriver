#language: pt

  @profile
  Funcionalidade: Atualizar dados de usuário no dashboard
    @profile-tab
    Cenário: Acessar páginas de perfil e de atualização
      Dado que estou logado no dashboard
      Quando clico para acessar meu perfil de usuário
      E clico no botão de atualização de dados
      Então acesso a página de atualização

    @update-profile
    Cenário: Atualizar dados de usuário com sucesso
      Dado que estou na página de atualização de perfil
      Quando preencho o formulário com meus dados
      E clico para atualizar meus dados
      Então o perfil é atualizado com sucesso
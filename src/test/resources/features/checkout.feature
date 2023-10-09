#language: pt

  @checkout
  Funcionalidade: Fazer checkout de produtos
    @checkout-billing
    Cenário: Adicionar dados com sucesso
      Dado que estou na página de checkout
      Quando adiciono meus dados de cobrança
      E clico para salvar os meus dados
      Então meus dados foram salvos com sucesso

    @checkout-success
    Cenário: Selecionar método de pagamento e completar a compra com sucesso
      Dado que estou na página de checkout
      E já preenchi meus dados de cobrança
      Quando seleciono o método de pagamento
      E clico para realizar o pedido
      Então meu pedido é realizado com sucesso

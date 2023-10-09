# language: pt

  @product
  Funcionalidade: adicionar um produto no carrinho de compras

    Cenário: Adicionar um produto no carrinho
      Dado que estou na página do produto
      E seleciono o tamanho
      Quando clico em Add to cart
      Então o produto é adicionado com sucesso no carrinho
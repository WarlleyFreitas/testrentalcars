Feature: Filtro e pesquisa por opções de aluguel de carros
# Como um usuário
# Eu quero filtrar e pesquisar por opções de aluguel de carros
# E então poder ver as opções de carro que me agrade
# O corner cenário de busca vazia também será validada

  Background:
    Given que o web browser esta na página home da rentcars

  @Behavior1
  Scenario: Pesquisar por carros em determinada localidade
    Given que o usuário insere "Recife" no campo de busca
    When o usuário clicar no botão Pesquisar
    Then a página para a busca realizada é exibida

  @Behavior2
  Scenario: Pesquisar por carros com campo de localidade vazio
    Given que o usuário insere "" no campo de busca
    When o usuário clicar no botão Pesquisar
    Then um alerta é exibido indicando que o campo é obrigatório

  @Behavior3
  Scenario: Salvar orçamento de um aluguel de carro
    Given que o usuário insere "Recife" no campo de busca
    When o usuário clicar no botão Pesquisar
    Then o usuário pode optar por um orçamento sugerido
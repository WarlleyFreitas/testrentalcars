Feature: Consulta e alteração de informações
# Como um usuário
# Eu quero alterar opções ou consultar informações relevantes
# E então facilitar minha experiência de navegação pelo site

  Background:
    Given que o web browser esta na página home da rentcars

  @Behavior4
  Scenario: Alterar a unidade monetária de visualização
    Given que o usuário acessa a opção de unidade monetária
    When o usuário alterar a unidade monetária para Libra Esterlina
    Then os valores exibidos na página devem refletir a moeda selecionada

  @Behavior5
  Scenario: Consultar os requisitos para alugar um carro no Brasil
    Given que o usuário acessa a opção de FAQ
    When o usuário acessar os requisitos para alugar um carro no Brasil no menu lateral esquerdo
    Then a opção escolhida é exibida
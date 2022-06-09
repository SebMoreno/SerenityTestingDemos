#Author: juansebasmorenoruiz@gmail.com
Feature: Consumo de un GET en una API REST en gorest
  Yo como aprendiz de automatizacion
  Necesito automatizar el consumo de una API REST
  Para practicar la automatización de pruebas en una API REST

  Scenario Outline: Consumir un usuario por medio de GET
    Given "Cliente" desea construir una petición en gorest con uri "https://gorest.co.in"
    When Realiza un GET al endpoint "/public/v1/users/<id>"
    Then Valida que el codigo de estado sea 200 y los datos correspondan
      | id   | name   | email   | gender   | status   |
      | <id> | <name> | <email> | <gender> | <status> |
    Examples:
      | id   | name             | email                          | gender | status |
      | 1246 | Darshan Nehru MD | md_nehru_darshan@stiedemann.io | female | active |



#Feature: Consumo de un POST en una API REST en gorest
#  Yo como aprendiz de automatizacion
#  Necesito automatizar el consumo de una API REST
#  Para practicar la automatización de pruebas en una API REST
#
#  Scenario Outline: Crear un usuario por medio de POST
#    Given "Cliente" desea construir una petición en gorest con uri "https://gorest.co.in"
#    When Realiza un POST al endpoint "/public/v1/users/"
#      | name   | email   | gender   | status   |
#      | <name> | <email> | <gender> | <status> |
#    Then Valida que el codigo de estado sea 201 y los datos correspondan
#      | name   | email   | gender   | status   |
#      | <name> | <email> | <gender> | <status> |
#    Examples:
#      | name   | email           | gender | status |
#      | Simone | nina@simone.com | female | active |



#Feature: Crear un usuario en goRest
#  Yo como QA
#  Quiero crear un usuario en goRest
#  Para validar el correcto funcionamiento
#
#  Background: Construir peticion
#    Given Construyo la peticion "https://gorest.co.in"
#
#  Scenario Outline: Crear un usuario en goRest de forma exitosa
#    When  Consumo el endpoint "/public/v1/users" con la instruccion post
#      | name   | <name>   |
#      | gender | <gender> |
#      | email  | <email>  |
#      | status | <status> |
#    Then Valido que el estado del response sea 201 y contenga un id
#
#    Examples:
#
#      | name | gender | email                 | status |
#      | Lous | male   | kk4l444651@tester.com | active |
#
#
#  Scenario Outline: Modificar nombre al usuario creado anteriormente
#    When  Consumo el endpoint "/public/v1/users/" con la instruccion patch
#      | name | <name> |
#    Then Valido que el estado del response sea 200 y contenga un id
#
#    Examples:
#
#      | name |
#      | Lara |
#
#
#  Scenario Outline: Modificar todos los datos del usuario creado anteriormente
#    When  Consumo el endpoint "/public/v1/users/" con la instruccion put
#      | name   | <name>   |
#      | gender | <gender> |
#      | email  | <email>  |
#      | status | <status> |
#
#    Then Valido que el estado del response sea 200 y contenga un id
#
#    Examples:
#
#      | name  | gender | email          | status   |
#      | Losss | female | 651@tester.com | inactive |
#
#  Scenario: Comparar nombre de usuario modificado anterior con el nuevo modificado
#    When  Consumo el endpoint "/public/v1/users/" con la instruccion get
#
#  Scenario: Eliminar usuario creado
#    When  Consumo el endpoint "/public/v1/users/" con la instruccion delete

#Author: juansebasmorenoruiz@gmail.com
Feature: Iniciar sesion Guru
  Yo como aprendiz de automatizacion
  Necesito inciar sesion en Guru
  Para aprender a automatizar una pagina web

  Scenario Outline: Iniciar sesion de forma exitosa
    Given "Jhoiner" desea ir a la pagina de <url>
    When Ingresa nombre de usuario <user> y password <password>
    Then Valida que el titulo sea <msg>

    Examples:
      | url                          | user     | password | msg                  |
      | "http://demo.guru99.com/V4/" | "mgr123" | "mgr!23" | "Manger Id : mgr123" |

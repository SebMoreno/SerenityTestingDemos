#Author: juansebasmorenoruiz@gmail.com
Feature: Resgitrarme en uTest
  Yo como automatizador
  Quiero registrarme en uTest
  Para validar el correcto funcionamiento

  Scenario: Registro exitoso de un usuario
    Given "Usuario" desea ir a la pagina de "https://www.utest.com"
    When Ingresa todos los datos de registro
      | firstName | lastName | email             | birthMonth | birthDay | birthYear | city         | zipCode  | password       | languages      |
      | Carlitos  | Santana  | testing@email.com | May        | 2        | 2000      | Barranquilla | 15648568 | tengoHambre153 | Italian;German |
    Then Valida que aparezca el mensaje de confirmación "Welcome to the world's largest community of freelance software testers!"

#Author: juansebasmorenoruiz@gmail.com
Feature: Registro fallido en UTest
  Yo como aprendiz de automatizacion
  Necesito automatizar el registro de un usuario
  Para practicar la automatización de una pagina web

  Background:
    Given "Usuario" desea ir a la pagina de "https://www.utest.com"
    And Inicia proceso de registro

#  Scenario: No ingreso de datos en la página de información personal
#    When No ingresa ningún dato e intenta cambiar de paso
#    Then Valida que aparezcan los errores de inputs correspondientes en el paso de información personal
#      | firstName | First name is required    |
#      | lastName  | Last name is required     |
#      | email     | Enter valid email         |
#      | birthDate | Date of birth is required |
#
  Scenario: Borrado de los datos de dirección por defecto
    When Ingresa datos validos de información personal
      | firstName  | Carlitos          |
      | lastName   | Santana           |
      | email      | testing@again.com |
      | birthMonth | May               |
      | birthDay   | 2                 |
      | birthYear  | 2000              |
    And Borra los datos por defecto del paso de dirección
    Then Valida que aparezcan los errores de inputs correspondientes en el paso de direccion
      | city | City is required |
      | zip  | Zip is required  |
#
#  Scenario: Borrado del computador seleccionado por defecto
#    When Ingresa datos validos de información personal
#      | firstName  | Carlitos          |
#      | lastName   | Santana           |
#      | email      | testing@again.com |
#      | birthMonth | May               |
#      | birthDay   | 2                 |
#      | birthYear  | 2000              |
#    And Avanza con los valores por defecto del paso de dirección
#    And Selecciona "No Computer Device" de la lista de opciones de computadores
#    Then Valida que aparezca el error "One device is required to complete registration." por no tener ningun dispositivo seleccionado
#
#  Scenario: No ingreso de contraseña ni aceptado de terminos ni politicas
#    When Ingresa datos validos de información personal
#      | firstName  | Carlitos          |
#      | lastName   | Santana           |
#      | email      | testing@again.com |
#      | birthMonth | May               |
#      | birthDay   | 2                 |
#      | birthYear  | 2000              |
#    And Avanza con los valores por defecto del paso de dirección
#    And Avanza con los valores por defecto del paso de dispositivos
#    And Intenta completar el registro
#    Then Valida que aparezcan los errores correspondientes del último paso del registro
#      | password | Confirm Password is required                                            |
#      | terms    | You must accept Terms of Use and Code of Conduct to be able to continue |
#      | policys  | You must accept Privacy & Security Policy to be able to continue        |

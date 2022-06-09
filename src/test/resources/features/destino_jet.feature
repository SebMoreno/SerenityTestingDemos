#Author: juansebasmorenoruiz@gmail.com
Feature: Alquiler de automovil en destinojet
  Yo como estudiante de automatizacion
  Necesito automatizar el proceso de alquiler de un automovil
  Para practicar la automatización de una pagina web

  Scenario: Alquiler fallido de un automovil
    Given "Cliente" desea ir a la pagina de "https://test.destinojet.co/"
    When Busca el alquiler de un automovil con la siguiente informacion
      | place | initialDate | initialHour | finalDate  | finalHour | discount                                      | carType  |
      | BCN   | 2022-03-15  | 10:00       | 2022-03-25 | 15:00     | Descuento 10 % Caribbean Airlines- BWee Miles | Standard |
    And Ingresa los datos de reserva
      | gender    | firstName | lastName | docType | docNum     | birthMonth | birthDay | birthYear | email          | cellnumber | comentary     | address             | expirationMonth | expirationYear | cvc | cardNum          |
      | Masculino | Carlitos  | Santana  | TI      | 1234561845 | Mayo       | 15       | 1990      | test@email.com | 1231236565 | to muy bonito | Cra 30 #25-12 Bello | 04              | 23             | 167 | 5456824916609101 |
    Then Valida que se haya fallado en la reserva del auto

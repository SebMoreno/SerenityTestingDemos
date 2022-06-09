#Author: juansebasmorenoruiz@gmail.com
Feature: Comprar camisa en disel
  Yo como cliente de disel
  Necesito comprar una camisa en disel.com
  Para tener una camisa nueva

  Scenario: Intento fallido de comprar de una camisa
    Given "Cliente" desea ir a la pagina de "https://co.diesel.com/"
    When selecciona la camiseta numero 1 y inicia su compra con la talla "S"
    And Ingresa datos propios
      | correo        | nombre | apellido | cedula     | telefono   | direccion         | departamento | municipio |
      | test@test.com | Carlos | Santana  | 1015460458 | 3208184555 | calle64bis 100-14 | Antioquia    | Medellín  |
    And Ingresa datos de pago y finaliza la compra
      | expirationdate | numbercard       | feesamount | fullname       | cvc | cedula     |
      | 03/23          | 5215587392715740 | 12         | Carlos Santana | 570 | 1678913654 |
    Then Valida que aparezca el mensaje "Por favor revise los detalles de pago"

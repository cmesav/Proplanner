#Author: mesa.cristian@gmail.com

Feature: Purchase a product
  As a client
  I want to purchase one product
  to use it when I need it

  Background:
    Given I log in the page

  @WithOutCoupon
  Scenario: purchase a product with out coupon
    When I add the product "Pan tajado" to the cart
    Then I see the product in my orders

  @ValidateCoupon
  Scenario: purchase a product with coupon
    When I add the products to the cart
      | Aceite de Girasol |
      | Pan tajado        |
      | Jamón Premium     |
    Then I see the error message "Cupón inválido"

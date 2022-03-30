Feature: lowest fare

  Scenario Outline: 
    When open "<bn>" browser 
    And launch "https://www.spicejet.com/" site
    And select roundtrip
    And enter the depart "<frm>" city
    When clear the input fields of to city
    And enter the arrive "<to>" city
    When select departure <dy> ,"<dm>",<dd>
    And select return <ry> ,"<rm>",<rd>
    And select search flight
    When click on lowest fare for departure flight
    When click on lowest fare for return flight
    And click continue
    And close site

    Examples: 
      | bn      | frm | to  | dy   | dm  | dd | ry   | rm  | rd |
      | chrome  | BLR | DEL | 2022 | may |  1 | 2022 | may |  5 |
      | firefox | BLR | DEL | 2022 | may |  1 | 2022 | may |  5 |
     
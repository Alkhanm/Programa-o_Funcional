# PADRÃO DE PROJETO: STRATEGY

O _Strategy_ é composto por três camadas:



`CONTEXT`

> É aquele que vai acessar um algoritimo das subclasses 
da interface _Strategy_.



`STRATEGY`
> Uma interface comum para todas as subclasses, 
ou para todos os algoritmos que são suportados.
O contexto usa essa interface para chamar uma das sublasses 
_Concrete Strategy_ ou um dos algoritmos definidos.

`CONCRETE STRATEGY`
> A classe concreta que implementa a _Strategy_ abstrata está definida como as subclasses 
> ConcreteStrategyA, ConcreteStrategyB, ConcreteStrategyC 

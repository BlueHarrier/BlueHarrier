# Práctica 8.3 - Collections: Calculadora de Pila

## Documentación

### ¿Qué vamos a hacer?

Crear una calculadora de pila, que dados unos números y operadores en notación polaca inversa pueda obtener el resultado.

### ¿Con qué lo vamos a hacer?

Se va a emplear Java y Junit para los tests.

### ¿Cómo se ha hecho?

Se ha implementado una clase `CalculadoraRPN`, que debe instanciarse para poderse emplear. Con su método `operate` se pueden introducir elementos, que pueden ser un `+`, un `*` o un número. Si reciben el operador de suma, sumará los dos últimos números introducidos en la pila, si es de multiplicación, los multiplicará, y si es un número, lo introducirá en la pila. Para saber qué hay actualmente en la cima de la pila, debe utilizarse el método `show`.

### ¿Dónde se ha hecho?

Mitad en clase y mitad en mi ordenador personal.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

01/02/2023.

---

## Enunciado

En esta práctica vamos a crear una pequeña calculadora de pila que sólo suma, multiplica y totaliza.

Las calculadoras de pila operan algo diferente de las calculadoras normales.
1. Metemos todos los operandos y los operadores en la pila
2. Realizamos las operaciones

Por ejemplo: si queremos obtener (2+3)*5 le introduciremos los datos de la siguente forma: 2 3 + 5 *	=> (da  25)
1. La calculadora tomará el primer  valor/operador de la pila (lo saca de la pila). Al ser éste el operador `*` llama al método `float multiplicar(Pila mem)`.
2. El método multiplicar toma el primer valor/operador de la pila (lo saca). Al ser un número lo toma como `float multiplicando`
3. El método multiplicar toma el primer valor/operador de la pila (lo saca). Al ser un operador `+`  llama al método `float suma(Pila mem)`
4. El método suma funciona de forma similar.
5. Cuando no queden datos en la pila hemos acabado de operar y debemos mostrar el mensaje "El total es: "+ `total`

Deberéis realizar test unitarios con al menos los siguiente casos de prueba:
1. 3 2 * 2 + 4 *
2. 3 2 * 2 + 4 * 3 * 2 + 4 * 3 + 2 * 2 + 4 *

### Instrucciones de entrega

Debe entregarse tanto la clase `CalculadoraRPN` como `TestCalculadoraRPN` y por supuesto la implementación de la clase `Pila`.
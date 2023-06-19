# Ejercicio 5.2

Vamos a probar el funcionamiento de las transacciones. Para vamos a utilizar la bd del tema 1 (concesionario de vehículos).
Los pasos serán:
1. Estableceremos la configuración que habilita las transacciones.
2. Indicaremos que comenzamos una transacción.
3. Consultaremos la tabla de contratos. Debe haber, y mostrar, 1 contrato.
4. Eliminaremos dicho contrato.
5. Consultaremos la tabla de contratos. Debe haber, y mostrar, 0 contratos.
6. Anularemos la transacción.
7. Consultaremos la tabla de contratos. Debe haber, y mostrar, 1 contrato.

*Nota:* Si llegados a este punto no te muestra 1 contrato debes avisar al profesor.

También queremos el caso contrario, esto es, que completemos la transacción. Para ello:
1. Estableceremos la configuración que habilita las transacciones.
2. Indicaremos que comenzamos una transacción.
3. Consultaremos los clientes.
4. Daremos de alta un nuevo cliente de nombre 'Barry' y apellido 'Allen'.
5. Consultaremos la tabla de clientes. Debe mostrarlo.
7. Confirmaremos la transacción.
8. Consultaremos la tabla clientes de nuevo.

*Nota:* Si llegados a este punto no te muestra a 'Barry' debes avisar al profesor.

Y, también:
1. Estableceremos la configuración que habilita las transacciones.
2. Indicaremos que comenzamos una transacción.
3. Consultaremos la tabla de clientes y debe mostrar a 'Barry'.
4. Modificaremos el nombre a 'Flash'.
5. Consultaremos la tabla clientes y ahora deberá aparecer 'Flash Allen'.
6. Anularemos la transacción.
7. Consultaremos la tabla clientes y debe mostrar de nuevo a 'Barry Allen'.

*Nota:* Si llegados a este punto no te muestra a 'Barry' debes avisar al profesor.
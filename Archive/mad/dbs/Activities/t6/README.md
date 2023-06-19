# Práctica 6.1 - Funciones y procedimientos

## Archivos incluidos

+ **deploy.sql:** Despliega la base de datos sin procedimientos ni funciones.
+ **destroy.sql:** Destruye la base de datos.
+ **./functions/** Archivos de despliegue de cada función.
+ **./proceduress/** Archivos de despliegue de cada procedimiento.

---

## Documentación

### ¿Qué vamos a hacer?

Una aplicación para generar automáticamente las nóminas de los trabajadores de distintas empresas.

### ¿Con qué lo vamos a hacer?

Utilizando MariaDB y SQL.

### ¿Cómo se ha hecho?

Creando cada procedimiento y función para mostrar cada parte de la nómina. Seguidamente, un procedimiento que muestra la nómina completa de un contrato, y por último, otro más que muestra todos los contratos en vigor en el mes y año marcados.

### ¿Para qué se ha hecho?

Para aprender a controlar procedimientos y funciones.

### ¿Dónde se ha hecho?

Mitad en casa y mitad en clase.

### ¿Quién lo ha hecho?

Daniel Píriz Cacho.

### ¿Cuándo se ha hecho?

Terminado el 23/3/2023.

---

## Enunciado (incompleto)

**1 Datos del trabajador**

 Se deberá desarrollar un procedimiento que una vez llamado mostrará los datos como en el ejemplo de la nómina proporcionado (T3).

 Deberá llamarse `datos_del_trabajador` y recibirá el `trabajador_id` del trabajador.

**2 Datos de la empresa**

 Se deberá desarrollar un procedimiento que una vez llamado mostrará los datos como en el ejemplo de la nómina proporcionado (T3).

 Deberá llamarse `datos_de_la_empresa` y recibirá el `empresa_id` de la misma.

**3 Días trabajados**

 Se deberán desarrollar una función que facilitado un `mes`, `anho` y `contrato_id`, y nos determine que el número de días totales trabajados

*Esta función deberá llamarse `dias_trabajados`.*

*Como ya sabéis, en España se considera que todos los meses trabajados completamente (desde el primer día al último) contablemente tienen 30 días, siendo ésta una aproximación razonable, y el número de días trabajados en cualquier otro caso.*

 Para seguir dándole forma a la nómina, deberemos crear un procedimiento que imprima.

 ```
     Periodo de liquidación DD/MM/AAAA - DD/MM/AAAA     Nº de días D
```

 Este procedimiento deberá denominarse `periodo_de_liquidacion`.

**3b Días trabajados II**

 Llegados a este punto, te habrás dado cuenta que algo falla. Nosotros hasta ahora trabajábamos con `trabajador_id` (personas) y ahora se nos requiere un `contrato_id` (contrato), por lo que debemos crear un procedimiento que relaciones ambos conceptos en el espacio temporal proporcionado. Este procedimiento, denominado `trabajadores_con_contrato_en_vigor` recibirá el `trabajador_id` , el `mes`y el `anho` , y deberá localizar **TODOS** los trabajadores que tengan, al menos, un contrato en vigor en ese periodo, y llamar a todos los procedimientos de creación de nómina (1), (2), (3),...(7) para cada uno de los contratos en vigor.

 *Recuerda que un trabajador podrá tener más de un contrato en vigor en un mes*
# Ejercicio 11.1

Accede a una base de datos remota utilizando JDBC.

1. Credenciales => Crear URI + `?useLegacyDateTimeCode=false&serverTimezone=Europe/Madrid`.
2. En el método `main`:
```
// Declarar variables

String sql = "SELECT * FROM alumnos;

try (Connection conn = DriverManager.getConnection(URI);
		Statement stat = conn.createStatement();
		ResultSet = stat.executeQuery(sql);
){
	// ...
}
```
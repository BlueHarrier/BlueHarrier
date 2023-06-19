<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://cdn.tailwindcss.com"></script>
	<%! final String TITLE = "Hello JSP!"; %>
	<%!
	/**
	 * Construye el resultado del formulario.
	 * @param Texto Texto que se desea utilizar
	 * @return Texto de salida formateado
	 */
	String buildFormResult (String text) {
		final String HTML_SETTINGS = "class=\"inline-block m-2 text-white px-5 py-2 bg-red-600 rounded-full\"";
		return "<div " + HTML_SETTINGS + ">" + TITLE + "</div>";
	}
	%>
	<%
		String paramString = request.getParameter("parameter");
		int param = 0;
		try {
			param = Integer.parseInt(paramString);
		}
		catch (Exception e){ /*Nada*/ }
		
	%>

	<title><%= TITLE %></title>
</head>
<body class="bg-black">
	<h1 class="shadow-blue-500/50 shadow-lg rounded-lg bg-blue-100 border-2 border-blue-200 font-bold text-blue-600 text-5xl text-center w-11/12 mx-auto my-2 py-6 mx-auto"><%= TITLE %></h1>
	<div class="shadow-red-500/50 shadow-lg my-5 w-11/12 px-8 py-6 m-auto text-center bg-red-100 rounded-lg border-2 border-red-200">
	<form method="post">
		<label for="parameter">Número de repeticiones</label><br/>
		<input type="number" name="parameter" min="0" value=<%= param %> required/><br/>
		<input type="submit"/><br/>
	</form>
	<%-- Imprime el texto especificado tantas veces como se haya expresado en el formulario --%>
	<%
	final String OUTPUT = buildFormResult(TITLE);
	for (int i = 0; i < param; i++){
		out.print(OUTPUT);
	}
	%>
	</div>
</body>
</html>
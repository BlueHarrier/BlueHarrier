import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;

/**
 * Controlador de la calculadora de pila para servidor JakartaEE.
 * @author Daniel "BlueHarrier" Píriz
 * @version 1.0.0
 * @since 29/05/2023
 */

public class ControlPila extends HttpServlet {

    /**
     * Registra peticiones get y realiza las operaciones necesarias en la calculadora.
     * @param Petición Información de la petición
     * @param Respuesta Parámetros de respuesta
     * @throws Error Errores de servlet ó i/o
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String operation = request.getParameter("operation");
        if (operation == null) {
            out.print(0.0);
            return;
        };
        try{
            CalculadoraRPN calculator = new CalculadoraRPN();
            StringTokenizer tokenizer = new StringTokenizer(operation, " ");
            while (tokenizer.hasMoreTokens()){
                calculator.operate(tokenizer.nextToken());
            }
            out.print(calculator.show());
        }
        catch (Exception e){
            out.print("ERROR");
        }
    }
}

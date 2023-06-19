<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>I.E.S. Dos Mares</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>

<body>
    <div id="contenedor">
        <header>
            <div id="home-img">
                <a href="#"><img src="./img/fondoLogo.gif"/></a>
            </div>
            <div id="home">
                <a href="#home">Home</a>
                <a href="#php">PHP</a>
                <a href="#html">HTML</a>
                <a href="#css">CSS</a>
            </div>
        </header>
        <div id="body">
            <div id="sidebar">
                <nav>
                    <form>
                        <input type="text" name="search"/>
                        <input type="submit" value="Search"/>
                    </form>
                </nav>
                <div>
                    <h2>I.E.S. Dos Mares</h2>
                    <p>
                        Nuestro centro <s>se encuentra</s> en la ciudad de <b>San Pedro del Pinatar</b>, 
                        en el barrio de Los Cuarteros, en la <u><b>Calle Cabo San Antonio 22</b></u>.
                    </p>
                </div>
                <div>
                    <h2>FCT</h2>
                    <table>
                        <thead>
                            <tr>
                                <td colspan="2">FCT 2015</td>
                            </tr>
                            <tr>
                                <td>Alumno</td>
                                <td>Empresa</td>
                            </tr>
                        </thead>
                        <tbody>
                            <?php
                            $students = 6;

                            function add_row($id, $marked){
                                if ($marked) echo "<tr class=\"resaltado\">";
                                else echo "<tr>";
                                echo "<td>Alumno $id</td>";
                                echo "<td>Empresa $id</td>";
                                echo "<tr/>";
                            }
                            for ($i = 0; $i < $students; $i++){
                                add_row($i + 1, $i == 1);
                            }
                            ?>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="2">
                                    <form>
                                        <label for="student">Alumno (1-6):</label><input type="number" name="student" size="2"/>
                                        <input type="submit" value="Enviar"/>
                                    </form>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <div>
                    <h2>Departamentos</h2>
                    <p>
                        <a href="#">Ciencias Naturales</a><br/>
                        <a href="#">Educación Física</a><br/>
                        <a href="#">Educación Plástica y Visual</a><br/>
                        <a href="#">Filosofía</a><br/>
                        <a href="#">FOL</a><br/>
                        <a href="#">Francés</a><br/>
                        <a href="#">Geografía e Historia</a><br/>
                        <a href="#">Informática</a><br/>
                        <a href="#">...</a><br/>
                    </p>
                </div>
            </div>
            <div id="content">
                <div id="php">
                    <h2>PHP</h2>
                    <p>
                        a. Desarrolla, con un script de PHP, las <span class="full_dec">celdas correspondientes a la lista
                        de los alumnos y empresas para la FCT</span>(1ptos).<br/>
                        b. Haz que el alumno número 2 aparezca con <span class="full_dec">class="resaltado"</span>(1ptos).<br/>
                        c. Haz un formulario en la última fila de la tabla en la que se pueda elegir el
                        alumno a resaltar(2ptos).<br/>
                    </p>
                </div>
                <div id="html">
                    <h2>HTML</h2>
                    <p>
                        a. Inserta la imagen de la cabecera.<br/>
                        b. Haz que la imagen de la cabecera tenga un enlace a la web
                        http://iesdosmares.murciaeduca.es.<br/>
                        c. Haz que cada uno de los elementos del menu lleve al enlace interno de cada
                        uno de los post.<br/>
                        d. Haz que cada uno de los apartados del sidebar de la izquierda aparezcan como
                        títulos de tamaño 2.<br/>
                        e. El texto <span class="full_dec">San Pedro del Pinatar</span> de la izquierda ponlo en negrita.<br/>
                        f. El texto <span class="full_dec">se encuentra</span> de la izquierda táchalo.<br/>
                        g. El texto <span class="full_dec">Cabo San Antonio 22</span> de la izquierda subráyalo enfatizándolo.
                    </p>
                </div>
                <div id="css">
                    <h2>CSS</h2>
                    <p>
                        a. El color por defecto de las letras es <span class="full_dec">darkblue</span>.<br/>
                        b. La imagen de fondo de la web es <span class="full_dec">fondo.gif</span>.<br/>
                        c. El tamaño de fuente por defecto debe ser de 13px.<br/>
                        d. El ancho de la caja <span class="full_dec">contenedor</span> debe ser de <span class="full_dec">900px</span> y debe estar centrada.<br/>
                        e. La lista del menú no debe llevar <span class="full_dec">ningún</span> estilo y sus elementos deben aparecer
                        en la misma fila <span class="full_dec">apilados a la izquierda</span>.<br/>
                        f. La caja "content" debe estar posicionada a la <span class="full_dec">derecha</span> y con una anchura de
                        <span class="full_dec">550px</span> mientras que la caja "sidebar" debe estar posicionada a la izquierda y
                        con una anchura de <span class="full_dec">280px</span>.<br/>
                    </p>
                </div>
            </div>
        </div>
        <footer>
            <div id="lmsgi">Lenguajes de Marca.</div>
            <div id="year">Curso: <a href="#">22/23</a>.</div>
            <div id="school">I.E.S. <a href="#">Dos Mares</a>.</div>
        </footer>
    </div>
</body>

</html>
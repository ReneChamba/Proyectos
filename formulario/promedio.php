<?php

// Iniciar sesión
session_start();

 // Desactivar los errores
  error_reporting(0);

// Crear variables tipo sesion:
$_SESSION['$_nombre'] = $_POST['name'];
$_SESSION['$_curso'] = $_POST['curso'];
$_SESSION['$_paralelo'] = $_POST['paralelo'];
$_SESSION['$_materia'] = $_POST['materia'];


// Obtener los valores de los input 
$nombre = $_POST['name'];
$curso = $_POST['curso'];
$paralelo = $_POST['paralelo'];
$materia = $_POST['materia'];

?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/styleControl.css" />
    <title>Form  | Promedio</title>
     <link rel="icon" type="image/png" href="/img/logo.png" />
    <?php
    
      if ($nombre ==null || $nombre ==''){

        echo "<div class = \"container container--errores\"> 
                <h1 class = \"title title--errores\" >mensaje del sistema</h1>
                <p class = \"paragrah\">Para acceder a este formulario, es necesario rellenar los campos de la pagina anterior.</p>
                <a  href = \"notas.php\"  class = \"enlaces\">regresar al anterior<a/>
              </div>";
      die();
    }
    ?>

  </head>
  <body>
    <div class="container container--promedio">
      <h1 class="title title--notas">ingreso de calificaciones</h1>

      <div class="datos--promedio">
        <div class="mostrar">
          <h2 class="subtitulo">datos personales</h2>
          <div class="mostrar__datos">
            <span>el nombre es:</span>
            <input
              type="text"
              name="nombre"
              value="<?php echo $nombre?>"
              class="form__input"
              readonly
            />
          </div>
          <div class="mostrar__datos">
            <span>el curso es:</span>
            <input
              type="text"
              name="curso"
              value="<?php echo $curso?>"
              class="form__input"
              readonly
            />
          </div>
          <div class="mostrar__datos">
            <span>el paralelo es:</span>
            <input
              type="text"
              name="paralelo"
               value="<?php echo $paralelo?>"
               class="form__input"
               readonly
            />
          </div>
          <div class="mostrar__datos">
            <span>la materia es:</span>
            <input
              type="text"
              name="materia"
               value="<?php echo $materia?>"
               class="form__input"
               readonly
            />
          </div>
        </div>

        <form action="finalpromedio.php" class="form form--promedio" method="POST" autocomplete="off">
          <h2 class="subtitulo">ingrese calificaciones</h2>

          <table class="table">
            <!-- encabezado -->
            <thead class="table__head">
              <tr>
                <th>trabajos autonomos</th>
                <th>actividad docente</th>
                <th>actividad practica</th>
                <th>evaluación final</th>
              </tr>
            </thead>

            <!-- cuerpo de la tabla -->
            <tbody>
              <tr>
                <td>
                  <input
                    type="number"
                    name="trabajo_autonomo"
                    min="0"
                    max="10"
                    step="0.1"
                    class="form__input"
                    required
                  />
                </td>
                <td>
                  <input
                    type="number"
                    name="actividad_docente"
                    min="0"
                    max="10"
                    step="0.1"
                    class="form__input"
                    required
                  />
                </td>
                <td>
                  <input
                    type="number"
                    name="actividad_practica"
                    min="0"
                    max="10"
                    step="0.1"
                    class="form__input"
                    required
                  />
                </td>
                <td>
                  <input
                    type="number"
                    name="evaluacion_final"
                    min="0"
                    max="10"
                    step="0.1"
                    class="form__input"
                    required
                  />
                </td>
              </tr>
            </tbody>
          </table>
          <input
            type="submit"
            value="enviar"
            class="form__submit form__enviar"
          />
        </form>
      </div>
    </div>
  </body>
</html>

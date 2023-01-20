<?php

// Iniciar sesión
session_start();

// Desactivar los errores
  error_reporting(0);

// Leer variables de sesión
// $_SESSION['$_nombre'] ;
// $_SESSION['$_curso'] ;
// $_SESSION['$_paralelo'];
// $_SESSION['$_materia'] ;


// Obtener los valores de los input number
$trabajosAutonomos = $_POST['trabajo_autonomo'];
$actividadDocente = $_POST['actividad_docente'];
$actividadPractica = $_POST['actividad_practica'];
$evaluacionFinal = $_POST['evaluacion_final'];

// Procesos
$suma = ($trabajosAutonomos+ $actividadDocente + $actividadPractica + $evaluacionFinal);
$promedioFinal = $suma/4;

// Estado
$estadoAlumno = "APROBADO";
if($promedioFinal<7){
  $estadoAlumno = "REPROBADO";

}

?>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Resultado Calificaciones</title>
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/styleControl.css" />
    
    <?php
    
    if ($_SESSION['$_nombre'] ==null || $_SESSION['$_nombre'] ==''){

      echo "<div class = \"container container--errores\"> 
        <h1 class = \"title title--errores\" >mensaje del sistema</h1>
        <p class = \"paragrah\">Para acceder a este formulario, es necesario rellenar los campos del formulario notas.</p>
        <a  href = \"control.php\"  class = \"enlaces\">ir a formulario notas<a/>
      </div>";
      die();
    }
    ?>


  </head>
  <!-- number_format(valor, numerodecimales) en php -->
  <body>
    <div class="container container--promedio container--promedio--final">
      <h1 class="title title--notas">resultado de calificaciones</h1>

      <div class="datos--promedio">
        <div class="mostrar">
          <h2 class="subtitulo">datos personales</h2>
          <div class="mostrar__datos">
            <span>nombre :</span>
            <input
              type="text"
              name="nombre"
              value="<?php echo  $_SESSION['$_nombre'] ;?>"
              class="form__input"
              readonly
            />
          </div>
          <div class="mostrar__datos">
            <span>curso :</span>
            <input
              type="text"
              name="curso"
              value="<?php echo  $_SESSION['$_curso'] ;?>"
              class="form__input"
              readonly
            />
          </div>
          <div class="mostrar__datos">
            <span>paralelo :</span>
            <input
              type="text"
              name="paralelo"
               value="<?php echo  $_SESSION['$_paralelo'] ;?>"
               class="form__input"
               readonly
            />
          </div>
          <div class="mostrar__datos">
            <span>materia :</span>
            <input
              type="text"
              name="materia"
              value="<?php echo  $_SESSION['$_materia'] ;?>"
              class="form__input"
              readonly
            />
          </div>
        </div>

        <div class="container container--promediofinal">
          <h2 class="subtitulo">notas calificaciones</h2>

          <table class="table">
            <!-- encabezado -->
            <thead class="table__head">
              <tr>
                <th>trabajo autonomo</th>
                <th>actividad docente</th>
                <th>actividad practica</th>
                <th>evaluación final</th>
                <th>suma</th>
                <th>promedio</th>
              </tr>
            </thead>

            <!-- cuerpo de la tabla -->
            <tbody>
              <tr>
                <td>
                  <input
                    type="text"
                    name="trabajo__autonomo"
                    value ="<?php echo $trabajosAutonomos;?>"
                    class="form__input"
                    readonly
                  />
                </td>
                <td>
                  <input
                    type="text"
                    name="actividad__docente"
                    value ="<?php echo $actividadDocente;?>"
                    class="form__input"
                    readonly
                  />
                </td>
                <td>
                  <input
                    type="text"
                    name="actividad__practica"
                    value ="<?php echo $actividadPractica;?>"
                    class="form__input"
                    readonly
                  />
                </td>
                <td>
                  <input
                    type="number"
                    name="evaluacion__final"
                    value ="<?php echo $evaluacionFinal;?>"
                    class="form__input"
                    readonly
                  />
                </td>

                <td>
                  <input type="text" name="suma" 
                  value ="<?php echo $suma;?>" 
                  readonly class="form__input" />
                </td>
                <td>
                  <input
                    type="number"
                    name="promedio"
                    value ="<?php echo  number_format( $promedioFinal, 2);?>"
                    class="form__input"
                    readonly
                  />
                </td>
              </tr>
            </tbody>
          </table>

          <div class="estado">
            <span>estado alumnno : <?php echo $estadoAlumno ;?> </span>
            <p class="estado__alumno"></p>
          </div>
          <a  href = "index.php"  class= "form__submit form__enviar">
          volver al inicio
           
          </a>
        </div>
      </div>
    </div>
  </body>
</html>

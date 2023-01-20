<?php

 // Desactivar los errores
error_reporting(0);

$multiplicador =$_POST['numero'];
$numeroInicio =$_POST['numeroInicio'];
$numeroFinal =$_POST['numeroFinal'];

?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/styleControl.css" />
    <title>Form | Resultados</title>
     <link rel="icon" type="image/png" href="/img/logo.png" />
      <?php
        if ($multiplicador ==null || $multiplicador ==''){

      echo "<div class = \"container container--errores\"> 
        <h1 class = \"title title--errores\" >mensaje del sistema</h1>
        <p class = \"paragrah\">Para acceder a este formulario, es necesario rellenar los campos de la pagina anterior.</p>
        <a  href = \"tabla.php\"  class = \"enlaces\">regresar al anterior<a/>
      </div>";
      die();
    }
    ?>


  </head>
  <body>
    <div class="container container--resultado">
      <h1 class="title title--resultado">Resultados</h1>
      <div class="datos__tabla">
        <div class="datos__valores">
          <div class="multiplicador">
            <span>multiplicador: </span>
            <input
              type="text"
              name="multiplicador"
              id="multiplicador"
              class="form__input"
              value = "<?php echo $multiplicador?>"
              readonly
            />
          </div>

          <div class="valor__Multiplicar">
            <div class="valor__inicio">
              <span>inicio : </span>
              <input
                type="text"
                name="multiplicador"
                id="multiplicador"
                value = "<?php echo $numeroInicio?>"
                class="form__input"
                readonly
              />
            </div>

            <div class="valor__final">
              <span>final: </span>
              <input
                type="text"
                name="multiplicador"
                id="multiplicador"
                value = "<?php echo $numeroFinal?>"
                class="form__input"
                readonly
              />
            </div>
          </div>
        </div>
        <?php

        for($inicio = $numeroInicio;$inicio<=$numeroFinal;$inicio++){ ?>

        <div class="datos-resultado">
          <?php  echo $inicio." * ".$multiplicador." = " ?>
          <span class="datos__span--resul">
            <?php echo "".($inicio*$multiplicador) ?>
          </span>
        </div>

        <?php 
        }
        
        ?>
      </div>
    </div>
  </body>
</html>

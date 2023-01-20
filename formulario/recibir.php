<?php

    // Desactivar los errores
    error_reporting(0);

    $nombre = $_POST['name'];
    $email = $_POST['email'];
    $ocupacion = $_POST['ocupacion'];
    $sexo = $_POST['sexo'];
  

?>



<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Recibir Información</title>
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/styleControl.css" />

    <?php
    
    if ($nombre ==null || $nombre ==''){

      echo "<div class = \"container container--errores\"> 
        <h1 class = \"title title--errores\" >mensaje del sistema</h1>
        <p class = \"paragrah\">Para acceder a este formulario, es necesario rellenar los campos de la pagina anterior.</p>
        <a  href = \"control.php\"  class = \"enlaces\">regresar al anterior<a/>
      </div>";
      die();
    }
    ?>

  </head>
  <body>
    <div class="container container--recibir--datos">
      <h1 class="title title--recibir--datos">información recibida</h1>

      <div class="imagen">
        <img
          src="img/fondoUsuario.png"
          alt="logo"
          title="logo usuario"
          class="imagen__img"
        />
      </div>

      <form class="form form__datos--recibir">
  

        <div class="datos--nombre datos__recibir">
          <label for="name">nombre:</label>
          <input type="text"  value = "<?php  echo $nombre?>" class="form__input" readonly />
        </div>
        <div class="datos--email datos__recibir">
          <label for="name">email:</label>
          <input type="email" value = "<?php  echo $email?>"  class="form__input" readonly />
        </div>
        <div class="datos--ocupacion datos__recibir">
          <label for="name">ocupación:</label>
          <input type="text" value = "<?php  echo $ocupacion?>"  class="form__input" readonly />
        </div>
        <div class="datos--sexo datos__recibir">
          <label for="name">sexo:</label>
          <input type="text" value = "<?php  echo $sexo?>"  class="form__input" readonly />
        </div>  

        <a href="index.php" class="enlaces">regresar inicio</a>
      </form>
    </div>
  </body>
</html>

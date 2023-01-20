<?php
  session_start();
  
//Cerrar sesion
session_destroy(); ?>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/style.css" />
    <title>Form</title>
    <link rel="icon" type="image/png" href="img/logo.png" />
    
  </head>
  <body>
    <!-- <div class="container"> -->
    <main class="container--grid container">
      <h1 class="title title--menu">menú principal</h1>
      <div class="container-flex">

      
      <div class="item__grid">
        <figure class="imagen">
          <img src="img/registrosform.png" alt="" class="imagen__img" />
        </figure>
        <p class="paragrah">
          permite registrar datos personales de un usuario por medio de un
          formulario, posterior se guarda en la base de datos.
        </p>
        <a href="control.php" class="enlaces enlaces--link"
          >control de formularios</a
        >
      </div>

      <div class="item__grid">
        <figure class="imagen">
          <img src="img/iconoMultiplicar.jpg" alt="" class="imagen__img" />
        </figure>
        <p class="paragrah">
          realiza una tabla de multiplicar de un número dado, entre un rango de
          números ingresados.
        </p>
        <a href="tabla.php" class="enlaces enlaces--link"
          >calculos de formularios</a
        >
      </div>
      <div class="item__grid item__grid--notas">
        <figure class="imagen">
          <img src="img/calificaciones.png" alt="" class="imagen__img" />
        </figure>
        <p class="paragrah">
          registra datos de un usuario, ademas se ingresan notas de varias
          actividades, finalmente se obtiene el promedio de las notas
          ingresadas.
        </p>
        <a href="notas.php" class="enlaces enlaces--link"
          >calculos de calificaciones</a
        >
      </div>
      </div>
    </main>
    <!-- </div> -->
  </body>
</html>

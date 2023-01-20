<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="assets/css/normalize.css">
    <link href="https://file.myfontastic.com/JUwFAwWE8oUWFGdiTZSWaX/icons.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/principal.css">
    <title>SimpleCode</title>
  </head>
  <body>
    <div class="container-main">

     <?php
      require "php/header.php";
      require "php/banner.php";
      require "php/content.php";
      require "php/footer.php";
     ?>
      
      <!-- <div class="container container--header">
        <div class="content content--header">
          <h1 class="title">Simple<span>Code</span> </h1>
          <div class="content-menu-search" id="content-menu-search-js">
            <nav class="menu">
              <span class="icon-menu" id="icon-menu-js"></span>
              <ul class="lista" id="lista-js">
                <li class="lista__item">
                  <a href="#" class="lista__link">Inicio</a>
                </li>
                <li class="lista__item">
                  <a href="#" class="lista__link">Contacto</a>
                </li>
                <li class="lista__item">
                  <a href="#" class="lista__link">Item 3</a>
                </li>
                <li class="lista__item lista__item--search">
                 <input
                  type="text"
                  name="search"
                  placeholder="Ingresa algo para buscar"
                 />
                </li>
             </ul>
           </nav>
           <div class="search">
            <input type="text" class ="search__busqueda"placeholder="Escribe algo..." >
            <span class="icon-search"></span>
           </div>
          </div>
        </div>
      </div> -->
      <!-- <div class="container container--banner">
        <div class="slider"  id="slider-container">
           <section class="slider__imagenes" id ="slider-imagenes"></section>
           <section class="slider__navigation content" id="slider-navigation"> </section>
        </div>
       
        <section class="content content--intro">
          <h2 class="subtitle">Hola soy <span class="portafolio">Ronny Chamba</span> </h2>
          <p class="paragraph">
           Bienvenido a mi Portafolio, donde encontraras mis proyectos realizados.
          </p>
          <div class="buttons">
            <a href="#" class="buttons__enlace">Proyectos</a>
          </div>
        </section>
      </div> -->

      <!-- <div class="container container--content">
        <main class="content--main">
          <section class="description content">
            <h3 class="description__subtitle">
            ¿Qué encontraras aqui?
            </h3>
            <p class="description__paragraph paragraph">
              Encontraras algunos de mis trabajos que he realizado en la Universidad.

            </p>
          </section>
          <div class="lamina">
            <section class="grid-container content" id="grid-container-js">
             <article class="tarjeta" id="codfast">
              <div class="tarjeta__img">
                <img src="assets/img/paginaweb.png" alt="" class="img" />
                <span class="lenguaje">HTML</span>
              </div>
              <div class="tarjeta__text">
                <h3 class="subtitle">CodFast</h3>
                <p class="paragraph">
                 En CodFast encontraras ejemplos de tips sobre Java, que te permitira recordarar
                 con facilidad ciertos temas.
                  <p class="pargraph fecha"><span class="icon-calendar"></span> 2021-01-15</p>
                </p>
              </div>
              </article>
               <article class="tarjeta" id="notas">
                <div class="tarjeta__img">
                 <img src="assets/img/paginaweb.png" alt="" class="img" />
                 <span class="lenguaje">HTML</span>
                </div>
                <div class="tarjeta__text">
                  <h3 class="subtitle">Ingreso de notas</h3>
                  <p class="paragraph">
                  En CodFast encontraras ejemplos de tips sobre Java, que te permitira recordarar
                   con facilidad ciertos temas.
                  <p class="pargraph fecha"><span class="icon-calendar"></span> 2021-01-15</p>
                  </p>
                </div>
              </article>
               <article class="tarjeta" id="formulario2">
                <div class="tarjeta__img">
                 <img src="assets/img/paginaweb.png" alt="" class="img" />
                  <span class="lenguaje">HTML</span>
                </div>
                <div class="tarjeta__text">
                 <h3 class="subtitle">Manejo de formularios</h3>
                  <p class="paragraph">
                   En CodFast encontraras ejemplos de tips sobre Java, que te permitira recordarar
                   con facilidad ciertos temas.
                  <p class="pargraph fecha"><span class="icon-calendar"></span> 2021-01-15</p>
                </p>
              </div>
              </article>
               <article class="tarjeta" id="restaurante">
                <div class="tarjeta__img">
                  <img src="assets/img/paginaweb.png" alt="" class="img" />
                  <span class="lenguaje">HTML</span>
                </div>
                <div class="tarjeta__text">
                  <h3 class="subtitle">Restaurante (Editado)</h3>
                  <p class="paragraph">
                   En CodFast encontraras ejemplos de tips sobre Java, que te permitira recordarar
                  con facilidad ciertos temas.
                  <p class="pargraph fecha"><span class="icon-calendar"></span> 2021-01-15</p>
                  </p>
              </div>
              </article>
            </section>
          </div>
        </main>
      </div> -->
      <!-- <div class="container container--footer">
        <footer class="content content--footer">

          <div class="group-column">
            <div class="column-33">
              <h3 class="subtitle">Sobre mi</h3>
              <p class="paragraph"> <span class="icon-user"></span> Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                 Enim quas molestias totam placeat praesentium ex quo, temporibus laudantium 
                 aliquam officia aperiam, tempora nulla animi ipsam, maxime optio repellat eum? Id.</p>
            </div>
            <div class="column-33">
               <h3 class="subtitle">Contáctame</h3>
               <p class="paragraph"> <span class ="icon-mail"></span>ronnychamba96@gmail.com</p>
                <p class="paragraph"> <span class ="icon-mail"></span>ronny.leo2011@gmail.com</p>
            </div>
            <div class="column-33">
               <h3 class="subtitle">Sigueme en mis redes sociales</h3>
               <p class="paragraph"> <span class="icon-facebook"> <a href ="#">Facebook</a> </span></p>
                <p class="paragraph"><span class="icon-instagram"> <a href ="#">Instagram</a> </span></p>
                <p class="paragraph"> <span class="icon-youtube"> <a href ="#">Youtube</a> </span></p>
            </div>
          </div>
          <p class="paragraph autor ">
             &copy; 2021 Ronny Chamba
          </p>
        </footer>
       </div> -->
  </div>
  <script src="assets/js/slider.js"></script>
  <script src="assets/js/menu.js" type="module"></script>
  <script src="assets/js/abrir_enlaces.js" type="module"></script>

  </body>
</html>

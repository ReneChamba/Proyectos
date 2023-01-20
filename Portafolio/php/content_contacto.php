<div class="container container--content">
  <main class="content content--main--contacto">
    <!-- <h2 ckass ="subtitle subtitle--contacto">Cont&aacuteme</h2> -->
    <div class="container-flex">
      <div class="contact-information  column column--50">
        <h3 class="column__title">Informaci&oacute;n de contacto</h3>
        <p class="column__txt">
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Delectus
            aliquid ratione corrupti, magnam deserunt ex praesentium illum
        </p>
        <p class="column__txt"><span class="icon-phone"></span> Tel&eacute;fono 1: 0983806227</p>
        <p class="column__txt"><span class="icon-phone"></span> Tel&eacute;fono 2: 0985793370</p>
        <p class="column__txt"><span class="icon-location"></span> Santo Domingo, Ecuador</p>
        <p class="column__txt"><span class="icon-mail"></span>ronnychamba96@gmail.com</p>
        <!-- <div class="social-icon">
          <a href="#" class="social-icon__link" title="Facebook"><span class="icon-facebook"></span
              ></a>
          <a href="#" class="social-icon__link" title="Twitter"><span class="icon-twitter"></span
              ></a>
          <a href="#" class="social-icon__link" title="Email"><span class="icon-mail"></span
              ></a>
        </div> -->
      </div>
      <form action="#" method="POST" class="form column column--50">
        <label for="" class="formulario__label">Nombre</label>
          <input
              type="text"
              name="nombre"
              class="formulario__input-txt"
              required
            />
          <label for="" class="formulario__label">Correo:</label>
          <input
              type="email"
              name="email"
              class="formulario__input-txt"
              required
          />
          <label for="" class="formulario__label">Tel&eacute;fono:</label>
          <input
              type="number"
              name="telefono"
              class="formulario__input-txt"
              required
          />
          <label for="" class="formulario__label">Mensaje:</label>
          <textarea
              name="mensaje"
              id=""
              cols="30"
              rows="10"
              class="formulario__textarea"
              required
              maxlength="150"
          >
          </textarea>
          <input
              type="submit"
              class="btn form__btn"
              value="Enviar"
              title="Click para enviar"
          />
      </form>
   
      
    </div>
  </main>
</div>
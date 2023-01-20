<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/styleControl.css" />
    <title>Form | Control Formularios</title>
    <link rel="icon" type="image/png" href="/img/logo.png" />
    
  </head>
  <body>
    <div class="container container--control">
      <div class="content">
        <h1 class="title title--control">control formularios</h1>
        <form action="recibir.php" class="form form--control" method="POST" autocomplete="off">
          <input
            type="text"
            name="name"
            id="name"
            placeholder="&#128100; Nombre"
            required
            class="form__input"
            />
          <input
           type="email"
           name="email"
           id="email"
           placeholder="&#128231; Email"
           required
           class="form__input"
            />
          <div class="ocupacion">
           <label for="ocupacion" class="ocupacion__title">ocupación</label>
           <div class="ocupacion__tipo">
             <div class="estudiante">
              <input
                type="radio"
                name="ocupacion"
                value="Estudiante"
                id="estudiante"
                checked
                class="container__form__input"
                
              />
              <label for="estudiante">Estudiante</label>
             </div>

              <div class="profesional">
                <input
                type="radio"
                name="ocupacion"
                value="Profesional"
                id="profesional"
                class="container__form__input"
                />
                <label for="profesional">Profesional</label>
              </div>
              <div class="hogar">
                <input
                 type="radio"
                 name="ocupacion"
                 value="Hogar"
                 id="hogar"
                 class="container__form__input"
                />
                <label for="hogar">Hogar</label>
              </div>
          </div>
        </div>

        <div class="sexo">
          <label for="sexo" class="sexo__title">Sexo</label>
          <select name="sexo" id="sexo" class="sexo__select">
            <option value="Femenino">Femenino</option>
            <option value="Masculino" selected>Masculino</option>
            <option value="Otros">Otros</option>
          </select>
        </div>

        <input
          type="submit"
          name="btn"
          id="btn"
          value="pasar información"
          class="form__submit"
        />
      </form>
       </div>
    </div>
  </body>
</html>

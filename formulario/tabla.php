<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/styleControl.css" />
    <title>Form | Tabla Multiplicar</title>
     <link rel="icon" type="image/png" href="/img/logo.png" />
  </head>
  <body>
    <div class="container container--tabla">
      <h1 class="title">tabla de multiplicar</h1>

      <form action="resultado.php" class="form form--tabla" method="POST" autocomplete="off">
        <div class="container__datos">
          <label for="numero">Ingrese número tabla:</label>
          <input
            type="text"
            name="numero"
            id="numero"
            required
            class="form__input"
          />
        </div>
        <div class="container__datos">
          <label for="numeroInicio">Ingrese número inicio:</label>
          <input
            type="text"
            name="numeroInicio"
            id="numero"
            required
            class="form__input"
          />
        </div>
        <div class="container__datos">
          <label for="numeroFinal">Ingrese número final:</label>
          <input
            type="text"
            name="numeroFinal"
            id="numero"
            required
            class="form__input"
          />
        </div>
        <input
          type="submit"
          name="btn"
          id="btn"
          value="calcular"
          class="form__submit"
        />
      </form>
    </div>
  </body>
</html>

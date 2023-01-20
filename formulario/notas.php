<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="estilos/mainGenerales.css" />
    <link rel="stylesheet" href="estilos/styleControl.css" />
    <title>Form | Notas</title>
     <link rel="icon" type="image/png" href="/img/logo.png" />
  </head>
  <body>
    <div class="container container--notas">
      <h1 class="title title--notas">promedio de calificaciones</h1>
      <form action="promedio.php" class="form form--notas" method="POST" autocomplete="off">
        <input
          type="text"
          name="name"
          id="name"
          placeholder="&#128100; Nombre"
          required
          class="form__input"
        />
        <div class="curso">
          <label for="curso" class="curso__title">seleccione curso :</label>
          <select name="curso" id="sexo" class="curso__select">
            <option value="Primero">Primero</option>
            <option value="Segundo">Segundo</option>
            <option value="Tercero">Tercero</option>
          </select>
        </div>

        <div class="paralelo">
          <label for="paralelo" class="paralelo__title"
            >seleccione paralelo :</label
          >
          <div class="paralelo__tipo">
            <div class="para--A">
              <input
                type="radio"
                name="paralelo"
                value="A"
                id="paralelo--A"
                checked
                class="container__form__input"
              />
              <label for="paralelo--A">A</label>
            </div>

            <div class="para--B">
              <input
                type="radio"
                name="paralelo"
                value="B"
                id="paralelo--B"
                class="container__form__input"
              />
              <label for="paralelo--B">B</label>
            </div>
            <div class="para--C">
              <input
                type="radio"
                name="paralelo"
                value="C"
                id="paralelo--C"
                class="container__form__input"
              />
              <label for="paralelo--C">C</label>
            </div>
          </div>
        </div>

        <div class="materia">
          <label for="materia" class="materia__title"
            >seleccione materia :</label
          >
          <select name="materia" id="materia" class="materia__select">
            <option value="Programacion 1">Programacion 1</option>
            <option value="Base Datos">Base Datos</option>
            <option value="Desarrollo Web" selected>Desarrollo Web</option>
            <option value="Sistemas Operativos">Sistemas Operativos</option>
            <option value="Arquitectura">Arquitectura</option>
          </select>
        </div>

        <input
          type="submit"
          name="btn"
          id="btn"
          value="enviar datos"
          class="form__submit"
        />
      </form>
    </div>
  </body>
</html>

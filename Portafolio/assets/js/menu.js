// Elemento que contiene al nav y un div(contiene los elementos de la busqueda)
const $contentMenuSearch = document.getElementById("content-menu-search-js");
$contentMenuSearch.addEventListener("click", (e) => eventClick(e));

const desplejarMenuBuscador = (element, claseAdd, iconoOcocultar) => {
  $contentMenuSearch.querySelector(element).classList.toggle(claseAdd);

  // La clase que le add al icono le quito el primer caracter 0(es un .)
  $contentMenuSearch
    .querySelector(iconoOcocultar)
    .classList.toggle(
      iconoOcocultar.substring(1, iconoOcocultar.length) + "--hide"
    );
};

const eventClick = (e) => {
  // Verificar sobre que etiqueta se hizo click
  if (e.target.tagName === "SPAN") {
    // Cambia de icono al span precionado
    e.target.classList.toggle("icon-close");

    // Obtengo la clase del span clickeado para luego validar cual es
    let nombreClase = e.target.classList[0];

    let elemento = "";
    let claseAgregar = "";
    let iconoOcultar = "";

    // Verificar en que span se hizo click
    if (nombreClase.toLowerCase() === "icon-menu") {
      elemento = ".lista"; // elemento al que se add clase para que se visible
      claseAgregar = "lista--view"; // Clase add
      iconoOcultar = ".icon-search"; // icono ha ocultar
    }
    if (nombreClase.toLowerCase() === "icon-search") {
      elemento = ".search__busqueda"; // elemento al que se add clase para que se visible
      claseAgregar = "search--view"; // Clase add
      iconoOcultar = ".icon-menu"; // icono ha ocultar
    }

    desplejarMenuBuscador(elemento, claseAgregar, iconoOcultar);
    console.log($contentMenuSearch);
  }
};

// Array de imagenes
let imagenes = [
  "assets/img/0.jpg",
  "assets/img/1.jpg",
  "assets/img/2.jpg",
  "assets/img/3.jpg",
  "assets/img/4.jpg",
];

// Elemento general del slider
const $sliderContainer = document.getElementById("slider-container");

// Elemento para cargar el slider
const $slider = document.getElementById("slider-imagenes");

// Establecer el ancho del slider en función del número de imagenes
$slider.style.width = imagenes.length * 100 + "%";

// Elemento para cargar la navegación
const $sliderNav = document.getElementById("slider-navigation");

// Variable para saber si el slider esta activo
let active = true;

// Evento para saber si el ratón esta sobre el slider
$sliderContainer.addEventListener("mouseover", () => {
  // Si el mouse esta sobre la imagenes se detendra el slider
  if (active) active = false;
});

// Evento para saber si el ratón NO esta sobre el slider
$sliderContainer.addEventListener("mouseout", () => {
  // Si el mouse sale de imagenes se reiniciara nuevamente el slider
  if (!active) active = true;
});

// Evento al pulsar en los botones de navegación
$sliderNav.addEventListener("click", (e) => slideImage(e.target.id.slice(-1)));

// Dibujar slider y navegación | esta fuera de cualquier funcion porque cargara apenas
// se lea el archivo
for (let img in imagenes) {
  // Cargar imagenes, codigo html

  // La ruta me toco buscar la manera, ya que poniendo "../img/1.jpg" , no entraba la imagen
  $slider.innerHTML += `<img src="${
    imagenes[img]
  }"  class="slider__img"  alt ="Juego Ahorcado"  style ="width:${
    100 / imagenes.length
  }%"/>`;

  // Cargar navegación
  $sliderNav.innerHTML += `<span class =" ${
    img == 0 ? "slider-nav slider-nav--active" : "slider-nav"
  }" id ="slider-nav-${img}"></span>`;
}

// Variable contador de imagenes
let cont = 0;

// Intervalo de tiempo para el contador
// Lanzo un intervalor cada cierto tiempo, mediante el metodo setInterval()
const starInterval = () => setInterval(counter, 2000);

// Iniciar el contador
starInterval();

// Función que cambia de imagen

function counter() {
  // Comprobar si la variable active en true

  if (active) {
    // La sumo antes porque la primera foto estara apenas cargue la pagina, xq si no esta estara cuatro segundos
    cont++;
    if (cont >= imagenes.length) cont = 0;

    // Mueve la imagen
    setInterval(slideImage(cont), 2000);

    // Marca las viñetas de la imagen enque se encuentra
    setInterval(setActive(cont), 2000);
  }
}

let banderaLeftRight = true;

function slideImage(id) {
  // Comprobar que sea un numero, x si acaso
  if (!active && !isNaN(id)) {
    cont = id;
    setActive(id);
  }

  $slider.style.left = "-" + id + "00%";
}

// Obtener los elementos span del navigation: devuelve un HTMLCollection, pero con los [...HTMLCOLLECTION], se lo convierte a un array
const navIcons = [...document.querySelectorAll(".slider-nav")];

function setActive(id) {
  // SEGUNDA FORMA,  A PARTIR DE ECM6
  // .slice()--> devulve un caracter especificado  de una cadena
  navIcons.map((idValue) =>
    idValue.attributes.id.nodeValue.slice(-1) == id
      ? idValue.classList.add("slider-nav--active")
      : idValue.classList.remove("slider-nav--active")
  );
}

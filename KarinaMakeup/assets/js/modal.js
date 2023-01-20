// Obtener todos los elementos que tenga ese selector-->[]
const imagenes = document.querySelectorAll(".gallery__modal");

// Obtener el modal
const modal = document.getElementById("modal");

// Obtener la imagene donde se mostrara la imagen seleccionada
const img = document.getElementById("modal__img");

// Obtener la imagene donde se mostrara la imagen seleccionada
const imgBig = document.getElementById("modal__img--big");

// Obtener el elemento h2
const subtitle = document.getElementById("modal__subtitle");

// Obtener el boton de cerrar el modal
const boton = document.getElementById("modal__boton");

// Rrecorrer cada una de las imagenes
for (let i = 0; i < imagenes.length; i++) {
  // Poner a la escucha cada una de las imagenes contenidas en el arreglo 'imagenes'
  imagenes[i].addEventListener("click", (e) => {
    // togle, pone/quita una clase
    modal.classList.toggle("modal__open");

    // Obtener atributo src de la imagen
    const src = e.target.src;

    // Pasar el atributo a la imagen del modal, puede ser cualquier atributo
    // img.setAttribute("src", src);

    // Obtener el atributo alt de la img para mostrar el h2 del modal
    const textoAlt = e.target.alt;
    // Ubicar texto
    subtitle.innerText = textoAlt;

    // bton del whatsap de la ventana modal
    const botonWhatsapp = document.getElementById("icon_whatsapp");

    // texto que aparecera como mensaje de whatsapp
    const href = `https://wa.me/593982975576?text=Hola%20Karina%20Hidalgo,%20necesito%20información%20por%20el%20servicio %20de:%20"${textoAlt}",%20gracias.`;
    // Pasar valor para el atributo
    botonWhatsapp.setAttribute("href", href);

    // Obtener las clases de la lista, para saber si es una de las imagenes grandes, ya que toca modifar su tamaño

    const clases = e.target.classList;

    //
    const claseModalImg = img.classList;
    const claseModalBig = imgBig.classList;

    const estadoImg = verificarClaseShow(claseModalImg);
    const estadoImgBig = verificarClaseHidden(claseModalBig);

    if (clases.length > 1) {
      imgBig.setAttribute("src", src);

      //
      if (estadoImg) {
        img.classList.remove("modal__img__show");
        // img.classList.add("modal__img__hidden");
      }
      if (estadoImgBig) {
        imgBig.classList.remove("modal__img__hidden");
        imgBig.classList.add("modal__img__show");
      } else {
        imgBig.classList.add("modal__img__show");
      }
    } else {
      img.setAttribute("src", src);
      if (!estadoImgBig) {
        imgBig.classList.remove("modal__img__show");
        imgBig.classList.add("modal__img__hidden");
      }
      if (!estadoImg) {
        img.classList.add("modal__img__show");
      }
    }
  });
}

function verificarClaseShow(listasClase) {
  let estado = false;

  for (let i = 0; i < listasClase.length; i++) {
    if (listasClase[i] == "modal__img__show") {
      estado = true;
    }
  }
  console.log(estado);
  return estado;
}

function verificarClaseHidden(listasClase) {
  let estado = false;

  for (let i = 0; i < listasClase.length; i++) {
    if (listasClase[i] == "modal__img__hidden") {
      estado = true;
    }
  }
  console.log(estado);
  return estado;
}

// Click sobre el boton cerrar
boton.addEventListener("click", () => {
  modal.classList.toggle("modal__open");
  console.log("boton x");
});

modal.addEventListener("click", () => {
  modal.classList.remove("modal__open");
});

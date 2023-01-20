const $containerTarejetas = document.querySelectorAll(".tarjeta");

const abrirWeb = (e) => {
  console.log(e);
};

$containerTarejetas.forEach((e) => {
  e.addEventListener("click", () => {
    let idTarjeta = e.id;
    let archivoAbrir = "/index.html";

    if (idTarjeta.toLowerCase() === "codfast")
      archivoAbrir = "https://programandoimaginando.com/RONNY/CodFast/";

    if (idTarjeta.toLowerCase() === "notas")
      archivoAbrir = "https://programandoimaginando.com/RONNY/notas/";

    if (idTarjeta.toLowerCase() === "formulario2")
      archivoAbrir = "https://programandoimaginando.com/RONNY/formulario/";

    if (idTarjeta.toLowerCase() === "restaurante")
      archivoAbrir = "https://programandoimaginando.com/RONNY/Restaurant/";
    window.open(archivoAbrir, "_blank");
  });
});

// $containerTarejetas.addEventListener("click", (e) => abrirWeb(e));

function fillTable(data) {
    var table = document.querySelector("table")

    for (let json in data) {
        let object = data[json];
        let id_producto = object.id;
        let nombre_producto = object.nombre;
        let descripcion_produdcto = object.descripcion;

        let row = table.insertRow()

        let cell_id_producto = row.insertCell();
        cell_id_producto.innerHTML = id_producto;

        let cell_nombre_producto = row.insertCell();
        cell_nombre_producto.innerHTML = nombre_producto;

        let cell_descripcion_producto = row.insertCell();
        cell_descripcion_producto.innerHTML = descripcion_produdcto;

        console.log(data[json]);
    }
}

function getData() {
    fetch('http://localhost:8080/productos')
        .then((response) => response.json())
        .then((data) => fillTable(data));
}

var boton = document.querySelector("button")

boton.onclick = function () {
    getData()
}
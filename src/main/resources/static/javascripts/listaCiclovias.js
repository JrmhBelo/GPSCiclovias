window.onload = async function() {
    let elem = document.getElementById("ciclovias");
    try {
        let ciclovias = await $.ajax({
        url: "/api/ciclovias",
        method: "get",
        dataType: "json"
        });
        let html ="";
        for(let ciclovia of ciclovias)
            html += `<section onclick='showCiclovia(${ciclovia.id})'>
                ${ciclovia.nome}</section>`
        elem.innerHTML = html;
    } catch(err) {
        console.log(err);
        elem.innerHTML = "<h1> Page not Available </h1>";
    }
}
function showCiclovia(id) {
    sessionStorage.setItem("cicloviaId",id);
    window.location = "Ciclovia.html";
}
async function filtrar() {
    try {
        let distrito = document.getElementById("distrito").value;
        let cidade = document.getElementById("cidade").value;
        let ciclovias = await $.ajax({
            url: "/api/ciclovias/"+distrito+"/"+cidade,
            method: "get",
            dataType: "json"
        });
        showCiclovias(ciclovias);
    } catch(err) {
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>"+
                "<h2> Por favor tente mais tarde</h2>";
    }
}
async function filtrarExtensao() {
    try {
        let min = document.getElementById("min").value;
        let max = document.getElementById("max").value;
        let ciclovias = await $.ajax({
            url: "/api/ciclovias/extensao/"+min+"/"+max,
            method: "get",
            dataType: "json"
        });
        showCiclovias(ciclovias);
    } catch(err) {
        let elemMain = document.getElementById("main");
        console.log(err);
        elemMain.innerHTML = "<h1> Página não está disponível</h1>"+
                "<h2> Por favor tente mais tarde</h2>";
    }
}
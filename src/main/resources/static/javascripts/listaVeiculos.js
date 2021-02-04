window.onload = async function() {
    let elem = document.getElementById("veiculos");
    try {
        let veiculos = await $.ajax({
        url: "/api/veiculos",
        method: "get",
        dataType: "json"
        });
        let html ="";
        for(let veiculo of veiculos)
            html += `<section onclick='showVeiculo(${veiculo.id})'>
                ${veiculo.marca}</section>`
        elem.innerHTML = html;
    } catch(err) {
        console.log(err);
        elem.innerHTML = "<h1> Page not vailable </h1>";
    }
}
function showVeiculo(id) {
    sessionStorage.setItem("veiculoId",id);
    window.location = "Veiculo.html";
}

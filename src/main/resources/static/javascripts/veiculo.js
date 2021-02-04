var veiculoId;
window.onload = async function() {
    let veiculoId = sessionStorage.getItem("veiculoId");
    try {
        let veiculo = await $.ajax({
            url: "/api/veiculos/"+veiculoId,
            method: "get",
            dataType: "json"
        });
        console.log(veiculo);
        

        document.getElementById("marca").innerHTML = veiculo.marca;
        document.getElementById("modelo").innerHTML = veiculo.modelo;
        //document.getElementById("numerorodas").innerHTML = veiculo.numerorodas;
            
        
    } catch(err) {
        console.log(err);
    }
}
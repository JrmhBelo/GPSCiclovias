var cicloviaId;
window.onload = async function() {
    let cicloviaId = sessionStorage.getItem("cicloviaId");
    try {
        let ciclovia = await $.ajax({
            url: "/api/ciclovias/"+cicloviaId,
            method: "get",
            dataType: "json"
        });
        console.log(ciclovia);
        

        document.getElementById("nome").innerHTML = ciclovia.nome;
        document.getElementById("descricao").innerHTML = ciclovia.descricao;
        document.getElementById("distrito").innerHTML = ciclovia.distrito;
        document.getElementById("cidade").innerHTML = ciclovia.cidade;
        document.getElementById("extensao").innerHTML = ciclovia.extensao;
        document.getElementById("inicio").innerHTML = ciclovia.inicio;
        document.getElementById("fim").innerHTML = ciclovia.fim;
            
        
    } catch(err) {
        console.log(err);
        
    }
}



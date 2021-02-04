
window.onload = function() {
    loadStats();
}

async function loadStats() {
    try {
        let stats = await $.ajax({
            url: "/api/utilizador/atividade",
            method: "get",
            dataType: "json"
        });
        let tbody = document.getElementById("stats");
        let html = "";
        for (const stat of stats) {
            html+="<tr><td>"+stat.nome + "</td>"+ 
            "<td>" +stat.cicPercorridas + "</td>"+
            "<td>"+stat.extensao+"</td><td>"+stat.veiUtilizados+"</td></tr>";
        }
        
        tbody.innerHTML = html;
    } catch(err) {
    }
}
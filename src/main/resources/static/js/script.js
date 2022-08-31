function selecionaModoDevolucao(tipo) {
    if(tipo == 1){
        document.getElementById("dadosContaDeposito").style.display = "block";
        document.getElementById("creditoConta").style.display = "none";
    } else {
        document.getElementById("dadosContaDeposito").style.display = "none";
        document.getElementById("creditoConta").style.display = "block";
    }
}
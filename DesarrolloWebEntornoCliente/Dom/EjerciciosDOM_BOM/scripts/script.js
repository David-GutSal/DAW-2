function verPassword(){
    let pw = document.getElementsByTagName("input")[0];
    if(pw.getAttribute("type") == "password"){
        pw.setAttribute("type", "text");
    }else{
        pw.setAttribute("type", "password");
    }
}

function startCruz(){
    let table = document.getElementsByTagName("table")[0];
    table.setAttribute("class", "startGame");
    let win1 = [1,1,1,0,0,0,0,0,0];
    let win2 = [0,0,0,1,1,1,0,0,0];
    let win3 = [0,0,0,0,0,0,1,1,1];
    let win4 = [1,0,0,1,0,0,1,0,0];
    let win5 = [0,1,0,0,1,0,0,1,0];
    let win6 = [0,0,1,0,0,1,0,0,1];
    let win7 = [1,0,0,0,1,0,0,0,1];
    let win8 = [0,0,1,0,1,0,1,0,0];

    let player1 = [];
    let player2 = [];
    let exit = false;
    do{


    exit = checkStade(player1, player2);
    }while(exit);


}
function checkStade(player1, player2){
     
}
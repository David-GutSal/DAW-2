function verPassword(){
    let pw = document.getElementsByTagName("input")[0];
    if(pw.getAttribute("type") == "password"){
        pw.setAttribute("type", "text");
    }else{
        pw.setAttribute("type", "password");
    }
}
function setOnclick(){}
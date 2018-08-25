var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        var x = document.createElement("INPUT");
        x.setAttribute("type", "text");
        x.setAttribute("value", this.responseText);
        x.setAttribute("id", "_csrf");
        x.setAttribute("name", "_csrf");
        x.setAttribute("hidden", true);
        document.getElementById("hiddenDiv").appendChild(x);
    }
};
xhttp.open("GET", "/api/csrf", true);
xhttp.send();
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        document.getElementById("_csrf").value = this.responseText;
        document.getElementById("_csrf").style.visibility='hidden';
    }
};
xhttp.open("GET", "/api/csrf", true);
xhttp.send();
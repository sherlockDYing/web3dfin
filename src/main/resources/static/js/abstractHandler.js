function commenthandler(id) {
    //   var abst = document.getElementById(id);
    var comment = document.getElementById(id);
    if (comment.style.display === "")
        comment.style.display = "none";
    else if (comment.style.display === "none")
        comment.style.display = "";
}


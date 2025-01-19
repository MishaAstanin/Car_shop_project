document.getElementById("let-register").addEventListener("click", function(event) {
    event.preventDefault();
    document.getElementById("enter-form").style.display = "none";
    document.getElementById("registration-form").style.display = "block";
});

document.getElementById("let-registration").addEventListener("click", function(event) {
    event.preventDefault();
    document.getElementById("enter-form").style.display = "block";
    document.getElementById("registration-form").style.display = "none";
});


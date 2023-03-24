


/**
 * Will validate that username is not taken yet
 */
function validateUser() {

}

function validatePass() {
    let passInput = document.getElementById("passwordInput");
    let passValue = passInput.value;
    let confirmPassInput = document.getElementById("confirmPasswordInput");
    if (confirmPassInput != null) {
        let confirmPassValue = confirmPassInput.value;
    }

    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$/;
    if (!passValue.match(passw)) {
        passInput.classList.add("is-invalid");
        if (!document.body.contains(document.getElementById("newPassHelp"))) {
            const para = document.createElement("p");
            const node = document.createTextNode("Please enter a valid Password");
            para.appendChild(node);
            para.style.cssText = "color:red; margin-bottom:0; text-align:right";
            const element = document.getElementById("passField");
            element.appendChild(para);
            para.id = "newPassHelp";
        }
    } else {
        try {
            document.getElementById("newPassHelp").remove();
            passInput.classList.remove("is-invalid");
        } catch (e) {
            console.log(e);
        }
    }

    // Handle pass and confirmPass matching next
    
}
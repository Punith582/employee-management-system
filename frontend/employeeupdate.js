//fetching data from local storage
let leid = localStorage.getItem("eid")
let lemail = localStorage.getItem("email")
let lename = localStorage.getItem("ename")
let lcontact = localStorage.getItem("contact")
let lsal = localStorage.getItem("sal")
let lpassword = localStorage.getItem("password")

//targeting the input tags
let name = document.getElementById("name")
let email = document.getElementById("email")
let sal = document.getElementById("sal")
let contact = document.getElementById("contact")
let password = document.getElementById("password")

//giving valus in input fields
name.value = lename;
email.value = lemail;
sal.value = lsal;
contact.value = lcontact;
password.value = lpassword;

//adding event to updatebtn
let updatebtn = document.getElementById("updatebtn");
updatebtn.addEventListener("click",(e)=>{
    e.preventDefault();
    let employee = {
        eid : leid,
        ename : name.value,
        email : email.value,
        sal: sal.value,
        contact : contact.value,
        password : password.value
    }
    console.log(employee);
    let x = fetch("http://localhost:8080/update",{
        method : "PUT",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(employee)
    })
    console.log(x);
    x.then((response)=>{
        console.log(response);
        if(response.ok)
        {
            localStorage.setItem("ename",name.value)
            localStorage.setItem("email",email.value)
            localStorage.setItem("password",password.value)
            localStorage.setItem("sal",sal.value)
            localStorage.setItem("contact",contact.value)
            alert("updated successfully");
            open("./home.html")
        }
    })
})
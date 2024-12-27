let submit=document.getElementById("submit");
let password1=document.getElementById("password");
let passworderr=document.getElementById("passerr")
password1.addEventListener("keyup",()=>
{
    let password=document.getElementById("password").value
    let upper=/[A-Z]/
    let lower=/[a-z]/
    let sc=/[!@#$%^&*]/
    if(upper.test(password)==false){
        passworderr.innerHTML="*Password must contain upper case"
        passworderr.style.color="red"
        password1.style.outlineColor="red"
    }
    else if(lower.test(password)==false){
         passworderr.innerHTML="*Password must contain lower case"
          passworderr.style.color="red"
        password1.style.outlineColor="red"
    }
    else if(sc.test(password)==false){
         passworderr.innerHTML="*Password must contain special charecter"
          passworderr.style.color="red"
        password1.style.outlineColor="red"
    }
    else if(password.length<8){
         passworderr.innerHTML="*Password must contain 8 charecters"
          passworderr.style.color="red"
        password1.style.outlineColor="red"
    }
    else{
        passworderr.innerHTML=""
        password1.style.outline="black"
    }
})

submit.onclick=()=>{
    let ename=document.getElementById("ename").value;
    let sal=document.getElementById("sal").value;
    let email=document.getElementById("email").value;
    let password=document.getElementById("password").value;
    let contact=document.getElementById("contact").value;
    // e.preventDefault()
    let employee={
        ename:ename,
        sal:sal,
        email:email,
        password:password,
        contact:contact
    }
    let url="http://localhost:8080/register"
    fetch(url,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(employee)
    })
    .then(response => response.json())  // Parse JSON response
    .then(data => {
        console.log("Success:", data);  // Log the response from the server
        // Optionally, you can redirect or show a success message here
        alert("registered successfully");
        open("./employeelogin.html")
    })
    .catch(error => {
        console.error("Error:", error);  // Handle errors
    });
   
}

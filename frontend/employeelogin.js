let login=document.getElementById("submit");

login.onclick=(e)=>{
    e.preventDefault();
    let email=document.getElementById("email").value;
    let password=document.getElementById("password").value;
    function showToast(message, isSuccess = true) {
        const toast = document.getElementById('toast');
        toast.textContent = message;
        toast.style.backgroundColor = isSuccess ? "#4caf50" : "#f44336"; // Green for success, red for error
        toast.classList.add('show');

        setTimeout(() => {
            toast.classList.remove('show');
        }, 3000);
    }
    let url=`http://localhost:8080/login/${email}/${password}`;
    fetch(url,{
        method:"GET",
        headers:{
            "Content-Type": "application/json"
        }
    })
    .then((response) => {
        if (!response.ok) {
          alert("User details were wrong");
          window.location.href = "./employeelogin.html";
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        console.log(data);
        console.log(data.eid)
        data=data.data
        localStorage.setItem("eid",data.eid)
        localStorage.setItem("ename",data.ename)
        localStorage.setItem("sal",data.sal)
        localStorage.setItem("email",data.email)
        localStorage.setItem("password",data.password)
        localStorage.setItem("contact",data.contact)
        console.log(url);
        window.location.href = "./home.html";
        // alert("successfully loged in")
        showToast("Login Successful!", true);
      })
      .catch((error) => {
        console.log("Error:", error);
         // alert("Login failed. Please check your credentials and try again.");
        showToast("Login failed. Please check your credentials and try again.", false);
      });
};

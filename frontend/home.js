let id = document.getElementById("id");
let name = document.getElementById("name");
let sal = document.getElementById("sal");
let email = document.getElementById("email");
let contact = document.getElementById("contact");
let pic=document.getElementById("pic");

let leid = localStorage.getItem("eid")
let lemail = localStorage.getItem("email")
let lename = localStorage.getItem("ename")
let lcontact = localStorage.getItem("contact")
let lsal = localStorage.getItem("sal")


id.innerText = leid;
name.innerText = lename;
sal.innerText = lsal;
email.innerText = lemail;
contact.innerText = lcontact
const imgurl=`http://localhost:8080/getimg/${leid}`;
console.log(imgurl);

pic.setAttribute("src",imgurl);

let updatebtn = document.getElementById("update-btn");
updatebtn.addEventListener("click",()=>{
    open("./employeeupdate.html","_self")
})

let deletebtn=document.getElementById("delete-btn")
deletebtn.addEventListener("click",()=>{
    let url=`http://localhost:8080/delete/${leid}`;
    let x=fetch(url,{
        method:"DELETE",
        headers:{
            "Content-Type": "application/json"
        }
    })
    console.log(x);
    
    x.then((response)=>{
        console.log(response);
    })
    alert("Deleted successfully")
    open("/employeelogin.html")
})
let upload=document.getElementById("upload-btn")
upload.addEventListener("click",()=>{
    const fileInput = document.getElementById('image');
    const file = fileInput.files[0]; 

    if (!file) {
        console.error("No file selected.");
        return;
    }
    else{
        console.log(file)
        let formData = new FormData();
        let eid = localStorage.getItem("eid"); 
        formData.append("eid", eid); 
        formData.append("img", file); 
        let x =fetch(`http://localhost:8080/updateimg/${eid}`, {
            method: "PUT",
            body: formData,
        });
        console.log(x); 
        x.then((response)=>{
            console.log(response)
            window.location.reload()
            // open("./home1.html","_self")
        })
        .catch(()=>{
            alert("image not uploaded properly")
        })
    }
})







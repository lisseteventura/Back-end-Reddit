let user;

function postData(event) {
  event.preventDefault();
  // const email = document.querySelector('.email');
  const password = document.querySelector(".pw");
  const username = document.querySelector(".username");
  user = username.value;
  console.log(username.value, password.value);
  fetch("http://localhost:8080/signup", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      // email: email.value,
      password: password.value,
      username: username.value
    })
  })
    .then(res => {
      //console.log(res)
      return res.json();
    })
    .then(res => {
      console.log(res);
      localStorage.setItem("user", res.token);
    })
    .catch(err => {
      console.log(err);
    });
}

function userLogin(event) {
  event.preventDefault();
  const username = document.querySelector(".login");
  const password = document.querySelector(".password");
  console.log(username.value, password.value);
  user = username.value;
  fetch("http://localhost:8080/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      username: username.value,
      password: password.value
    })
  })
    .then(res => {
      return res.json();
    })
    .then(res => {
      console.log(res);
      localStorage.setItem("user", res.token);
      // if(res.httpStatus !== 'BAD_REQUEST')
      if (localStorage.getItem("user") !== "undefined") {
        alert("Welcome to Reddit!");
        //makes login form disppear once user logs in
        document.querySelector(".form-inline").style.display = "none";
      } else {
        alert("Email and Password is invalid, please try again");
      }
      //      window.location.href = "index.html";
      //     }else{
      //      localStorage.clear();
      //     }
    })
    .catch(err => {
      console.log(err);
    });
}

// DO IT LATER

function updateDom() {
  document.querySelector(".signupForm").style.display = "none";
  document.querySelector(".postForm").style.display = "block";
  fetch("http://localhost:8080/post/list", {
    headers: {
      Authorization: "Bearer " + localStorage.getItem("user")
    }
  })
    .then(res => {
      return res.json();
    })
    .then(res => {
      const list = document.querySelector(".thePosts");
      for (let i = 0; i < res.length; i++) {
        const item = document.createElement("li");
        const title = document.createElement("h3");
        const description = document.createElement("p");
        item.appendChild(title);
        item.appendChild(description);
        title.innerText = res[i].title;
        description.innerText = res[i].description;
        list.appendChild(item);
      }
    })
    .catch(err => {
      console.log(err);
    });
}

function createPost(event) {
  event.preventDefault();
  const title = document.querySelector(".title");
  const description = document.querySelector(".description");
  fetch(`http://localhost:8080/post/create/${user}`, {
    method: "POST",
    headers: {
      Authorization: "Bearer " + localStorage.getItem("user"),
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      title: title.value,
      description: description.value
    })
  })
    .then(res => {
      console.log(res);
      updateDom(res);
    })
    .catch(err => {
      console.log(err);
    });
}

//this function lists all point
function displayAll(event) {
  const allPosts = document.querySelector(".postForm");
  fetch("http://localhost:8080/post/list", {
    method: "GET",
    headers: {
      "Content-Type": "  application/json"
    }
  })
    .then(res => {
      return res.json();
    })
    .then(res => {
      console.log(res);
      const list = document.querySelector(".thePosts");
      for (let i = 0; i < 100; i++) {
        // if (i <= 10) {
        const item = document.createElement("li");
        item.id = res[i].id;
        const title = document.createElement("h3");
        const description = document.createElement("p");
        item.appendChild(title);
        item.appendChild(description);
        title.innerText = res[i].title;
        description.innerText = res[i].description;
        list.appendChild(item);
        allComments(res[i].id);
        // }
      }
    });
}
displayAll();

// function allComments(postId) {
//   fetch(`http://thesi.generalassemb.ly:8080/post/${postId}/comment`, {
//     method: "GET",
//     headers: {
//       "Content-Type": "application/json"
//     }
//   })
//     .then(res => {
//       return res.json();
//     })
//     .then(res => {
//       const post = document.getElementById(`${postId}`);
//       const list = document.createElement("ul");
//       post.appendChild(list);
//       for (let i = 0; i < res.length; ++i) {
//         const item = document.createElement("li");
//         const text = document.createElement("p");
//         item.appendChild(text);
//         text.innerText = res[i].text;
//         list.appendChild(item);
//       }
//     })
//     .catch(err => {
//       console.log(err);
//     });
// }

let modal = document.getElementById("myModal");
// Get the button that opens the modal
let btn = document.getElementById("myBtn");
// Get the <span> element that closes the modal
let span = document.getElementsByClassName("close")[0];
// When the user clicks on the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
};
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
};
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
};

function userProfile(event) {
  event.preventDefault();
  const adEmail = document.querySelector(".adEmail");
  const mobile = document.querySelector(".mobile");
  const address = document.querySelector(".address");
  console.log(adEmail.value, mobile.value, address.value);
  fetch(`http://localhost:8080/profile/${user}`, {
    method: "POST",
    headers: {
      Authorization: "Bearer " + localStorage.getItem("user"),
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      additionalEmail: adEmail.value,
      mobile: mobile.value,
      address: address.valiue
    })
  })
    .then(res => {
      res.json();
      console.log(res);
      // updateDom(res);
    })
    .catch(err => {
      console.log(err);
    });
}

// function getUser(event){
//   event.preventDefault();
//   fetch('http://thesi.generalassemb.ly:8080/profile',{
//   method: 'GET',
//   header: {
//     'Authorization': "Bearer " + localStorage.getItem('user'),
//     'Content-Type':'application/json'
//   },
//   .then

// ajax 통신 (비동기 자바스크립트 통신)

/*
https://api.coingecko.com/api/v3/coins/bitcoin
https://jsonplaceholder.typicode.com/users
https://jsonplaceholder.typicode.com/posts
https://jsonplaceholder.typicode.com/comments
*/

let xhttp = new XMLHttpRequest();
console.log(xhttp);
xhttp.open("get", "books.json");
xhttp.send();
xhttp.onload=function(){
    console.log(xhttp.responseText);
    const body = document.querySelector("body");
    console.log(body);
    let books = JSON.parse(xhttp.responseText);
    
    console.log(typeof books);
    console.log(books.length);

    body.innerHTML += "<br>----------기본 for문 사용----------<br>"
    for(let i=0;i<books.length;i++) {
        body.innerHTML += books[i].title + "<br>";
    }

    body.innerHTML += "<br>----------forEach문 사용----------<br>"
    books.forEach(element => {
        body.innerHTML += element.title + "<br>";
    });

    body.innerHTML += "<br>---for in(index==번호) 반복문 사용---<br>"
    for(const key in books) {
        body.innerHTML += books[key].title + "<br>";
    }

    body.innerHTML += "<br>---for of(객체반환) 반복문 사용---<br>"
    for(const obj of books) {
        body.innerHTML += obj.title + "<br>";
    }

    var result = books.find(book=>book.title === "javacript 기초");
    console.log(result);
    
}
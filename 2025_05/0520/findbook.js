// ajax 통신 (비동기 자바스크립트 통신)

/*
https://api.coingecko.com/api/v3/coins/bitcoin
https://jsonplaceholder.typicode.com/users
https://jsonplaceholder.typicode.com/posts
https://jsonplaceholder.typicode.com/comments
*/

let books;
let xhttp = new XMLHttpRequest();
console.log(xhttp);
xhttp.open("get", "books.json");
xhttp.send();
xhttp.onload=function(){
    books = JSON.parse(xhttp.responseText);
}

function searchBook() {
    const input = document.getElementById("inputbox").value.trim();
    const resultDiv = document.getElementById("result");

    const result = books.find(book => book.title === input);

    if (result) {
        resultDiv.innerHTML = `
            책 제목 : ${result.title}<br>
            저자 : ${result.author}<br>
            가격 : ${result.price}원
        `;
    }
}
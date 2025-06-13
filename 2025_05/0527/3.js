'use strict'   // 문법적으로 오류 확인

// 객체 : { }
// JSON 형식 : "{ }"
// 배열 : [ ]

function add(a, b) {
    return a + b;
}

let copyadd = add;
console.log(copyadd(10, 20));

// 변수명 = 함수명 처럼 사용, 함수 이름은 주소 또는 위치

let minus = (a, b)=>{return a - b;};
console.log(minus(20, 10));

minus = function(a, b) {
    return a - b;
}
console.log(minus(20, 10));

minus = function minus2(a, b) {
    return a - b;
}

console.log(minus(30, 10));

let f;
let ff;
let fff;

fff = ff = f = minus;

console.log(fff(1, 2));

// 배열을 선언하는 방법
let arr = [];
console.log(typeof arr);
console.log(arr);

let arr2 = new Array();
console.log(typeof arr2);

// 객체를 선언하는 방법 (객체)
let obj = {};
console.log(typeof obj);
console.log(obj);

let obj2 = new Object();
console.log(typeof obj2);
console.log(obj2);

// 배열객체와 객체를 구별하는 방법
console.log(Array.isArray(arr));
console.log(Array.isArray(obj));

// 배열에 값을 입력하기
arr = ["banana", "apple"];
console.log(arr);
arr.push("melon");
console.log(arr);
console.log(arr.pop());
console.log(arr);

arr2 = new Array(1, 2, "3", 4);
console.log(arr2);

let arr3 = [];
let insa = "hello";
console.log(insa);
arr3 = insa;        // arr3은 단순 문자열
arr3 = [...insa];   // arr3은 배열
console.log(arr3);

let arr4 = insa.split();    // space로 분리
console.log(arr4);          // 분리할 게 없을 경우 단일 배열로 출력

arr4 = insa.split("");      // 한 문자씩 분리
console.log(arr4);          // 문자열을 한 문자씩 분리하여 출력

let arr5 = ["banana", "apple", "melon"];
let arr6 = ["banana", "apple", "melon"];
let arr7 = "['banana', 'apple', 'melon']";

console.log(Array.isArray(arr5));
console.log(Array.isArray(arr6));
console.log(Array.isArray(arr7));

// 문자열 형태의 배열을 입력받을 경우(arr7)
// 이 데이터를 배열 객체로 변환하기

console.log(arr7.substring(1, arr7.length-1));

arr7 = arr7.replace("[", "");
arr7 = arr7.replace("]", "");
console.log(arr7);
arr7 = arr7.replace("'", "");
console.log(arr7.split(","));

let json3 = "['name':'hong', 'age':'23']";
let json4 = "['name':'hong', 'age':'23']";
let json5 = "{\"name\":\"hong\", \"age\":\"23\"}";
console.log(JSON.parse(json5));
// 중요사항 : 배열 또는 객체는 ""으로 값을 처리함

arr5=["banana", "apple", "melon"];
// 배열을 문자열로 만들 경우 join() 함수 사용
console.log(arr5.join());   // (기본값) ","를 기준으로 문자열을 합침
console.log(Array.isArray(arr5.join()));
console.log(arr5.join("-"));
console.log(arr5.toString());
console.log(JSON.stringify(arr5));  // 있는 그대로의 문자열

// 객체
let obj5 = {"name":"kim", "age":"20"};
console.log(obj5);

let firstName = "park";
let age = "23";
let person = {"name":firstName, "age":age};
console.log(person);

person["age"] = 35;
console.log(person);

// for문은 for(초기값, 제어문, 증감식), forEach, for( in ), for( of ) 등의 문법이 있다
'use strict'   // 문법적으로 오류 확인

var a = 10;
console.log(a);

let b = 20;
console.log(b);

{
    console.log(a);
    console.log(b);
    var c = 100;
    let d = 200;
}
console.log(c);
// console.log(d);     // 오류 발생 (not defined)

// 확인사항 : var는 문법에 엄격하지 않고, let은 문법에 엄격하다
console.log('오류 발생 이후의 문장임'); // 위에서 오류 발생 시 그 다음 문장은 수행하지 않음

const e = "한 번 선언 후 값 변경 불가";
console.log(e);
// e = "값을 변경함";   // const(상수)의 값을 변경하여 오류 발생

let f = 1;
let g = '1';
let h = "1";
let i = `1`;
console.log(typeof f);
console.log(typeof g);
console.log(typeof h);
console.log(typeof i);

console.log(f==g);
console.log(f===g);
console.log(f===parseInt(g));
console.log(String(f)===g);
console.log(f.toString()===g);
console.log(""+f===g);
console.log(`${f}`===g);

// 문자 + 숫자는 문자열이 우선
console.log('5+5');
console.log('5'+'5');
console.log(5+String(5));
console.log(5+Number('5'));
console.log(5+parseInt('5'));
console.log(5+parseFloat('3.14'));

/* 
    변수의 값 상태
    null : 객체가 생성되지 않은 상태
    undefined : 값이 정의되지 않은 상태
    NaN(Not a Number) : 잘못된 입력값
*/

var j;
console.log(j);
j = null;
console.log(j);
j = undefined;
console.log(j);

let xhttp = new XMLHttpRequest();
console.log(xhttp);
xhttp.open("get", "bootstrap1.html");
let result = xhttp.send();

console.log(0/0);
console.log(10/0);
console.log(isNaN(0/0));
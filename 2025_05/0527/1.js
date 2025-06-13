/* 변수 (숫자 또는 문자)
    int, float, char, char[]
    long, double, strinig
    정수    int a = 10;
    문자    char c = 'a';
    문자열  char[] s = "hello";
            String s = "hello";
*/

// 함수 정의
/*
function add(int a, int b) {
    return a + b;
}
*/

/*
function add(a::Number, b::Number) {
    return a + b;
}
*/

function add(a, b) {
    return a + b;
}

// 함수의 사용
// 1. 값을 직접 입력하는 형태
var result = add(10, 20);

// 2. 변수를 통해 입력하는 형태
var a = 10; var b = 20;
result = add(a, b);

// 3. 함수를 통해서 입력하는 형태
result = add(add(1, 2), add(3, 4));

// 4. 혼합 사용 형태
result = add(add(1, 2), a);
result = add(add(add(a, b), add(a, b)), b);

// 내장 함수
console.log(Math.round(23.5));



// 기본 함수

// 사용자 정의 함수

// 라이브러리를 이용한 함수
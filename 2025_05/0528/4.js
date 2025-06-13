`use strict`

// 클래스 : 속성 + 함수 ( 생성자함수 = 클래스명() = constructor() )

class Person {
    // java에서 사용 방식
    // String name;
    // int age;

    constructor(name, age) {
        this.name = name;   // this 는 이 객체를 의미 / .name 은 멤버 변수
        this.age = age;
    }

    print() {
        console.log(`나의 이름은 ${this.name}입니다.`);
        console.log(`나의 나이는 ${this.age}입니다.`);
    }
}

let p1 = new Person();
console.log(p1);

let p2 = new Person("hong", 30);
console.log(p2);

p2.print();

p1.name = "kim";
p1.age = 20;
p1.print();

p1["name"] = "ryu";
p1["age"] = 25;
p1.print();

class NewPerson {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }

    get name() { return this._name; }
    get age() { return this._age; }

    set name(value) { this._name = value; }
    set age(value) { this._age = value; }

    print() {
        console.log(this.name);
        console.log(this.age);
    }
}

let newp = new NewPerson("park", 40);
console.log(newp._name);    // 변수를 호출
console.log(newp.name);     // get 함수를 호출
// console.log(newp.name());   // 함수로서 호출 시 오류 발생

newp._name = "park2";       // 변수의 값을 직접 설정
console.log(newp._name);
newp.name = "park3";        // set 함수 호출
console.log(newp.name);

// XMLHttpRequest : 비동기식
// fetch() : 동기식
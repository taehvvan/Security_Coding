import ReactDOM from "react-dom/client";

import React,{useState, useEffect} from "react";

function PhonebookList() {

  // useEffect() : 호출될 때 데이터가 수신될 경우 이를 저장할 상태변수를 미리 선언해야 함
  const [contacts, setContacts] = useState([]);
  
  // 최초 호출이 한 번 일어난다
  useEffect(()=>{
    console.log("호출!!");
    const xhttp = new XMLHttpRequest();
    xhttp.open("get", "data.json");
    xhttp.send();
    xhttp.onload=function(){
      let data = JSON.parse(xhttp.responseText);
      setContacts(data);
      console.log(contacts);
    }
  })

  return <>
  <div>
  {contacts.map(contact => (
    <ul style={{listStyle:'none', border:'1px solid black', padding:0}}>
        
          <li>{contact.id}</li>
          <li>{contact.name}</li>
          <li>{contact.phone}</li>
        
    </ul>
  ))}
  </div>
  </>
}


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<PhonebookList />);


/*
import { useState } from "react";
import ReactDOM from "react-dom/client";

// 어떤 상태가 변화되었을 때 실행하는 코드
import React,{useState, useEffect} from "react";

// 사용할 기능을 함수로 만들기(상태변수선언, 상태변화실행함수(useEffect), 화면에 표시할 return 태그)
function Counter() {
  const [count, setCount] = useState(0);

  // 상태변화실행함수 (useEffect)
  useEffect(()=>{
    console.log(`현재 카운터 : ${count}`)
  }, [count]);

  // 화면에 표시할 return 태그 (<> </> 또는 ( ) 사용)
  return (
    <div>
      <div>카운터 : {count} </div>
      <button onclick={() => setCount(count + 1)}>숫자 증가하기</button>
    </div>
  );
}


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<Counter />);
*/






/*
import { useState } from "react";
import ReactDOM from "react-dom/client";

// <App /> 태그는 외부에 있는 함수를 가지고 와서 사용하는 태그
// 내부적으로 App 작성하기 -> export 할 필요 없음
function App() {

  // 전달받은 데이터가 있다고 가정할 경우 (배열 형식)
  // <Todos> 태그는 함수의 Todos()
  // todos={todos}는 속성=값으로서 함수의 입력값 Todos({ todos } 를 의미
  // map을 이용하여 반복 처리
  const [todos, setTodos] = useState(["todo 1", "todo 2"]);
  return <>
    <div>
      <Todos todos={todos} />
    </div>
  </>
}

function Todos({ todos }) {
  return (
    <>
      {todos.map((todo, index) => {
        return <p key={index}>{todo}</p>;
      })}
    </>
  );
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
*/
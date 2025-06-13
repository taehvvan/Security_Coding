function confirm() {
    let id = document.getElementById("id");
    let password = document.getElementById("password");
    
    if(id.value==="" || password.value==="") {
        window.alert("id 또는 패스워드가 비어있습니다.");
        if(id.value==="") {
            id.focus()
        } else {
            password.focus();
        }
        return false;
    }

    if(password.value.length<4) {
        window.alert("비밀번호의 길이가 4자 이상이어야 합니다.");
        password.value = "";
        password.focus();
        return false;
    }            

    if(!/^(?=.*[A-Za-z])(?=.*\d).+$/.test(password.value)) {
        window.alert("비밀번호는 영문자, 숫자가 포함되어야 합니다.")
        password.value;
        password.focus;
        return false;
    }

    if(id.value==="admin" && password.value==="Aa12") {
        window.alert("로그인 성공");
        return true;
    } else {
        window.alert("로그인 실패");
        id.focus();
        return false;
    }
}
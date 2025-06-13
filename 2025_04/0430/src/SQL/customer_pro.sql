--customer_pro 저장 프로시저 생성문
create or replace procedure customer_pro    -- customer_pro 라는 저장프로시저 생성
                                            -- ore replace 옵션은 재생성
(
    cusname out customer.cus_name%type,  -- cusname 변수는 customer 테이블의 cus_name 컬럼 타입으로 지정됨
                                         -- out : 컬럼에 저장된 레코드값을 되돌려받을 때 사용
    cusphone out customer.cus_phone%type,
    cusemail out customer.cus_email%type,
    cusno in customer.cus_no%type        -- in : 값을 입력받을 때 사용
)
is
    
begin
    select cus_name, cus_phone, cus_email into cusname, cusphone, cusemail from customer where cus_no = cusno;
    -- 입력받은 고객번호를 기준으로 오라클의 해당 테이블로부터 고객이름, 고객폰번호, 고객이메일을 검색해서
    -- cusname, cusphone, cusemail 변수에 저장
end;
/
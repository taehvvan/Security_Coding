-- 오라클 db SQL문에서 한 줄 주석문 기호
/* 한 줄 이상 주석문 기호 */

-- customer 테이블 생성
create table customer(
	cus_no number(38) primary key
	, cus_name varchar2(50) not null
	, cus_phone varchar2(30) not null
	, cus_email varchar2(100) not null
	, cus_date date		 
);

/* 평가시험 나오는 부분 - 테이블 생성 구문에서 default sysdate 제약 조건
 * 
 * default sysdate 제약조건을 주면 cus_date 컬럼에 굳이 등록날짜값을 저장하지 않아도 기본 날짜값이
 * 오라클 sysdate 날짜 함수에 의해서 저장된다. default 제약조건은 기본값을 저장할 수 있는 제약조건
 */
-- 

/*
 * 오라클 자료형 종류
 * number(38) : 최대자리수 38자까지 정수 숫자값 저장
 * varchar2 : 가변 문자 타입
 * date : 날짜 타입
 * 
 * 제약조건 : 테이블 컬럼에 자료 저장 시 어떤 제한을 가하는 것
 * 
 * 제약조건 종류
 * 1. primary key : 기본키 제약조건. 중복 자료 저장 금지, null 저장 금지
 * 2. not null : null 저장 금지, 즉 반드시 자료를 입력해야 함
 * 해당 컬럼에 제약조건을 생략하면 기본값 null 제약조건이다.
 */

select * from customer;

/*
 * 레코드 : 테이블 컬럼에 저장된 한 행의 자료 집합
 * 
 * 레코드 저장문 형식
 * insert into 테이블명 (컬럼 목록) values(값);
 * 
 * 레코드 저장문 특징)
 * 	1. 테이블의 모든 컬럼에 레코드 저장 시에는 컬럼 목록을 생략해도 된다. 
 * 	2. 원하는 컬럼에만 레코드를 저장할 때에는 컬럼 목록을 명시 코드해야 한다.
 * 	3. 컬럼 목록 순서와 values 값 목록 순서는 일치해야 한다.
 * 	4. 문자열 레코드 저장 시에는 ''(작은 따옴표)로 감싼다.
 * 
 * SQL문은 대소문자를 구분하지 않지만 컬럼에 저장된 영문 레코드는 대소문자를 구분한다.
 * 
 * 시퀀스 : 번호 발생기. 주로 고객번호나 게시판 번호 등 정수 숫자 번호값 발생 용도로 사용
 * 
 * 시퀀스 특징)
 * 	1. 시퀀스 번호는 중복 번호가 없고 null이 없다. primary key 제약조건으로 설정되고
 * 	   정수 숫자 타입으로 지정된 컬럼 레코드값 저장 용도로 사용해야 한다.
 * 
 * (평가시험)
 * 시퀀스 생성 문법 형식)
 * 	create sequence 시퀀스명
 * 	start with 1    -- 1부터 시작, 기본값으로 생략 가능
 * 	increment by 1  -- 1씩 증가, 기본값으로 생략 가능
 * 	nocache			-- 임시 메모리를 사용하지 않겠다는 의미, 생략 시 기본값은 cache 20
 * 					-- cache 20 : 오라클에서 시퀀스 번호를 미리 20개까지 메모리에 올려놓음
 * 					-- 어제 마지막으로 발급된 시퀀스 번호가 100이라면 캐시에는 101~120까지 메모리에 있고,
 * 					-- 다음 시퀀스 번호값은 121부터 시작됨. 오늘 db가 재시작하면 캐시값은 초기화됨.
 * 	nocycle;		-- 시퀀스 최대값 또는 최소값에 도달하면 다시 처음부터 시퀀스 번호값을 반복하지 않음
 * 					-- 기본값으로 생략 가능
 */

-- cus_seq라는 시퀀스를 생성
create sequence cus_seq
start with 1
increment by 1
nocache
nocycle;

-- (평가시험) cus_seq 다음 시퀀스 번호값 확인
select cus_seq.nextval as "다음 시퀀스 번호값" from dual;

select sysdate as "오늘 날짜와 시간값" from dual;

insert into customer (cus_no, cus_name, cus_phone, cus_email, cus_date) 
	values (cus_seq.nextval, '홍길동', '010-777-7777', 'hong@gmail.com', sysdate);
	
/* 저장 후 레코드 검색 쿼리문 문법 형식)
 * 		select 컬럼목록(전체컬럼은 *) from 테이블명 where 조건식 order by 기준컬럼 desc(asc);
 * 
 * order by는 정렬문이다.
 * 		asc : 오름차순 (기본값, 생략 가능)
 * 		desc : 내림차순
 * 
 * 내림차순 정렬 규칙)
 * 1. 한글은 가나다 역순 2. 영어는 알파벳 역순 3. 숫자는 큰 숫자부터 정렬
 */
	
select * from customer order by cus_no desc;

-- 2번째 레코드 저장
insert into customer (cus_no, cus_name, cus_phone, cus_email, cus_date) 
	values (cus_seq.nextval, '이순신', '010-999-9999', 'leeshin@gmail.com', sysdate);
	
-- 3번째 레코드 저장
insert into customer (cus_no, cus_name, cus_phone, cus_email, cus_date) 
	values (cus_seq.nextval, '신사임당', '010-888-8888', 'shin@gmail.com', sysdate);
	
/* (평가시험) 레코드 수정문 형식)
 * 		update 테이블명 set 컬럼명 = 변경할 값, 컬럼명 = 변경할 값 ... where 조건식;
 */	
	
-- 2번 레코드의 고객이름, 폰번호, 이메일주소를 변경
update customer set cus_name = '수정 홍길동', cus_phone = '010-555-5555', 
	cus_email = 'edithong@gmail.com' where cus_no = 2;
	
-- 값이 변경되었는지 확인
select cus_name, cus_phone, cus_email from customer where cus_no = 2;

/* 레코드 삭제문 형식)
 * 		delete from 테이블명 where 조건식; (from절은 생략 가능)
 */

select * from customer order by cus_no asc;	-- 고객 번호를 기준으로 오름차순 정렬
-- 4번 레코드를 삭제
delete from customer where cus_no = 4;
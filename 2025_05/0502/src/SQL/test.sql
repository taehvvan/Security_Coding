create table tbl_board7(
	bno number(38) primary key
	, bname varchar2(50) not null
	, btitle varchar2(200) not null
	, bcont varchar2(4000) not null
	, bdate date default sysdate 
);

select * from tbl_board7;


create sequence bno_seq2
start with 1
increment by 1
nocache
nocycle;

select bno_seq2.nextval as "다음 시퀀스 번호값" from dual;

select * from tbl_board7 order by bno desc;

update tbl_board7 set bname = '수정 홍길동', btitle = '수정 제목', 
	bcont = '수정 내용' where bno = 3;
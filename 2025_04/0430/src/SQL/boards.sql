-- boards 테이블 생성(자료실 => 게시판)
create table boards (
	bno number(38) primary key
	, bwriter varchar2(50) not null		-- 글쓴이
	, btitle varchar2(200) not null		-- 글제목
	, bcontent varchar2(4000) not null	-- 글내용
	, bdate date default sysdate		-- 등록날짜
										-- default sysdate 제약조건 : 날짜/시간값을 저장하지 않아도 기본값 저장
	, bfilename varchar2(200) 			-- 첨부파일명
	, bfiledata blob null				-- blob : 오라클에서 대용량 이진 데이터를 저장할 수 있는 자료형
										-- Binary Large Object의 약어
										-- 최대 4GB까지 저장 가능, 순수 이진 데이터이므로 텍스트가 아닌 파일데이터(그림, 동영상, 오디오 등)를 그대로 저장 가능
);

select * from boards order by bno desc;

-- seq_bno 시퀀스 생성
create sequence seq_bno
start with 1
increment by 1
nocache
nocycle;

-- seq_bno 다음 시퀀스 번호값 확인
select seq_bno.nextval as "다음 시퀀스 번호값" from dual;
-- ���� ������ ����� accounts ���̺� ���� (Ʈ����� �ǽ��� ���� ���̺�)
create table accounts (
    ano varchar2(50) primary key    -- ���¹�ȣ
    , owner varchar2(50) not null   -- ���� ������(������)
    , balance number(38) not null   -- ���� �ܾ�(�Ա�/���)
);

select * from accounts order by balance asc;

insert into accounts values('111-111-1111', 'ȫ�浿', 10000000);
insert into accounts values('222-222-2222', '�̼���', 0);

commit;     -- Ʈ����ǿ��� commit ��ɾ�� ���� �������� �����ݿ�


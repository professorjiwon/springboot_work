create sequence seq_board nocache;

create table boardtest(
    boardno number primary key,
    title VARCHAR2(100),
    writer varchar2(20),
    content varchar2(500)
)

insert into boardtest values(seq_board.nextval, '제목1', '더조은', '내용1');
insert into boardtest values(seq_board.nextval, '제목2', '나빛나', '내용2');

commit;
create table jpapaging (
    id number primary key,
    email varchar2(50),
    name varchar2(20)
);
create sequence jpapaging_seq NOCACHE;

insert into jpapaging values(jpapaging_seq.nextval, 'user01@test.com', 'user01');
insert into jpapaging values(jpapaging_seq.nextval, 'user02@test.com', 'user02');
insert into jpapaging values(jpapaging_seq.nextval, 'user03@test.com', 'user03');
insert into jpapaging values(jpapaging_seq.nextval, 'user04@test.com', 'user04');
insert into jpapaging values(jpapaging_seq.nextval, 'user05@test.com', 'user05');
insert into jpapaging values(jpapaging_seq.nextval, 'user06@test.com', 'user06');
insert into jpapaging values(jpapaging_seq.nextval, 'user07@test.com', 'user07');
insert into jpapaging values(jpapaging_seq.nextval, 'user08@test.com', 'user08');
insert into jpapaging values(jpapaging_seq.nextval, 'user09@test.com', 'user09');
insert into jpapaging values(jpapaging_seq.nextval, 'user10@test.com', 'user10');
insert into jpapaging values(jpapaging_seq.nextval, 'user11@test.com', 'user11');
insert into jpapaging values(jpapaging_seq.nextval, 'user12@test.com', 'user12');
insert into jpapaging values(jpapaging_seq.nextval, 'user13@test.com', 'user13');
insert into jpapaging values(jpapaging_seq.nextval, 'user14@test.com', 'user14');
insert into jpapaging values(jpapaging_seq.nextval, 'user15@test.com', 'user15');
insert into jpapaging values(jpapaging_seq.nextval, 'user16@test.com', 'user16');
insert into jpapaging values(jpapaging_seq.nextval, 'user17@test.com', 'user17');
insert into jpapaging values(jpapaging_seq.nextval, 'user18@test.com', 'user18');
insert into jpapaging values(jpapaging_seq.nextval, 'user19@test.com', 'user19');
insert into jpapaging values(jpapaging_seq.nextval, 'user20@test.com', 'user20');
insert into jpapaging values(jpapaging_seq.nextval, 'user21@test.com', 'user21');
insert into jpapaging values(jpapaging_seq.nextval, 'user22@test.com', 'user22');
insert into jpapaging values(jpapaging_seq.nextval, 'user23@test.com', 'user23');
insert into jpapaging values(jpapaging_seq.nextval, 'user24@test.com', 'user24');
commit;
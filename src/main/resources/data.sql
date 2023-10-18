-- Company Test Data
insert into company (name, country, region, created_at, modified_at)
values ('회사1', '대한민국', '서울', now(), now());
insert into company (name, country, region, created_at, modified_at)
values ('회사2', '대한민국', '경기', now(), now());

-- user Test Data
insert into user (name, created_at, modified_at)
values ('사용자1', now(), now());
insert into user (name, created_at, modified_at)
values ('사용자2', now(), now());

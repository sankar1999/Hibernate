insert into course(id, name, created_date, last_updated_date)
values (101, 'Java', '2022-12-20 02:17:25', '2022-12-20 02:17:25');
insert into course(id, name, created_date, last_updated_date)
values (102, 'Python', '2022-12-20 02:17:25',  '2022-12-20 02:17:25');
insert into course(id, name, created_date, last_updated_date)
values (103, 'Go', '2022-12-20 02:17:25', '2022-12-20 02:17:25');



insert into passport(id, number)
values (401, 'E1234');
insert into passport(id, number)
values(402, 'N1234');
insert into passport(id, number)
values (403, 'L1234');

insert into student(id, name, passport_id)
values(201,'Justin', 401);
insert into student(id, name, passport_id)
values(202,'Zayn', 402);
insert into student(id, name, passport_id)
values(203,'Drake', 403);


insert into review(id, rating, description, course_id)
values(501, '5', 'Excellent', 101);
insert into review(id, rating, description, course_id)
values(502, '4', 'Good', 101);
insert into review(id, rating, description, course_id)
values(503, '3', 'Not Bad', 103);


insert into student_course(student_id, course_id)
values(201, 101);
insert into student_course(student_id, course_id)
values(203, 101);
insert into student_course(student_id, course_id)
values(203,101);
insert into student_course(student_id, course_id)
values(201, 103);

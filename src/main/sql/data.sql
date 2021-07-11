insert into teacher(t_first_name, t_last_name, experience) values ('teacher1_f', 'teacher1_l', 1);
insert into teacher(t_first_name, t_last_name, experience) values ('teacher2_f', 'teacher2_l', 2);
insert into teacher(t_first_name, t_last_name, experience) values ('teacher3_f', 'teacher3_l', 3);
insert into teacher(t_first_name, t_last_name, experience) values ('teacher4_f', 'teacher4_l', 4);
insert into teacher(t_first_name, t_last_name, experience) values ('teacher5_f', 'teacher5_l', 5);

insert into course(c_name, data_begin_end, c_id_teacher) values ('course1', 'data1', 1);
insert into course(c_name, data_begin_end, c_id_teacher) values ('course2', 'data2', 2);
insert into course(c_name, data_begin_end, c_id_teacher) values ('course3', 'data3', 2);
insert into course(c_name, data_begin_end, c_id_teacher) values ('course4', 'data4', 3);
insert into course(c_name, data_begin_end, c_id_teacher) values ('course5', 'data5', 4);
insert into course(c_name, data_begin_end, c_id_teacher) values ('course6', 'data6', 4);
insert into course(c_name, data_begin_end, c_id_teacher) values ('course7', 'data7', 4);
insert into course(c_name, data_begin_end, c_id_teacher) values ('course8', 'data8', 5);

insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson1', 'day1', 1);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson1.2', 'day1.2', 1);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson2', 'day2', 2);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson3', 'day3', 3);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson4', 'day4', 4);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson5', 'day5', 5);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson6', 'day6', 6);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson7', 'day7', 7);
insert into lesson(l_name, day_of_week_time, l_id_course) values ('lesson8', 'day8', 8);

insert into student(s_first_name, s_last_name, group_number) values ('student1_f', 'student1_l', 'group1');
insert into student(s_first_name, s_last_name, group_number) values ('student2_f', 'student2_l', 'group2');
insert into student(s_first_name, s_last_name, group_number) values ('student3_f', 'student3_l', 'group3');
insert into student(s_first_name, s_last_name, group_number) values ('student4_f', 'student4_l', 'group4');

insert into course_student(course_id, student_id) values (1, 1);
insert into course_student(course_id, student_id) values (1, 2);
insert into course_student(course_id, student_id) values (1, 3);
insert into course_student(course_id, student_id) values (2, 2);
insert into course_student(course_id, student_id) values (3, 4);
insert into course_student(course_id, student_id) values (4, 4);

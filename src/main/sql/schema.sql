create table teacher(
                        id_teacher serial primary key,
                        t_first_name varchar(20) not null default 'first_name',
                        t_last_name varchar(20) not null default 'last_name',
                        experience integer not null default 0
);

create table course(
                       id_course serial primary key,
                       c_name varchar(20) not null default 'name',
                       data_begin_end varchar(20) not null default 'data_begin_end',
                       c_id_teacher integer not null default 0,
                       foreign key (c_id_teacher) references teacher(id_teacher)
);

create table lesson(
                       id_lesson serial primary key,
                       l_name varchar(20) not null default 'name',
                       day_of_week_time varchar(20) not null default 'day_of_week_time',
                       l_id_course integer not null default 0,
                       foreign key (l_id_course) references course(id_course)
);

create table student(
                        id_student serial primary key,
                        s_first_name varchar(20) not null default 'first_name',
                        s_last_name varchar(20) not null default 'last_name',
                        group_number varchar(20) not null default 0
);

create table course_student(
                       course_id integer,
                       student_id integer,
                       foreign key (course_id) references course(id_course),
                       foreign key (student_id) references student(id_student)
);



create table student(
    rollno int primary key,
    fullname varchar(50),
    city varchar(50)
);

create table mathematics (
                               mno int primary key,
                               marks int,
                               foreign key (mno) references student(rollno)
);

create table physics (
                               pno int primary key,
                               marks int,
                               foreign key (pno) references student(rollno)
);

create table chemistry (
                               cno int primary key,
                               marks int,
                               foreign key (cno) references student(rollno)
);

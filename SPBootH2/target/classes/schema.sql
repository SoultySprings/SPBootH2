CREATE TABLE student(
    rollno int primary key,
    fullname varchar(50),
    city varchar(50)
);

CREATE TABLE mathematics (
    mno int primary key,
    marks int,
    foreign key (mno) references student(rollno)
);

CREATE TABLE physics (
    pno int primary key,
    marks int,
    foreign key (pno) references student(rollno)
);

CREATE TABLE chemistry (
    cno int primary key,
    marks int,
    foreign key (cno) references student(rollno)
);

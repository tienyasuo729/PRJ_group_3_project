create database test;
use test;

CREATE TABLE Student (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(255)
);

CREATE TABLE GGHH (
    ggID INT PRIMARY KEY,
    ggName VARCHAR(255)
);

CREATE TABLE Course (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(255)
);

CREATE TABLE StudentCourse (
    StudentID INT,
    CourseID INT,
    ggID INT NULL,  -- Cho phép giá trị null
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
    FOREIGN KEY (ggID) REFERENCES GGHH(ggID)
);

create table hhh(
	aa INT primary key,
    bb INT,
    FOREIGN KEY (aa) REFERENCES Student(StudentID),
    FOREIGN KEY (bb) REFERENCES Student(StudentID)
);

ALTER TABLE hhh
ADD CONSTRAINT different_values CHECK (aa <> bb);
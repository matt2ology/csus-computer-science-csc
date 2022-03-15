DROP TABLE student;
DROP TABLE course;
DROP TABLE student_course;

CREATE TABLE student(
    SSN NUMBER PRIMARY KEY,
    s_name VARCHAR2(20)
);
CREATE TABLE course(
    course_id NUMBER PRIMARY KEY,
    course_desc VARCHAR2(20)
);
CREATE TABLE student_course(
    SSN NUMBER REFERENCES student,
    course_id NUMBER,
    CONSTRAINT student_course_id_fk FOREIGN KEY (course_id) REFERENCES course
);

-- if you have children table with reference to the parent TABLE
-- 
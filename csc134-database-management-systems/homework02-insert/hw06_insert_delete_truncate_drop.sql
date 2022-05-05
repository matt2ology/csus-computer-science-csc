DROP TABLE MENDO_STUDENT
DROP TABLE MENDO_CLASS
DROP TABLE MENDO_STUDENT_CLASS
CREATE TABLE MENDO_STUDENT(
    SSN    number,
    lname  varchar2(10),
    fname  varchar2(10),
    dob    date,
    salary number,
    --salary check>10000
    CONSTRAINT _candidate_salary_ck check (salary > 10000),
    --(lname and fname are a composite candidate key)
    CONSTRAINT number PK_Student PRIMARY KEY (lname, fname)
)

CREATE TABLE MENDO_CLASS(
    --Class code primary key
    class_code number PRIMARY KEY,
    --Class description (Create an index on this column using the create index command)
    class_desc varchar2(20)
)

--Class description (Create an index on this column using the create index command)
CREATE INDEX idx_class_desc
ON MENDO_CLASS (class_desc)

CREATE TABLE MENDO_STUDENT_CLASS(
    SSN number FOREIGN KEY REFERENCES MENDO_STUDENT(SSN),
    class_code NUMBER FOREIGN KEY REFERENCES MENDO_CLASS(class_code),
)
DROP TABLE mendo_student;
DROP TABLE mendo_class;

CREATE TABLE mendo_student
(
    ssn     VARCHAR2(20),
    lname   VARCHAR2(20),
    fname   VARCHAR2(20),
    age     NUMBER,
    salary  NUMBER,
    dob     NUMBER,
    CONSTRAINT mendo_student_ssn_pk PRIMARY KEY (ssn)
); 

ALTER TABLE mendo_student ADD UNIQUE (fname, lname);

ALTER TABLE mendo_student MODIFY age CONSTRAINT mendo_student_age_ck CHECK (age<10 AND age>50);

ALTER TABLE mendo_student ADD address VARCHAR2(20);

ALTER TABLE mendo_student MODIFY dob DATE NOT NULL;

CREATE INDEX mendo_student_ssn_dob_idx ON mendo_student (ssn, dob);

ALTER TABLE mendo_student ADD transferable CHAR;
ALTER TABLE mendo_student MODIFY transferable CHAR NOT NULL;

ALTER TABLE mendo_student MODIFY transferable CONSTRAINT mendo_student_transferable_ck CHECK (transferable = 'y' or transferable = 'Y' or transferable = 'n' or transferable = 'N');  

ALTER TABLE mendo_student DROP (age);

CREATE TABLE mendo_class
(
  code        NUMBER,
  description VARCHAR2(100) NOT NULL,
  CONSTRAINT mendo_class_description_uk UNIQUE (description)
);

ALTER TABLE mendo_class ADD PRIMARY KEY (code);

CREATE INDEX mendo_class_decription_idx ON mendo_class (description);


CREATE TABLE mendo_student_class(
  ssn  NUMBER;
  code NUMBER;
);

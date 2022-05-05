drop table mendoza_student_class;
drop table mendoza_student;
drop table mendoza_class;
drop table mendoza_student2;
drop table mendoza_class2;

create table mendoza_student
(
 ssn char(11) not null,
 lname varchar(40) not null,
 fname varchar(20) not null,
 phone char(12),
 address varchar(40),
 city varchar(20),
 state char(2),
 zip char(5),
 dob date,
 salary number
);

create table mendoza_class
(
 class_code varchar2(10),
 class_description varchar2(30)
);

create table mendoza_student_class
(
 ssn char(11) not null,
 class_code varchar2(10) not null
);

alter table mendoza_student add constraint mendoza_student_pk primary key (ssn);
alter table mendoza_student_class add constraint mendoza_stu_cla_pk primary key(ssn,class_code);
alter table mendoza_class add constraint mendoza_clss_pk primary key(class_code);
alter table mendoza_student_class add constraint st_fk foreign key (ssn) references mendoza_student;
alter table mendoza_student add constraint mendoza_student_uk unique(lname,fname);
create index mendoza_clss_desc_indx on mendoza_class (class_description);

insert into mendoza_student
values('409-56-7008', 'Bennet', 'Abraham',
'', '6223 Bateman St.', 'Berkeley', 'CA', '94705','26-feb-1988',10000);

insert into mendoza_student
values ('213-46-8915', 'Green', 'Marjorie',
'', '309 63rd St. #411', 'Oakland', 'CA', '94618','25-feb-1989',20000 );

insert into mendoza_student
values('238-95-7766', 'Gren', 'Cheryl',
'415 548-7723', '589 Darwin Ln.', 'Berkeley', 'CA', '94705',null,45000);

insert into mendoza_student
values('998-72-3567', 'Greeenr', 'Albert',
'801 826-0752', '67 Seventh Av.', 'Salt Lake City', 'UT', '84152','24-feb-1992',15000);

insert into mendoza_student
values('427-17-2319', 'Dull', 'Ann',
'415 836-7128', '3410 Blonde St.', 'Palo Alto', 'CA', '94301','23-feb-1993',30000);

insert into mendoza_student
values('672-71-3249', 'Yokomoto', 'Akiko',
'415 935-4228', '3 Silver Ct.', 'Walnut Creek', 'CA', '94595','22-feb-1994',35000);

insert into mendoza_student
values('267-41-2394', 'O''Leary', 'Michael',
'409-56-7008', '22 Cleveland Av. #14', 'San Jose', 'CA', '95128','12-feb-1995',32000);

insert into mendoza_student
values('472-27-2349', 'Gringlesby', 'Burt',
'707 938-6445', 'PO Box 792', 'Covelo', 'NY', '95428','12-feb-1996',34000);

insert into mendoza_student
values('527-72-3246', 'Greene', 'Morningstar',
'615 297-2723', '22 Graybar House Rd.', 'Nashville', 'TN', '37215','11-feb-1995',25000);

insert into mendoza_student
values('999-00-0000', 'Al', 'Cal',
'615 297-2723', '22 Graybar House Rd.', 'Nashville', 'TN', '37215','06-feb-1998',22000);

insert into mendoza_student
values('172-32-1176', 'White', 'Johnson',
'408 496-7223', '10932 Bigge Rd.', 'Menlo Park', 'ma', '94025','05-feb-1999',23000);

insert into mendoza_student
values('712-45-1867', 'del Castillo', 'Innes',
'615 996-8275', '2286 Cram Pl. #86', 'Ann Arbor', 'MI', '48105','04-feb-1982',23500);

insert into mendoza_student
values('846-92-7186', 'Hunter', 'Sheryl',
'415 836-7128', '3410 Blonde St.', 'Palo Alto', 'CA', '94301','03-feb-1979',18000);

insert into mendoza_student
values('486-29-1786', 'Locksley', 'Chastity',
'415 585-4620', '18 Broadway Av.', 'San Francisco', 'CA', '94130','02-feb-1978',15500);

insert into mendoza_student
values('648-92-1872', 'Blotchet-Halls', 'Reginald',
'503 745-6402', '55 Hillsdale Bl.', 'Corvallis', 'OR', '97330','01-feb-1977',43000);

insert into mendoza_class
values('37','Database Programming');

insert into mendoza_class
values('3','Introduction to Computers');

insert into mendoza_class
values('32','Introduction to C programming');

insert into mendoza_class
values('34','Intro to principles');

insert into mendoza_class
values('14A','Operating systems');

insert into mendoza_class
values('1','');

insert into mendoza_class
values('55','');

insert into mendoza_student_class
values('409-56-7008', '37');

insert into mendoza_student_class
values ('213-46-8915', '32');

insert into mendoza_student_class
values('998-72-3567', '3');

insert into mendoza_student_class
values('998-72-3567', '55');

insert into mendoza_student_class
values('427-17-2319', '34');

insert into mendoza_student_class
values('672-71-3249', '3');

insert into mendoza_student_class
values('267-41-2394', '34');

insert into mendoza_student_class
values('472-27-2349', '32');

insert into mendoza_student_class
values('527-72-3246', '1');

insert into mendoza_student_class
values('172-32-1176', '37');

insert into mendoza_student_class
values('712-45-1867', '37');

insert into mendoza_student_class
values('846-92-7186', '32');

insert into mendoza_student_class
values('486-29-1786', '1');

insert into mendoza_student_class
values('648-92-1872', '55');

-- Question 01
-- Using a single SQL statement display fname,lname of all the students who are
-- taking Database Programming regardless of case.

SELECT fname, lname FROM mendoza_student WHERE ssn IN (SELECT ssn FROM mendoza_student_class WHERE class_code IN (SELECT class_code FROM mendoza_class WHERE LOWER(class_description) = 'database programming'));

-- Question 02
-- Using a single SQL statement display all the rows from the student_class
-- table where class description is not null

SELECT * FROM MENDOZA_STUDENT_CLASS WHERE CLASS_CODE IN (SELECT CLASS_CODE FROM MENDOZA_CLASS WHERE CLASS_DESCRIPTION IS NOT NULL);

-- Question 03
--Using a single SQL statement display fname, lname of all the students whose
-- first name is anything except John, Jack or Bob. and are taking the operating
-- systems class and their phone number is null

SELECT fname, lname FROM MENDOZA_STUDENT WHERE fname NOT IN ('John', 'Jack', 'Bob') AND PHONE IS NULL AND ssn IN
(SELECT ssn FROM MENDOZA_STUDENT_CLASS WHERE CLASS_CODE IN
(SELECT CLASS_CODE FROM MENDOZA_CLASS WHERE LOWER(CLASS_DESCRIPTION) = 'operating systems'));

-- Question 04
-- Using a single SQL statement display ssn, fname, lname, age/2 of all the
-- students whose first name begins with the letter J and age is greater than
-- 25 and are taking any class that contains 'Intro' in its description
-- (Have to convert the dob into a number). Order the results by age/2 in
-- descending order. Use an alias for the order by clause

SELECT ssn, fname, TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) / 2 age
FROM mendoza_student WHERE UPPER(fname) LIKE 'J%' AND TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) > 25 AND ssn IN
(SELECT ssn FROM mendoza_student_class WHERE class_code IN
(SELECT class_code FROM mendoza_class WHERE UPPER(class_description) LIKE '%INTRO%'))
ORDER BY age DESC;

-- Question 05
-- Using a single SQL statement display fname, lname from the student table where last name
-- contains the letters 'nn' (e.g. Benny, Bonny, Sonny) and is enrolled in any class
-- that contains the letter 'h' in its description regardless of case. Order the results by lname.
-- When using order by use the position and not the name of the column

SELECT ssn, fname, lname, TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) / 2 age
FROM mendoza_student WHERE UPPER(fname) LIKE 'J%' AND TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) > 25 AND ssn IN
(SELECT ssn FROM mendoza_student_class WHERE class_code IN
(SELECT class_code FROM mendoza_class WHERE UPPER(class_description) LIKE '%INTRO%'))
ORDER BY age DESC;

-- Question 06
-- Using a single SQL statement, delete all the rows from the class table for all classes
-- that are associated with students who live in Sacramento and earn less than 15000
-- (NOTE: you are deleting from the class table)

DELETE FROM mendoza_class WHERE class_code IN
(SELECT class_code FROM mendoza_student_class WHERE ssn IN
(SELECT ssn FROM mendoza_student WHERE LOWER(city) = 'sacramento' AND salary < 15000));


-- Question 07
-- Using a single SQL statement use a combination of create and select to create
-- a new table called class2 that contains the list of all the classes that are
-- taken by students who are older than 30 years old

CREATE TABLE mendoza_class2 AS SELECT class_code, class_description FROM mendoza_class WHERE class_code IN
(SELECT class_code FROM mendoza_student_class WHERE ssn IN
(SELECT ssn FROM mendoza_student WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12) > 30));


-- Question 08
-- Update the salary to 75000 for all students who are enrolled in 'Databas' programming’
-- regardless of case and live in CA

UPDATE mendoza_student SET salary = 75000 WHERE ssn IN
(SELECT ssn FROM mendoza_student_class WHERE class_code IN
(SELECT class_code FROM mendoza_class WHERE UPPER(class_description) = 'DATABASE PROGRAMMING' AND UPPER(state) = 'CA'));

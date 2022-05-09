drop table mendo_student_class;
drop table mendo_student;
drop table mendo_class;
drop table mendo_student2;
drop table mendo_class2;
drop table mendo_new_table;

create table mendo_student
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

create table mendo_class
(
 class_code varchar2(10),
 class_description varchar2(30)
);

create table mendo_student_class
(
 ssn char(11) not null,
 class_code varchar2(10) not null
);

alter table mendo_student add constraint mendo_student_pk primary key (ssn);
alter table mendo_student_class add constraint mendo_stu_cla_pk primary key(ssn,class_code);
alter table mendo_class add constraint mendo_clss_pk primary key(class_code);
alter table mendo_student_class add constraint st_fk foreign key (ssn) references mendo_student;
alter table mendo_student add constraint mendo_student_uk unique(lname,fname);
create index mendo_clss_desc_indx on mendo_class (class_description);

insert into mendo_student
values('409-56-7008', 'Bennet', 'Abraham',
'', '6223 Bateman St.', 'Berkeley', 'CA', '94705','26-feb-1988',10000);

insert into mendo_student
values ('213-46-8915', 'Green', 'Marjorie',
'', '309 63rd St. #411', 'Oakland', 'CA', '94618','25-feb-1989',20000 );

insert into mendo_student
values('238-95-7766', 'Gren', 'Cheryl',
'415 548-7723', '589 Darwin Ln.', 'Berkeley', 'CA', '94705',null,45000);

insert into mendo_student
values('998-72-3567', 'Greeenr', 'Albert',
'801 826-0752', '67 Seventh Av.', 'Salt Lake City', 'UT', '84152','24-feb-1992',15000);

insert into mendo_student
values('427-17-2319', 'Dull', 'Ann',
'415 836-7128', '3410 Blonde St.', 'Palo Alto', 'CA', '94301','23-feb-1993',30000);

insert into mendo_student
values('672-71-3249', 'Yokomoto', 'Akiko',
'415 935-4228', '3 Silver Ct.', 'Walnut Creek', 'CA', '94595','22-feb-1994',35000);

insert into mendo_student
values('267-41-2394', 'O''Leary', 'Michael',
'409-56-7008', '22 Cleveland Av. #14', 'San Jose', 'CA', '95128','12-feb-1995',32000);

insert into mendo_student
values('472-27-2349', 'Gringlesby', 'Burt',
'707 938-6445', 'PO Box 792', 'Covelo', 'NY', '95428','12-feb-1996',34000);

insert into mendo_student
values('527-72-3246', 'Greene', 'Morningstar',
'615 297-2723', '22 Graybar House Rd.', 'Nashville', 'TN', '37215','11-feb-1995',25000);

insert into mendo_student
values('999-00-0000', 'Al', 'Cal',
'615 297-2723', '22 Graybar House Rd.', 'Nashville', 'TN', '37215','06-feb-1998',22000);

insert into mendo_student
values('172-32-1176', 'White', 'Johnson',
'408 496-7223', '10932 Bigge Rd.', 'Menlo Park', 'ma', '94025','05-feb-1999',23000);

insert into mendo_student
values('712-45-1867', 'del Castillo', 'Innes',
'615 996-8275', '2286 Cram Pl. #86', 'Ann Arbor', 'MI', '48105','04-feb-1982',23500);

insert into mendo_student
values('846-92-7186', 'Hunter', 'Sheryl',
'415 836-7128', '3410 Blonde St.', 'Palo Alto', 'CA', '94301','03-feb-1979',18000);

insert into mendo_student
values('486-29-1786', 'Locksley', 'Chastity',
'415 585-4620', '18 Broadway Av.', 'San Francisco', 'CA', '94130','02-feb-1978',15500);

insert into mendo_student
values('648-92-1872', 'Blotchet-Halls', 'Reginald',
'503 745-6402', '55 Hillsdale Bl.', 'Corvallis', 'OR', '97330','01-feb-1977',43000);

insert into mendo_class
values('37','Database Programming');

insert into mendo_class
values('3','Introduction to Computers');

insert into mendo_class
values('32','Introduction to C programming');

insert into mendo_class
values('34','Intro to principles');

insert into mendo_class
values('14A','Operating systems');

insert into mendo_class
values('1','');

insert into mendo_class
values('55','');

insert into mendo_student_class
values('409-56-7008', '37');

insert into mendo_student_class
values ('213-46-8915', '32');

insert into mendo_student_class
values('998-72-3567', '3');

insert into mendo_student_class
values('998-72-3567', '55');

insert into mendo_student_class
values('427-17-2319', '34');

insert into mendo_student_class
values('672-71-3249', '3');

insert into mendo_student_class
values('267-41-2394', '34');

insert into mendo_student_class
values('472-27-2349', '32');

insert into mendo_student_class
values('527-72-3246', '1');

insert into mendo_student_class
values('172-32-1176', '37');

insert into mendo_student_class
values('712-45-1867', '37');

insert into mendo_student_class
values('846-92-7186', '32');

insert into mendo_student_class
values('486-29-1786', '1');

insert into mendo_student_class
values('648-92-1872', '55');

-- Question 01: Give a listing of all the ssns,first names and the class descriptions of
-- all the classes the students are taking. If there are no class _descriptions
-- display 'No description is available yet'. (USE NVL)

select MS.ssn, NVL(MC.class_description,'No description is available yet') "Class_description", MS.fname
from mendo_class MC, mendo_student MS, mendo_student_class MSC
where MC.class_code = MSC.class_code and MSC.ssn = MS.ssn;

-- Question 02: Give a listing of only the lname and the class_code for
-- students who are taking 'Introduction to C programming'. (Inner join)

select lname, MC.class_code
from mendo_class MC, mendo_student MS, mendo_student_class MSC
where MC.class_code = MSC.class_code and MSC.ssn = MS.ssn and class_description='Introduction to C programming';

-- Question 03: Give a lising of all the class_descriptions and the number of
-- students enrolled in each class for all students who are older
-- than the average age where the total number of students for the class
-- is more than 1 student. Order by the number of students. If there
-- is no class description replace it with 'Other Classes'
-- (Note: Take it in steps. First do all those who are older than the average age, then do the group by, then add the having clause and then the order and then combine everything together)

select MSC.class_code,class_description,count(*) "number of students"
from mendo_class MC, mendo_student MS, mendo_student_class MSC
where MS.ssn = MSC.ssn and MSC.class_Code = MC.class_code and months_between(sysdate,dob)/12>(select avg(months_between(sysdate,dob)/12) from mendo_student)
group by MSC.class_Code, MC.class_description
having count(*)>1;

-- Question 04: Give a listing of all the classes for which no students are
-- enrolled in (use in or not in clause) (subquery)

select class_code
from mendo_class
where class_code not in(select distinct(Class_code) from mendo_student_class);

-- Question 05: Give a listing of all the students who are not enrolled in any
-- classes (Note: Use Exists or not Exists)

select fname, lname from mendo_student s left outer join mendo_student_class sc
on s.ssn = sc.ssn where not exists (select * from mendo_student s where s.ssn = sc.ssn);

-- Question 06: create a new table that contains the list of all the students
-- and class_descriptions. Include In this table the list of all
-- students who are not enrolled in any classes (display no classes). If there are no class descriptions then display ‘no description’
-- (Use combination of inner join, union and minus)
-- (Note: minus will deal with the students who are not enrolled in any classes)

CREATE TABLE mendo_new_table AS
SELECT fname, lname, NVL(class_description, 'No Description') AS "Class Description"
FROM mendo_student MS inner join mendo_student_class MSC
on MS.ssn = MSC.ssn inner join mendo_class MC on MSC.class_code = MC.class_code
UNION
((SELECT fname, lname, NVL(class_description, 'No Description') AS "Class Description"
FROM mendo_student MS inner join mendo_student_class MSC
on MS.ssn = MSC.ssn inner join mendo_class MC on MSC.class_code = MC.class_code)
MINUS
(SELECT fname, lname, NVL(class_description, 'No Description') AS "Class Description"
FROM mendo_student MS inner join mendo_student_class MSC
on MS.ssn = MSC.ssn inner join mendo_class MC on MSC.class_code = MC.class_code));

select * from mendo_new_table;

 -- Question 07: repeat question 6 using a combination of inner join, union and not exists
 -- (Note: Not exists will deal with the students who are not enrolled in any classes)

drop table mendo_new_table;

select fname, lname, 'no classes' from mendo_student s where not exists
(select * from mendo_student_class sc where s.ssn = sc.ssn)
UNION
select fname, lname, class_description from mendo_student s natural join mendo_student_class
natural join mendo_class where class_description is not null
UNION
select fname, lname, 'no description' from mendo_student s natural join mendo_student_class
natural join mendo_class where class_description is null;

-- Question 08: create a view. We want to find out which courses are being taken by the different students for all those whose age is greater than the average age. Give a listing of the course descriptions and student names (Inner join)

create view CourseTaken as
select class_description, fname, lname from mendo_student s natural join
mendo_student_class sc natural join mendo_class
where floor(months_between(sysdate, dob) / 12) >
(select avg(floor(months_between(sysdate, dob) / 12)) from mendo_student);

select * from CourseTaken;

-- Question 09: We want to find out the courses that each student is not enrolled in.
-- Give a listing of the course descriptions, and the students (lname) who are not taking that specific course
-- (Use a cartesian product and union it with a minus)

-- SELECT lname, class_description FROM mendo_student, mendo_class, mendo_student_class
-- UNION
-- (SELECT lname, class_description
-- FROM mendo_student st, mendo_class cl, mendo_student_class sc
-- WHERE st.ssn = sc.ssn (+) AND sc.class_code = cl.class_code (+))
-- MINUS
-- (SELECT lname, class_description
-- FROM mendo_student st, mendo_class cl, mendo_student_class sc
-- WHERE st.ssn = sc.ssn AND sc.class_code = cl.class_code);

select lname, class_description from mendo_student, mendo_class
MINUS
select lname, class_description from mendo_student natural join
mendo_class natural join mendo_student_class;

-- 10 Use the system catalog tables to display the results to find out the
-- following:(Note show me the SQL syntax along with your results) Only a single SQL statement for each question.
-- a) Primary key name and the columns that make up the primary key for student table

select constraint_name, column_name from user_constraints natural join
user_cons_columns where table_name = 'MENDO_STUDENT' AND constraint_type = 'P';

-- b) Unique key name and the columns that make up the unique key for the student table

select constraint_name, column_name from user_constraints natural join
user_cons_columns where table_name = 'MENDO_STUDENT' AND constraint_type = 'U';

-- c) Foreign key name, the columns that make up the foreign key 
-- and the columns it references in the parent table for student_class table

select constraint_name, search_condition r_constraint_name
from user_constraints natural join user_cons_columns
where table_name = 'MENDO_STUDENT_CLASS' AND constraint_type = 'R';

-- d) Name of all the check constraints and their conditions for the student table

select constraint_name, search_condition from user_constraints natural join
user_cons_columns where table_name = 'MENDO_STUDENT' AND constraint_type = 'C';

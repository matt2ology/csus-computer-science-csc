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
-- Write a single SQL statement that displays the number of of people with the
-- same lastname. The results should contain the lastname and the count for each
-- lastname. Exclude from the list all those who live in CA

SELECT lname AS "Last Name",
  COUNT(*)   AS "Count"
FROM MENDOZA_STUDENT
WHERE UPPER(state) != 'CA'
GROUP BY lname
ORDER BY lname;

-- Question 02
-- Write a single SQL statement that displays the number of people living
-- in each of the states. The results should display the state and the number
-- of people living in each state.  Exclude from the list all those who are
-- living in cities that contains the letter ‘h’

SELECT state AS "State",
  COUNT(*)   AS "Count"
FROM MENDOZA_STUDENT
WHERE LOWER(city) NOT LIKE '%h%'
GROUP BY state
ORDER BY state;

-- Question 03
-- Use a single SQL statement that  displays the ssn and the number of classes
-- a student is taking with the column heading  “number of classes�?  where the
-- number of classes is less than 2 , order by ssn descending.

SELECT ssn          AS "SSN",
  COUNT(class_code) AS "Number of Classes"
FROM MENDOZA_STUDENT_CLASS
GROUP BY ssn
HAVING COUNT(class_code) < 2
ORDER BY ssn DESC;

-- Question 04
-- Write a single SQL statement that displays the average age for each city,
-- state combination for all students whose salary is greater than the average
-- salary and are taking some kind of ‘Intro’ class. Also exclude the city 'Berkeley'
-- from the list regardless of case. Sort by city in ascending order and state in descending order
  
SELECT city,
  state,
  AVG(TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12)) AS "Age"
FROM MENDOZA_STUDENT
WHERE salary >
  (SELECT AVG(salary) FROM MENDOZA_STUDENT
  )
AND ssn IN
  (SELECT ssn
  FROM MENDOZA_STUDENT_CLASS
  WHERE class_code IN
    (SELECT class_code FROM MENDOZA_CLASS WHERE class_description LIKE 'Intro%'
    )
  )
AND LOWER(city) != 'berkeley'
GROUP BY city,
  state
ORDER BY city ASC,
  state DESC;
  
-- Question 05
-- Write a single SQL statement that displays the States in lower case along
-- with the rounded average age for the different states with the alias name "average of ages"
-- for all the students who are taking a class that contains ‘principles’ in its description regardless of case.

SELECT LOWER(state)                                     AS "states",
  ROUND(AVG(TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12 ))) AS "average of ages"
FROM MENDOZA_STUDENT
WHERE ssn IN
  (SELECT ssn
  FROM MENDOZA_STUDENT_CLASS
  WHERE class_code IN
    (SELECT class_code
    FROM mendoza_class
    WHERE LOWER(class_description) LIKE '%principles'
    )
  )
GROUP BY state
ORDER BY state;

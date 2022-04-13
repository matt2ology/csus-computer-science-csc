drop sequence salary;
drop table mendoza_candidate;
drop table mendoza_party;
drop table mendoza_candidate2;


Create sequence salary start with 20000 increment by 10000;

create table mendoza_party
(
  partyid number primary key,
  partydesc varchar2(20)
);

insert into mendoza_party
values(1,'Democrat');

insert into mendoza_party
values(2,'Republican');

insert into mendoza_party
values(3,'Independent');

insert into mendoza_party
values(4,'');


create table mendoza_candidate
(
  lname varchar(40)  not null,
  fname varchar(20)  not null,
  address	varchar(20),
  salary number,
  dob	date,
  partyid number references mendoza_party
);


insert into mendoza_candidate
values('jennet', 'abraham', 'Berkeley, CA.', salary.nextval, '01 feb 1960',1);

insert into mendoza_candidate
values ( 'Green', 'abraham', 'Oakland, CA.',salary.nextval, '01 feb 1964',1 );

insert into mendoza_candidate
values('gren', 'cheryl','Berkeley, CA.',null,'01 feb 1968',2 );

insert into mendoza_candidate
values('greeenr', 'albert', 'Salt Lake City, UT', salary.nextval, '01 feb 1970',2);

insert into mendoza_candidate
values('gran', 'anne', 'Salt Lake City, UT', salary.nextval, '01 feb 1961',3 );


insert into mendoza_candidate
values('mama', 'mia', 'pepper City, UT', salary.nextval, '01 feb 1968',null );
commit;

-- Group Assignment: Group By

-- Question 01
-- 1) Display the first name of all the candidates who are Democrats. (use subquery)

SELECT fname FROM mendoza_candidate
WHERE partyid = (SELECT partyid FROM mendoza_party WHERE partydesc = 'Democrat');

-- Question 02
-- 2) Display the party description of the all the candidates
-- whose last name ends with 'C' regardless of case. (Use subquery)

SELECT partydesc FROM mendoza_party WHERE partyid IN
(SELECT partyid FROM mendoza_candidate WHERE LOWER(lname) like '%c');

-- Question 03
-- 3) Display the first name of all the candidates who are either Democrats
-- or Republicans regardless of case. (use subquery, use in clause)

SELECT fname FROM mendoza_candidate WHERE partyid IN
(SELECT partyid FROM mendoza_party WHERE partyid = '1' OR partyid = '2');

-- Question 04
-- 4) Create a second table called candidate2 that contains all the data from the
-- candidate table using create table as… statement. The new table should contain
-- only the first name, lastname and the salary, lowered by 10% for all the
-- candidates who are Republicans

Create Table mendoza_candidate2 AS (SELECT fname, lname , salary- salary*0.1 AS salary
FROM mendoza_candidate INNER JOIN Party ON Party.partyid = mendoza_candidate.partyid
WHERE partyDesc = 'Republican');

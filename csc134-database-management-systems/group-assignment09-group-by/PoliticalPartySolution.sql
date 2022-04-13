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
-- 1) Display the number of people in each party. Order by Party. (Make sure to display the party_code)

SELECT partyid, COUNT(partyid) FROM Mendoza_candidate GROUP BY partyid;

-- Question 02
-- 2) Display the number of people in each party whose first name starts with d or r. (Make sure to display the party_code)

SELECT partyid, count(partyid) FROM mendoza_candidate
  WHERE lower(fname) LIKE 'd%' OR lower(fname) LIKE 'r%'
  GROUP BY partyid;

-- Question 03
-- 3) Display the average salary for each party (Make sure to display the party_code)

SELECT partyid, avg(salary) FROM Mendoza_candidate GROUP BY partyid;

-- Question 04
-- 4) Display the number of people in each party  where the number of people does not exceed 2

SELECT partyid, COUNT(partyid) FROM mendoza_candidate GROUP BY partyid HAVING COUNT(partyid) >= 2;

-- Question 05
-- 5) Display the average salary for each party  where the average does not exceed 50000

SELECT partyid, AVG(salary) FROM mendoza_candidate GROUP BY partyid HAVING AVG(salary) >= 50000;

-- Question 06
-- 6)  Create a new table called candidate2 that contains the number of people in each party.
-- Should contain the partycode and the number of people (CAUTION, you have to use an alias for this to work)

CREATE TABLE mendoza_candidate2 AS SELECT partyid, COUNT(*) party_count FROM mendoza_candidate GROUP BY partyid;

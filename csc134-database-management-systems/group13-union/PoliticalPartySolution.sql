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

-- Group Assignment: Union
-- 1)	Display the name and the corresponding description based on the candidates salary
--(Use union and be cautious of the types) Order by name
-- < 50000                      Honest
-- >50000 and < 100000          Not so honest
-- >100000                      80000

SELECT fname || ' '  || lname AS "name", 'Honest' AS "description" FROM mendoza_candidate WHERE salary < 50000
UNION
SELECT fname || ' '  || lname AS "name", 'Not so honest' FROM mendoza_candidate WHERE salary > 50000 AND salary < 100000
UNION
SELECT fname || ' '  || lname AS "name", '80000' FROM mendoza_candidate WHERE salary > 100000
ORDER BY "name";

-- 2)	Display the name and the corresponding description based on the candidates salary
-- (Use a plain case statement in chapter 5)
-- < 50000                      Honest
-- >50000 and < 100000          Not so honest
-- >100000                      80000

SELECT fname || ' '  || lname AS "NAME", CASE WHEN SALARY < 50000 THEN 'Honest'
WHEN SALARY >50000 AND SALARY < 100000 THEN 'Not so honest'
WHEN SALARY >100000 THEN '800000'
END AS "DESCRIPTION"
FROM MENDOZA_CANDIDATE
ORDER BY 1;

-- 3) Display the name of all the people who are not associated with a party (use not in).
-- This is a bit tricky because people who don’t have a party_id will have a null
-- and you cannot compare a null using not in because it doesn’t know how to deal with non-data.
-- You can put the party_id in an NVL function in the where clause to resolve this issue

-- -- Candidate's who are not Republicans --
-- SELECT fname || ' '  || lname AS "NAME" FROM mendoza_candidate
-- WHERE NVL(PARTYID,0) NOT IN(SELECT PARTYID FROM PARTY WHERE PARTYDESC='Republican');

-- -- Candidate's who are not Democrats --
-- SELECT fname || ' '  || lname AS "NAME" FROM mendoza_candidate
-- WHERE NVL(PARTYID,0) NOT IN(SELECT PARTYID FROM PARTY WHERE PARTYDESC='Democrat');

-- -- Candidate's who are not Independents --
-- SELECT fname || ' '  || lname AS "NAME" FROM mendoza_candidate
-- WHERE NVL(PARTYID,0) NOT IN(SELECT PARTYID FROM PARTY WHERE PARTYDESC='Independent');

SELECT CONCAT(fname,lname) as name FROM mendoza_candidate WHERE nvl(partyid, -1) NOT IN (SELECT partyid from mendoza_party)
-- OR 
-- SELECT fname || '' || lname as name FROM mendoza_candidate WHERE nvl(partyid, -1) NOT IN (SELECT partyid from mendoza_party)


-- 4) Repeat question 3 using (not exists)
-- drop table A;
-- drop table B;
-- create table A (fname varchar2(20), id number);
-- create table B (id number, description varchar2(20));
-- insert into A values ('john', 1);
-- insert into A values ('jack', null);
-- insert into B values ( 1,'good');
-- insert into B values ( 2,'bad');
-- select fname from A where not exists(SELECT id FROM B WHERE B.id = A.id AND A.id is not null);

SELECT CONCAT(fname,lname) AS name FROM mendoza_candidate WHERE NOT EXISTS(SELECT partyid FROM mendoza_party WHERE mendoza_party.partyid = mendoza_candidate.partyid AND mendoza_candidate.partyid is not null);

-- 5) Repeat question 3 using (minus)

Select CONCAT(fname,lname) as name from mendoza_candidate
MINUS
Select CONCAT(fname,lname) as name from mendoza_candidate where partyid IS NOT NULL;

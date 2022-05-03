drop sequence salary;
drop table mendoza_candidate;
drop table party;


Create sequence salary start with 20000 increment by 10000;

create table party
  (
    partyid number primary key,
    partydesc varchar2(20)
  );

insert into party
values(1,'Democrat');

insert into party
values(2,'Republican');

insert into party
values(3,'Independent');

insert into party
values(4,'');


create table mendoza_candidate
  (
  lname varchar(40)  not null,
  fname varchar(20)  not null,
  address	varchar(20),
  salary number,
  dob	date,
  partyid number references party
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

-- Question 01

SELECT INITCAP(fname) || ', ' || INITCAP(lname) || ', ' || dob AS "Full Information" FROM mendoza_candidate;

-- Question 02

SELECT INITCAP(fname), TRUNC(MONTHS_BETWEEN(SYSDATE,DOB)/12) FROM mendoza_candidate;

-- Question 03

SELECT UNIQUE INITCAP(lname) AS "Last Name" FROM mendoza_candidate;

-- Question 04

SELECT INITCAP(fname) AS "First Name" FROM mendoza_candidate WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DOB)/12) > 40;

-- Question 05

SELECT INITCAP(fname) AS "First Name", salary FROM mendoza_candidate WHERE salary BETWEEN 20000 AND 40000 OR salary IS NULL;

-- Question 06

SELECT INITCAP(fname) AS "First Name" FROM mendoza_candidate WHERE fname LIKE 'c%' AND TRUNC (MONTHS_BETWEEN(SYSDATE, DOB)/12) > 40;

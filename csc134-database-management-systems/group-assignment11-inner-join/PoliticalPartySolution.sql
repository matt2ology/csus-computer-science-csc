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

-- Group Assignment: Inner Join
-- 1) Display the Cartesian product of the party and candidate table

select * from mendoza_party cross join mendoza_candidate;

-- 2) Display the lastname and the party description of each individual

-- select c.lname, p.partydesc from mendoza_candidate c inner join mendoza_party p on c.partyid=p.partyid;
-- Or simply...
select lname, partydesc from mendoza_candidate natural join mendoza_party;

-- 3) Display the last name and the party dscription of each individual. If there is not a party description, then display no description. (Use the NVL function)

select c.lname,NVL(p.partydesc,'No description') from mendoza_candidate c left join mendoza_party p on c.partyid=p.partyid;

-- 4) Display the number of people in each party (display party_description)

select partydesc, count(partyid) from mendoza_party natural join mendoza_candidate group by partydesc;

-- 5) Display the number of people in each party for only those parties whose average salary is greater than 50,000. (Identify the party name)

SELECT partydesc, count(partyid) from mendoza_party natural join mendoza_candidate having avg(salary) > 50000 group by partydesc;

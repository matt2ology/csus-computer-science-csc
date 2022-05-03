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

-- Group Assignment: Outter Join
-- 1) Display the last name and the party description of each individual. If there is not a party associated with the individual then display “no party”

select c.lname,nvl2(p.partydesc, partydesc, 'no party') from mendoza_candidate c left outer join mendoza_party p on (c.partyid = p.partyid);

-- 2) Display the last name and the party description of each individual. If there is a party that does not have any individuals associated with it, then display “No one”

select nvl(lname, 'no one'), partydesc from mendoza_candidate right outter join mendoza_party on mendoza_candidate.partyid = mendoza_party.partyid;

DROP TABLE Candidate;
DROP TABLE Party;
CREATE TABLE Candidate(
    FirstName VARCHAR(20),
    LastName VARCHAR(20),
    DOB DATE,
    Salary INT
);

CREATE TABLE Party(
    PartyDesc VARCHAR(255)
);

ALTER TABLE Candidate DROP COLUMN DOB;
ALTER TABLE Candidate ADD DOB DATE;
ALTER TABLE Candidate ADD FullName VARCHAR(40);
ALTER TABLE Candidate ADD CONSTRAINT PK_FullName PRIMARY KEY (FullName,FirstName,LastName);

DROP TABLE Party;
Create TABLE Party(
    PartyID INT NOT NULL PRIMARY KEY (PARTYID),
    PartyDesc VARCHAR(255),
);

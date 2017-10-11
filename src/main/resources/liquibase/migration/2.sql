create table DR
 (id NUMBER(11) primary key,
 bezeichnung varchar2(255)
);

Alter table DATAGROUP add ID_DR NUMBER(11);

Alter table DATAGROUP add CONSTRAINT FK_DATAGROUP_DR FOREIGN KEY (ID_DR) REFERENCES DR(id);


show databases;
create database vrps;
use vrps;
create table jobseeker(
FIRST_NAME       VARCHAR(40) NOT NULL,
MIDDLE_NAME      VARCHAR(40) NOT NULL,
LAST_NAME        VARCHAR(40) NOT NULL,
DATE_OF_BIRTH    DATE NOT NULL ,        
PHONE_NUMBER     VARCHAR(40),
ADDRESS VARCHAR(40),
QUALIFICATION    VARCHAR(40) NOT NULL,
EMAIL_ID         VARCHAR(40) NOT NULL,
YEAR_OF_PASSING  int(4) NOT NULL,
JOBSEEKER_ID int(6) AUTO_INCREMENT PRIMARY KEY,
PERCENTAGE     numeric(2),
EXPERIENCE             int(2))
AUTO_INCREMENT=8066900;


create table job_description(jobpost_id INT(6) primary key ,
designation varchar(40) not null,
experience int(2),
eligibiltyPer numeric(2),
skillset VARCHAR(40)
);

create table applications(
REFERENCE_ID    int(6) AUTO_INCREMENT PRIMARY KEY ,
FIRST_NAME       VARCHAR(40) NOT NULL,
MIDDLE_NAME      VARCHAR(40) NOT NULL,
LAST_NAME        VARCHAR(40) NOT NULL,
DATE_OF_BIRTH    DATE NOT NULL ,        
PHONE_NUMBER     VARCHAR(40),
ADDRESS VARCHAR(40),
QUALIFICATION    VARCHAR(40) NOT NULL,
EMAIL_ID         VARCHAR(40) NOT NULL,
YEAR_OF_PASSING  NUMERIC(4) NOT NULL,
PERCENTAGE numeric(2),
JOBSEEKER_ID int(6),
JOBPOST_ID INT(6),
EXPERIENCE int(2),
constraint fkey foreign key (jobpost_id) references job_description(jobpost_id),
constraint f_key foreign key (JOBSEEKER_ID) references JOBSEEKER(JOBSEEKER_ID)) AUTO_INCREMENT=1234567890;

 

create table application_and_status(reference_id int(6) ,
jobseeker_id int(6) ,
jobpost_id int(6) ,
admin_status varchar(3),
tr_status varchar(3),
hr_status varchar(3)
);

 create table rating_comment (
jobseeker_id int(6),
admin_rating int,
admin_comment varchar(50),
tr_rating int,
tr_comment varchar(50),
hr_rating int,
r_comment varchar(50)
);



create table required_skills(
jobpost_id int(6),
skill varchar(100));


create table jobseeker_skills(
jobseeker_id int(6),
skill varchar(100));


create table application_skills(
reference_id int(6),
skill varchar(100));


create table credentials(
user_name varchar(20),
pass_word varchar(20),
jobseeker_id int(10)
);


create table employee_credentials(
user_name varchar(20),
pass_word varchar(20),
job_role varchar(5));


drop table employee_credentials;
drop table credentials;
drop table application_skills;
drop table jobseeker_skills;
drop table required_skills;
drop table rating_comment;
drop table application_and_status;
drop table applications;
drop table jobseeker;
drop table job_description;

#  -----=----=========================================================================================================================================================================================;



insert into employee_credentials values('admin','admin','admin');
 
 insert into employee_credentials values('tr','tr','tr');
 insert into employee_credentials values('hr','hr','hr');

 
 insert into job_description values ( 100,'Developer',1,60,' java sql');
  commit;
desc applications;
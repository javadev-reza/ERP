ALTER TABLE erp_db.M_Application disable keys;
insert into erp_db.M_Application (id,statusEnabled,description,modulId,application,link,price) values(1,true,'Fitur untuk Driver Recruitment',1,'Driver Recruitment','',null);
insert into erp_db.M_Application (id,statusEnabled,description,modulId,application,link,price) values(2,true,'Fitur untuk Drop Box',1,'Drop Box','',null);
insert into erp_db.M_Application (id,statusEnabled,description,modulId,application,link,price) values(3,true,'Fitur untuk Drver Finder',1,'Drver Finder','',null);
ALTER TABLE erp_db.M_Application enable keys;
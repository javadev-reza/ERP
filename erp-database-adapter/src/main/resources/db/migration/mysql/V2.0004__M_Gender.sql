ALTER TABLE erp_db.M_Gender disable keys;
insert into erp_db.M_Gender (id,statusEnabled,description,languageId,gender) values(1,true,null,1,'Laki-Laki');
insert into erp_db.M_Gender (id,statusEnabled,description,languageId,gender) values(2,true,null,1,'Perempuan');
insert into erp_db.M_Gender (id,statusEnabled,description,languageId,gender) values(3,true,null,2,'Male');
insert into erp_db.M_Gender (id,statusEnabled,description,languageId,gender) values(4,true,null,2,'Female');
ALTER TABLE erp_db.M_Gender enable keys;
ALTER TABLE erp_db.M_Language disable keys;
insert into erp_db.M_Language (id,statusEnabled,description,language) values(1,true,null,'Bahasa Indonesia');
insert into erp_db.M_Language (id,statusEnabled,description,language) values(2,true,null,'English');
ALTER TABLE erp_db.M_Language enable keys;
ALTER TABLE erp_db.M_Country disable keys;
insert into erp_db.M_Country (id,statusEnabled,description,country) values(1,true,null,'Indonesia');
ALTER TABLE erp_db.M_Country enable keys;
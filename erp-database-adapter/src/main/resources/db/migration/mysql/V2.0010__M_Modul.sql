ALTER TABLE erp_db.M_Modul disable keys;
insert into erp_db.M_Modul (id,statusEnabled,description,modul) values(1,true,'Modul Default','Default');
ALTER TABLE erp_db.M_Modul enable keys;
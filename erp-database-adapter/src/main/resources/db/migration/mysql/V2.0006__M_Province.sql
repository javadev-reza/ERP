ALTER TABLE erp_db.M_Province disable keys;
insert into erp_db.M_Province (id,statusEnabled,description,countryId,province) values(1,true,null,1,'Jawa Barat');
ALTER TABLE erp_db.M_Province enable keys;
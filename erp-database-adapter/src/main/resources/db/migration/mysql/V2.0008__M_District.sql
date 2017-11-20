ALTER TABLE erp_db.M_District disable keys;
insert into erp_db.M_District (id,statusEnabled,description,cityId,district) values(1,true,null,1,'Bojongloa Kaler');
ALTER TABLE erp_db.M_District enable keys;
ALTER TABLE erp_db.M_City disable keys;
insert into erp_db.M_City (id,statusEnabled,description,provinceId,city) values(1,true,null,1,'Bandung');
ALTER TABLE erp_db.M_City enable keys;
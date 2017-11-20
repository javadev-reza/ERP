ALTER TABLE erp_db.M_SubDistrict disable keys;
insert into erp_db.M_SubDistrict (id,statusEnabled,description,districtId,subdistrict) values(1,true,null,1,'Suka Asih');
ALTER TABLE erp_db.M_SubDistrict enable keys;
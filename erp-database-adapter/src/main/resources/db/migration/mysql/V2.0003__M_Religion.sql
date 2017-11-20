ALTER TABLE erp_db.M_Religion disable keys;
insert into erp_db.M_Religion (id,statusEnabled,description,religion) values(1,true,null,'Islam');
insert into erp_db.M_Religion (id,statusEnabled,description,religion) values(2,true,null,'Katolik');
insert into erp_db.M_Religion (id,statusEnabled,description,religion) values(3,true,null,'Protestan');
insert into erp_db.M_Religion (id,statusEnabled,description,religion) values(4,true,null,'Hindu');
insert into erp_db.M_Religion (id,statusEnabled,description,religion) values(5,true,null,'Budha');
insert into erp_db.M_Religion (id,statusEnabled,description,religion) values(6,true,null,'Konghuchu');
ALTER TABLE erp_db.M_Religion enable keys;
ALTER TABLE erp_db.S_AuthStatus disable keys;
insert into erp_db.S_AuthStatus (id,statusEnabled,description,authStatus) values(1,true,null,'Public');
insert into erp_db.S_AuthStatus (id,statusEnabled,description,authStatus) values(2,true,null,'Private');
insert into erp_db.S_AuthStatus (id,statusEnabled,description,authStatus) values(3,true,null,'Super User');
ALTER TABLE erp_db.S_AuthStatus enable keys;
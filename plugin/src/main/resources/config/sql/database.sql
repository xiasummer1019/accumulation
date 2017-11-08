#创建数据库
CREATE DATABASE hpl_com_01;

#创建用户
CREATE USER 'HPL_COM_01'@'%' IDENTIFIED BY 'HPL_COM_01';

#删除用户
#drop user 'HPL_COM_01'@'%';

#查询权限
SELECT Host,User,authentication_string from mysql.user;
show grants for 'HPL_COM_01'@'%'

#赋予权限
#grant all privileges on HPL_COM_01.* to 'HPL_COM_01'@'%' identified by 'HPL_COM_01';
v

#表权限
grant Select,Insert,Update,Delete,Create,Alter,Index,References on hpl_com_01.* to 'HPL_COM_01'@'%' identified by 'HPL_COM_01';


#列权限
#grant Select, Insert, Update, References on hpl_com_01.* to 'HPL_COM_01'@'%' identified by 'HPL_COM_01';
#视图#存储过程
grant CREATE VIEW, SHOW VIEW, ALTER ROUTINE, CREATE ROUTINE, EXECUTE on hpl_com_01.* to 'HPL_COM_01'@'%' identified by 'HPL_COM_01';


#刷新权限
flush PRIVILEGES;


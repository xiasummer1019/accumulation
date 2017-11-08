-- ----------------------------
-- Table structure for COM_BASE_T_AUTH 权限列表
-- ----------------------------
DROP TABLE IF EXISTS COM_BASE_T_AUTH;
CREATE TABLE COM_BASE_T_AUTH (
auth_id INT  COMMENT 'id',
auth_name varchar(20) COMMENT '权限名称' ,
auth_uuid varchar(50) COMMENT '权限uuid' ,
auth_path varchar(50) COMMENT '权限路径' ,
auth_type int  COMMENT '权限类型:1基础分类2侧边展示3按钮页4按钮操作5' ,
auth_icon varchar(50) COMMENT '权限图标' ,
auth_description VARCHAR(200) COMMENT '权限描述' ,
auth_fid int COMMENT '父权限id',
auth_sn int COMMENT '相对序号'
);

INSERT INTO com_base_t_auth (auth_id,auth_name,auth_uuid,auth_type,auth_icon,auth_description,auth_fid,auth_sn
)VALUES(1,'开发设置','cefdf699-71e4-4416-9c22-af540bf258d4',1,'','开发设置，禁止对外开发！',0,1);

INSERT INTO com_base_t_auth (auth_id,auth_name,auth_uuid,auth_type,auth_icon,auth_description,auth_fid,auth_sn
)VALUES(2,'系统设置','3f36ed55-8aaa-4606-ab9c-4236166041ab',1,'<i class="menu-icon fa fa-desktop"></i>','系统设置，配置相关信息！',0,2);


INSERT INTO com_base_t_auth (auth_id,auth_name,auth_uuid,auth_path,auth_type,auth_icon,auth_description,auth_fid,auth_sn
)VALUES(1001,'权限','9436df96-0938-4d9b-b64b-d7e7327596e7','develop/auth',1,'','开发设置，禁止对外开发！',1,1);

-- ----------------------------
-- 组织机构表
-- ----------------------------
DROP TABLE IF EXISTS COM_BASE_T_ORGANIZATION;
CREATE TABLE COM_BASE_T_ORGANIZATION (
org_id INT  COMMENT 'id',
org_name varchar(20) COMMENT '名称' ,

org_fid int COMMENT '父级id',
);

# RESTfull Demo

本示例采用Springboot + Mybatis 构建了RESTfull示例工程，实现了如下接口

```bash
POST /users       - 创建用户
GET /users        - 获取用户列表
GET /users/:id    - 获取具体用户
PUT /users/:id    - 更新用户
DELETE /users/:id - 删除用户
```

### 工程目录

```
├── java
│   └── xyz
│       └── smallmuou
│           ├── RestfulldemoApplication.java  - 入口类
│           ├── controller
│           │   └── UserController.java       - 用户控制列下，负责路由请求
│           ├── dao
│           │   └── UserMapper.java           - 用户映射类
│           ├── entity
│           │   ├── ResponseResult.java       - 响应包
│           │   └── User.java                 - 用户类
│           └── service
│               └── UserService.java          - 用户服务类，负责调用DAO
└── resources
    ├── application.properties                - 工程配置文件，配置数据库源、mybatis等
    ├── mybatis
    │   ├── mapper
    │   │   └── UserMapper.xml                - 用户对应映射文件
    │   └── mybatis-config.xml                - mybatis配置文件
```


### 数据库

创建restfuldemo数据库，建tb_user表

```
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

### 调用示例

```bash
curl http://localhost:8080/users

curl http://localhost:8080/users/1

curl -X POST -H 'content-type: application/json' -d '{"name":"test"}' http://localhost:8080/users

curl -X PUT -H 'content-type: application/json' -d '{"name":"test1"}' http://localhost:8080/users/1

curl -X DELETE http://localhost:8080/users/1
```

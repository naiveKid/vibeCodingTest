# User Management System

## 项目介绍

基于 Spring Boot 3.0 的用户管理系统，包含用户注册、登录、信息修改、头像上传功能，使用 MySQL 数据库，集成 Spring Security 进行权限管理。

## 技术栈

- Spring Boot 3.0
- Spring Security
- Spring Data JPA
- MySQL
- Maven

## 功能特性

- 用户注册
- 用户登录
- 个人信息查看
- 个人信息修改
- 头像上传

## 项目结构

```
src/main/java/com/example/usermanagement/
├── config/          # 配置类
├── controller/      # 控制器
├── model/           # 实体类
├── repository/      # 数据访问层
├── security/        # 安全配置
├── service/         # 业务逻辑层
└── UserManagementSystemApplication.java  # 应用入口
```

## 配置说明

在 `application.properties` 文件中配置数据库连接信息：

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/user_management_system?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
```

## 运行项目

1. 确保 MySQL 数据库已启动，并且创建了名为 `user_management_system` 的数据库
2. 执行以下命令构建项目：
   ```bash
   mvn clean install
   ```
3. 执行以下命令运行项目：
   ```bash
   mvn spring-boot:run
   ```

## API 接口

### 用户注册
- URL: `/api/users/register`
- Method: POST
- Request Body:
  ```json
  {
    "username": "test",
    "password": "123456",
    "email": "test@example.com",
    "firstName": "Test",
    "lastName": "User"
  }
  ```

### 用户登录
- URL: `/api/auth/login`
- Method: POST
- Form Data:
  ```
  username: test
  password: 123456
  ```

### 获取个人信息
- URL: `/api/users/profile`
- Method: GET
- 需登录

### 修改个人信息
- URL: `/api/users/update`
- Method: PUT
- Request Body:
  ```json
  {
    "firstName": "Updated",
    "lastName": "User",
    "email": "updated@example.com"
  }
  ```
- 需登录

### 上传头像
- URL: `/api/users/avatar`
- Method: POST
- Form Data:
  ```
  file: [选择文件]
  ```
- 需登录

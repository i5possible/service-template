# Service template

Service template for spring boot web app, featuring:
* JUnit 5
* Logging - configured in a yml file.
* Jacoco coverage checking
* Vulnerability checking
* Building docker image for deployment

How to set up a new service:

* Copy or fork this template and do a global replace of ``service-template``
to your service name. Make sure that no references to the string ``service-template`` remain.
* Search for all ``TODO`` and do them.

## 开发流程
* 1.生成entity实体对应的数据库表
 > * 在对应的model下创建对应的实体类    
 > * 执行`./go generate-migration V{version}__xxx`，此时会生成对应的migration文件    
 > * 执行`./go generate-schema`,此时会修改schema.sql文件
 > * 执行`./gradlew bootRun`,此时会执行对应新增的sql文件


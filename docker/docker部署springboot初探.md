#### 一、目标
在win10系统的docker环境中，实现springboot服务的容器部署，并使容器连接宿主机的mysql服务
#### 二、准备工作

1. 安装docker desktop for windows(略)
2. 本地安装mysql服务并启动（略）
3. 准备好idea + maven + springboot + mysql的demo工程
#### 三、使idea连上docker服务

1. 在docker desktop中开启端口（不安全）并重启

![image.png](https://cdn.nlark.com/yuque/0/2023/png/390665/1678457709359-ab1627ac-da5e-4802-b475-d6445929485e.png#averageHue=%231e2c39&clientId=u4ebc545f-0399-4&from=paste&height=627&id=YqUlX&name=image.png&originHeight=1035&originWidth=1920&originalType=binary&ratio=1.6500000953674316&rotation=0&showTitle=false&size=178311&status=done&style=none&taskId=u0e409833-a2dc-43a4-beb5-30a9698fc8a&title=&width=1163.636296379997)

2. 用企业版的idea或者安装idea的docker插件，配置连接信息

![image.png](https://cdn.nlark.com/yuque/0/2023/png/390665/1678457971065-63eb1cc8-2a0c-4d8d-8d47-f55a4d1ddde2.png#averageHue=%233c4145&clientId=u4ebc545f-0399-4&from=paste&height=626&id=u0851b1b7&name=image.png&originHeight=1033&originWidth=1494&originalType=binary&ratio=1.6500000953674316&rotation=0&showTitle=false&size=95174&status=done&style=none&taskId=u54ad1669-9de0-4c21-a598-26c6db1a88d&title=&width=905.4544931206851)
#### 四、工程代码
1、在pom文件中添加docker插件
```xml
<properties>
    <docker.image.name>XXX</docker.image.name>
    <docker.remote.address>http://127.0.0.1:2375</docker.remote.address>
    <docker.dockerfile.dir>src/main/docker</docker.dockerfile.dir>
</properties>
```
```xml
<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>docker-maven-plugin</artifactId>
    <version>1.2.2</version>
    <configuration>
        <!-- 这里是最终生成的docker镜像名称 -->
        <imageName>${docker.image.name}</imageName>
        <!-- docker远程服务器地址 -->
        <dockerHost>${docker.remote.address}</dockerHost>
        <!--设置目录，该目录下放dockerfile-->
        <dockerDirectory>${docker.dockerfile.dir}</dockerDirectory>
        <resources>
            <resource>
                <targetPath>/</targetPath>
                <directory>${project.build.directory}</directory>
                <include>${project.build.finalName}.jar</include>
            </resource>
        </resources>
    </configuration>
</plugin>
```

2. 在pom文件中配置的dockerfile目录下添加dockerfile文件，文件名为Dockerfile
```dockerfile
#指定基础镜像，在其上进行定制
FROM openjdk:11

#维护者信息
MAINTAINER XXX <xxx@gmail.com>

#这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /tmp

#复制上下文目录下的target/xxx-0.0.1-SNAPSHOT.jar 到容器里
COPY xxx-0.0.1-SNAPSHOT.jar app.jar


#声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务
EXPOSE 8080

#指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
#java.security.egd=file:/dev/./urandom 的目的是为了缩短 Tomcat 启动的时间。
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

```

3. 更改mysql配置
   1. 在powershell中输入ipconfig，查到win10安装docker desktop后生成的一个转发ip(与wsl和docker的网络知识相关)
   2. 将IPv4 地址配到springboot的配置文件中，因为服务最终运行在容器中，如果mysql的url配置为localhost：3306肯定无法访问到宿主机的mysql服务，所以需要这个适配器做转发
```
以太网适配器 vEthernet (Default Switch):

   连接特定的 DNS 后缀 . . . . . . . :
   本地链接 IPv6 地址. . . . . . . . : fe80::84a2:9d3a:42e4:6dab%47
   IPv4 地址 . . . . . . . . . . . . : 172.19.0.1
   子网掩码  . . . . . . . . . . . . : 255.255.240.0
   默认网关. . . . . . . . . . . . . :
```
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://172.19.0.1:3306/demo?serverTimezone=GMT%2B8&characterEncoding=utf8&useSSL=true
    username: root
    password: XXXXXX
```

4. 构建镜像并推送到远程仓库
```bash
mvn package docker:build -DskipTests
```
备注：构建成功后，会在docker desptop中看到对应的镜像，也可以通过docker命令查看

5. 部署容器
```bash
docker run -p 8080:8080 --name <容器名> <镜像名>
```
#### 五、问题记录

1. 在第三步使idea连上docker服务的时候，TCP socket输入tcp://localhost:2375总是无法连接成功

解决方法参考：

2. 容器访问宿主机mysql总是失败

解决方案：如4.3中描述，需要适配器做转发
##### 六、总结

1. 使用docker的确能使打包、部署、运维等操作更加便捷
2. **docker的网络知识很总要，需要理解并熟练使用**
3. 关于idea插件等客户端远程连接docker的方案在生产环境需要用认证信息保证环境安全

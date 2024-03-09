
<div align=center>
	<h3>📚 "[백엔드 개발자 성능 개선 초석 다지기] java CompletableFuture 비동기활용 편 코드입니다." 📚</h3>
</div>
<br><br>

# 📖 실습 환경
* spring boot 2.7.4
* java 11
* ehcache 2.x
* mysql 8.0.33
* Maven
* intellij

## "백엔드 개발자 성능 개선 초석 다지기" 비동기활용 관련된 코드만 포함되어 있습니다.

### 본인 환경에 맞는 디비 설정정보를 application.properties로 수정 해주세요.

```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/study_db
spring.datasource.username=
spring.datasource.password=
```

### notice 테이블

```sql
CREATE TABLE `notice` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `who` varchar(30) DEFAULT NULL,
  `createDate` timestamp NOT NULL,
  `updateDate` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_notice_createDate` (`createDate`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb3;
```


### 아래에 pom.xml 전체 코드를 붙여서 동일한 환경에서 실습해주세요.

* 전체 pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.example</groupId>
    <artifactId>performancecache</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>performancecache</name>
    <description>performancecache</description>
    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.3.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>

        <!-- mybatis sql pretty -->
        <dependency>
            <groupId>org.bgee.log4jdbc-log4j2</groupId>
            <artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
            <version>1.16</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

```
         







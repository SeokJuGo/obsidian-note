# [[Spring]] Boot

- 기존 Spring의 경우 Applicatino 개발 시에, 많은 사전작업이 필요한 것을 간소화

1) Project에 따라 자주 사용되는 library가 미리 조합되어있음
2) 복잡한 설정을 자동 처리
3) 내장 서버를 포함하여 tomcat과 같은 WAS를 추가로 설치하지않아도 됨.
4) WAS에 배포하지 안혹도 실행할 수 있는 JAR파일로 Web Application을 개발 할 수 있음.

## `@SpringBootApplication`

- 기존 xml이 하던 초기화 작업을 모두 처리해줌.

### 참조

https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.using-the-springbootapplication-annotation

### 1. Port 및 파일경로

```properties
# server.servlet.context-path=/board
server.port=80


# JSP Path (ViewResolver)
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

### 2. DB설정

```properties
# DataBase Settings : hikariCP : https://github.com/brettwooldridge/HikariCP
spring.datasource.hikari.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.datasource.hikari.jdbc-url=jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8
spring.datasource.url=jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8
spring.datasource.hikari.username=ssafy
spring.datasource.hikari.password=ssafy

#MyBatis Setting
mybatis.type-aliases-package=com.ssafy.*.model
mybatis.mapper-locations=mapper/**/*.xml
```

### 3. 파일path

```properties
# file upload path : window
file.path=C:/board/upload/
file.path.upload-images=C:/board/upload/imageUpload
file.path.upload-files=C:/board/upload/fileUpload/
```


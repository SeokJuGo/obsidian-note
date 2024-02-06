---
tags:
  - Spring
---

### 1.XML 기반 설정

XML 파일을 사용하여 `ApplicationContext`를 설정할 수 있다. 기본적으로 `applicationContext.xml` 파일에 빈(bean) 설정과 의존성 주입을 정의

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.1.xsd">
	
	<context:component-scan base-package="com.ssafy.hello.di5"></context:component-scan>
	
</beans>
```



### 2. 어노테이션 기반 설정:

어노테이션을 사용하여 빈을 정의하고 의존성 주입을 수행할 수 있다. `@Component`, `@Service`, `@Repository`, `@Autowired` 등의 어노테이션을 사용

```java
@Component(value = "eng")
public class HelloMessageEng implements HelloMessage {
}

@Component (value="kor")
public class HelloMessageKor implements HelloMessage {
	
}
```

### 3. 자바 설정 파일 (JavaConfig) 사용:

자바 파일에서 어노테이션 `@ComponentScan` 설정할 수 있다

```java
@ComponentScan(basePackages   = {"com.ssafy.hello.di6"})
public class ApplicationConfig {

}
.
.
public class HelloMain {

	public static void main(String[] args) { 
ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContext.class);
        
    }

---
tags:
  - Spring
---

# AOP
-----

CCC CC **묘듈화하여 재사용하는 기법**

| AOP 용어    |                                                              |
| ----------- | ------------------------------------------------------------ |
| `Target`    | 핵심 기능을 담고 있는 모듈                                   |
| `Advice`    | 어느 `시점`에 기능을 실행할지의 여부                         |
| `JoinPoint` | aspect가 적용 될 수 있는 지점                                |
| `Pointcut`  | 적용될 JoinPoint를 정규표현식으로 나타낸 것                  |
| `Aspect`    | 여러 객체에 공통으로 적용될 공통 관심사항 `aspect=Advice+PointCut` |
| `Weaving`   | 스프링이 하는 행위(바느질하기)                               |

### PCD 포인트컷 사용예제

```xml
"execution(\[선언타입\] 리턴타입 (패키지.클래스.메서드) 매개변수)"  
<aop:pointcut id="publicMethod" expressio\="execution(* * * (..))"/>      
<aop:pointcut id="publicMethod" expression="execution(public com.ssafy..*Person.getAge (Integer,..))"/>
```



| Pointcut                                              | 선택된 Joinpoint                                             |
| ----------------------------------------------------- | ------------------------------------------------------------ |
| `execution (public * *(.))`                           | public 메소드 실행                                           |
| `execution (* set*(..))`                              | 이름이 set으로 시작하는 모든 메소드 실행                     |
| `execution(* set* (...))`                             | 이름이 set으로 시작하는 모든 메소드 실행                     |
| `execution(* com.test.service.AccountService.* (..))` | AccountService 인터페이스의 모든 메소드 실행                 |
| `execution(* com.test.service.* *())`                 | service패키지의 모든 메소드 실행                             |
| `execution(* com.test.service..*.*(...))`             | service패키지와 하위 패키지의 모든 메소드 실행               |
| `within(com.test,service.*)`                          | service패키지 내의 모든 결합점                               |
| `within(com.test.service..*)`                         | service패키지 및 하위 패키지의 모든 결합점                   |
| `this (com.test.service.AccountService)`              | AccountService인터페이스를 구현하는 프록시 개체의 모든 결합점 |
| `arget(com.test.service.AccountService)`              | AccountService인터페이스를 구현하는 대상 객체의 모든 결합점  |
| `args (java.io.Serializable)`                         | 하나의 파라미터를 갖고 전달된 인자가 Serializable인 모든 결합점 |


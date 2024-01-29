## 목차

[1.Abstract](#1-abstract)

[2.Interface](#2-interface)

[3.Generic](#3-generic)

JAVA - Penguin  C++ - diamond 상속

---

# 1. Abstract

- 자손클래스에서 조상메소드를 반드시 재정의할 때

- abstract 클래스는 객체생성불가.(타입은 가능)

  ```
  public abstract class Vehicle{
  ...}
  Vehicle v = new Vehicle(); //?
  Vehicle v = new Car(); //?
  ```

- abstract 메소드는 오버라이드강요. 클래스는 상속강요 abstract method <--> final method

- abstract 메소드가 하나라도있으면 abstract 클래스가 되어야한다.

- 제한자와 순서가 바뀌어도 된다.



# 2. Interface

### 1)특징

- 최고 수준의 추상화 단계 (옷(inter) ->상의(abstract) ->티셔츠(구현))
- 모든 멤버 변수는 public static final (생략 가능)  int a (x) private(x)
- 모든 메서드는 public abstract (생략 가능)
- 다중 상속 가능 (구현이 없다.)
- abstract method는 abstract가 붙지만 interface는 public

일반

구현method -> field -> 생성자

interface

구현method x -> field x -> 생성자 x

### 2) 장점

- 인터페이스를 통한 간접적인 클래스사용 - 프린터
- 상속의 관계가 없는 클래스들에게 관계 부여(다형성)  - 카메라 폰 (기능이 같다 ex)충전)
- 독립적인 프로그래밍으로 개발 기간 단축 - 계산기

open-close principle -> 사용에는 열려있으나 수정은 폐쇄 -> 인터페이스를 사용

### 3) default 메소드

- 새로운 기능이 생겼을때 하위 클래스들이 구현하지 않고 오버라이드

- 문제점

​	1, 슈퍼 클래스와 인터페이스 중복이름(슈퍼클래스 우선)  

2. 인터페이스와 인터페이스 중복(반드시 오버라이드)



# 3. Generic<T>

- 컴파일 시에 타입을 명시
- 참조타입만 가능

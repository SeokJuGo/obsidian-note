# 생성자
- 초기화, 리턴이 없는 메서드
- 멤버변수의 초기화

## 목차

1. [생성자](#1-생성자)
2. [this](#2-this)
3. [초기화 블록](#3-초기화-블록)


## 1. 생성자

### 1) 기본생성자

- 파라미터가없다, 생성자코드가 없으면 컴파일러가 제공

### 2) 파라미터가 있는 생성자

- 파라미터가 있는 생성자가있으면 기본 생성자는 추가되지않음
- 생성자 호출 시 값을 넘겨줘 초기화

```java
Person p1 =new Person();
Person p2 = new Person("go",20);
```

## 2. this

- 현재 클래스의 객체를 의미→static에서는 안됨
- this() 객체의 생성자를 의미
- 생성자 오버로딩

```java
public Person(int age,String name){

}
public Person(String name){
System.out.println();// 주의
this(0,"김") 
}


```
- 오버로딩 중복된 코드

![image](https://github.com/SeokJuGo/SSAFY_TIL/assets/116260619/ae37f602-12e3-41bb-a1f5-203d8dcb2bf4)

## 3. 초기화 블록

```java

boolean isHungry;
static{ //?

}
	{isHungry = true; //?
	}

```

# 0. OOP? 
- Object? 주체가 아닌것, 주체가 활용하는 것
- OOP? 주변의 많은 것들을 객체화해서 프로그래밍

## 1) APIE

- 추상화(Abstraction)
- 다형성(Polymorphism)
- 상속(Inheritance)
- 은닉(Encapsulation)

## 2) 장점

- 신뢰성
- 추가/수정/삭제가 용이
- 재사용성

## 목차

1. [추상화](#1-추상화)
2. [JVM 메모리](#2-jvm-메모리)
3. [변수](#3-변수)
4. [메서드](#4-메서드)

---

# 1. 추상화

- 현실의 객체가 갖는 속성과 기능을 추상하여 클래스에 정의한 것

타입 = 설계도 = 틀 = class

# 2. JVM 메모리

![image](https://github.com/SeokJuGo/SSAFY_TIL/assets/116260619/853c920f-2890-4f85-b7cf-f0e8f993a8f9)
```java
Person p1 = new Person();
```
- 세 단계의 순서!

# 3. 변수

```java
public class Person{
	static int age // 클래스멤버면수
	String name // 인스턴스멤버변수
	public void method(){
	int a // 지역변수
	}
}

```

### 📣 주의

- 지역변수는 스택에 있기 때문에 괄호가 끝나면 소멸, 이 후 지역변수가 생성했던 heap영역의 메모리는 gc가 소멸시킨다.

### 클래스 멤버변수
```java
Person p1 = new Person();
p.name = " " //x
person.name = "변경" //o
```

</br>


```java
public class Person {  // 여기서 생각해야 할 것?
	private int age;
	static int a = 0;
	public static void main(String[] args) {
		Person.a = 10;
		Person p1 = new Person();
		System.out.println(p1.a);
		System.out.println(Person.a);
	}	
}
```
# 4. 메서드

- double res = add(100,200); # 리턴 값이 묵시적 형변환된다.

```jsx
void add(long a,long b){
return a+b
}
add(1.1,2.2);
add(10L,20L);
// float? long? 묵시적 형변환이 될까?
```

- variable arguments

```jsx
public void variableArgs(// ??){
int sum = 0;
for(  //? ){
sum+=i;
}
System.out.println(sum);
```

![image](https://github.com/SeokJuGo/SSAFY_TIL/assets/116260619/3ad2110b-dccb-4ab8-82ea-20ce28c08334)

![image](https://github.com/SeokJuGo/SSAFY_TIL/assets/116260619/9fd5443e-6c08-4cb6-96ce-f2abb1f145c8)

### 1) 오버로딩(Overloading)

- 메서드이름은 같지만, 매개변수 개수나 타입이 다른 것 (리턴타입xx)
- 장점 - 기억해야할 메소드 이름 감소 중복코드 효율적 관리 ex)println()
1. Q1

```jsx
static public long add(long a, long b) {
		return a+b;
	}
add(1,2)
```

2. Q2

```jsx
static public int add(float a, int b) {
		return a+b;
	}
		System.out.println(add(2,2));

```

3. Q3

```jsx

static public long add(long a, int b) {
		return a+b;
	}
	static public long add(int a, long b) {
		return a+b;
	}
add(1,2)
```

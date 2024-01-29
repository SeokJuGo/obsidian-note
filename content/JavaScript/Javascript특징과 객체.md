# JavaScript

## 1. 특징

- 인터프리터 언어

```javascript
<!--한 줄씩 읽기 때문에 script태그를 
body태그에 쓰는경우는 사용자에게 나중에 띄어줄때
-->
<head><script type = "text/javascript"></script> </head>
<body><script><!----></script></body>
```

- 일급객체  (함수를 변수,리턴값,파라미터)

```javascript
<!--1. 변수에 할당 할 수 있다.-->
const greet = function(name) {
    console.log('안녕하세요, ' + name + '님!');
};

function sayHello(greetingFunction, name) {
    greetingFunction(name);
}
<!--2. 다른 함수의 매개변수로 전달할 수 있다:.-->
sayHello(greet, '사용자');

<!--3. 함수에서 반환할 수 있습니다:-->
function createGreeter() {
    return function(name) {
        console.log('안녕하세요, ' + name + '님!');
    };
}
```

- Undefined, null, 0 은 모두 False이다.

```javascript
      var a; <!-- undefined-->
      var b = null; <!-- null-->
      var c = 0; <!-- 0 -->
      if (!a) {console.log("a"); } <!-- a -->
      if (!b) { console.log("b"); } <!-- b -->
      if (!c) { console.log("c");  } <!-- c -->
```

- 자동 형변환

```javascript
<!--자동 형변환되지만, + 는 문자열을 이어준다-->
 	  console.log("40" - 5); // 35
      console.log("40" + 5); // 405
```

- 언더플로우, 오버플로우가 실행된다.

```javascript
<!--오류가 나지 않기때문에 주의-->      
// 언더플로우
      console.log(0 / 100); // 0
      console.log(-0 / 100); // -0

      // 오버플로우
      console.log(100 / 0); // Infinity
      console.log(-100 / 0); // -Infinity
```

![image](https://github.com/SeokJuGo/SeokJuGo/assets/116260619/c0b4dfdd-1937-4c0b-894a-6e8d8c01c107)

## 2. 객체

- 자바와 동일하게 생성자를 사용해서 객체를 사용할 수 있음.

```javascript
      // 생성자 함수
      function Student(name, area, classNum) {
        this.s-name = name;
        this.area = area;
        this.classNum = classNum;
        this.info = function () {
          console.log(this.name + "은 " + this.area + this.classNum + "반");
        };
      }

      // 객체 생성.
      var student1 = new Student("김싸피", "서울", 10);
      var student2 = new Student("박싸피", "대전", 4);
student1.name

<!--[]표기법과 .표기법을 사용할 수있다.-->

      // 속성명에 연산자가 포함된 경우 [] 표기법만 접근 가능.
      console.log(student1["s-name"]); // 김싸피
      console.log(students1.s - name); // NaN
```


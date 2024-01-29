## 1. var, let, const

| 키워드  |     스코프     | 재할당 가능 여부 |
| :-----: | :------------: | :--------------: |
|  `var`  | function scope |       가능       |
|  `let`  |  block scope   |       가능       |
| `const` |  block scope   |      불가능      |

#### 1) var

```js
var x = 10;
console.log(x);
var x = 20;
console.log(x);
{
  console.log(x);
}
```

- 선언 및 재 할당이 가능하다.
- 전역 범위 스코프이다.

#### 2) let

```js
let y = 10;
// let y = 5; 불가능
y = 5;
{
  let y = 20;
  console.log(y);
}
```

- let 예약어는 한번 선언한 변수를 다시 선언할 수 없다.
- 재 할당은 가능
- block scope이기 때문에 블록안에서 선언이 가능하다.

#### 3) const

```js
const z = 10;
//const z =5; 불가능
//z = 5; 불가능
console.log(z);
{
  const z = 50;
  console.log(z);
}

```

- const 한번 선언한 변수를 다시 선언할 수 없다.
- 재 할당도 불가능
- block scope이기 때문에 블록안에서 선언이 가능하다.





## 2. PropertyShorthand, ConciseMethod

```js
var id = "ssafy",
  name = "고석주",
  age = 28;

const user = {
  id,
  name,
  age,
  info() {
    console.log("user info : " + this.id + " " + this.name + " " + this.age);
  },
};
```

- PropertyShorthand :`{id:id , name:name, age:age}` 할 필요 없이, 변수 명 그대로 입력하면 된다. 
- ConciseMethod : `console.log("user info : " + this.id + " " + this.name + " " + this.age);` this를 입력해주어야 해당 객체의 내용을 반환한다.

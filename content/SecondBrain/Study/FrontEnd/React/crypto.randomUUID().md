---
title: crypto.randomUUID()
tags:
  - React
date: 2024-03-07
중요도: 중
---
# 날짜  2024-03-07 16:07

# 메모
### 1. UUID
- uuid는 범용적인 고유 식별에 사용될 id
- 주로 사용할 때는 다른 값과 중복되지 않은 고유 값을 생성해야 할 때 사용한다.

### 2. crypto
- crypto는 기본적인 암호화 기법을 제공하는 객체
	이를 통해 무작위 숫자 생성기나 암호화에 필요한 기본 요소에 접근할 수 있다

crpyto.randomUUID() 메소드를 사용하면 uuid 라이브러리를 사용하지 않고도, uuid를 생성할 수 있다.

# 코드

```js
let uuid = crypto.randomUUID();
console.log(uuid); // for example "36b8f84d-df4e-4d49-b662-bcde71a8764f"
```
```
---
title: UseSate 속성 추가하기
tags:
  - React
  - JavaScript
date: 2024-02-03T15:47:00
---
`useState()`에는 set함수밖에 사용 할 수밖에없어, 새로운 변수를 선언 후 재사용해야 할 지 고민했다.


아래처럼 배열을 가져올땐 자바스크립트 `전개 연산자`를 사용하면 된다.

```javascript
var arr1 = [1, 2, 3]; var arr2 = [4, 5, 6];
ex) var combinedArray = [...arr1, ...arr2]
```


```javascript
  
		const [months, setMonths] = useState<number[]>([]);
        for (let i = 1; i <= 12; i++) {
            setMonths((months) => [...months, i]);
        }
```
- useState와 전개연산자를 사용한 코드
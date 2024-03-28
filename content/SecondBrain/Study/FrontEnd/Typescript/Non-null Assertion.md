---
title: Non-null Assertion
tags:
  - Typescript
date: 2024-03-28
중요도: 중
---
# 날짜  2024-03-28 14:52

# 메모


TypeScript에서 Non-null Assertion 연산자인 `!`은 nullable한 변수나 속성을 사용할 때 TypeScript 컴파일러에게 해당 표현식이 null 또는 undefined가 아니라고 확신시키는 역할

## 코드

예시 1.

```typescript
console.log(nullableValue.length); // 오류: Object is possibly 'null'.

```

```Typescript
console.log(nullableValue!.length); // OK: 여기서 non-null assertion 연산자를 사용하여 오류를 피할 수 있다.
```

예시 2.
```typescript
const a = JSON.parse(sessionStorage.getItem("myInfo")!);
```

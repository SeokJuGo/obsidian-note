---
title: globalStyle
tags:
  - VanillaExtract
date: 2024-03-21
중요도: 중
---
# 날짜  2024-03-21 10:33

# 메모
css selector같이 사용하고 싶을 때 사용한다.
자식 요소를 여러 개 속성을 추가할 때 가독성을 위해 사용한다.

# 코드
```ts
export const ul = styleVariants({  
    store: [{marginBottom: '10px'}],  
    menu: [{display: 'flex', justifyContent: 'space-around',}]  
})  
globalStyle(`${ul.menu} > li`, {  
    width: '25%',  
});
```
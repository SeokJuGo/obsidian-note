---
title: styleVariants
tags:
  - VanillaExtract
date: 2024-03-21
중요도: 중
---
# 날짜  2024-03-21 10:27

# 메모
중복되는 요소 또는 css가독성을 위해 비슷한 변수를 그룹핑 할 때 사용한다.


# 코드
```ts
export const baseContainer = style({  
    width: '100%',  
    height: '100%',  
    position: 'absolute',  
    justifyContent: 'center',  
  
    top: 0,  
    right: 0,  
    bottom: 0,  
    left: 0,  
    zIndex: 1,  
  
})  
export const container = styleVariants({  
  
    invisible: [baseContainer, {  
        backgroundColor: "rgba(0, 0, 0, 0.5)",  
        zIndex: 2,  
    }],  
    visible: [baseContainer, {  
        pointerEvents: 'none',  
        overflow: 'hidden',  
  
    }]  
})
```
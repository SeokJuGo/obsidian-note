---
title: pointer
tags:
  - CSS
date: 2024-03-19
중요도: 중
---
# 날짜  2024-03-19 17:26

# 메모
pointer-events CSS 속성은 그래픽 요소가 어떤 상황에서 포인터 이벤트의 대상이 될 수 있는지 지정한다.

- 모달을 띄우고 나서 invisible상태에서, 앞 부분을 무시하고 싶을 때 사용했다.



# 코드
```css
/* 키워드 값 */
pointer-events: auto;
pointer-events: none;
pointer-events: visiblePainted; /* SVG only */
pointer-events: visibleFill;    /* SVG only */
pointer-events: visibleStroke;  /* SVG only */
pointer-events: visible;        /* SVG only */
pointer-events: painted;        /* SVG only */
pointer-events: fill;           /* SVG only */
pointer-events: stroke;         /* SVG only */
pointer-events: all;            /* SVG only */
/* 전역 값 */
pointer-events: inherit;
pointer-events: initial;
pointer-events: unset;
```

```tsx
import {createVar, style, styleVariants} from '@vanilla-extract/css';  
import theme from '@/styles/theme/theme';  
  
  
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
    visible: [baseContainer, {  
        backgroundColor: "rgba(0, 0, 0, 0.5)"  
    }],  
    invisible: [baseContainer, {  
        pointerEvents: 'none',  
        overflow: 'hidden',  
  
    }]  
})  
const baseModal = style({  
    width: '100%',  
    height: '70%',  
    position: 'absolute',  
    bottom:0,  
    borderRadius: '10px',  
    background: 'white',  
    transitionDuration: "500ms",  
    transition: "transform 0.4s ease-out",  
    backgroundColor: theme.layout  
})  
export const modal = styleVariants({  
    visible:[baseModal,{display: 'inline', transform: 'translateY(0%)'}],  
    invisible:[baseModal,{ transform: 'translateY(100%)', overflow: 'hidden',}]  
})
```
---
tags:
  - React
---

![[Pasted image 20240131110607.png]]
```tsx
import React from 'react';  
import palette from '@/lib/styles/colorPalette'  
const Hamburger = () => {  
    return (  
            <svg xmlns="http://www.w3.org/2000/svg"  
                 width="25"  
                 height="25"  
                 viewBox="0 0 24 24"  
                 fill="none"  
                 stroke={palette.MenuColor}  
                 stroke-width="2"  
                 stroke-linecap="round"  
                 stroke-linejoin="round"  
                 className="feather feather-menu">  
                <line x1="3" y1="12" x2="21" y2="12"></line>  
                <line x1="3" y1="6" x2="21" y2="6"></line>  
                <line x1="3" y1="18" x2="21" y2="18"></line>  
            </svg>    );  
};  
  
export default Hamburger;
```
stroke-width="2"  
stroke-linecap="round"  
stroke-linejoin="round" 

svg파일을 jsx로 바꿔주면서 생기는오류

`카멜케이스`로 사용해야한다. 
예) strokeWidth 
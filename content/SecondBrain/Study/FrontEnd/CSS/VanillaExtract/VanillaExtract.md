---
title: VanillaExtract
tags:
  - VanillaExtract
  - CSS
date: 2024-03-08
중요도: 중
---
# 날짜  2024-03-08 16:53

# 메모

Vanilla Extract는 CSS-in-JS 도구
npm
- npm install @vanilla-extract/css
- npm install --save-dev @vanilla-extract/next-plugin
next.config.js
```
const { createVanillaExtractPlugin } = require('@vanilla-extract/next-plugin'); const withVanillaExtract = createVanillaExtractPlugin(); /** @type {import('next').NextConfig} */ const nextConfig = {}; module.exports = withVanillaExtract(nextConfig);
```


- CSS에서 JS문법을 사용할 수 있어서 생산성 🔼
- 컴포넌트 파일에 관련된 코드들을 함께 둘 수 있음
- className이 겹치지 않음을 보장한다.(지역 스코프 스타일)
# 코드

.css.ts
```tsx
import { style } from '@vanilla-extract/css';  
import theme from "./theme/theme"  
  
export const container = style({  
    // Mobile width  
    width: '100%',  
  
  
    // Default width  
    '@media': {  
        'screen and (min-width: 768px)': {  
            width: '40%'  
        },  
    },  
    backgroundColor: `${theme.layout}`  
});
```

  ```tsx
  import * as styles from "@/styles/header.css"


<div className="styles.container"></div>
```

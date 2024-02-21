---
제목: Modal Bottom-up style-sheet
tags:
  - CSS
날짜: 2024-02-04
중요도: 하
---
# 날짜 : 2024-02-04  18:30


# 메모

주로 모달창에서  쓰임. 아래서 위로 올라오는 효과
# 코드
```css
.bottom-sheet {  
    position: fixed;  
    bottom: 0;  
    width: 40vw;  
    height: 100vh;  
    transform: translateY(100%);  
    transition: transform 0.4s ease-out;  
}
```
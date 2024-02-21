---
제목: "@media 쿼리"
tags:
  - CSS
날짜: 2024-02-15
중요도: 중
---
# 날짜  : 2024-02-15  17:57


# 메모
`@media` 쿼리를 사용하여 화면 너비가 768px 이하일 때, 너비를 100%로 설정하여 모바일 환경에 적합하게 만들어 줄 수있다.

# 코드
```css
const Container = styled.div`  
  width: 40%;  height: 100%;  background-color: white;   
  /* 모바일 환경에서는 너비를 100%로 */  
  @media (max-width: 768px) {    width: 100%;  }`;
```
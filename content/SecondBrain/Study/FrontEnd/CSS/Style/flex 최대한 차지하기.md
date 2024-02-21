---
title: flex 최대한 차지하기
tags:
  - CSS
date: 2024-02-21
중요도: 하
---
# 날짜  2024-02-21

# 메모
네비게이션 바에서 로그아웃 등 끝 쪽으로 밀고 싶을 때가 있다.
flex:1 을 해주면 최대한 그 공간을 차지하게 된다.

https://codepen.io/SeokJuGo/pen/poYBMrz
# 코드
```html
<div class="container">
  <div class="item">Item 1</div>
  <div class="item">Item 2</div>
  <div class="">Item 3</div>
</div>
```
```css
  .item {
    flex: 1;
    border: 1px solid #777;
    margin: 10px;
    text-align: center;
    line-height: 200px;
  }
```
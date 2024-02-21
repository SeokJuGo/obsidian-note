---
제목: hover,active,duration
tags:
  - CSS
날짜: 
중요도: 하
---
# 날짜 : 2024-02-06  10:24


# 메모

`hover`: 마우스를 가져가 댈 때 변경되는 효과
`active`: 마우스를 누를 때 변경되는 효과
`duration`: 변경되는 시간을 늘리는 효과
# 코드
tailwind
```css
hover:bg-gray-300  
active:scale-90  
duration-300
```
css
```css
/* hover:bg-gray-300 */
.element:hover {
  background-color: #d1d5db; /* Tailwind에서 bg-gray-300에 해당하는 색상 */
}

/* active:scale-90 */
.element:active {
  transform: scale(0.9);
}

/* duration-300은 transition 속성을 추가하며, 해당 값은 0.3초로 해석. */
.element {
  transition-duration: 0.3s;
  /*transition-property: background-color*/ /*해당 옵션만*/
}

```
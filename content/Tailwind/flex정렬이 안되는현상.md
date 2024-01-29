

```
display:flex; /* display flex로 설정 */
flex-direction: column; /* 위에서 아래로 정렬 (열) */ 
justify-content: center; /* flex-derction 방향 가운데 정렬*/ 
align-items:center; /* justify와 수직축 방향 가운데 정렬 */
```


테일윈드로 변환하면 다음과 같다.
```
<div class="flex flex-col justify-center items-center">
```



여기서 display 설정을 하지 않으면 flex-direction은 설정이 되지만 나머지는 적용이 안된다.
---
제목: react option selected
tags:
  - React
  - TroubleShooting
날짜: 2024-02-04
중요도: 중
---
# 날짜 : 2024-02-04  18:53

# 문제
```
Use the `defaultValue` or `value` props on <select> instead of setting `selected` on <option>.
```
option태그에 selected를 사용하게되면 뜨는에러, ui에는 문제가 없지만, console창에 에러가 뜨게된다.

# 해결

React에서는Option태그에 Selected대신  Select태그에 value라는 값을 지정해줘야한다.

# 코드
전
```javascript
<Select onChange={e => setSelectedYear(Number(e.target.value))}>  
    {years.map((year, index) => (<option key={index} value={year} selected={year==currYear}  
    >{year} </option>))}  
</Select> 

```
후
```javascript
<Select onChange={e => setSelectedYear(Number(e.target.value))} value={currYear}>  
    {years.map((year, index) => (<option key={index} value={year}  
    >{year} </option>))}  
</Select>
```

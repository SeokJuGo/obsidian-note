---
tags:
  - React
Date: 2024-02-03T16:40:00
---

의존성 배열은 useEffect 훅에 입력하는 두 번째 매개변수

**종속성 추적**
`useEffect` 내에서 사용된 상태나 변수가 변경될 때만 특정 작업을 수행하도록 하기 위해 사용된다.

**무한 루프 방지**
`useEffect` 내에서 상태를 변경하고 그 상태를 다시 읽을 때, 의존성 배열을 사용하여 해당 상태를 변경할 때만 `useEffect`가 다시 실행되도록 조절할 수 있다.

예시) 선택된 `Year`과 `Month`을 확인 후 `Day`를 반환

```javascript
import React, {useEffect, useState} from "react";
  
const Index = () => {  
const today = new Date();  
const year = `${today.getFullYear()}`  
const month = `${today.getMonth() + 1}`  
const day = `${today.getDate()}`;  
  
const [years, setYears] = useState<number[]>([]);  
const [months, setMonths] = useState<number[]>([]);  
const [days, setDays] = useState<number[]>([]);  
const [selectedYear, setSelectedYear] = useState("");  
const [selectedMonth, setSelectedMonth] = useState("");  
const [selectedDay, setSelectedDay] = useState("");  
const [endDay, setEndDay] = useState<number>(0);  
useEffect(() => {  
    // 현재 날짜 기준으로 최대 년도를 보여준다.  
    const newYears = [];  
    const newMonths = [];  
    for (let i = 2000; i <= parseInt(year); i++) newYears.push(i);  
    for (let i = 1; i <= 12; i++) newMonths.push(i);  
    setYears(newYears);  
    setMonths(newMonths);  
  
    // 선택된 년도와 월을 확인 후 최대 일을 반환  
    if (selectedYear !== "" && selectedMonth !== "") {  
        const lastDay = new Date(parseInt(selectedYear), parseInt(selectedMonth), 0).getDate();  
        setEndDay(lastDay);  
        const newDays = [];  
        for (let i = 1; i <= lastDay; i++) newDays.push(i);  
        setDays(newDays);  
    }  
}, [selectedYear, selectedMonth]);
    return (  
        <div>  
        <div className="flex justify-around">  
  
    <select onChange={e => setSelectedYear(e.target.value)}>  
        {years.map((year, index) => (<option key={index} value={year}  
        >{year} </option>))}  
    </select>  
    <select onChange={e=>setSelectedMonth(e.target.value)}>  
	        {months.map((month, index) => (<option key={index} value={month}>{month}</option>))}  
    </select>  
    <select onChange={e=>setSelectedDay(e.target.value)}>  
        {days.map((day, index) => (<option key={index} value={day}>{day}</option>))}  
    </select>  
</div>
                    </div>  
    );  
};  
  
export default Index;
```
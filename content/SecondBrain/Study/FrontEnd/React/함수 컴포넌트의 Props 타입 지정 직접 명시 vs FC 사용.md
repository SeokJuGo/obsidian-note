---
제목: not function 오류
tags:
  - React
날짜: 2024-02-09
중요도: 상
---
# 날짜 : 2024-02-09  17:56


# 문제

아래의 코드를  아래와 같이 자식으로 props를 넘겨주려고 했다.
```javascript
const refreshDiary = () => {  
    fetchDiary(Number(user.userId))  
        .then((data) => {  
            setDiaryList(data);  
        });  
}

...

  
    <CalendarComponent events={events} refreshDiary={refreshDiary}  />
```

```javascript

const CalendarComponent = ({ events:any, refreshDiary:()=>void }) => {
}
refreshDiary() // 이 부분
```

`TypeError: refreshDiary is not a function`

refreshDiary()라는 함수를 보냈지만 함수가 아니라고 나왔다..?

문제를 도저히 찾을 수 없었고, 여러 방법으로 시도했는데

React.FC를 제네릭하면 정상적으로 동작하는 걸 알 수 있었다.

이유는 알 수 없는데 Fucntion Component를 명시적으로 사용하라는건가싶다..

# 코드
```javascript
import React from 'react';

interface DateProps {
    date: string;
    onClick: () => void;
}

const MyComponent = ({ date, onClick }: DateProps) => {
    return <div onClick={onClick}>{date}</div>;
}


```

```javascript
import React from 'react';

interface DateProps {
    date: string;
    onClick: () => void;
}

const MyComponent: React.FC<DateProps> = ({ date, onClick }) => {
    return <div onClick={onClick}>{date}</div>;
}

```
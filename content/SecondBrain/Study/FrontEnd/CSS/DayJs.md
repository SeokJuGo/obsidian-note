---
title: DayJs
tags:
  - CSS
date: 2024-02-22
중요도: 하
---
# 날짜  2024-02-22 11:17

# 메모

npm i dayjs

 트위터처럼 몇 분 전 몇 시간 전을 간단히 표현해주는 라이브러리
 plugin 방식으로 필요한 함수는 extend해줘야 한다.
  `페이지 별로 locale extend를 해줘야한다.`
# 코드
```javascript
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relatvieTime'


dayjs.locale('ko')
dayjs.extend(relativetime)
...


dayjs(시간).fromNow(true)

```
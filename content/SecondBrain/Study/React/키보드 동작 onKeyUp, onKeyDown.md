---
제목: 키보드 동작
tags:
  - React
  - JavaScript
날짜: 2024-02-13
중요도: 하
---
# 날짜  : 2024-02-13  19:45


# 메모
키보드 동작이 실행되었을 때 명령어 onKeyPress는 더이상 지원되지않는다고 하니, 가능하면 `onKeyUp`을 사용

# 코드
```javascript
const handleOnClick = () => {
  navigate('/main');
};
// 버튼에 적용할 클릭 이벤트 함수


const handleOnKeyUp = e => {
  if (e.key === 'Enter') {
    handleOnClick(); // Enter 입력이 되면 클릭 이벤트 실행
  }
};
```


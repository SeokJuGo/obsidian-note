---
title: useMemo
tags:
  - React
date: 2024-02-19
중요도: 상
---
# 날짜  2024-02-19

# 메모
React에서 성능 최적화는 중요하다.
`useMemo`는 React 훅 중 하나로, 이전 결과를 기억하고 해당 결과가 변경되지 않았을 때 이를 재사용하는 메모이제이션 기능을 제공 이는 특히 계산 비용이 높은 함수의 결과를 캐싱하여 성능을 향상시킬 때 유용하다.
# 코드
https://stackblitz.com/edit/vitejs-vite-hjbydf?file=src%2FApp.tsx
```jsx
import { useState } from "react";
 
const hardCalculate = (number) => {
  console.log("어려운 계산!");
  for (let i = 0; i < 99999999; i++) {} // 생각하는 시간
  return number + 10000;
};

const easyCalculate = (number) => {
  console.log("쉬운 계산!");
  return number + 1;
};

function App() {
  const [hardNumber, setHardNumber] = useState(1);
  const [easyNumber, setEasyNumber] = useState(1);

  const hardSum = hardCalculate(hardNumber);
  const easySum = easyCalculate(easyNumber);

  return (
    <div>
      <h3>어려운 계산기</h3>
      <input
        type="number"
        value={hardNumber}
        onChange={(e) => setHardNumber(parseInt(e.target.value))}
      />
      <span> + 10000 = {hardSum}</span>
      
      
      <h3>쉬운 계산기</h3>
      <input
        type="number"
        value={easyNumber}
        onChange={(e) => setEasyNumber(parseInt(e.target.value))}
      />
      <span> + 1 = {easySum}</span>
    </div>
  );
}

export default App;
```
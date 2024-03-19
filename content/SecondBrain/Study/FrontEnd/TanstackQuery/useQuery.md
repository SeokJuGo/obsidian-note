---
title: useQuery
tags:
  - TanstackQuery
date: 2024-03-15
중요도: 중
---
# 날짜  2024-03-15 12:53

# 메모

서버 데이터 fetch 해오기 - `useQuery`

해당 컴포넌트 내에서만 사용할 수 있다.

CSR에서 사용


https://tanstack.com/query/latest/docs/framework/react/reference/useQuery
# 코드
```tsx
useQuery({queryKey:['participant'],queryFn:Promise.resolve})
```
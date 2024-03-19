---
title: 
tags: 
date: 
중요도:
---
# 날짜  2024-03-15 12:55

# 메모

`useQuery`가 해당 컴포넌트만 사용한다면,

`queryClient`와 `dehydrate`를 사용하면 자식 컴포넌트 내부에서 사용 할 수 있다.

SSR에서 사용
# 코드
```tsx
const queryClient = new QueryClient();  
await queryClient.prefetchQuery({queryKey: ['account'], queryFn: getAccount})  
const dehydratedState = dehydrate(queryClient);


return(<HydrationBoundary state={dehydratedState}>  
    {children}  
</HydrationBoundary>)
```
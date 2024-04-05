---
title: CacheTime
tags:
  - TanstackQuery
date: 2024-04-05
중요도: 중
---
# 날짜  2024-04-05 16:43

# 메모
`staleTime` 매개변수는 데이터가 "stale"으로 간주되기 전까지의 시간을 설정하고. 반면에, `cacheTime`은 캐시에서 데이터가 비활성 상태(inactive)로 남아있을 수 있는 최대 시간을 설정한다. 즉, `cacheTime`을 늘리고 싶다면, gcTime을 설정해야한다.

# 코드
```javascript
    const queryClient = new QueryClient({
        defaultOptions: {
            queries: {
                gcTime: 1000 * 60 * 60, // 
            },
        },
    });
```
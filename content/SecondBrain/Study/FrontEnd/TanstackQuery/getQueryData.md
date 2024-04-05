---
title: useQueryClient
tags:
  - TanstackQuery
date: 2024-03-13
중요도: 중
---
# 날짜  2024-03-13 16:26

# 메모

`const { data: qr, isLoading, error } = useQuery({queryKey: ['QR',payId], queryFn: getQRCode}) ;`
queryClient.getQueryData는 `기존 쿼리의 캐시된 데이터를 가져오는 데 사용할 수 있는 동기 함수` 쿼리가 존재하지 않으면 `undefined`를 반환한다.


새로운 객체를 생성하는게 아니라면 CSR에서 사용하여야한다.
# 코드
```tsx
const queryClient = useQueryClient();  
const post = queryClient.getQueryData(["meetId","1"]);
```
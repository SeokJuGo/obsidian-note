---
title: SSR 파라미터 호출
tags:
  - Next
date: 2024-03-13
중요도: 중
---
# 날짜  2024-03-13 14:16

# 메모

클라이언트 상태에서 URL파라미터를 불러오는 방법은
useSelectedLayoutSegment(), useSelectedLayoutSegments(), useParams() 가 있는데,
CSR에서만 사용가능하다.

Next에서는 폴더명에 대괄호를 붙여서 동적인 페이지를 만드는데, 대괄호를 붙힌 naming에 맞추어서  page 파라미터에 넣어주면 된다.

리턴값은 항상 string타입이다.
# 코드
[meetId]/page.tsx
```tsx
type Props = {  
    params: { meetId: string },  
}  
export default async function Page({params}: Props){  
    const {meetId} = params;
    }
```
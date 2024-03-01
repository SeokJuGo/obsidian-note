---
title: middleware
tags:
  - Authjs
date: 2024-03-01
중요도: 상
---
# 날짜  2024-03-01 14:31

# 메모

- 라우트 역할 ⇒ 공통적으로 로그인을 해야지만 접근이 가능한 페이지
# 코드
```tsx
import { auth } from "./auth"  
import {NextResponse} from "next/server";  
  
export async function middleware() {  
  const session = await auth();  
  if (!session) {  
    return NextResponse.redirect('http://localhost:3000');  
  }  
}  
  
// 이곳은 로그인 해야지만 들어갈 수 있다
export const config = {  
  matcher: [/home'],  
}
```
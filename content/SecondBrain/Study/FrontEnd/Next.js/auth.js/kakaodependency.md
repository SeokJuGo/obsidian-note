---
title: kakao dependency
tags:
  - Authjs
date: 2024-03-04
중요도: 중
---
# 날짜  2024-03-06 22:46

# 메모
- auth.js 카카오 인증 dependency
- ***JavascriptKey*** = clientId
- ***AppId*** = clientSecret
- ***redirect URI***: domain/api/auth/callback/kakao
# 코드
```tsx
import KakaoProvider from "next-auth/providers/kakao";

providers: [
  KakaoProvider({
    clientId: process.env.KAKAO_CLIENT_ID,
    clientSecret: process.env.KAKAO_CLIENT_SECRET
  })
]
```

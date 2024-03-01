---
title: Auth.js
tags:
  - Next
  - Authjs
date: 2024-03-01
중요도: 상
---
# 날짜  2024-03-01 14:22

# 메모

#### auth.js (구 nextauth)
- provider로 다양한 로그인방법을 지원한다.
- 기본로그인 credentials provider

#### 동적 라우팅(catch all routing)
- 경로의 현재 상태에 따라 경로를 자동 조정해주는 역할

`npm i next-auth@beta @auth/core`
# 코드


/src/auth.ts
```tsx
import NextAuth from "next-auth"  
import CredentialsProvider from "next-auth/providers/credentials";  
  
  
export const {  
  handlers: { GET, POST },  
  auth,  
  signIn,  
} = NextAuth({  
  pages: {  
    signIn: '/login',  
    newUser: '/signup',  
  },  
  providers: [  
    CredentialsProvider({  
      async authorize(credentials) {  
        const authResponse = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}/api/login`, {  
          method: "POST",  
          headers: {  
            "Content-Type": "application/json",  
          },  
          body: JSON.stringify({  
            id: credentials.username,  
            password: credentials.password,  
          }),  
        })  
  
        if (!authResponse.ok) {  
          return null  
        }  
  
        const user = await authResponse.json()  
        console.log('user', user);  
        return {  
          email: user.id,  
          name: user.nickname,  
          image: user.image,  
          ...user,  
        }  
      },  
    }),  
  ]  
});
```

#### catch all route

/src/app/api/auth/[...nextauth]/route.ts

```tsx
export { GET, POST } from '@/auth';
```
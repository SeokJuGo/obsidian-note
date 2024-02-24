---
title: next-auth
tags:
  - Next
date: 2024-02-24
중요도: 상
---
# 날짜  2024-02-24 13:29

# 메모

next-auth에서 지원하는 로그인 등
![[Pasted image 20240224133235.png]]
- 쿠키 로그인 등 지원한다.
`npm i next-auth@5 @auth/core`
# 코드
middleware.ts
```ts
// 내가 로그인했는지 안했는 지 알 수있는 곳
import { auth } from "./auth"
import {NextResponse} from "next/server";

export async function middleware() {
  const session = await auth();
  if (!session) {
    return NextResponse.redirect('http://localhost:3000/i/flow/login');
  }
}
export const config = {
// 미들웨어를 적용할 라우트들,  로그인을 해야지만 접속 할 수 있는 라우트
//matcher: ['/compose/tweet', '/home', 'explore', 'message', '/search] 
}
```

auth.ts
```ts
import NextAuth from "next-auth"
import CredentialsProvider from "next-auth/providers/credentials";
import { cookies } from 'next/headers'
import cookie from 'cookie';

export const {
  handlers: { GET, POST },
  auth,
  signIn,
} = NextAuth({
  pages: {
    signIn: '/i/flow/login',
    newUser: '/i/flow/signup',
  },
  callbacks: {
    jwt({ token}) {
      console.log('auth.ts jwt', token);
      return token;
    },
    session({ session, newSession, user}) {
      console.log('auth.ts session', session, newSession, user);
      return session;
    }
  },
  events: {
    signOut(data) {
      console.log('auth.ts events signout', 'session' in data && data.session, 'token' in data && data.token);
      // if ('session' in data) {
      //   data.session = null;
      // }
      // if ('token' in data) {
      //   data.token = null;
      // }
    },
    session(data) {
      console.log('auth.ts events session', 'session' in data && data.session, 'token' in data && data.token);
    }
  },
  providers: [
    CredentialsProvider({
      async authorize(credentials) {
        const authResponse = await fetch(`${process.env.AUTH_URL}/api/login`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            id: credentials.username,
            password: credentials.password,
          }),
        })
        let setCookie = authResponse.headers.get('Set-Cookie');
        console.log('set-cookie', setCookie);
        if (setCookie) {
          const parsed = cookie.parse(setCookie);
          cookies().set('connect.sid', parsed['connect.sid'], parsed); // 브라우저에 쿠키를 심어주는 것
        }
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
.env
```
AUTH_SECRET=hello
```
/api/auth/[...nextauth]/route.ts
```
export function GET(){
	

}

export fundtion POST(){
	
}
```

login.tsx
```jsx
    try {
      await signIn("credentials", {
        username: id,
        password,
        redirect: false,
      })
      router.replace('/home');
    } catch (err) {
      console.error(err);
      setMessage('아이디와 비밀번호가 일치하지 않습니다.');
    }
```
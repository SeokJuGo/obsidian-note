---
title: authjs tsx
tags:
  - Authjs
date: 2024-03-04
중요도: 중
---
# 날짜  2024-03-04 10:46

# 메모
- auth js `signOut` 함수는 로그아웃을 처리하는 함수

`auth.ts` 파일은 서버 측 코드이다 클라이언트의 리다이렉트는 해당 파일에서 처리되지 않아야 한다. 대신, 클라이언트의 리다이렉트는 클라이언트 측에서 처리되어야 한다.
# 코드
```tsx
"use client"  
import {useRouter} from "next/navigation";
const onLogout = () => {  
    signOut({ redirect: false })  
        .then(() => {  
            router.replace('/');  
        });  
};
```
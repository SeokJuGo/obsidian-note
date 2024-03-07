---
title: TanstackQuery
tags: 
date: 
중요도:
---
# 날짜  2024-02-27 13:59

# 메모
npm i @tanstack/react-query@5 -S
npm i @tanstack/react-query-devtools@5 -D


- React Query는 React 데이터를 관리하기 위한 라이브러리 주로 서버에서 데이터를 가져오는 작업, 캐싱, 데이터 업데이트 상태를 관리하는데 사용된다.

> 클라이언트 측에서 상태를 관리하는 데에는 Zustand와 같은 라이브러리를 사용하고, 서버 측에서 데이터를 관리하고 제공하는 데에는 React Query와 같은 라이브러리를 사용한다.
# 코드

RQProvider.tsx
```javascript
"use client";  
  
import React, {useState} from "react";  
import {QueryClientProvider, QueryClient} from "@tanstack/react-query";  
import {ReactQueryDevtools} from "@tanstack/react-query-devtools";  
  
type Props = {  
    children: React.ReactNode;  
};  
  
function RQProvider({children}: Props) {  
    const [client] = useState(  
        new QueryClient({  
            defaultOptions: {  // react-query 전역 설정  
                queries: {  
                    refetchOnWindowFocus: false,  
                    retryOnMount: true,  
                    refetchOnReconnect: false,  
                    retry: false,  
                },  
            },  
        })  
    );  
  
    return (  
        <QueryClientProvider client={client}>  
            {children}  
            <ReactQueryDevtools initialIsOpen={process.env.NEXT_PUBLIC_MODE === 'local' }/>  
        </QueryClientProvider>    );  
}  
  
export default RQProvider;
```
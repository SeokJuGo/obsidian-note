---
title: Intersection Observer
tags:
  - React
date: 2024-03-22
중요도: 중
---
# 날짜  2024-03-22 15:33

# 메모

React 애플리케이션에서 사용자가 스크롤하여 화면에 특정 요소가 나타날 때를 감지하고 싶은 경우가 예를 들어, 사용자가 특정 섹션으로 스크롤할 때 추가적인 애니메이션을 적용하거나 데이터를 불러오는 등의 동작을 수행 할 때 이를 위해 `Intersection Observer API`를 사용할 수 있다.

## Intersection Observer란?
`Intersection Observer`는 브라우저가 요소의 가시성에 대한 변경 사항을 감지할 수 있게 해주는 API 이를 사용하여 요소가 화면에 나타나는지 여부를 감지할 수 있다.
# 코드
1. 태그 감지 (IntersectionObserver)
https://stackblitz.com/edit/vitejs-vite-jfidw9?file=src%2FApp.tsx

2. 현재 스크롤 감지 ( window.pageYOffset)
https://stackblitz.com/edit/vitejs-vite-ndvt5p?file=src%2FApp.tsx
```tsx
'use client'  
import { useEffect, useRef } from "react";  
  
export default function MyPage() {  
    // 각 div 요소들의 참조를 저장하기 위한 배열을 생성합니다.  
    const div1Ref = useRef<HTMLDivElement>(null);  
    const div2Ref = useRef<HTMLDivElement>(null);  
    const div3Ref = useRef<HTMLDivElement>(null);  
  
    useEffect(() => {  
        const observer = new IntersectionObserver(  
            (entries) => {  
                entries.forEach((entry) => {  
                    if (entry.isIntersecting) {  
                        // 요소가 화면에 나타나면 해당 요소의 클래스 이름을 출력합니다.  
                        console.log(`${entry.target.className}가 화면에 보입니다.`);  
                    }  
                });  
            },  
            {  
                root: null, // 뷰포트를 기준으로 합니다.  
                rootMargin: '0px',  
                threshold: 0.1, // 타겟의 10%가 보일 때 콜백을 실행합니다.  
            }  
        );  
  
        // 각 div 요소들을 관찰합니다.  
        if (div1Ref.current) observer.observe(div1Ref.current);  
        if (div2Ref.current) observer.observe(div2Ref.current);  
        if (div3Ref.current) observer.observe(div3Ref.current);  
  
        // 컴포넌트가 언마운트될 때 observer를 정리합니다.  
        return () => {  
            if (div1Ref.current) observer.unobserve(div1Ref.current);  
            if (div2Ref.current) observer.unobserve(div2Ref.current);  
            if (div3Ref.current) observer.unobserve(div3Ref.current);  
        };  
    }, []);  
  
    return (  
        <div>  
            <div style={{ height: '100vh' }}>  
                <p>스크롤해서 아래 div들을 확인해보세요.</p>  
            </div>            {/* div 요소들에 ref를 설정하여 참조를 저장합니다. */}  
            <div  
                className="div1"  
                ref={div1Ref}  
                style={{ height: '100vh', backgroundColor: 'lightblue' }}  
            >  
                Div 1  
            </div>  
            <div                className="div2"  
                ref={div2Ref}  
                style={{ height: '100vh', backgroundColor: 'lightgreen' }}  
            >  
                Div 2  
            </div>  
            <div                className="div3"  
                ref={div3Ref}  
                style={{ height: '100vh', backgroundColor: 'lightcoral' }}  
            >  
                Div 3  
            </div>  
        </div>    );  
};
```
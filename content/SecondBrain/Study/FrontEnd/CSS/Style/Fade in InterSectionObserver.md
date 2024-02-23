---
title: fade in
tags:
  - CSS
date: 2024-02-23
중요도: 하
---
# 날짜  2024-02-23 10:53

# 메모

스크롤을 내리면 fade in되도록 하는 기능
https://stackblitz.com/edit/vitejs-vite-9c7mpx?file=src%2FApp.css
# 코드
```jsx
import React, { useEffect, useRef } from 'react';

import './App.css';

  

const ContentComponent: React.FC = () => {

  const contentsRef = useRef<HTMLDivElement>(null);

  

  useEffect(() => {

    const callback: IntersectionObserverCallback = (entries, observer) => {

      entries.forEach((entry) => {

        if (entry.isIntersecting) {

          const contents = entry.target.querySelectorAll('.content');

          contents.forEach((content) => content.classList.add('first-in'));

  

          observer.unobserve(entry.target);

        }

      });

    };

    const observer = new IntersectionObserver(callback);

    if (contentsRef.current) {

      observer.observe(contentsRef.current);

    }

  

    return () => {

      if (contentsRef.current) {

        observer.unobserve(contentsRef.current);

      }

    };

  }, []);

  

  return (

    <div className="container">

      <div className="scroll">👇</div>

  

      <div className="" style={{ height: '1000px' }}></div>

      <div ref={contentsRef} className="contents">

        <div className="content">One</div>

        <div className="content">Two</div>

        <div className="content">Three</div>

        <div className="content">Four</div>

      </div>

    </div>

  );

};

  

export default ContentComponent;
```

css
```css
* {

  box-sizing: border-box;

  margin: 0;

  padding: 0;

}

  

.scroll {

  font-size: 40px;

  text-align: center;

  height: 200px;

  line-height: 200px;

  animation: bounce 2s ease infinite;

  margin-bottom: 200px;

}

  

@keyframes bounce {

  70% {

    transform: translateY(0%);

  }

  80% {

    transform: translateY(-15%);

  }

  90% {

    transform: translateY(0%);

  }

  95% {

    transform: translateY(-7%);

  }

  97% {

    transform: translateY(0%);

  }

  99% {

    transform: translateY(-3%);

  }

  100% {

    transform: translateY(0);

  }

}

  

.contents {

  margin: 0 auto 50px auto;

  width: 400px;

  height: 400px;

  line-height: 100%;

  font-size: 30px;

  font-weight: bold;

  color: #555;

  display: grid;

  grid-template-columns: 1fr 1fr;

  grid-template-rows: 1fr 1fr;

  text-align: center;

}

  

.content {

  line-height: 200px;

  opacity: 0;

  transform: translateY(50px);

}

  

.first-in {

  opacity: 1;

  transform: translateY(0);

  transition: all 1s 0.5s ease;

}

  

.second-in {

  opacity: 1;

  transform: translateY(0);

  transition: all 1s 1.2s ease;

}
```
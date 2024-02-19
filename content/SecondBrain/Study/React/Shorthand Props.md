---
title: Shorthand Props
tags:
  - React
date: 2024-02-19
중요도: 중
---
# 날짜  2024-02-19

# 메모
같은 Props를 자식에게 보내야 할 때가 있을 때 요소들을 일일이 입력하지 않는 방법이다.  

# 코드
```jsx
function Shorthand Props (isDarkMode,isLogin,...props): Element {
return (
<header>
	className="clean-header"
	title="Clean Code React"
	isDarkMode={isDarkMode}
	isLogin={isLogin}
	hasPadding={true}
	isFixed={true}
	isAdmin={true}
<ChildComponent {...props} />
</header>
		```
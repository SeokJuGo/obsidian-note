---
title: SSR CSR 동시 사용
tags:
  - Next
date: 2024-02-23
중요도: 상
---
# 날짜  2024-02-23 15:48

# 메모
Next.js에서 CSR방식에서  SSR방식을 import하여 같이 사용하게 SSR이 CSR로 성격이 바뀌게 된다.

같이 사용하려면 Props로 children을 넘겨주어서 같이 사용해야한다.

# 코드
```jsx
Post.jsx
return(
	<PostArticle post={target}>
)
```

```jsx
PostArticle.jsx

type Props{
	children: ReactNode,
	post:{
	...
	}
}
export default function PostArticle({children,post}:Props){


return(
	<div>
		{children}
	</div>
)
}
```
---
title: next svg파일 사용하기
tags:
  - Next
date: 2024-03-08
중요도: 중
---
# 날짜  2024-03-08 16:56

# 메모

npm install @svgr/webpack

- next.js에서는 svg파일을 사용하려면 간단한 설정이 필요함.!
# 코드
```js
module.exports = {
	webpack: (config) => {
		// 기존 URL 파일로더 규칙을 가져옵니다.
		const fileLoaderRule = config.module.rules.find((rule) => rule.test?.test?.('.svg'));
	
		
	  config.module.rules.push(
	    {
	      ...fileLoaderRule,
	      test: /\.svg$/i,
	      resourceQuery: { not: /components/ },
	    },
	    {
	      test: /\.svg$/i,
	      issuer: /\.[jt]sx?$/,
	      resourceQuery: /components/,
	      use: ['@svgr/webpack'],
	    }
	  );
	  return config;
	}
}

```

```tsx
<Image src={inRoom} width={24} height={24} alt='button'/>
```
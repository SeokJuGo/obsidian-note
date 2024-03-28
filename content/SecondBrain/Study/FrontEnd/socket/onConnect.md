---
title: onConnect
tags:
  - Socket
date: 2024-03-28
중요도: 중
---
# 날짜  2024-03-28 21:58

# 메모
# onConnect 콜백 

구독 시에 자동으로 init되는 함수를 만들고 싶었으며, client가 연결됐는지는 확인 할 수 있지만 특정 구독 상태를 확인하는 방법은 없었다. 그래서 `onConnect` 함수를 이용하기로 했다.

`onConnect` 콜백은 Stomp 클라이언트가  서버에 연결되었을 때 호출되며 이 콜백을 사용하여 클라이언트가 연결될 때 필요한 동작을 정의할 수 있다.

# 코드
```ts
  clientdata.onConnect = function () {  
    // 구독 판별 함수
	set((state) => ({ ...state, initiating: true }));  
	
	// 구독 콜백 함수 (이미 구독이 되어있는 상태)
	clientdata.subscribe(`/api/sub/${payId}`, (message: any) => {  
	  const res = JSON.parse(message.body);  
	  set((state) => ({ ...state, res }));  
	});
},
```
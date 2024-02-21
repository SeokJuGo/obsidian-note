---
제목: Arrays.from
tags:
  - JavaScript
날짜: 2024-02-06
중요도: 중
---
# 날짜 : 2024-02-06  11:49


# 메모
`Array.from`  유사 배열 객체를 배열로 바꾸는데 사용
타입스크립트에서 interface를 만드는 과정에서 Arrays배열을 사용할 때 사용

# 코드
```javascript
const [imgFiles, setImgFiles] = useState<File[]>([]);
	// 사용 예 imgFiles.forEach (x)
	Arrays.from(imgFiles).forEach(()=>{

});
```
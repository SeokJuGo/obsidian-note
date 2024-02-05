---
제목: Axios 에러처리
tags:
  - JavaScript
  - Axios
날짜: 2024-02-05
중요도: 중
---
# 날짜 : 2024-02-05  10:26


# 메모
백엔드에게 요청을 보내면서 Axios 오류가 났을 때 어떤 부분인지 알아야 시간 단축에 도움이 되는데,
짧은 코드보단  API를 가능한 구체적으로 작성하면 좋다.


# 코드

then catch를 사용한 경우
```javascript
export const createDiary = async (data: DiaryWriteRequestProps) => {  
    await axios.post('/diary', data).  
    then((response)=>console.log(response.data)).  
    catch((error)=>console.log(error.response.data.message))  
};
```

try catch를 사용한 경우
```javascript
try {  
    const res = await axios.patch(`/diary/${data.diaryId}`, data);  
} catch (err:any) {  
    console.log('Register err : ', err.response);  
    const statusCode = err.response.status; // 400  
    const statusText = err.response.statusText; // Bad Request  
    const message = err.response.data.message[0]; // id should not be empty  
    console.log(`${statusCode} - ${statusText} - ${message}`);  
}
```
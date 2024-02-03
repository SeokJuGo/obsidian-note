---
tags:
  - Axios
---

## 문제
받아온 객체를 그대로 전달
`PATCH http://localhost:8080/diary/16 400 (Bad Request)`에러가 났다.
```javascript
const handleEventDrop = (info: any) => {  
    const diary: DiaryWriteRequestProps = {  
        diaryId: startProps.diaryId,  
        content: startProps.content,  
        emoji: startProps.emoji,  
        createdDate: startProps.createdDate,  
        photoList: startProps.photoList.filter((prop) => prop === "path"),  
        emoticonRequest: {  
            emotionList: startProps.emotionList,  
            familyList: startProps.familyList,  
            healthList: startProps.healthList,  
            peopleList: startProps.peopleList,  
            weatherList: startProps.weatherList,  
        },  
    };
```

Diary안에 emotionRequest라는 객체를 넣으려고했다.
```javascript
            emotionList: startProps.emotionList,  
            familyList: startProps.familyList,  
            healthList: startProps.healthList,  
            peopleList: startProps.peopleList,  
            weatherList: startProps.weatherList,  
```
이 부분이 문제였는데. emotionList{["emotionId":1,"emotion":"Joy",...]}
이런형식으로 되어있었다.

하지만 백엔드 Patch부분에서는 아래와 같이 들어가야한다.
```json
{
  "diaryId": 16,
  "content": "string",
  "emoji": 0,
  "createdDate": "2024-02-02T03:06:49",
  "photoList": [
    "string"
  ],
  "emoticonRequest": {
    "emotionList": [
      "Joy"
    ],
    "familyList": [
      "Harmony"
    ],
    "healthList": [
      "Healthy"
    ],
    "peopleList": [
      "Family"
    ],
    "weatherList": [
      "Clear"
    ]
    
  }
}
```

## 바뀐코드
```JAVASCRIPT
emoticonRequest: {  
    emotionList: startProps.emotionList.map((object:any) => object.emotion),  
    familyList: startProps.familyList.map((object:any) => object.family),  
    healthList: startProps.healthList.map((object:any) => object.health),  
    peopleList: startProps.peopleList.map((object:any) => object.people),  
    weatherList: startProps.weatherList.map((object:any) => object.weather),  
},
```
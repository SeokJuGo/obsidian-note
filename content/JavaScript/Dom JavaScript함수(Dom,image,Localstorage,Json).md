
# DOM  JavaScript함수

## 목차

[1. Dom](#1-dom)

[2. 이미지](#2-이미지)

[3. LocalStorage](#3-localstorage)

[4. Json](#4-json)

## 1. Dom

|              함수 또는 메서드               |                     설명                      |
| :-----------------------------------------: | :-------------------------------------------: |
|      `document.createElement(tagName)`      |          새 HTML 요소를 생성합니다.           |
|       `document.createTextNode(text)`       |           텍스트 노드를 생성합니다.           |
|     `parentNode.appendChild(childNode)`     |      부모 노드에 자식 노드를 추가합니다.      |
|     `parentNode.removeChild(childNode)`     |     부모 노드에서 자식 노드를 제거합니다.     |
|        `node.appendChild(childNode)`        |        노드에 자식 노드를 추가합니다.         |
|        `node.removeChild(childNode)`        |       노드에서 자식 노드를 제거합니다.        |
|              `node.innerHTML`               |   노드의 HTML 내용을 가져오거나 설정합니다.   |
|             `node.textContent`              |  노드의 텍스트 내용을 가져오거나 설정합니다.  |
|       `node.querySelector(selector)`        | 선택자에 맞는 첫 번째 자식 요소를 반환합니다. |
|      `node.querySelectorAll(selector)`      |  선택자에 맞는 모든 자식 요소를 반환합니다.   |
|  `node.addEventListener(event, callback)`   |          이벤트 리스너를 등록합니다.          |
| `node.removeEventListener(event, callback)` |          이벤트 리스너를 제거합니다.          |

## 2. 이미지

|              JavaScript 코드               |                            설명                             |
| :----------------------------------------: | :---------------------------------------------------------: |
|     `document.createElement(tagName)`      |                 새 HTML 요소를 생성합니다.                  |
|  `element.setAttribute(attribute, value)`  |             HTML 요소의 속성과 값을 설정합니다.             |
| `element.setAttribute("src", "image.jpg")` | 이미지 요소의 src 속성을 설정하여 이미지 경로를 지정합니다. |
|    `element.setAttribute("width", 150)`    |              이미지 요소의 너비를 설정합니다.               |



## 3. LocalStorage

| 함수 또는 메서드                     | 설명                                                  |
| ------------------------------------ | ----------------------------------------------------- |
| `localStorage.setItem(key, value)`   | 로컬 스토리지에 특정 키와 값을 저장합니다.            |
| `localStorage.getItem(key)`          | 로컬 스토리지에서 특정 키에 해당하는 값을 가져옵니다. |
| `localStorage.removeItem(key)`       | 로컬 스토리지에서 특정 키와 해당 값을 제거합니다.     |
| `localStorage.clear()`               | 로컬 스토리지의 모든 데이터를 제거합니다.             |
| `sessionStorage.setItem(key, value)` | 세션 스토리지에 특정 키와 값을 저장합니다.            |
| `sessionStorage.getItem(key)`        | 세션 스토리지에서 특정 키에 해당하는 값을 가져옵니다. |
| `sessionStorage.removeItem(key)`     | 세션 스토리지에서 특정 키와 해당 값을 제거합니다.     |
| `sessionStorage.clear()`             | 세션 스토리지의 모든 데이터를 제거합니다.             |



## 4. Json

| 함수 또는 메서드             | 설명                                                 |
| ---------------------------- | ---------------------------------------------------- |
| `JSON.parse(jsonString)`     | JSON 형식의 문자열을 JavaScript 객체로 파싱합니다.   |
| `JSON.stringify(jsonObject)` | JavaScript 객체를 JSON 형식의 문자열로 직렬화합니다. |

---
제목: Modal Style
tags:
  - CSS
  - Modal
날짜: 2024-02-09
중요도: 하
---
# 날짜  : 2024-02-09  15:40


# 메모
모달 ui 라이브러리를 자주 사용하다보니 내가 꾸미고 싶은대로 하기가 어려워지고,
바닐라js로 되어있어 사용하기 불편함..

- 간단한 정 가운데에 나오는 예 아니오 모달창
# 코드

```html
 <div className="flex justify-center items-center">  
    {/* 배경 */}  
    <div className="fixed top-0 left-0 w-full h-full bg-black opacity-50 z-10"></div>  
    {/* 내용 */}  
    <div className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 z-20">  
        <div className="bg-white p-8 rounded-lg shadow-lg">  
            <p className="text-gray-700 font-bold">내용</p>  
            <br/>            <hr/>            <div className="flex justify-between">  
                <button className="btn w-[40%]"}>취소</button>  
                <button className="btn bg-red-300 w-[40%]">삭제</button>  
            </div>        </div>    </div></div>
```
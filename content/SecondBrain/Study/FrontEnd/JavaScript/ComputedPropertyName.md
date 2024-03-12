---
title: ComputedPropertyName
tags:
  - JavaScript
date: 2024-03-12
중요도: 상
---
# 날짜  2024-03-12 12:52

# 메모
- Object Key를 변수값으로 넘기는방법
- 객체의 key값을 표현식(변수, 함수 등)을 통해 지정하는 문법

# 코드
```javascript
const handleCheck = (memberId: number, type:"payAgree"|"isDrinkAlcohol") => {  
    const updatedMembers = selectMembers.map(member =>  
        member.memberId === memberId ? { ...member, [type]: !member[type] } : member  
    );  
    setFilterMembers(updatedMembers);  
    setSelectMembers(updatedMembers);  
};
```
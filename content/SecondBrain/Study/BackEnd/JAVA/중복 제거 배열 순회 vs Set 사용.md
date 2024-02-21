---
제목: 중복값 제거
tags:
  - JavaScript
날짜: 2024-02-13
중요도: 하
---
# 날짜  : 2024-02-13  22:10


# 메모

1. 배열 순회 방식: O(n^2)
    
    - 배열을 순회하면서 각 요소를 확인하여 중복을 제거하는 방법
2. `Set` 사용 방식: O(n)
    - `Set`은 유일한 값을 저장하는 컬렉션으로, 내부적으로 해시 테이블을 사용하여 중복을 제거 성능적으로 뛰어나다.
# 코드
```javascript
doctorList.forEach((doctor: DoctorProfileProps) => {
    if (!departments.includes(doctor.department)) {
        setDepartments((prevState) => [...prevState, doctor.department]);
    }
});

```
```javascript
const uniqueDepartments:Set<string> = new Set(doctorList.map((doctor: DoctorProfileProps) => doctor.department));  
setDepartments(Array.from(uniqueDepartments));
```

## 목차

[1.Collection](#1-collection)

​	[1) ArrayList](#1-list)

​	[2) LinkedList](#2-linkedlist)

​	[3) 정렬](#3-정렬)

# #1 Collection

![image](https://github.com/SeokJuGo/SeokJuGo/assets/116260619/c2710d3b-2a54-4a6a-840c-4f253d373c85)

- List, Set, Map -> 3대 인터페이스

1) List

- 순서가 있다.

- 중복을 허락한다.

- add(index,) 값이있다면 인덱스가 밀린다.

  

```
List<Integer> lis = new ArrayList<Integer>();
for (int i = 0; i<=lis.size(); i++){
	if(lis.indexOf(i)%2 == 0) lis.remove(i); //1 ?
}
```

2) Set

- 순서가 없다 (출력도 넣은순서가 아님)
- 중복이 없다.
- hashSet사용 -put



3) Map

- key-value
- key만 중복불가
- Entry<T,T> 
- put(index)  값이 있다면 인덱스가 수정된다.

## 1) ArrayList

- 크기가 유동적 <-> 배열
- 순차적 데이터 <-> 배열

|     주요 메소드      |           설명           |
| :------------------: | :----------------------: |
|    add((idx),val)    |    맨 뒤 인덱스 추가     |
|       get(idx)       |  해당 인덱스의 값 반환   |
|     set(idx,val)     |     인덱스로 값 변환     |
|    contains(val)     | 값이 배열에 있는지 true  |
| remove(idx or value) |  인덱스 or 값의 첫번째   |
|       toArray        | 일반 배열 타입 변환 리턴 |
|       isEmpty        |      비었으면 true       |
|         size         |      요소 개수 반환      |



## 2) LinkedList

- 비순차데이터 검색 유용하다.

## 3) 정렬

- Comparable - 클래스 내부에서 구현
- Comparator - 구현부에서 sort(객체들, Comparator 1)디폴트 클래스 호출 또는 2)디폴트 메소드)






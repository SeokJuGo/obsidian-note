# CSS 선택자와 Flexbox

## 목차
[1. 선택자](#css-선택자---flukeoutgithubio)


[2. Flex](#flexbox---flexboxfroggycom)

-------

## CSS 선택자 - flukeout.github.io

### 1. 선택자 기초

- `*`: 모든 요소를 선택합니다.
- `element`: 해당 요소를 선택합니다.
- `.class`: 클래스 이름과 일치하는 요소를 선택합니다.
- `#id`: ID 이름과 일치하는 요소를 선택합니다.

### 2. 조합 선택자

- `element element`: 부모 요소 아래의 자식 요소를 선택합니다.
- `element > element`: 직계 자식 요소를 선택합니다.
- `element, element`: 여러 요소를 동시에 선택합니다.

### 3. 속성 선택자

- `element[attribute]`: 특정 속성이 있는 요소를 선택합니다.
- `element[attribute="value"]`: 특정 속성 값과 일치하는 요소를 선택합니다.
- `element[attribute^="value"]`: 특정 속성 값으로 시작하는 요소를 선택합니다.

### 4. 가상 클래스 선택자

- `element:first-child`: 첫 번째 자식 요소를 선택합니다.
- `element:last-child`: 마지막 자식 요소를 선택합니다.
- `element:nth-child(n)`: n번째 자식 요소를 선택합니다.
- `element:hover`: 마우스를 올려놓을 때 요소를 선택합니다.

----
----


## Flexbox - flexboxfroggy.com

### 1. Flex 컨테이너와 아이템

- `display: flex;`: Flex 컨테이너를 생성합니다.
- `flex-direction: row | row-reverse | column | column-reverse;`: 아이템의 배치 방향을 설정합니다.
- `flex-wrap: nowrap | wrap | wrap-reverse;`: 아이템이 한 줄에 다 들어가지 않을 경우 어떻게 줄을 바꿀지 설정합니다.
- `justify-content: flex-start | flex-end | center | space-between | space-around;`: 아이템을 가로로 정렬합니다.
- `align-items: flex-start | flex-end | center | baseline | stretch;`: 아이템을 세로로 정렬합니다.

### 2. 아이템에 대한 Flex 설정

- `order: <number>;`: 아이템의 순서를 지정합니다.
- `flex-grow: <number>;`: 아이템의 크기를 얼마나 더 늘릴지 설정합니다.
- `flex-shrink: <number>;`: 아이템의 크기를 얼마나 줄일지 설정합니다.
- `flex-basis: <length> | auto;`: 아이템의 초기 크기를 설정합니다.
- `flex: <flex-grow> <flex-shrink> <flex-basis>;`: 위 속성들을 한 줄로 축약해서 설정할 수 있습니다.

### 3. 아이템 간의 간격 설정

- `align-self: auto | flex-start | flex-end | center | baseline | stretch;`: 개별 아이템의 세로 정렬을 설정합니다.
- `align-content: flex-start | flex-end | center | space-between | space-around | stretch;`: 여러 줄의 아이템을 정렬합니다.

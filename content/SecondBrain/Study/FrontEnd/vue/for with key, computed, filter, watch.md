---
tags:
  - Vue
---

## 1. v-for with key

`v-for` 디렉티브는 배열이나 객체를 순회하면서 각 아이템에 대해 작업을 수행할 수 있게해준다. 하지만 `v-for`를 사용할 때 배열의 각 아이템에 고유한 식별자(key)를 항상 설정해야하는데, `vue`는 `in place patch`전략을 사용한다. 

`in place patch`란 필요한 부분만 바꾸며 Dom을 재사용한다는 말이다. 일반적으로는 오류를 일으키지 않지만, 데이터를 조작 시에 문제가 생길 수 있다.  예를들어 아래와 같은 음료가 있을때 key를 사용하지않고 한 칸 씩 민다면.

변경 전

|  종류  | 개수 |
| :----: | :--: |
| 사이다 | 5개  |
|  콜라  | 1개  |

변경 후 (메모리 절약을 위해 필요한 부분만 바뀌게된다.)

|  종류  |  개수   |
| :----: | :-----: |
|  콜라  | **5개** |
| 사이다 | **1개** |

아래와 같이 항상 키 값을 설정해주는게 좋다.

```vue
    <div v-for="item in items" :key="item.id">
      <!-- content -->
    </div>
.
.
.
<script setup>
        const items = ref([
          { id: id++, name: 'Alice' },
          { id: id++, name: 'Bella' },
        ])
</script>
```

**수정 메서드**

- `push()`
- `pop()`
- `shift()`
- `unshift()`
- `splice()`
- `sort()`
- `reverse()`

공식 홈페이지링크 https://ko.vuejs.org/guide/essentials/list.html



## 2. computed vs method

computed 속성은 의존된 반응형 데이터를 기반으로 캐시된다. 의존하는 데이터가 변경된 경우에만 재평가 됨. 즉, 의존된 반응형 데이터가 변경되지 않는 한 여러 참조 평가할 필요없이 즉시 반환한다. 반면에 method는 렌더링 될 때마다 항상 함수를 실행한다.

```vue
<body>
    <p>{{abc}}</p>
    <p>{{abc}}</p>
    <p>{{abc}}</p>
    
</body>
<script setup>
//    ...
    const a = ref(1);
	const abc = computed(() => {
          return a.value
        })
</script>
```

computed는 위의 함수가 한 번만 실행되는 반면 메소드를 사용한다면 세 번 실행된다.

```vue
<script setup>
    //...
const abc = computed(() => {
          return a.value+1
        })
</script>
```

 하지만 value를 계속 더하는 상태라면 세 번이 실행된다.

## 3. filter

`Vue.js`에서 `filter`는 데이터 배열을 특정 기준에 따라 모두 필터링할 때 사용된다. 

```vue
    <li v-for="todo in todos" :key="todo.id">
      {{ todo.text }}
      <button @click="removeTodo(todo)">X</button>
    </li>
<script>
function removeTodo(todo) {
  todos.value = todos.value.filter((t) => t !=todo);
}
    </script>
```

해당하는 리스트를 삭제하는 함수 `todos.value.filter((t)=>t!=todo)` todos의 각각의 객체는 t이다. 

todo는 선택된 리스트





## 4.watch

반응형 데이터를 감시하고 감시하는 데이터가 변경되면 콜백 함수를 호출

```vue
<script>
	watch(variable,(newValue,oldValue)=>{
	// do something
})
</script>
```

`variable` : 감시하는 변수, `newValue` 변화된 값, `oldValue` 바뀌기 전

```vue
    <button @click="count++">Add 1</button>
    <p>Count: {{ count }}</p>

<script>
	const countWatch = watch(count, (newValue, oldValue) => {
	console.log(`newValue: ${newValue}, oldValue: ${oldValue}`)
	})
</script>
```

![image](https://github.com/SeokJuGo/SeokJuGo/assets/116260619/f7a2ec8a-7eae-4c5f-b349-01880cf87599)

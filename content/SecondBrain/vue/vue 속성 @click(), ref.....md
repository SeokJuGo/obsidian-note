---
tags:
  - Vue
---

## 1. [[Vue]] 속성

```vue
<template>
  <div>
    <p>카운트: {{ count }}</p>
    <button @click="increment">증가</button>
	<input type="text" v-model="count" />
  </div>

</template>

<script setup>
import { ref } from 'vue';
const count = ref(0);

function increment() {
  count.value++;
}
</script>
```



---

### 1. @click()

```vue
    <button @click="increment">증가</button>
    function increment() {
  count.value++;
}
```

**`@click` (또는 `v-on:click`) - 이벤트 처리**

`@click` 또는 `v-on:click`은 사용자가 특정 DOM 요소를 클릭했을 때 발생하는 이벤트를 처리하는 Vue.js의 디렉티브입니다. 이를 사용하여 특정 이벤트에 대응하는 메소드를 호출하거나 다양한 로직을 실행할 수 있다.

`@click` v-on:click와 동일. 클릭 시 이벤트

### 2. setup

```vue
 <div>
</div>
<script setup>
    </script>
```

`<script setup>` vue 3 사용, Composition API를 더 쉽게 사용. 한다. div에 아이디를 따로 표시하지 않아도 됨.





### 3. ref

```vue
<template>
  <div>
    <p>카운트: {{ count }}</p>
    <button @click="increment">증가</button>
	<input type="text" v-model="count" />
  </div>

</template>
const count = ref(0);
```

`ref` 변수를 리액티브하게 사용할 수 있다. v-model을 사용함으로써 서로 전달할 수 있음.


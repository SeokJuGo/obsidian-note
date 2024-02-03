---
tags:
  - Vue
---

# [[Vue]] Function



## 1. 기본 문법

####   1)데이터 바인딩

```vue
<p>{{msg}}</p>
```

- Mustache(이중 중괄화)를 사용해서 변수를 바인딩할 수 있다. msg가 변경되면 바로 갱신된다.

####   2) 속성 (v-bind)

```vue
<button v-bind:[attributename]="isOk">확인</button>
<script setup>
import {ref} from "vue"
    const attributename = "disabled"
    const isOk = "false"
</script>
```

- 속성을 부여할 땐 Mustache를 사용할 수 없다. v-bind를 사용함으로써 속성을 부여할 수 있다.(생략가능)
- 속성명을 삽입하고 싶을땐 대괄호를 사용한다. 속성변수명은 **대문자를 사용할수없음!**



## 2. v-if, v-show

```vue
<template>
<h1 v-if=false>hi </h1>
<h1 v-show=false>hi </h1>
</template>
```

- `v-if ` 태그 엘리멘트가 모두 사라진다.
- `v-show` `style="display: none"` 으로 표시된다.  (여러번 바뀌는 상황이라면 v-show을 권장)



## 3.v-model

```vue
<template>
  <div>
    <form>
    <input type="text" v-model="color">
    <h1>{{color}}</h1>
  </form>
    </div>
</template>

<script setup>
import { ref } from "vue";
const color = ref("red");

</script>
```

- `v-model`을 사용하게 되면 `양방향` 통신을하게 되며 페이지  reloading을 하지 않아도 반응한다.



## 4.@submit

submit시 상태를 변경

```vue
<template>
  <div>
    <form @submit.prevent>
    <input type="text" v-model="color">
    <h1>{{ hello}}</h1>
    <button @click ="seokju">gg</button>
  </form>
    </div>
</template>

<script setup>
import { ref } from "vue";
const color = ref("black");
const hello = ref("hello")
const seokju = () =>{
  hello.value = color.value;
}
</script>
```

- `v-model`이 즉각 반영을 하지만, form 데이터를 submit했을 때 반영하고 싶다면, 변수를 추가하되, 페이지 리로딩을 하게 되면, 다시 되돌아가게 된다. 여기서 `@submit.prevent`를 사용하게 되면, 텍스트가 변경된다.

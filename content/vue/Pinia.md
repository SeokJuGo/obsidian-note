[[Vue]]
# :pineapple: Pinia 

Vue의 스토어 라이브러리로 컴포넌트/페이지 간에 상태를 공유할 수 있다.

#### package.json

```json
"dependencies": {
    "pinia": "^2.1.4",
    "pinia-plugin-persistedstate": "^3.2.0",
    "vue": "^3.3.4"
  },
```

`pinia-plugin-persistedstate`는 `Vue.js` 애플리케이션에서 상태를 로컬 스토리지나 세션 스토리지에 지속적으로 저장할 수 있게 해주는 Pinia 플러그인이다. `pinia-plugin-persistedstate`를 사용하면 애플리케이션의 상태가 페이지를 새로 고침하거나 브라우저를 닫았다가 다시 열었을 때도 유지된다.

#### main.json

```js
//import { createApp } from 'vue'
import { createPinia } from 'pinia'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'
//import App from './App.vue'

//const app = createApp(App)
const pinia = createPinia()

pinia.use(piniaPluginPersistedstate)

// app.use(createPinia())
app.use(pinia)

//app.mount('#app')

```

#### counter.js

```js
import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useCounterStore = defineStore('counter', () => {
  let id = 0
  const todos = ref([])
...
  return { todos}
}, { persist: {storage: localStorage }})  //sessionStorage...

```

#### App.vue

```vue
<script setup>
import { storeToRefs } from "pinia";
import {useCounterStore} from "./stores/counter";

const store = useCounterStore();
const {count} = storeToRefs(store);
</script>

<template>
  <div>
    <button @click="store.increment">click</button>
    <div>{{ store.doubleCount }}</div>
    <div>{{ store.count }}</div>
    <div>{{ count }}</div>
    
  </div>
</template>
```

1. `storeToRefs`: Vuex 스토어의 상태를 반응형 참조로 변환하는 함수. 이 함수는 스토어의 상태를 가져와 모든 반응형 속성에 대한 참조를 생성한다.
2. `useCounterStore()`: Vue 스토어를 생성하고 반환하는 함수
3. 디스트럭처링: `storeToRefs`에서 반환된 객체를 디스트럭처링을 사용하여 원하는 속성으로 추출합니다.

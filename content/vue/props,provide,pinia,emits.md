[[Vue]]
# Props

```vue
<script setup>
    // import {defineProps} from "vue"
    const {ages} = defineProps(["ages"])
</script>

<template>
        <ul>
            <li v-for="age in ages">{{age}}</li>
        </ul>
</template>
```

```vue
<script setup>
    import Child from "./Child.vue"
    import {ref} from "vue"
    const ages = ref([14, 15, 16, 21, 22, 13, 19, 27, 25])
</script>
<template>
        <div class="newline"></div>
        <Child :ages="ages"/> // 깊이만큼 선언한다.
</template>
```



# Inject

```vue
<script setup>
    import Child from "./Child.vue"
    import {provide, ref} from "vue" // 1번
    const ages = ref([14, 15, 16, 21, 22, 13, 19, 27, 25])
    provide("ages", ages) //2번
</script>
<template>
        <Child />
</template>
```

```vue
<script setup>
    import {inject} from "vue" // 3번  Props는 생략해도되는 반면 inject는 생략하면 안된다.
    const ages = inject("ages") //4번 깊이만큼 선언하지 않아도된다.

</script>

<template>
            <li v-for="age in ages">{{age}}</li>
</template>
```

# Pinia

`root/pinia/useAges.js`

````js
export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})
````

- 변수명은 use{변수}Store와 같이 해준다.

```vue
<script setup>
    import Child from "./Child.vue"
    import {useAgesStore} from "../../pinia/useAges"
    const {count, doubleCount} = useCounterStore()
</script>
```



# Emits

```vue
<script setup>
const emit = defineEmits(['response'])
emit('response', '🌷!')
</script>
```

```vue
<script setup>
import { ref } from 'vue'
import ChildComp from './ChildComp.vue'
const childMsg = ref('아직 메시지를 받지 못했어요!')
</script>
<template>
  <ChildComp />
  <p>{{ childMsg }}</p>
</template>
```


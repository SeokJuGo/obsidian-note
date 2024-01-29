[[Vue]]
# 1. Axios

javascript 어플리케이션에서 서버 통신을 하기 위한 HTTP 통신 라이브러리

#### 1) npm install

```
npm install axios
```

#### 2) async

`axios`는 `async`함수를 사용한다.  async함수는 보통 함수 앞에 명시하며, aysnc가 붙은 함수는 `Promise`객체를 반환한다.

```vue
<script>
async function f (){
   // return은 promise 객체이다.
}
</script>
```


- 전체 리스트
```vue
<script setup>
import { ref } from "vue";
import api from "axios";
import { onMounted } from "vue";
const boards = ref([]);
const boardlist = async () => {
  await api
    .get(`http://localhost:9999/vue/board/`, {
      params: {
        pgno: "1",
        key: "",
        spp: "10",
        word: "",
      },
    })
    .then((response) => {
      //   boards.value = data;
      //   console.log("3. albums data >> ", data);
      console.log(response);
    })
    .catch((e) => {
      console.log("3. bpards catch >> ", e);
    });
};
onMounted(() => {
  boardlist();
});
</script>
```
- parameter별 detail
```vue
<script setup>
import { ref, onMounted } from "vue";

import { useRoute, useRouter } from "vue-router";

import api from "axios";
const route = useRoute();
const articleNo = ref(route.params.no)
const boards = ref({});
//http://localhost:9999/vue/board/?pgno=1&word=&spp=4&key=
const boarddetail = async () => {
  await api
    .get(`http://localhost:9999/vue/board/${articleNo.value}`)
    .then(({ data }) => {
      boards.value = data
      console.log("1. boards data >> ", boards.value);
      //console.log("----------------------------->", response);
    })
    .catch((e) => {
      console.log("1. boards catch >> ", e);
    });
};

onMounted(() => {
  articleNo;
  boarddetail();
console.log(articleNo.value)
});


const router = useRouter(); // 네비게이션
const showBoard=(no) =>{
  router.push(`/boarddetail/${no}`);
}
</script>
```
`async` 함수는 항상 `Promise`를 반환하며, `await`는 `Promise`가 처리(resolve)될 때까지 실행을 일시 중단하고 해당 `Promise`의 결과를 반환한다.



---
tags:
  - React
  - Route
---

[[React]]
```
<Routes>  
    <Route path={"/login"} element={<LoginPage/>}/>  
    <Route path={"/join"} element={<UserRegist/>}/>  
    <Route path={"/"} element={<Main/>}/>  
</Routes>
```
여기서 Main 경로에 `/만` 썼을땐 동작하지 않았는데

와일드카드를 붙이니 Main이하 경로들이 렌더링이되었다.

**라우트 순서의 중요성:**

- React Router에서는 라우트 순서가 중요 라우트는 위에서부터 아래로 평가되며, 첫 번째로 매칭되는 라우트가 사용
- `/`만 사용했을 때, `/feed`, `/profile`, `/consult` 등의 경로는 `/`와 일치하기 때문에 `/`에 매칭되는 라우트가 먼저 발견되어 그 뒤의 라우트들이 무시될 수 있다
- `/*`를 사용하면 와일드카드 경로가 가장 마지막에 위치하기 때문에 다른 경로들과 충돌하지 않고 적절한 라우트로 매칭된다.
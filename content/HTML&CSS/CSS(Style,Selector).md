## 목차

[Style](# 1.style)

[Selector](# 2.selector)

# CSS

## 0. 단축키

------------------

|       단축키        |               설명                |
| :-----------------: | :-------------------------------: |
|      Ctrl + L       |  같은 글자들을 모두 refactoring   |
|      Ctrl+D D       |  같은 글자들을 부분 refactoring   |
| Ctrl+alt+아래방향키 | 아래에 있는 글자들을 같이 바꾼다. |



## 1.Style

- 스타일의 우선순위 (인라인 > 내부 > 외부)

1)  **외부스타일 시트**

   ```html
   <!--1. link-->
   <link rel="stylesheet" type="text/css" href="../css/4-1.css" />
   
   <!--2. import, header에 위치해야됨.-->
       <style type="text/css" media="screen">
         @import url("../css/4-1.css");
         /* @import "../css/4-1.css"; */
         h2 {
           background-color: orange;
         }
       </style>
   ```

2) **내부스타일 시트**

   ```html
       <style type="text/css">
         h2,p {
           color: magenta;
         }
       </style>
   ```

3) **인라인 스타일**

   ```html
   <h2 style="color: magenta">Inline Style Sheet</h2>
   ```



## 2.Selector

- 선택자 우선순위  전체<타입<클래스<아이디

1.  **전체 선택자**

   ```html
   <style type = "text/css">
       * { color: magenta;  }
   </style>
   ```

2. **타입 선택자**

   ```html
   <style type = "text/css">
       p,div{ color: magenta;}
   </style>
   ```

3.  **클래스 선택자**

   ```html
   <!--1. 클래스는 여러개가 될 수 있다.-->
   <style type = "text/css"> 
       .hi{ color: magenta;  }
   </style>
   ```

4. **ID 선택자**

   ```html
   <!--1. ID는 하나-->
   <style type = "text/css"> 
       #hi{ color: magenta;  }
   </style>
   ```

5. **자식 선택자**

   - 원하는 결과를 얻기 위해 모든 선택자를 적절히 사용하는게 중요하다.

   ```html
   <!--1. 하위 선택자-->
   <style type = "text/css"> 
       div span { color: magenta;  }
   </style>
   
   <!--3. 자식 선택자-->
   <style type = "text/css"> 
       div > div { color: magenta;  }
   </style>
   <!--하위 자손 구분-->
   <body>
       <div>
           <span>
               
           </span>
           <div> 
               
           </div>
       </div>
   </body>
   ```

6. **가상클래스**

- link, visited,hover,active 기억하기

```html
	<style type="text/css">
      a:link {
        color: gray;
        text-decoration: none;
      }
      a:visited {
        color: red;
        text-decoration: none;
      }
      a:hover {
        color: green;
        text-decoration: underline;
        font-weight: bold;
      }
      a:active {
        color: blue;
        text-decoration: none;
      }
    </style>
  </head>
  <body>
    <a href="http://www.google.com">Google</a>
    <a href="http://www.ssafy.com">ssafy</a>
    <a href="http://www.naver.com">Naver</a>
    <a href="http://www.daum.net">Daum</a>
  </body>
</html>

```

![image](https://github.com/SeokJuGo/SSAFY_TIL/assets/116260619/533d34a9-8ccc-401d-81fd-4f4ef114fa19)


목차
--

[1\. Exception](#1-exception)

[2. Throws](#--throws)

1\. Exception
=============

*   프로그래밍에 의해 수습될 수있는 상황
    
*   Error,Exception -> Throwable -> Object
    
*   1.Checked exception - 대처코드가 없으면 컴파일 x
    
*   2.Unchecked exception - 대처코드가 없어도 컴파일 o

```
public static void main(String\[\] args) {  
        int num = new Random().nextInt(2);  
        try {  
            System.out.println("code 1, num:"+num);  
            int i = 1/num; // 예외시작  
            System.out.println("code 2 예외없음");  
            return; // 주의  
        }catch(ArithmeticException e) {System.out.println("code 3 처리완료");     
        }catch(NullPointerException e) {System.out.println("code 4 처리완료"); // 1) 컴파일 여부?  
        }finally{System.out.println("code 5 언제나 실행");  
        }System.out.println("code 6");  
        } // 2) 0일때 1일때 순서
```



        }catch(Exception e) {     
            System.out.println("전체처리");  
        }catch(NullPointerException e) {  
            System.out.println("널포인트");  
        }//3) 컴파일 또는 런타임 에러되는지? 나면 4) 어디 또는 수정? 

*   finally를 쓰는이유는 유지보수
    
*   try(리소스 타입 리소스 ->자동 close){}
    

\- Throws
---------

*   호출한 곳으로 Exception 객체 전달
    
*   reachable unreachalbe 

```
main(){
method1(); //?
method2();
}
void method1() throws Exception(){}
void method2() throws ClassNotFoundException{}
```



```
class Parent{  
void methodA() throws IOException{}  
}  
class Child extends Parent{  
@Override  
void methodA() trhow Exception{} //5)??  
}  

```




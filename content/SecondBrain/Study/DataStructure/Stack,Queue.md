----

 `삼성 역량 평가 B형`에 목적을 두어 기초와 변형하여 상술 하였음. 

---

# Stack Basic

```c
#include <stdio.h>
#define MAX_N 100
int top;
int stack[MAX_N];
void stackInit(void)
{
    top = 0;
}
 
int stackIsEmpty(void)
{
    return (top == 0);
}
 
int stackIsFull(void)
{
    return (top == MAX_N);
}
 
int stackPush(int value)
{
    if (stackIsFull())
    {
        printf("stack overflow!");
        return 0;
    }
    stack[top] = value;
    top++;
 
    return 1;
}
 
int stackPop(int *value)
{
    if (stackIsEmpty())
    {
        printf("stack is empty!");
        return 0;
    }
    top--;
    *value = stack[top];
 
    return 1;
}
 
int main(int argc, char* argv[])
{
    int T, N;
 
    scanf("%d", &T);
 
    for (int test_case = 1; test_case <= T; test_case++)
    {
        scanf("%d", &N);
        stackInit();
        for (int i = 0; i < N; i++) 
        {
            int value;
            scanf("%d", &value);
            stackPush(value);
        }
 
        printf("#%d ", test_case);
 
        while (!stackIsEmpty())
        {
            int value;
            if (stackPop(&value) == 1)
            {
                printf("%d ", value);
            }
        }
        printf("\n");
    }
    return 0;
}
```

**체크 사항:** 스택 오버플로우 및 스택 비어 있음에 대한 검사를 수행하여 `안정성`을 최대한 확보하고, 

최대 스택 크기(MAX_N)를 정의하여 메모리 사용량을 제한하였다

# Stack 변형

```java
public class Stack {
	int[] stack = new int[2000000]; 
	int top;
	
	void push(int a) {
		stack[++top] = a;
	}

	int pop() {
		if(top!=0) return stack[--top];
		return -1;
	}
	
	int size() {
		return top;
	}
	
	boolean empty() {
		if(top!=0) return true;
		return false;
	}
}

```

**체크사항**

스택 변형에서는 스택의 메모리를 크게 확장하여 push 연산 시 스택이 가득 찬지 확인하는 검사를 배제하였다. 이로 인해 스택 변형은 일반적인 상황에서는 약간의 성능 향상을 얻을 수 있다. 

하지만 스택이 실제로 오버플로우되는 경우에는 예상치 못한 결과를 초래할 수 있다.

- **메모리 사용량 감소:** 스택 변형에서는 스택의 크기를 크게 확장하였다. 이로 인해 스택이 가득 차더라도 스택 오버플로우를 검사하거나 예외 처리할 필요가 없다. 따라서 스택 오버플로우 및 스택 언더플로우에 대한 추가적인 메모리 및 연산 비용이 들지 않는다. 특히 스택의 크기를 사전에 정확히 예측하기 어려운 경우에 유용하다.
- **Push 연산 최적화:** 스택 변형에서는 push 연산이 간단하게 `stack[++top] = a;`와 같이 수행됩니다. 이것은 push 연산이 더 빠르게 실행될 수 있도록 도와준다. 스택이 가득 찼는지 여부를 확인하는 검사가 없기 때문에 push 연산이 더 빠르게 수행한다.
- **Short-circuit 최적화:** `top`이 0인 경우는 스택이 비어있을 때만 발생하므로, 이런 경우를 고려하여 `if(top!=0)`과 같은 검사를 생략할 수 있다. 이것은 코드를 더 간단하고 빠르게 만들어준다.

# + Queue 변형

```java
public class Queue {
	int[] que = new int[2000000];
	int s;
	int e;
	
	void push(int a) {
		que[++e] = a;
	}
	int pop() {
		if(e!=0) return que[--e];
		return -1;
	}
	int size() {
		return e-s;
	}
	int front() {
		if(s!=e) return que[s];
		return -1;
	}
	int back() {
		if(s!=e) return que[e];
		return -1;
	}
	boolean empty() {
		if(s!=e) return true;
		return false;
	}
}

```


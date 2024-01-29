## 관점

- **문자열은 equals만 하면 되는거 아닌가?**
  - 문자열 패턴 매칭은 단순히 두 문자열이 동일한지 확인하는 것 이상의 문제이다. 패턴 매칭은 텍스트 내에서 특정한 패턴을 찾는 과정으로, 패턴이 어디에서 발생하는지, 그리고 얼마나 자주 발생하는지가 중요하다.
- **효율적인 방법은 없을까?**
  - 각각의 알고리즘은 다양한 시간 복잡도와 성능을 보인다. 
  - 완전 탐색을 하게 되면 시간이 많이 소요될 수 있다. 주어진 상황에 맞는 효율적인 알고리즘을 선택해야한다.


## 문자열 패턴 매칭 (n*M)

```java
x = "XCVNWELKFSDMNVDFMBNELJVK"
y = "SDLKFJ"
```

일치하는 문자 시간 복잡도 => O(n*m)




## KMP(N+M)

```java
class KMP_String_Matching {
	void KMPSearch(String pat, String txt)
	{
		int M = pat.length();
		int N = txt.length();

		int lps[] = new int[M];
		int j = 0; 

		computeLPSArray(pat, M, lps);

		int i = 0;
		while ((N - i) >= (M - j)) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				System.out.println("Found pattern "
								+ "at index " + (i - j));
				j = lps[j - 1];
			}

			else if (i < N
					&& pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
	}

	void computeLPSArray(String pat, int M, int lps[])
	{
		int len = 0;
		int i = 1;
		lps[0] = 0; 
		while (i < M) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else 
			{
				if (len != 0) {
					len = lps[len - 1];

				}
				else
					lps[i] = len;
					i++;
				}
			}
		}
	}

	public static void main(String args[])
	{
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		new KMP_String_Matching().KMPSearch(pat, txt);
	}
}
```

- **장점:**
  1. **효율적인 비교 연산:** KMP 알고리즘은 패턴과 텍스트를 한 번에 살펴보면서 부분 일치를 찾아낸다 이로 인해 불필요한 문자열 비교를 줄여 시간 복잡도를 크게 감소
  2. **추가 공간 복잡도:** KMP 알고리즘은 부분 일치를 저장하는 데 필요한 LPS(Longest Proper Prefix which is also Suffix) 배열을 생성
- **단점:**
  - **추가적인 공간 요구:** LPS 배열을 저장하기 위한 추가적인 공간이 필요

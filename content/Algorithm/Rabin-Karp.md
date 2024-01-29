##  라빈 카프

```java
public class Main {

    public static void search(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        int patternHash = pattern.hashCode();
        
        for (int i = 0; i <= textLength - patternLength; i++) {
            // 부분 문자열의 해시값 계산
            int substringHash = text.substring(i, i + patternLength).hashCode();

            // 해시값이 일치하고 부분 문자열이 일치할 경우 패턴이 발견됨
            if (patternHash == substringHash && text.substring(i, i + patternLength).equals(pattern)) {
                System.out.println("패턴이 텍스트의 인덱스 " + i + " 에서 발견되었습니다.");
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABCABAB";
        String pattern = "ABAB";

        // 라빈-카프 알고리즘을 사용하여 패턴을 텍스트에서 찾기
        search(pattern, text);
    }
}

```

- `해쉬 값`을 이용하여 pattern의 중간까지 가지않고 `한 번만` 비교한다. 다만 해쉬 충돌이 날 가능성이 있다.

  `text.substring(i, i + patternLength).equals(pattern)` 이와 같은 검증과정을 한 번 더 함으로써 안정적으로 사용할 수있다 

# JDBC (Java Database Connectivity)

- JDBC는 Java 프로그램이 다양한 데이터베이스와 통신하고 상호 작용하기 위한 표준 인터페이스를 제공하는 API
- JDBC를 사용하려면 해당 데이터베이스에 대한 JDBC 드라이버가 필요하다
- JDBC 드라이버는 데이터베이스 연결을 설정하고, SQL 쿼리를 실행하며, 결과를 처리하는 데 사용된다.

## 1. 드라이버 통신 테스트

```java
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>

```

- mysql dependency 추가하기 https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.33

```java
package com.ssafy.jdbctest;

public class DriverLoadingTest {
	public DriverLoadingTest() {
//		Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success !!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DriverLoadingTest();
	}

}

```

- 자바의 클래스와 DB를 연결(java.lang.class) https://docs.oracle.com/javase/8/docs/api/

**`java.lang.Class`와 JDBC 연결**:

- `java.lang.Class` 클래스는 Java 클래스의 메타정보를 다루는 데 사용
- JDBC에서 `java.lang.Class`는 JDBC 드라이버 클래스를 동적으로 로드하는 데 주로 활용`Class.forName("com.mysql.cj.jdbc.Driver")`와 같이 사용하여 MySQL JDBC 드라이버 클래스를 로드한다.

`Class.forName("com.mysql.cj.jdbc.Driver")`는 MySQL JDBC 드라이버 클래스를 동적으로 로드. 



`java.lang.Class`를 사용하여 JDBC 드라이버 클래스를 로드하고, 이 드라이버를 통해 데이터베이스와 연결을 설정하고 데이터를 조회하거나 수정하는 것이 일반적인 JDBC 프로그래밍의 시작 단계 중 하나이다.



## 2. [[DML]] insert 해보기

```java
package com.ssafy.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
	public InsertTest() {
//		Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success !!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		String id = "seokju";
		String name = "석주";
		String pwd = "9988";
		int cnt = it.register(id, name, pwd);
		if (cnt != 0) {
			System.out.println("회원가입성공");
		} else {
			System.out.println("실패");
		}
	}

	private int register(String id, String name, String pwd) {
		int cnt = 0;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy",
					"ssafy");
			System.out.println("DB연결 성공");
			StringBuilder sql = new StringBuilder("insert into ssafy_member(userid,username,userpwd) \n");
			sql.append("values('" + id + "','" + name + "','" + pwd + "')");
			System.out.println(sql.toString());
			stmt = conn.createStatement();
			cnt = stmt.executeUpdate(sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

}

```


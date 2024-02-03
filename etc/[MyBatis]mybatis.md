# Mybatis

- MyBatis는 개발자가 지정한 SQL 저장 프로시저나 매핑을 지원하는 퍼시스턴스 프레임워크

모든 MyBatis는 SqlSessionFactory인스턴스를 사용한다.

![image](https://github.com/SeokJuGo/SeokJuGo/assets/116260619/ee616a13-cea3-4232-a50f-6fa73b14e004)

## 1) 숨긴정보

```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://localhost:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8
username=ssafy
password=ssafy
```

## 1) sql 쿼리 정보

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="com.ssafy.mybatis.dao.MemberDao">

	<resultMap type="memberDto" id="member">
		<result column="user_id" property="userId"/>
		<result column="user_name" property="userName"/>
		<result column="user_password" property="userPwd"/>
		<result column="email_id" property="emailId"/>
		<result column="email_domain" property="emailDomain"/>
		<result column="join_date" property="joinDate"/>
	</resultMap>

	<insert id="joinMember" parameterType="memberDto">
		insert into members (user_name, user_id, user_password, email_id, email_domain, join_date)
		values (#{userName}, #{userId}, #{userPwd}, #{emailId}, #{emailDomain}, now())
	</insert>

	<select id="listMember" resultMap="member">
		select user_id, user_name, user_password, email_id, email_domain, join_date
		from members
	</select>

</mapper>
```

## 2) mybatis 환경정보

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

	<properties resource="com/ssafy/mybatis/config/dbinfo.properties"/>
	
	<typeAliases>
		<typeAlias type="com.ssafy.mybatis.MemberDto" alias="memberDto" />
	</typeAliases>

	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC" />
			<dataSource type="POOLED">
				<property name="driver" value="${driver}" />
				<property name="url" value="${url}" />
				<property name="username" value="${username}" />
				<property name="password" value="${password}" />
			</dataSource>
		</environment>
	</environments>
	
	<mappers>
		<mapper resource="com/ssafy/mybatis/config/member.xml" />
	</mappers>
	
</configuration>
```

## 3) mybatis 팩토리

```java
package com.ssafy.mybatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			String resource = "com/ssafy/mybatis/config/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	
}

```


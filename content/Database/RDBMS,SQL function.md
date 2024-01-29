# Database



## 목차

[1. RDBMS](#1-rdbms)

[2. SQL function](#2sql-function)



## 1. RDBMS

- 관계형 데이터베이스 시스템
- 테이블기반 DBMS
- 데이터를 테이블 단위로 관리, 테이블 내에는 여러개의 컬럼이있다.
- 중복 데이터를 최소화함.
- 여러 테이블에 분산되어 있는 데이터 검색 시 JOIN을 이용함. 

![image](https://github.com/SeokJuGo/SeokJuGo/assets/116260619/612d546c-261d-4e30-a33d-750edd8e3e9e)

## DCL,DDL,DML

### DML(Data Manipulation Lanaguage)

- insert update delete select

### DDL(Data Definition Lanaguage)

- create alter drop rename

### DCL(Data Control Language)

- Grant,revoke





## 2.SQL Function

### 1. IF

- IF( expression1(조건), expression2(TRUE), expression3(FALSE) )

```mysql
SELECT IF(salary>15000,"고액연봉","평균연봉") FROM employees;
```

### 2. IFNULL

- IFNULL(expression1(IF), expression2(NULL))

```mysql
SELECT IFNULL(commision+1,0) FROM employees;
```

### 3.NULLIF

- NULLIF(expression1(NULL), expression2(IF) )

```mysql
SELECT IFNULL(0,commision+1) FROM employees;
```

### 4.CASE WHEN THEN

```mysql
case
	when salary>= 15000 then "고액연봉"
	when salary>= 8000 then "평균연봉"
	else "저액연봉"
END "급여봉급"
FROM employees;
```

:rocket: if vs case

```mysql
SELECT salary,
IF (salary>=15000,"고액연봉",
IF(salary>=8000,"평균연봉","저액연봉")) as "급여봉급"
FROM employees;
```

- 대체가 가능함.

### 5. Is

```mysql
SELECT * FROM
WHERE commision=null; (x)

WHERE commision is null; (o)
```

### 6. like

```mysql
SELECT * FROM employees
where first_name like "%x%"
```

### 7.distinct

```mysql
SELECT DISTINCT column_name FROM table_name;
```

### 8.concat

```mysql
SELECT CONCAT(column1, ' ', column2) AS concatenated_column
FROM table_name;
```

### 9. length() vs char_length()

```mysql
SELECT char_length("홍길동") as 한글, char_length("hong") as 영문 FROM DUAL;
```

### 10.문자열 관련

```mysql
replace(name,element,element);
substr(name,start,end);
left(name,start,end)
right(name,start,end)
```

# ​:baseball:​ Database



## DDL

- Data Definition Language 테이블의 구조생성변경 제거

|   SQL    | 설명  |
| :------: | :---: |
|  INSERT  |  DML  |
|  UPDATE  |  DML  |
|  DELETE  |  DML  |
|  SELECT  |  DML  |
| `CREATE` | `DDL` |
| `ALTER`  | `DDL` |
|  `DROP`  | `DDL` |
| `RENAME` | `DDL` |
|  GRANT   |  DCL  |
|  REVOKE  |  DCL  |



```mysql
create table ssafy_member (
	idx			int 		not null auto_increment,
	userid		varchar(16)	not null unique,
	username	varchar(20),
	userpwd		varchar(16),
	emailid		varchar(20) check(emailid in('a','b','c')),
	emaildomain	varchar(50) default 'ssafy.com',
	joindate	timestamp	not null default current_timestamp,
	constraint ssafy_member_idx_pk primary key (idx) # 제약조건이름은 규칙성이 있어야 좋음.
) ENGINE=InnoDB default CHARSET=utf8mb4;
```

| 제약조건       | 설명                                       |
| -------------- | ------------------------------------------ |
| NOT NULL       | NULL 저장 `X`                              |
| UNIQUE         | NULL 저장 `O`, NULL을 제외한 중복X         |
| PRIMARY KEY    | NULL 저장 `X`, 중복 `X`                    |
| FOREIGN KEY    | NULL 저장 `O`, 부모키(PK) 값과 같아야한다. |
| DEFAULT        | 입력하지 않으면 기본값으로 저장이된다.     |
| CHECK          | `조건`이 맞다면 insert한다.                |
| AUTO_INCREMENT | `1`부터 시작, 순차적으로 증가한다.         |



```mysql
ALTER TABLE 테이블이름 ADD COLUMN 컬럼명 data-type 제약조건;
ALTER TABLE 테이블이름 MODIFY COLUMN 컬럼명 data-type 제약조건; # 이전 범위보다 커야한다.
ALTER TABLE 테이블이름 CHANGE COLUMN 이전컬럼 변경 data-type 제약조건;
ALTER TABLE 테이블이름 DROP COLUMN 컬럼명;
ALTER TABLE 테이블이름 테이블명 RENAME 변경명;
```



## Index

- 인덱스는 테이블의 `동작속도`를 높이는 하나의 사본. 
- 디스크 공간은 테이블보다  대략 1/10적다, index는 세부항복이 없고 키필드만 갖고 있기때문
- 삽입 수정시 같이 변경되기때문에 주의해서 생성해야한다.



### 클러스터형 인덱스 (Clustered index)

- `자동정렬`이 된다. 중간에 pk값을 `없애도 정렬이 유지`되지만, pk값을 `삽입하면 재정렬`을 한다.

![image](https://github.com/SeokJuGo/SeokJuGo/assets/116260619/06d5f6cb-e82c-4808-abb4-ede51382fcb7)



### 보조 인덱스 (Secondary index or nonClustered index)

- 후보키만 가능 최소한의 고유식별기능(중복이 없어야함)
- 검색 속도는 느리지만 CRUD 부하가 적음
- 정렬 x

|     인덱스      | 속도  | 부하 | 정렬 |
| :-------------: | :---: | :--: | :--: |
| Clustered index | logN  |  큼  |  O   |
| Secondary Index | 2logN | 작음 |  X   |



#### 제약 조건에 따른 index 결정

- Primary Key가 존재하면서 Unique Key가 있다면 `1. pk - Clustered index` `2. uk - Seondary Index`
- Primary Key가 존재 x Unique Key가 있다면 `1. uk - Clustered index`




# DML

- 데이터베이스를 조작하는 언어

### 생성(CREATE) 

```mysql
-- 'kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com' 등록시간
insert into ssafy_member (userid, username, userpwd, emailid, emaildomain, joindate)
values("kimssafy", '김싸피', '1234', 'kimssafy', 'ssafy.com', now());

```

### 읽기(Read)

```mysql
select * from ssafy_member;
```

### 업데이트(UPDATE)

```mysql
-- userid가 kimssafy인 회원의 비밀번호를 9876로 변경하고 이메일 도메인을 ssafy.com으로 변경.
update ssafy_member
set userpwd = '9876', emaildomain = 'ssafy.com'
where userid = 'kimssafy';

```

### 삭제(DELETE)

```mysql
-- userid가 kimssafy인 회원 탈퇴
delete from ssafy_member
where userid = 'kimssafy';

```


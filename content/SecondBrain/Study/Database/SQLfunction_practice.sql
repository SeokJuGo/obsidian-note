
-- 1번 world DB
use world;
-- 2번 훑어보기
show tables;
desc city;
desc country;
desc countrylanguage;
select * from city;
select * from country;
select * from countrylanguage;
-- 3번 WHERE절
SELECT * FROM country
WHERE code='KOR';
-- 4번 WHERE절
SELECT code,name,gnp,gnpold,gnp-gnpold as gnp변동량
FROM country
WHERE gnp-gnpold>0
order by gnp-gnpold;
-- 5번 중복
SELECT distinct continent from country;
-- 6번 concat
SELECT concat(name,'은',region,'에 속하며 인구는',population) as 정보 FROM country
WHERE continent='asia';
-- 7번 oder by, is null
SELECT name,continent,gnp,population
from country
where population>10000 and indepyear is null
order by population desc;
-- 8번 limit
SELECT code, name, population 
FROM country
WHERE population>=100000000 and population<=200000000
order by population desc limit 3;
-- 9번 in function
select * from country
where indepyear in (800,1810,1811,1901) 
order by indepyear,code desc;
-- 10번 포함하는 문자 찾기
select* from country
where region like "%asia" and name like "_o%";
-- 11번 char_length vs length
SELECT char_length("홍길동") as 한글, char_length("hong") as 영문 FROM DUAL;
-- 12번 문자열 찾기
SELECT code,name,GovernmentForm from country
where char_length(name)>=10 and GovernmentForm like '%republic%'
order by name desc limit 10;
-- 13번 or와 문자열 찾기 응용
SELECT code,name FROM country
WHERE code like 'a%' or code like 'e%' or code like 'i%' or code like 'o%' or code like'u%' limit 3;

-- 14번 replace, substring, repeat
SELECT name, replace(name,substr(name,3,char_length(name)-4),repeat("*",char_length(name)-4)) AS gg FROM country;

-- 15번 replace
SELECT distinct name, replace(region," ","_") as  지역들 FROM country
order by char_length(지역들) desc;

-- 16번 round
SELECT name,surfacearea,population,round(surfacearea/population,3) as "1인당 점유면적" FROM country 
where population >=100000000;

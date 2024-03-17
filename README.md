
<div align=center>
	<h3>📚 비동기 방식 활용으로 성능 개선 프로젝트 📚</h3>
</div>
<br><br>

## 🖥️ 프로젝트 소개
공지사항 API에 동기와 비동기를 구분하여 동기 방식에 비해 java completeFuture 비동기 방식의 활용을 통해 성능적으로 개선되는 방법 및 nGrinder 부하테스트를 통해서 성능적으로 향상을 확인하는 프로젝트

<br>

## 프로젝트 상세 페이지
- https://elastic-caraway-da9.notion.site/Asynchronism-Performance-Improvement-Project-921f899003544a7facb562393a1e27e5

<br>

# 📖 프로젝트 환경
* spring boot 2.7.4
* java 11
* ehcache 2.x
* mysql 8.0.33
* Maven
* intellij
* nGrinder

### 사용 공지사항 데이터베이스 테이블

```sql
CREATE TABLE `notice` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `who` varchar(30) DEFAULT NULL,
  `createDate` timestamp NOT NULL,
  `updateDate` timestamp NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_notice_createDate` (`createDate`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb3;
```


## 📌 주요 기능
#### 비동기 방식 vs 동기 방식 성능 비교
- 상황 : 1천건의 데이터를 조회하고 1천건의 데이터를 발송하는 작업에 대해 비교
- 데이터 발송은 sendLog로 대체

- 동기 방식
  - GET : localhost:8080/api/send/logs
  - 결과 : 8.12 s = 8120000ms
    <img width="929" alt="동기 방식 포스트맨" src="https://github.com/BellOne4222/nGrinder_Performance_improvement-By-Using-Ehcache-and-Application_Index/assets/127610150/ab47fa53-4f77-4923-b9b5-6b3dec39183a">
    <br>
  

- 비동기 방식
  - 결과 : 721ms = 721000ms 
  - 동기 방식에 비해 응답시간이 약 11262배 향상
<img width="919" alt="비동기방식 포스트맨" src="https://github.com/BellOne4222/nGrinder_Performance_improvement-By-Using-Ehcache-and-Application_Index/assets/127610150/79dbeade-d0a5-41f1-9980-d18f016d2103">
  

#### 비동기 방식 vs 동기 방식 성능 비교
- nGrinder를 통한 부하 테스트
- 동기 방식
  - Vuser(가상 사용자) : 2
  - Duration : 1분
<img width="887" alt="동기 방식 ngrinder" src="https://github.com/BellOne4222/nGrinder_Performance_improvement-By-Using-Ehcache-and-Application_Index/assets/127610150/c682a799-1017-4922-912f-38b26e7fe7ba">  
- 비동기 방식
  - Vuser(가상 사용자) : 2
  - Duration : 1분
    <img width="899" alt="비동기 방식 ngrinders" src="https://github.com/BellOne4222/nGrinder_Performance_improvement-By-Using-Ehcache-and-Application_Index/assets/127610150/5f8d637b-d555-4d8f-84ed-bc34a843e32b">

- 수치 변화
  - 평균 TPS : { 0.2 } → { 32.4 }
  
  - Peek TPS : { 1.0 } → { 105.5 }
  - Mean Test Time : { 7313 } ms → { 57.03 }ms
    - 평균 테스트 시간은 약 128배 단축
  - Exected Tests : { 8 } → { 1813 }
    - 테스트 수행 수도 약 227배 증가함을 알 수 있다.
  - 평균 테스트 시간이 크게 단축되고, 테스트 수행 수도 증가함에 따라 동기 방식보다 비동기 방식을 활용 할 때 성능이 향상됨을 알 수 있다.











# wanted-pre-onboarding-backend

프리온보딩 백엔드 인턴십 선발과제

## 개발환경
- Java 17
- Spring Boot 3.X
- MySQL 8.0
- JPA
- Docker
- SwaggerUI

## 요구사항 분석 및 구현 과정
#### 0. 기능 구현 전 설정

Docker를 이용한 DB 연동

[schema.sql](https://github.com/daulkim/wanted-pre-onboarding-backend/blob/main/src/main/resources/data.sql)를 통해 테이블 생성 & [data.sql](https://github.com/daulkim/wanted-pre-onboarding-backend/blob/main/src/main/resources/data.sql)를 통해 회사와 사용자 데이터틑 생성

ControllerAdvice를 이용한 공통에러처리

SwaggerUI를 통한 API 명세


#### 1. 채용공고 등록
회사는 아래 데이터와 같이 채용공고를 등록
```
{
  "회사_id":회사_id,
  "채용포지션":"백엔드 주니어 개발자",
  "채용보상금":1000000,
  "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "사용기술":"Python"
}
```
#### 2. 채용공고 수정
회사는 채용공고를 수정 가능(회사 id 제외 모든 필드)
```
{
  "채용포지션":"백엔드 주니어 개발자",
  "채용보상금":1500000, # 변경됨
  "채용내용":"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", # 변경됨
  "사용기술":"Python"
}
```
#### 3. 채용공고 삭제
DB에서 데이터 삭제

post와 user_application 테이블의 fk 설정으로 지원자가 있는 경우 삭제되지 않음 

-> 추후 공고 마감일을 추가하여 DB에서 데이터를 삭제하는 대신 마감하는 방향으로 수정 필요할 것으로 판단됨

#### 4-1. 채용공고 목록 조회 & 4-2. 채용공고 검색
아래와 같이 채용공고 목록 조회

QueryDsl의 이용하여 [동적쿼리](https://github.com/daulkim/wanted-pre-onboarding-backend/blob/24f35b6f21e36ccec941c46b8ccf53608a5cc978/src/main/java/com/wanted/pre_onboarding/recruitment/post/domain/PostRepositoryCustomImpl.java#L28) 생성
keyword가 있을 때 회사명과 채용포지션에 keyword가 포함되는 공고만 조회

```
[
  {
    "채용공고_id": 채용공고_id,
    "회사명":"원티드랩",
    "국가":"한국",
    "지역":"서울",
    "채용포지션":"백엔드 주니어 개발자",
    "채용보상금":1500000,
    "사용기술":"Python"
  },
  {
    "채용공고_id": 채용공고_id,
    "회사명":"네이버",
    "국가":"한국",
    "지역":"판교",
    "채용포지션":"Django 백엔드 개발자",
    "채용보상금":1000000,
    "사용기술":"Django"
  },
  ...
]
```
#### 5. 채용 상세 페이지 조회
아래 데이터와 같이 채용 상세 페이지 조회
* 목록조회와 달리 채용내용이 추가됨
* 해당 회사가 올린 다른 채용공고 목록이 추가됨

조회 시 company와 [fetchJoin](https://github.com/daulkim/wanted-pre-onboarding-backend/blob/24f35b6f21e36ccec941c46b8ccf53608a5cc978/src/main/java/com/wanted/pre_onboarding/recruitment/post/domain/PostRepositoryCustomImpl.java#L19)을 통해 한번에 조회 후 공고 id와 조회된 공고의 회사id로 해당 회사가 올린 [다른 공고 조회](https://github.com/daulkim/wanted-pre-onboarding-backend/blob/24f35b6f21e36ccec941c46b8ccf53608a5cc978/src/main/java/com/wanted/pre_onboarding/recruitment/post/service/PostService.java#L41C61-L41C61)(해당 공고를 제외)

```
{
  "채용공고_id": 채용공고_id,
  "회사명":"원티드랩",
  "국가":"한국",
  "지역":"서울",
  "채용포지션":"백엔드 주니어 개발자",
  "채용보상금":1500000,
  "사용기술":"Python",
  "채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "회사가올린다른채용공고":[채용공고_id, 채용공고_id, ..] # id List (선택사항 및 가산점요소).
}
```
#### 6. 채용공고 지원
사용자는 채용공고에 지원(한 공고에 1회만 지원 가능)

[checkDuplicated](https://github.com/daulkim/wanted-pre-onboarding-backend/blob/24f35b6f21e36ccec941c46b8ccf53608a5cc978/src/main/java/com/wanted/pre_onboarding/recruitment/user_application/service/UserApplicationService.java#L21C18-L21C33)로 지원 전 해당 공고에 이미 지원 했는지 체크
```
{
  "userId" : 1,
  "postId" : 1
}
```

## ERD
![wanted-pre-onboarding-backend-4](https://github.com/daulkim/wanted-pre-onboarding-backend/assets/73690073/32be6585-bb5f-43db-9d57-3ae1a9be8eaf)


## 실행방법
```
cd docker
docker-compose -p wanted -d
cd .. 
./gradlew bootRun
```

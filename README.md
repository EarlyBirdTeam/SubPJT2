# Sub Project1

> Spring과 Vue를 사용하여 로그인, 회원가입 등의 기초로직을 수행하는 프로젝트 설계하기

## API 문서
- Swagger 문서 URL : http://localhost:8080/swagger-ui.html

## Wireframe 

- 로그인

![image](https://user-images.githubusercontent.com/23401317/88033757-b321b200-cb7a-11ea-90cb-c8d490f7cf2b.png)

- 메인1

![5반_10팀_프로젝트1_와이어프레임_메인1](/uploads/a362e2da26b464a0599da301be6ee12d/5반_10팀_프로젝트1_와이어프레임_메인1.png)

 - 메인2

![5반_10팀_프로젝트1_와이어프레임_메인2](/uploads/ebd623981162e05f33e23f231a882a4c/5반_10팀_프로젝트1_와이어프레임_메인2.png)

 - 모임 관리 페이지

![image](/uploads/d750cae26380b2e6172b96a180205e7f/image.png)

 - 모임생성

![5반_10팀_프로젝트1_와이어프레임_모임생성](/uploads/901954942f0220864eb4464cf3ee3d25/5반_10팀_프로젝트1_와이어프레임_모임생성.png)

## 셋업

### 1. 로컬로 클론

```
$ git clone https://lab.ssafy.com/s03-webmobile1-sub2/s03p12a510.git
```

### 2. Vue 환경 설정 및 패키지 설치

```
$ npm install
$ npm install --save vue-cookie
$ npm install --save js-cookie vuex-persistedstate
```

### 3. 데이터베이스 세팅

```
$ docker -v
$ docker run --name maria-db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mariadb -d mariadb
$ docker exec -it maria-db mysql -u root -p
```

데이터 베이스에 ssafy 테이블 추가
```
$ create database ssafy;
```

## 실행

### Frontend 실행

```
$ npm run serve
```



- 가장 최상단 URL 에 **Swagger 문서 자동 생성**


### 개발 환경

- Spring Boot

  - Spring Data JPA
  - Hibernate

- Vue 

  - vue cli
  - vue router
  - vuex

- Database

  - docker (MariaDB)

  
## 구성

### File

- user
  - Join
  - JoinDone
  - Login
  - MyPage
- post
  - List
- etc
  - e404
  - error

### URL
- root
  - user
    - join
    - joinDone
    - MyPage
- 404
- error

### HTTP Req

- /account (POST) : 사용자 정보 조회
- /account (PUT)  : 사용자 정보 수정
- /account/delete (PUT) : 사용자 정보 삭제
- /account/login (GET) : 로그인
- /account/signup (POST) : 회원 가입

## 진행

### 회원 관리

- 회원 가입 /user/join
  - 입력 필드는 닉네임, 이메일, 실명, 비밀번호로 구성.
  - 이메일과 비밀번호는 각각 정규 표현식을 정의하여 진행함.
  - 각 input이 공란일 경우 경고 메세지 출력
  - 확인용 비밀번호가 다를 경우 경고 메세지 출력
  - 정상적으로 입력이 끝나면 가입 완료 페이지로 이동하며 가입 메일이 발송됨.

- 회원 가입 완료 /user/joinDone 
  - 가입 메세지가 발송되었다는 문구와 함께 SMTP GMAIL 발송.
  - 돌아가기 버튼을 누르면 메인 화면으로 돌아감.

- 로그인 로그아웃 / 
  - 해당 페이지는 메인(List) 페이지에 Modal Component 로 구현하였음.
  - 계정 정보를 입력하고, 계정 확인이 완료되면 {"Logged":"email"} 형태로 계정 정보가 저장되며, 로그인 완료.
  - 계정이 틀릴경우 경고 메세지가 출력됨.
  - 헤더의 로그인 버튼은 로그인 상태가 되면 회원 정보 페이지로 이동할 수 있는 계정 버튼과 로그아웃 버튼으로 전환됨.
  - 로그아웃 버튼을 누르면 저장된 계정 정보가 폐기 되며 메인(List) 페이지로 이동.

- 회원 관리 /user/MyPage 
  - 회원 관리가 가능
  - 가입 시 입력했던 정보를 수정할 수 있음.
  - 이메일 정보는 수정이 불가능.
  - 페이지 진입시 자동으로 계정 정보가 입력됨.
  - 비밀번호는 보안상 입력되지않음.
  - 닉네임과 비밀번호, 이름을 수정하고 '회원정보 수정' 버튼을 눌러 수정이 가능.
  - 비밀번호를 정확히 입력하고 회원 탈퇴 버튼을 눌러 회원 정보 삭제가 가능.
  - 삭제 후 메인(List) 페이지로 이동.


### 에러 페이지

- e404 /* 
  - 명시된 주소 외에 접근 할 경우 이동되는 페이지.
  - 잘못된 주소임을 명시해줌.
  
- error /error
  - 웹 이용 중 에러 코드 발생 시 이동하는 페이지.
  - 요청 오류가 발생함을 알리고, 해당 에러 코드를 표시함.

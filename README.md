# weather-forecast

## 1. Introduce

### 프로젝트 명

(대학생에게 유용한) 캠퍼스 복합정보 날씨 웹 어플리케이션

### 작품명

지금 한신은

### 개발 동기

시중에 나와 있는 날씨 앱들이 가득하지만 대학생인 나와 밀접하게 연관되어있는 장소인 캠퍼스를 갈 때마다 본가인 수원의 날씨와는 조금 다른 느낌이 들었다. 아침에 캠퍼스위치가 아닌 현위치 날씨를 확인하였기 때문이다. 캠퍼스 날씨 정보는 대략 파악한 후 등교했던 것 같다. 캠퍼스 위치에 대한 날씨정보를 접하더라도 온도로는 정확히 체감할 수 없기에 날씨에 맞는 적절한 옷차림을 하지 못했던 적도 많다. 예를 들어, 생각보다 현재  온도에 비해 덥게 입었을 때, 춥게 입었을 때가 있다. 그리고 학교 홈페이지를 들어갔을 때 날씨 알림화면이 있으면 좋겠다는 생각을 하였다. 각 홈페이지마다 날씨정보가 있다면 좋지 않을까라는 생각을 해보았다. 이 뿐만 아니라 현대인에게 날씨정보는 정말 큰 정보다. 그래서 캠퍼스 날씨 웹 어플리케이션을 만들기로 했다.

### 개발 목적

날씨 정보는 다른 여타 정보들보다 인간의 삶의 양식에 매우 영향을 미치는 생활밀착형 정보로써 과거 단순한 기상 정보만을 전달하던 특성을 넘었으며 지금은 모바일 앱을 통해 삶의 질을 높이는 응용요소로 적용되고 있는 상황이다. 실제로 스마트폰 이용시 사람들이 가장 많이 사용하는 어플 순서로는 통화, 메신저, SNS 다음으로 ‘날씨’를 선택한다.  

![image](https://user-images.githubusercontent.com/86752528/207083296-55ea7a37-52ec-4486-b793-91bf554ee03b.png)
![image](https://user-images.githubusercontent.com/86752528/207083336-3c22166d-d86c-4bf5-a91a-ec670d893b05.png)

이를 종합해본다면 현대인은 스마트폰을 이용해 기상예측정보를 중요하게 여기고 있음을 알 수 있다. 또한 인간은 모바일 및 다양한 스마트 기기를 통해 과거보다 정확한 기상정보를 알고 대비할 수 있는 상황에도 불구하고, 인간은 자신의 고정관념과 잘못된 기억을 사용하여 판단오류를 내리는 경우가 있어 날씨로 인한 손실을 모두 피하지 못하고 있다는 논문 을 참고해 보았을 때 날씨정보를 알려줄 때 사용자에게 더욱 효과적이고 날씨에 관련한 정보까지 서비스 해 줄 필요가 있다고 생각하였다. 예를 들면, 날씨에 맞는 옷차림과 날씨에 맞는 음악 같은 것이다.

### 관련 조사

국내 대학교 사이트를 검색해 보았으나 각 사이트마다 날씨 정보가 없다. (검색 통해서 확인함). 캠퍼스에 등교하여 캠퍼스 날씨를 알고 싶을 때가 분명 있을 것이다. 또한 대학생들의 관심사인 음악, 패션을 접목한 웹사이트를 만들면 괜찮지 않을까 하는 생각이 들었다. (아래 순서대로 서울대, 연세대 홈페이지화면)

그리고 날씨를 자주 확인하는 현대인의 특성을 고려하였을 때 날씨 웹앱에 대학생들이 가장 관심 있어 하는 콘텐츠들을 같이 넣으면 효과적일 것이라고 생각했다. 날씨가 주된 콘텐츠이지만 이 안에 종합 컨텐츠를 넣어보고자 하였다. 생각해낸 주제는 패션과 음악이다.

### 그 외

1. 패션
현대인은 의상을 고르는데 들어가는 스트레스가 많다. 각종 스트레스의 바다에 살면서 수많은 정보를 고려하고 선택해야 한다. 이런 상태에서의상을 고르는 데 들어가는 시간을 최대한 줄여 주고 적합한 의상을 추천해줌으로써 높은 만족도와 날씨에 따라 발생하는 질병을 예방하는 서비스가 필요한 시점이다.

2. 음악
대학생들은 대부분 이동시 무선이어폰을 착용하고 이동하는 모습들을 많이 볼 수 있을 것이다. 캠퍼스 학생들 대부분 음악을 자주 듣는다. 음악은 대학생들이 관심있는 콘텐츠임은 분명하다.

3. 캠퍼스 전화번호부 검색
대학교 커뮤니티 어플인 ‘에브리타임’을 들어가면 간혹 캠퍼스 전화번호를 물어보는 글들이 올라온다. 해당부서에 대한 전화번호를 물어보는 글, ‘031-379-XXXX’ 전화번호는 어디부서 전화번호 인지 물어보는 글이 대부분이다. 대학생들에게는 관련 캠퍼스 내 부서 전화번호정보를 편하게 알려줄 수 있는 것이 필요하다고 생각하여 이를 참고했다. 한신대 내 학생들이 더욱 참여하기 위해 캠퍼스 학생 인원들 학교 전화번호 잘 알지 못하는 상황이다. 한신대 전화번호부를 검색할 수 있도록 한다면 많은 이들에게 필요할 것이다.  
캠퍼스홈페이지 안에도 전화번호 검색목록이 있는 것을 확인했지만 보다 유용하고 편리하게 사용할 수 있는 전화번호부 검색창을 만들기로 하였다.

## 2. Contents

### 주요 기능

#### 한신대 지역 날씨 서비스
- 캠퍼스 지역 특화 날씨알림
- 날씨별로 다른 테마로 날씨 알림 (낮,밤,흐림,비,눈)
-  최대 3일까지 날씨예보 확인가능
-  날씨관련 여러 정보 제공

#### 날씨별 옷차림 추천 서비스
- 현재 날씨에 맞는 옷차림 추천 기능
-  옷 사이트 연결 기능
-  남성ㆍ여성 나누어 옷차림 추천 기능

#### 날씨별 노래 추천 서비스
- 날씨별 노래 추천 서비스 
- 노래영상 유튜브 연결기능 

#### 한신대 전화번호부 검색 서비스
-  카테고리(소속, 세부소속, 전화번호)구분 없이 한신대 전화번호 검색 기능
-  전화번호 목록 클릭 시 상세페이지 열람
-  상세페이지 내용 : 소속, 세부소속, 이름, 전화번호, 실번호

### 비주요 기능
-  통일성 ‘sans-serif’체 이용하여 정보 효과적으로 전달함. (배경, 폰트색, 하이라이트색)
-  정보의 중요도에 따라 글씨 크기와 굵기를 달리 함
-  심플함, 통일성 강조
-  온도별 코디(옷차림)추천 통해 그 날 입을 적절한 옷차림 알림

## 3. TEAM

### 팀명

수원별  
팀원의 이름이 백연수, 김재원, 안나별이다. 각 이름의 끝자를 나열시키면 ‘수원별’이라는 닉네임이 만들어진다. 그리고 세명 모두 수원에 거주하고 있기 때문에 수원별이라는 이름을 짓게 되었다.

### 업무 분담

#### 안나별
- 일정 조율 및 프로젝트 설계 작업주도
- 기상청 API 분석
- 하계 프로젝트, 공모전 프로젝트 지원서 및 결과보고서 작성.
- 회의 진행 및 일정 수립.
- 개발 진행시 피드백 진행.

#### 백연수
- figma 이용한 디자인기획 및 프로토타입 개발 수행
- 날씨 화면구성, 옷차림, 음악페이지 구성 및 JSON연동
- 깃허브 공동 레포지토리 관리
- 한신대 전화번호부 검색기능 구현
- 결과물 시연 동영상 제작 

#### 김재원
- 기상청 API 분석 및 데이터시트 작성
- 기상청 API에서 데이터를 받아올 모듈 설계 및 구현
- 데이터베이스 설계 및 쿼리 작성
- 데이터베이스에 기상청 데이터 입력
- 데이터테이블을 스프링부트 엔티티로 객체화
- 프론트엔드에서 데이터를 받아올 수 있는 RestAPI 구현
- API 웹 서버 세팅 

### 수행 일정

#### 안나별 
- 7월: 계획 , 하계프로젝트 보고서 
- 8월: SpringBoot 공부, 하계프로젝트 보고서 작성, rest api공부
- 9월: 기획, project Manager 관련 공부
- 10월: 결과보고서작성 및 일정조율 

#### 백연수
- 7월: 서비스 기획, 디자인
- 8월: Vue.js 공부
- 9월: 프로그래밍 시작, 메인페이지 제작
- 10월: 서브페이지 제작, API 연결

#### 김재원
- 7월 : 스프링부트 강좌 시청
- 8월 : DB 및 API 설계
- 9월 : 백엔드 코드 구현 시작
- 10월 : API 모듈 제작, 프론트엔드와의 연결 구현

### 커뮤니케이션

기본적인 소통창구는 카카오톡 채팅방을 이용하였다. 개발문서 관리 및 버전 관리는 깃허브를 사용하여 관리하였고 각자의 브랜치에서 커밋한 파일을 올릴 때 나머지 팀원이 전부 승인해주면 메인브랜치에 올라가는 풀리퀘스트 방식을 이용하였다. 또한 커밋시 커밋 메시지도 통합하는 시간을 가짐으로써 문서내용 확인 및 효과적인 관리법에 힘을 더했다. 1주일에 한번은 만남을 가짐으로써 프로젝트에 대한 생각과 개발을 이어나가고자 하였습니다.  
오프라인 만남이 어렵거나 꼭 필요하지 않는 상황이라면 구글미트를 적극적으로 이용하여 회의 진행하고 어려운 점에 대해 이야기 하였습니다.

## 4. Development

### 개발 환경

#### 코드 관리
GitHub

#### 디자인 툴
figma

#### 프론트엔드 사용 언어 및 프레임워크
HTML, CSS, JavaScript, Vue.js, SCSS

#### 백엔드 사용 환경
SpringBoot 2.7, Gradel, MariaDB, Mysql

#### 스프링부트 의존성 목록
lombok 1.18, junit 5.8, mysql-connector-java, spring-boot-starter-data-jpa,
jdbc:mariadb-java-client, spring-boot-starter-test, querydsl, json-simple 1.1

#### OS
Ubuntu 22.04 LTS 

#### 웹 서버
Apache Tomcat&Nginx 1.18

### 시스템 구성도

![image](https://user-images.githubusercontent.com/86752528/207088002-3db1bf97-cd3c-4f67-8570-fdc70e90434d.png)

## 5. Result

### 프론트엔드

![image](https://user-images.githubusercontent.com/86752528/207088312-42cde261-70fe-4cf2-9bb6-cefc01c3339f.png)

| 맑음(낮) | 맑음(밤) | 흐림 | 비 | 눈 |
| --- | --- | --- | --- | --- |
| ![image](https://user-images.githubusercontent.com/86752528/207088563-c0775e02-083c-4840-9112-ff061fee4dc4.png) | ![image](https://user-images.githubusercontent.com/86752528/207088585-89cef343-ebca-43cf-9d14-6c5a276d89cf.png) | ![image](https://user-images.githubusercontent.com/86752528/207088600-4a824521-0343-4d5a-b2cb-5e7691e5c77e.png) | ![image](https://user-images.githubusercontent.com/86752528/207088618-49e3c86e-e5f0-4140-b04f-73ac640daa23.png) | ![image](https://user-images.githubusercontent.com/86752528/207088635-661b2cae-7624-4165-ad30-d1b63c96a928.png) |

![image](https://user-images.githubusercontent.com/86752528/207088782-e4c12395-e934-4acf-990d-7f0ccb7ccb4a.png)  
![image](https://user-images.githubusercontent.com/86752528/207088807-db470b58-a6fa-4000-bf31-35cd6bee213a.png)  
![image](https://user-images.githubusercontent.com/86752528/207088834-ef697f57-ba3a-4a18-b668-6d807c2f80d3.png)  

### 백엔드

![image](https://user-images.githubusercontent.com/86752528/207088902-3444ee63-1af7-485e-954d-60dd8dd21212.png)
![image](https://user-images.githubusercontent.com/86752528/207088925-2eb7e708-8f12-4f8f-ad59-f57a3525807c.png)  
![image](https://user-images.githubusercontent.com/86752528/207088948-3961e81e-9a84-475b-bc0a-9c1de572ae4a.png)
![image](https://user-images.githubusercontent.com/86752528/207088983-3c7c03dd-5b21-4642-b12c-7d0319538f55.png)  
![image](https://user-images.githubusercontent.com/86752528/207089016-a290773e-5b26-4713-93cf-232c940383ba.png)
![image](https://user-images.githubusercontent.com/86752528/207089037-14ffafea-5f31-4ff4-a2bb-6d6f96d311b7.png)  




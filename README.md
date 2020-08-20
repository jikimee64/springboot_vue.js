# Toy Project

Spring Boot And Vue.js 를 사용한 토이프로젝트

## 목표

1. Spring Boot, Spring data JPA로 서버를 구성한다.
2. Vue.js로 클라이언트를 구성한다.

## 주제

회원제 게시판을 구현한다.

## 구현

### 서버

#### Server 사용기술

- Spring Boot
- Spring data JPA(Hibernate)
- Maria DB
- Spring Security

#### Server 제작 내용

- 회원제 게시판 제작을 목표로 한다
- 댓글은 무한계층형으로 구현하고 삭제시 동일 노드의 게시물이 모두 삭제 되도록 만든다.
- 오픈소스 에디터를 적용한다.
- 게시물, 댓글 검색기능을 적용한다.
- 회원 가입시 유효성 검사는 client, server 모두에서 진행
- 스프링 시큐리티를 통해 가입, 로그인, 비밀번호 암호화등을 적용한다.
- HTTP API(REST)로 서버와 클라이언트가 JSON 데이터를 주고 받는다
- JWT를 통해서 사용자 인증을 진행한다

### Vue.JS 클라이언트

View를 작성하는데 이용되는 자바스크립트 기술의 이해를 위해 상대적으로 진입장벽이 낮은 Vue.js를 이용한다.


#### Vue.JS Client 사용기술

- vue.js 2
- vuex: 상태 관리
- vue-router: SPA 라우팅
- axios: HTTP client
- [vuetifyjs CSS](https://vuetifyjs.com/ko/): CSS만 사용


#### Client 제작 내용

- vuex를 사용하여 상태관리를 한다
- props를 통해 컴포넌트간 데이터를 전송한다
- axios를 이용하여 서버와 HTTP 통신을 수행한다

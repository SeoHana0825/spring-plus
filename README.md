# CH5 SPRING PLUS
#### 코드 개선 및 N+1 문제, Security, QueryDSL, 배포까지의 흐름 이해 과제

---
### 1. 과제 목표

---
### 2. 과제 내용

#### Lv1. 코드 개선

- ```@Transactional```의 이해
  - 할 일 저장 기능 (POST) api 호출 에러 발생
  - 에러를 해결하고 할 일을 정상적으로 저장 할 수 있도록 코드 수정하기

- ```JWT```의 이해
  - ```User``` 정보에 ```nickname``` 컬럼 추가 요청
  - 프론트엔드 개발자가 ```JWT```에서 유저의 ```nickname```을 꺼내 화면에 보여주길 원함
    - ```nickname```은 중복 가능

- ```JPA```의 이해
  - 할 일 검색 시 ```weather``` 조건으로도 검색할 수 있고
  - 할 일 검색 시 ```수정일 기준 (Update date)``` 으로 기간 검색 가능
  - ```JPQL```을 사용하고, 쿼리 메소드명은 자유롭게하지만 너무 길지 않게 주의
    - ```weather``` 과 ```기간의 시작과 끝``` 은 있을 수도, 없을 수도 있음
    - 필요에 의해 ```if```문을 사용해 여러 개의 쿼리를 처리해도 됨

- 테스트코드 : 컨트롤러 테스트의 이해
  - 테스트 패키지의 ```controllerTest```의 ```단건 조회 시 예외``` 테스트 실패,
  테스트가 정상적으로 수행되어 통과되게 수정

- ```AOP```의 이해
  - ```UserAdminController``` 클래스의 ```changeUserRols()``` 메소드가 **실행 전** 동작 필요
  - ```AdminAccessLoggingAspect``` 클래스에 있는 AOP를 개발 의도에 맞게 수정

- 트러블슈팅 : https://velog.io/@onnuri1226/트러블슈팅-Spring플러스-Lv1-필수-코드-개선

#### Lv2. Security, QueryDLS 이해하기

- ```JPA Cascade``` 활용
  - 실수로 코드를 지웠다!
  - 할 일을 새로 저장 시, 할 일을 생성한 유저는 **담당자**로 등록
  - ```JPA Cascade``` 기능을 활용

- ```N+1``` 문제 해결
  - ```CommentController``` 클래스의 ```getComments()``` api 메소드 호출 할 때 N+1 문제 발생

- ```QueryDSL``` 활용
  - JPQL로 작성된 ```findByWithUser```를 QueryDSL로 변경
    - N+1 이 발생하지 않도록 주의!

- spring Security
  - 기존 ```Filter```와 ```Argument Resolver```을 사용하던 코드들을 ```Spring Security```로 변경
    - 접근 권한, 유저 권한 기능은 유지
    - 토큰 기반 인증 방식 유지 (JWT 유지)

- 트러블슈팅 : https://velog.io/@onnuri1226/트러블슈팅-Spring플러스-Lv2-필수.-Security-QueryDSL

#### Lv3. QueryDLS 검색기능구현, Transaction 심화, AWS, 대용량 데이터 처리


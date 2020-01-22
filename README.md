# CRUD-board-basic
## 학습 내용 정리
* * *
### 20.01.22 
* * * 
#### Junit4 Test
* review list 테스트코드 수정

* * *
### 20.01.21 
* * * 
#### Junit4 Test
* review 테스트

* * *
### 20.01.20 
* * * 
#### Junit4 Test
* getMenuItems 서비스 구현

* * *
### 20.01.19 
* * * 
#### Junit4 Test
* getMenuItems 테스트 추가


* * *
### 20.01.18 
* * * 
#### [Gradle을 이용한 멀티모듈](https://jojoldu.tistory.com/123) - 5
* 역할 분리 마무리 및 전체 테스트 통과


* * *
### 20.01.17 
* * * 
#### [Gradle을 이용한 멀티모듈](https://jojoldu.tistory.com/123) - 4
* 역할에 맞춰 코드 제거 및 생성


* * *
### 20.01.16 
* * * 
#### [Gradle을 이용한 멀티모듈](https://jojoldu.tistory.com/123) - 3
* common, api, customer 분할
  
  
* * *
### 20.01.15 
* * * 
#### [Gradle을 이용한 멀티모듈](https://jojoldu.tistory.com/123) - 2
* common 모듈 설정
    * 아래 jar 파일 설정을 해줘야 타 모듈에서 common 모듈을 호출할 때 이슈 없이 작동한다.
    ```
    bootJar {
        enabled = false
    }
    jar {
        enabled = true
    }
    ```

* * *
### 20.01.14 
* * * 
#### [Gradle을 이용한 멀티모듈](https://jojoldu.tistory.com/123) - 1
* 멀티 모듈이 생긴 이유
    * 대부분의 서비스는 단일 프로젝트로 구성되는 일이 거의 없습니다.
아무리 작게 구성해도 일정 수준 이상의 트래픽을 감당하려면 사용자와의 접점을 담당하는 서버(이하 web프로젝트라고 하겠습니다.), DB와의 접점을 담당하는 서버(api프로젝트라 칭하겠습니다.)로 구분하여 구성하게 됩니다.
이럴 경우 고민이 되는 것이 그럼 web과 api 모두에서 사용되는 클래스들은 어떻게 다룰 것인가 입니다. (공통으로 사용되는 클래스는 Member 클래스)
   * ![공통 사용 영역](https://github.com/jojoldu/blog-code/raw/master/gradle-multi-modules/images/%EC%84%9C%EB%B2%84%EA%B5%AC%EC%84%B1.png)

    * 가장 쉽고 흔한 방법은 복사 & 붙여넣기입니다.
한 프로젝트에서 Member 클래스파일을 생성하고 이를 다른 프로젝트에서 코드를 복사하는 방식입니다.
하지만 이럴 경우 연동되는 프로젝트가 늘어날 경우, 혹은 Member 클래스의 코드에 수정이 필요할 경우에 정말 많은 양을 수정해야하고 실수할 여지가 많아집니다. 이러한 문제점을 Gradle을 이용해 멀티모듈방식으로 해결할 수 있습니다.

#### [멀티모듈의 문제점](http://woowabros.github.io/study/2019/07/01/multi-module.html)
* common은 의존성이 존재해서는 안된다.

* * *
### 20.01.13 
* * * 
#### 회사 11시 퇴근으로 인한 이론 스터디 휴무
* 딥슬라이드 개발 진행 - 결제기능, 모델 아이디 삽입, 충돌 정리, 인트로 설정
* DT-161, DT-158, develop 정리 완료

* * *
### 20.01.12 
* * * 
#### [하루종일 집에서 명상음악 들으면서 업무, 스터디 리뷰](https://www.youtube.com/watch?v=nKHBIAdBvZ4&list=PLLnunhcTXCPK-PTCT-3SeUllA-EK9Zwjj&index=8&t=2625s)
* 지난 5일간 업무 진행내역 확인
* 지난 5일간 스터디 내역 확인
    * 다음주 부터는 매 주 일요일마다 월~토 학습내역 총정리해서 하나로 묶기

* * *
### 20.01.11 
* * * 
#### 모듈 분리
* 프로젝트 모듈화를 통한 역할 분리 작업
    * 모듈 생성하기
        1. (Root Project) alt + n
        1. New
        2. Module
        3. Gradle/Java
        4. ArtifactId : module name
        5. finish

    * 모듈별 필요한 클래스 이동(IntelliJ 기능)
        1. 옮기려는 패키지 오른쪽 클릭
        2. Refactor
        3. Move Package or Directory
        4. 3가지 선택지 중 필요한 형태의 옵션 선택하여 클래스 위치 변경

    * 모듈 포함시키기
        * project에 module 포함시키기
            1. root directory
            2. settings.gradle
            3. include 'module name'
            * tip - 주로 공통으로 사용되는 모듈은 최상단으로 올려준다.
        
        * module에서 다른 module 포함시키기
            1. build.gradle
            2. in dependencies
            3. implementation project(':module name')
            * example
                ```
                dependencies {
                    implementation project(':ordering-common')
                }
                ```

    * 분리된 모듈별 테스트 셋팅
        1. edit configuration
        2. Add Junit4
        3. Tesk kind : all Package
        4. Search for tests : in single module
        5. User classpath of module : 사용 할 테스트 클래스 패스


* * *
### 20.01.10 
* * * 
#### [spring - open seesion in view](https://kingbbode.tistory.com/27) - 3
* open session in view를 이해하기위한 지식 - 영속성을 갖는 객체의 상태
    * 영속성을 갖는 객체의 상태
        * Persistence
            * 데이터베이스 식별자(primary key)를 가지며, 작업 단위 내에서 영속성에 의해 관리되는 상태(추가 설명 보강)
                > Transaction 안에서 조회, 저장, 수정 등을 통해 가져온 영속성이 부여된 상태를 Persistence 상태라 하며, Transient 상태의 객체도 강제로 Persistence 상태로 전환시킬 수 있습니다.
            
        * Detached
            * 데이터베이스 식별자를 가지지만 영속성 컨텍스트로부터 분리되어 더이상 데이터베이스와의 동기화가 보장되지 않는 상태
                > Session.close() 메소드는 Session을 닫고 영속성 컨텍스트를 포함한 모든 자원을 반환하며, 관리하에 있는 모든 영속성 인스턴스를 Detached 상태로 변경시킵니다. Hibernate는 Detached 상태의 객체에 대해서는 변경사항을 추적하지 않으며, 따라서 데이터베이스와의 동기화 또한 수행하지 않습니다.

        * Transient
            * 아무 상태도 가지지 않는 상태(무 상태를 정의하기 위한 상태)
                > new 연산자를 사용하여 생성한 객체는 곧바로 Persistence 상태가 되지 않고 Transient 상태를 갖게 됩니다.

        * Removed
            * 제거될 상태
                > Transaction이 종료되는 시점에 삭제될 객체는 Removed 상태를 갖습니다.
        * ![상태 그래프](https://kingbbode.github.io/images/2016/2016_12_28_OPEN_SESSION_IN_VIEW/status.png)


* * *
### 20.01.09 
* * * 
#### [spring - open seesion in view](https://kingbbode.tistory.com/27) - 2
* open session in view를 이해하기위한 지식 - 영속성 컨텍스트
    * 정의
        * Hibernate는 도메인 레이어 객체들이 하부의 데이터 저장소와 영속성 메커니즘에 대해 알지 않아도 되는 _투명한 영속성(transparent persistence)_ 을 제공하는 _비침투적인(nonintrusive)_ 프레임워크입니다.

        * 영속성과 관련된 모든 관심사는 도메인 객체로부터 격리된 채 관리자 객체에 의해 투명하게 처리되는데, 이 관리자 객체의 기능을 담당하는 객체가 Hibernate의 _Session 객체_ 이며, _Sesstion 객체_ 는 _영속성 컨텍스트_ 를 포함한다.

        * 영속성 컨텍스트를 이애하기 위해서는 _Transaction_ 을 이해하고있어야한다. _Transaction_ 은 쪼갤 수 없는(아토믹한) 업무처리의 단위로, 작업의 원자 단위라고 보면되며, 영속성 컨텍스트는 _Transaction_ 과 1:1로 연결된다.

        * 하나의 _Transaction_ 동안 수정된 객체의 모든 상태는 영속성 컨텍스트 내에 저장되어, _Transaction_ 이 종료될 때 데이터 저장소에 동기화(flushing)된디ㅏ. 따라서 Hibernate Session을 하나의 작업 단위 동안 생성 및 조회, 수정, 삭제되는 객체의 상태를 보관하는 일종의 _캐시_ 로 간주해도 무방하다. - 실제로 Hibernate Sesstion을 _1차 캐시_ 라고 부르기도 한다.

    * Transaction 예제
        *   ```Java
            @Transactional
            public void moveTeam(Long memberIdx, Team team){ 
                Member member = memberRepository.findOne(memberIdx);
                member.moveTeam(team);
            } 
            ```
        * 위 moveTeam 메서드가 실행될 때 @Transactional 어노테이션에 의해 자동으로 Hibernate Sesstion이 열리게 된다. 조회(findOne)을 통해 가져온 Member 객체는 영속성 컨텍스트에 캐쉬되고, Transaction 동안 Member 객체의 변경 사항이 추적된다.  이 때 Member 객체는 영속성을 갖는다고 말한다. moveTeam에 의해 영속성을 갖는 Member 객체가 변경된 것을 영속성 컨텍스트가 감지하게 된다. Transaction이 종료되는 시점인 메서드 종료 시점에 영속성 컨텍스트가 캐시하고 있는 변경 상태를 저장소와 동기화하게 되며, 이때 update 쿼리가 자동으로 실행된다.
        
        
* * *
### 20.01.08 
* * * 
#### [spring - open seesion in view](https://kingbbode.tistory.com/27) - 1
* 정의
    * 영속성 컨텍스트를 뷰 렌더링이 끝나는 시점까지 개발한 상태로 유지하는 것

    * 객체-관계 매핑(ORM, Object-Relational Mapping)의 사용으로 등장하게 된 패턴. 

    * Spring Boot에서 기본으로 설정되어 있다.
    
* 에러 발생상황 예제
    * JPA(Java Persistence API)의 구현체 Hibernate를 이용해 작성
    * View Layer에서 연관 객체를 사용하려 하면 **LazyInitializationException**이 발생한다.
        ```Java
        //Controller 
        @GetMapping("") 
        public String home(Model model){ 
            model.addAttribute("teams", teamService.findAll()); return "home"; 
        } 
        //Service 
        @Transactional public List<Team> findAll(){ 
            return teamRepository.findAll(); 
        }
        ```
    * Error Message
        > org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.kingbbode.model.Team.members, could not initialize proxy - no Session

    * 에러 원인 분석
        * findAll 메서드가 종료될 때 Transaction이 종료되며, Transaction의 종료로 JDBC Connection이 disconnect되고, Hibernate Session이 종료되며, 영속 객체는 Detaced 상태로 변경됩니다. 즉 Service Layer에서 관리되는 Transaction이 View Layer로 넘어가면서 종료되었기 때문에 발생하는 문제인 것 입니다.

* 문제점을 해결하기 위한 방법들의 등장
    * 뷰 렌더링에 필요한 객체 그래프를 모두 로드
        * 뷰에서 필요로 하는 모든 연관 관계의 객체를 `EAGER Fetch`로 설정하거나, Join 쿼리를 작성하는 방법입니다. 그러나 REPOSITORY의 재사용성 감소 및 복잡성 증가를 야기하는 방법이며, 뷰와 영속성 관심사의 강한 결합(뷰를 수정하면, 모델도 변경해야 하는)은 관심사의 분리 원칙을 위반하게 됩니다.
    * POJO FACADE 패턴
        * 애플리케이션 레이어 안에서 새로운 객체를 통해 프록시를 초기화한 후 사용자 인터페이스로 반한하는 방법입니다. POJO FACADE 패턴은 뷰에 대한 관심사를 애플리케이션 레이어의 흐름 관리와 관련된 관심사와 혼합하는 것 입니다. 비록 SERVICE와 독립된 별도의 Pojo 객체에 프록시 초기화 로직을 위치시킨다고 해도 애플리케이션 레이어 개발시에 렌더링될 뷰에 대한 존재와 렌더링과 관련된 요구사항을 고려해야 합니다.
        * POJO FACADE 패턴의 가장 적절한 용도는 분산 환경에서 원격 통신을 지원하기 위한 REMOTE FACADE[Fowler PEAA]로 사용하는 것 입니다. 분산 환경이 아닌 단일 JVM 상에서 뷰를 렌더링하기 위한 객체 그래프를 전달하는 경우에는 POJO FACADE 를 사용하는 것을 권하지 않습니다.
        * 뷰 렌더링에 필요한 객체 그래프를 모두 로드하는 방식은 많은 단점이 존재하며, POJO FACADE 패턴은 분산 환경에 적합하다는 결론입니다. 그리고 등장한 것이 Open Session In View 패턴 입니다

* 최종적인 문제의 해결방안 Open Session In View 패턴
    * 뷰 렌더링 시점에 영속성 컨텍스트가 존재하지 않기 때문에 Detached 객체의 프록시를 초기화할 수 없다면 영속성 컨텍스트를 오픈된 채로 뷰 렌더링 시점까지 유지하자는 것 입니다. 즉, 작업 단위를 요청 시작 시점부터 뷰 렌더링 완료 시점까지로 확장하는 것 입니다. Open Session In View 패턴에 대한 많은 논쟁들이 있었지만, 결론은 Open Session In View 패턴은 레이어 아키텍처를 해치는 안티패턴이 아니라는 것 입니다.
    
    
* * *
### 20.01.07 
* * * 
#### [REST API](https://itstory.tk/entry/%EB%8D%94-%EB%82%98%EC%9D%80-RESTful-API%EB%A5%BC-%EC%84%A4%EA%B3%84%ED%95%98%EA%B8%B0-%EC%9C%84%ED%95%9C-%EC%B5%9C%EA%B3%A0%EC%9D%98-10%EA%B0%80%EC%A7%80-%EC%97%B0%EC%8A%B5%EB%B0%A9%EB%B2%95)
* REST(Representational State Transfer) API의 목적
    * 웹기반으로 리소스를 관리할 때 이를 구조적으로 요청 및 제공하기위해 만들어진 API 아키텍처

* HTTP Method
    * REST API는 수행할 작업의 분리를 http method를 이용하여 구분한다. 특정 URL에 어떤 메소드로 접근하느냐에 따라서 작업의 종류가 결정된다.

    * Idempotent : 여러번 요청시 데이터의 동일성 유지 여부. REST의 표준을 지키는데 매우 중요한 사항이므로 **반드시** 충족해야한다.
    
    * |Method|Meaning|Idempotent|
      |------|---|---|
      |POST|Create|No|
      |GET|Select|Yes|
      |PUT|Update|Yes|
      |DELETE|Delete|Yes|

* Ressource
    * REST는 리소스 지향적 아키텍쳐이다. 아래의 예시는 리소스를 표현하는 규칙을 나타낸다
        * 모든 리소스는 명사로 표현 
        * 풍촌식당의 음식점 메뉴가 http://fungchon/menus이라면 1번 메뉴의 리소스는 http://fungchon/menus/1 이와 같다.

* Characteristic
    1. 유니폼 인터페이스(Uniform Interface)
        * 플랫폼에 상관없이 동일한 인터페이스 제공. 이로인해 프론트엔드 기술에 상관없이 동일한 자원 사용 가능하여, 비즈니스로직을 통일하는게 가능
    2. 무상태(Stateless)
        * 세션과 같이 클라이언트의 상태를 기억하지 않는다.
        * 인증같은 부분은 토큰등의 API KEY를 발급하여 관리한다.
    3. 캐시 가능(Cacheable)
        * HTTP라는 기존 웹 표준을 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 활용 가능. 따라서 HTTP의 기능인 캐싱 기능 적용 가능. HTTP 프로토콜 표준에서 사용하는 Last-Modified태그 혹은 E-Tag를 이용하면 캐싱 구현
    4. 자체 표현 구조(Self-descriptiveness)
        * 리소스의 경로와 정해진 Method를 보고 API 해석이 가능
        * 최소한의 문서로 쉽게 사용 가능
    5. 클라이언트 서버 구조(Client-Server)
        * 클라이언트-서버라는 구조로 각 부분의 개발 의존성을 최소화 가능
        * REST 서버는 API를 제공하며, 클라이언트는 사용자 인증, 컨텍스트(세션, 로그인 정보)등을 직접 관리하는 구조로 각각의 역할을 확실하게 분리하기 때문에 서로의 의존성이 줄어든다.
    6. 계층형 구조(Layered System)
        * 순수 비즈니스로직, 인증, 암호화, 로드밸런싱 등의 계층을 나누어 개발이 가능

* REST antipattern
    * 아래 항목이 적용된 API는 REST 하지 **않은** API이다.
    * GET/POST를 이용한 터널링
        * http://myweb/users?method=update&id=gildong 이 전형적인 GET을 이용한 터널링
    * Self-descriptiveness 속성 사용하지 않음
    * HTTP 응답 코드를 사용하지 않음
        * 200, 403, 404, 500 등의 응답 코드를 사용해서 구현되어야 한다. 그렇지 않으면 REST라 할 수 없음
        
        
* * *
### 20.01.06 
* * * 
##### [스프링 어노테이션 이용하여 예외처리하기](https://jeong-pro.tistory.com/195)
* 정의
    * 예외처리는 서비스가 비즈니스로직에 집중하기 힘들게 만든다. 예외처리를 하다보면 비즈니스로직 자체보다는 예외처리를 위한 코드가 더 많아 지는 경우도 있다. 이러한 문제를 해결하기 위해 아래 두 어노테이션을 이용하면 예외처리와 비즈니스로직을 분리하는게 가능하다.

* @ControllerAdvice
    * 기능
        * @ExceptionHandler가 하나의 클래스에 대한 것이라면, @ControllerAdvice는 모든 @Controller 즉, 전역에서 발생할 수 있는 예외를 잡아 처리해주는 annotation이다.
        * 아래 예제와 같이 예외처리를 담당할 클래스를 생성한뒤, 해당 클래스에 어노테이션을 붙여준다. 그 다음 @ExceptionHandler를 이용하여 처리하려는 예외로직을 작성하면된다.
        * 특정 패키지 단위로 제한할 수 있다. @RestControllerAdvice("com.example.demo.login.controller")

    * 주의사항
        * @RestControllerAdvice는 @RestController에서만 발생하는 예외를 처리해주고, @ControllerAdvice는 @Controller에서만 발생하는 예외를 처리해준다.

    * 예제
        ```Java
        @ControllerAdvice OR @RestControllerAdvice
        public class RestaurantErrorAdvice {

            @ResponseBody
            @ResponseStatus(HttpStatus.NOT_FOUND)
            @ExceptionHandler(RestaurantNotFoundException.class)
            public String handleNotFound() {
                return "{}";
            }
        }
        ```

* @ExceptionHandler(RestaurantNotFoundException.class)
    * 기능
        * @Controller, @RestController가 적용된 Bean 내에서 발생하는 예외를 잡아서 하나의 메서드에서 처리해주는 기능을 한다.
        * @ExceptionHandler라는 어노테이션을 쓰고, 인자로 캐치하고싶은 예외클래스 등록
        * @ExceptionHandler(NullPointerException.class, IOException.class)와 같이 다중 예외를 인자로 받는게 가능하다.
    
    * 주의사항
        * _Contorller_, _RestController_ 에서만 사용 가능하다.
        * 리턴타입은 자유롭게 해도 상관없다.
        * 

    * 예제
        ```Java
        @ControllerAdvice
        public class RestaurantErrorAdvice {

            @ResponseBody
            @ResponseStatus(HttpStatus.NOT_FOUND)
            @ExceptionHandler(RestaurantNotFoundException.class)
            public String handleNotFound() {
                return "{}";
            }
        }

        @RestController 
        public class MyRestController {
            @ExceptionHandler(NullPointerException.class, IOException.class) 
            public Object nullex(Exception e) { 
                System.err.println(e.getClass()); return "myService"; 
            } 
        }
        ```

* 에러 관리하기
    * 아래와 같은 형태로 에러코드를 관리하여, LoginErrorCode.OperationNotAuthorized.getCode(); 과 같이 호출하여 반환 될 메세지를 정리해주고, 조건문에 따라서 정해놓은 @ExceptionHandler 메소드를 호출해주면(throw new NPException;) 에러처리가 끝난다. 중복되는 예외처리 로직을 사용하지 않아도 된다.

    ```Java
    public enum LoginErrorCode { 
        OperationNotAuthorized(6000,"Operation not authorized"), 
        DuplicateIdFound(6001,"Duplicate Id"),  
        UnrecognizedRole(6010,"Unrecognized Role"); 

        private int code; 
        private String description; 

        private LoginErrorCode(int code, String description) { 
            this.code = code; 
            this.description = description; 
            } 

        public int getCode() { 
            return code; 
        } 

        public String getDescription() { 
            return description; 
        } 
    }
    ```


* * *
### 20.01.04 
* * * 
#### Spring의 Annotation - 3
* @Transactional
    * 정의
        * 스프링에서는 트랜잭션 처리를 지원하는데 그중 어노테이션 방식으로 @Transactional을 선언하여 사용하는 방법이 일반적이며, 선언적 트랜잭션이라 부른다.

    * 특징
        * 원자성(Atomicity) - 한 트랜잭션 내에서 실행한 작업들은 하나로 간주한다. 즉, 모두 성공 또는 모두 실패. 
        * 일관성(Consistency) - 트랜잭션은 일관성 있는 데이타베이스 상태를 유지한다. (data integrity 만족 등.)
        * 격리성(Isolation) - 동시에 실행되는 트랜잭션들이 서로 영향을 미치지 않도록 격리해야한다. 
        * 지속성(Durability) - 트랜잭션을 성공적으로 마치면 결과가 항상 저장되어야 한다.

    * 기능
        * @Transactional 어노테이션을 선언한 클래스에 트랜잭션 기능이 적용된 프록시 객체가 생성된다. 해당 프록시 객체는 어노테이션이 포함된 메소드가 호출 될 경우 PlatformTransactionManager를 사용하여 트랜잭션을 시작하고, 정상 여부에 따라 Commit 또는 Rollback 한다.

    * 예제
        ```Java
            @Transactional
            public Restaurant updateRestaurant(Long id, String name, String address) {
                Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

                restaurant.updateInformation(name, address);

                return restaurant;
            }
        ```
    * 더보기
        * [PlatformTransactionManager](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/PlatformTransactionManager.html)

* @NotEmpty, @NotNull, @NotBlank
    * 정의
        * 도메인 값을 입력 할 때, 특정 상태의 값들을 넣을 수 없도록 설정해주는 어노테이션

    * 기능
        * @NotEmpty : null과 ""을 허용하지 않는다.
        * @NotNull : null을 허용하지 않는다.
        * @NotBlank : null과 ""과 빈 공백 물자열(space)를 허용하지 않는다.

    * 예제
        ```Java
        @NotEmpty
        private String name;

        @NotNull
        private String address;

        @NotBlank
        private String phoneNumber;
        ```

* @Valid
    * 정의
        * 복잡한 유효성체크를 쉽게 처리하도록 도와주는 스프링에서 제공해주는 어노테이션

    * 기능
        * 상단의 @NotEmpty 와 같은 도메인 값 정보를 설정해주는 어노테이션을 체크하여 request를 통해 전달받은 객체의 값이 유효성이 올바른지 체크해준다.

    * 예제
        ```Java
        @PatchMapping("restaurants/{id}")
        public String update(@PathVariable("id") Long id,
                            @Valid @RequestBody Restaurant resource) {
            String name = resource.getName();
            String address = resource.getAddress();

            restaurantService.updateRestaurant(id, name, address);

            return "{}";
        }
        ```

* @ResponseBody, @RequestBody
    * 정의
        * 웹 서비스와 REST 방식이 시스템을 구성하는 주요 요소로 자리 잡으면서 웹 시스템간에 XML이나 JSON 등의 형식으로 데이터를 주고 받는 경우가 증가하고 있다. 이에 따라 스프링도 클라이언트에서 전송한 XML, JSON 등등의 데이터를 컨트롤러에서 DOM객체나 자바 객체로 변환해서 수신하는 기능이 컨트롤러에서 어노테이션을 이용해 제공되었다. 반대로 자바객체를 데이터타입으로 변환해서 송신하는 기능도 제공된다.

    * 기능
        * @ResponseBody : 자바 객체를 HTTP 응답 body로 변환
        * @RequestBody : HTTP 요청 body를 자바 객체로 변환

    * 예제
        ```Java
        @ControllerAdvice
        public class RestaurantErrorAdvice {

            @ResponseBody
            @ResponseStatus(HttpStatus.NOT_FOUND)
            @ExceptionHandler(RestaurantNotFoundException.class)
            public String handleNotFound() {
                return "{}";
            }
        }

        @ResponseBody
        public GuestMessageList listXml() {

            GuestMessageList list = ...;

            return list;
        }
        ```      
      
* * *
### 20.01.03 
* * * 
#### Junit4 - 2
* Verify
    * 정의
        * Mock을 이용시에 원하는 메소드가 특정 조건으로 실행되었는지를 검증

    * 기능
        * verify()는 기본적으로 메소드 호출이 한 번 되는 것을 검증할 수 있다. 추가로 times(), atLeast(), atMost(), never()등을 사용하면 특정 호출 횟수 및 최소/최대 횟수를 지정해서 검증할 수 있다.
        * inOrderObj.verify(mock.method())같은 형식으로 메소드에 호출 시 넘긴 값 뿐만이 아니라 메소드 호출 순서도 검증가능하다. 여러 mock의 메소드 호출 순서도 검증할 수 있다.
        * verifyNoMoreInteractions(mockedList) mock의 행동이 모두 검증 되었는지 확인한다.

    * 예제
        ```Java
        @Test
        public void update() throws Exception {
            mvc.perform(
                    patch("/restaurants/1004")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"JOKER Bar\", \"address\":\"Busan\"}"))
                .andExpect(status().isOk());

            verify(restaurantService).updateRestaurant(1004L, "JOKER Bar", "Busan");

            /* 다회 검사 */
            mockedList.add("once");

            mockedList.add("twice");
            mockedList.add("twice");

            mockedList.add("three times");
            mockedList.add("three times");
            mockedList.add("three times");

            verify(mockedList).add("once"); // times(1) 기본값
            verify(mockedList, times(1)).add("once");

            verify(mockedList, times(2)).add("twice");
            verify(mockedList, times(3)).add("three times");

            verify(mockedList, never()).add("never happened"); // 호출된 적 없음

            verify(mockedList, atLeastOnce()).add("three times"); // 최소 한 번
            verify(mockedList, atLeast(2)).add("five times"); // 최소 두 번
            verify(mockedList, atMost(5)).add("three times"); // 최대 다섯 번

            /* 메소드 호출 순서 검증 */
            List singleMock = mock(List.class);

            singleMock.add("first");
            singleMock.add("second");

            InOrder inOrder = inOrder(singleMock);

            inOrder.verify(singleMock).add("first");
            inOrder.verify(singleMock).add("second");

            // multiple mocks
            List firstMock = mock(List.class);
            List secondMock = mock(List.class);

            //using mocks
            firstMock.add("first");
            secondMock.add("second");

            InOrder inOrder = inOrder(firstMock, secondMock); // pass multiple mocks to verify

            inOrder.verify(firstMock).add("first");
            inOrder.verify(secondMock).add("second");

            /* mock이 모두 검증되었는지 확인 */
            mockedList.add("one");
            mockedList.add("two");

            verify(mockedList).add("one");

            verifyNoMoreInteractions(mockedList); // fail here
        }
        ```

      
* * *
### 20.01.02 
* * * 
#### java - 2
* [의존 역전 원칙 (DIP)](http://wonwoo.ml/index.php/post/1717)
    * 정의
        * 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안된다. 저수준 모듈이 고수준 모듈에서 정의한 추상 타입에 의존해야 한다.

    * 고수준 모듈과 저수준 모듈
        * 고수준 모듈 - 의미가 있는 단일 기능을 제공하는 모듈
        * 저수준 모듈 - 고수준 모듈의 기능을 구현하기 위해 필요한 하위 기능을 실제로 구현 해놓은 모듈

    * DIP 원칙을 _어긴_ 코드
        아래 코드는 고수준 모듈이 저수준 모듈의 구현에 의존하고 있기 때문에, 저수준 모듈이 변경 될 경우 고수준 모듈에서 코드수정이 발생해야한다.
        고수준 모듈인 Response는 저수준모듈인 JsonConverter에 의존하고있다.
        
        ```Java
        public class Response {
            private JsonConverter jsonConverter = new JsonConverter();

            public String response()  {
                byte[] bytes = null; //파일은 생략
                return jsonConverter.convert(bytes);
            }

        }

        class JsonConverter {

            public String convert(byte[] bytes) {
                //json ...
                return "json";
            }
        }
        ```
    
    * DIP 원칙을 _지킨_ 코드
        Converter라는 인터페이스를 JsonConverter가 implements하였다.
        인터페이스를 통하여 JsonConverter가 Converter에 의존한 상태가 되었다.
        기능 변경이 필요 할 경우 고수준 모듈 Response는 동일하게 Converter 인터페이스를 사용하면 되며,
        저수준 모듈 JsonConverter에서만 코드 변경이 발생한다.
        만약 다른 저수준 모델이 필요 할 경우 Converter 인터페이스를 통해 implements하여 제공하면 고수준 모델은 변경사항이 발생하지 않는다.

        ```Java
            public class Response {

                private Converter converter = new JsonConverter();

                public String response() {
                    byte[] bytes = null; //파일은 생략
                    return converter.convert(bytes);
                }

            }

            interface Converter {

                String convert(byte[] bytes);

            }

            class JsonConverter implements Converter {

                @Override
                public String convert(byte[] bytes) {
                    //json ...
                    return "json";
                }
            }
        ```
        ```Java
            public class Response {

            private Converter converter = new XmlConverter();

            public String response() {
                byte[] bytes = null; //파일은 생략
                return converter.convert(bytes);
            }

            }

            class XmlConverter implements Converter {

            @Override
            public String convert(byte[] bytes) {
                //xml ...
                return "xml";
            }
            }
        ```


#### Junit4 - 2
* Verify
    * 정의
        * 

    * 기능
        * 

    * 예제
        ```Java
        @Test
        public void update() throws Exception {
            mvc.perform(
                    patch("/restaurants/1004")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"JOKER Bar\", \"address\":\"Busan\"}"))
                .andExpect(status().isOk());

            verify(restaurantService).updateRestaurant(1004L, "JOKER Bar", "Busan");
        }
        ```
      
      
### 20.01.01 
* * * 
#### java - 1
* java8 추가기능 [Optional](https://jdm.kr/blog/234)
    * Optional이란?
        * java.util.Optional<T>
        * java8에서 최초로 도입된 기능. null으로 인해 도입 되었다. null은 개발에있어서 더 불편한 영향을 끼치고있기에, 이를 더 효율적으로 다룰 수 있는 기능을 도입
        * “존재할 수도 있지만 안 할 수도 있는 객체”, 즉, “null이 될 수도 있는 객체”을 감싸고 있는 일종의 래퍼 클래스

    * Optional의 효과
        * NPE를 유발할 수 있는 null을 직접 다룰 필요 없어짐
        * 수고롭게 null 체크를 직접 하지 않아도 됌
        * 명시적으로 해당 변수가 null일 수도 있다는 가능성을 표현 가능. (따라서 불필요한 방어 로직을 최소화)

    * 기존 optional을 이용하기 전 NPE 방어 수단
        * 중첩 분기
            ```Java
            public String getCityOfMemberFromOrder(Order order) {
                if (order != null) {
                    Member member = order.getMember();
                    if (member != null) {
                        Address address = member.getAddress();
                        if (address != null) {
                            String city = address.getCity();
                            if (city != null) {
                                return city;
                            }
                        }
                    }
                }
                return "Seoul"; // default
            }
            ```

        * 반환
            ```Java
            public String getCityOfMemberFromOrder(Order order) {
                if (order == null) {
                    return "Seoul";
                }
                Member member = order.getMember();
                if (member == null) {
                    return "Seoul";
                }
                Address address = member.getAddress();
                if (address == null) {
                    return "Seoul";
                }
                String city = address.getCity();
                if (city == null) {
                    return "Seoul";
                }
                return city;
            }
            ```
    * Optional 기본 사용 방법
        * 변수 선언하기
            제네릭을 제공하기 때문에, 변수를 선언할 때 명시한 타입 파라미터에 따라서 감쌀 수 있는 객체의 타입이 결정
            ```
            Optional<Order> maybeOrder; // Order 타입의 객체를 감쌀 수 있는 Optional 타입의 변수
            Optional<Member> optMember; // Member 타입의 객체를 감쌀 수 있는 Optional 타입의 변수
            Optional<Address> address; // Address 타입의 객체를 감쌀 수 있는 Optional 타입의 변수
            ```

#### Tool
* [HTTPie](https://www.lesstif.com/pages/viewpage.action?pageId=28606741)
    * [설치](https://httpie.org/#installation)

    * 터미널에서 http 요청을 시도해볼 수 있는 툴

    * 특징
        * curl 에 비해 사용이 쉬움
        * json 지원 기능 내장
        * 출력을 포맷팅하여 보여주므로 가독성이 뛰어남
        * Form 과 file 업로드가 쉬움
        * HTTP 인증 및 커스텀 헤더 설정등
        
* * *
### 19.12.30 
* * * 
#### Junit4 - 4
* Mock Object
    * 정의
        * 실제 객체를 만들기에는 비용과 시간이 많이 드는 경우, 의존성이 복잡하게 연결되어있어 제대로 구현하기 어려울 경우 생성하는 '가짜' 객체
    
    * Mock 객체 필요 케이스
        1. 테스트 작성을 위한 환경 구축이 어려운 경우
            * 환경 구축에 작업시간이 많이 필요한 경우(DB, WebServer, WebApplicationServer, FTP Server...ETC)
            * 특정 모듈이 없어 테스트 환경을 구축하지 못하는 경우
            * 타 부서와의 협의나 정책이 필요한 경우
        2. 테스트가 특정 경우나 순간에 의존적인 경우
            * 특수한 데이터가 입력되는 상황(ex.초기 회원가입시에만 나타나는 특정 선택케이스)을 매번 구현시켜기 어려울 때
        3. 테스트 시간이 오래 걸리는 경우
            * 클러스터링과 같이 6시간 7시간 걸리는 경우 해당 작업이 완료되었다는 가정 하에 테스트 진행
        4. 개인 PC의 성능이나 서버의 성능문제로 오래 걸릴수 있는 경우 시간을 단축하기 위해 사용한다
            * 특정 연산이 오래 걸릴 경우, 해당 연산의 결과값을 대체
    
    * Mock에 대한 기본적인 분류 개념 - 기본
        1. 테스트 더블
        2. 더미객체(Dummy Object)
        3. 테스트 스텁(Test Stub)
        4. 페이크 객체(Fake Object)
        5. 테스트 스파이(Test Spy)
        6. Mock 객체(Mock Object)

* Mockito
    * Mock Object Framework
        * 단위테스트를 하기 위해 Mock을 만들어주는 프레임워크. Mock이 필요한 테스트에 직관적으로 사용가능.

    * 특징
        * 사용법이 단순하다.
        * call("getName")처럼 이름이 호출하지 않는다.
        * 읽기 어려운 anonymous inner클래스를 사용하지 않는다.
        * 리펙토링이 쉽다.
        * 작성이 어렵지 않아 테스트 자체에 집중할 수 있다.
        * 테스트 스텁을 만드는 것과 검증을 분리한다.
        * Mock 만드는 방법을 단일화 했다.
        * 테스트 스텁을 만들기 쉽다.
        * API가 간단하다.
        * 실패 시에 발생하는 스택 트레이스가 깔끔하다.

    * 사용 단계
        1. CreateMock : 인터페이스에 해당되는 Mock 객체를 만든다.
        2. Stub : 테스트에 필요한 Mock 객체의 동작을 지정한다.
        3. Excercise : 테스트 메소드 내에서 Mock 객체를 사용한다.
        4. Verify : 메서드가 예상되로 호출되었는지 검증한다.

* Annotation
    * @MockBean
        * 기존에 사용되던 Bean의 껍데기만 가져오고 내부 구현 부분은 모두 사용자에게 위임한 형태
          즉, 해당 Bean의 특정 메소드가 임의의 값이 입력되면 반환되는 내용이 무엇인지 모두 개발자 필요에 의해서 조작 가능

        * example
            ```
            @MockBean
            private BoardService boardService;

            @Test
            public void getBoardList() throws Exception {
                List<BoardDto> boardDtos = new ArrayList<>();

                User writer = User.builder()
                    .id(1L)
                    .email("test@gmail.com")
                    .name("kimtaeyoung")
                    .nickName("daniel")
                    .userId("daniel_grey")
                    .build();

                BoardDto boardDto = BoardDto.builder()
                    .writer(writer)
                    .title("title")
                    .id(1L)
                    .content("content")
                    .boardType(1L)
                    .build();

                boardDtos.add(boardDto);

                given(boardService.findBoardListByBoardType(1L)).willReturn(boardDtos);

                mvc.perform(get("/board/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("\"id\":1")))
                    .andExpect(content().string(containsString(
                        "\"writer\":{\"id\":1,\"userId\":null,\"password\":null,\"name\":null,\"nickName\":null,\"email\":null,\"role\":null,\"createdAt\":null,\"lastLoggedIn\":null}")))
                    .andExpect(content().string(containsString("\"boardType\":1")))
                    .andExpect(content().string(containsString("\"title\":\"title\"")))
                    .andExpect(content().string(containsString("\"content\":\"content\"")));
            }
            ```

    * given method
        * 개발자가 직접 설정한 값으로 반환값이 생성될 것을 설정할 수 있는 메소드
        * BDD를 위해 만들어진 기능

    * MockitoAnnotations.initMocks(this)
        * 해당 테스트 파일 내에 있는 @Mock 객체를 초기화 해주는 기능
        * 만약 @Mock이 설정되어있는 객체가 호출되지 않은 상태일때 사용하여 주입시켜주는 역할
        
        
* * *
### 19.12.29 
* * * 
#### Spring 이론 - 3
* Application Layer
    * Controller와 Service를 나누는 이유
        * 코드의 복잡도를 낮추기 위해서. 각 계층의 역할을 나눔으로써 목적이 명확해지고 코드의 책임이 분명해진다.
        * controller에서는 service에서 테스트를 통해 검증된 인터페이스를 사용함으로써 오류를 방지한다. 즉, 오류발생을 원천 차단할 수 있다.
        
#### Junit4 - 3
* Annotation
    * @Before
        * @Test annotation이 동작하기 전에 먼저 객체 생성, 주입 등의 선동작을 수행한다.
        * @Test annotation에서 공통으로 사용하는 코드를 작성해놓고 사용 할 수 있다.


* * *
### 19.12.28 
* * * 
#### Spring 이론 - 2
* Annotation
    * Component
        * 개발자가 직접 작성한 Class를 IOC Container에 Bean으로 등록하고 spring에서 관리 할 수 있도록 변경
            
#### Junit4 - 2
* Annotation
    * @SpyBean
        * 테스트로 컨트롤러를 사용시 원하는 객체를 넣어 줄 수 있다.
        * example
            ```Java
              @SpyBean(BoardServiceImpl.class)
              private BoardService boardService;
            ```
            
    * @MockBean
        * 기존에 사용되던 스프링 Bean이 아닌 Mock Bean을 주입합니다. 어노테이션 내부에 문자열 값을 등록한 것은 기존에 선언된 Bean 객체를 덮어쓰기 위함입니다. 만약 Bean의 이름을 강제로 지정하지 않으면, Spring에선 어떤 Bean을 가져와야할지 알수 없어 오류가 발생합니다.
        * 기존에 사용되던 Bean의 껍데기만 가져오고 내부의 구현 부분은 모두 사용자에게 위임 즉, 해당 Bean의 어떤 메소드가 어떤 값이 입력 되면 어떤 값이 리턴 되어야 한다는 내용 모두 개발자 필요에 의해서 조작이 가능
    
    
* * *
### 19.12.27 
* * * 
#### Junit4 - 1
* Annotation
    * @RunWith(SpringRunner.class)
        * Spring을 이용하여 테스트를 수행할 수 있도록 설정
    * @WebMvcTest(example.class)
        * example class를 지정하여 해당 class 테스트 수행 설정
    * @Test
        * 해당 함수를 테스트 함수로 명시
* Test Class
    * MockMvc
        * 브라우저에서 요청과 응답을 의미하는 객체로서 Controller 테스테 사용을 용이하게 해주는 라이브러리
        * MockMvc의 활용방법
            * perform
                * perform({method}("/uri"))
                    * method와 uri를 지정해 해당 요청의 반환값을 확인 할 수 있다.
                * andExpect(expect data)
                    * perform에 메서드 체이닝을 이용하여 반환값으로 기대되는 내용을 입력한다. 만약 해당 값이 존재 할 경우 통과, 없을경우 에러가 발생한다.

        * example
            ```
            @Test
            public void list() throws Exception {
                mvc.perform(get("/board/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("\"id\":1")))
                    .andExpect(content().string(containsString("\"write\":1")))
                    .andExpect(content().string(containsString("\"boardType\":1")))
                    .andExpect(content().string(containsString("\"title\":\"hello World!\"")))
                    .andExpect(content().string(containsString("\"content\":\"it is content\"")));
            }
            ```
* 에러 발생
    현재 구조에서 아래와같은 에러 발생. 원인 확인 필요
    ```
    Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.StudyBoardCRUD.firstBoard.normalboard.service.BoardService' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {}
    ```
  
  
* * *
### 19.12.26 
* * * 
#### REST API(REpresentational State Transfer) - 1
* REST API 규칙을 적용하는 이유
    * 다양한 프론트 환경에서 백엔드로 resource에 대한 요청을 할 때 
      백엔드가 REST API 규칙을 이용해 작성 할 경우 통일된 요청 및 반환을 할 수 있다.
* Resource의 CRUD에 대한 대응 REST API의 대응
    * CREATE -> POST
    * READ -> GET
    * UPDATE -> PUT/PATCH
    * DELETE -> DELETE
* Resource의 분류
    * Collection가 할 수 있는 행동
        * Read(List), Create
        * Collection의 Read는 할 경우 목록이 반환한다.
    * Member가 할 수 있는 행동
        * Read(Detail), Update, Delete
        * Member의 Read는 각 개별 상세정보를 반환한다.
* URI / URL
    * 자원을 요청할때 사용하는 구성요소
    * example
        ```
        Collection
        http://host/boards
        Member
        http://host/boards/{id}
        ```
* JSON(Javascript Object Notation)
    * JSON은 경량(Lightweight)의 DATA-교환 형식
    * Javascript에서 객체를 만들 때 사용하는 표현식을 의미한다.
    * 특정 언어에 종속되지 않으며, 대부분의 프로그래밍 언어에서 JSON 포맷의 데이터를 핸들링 할 수 있는 라이브러리를 제공한다.
    * 해당 데이터 포맷을 이용하여 대다수의 통신에서 정보를 반환한다.
    * example
        ```
        단일
        {
            "id": 1,
            "boardType": 1,
            "writer": 1,
            "title": "first board",
            "content": "hello world!"
        }

        목록
        [
            {
                "id": 1,
                "boardType": 1,
                "writer": 1,
                "title": "first board",
                "content": "hello world!"
            },
            {
                "id": 2,
                "boardType": 1,
                "writer": 1,
                "title": "second board",
                "content": "hello again!"
            }
        ]
        ```
* Board API를 REST API로 구성해보기
    * 게시판 목록 호출
        * GET /boards/{boardType}
    * 게시글 호출
        * GET /boards/{id}
    * 게시글 추가 호출
        * POST /boards
    * 게시글 삭제
        * DELETE /boards/{id}
            
            
* * *
### 19.12.25 
* * * 
#### BDD(Behavior Driven Development) - 1
* BDD란 무엇인가? 
    * BDD는 한 TDD 실천자가 테스트의 의도를 더 명확하게 표현하기 위한 용어를 찾는 과정에서 탄생하였다.
      사실 테스트라는 단어는 원하는 동작을 정의한다는 정신을 잘 반영하지 못하며 의미가 너무 함축적이다.
      개발자 커뮤니티에서는 테스트와 테스트 메소드보다는 명세와 행위라는 용어를 거론하기 시작했다.
* Spock(BDD Framework)
    * spock이란 무엇인가?
        * Spock은 Groovy 문법을 사용하여 이해하기 쉽게 테스트 케이스를 만들 수 있도록 해주는 단위 테스트 프레임워크(unit testing framework). Groovy 기술이지만, Java 테스트도 가능
        * Spock을 이용하여 테스트 코드를 작성하는 것은 다른 표준 테스트 프레임워크를 사용하는 것보다 시간이 덜 듭니다.(JUn it 과 Mock 프레임워크의 조합)
        * Mocking, Stubbing 그리고 Spying 작업들을 매우 간단한 코드로 할 수 있는 쉬운 문법 덕분에 테스트 코드 로직을 변질시키지 않을 수 있습니다.
        * Spock은 개발자들이 테스트를 BDD 같은 형식으로 구성할 수 있게 함으로써, 테스트를 더욱 명확하게 할 수 있습니다.
        * Groovy를 사용하여 클로저와 맵을 직접 사용할 수 있어서  테스트의 명확성을 더 높일 수 있습니다.

    * Setting
        * gradle
            ```
            apply plugin: 'groovy'
            dependencies {
                    testCompile('org.spockframework:spock-core:1.1-groovy-2.4')
                    testCompile('org.spockframework:spock-spring:1.1-groovy-2.4')
            }

            ```
        * 테스트 폴더 분리
            * 필요한 경우 테스트 폴더를 분리시켜줍니다. 파일이 그루비 파일로 생성되어 테스트에는 지장이 없으나, 나중에 어떤 테스트가 spock 테스트인지, junit 테스트인지 구분이 안 될 때가 있습니다.
              이러한 경우를 대비하기 위해여 폴더를 분리하는것을 추천합니다.
              ```
              project > src > test > groovy 생성
              ```
        * trouble shooting
            * 다른 IDEA는 모르겠으나, IntelliJ에서 테스트를 못찾는 오류가 종종 발생합니다. spock 셋팅이 잘못되어있거나(셋팅이랄것도 없는게 사실 gradle에 몇줄 넣어준게 끝), IntelliJ 설정이 문제가 있을 가능성이 있습니다.
            * IntelliJ 문제인지 확인하기 위해서는 아래 커맨드를 입력하여 테스트가 정상적으로 수행되는지 확인합니다.
                terminal에서 gradlew가 있는 위치로 이동 후 아래 커맨드 입력
                ```
                ./gradlew test
                ```
                정상 작동 될 경우 IntelliJ의 문제이므로 아래 설정 변경 후 테스트 재실행
            * IntelliJ 
                * Preference(cmd + ,) -> gradle -> build and run using 'intelliJ IDEA', Run tests using 'intelliJ IDEA'
                * Project Settings(cmd + ;)  -> modules -> test directory -> select Source -> Test Source Folders List Check
    * spock의 기본 사용방법
        하단의 example과 함께 보시면은 이해가 더 쉽습니다.
        * Specification: extends 하면 Spock Test 클래스가 됩니다.
        * def : groovy의 동적 타입 선언(메소드, 변수에 모두 사용할 수 있음. JS의 var 같은 존재)
                def 대신에 Java처럼 실제 클래스 타입을 명시할 수도 있습니다.
        * given (혹은 setup) : 테스트 하기 위한 기본 설정작업 (테스트 환경 구축)
        * when : 테스트할 대상 코드를 실행 (Stimulus)
        * then : 테스트할 대상 코드의 결과를 검증 (이 메소드 범위에선 한줄한줄이 자동 assert가 됩니다.)
        * expect : 테스트할 대상 코드를 실행 및 검증 (when + then)
        * where : feature 메소드를 파라미터로 삼아 실행시킵니다.
    * example
        ```Java
        class RestaurantTests extends Specification {
            def "temporary test"() {
                given:
                List<Integer> list = new ArrayList<>()
                when:
                list.add(1)
                then:
                2 == list.get(0)
            }

            def "temporary second test"() {
                given:
                List<Integer> list = new ArrayList<>()
                when:
                list.add(1)
                then:
                1 == list.get(0)
            }
            def "computing the maximum of two numbers"() {
                expect:
                Math.max(a, b) == c

                where:
                a | b | c
                5 | 1 | 5
                3 | 9 | 9
            }
        }
        ```


* * *
### 19.12.24 
* * * 
#### Builder 이용하여 DTO 개선하기
* Builder란?
    * GoF에서 말하는 Builder 패턴의 목적
        * 객체의 생성 알고리즘과 조립 방법을 분리하는 것이 목적이다.
    * Effective-Java에서 말하는 Builder 패턴의 목적
        * 객체 생성을 깔끔하고 유연하게 하기 위한 기법
    * 점층적 생성자 패턴
        * 다른 생성자를 호출하는 생성자가 많으므로, 인자가 추가되는 일이 발생하면 코드를 수정하기 어렵다.
        * 코드 가독성이 떨어진다. 특히 인자 수가 많을 때 호출 코드만 봐서는 의미를 알기 어렵다.
        * example
            ```java
              // 점층적 생성자 패턴 코드의 예 : 회원가입 관련 코드
              public class Member {
              
                  private final String name;      // 필수 인자
                  private final String location;  // 선택적 인자
                  private final String hobby;     // 선택적 인자
              
                  // 필수 생성자
                  public Member(String name) {
                      this(name, "출신지역 비공개", "취미 비공개");
                  }
              
                  // 1 개의 선택적 인자를 받는 생성자
                  public Member(String name, String location) {
                      this(name, location, "취미 비공개");
                  }
              
                  // 모든 선택적 인자를 다 받는 생성자
                  public Member(String name, String location, String hobby) {
                      this.name = name;
                      this.location = location;
                      this.hobby = hobby;
                  }
              }
            ```
    * 자바빈 패턴
        * 객체 일관성(consistency)이 깨진다.
        * 1회의 호출로 객체 생성이 끝나지 않았다.
        * 즉 한 번에 생성하지 않고 생성한 객체에 값을 떡칠하고 있다.
        * setter 메서드가 있으므로 변경 불가능(immutable)클래스를 만들 수가 없다.
        * 스레드 안전성을 확보하려면 점층적 생성자 패턴보다 많은 일을 해야 한다.
        * example
            ```java
            public class NutritionFacts {
                public void main() {
                    NutritionFacts cocaCola = new NutritionFacts();
                    cocaCola.setServingSize(240);
                    cocaCola.setServings(8);
                    cocaCola.setCalories(100);
                    cocaCola.setSodium(35);
                    cocaCola.setCarbohdydrate(27);
                }
            }
            ```
    * 빌더 패턴
        * 각 인자가 어떤 의미인지 알기 쉽다.
        * setter 메소드가 없으므로 변경 불가능 객체를 만들 수 있다.
        * 한 번에 객체를 생성하므로 객체 일관성이 깨지지 않는다.
        * build() 함수가 잘못된 값이 입력되었는지 검증하게 할 수도 있다.
        * example
            ```java
              // Effective Java의 Builder Pattern
              public class NutritionFacts {
                  private final int servingSize;
                  private final int servings;
                  private final int calories;
                  private final int fat;
                  private final int sodium;
                  private final int carbohydrate;
              
                  public static class Builder {
                      // Required parameters(필수 인자)
                      private final int servingSize;
                      private final int servings;
              
                      // Optional parameters - initialized to default values(선택적 인자는 기본값으로 초기화)
                      private int calories      = 0;
                      private int fat           = 0;
                      private int carbohydrate  = 0;
                      private int sodium        = 0;
              
                      public Builder(int servingSize, int servings) {
                          this.servingSize = servingSize;
                          this.servings    = servings;
                      }
              
                      public Builder calories(int val) {
                          calories = val;
                          return this;    // 이렇게 하면 . 으로 체인을 이어갈 수 있다.
                      }
                      public Builder fat(int val) {
                          fat = val;
                          return this;
                      }
                      public Builder carbohydrate(int val) {
                          carbohydrate = val;
                          return this;
                      }
                      public Builder sodium(int val) {
                          sodium = val;
                          return this;
                      }
                      public NutritionFacts build() {
                          return new NutritionFacts(this);
                      }
                  }
              
                  private NutritionFacts(Builder builder) {
                      servingSize  = builder.servingSize;
                      servings     = builder.servings;
                      calories     = builder.calories;
                      fat          = builder.fat;
                      sodium       = builder.sodium;
                      carbohydrate = builder.carbohydrate;
                  }
              
                  public main() {
                      //type A
                      NutritionFacts.Builder builder = new NutritionFacts.Builder(240, 8);
                      builder.calories(100);
                      builder.sodium(35);
                      builder.carbohydrate(27);
                      NutritionFacts cocaCola = builder.build();
                       
                      //type B
                      // 각 줄마다 builder를 타이핑하지 않아도 되어 편리하다.
                      NutritionFacts cocaCola = new NutritionFacts
                      .Builder(240, 8)    // 필수값 입력
                      .calories(100)
                      .sodium(35)
                      .carbohydrate(27)
                      .build();           // build() 가 객체를 생성해 돌려준다.
                  
                  }
              }  
            ```


* * *
### 19.12.23 
* * * 
#### AOP(Aspect Oriented Programming)
* AOP란 무엇인가?
    * AOP는 관점 지향 프로그래밍으로 "기능을 핵심 비즈니스 기능과 공통 기능으로 '구분'하고, 공통 기능을 개발자의 코드 밖에서 필요한 시점에 적용하는 프로그래밍 방법"이다.
    * 구성요소
        * JoinPoint: 모듈의 기능이 삽입되어 동작할 수 있는 실행 가능한 특정 위치
        * PointCut: 어떤 클래스의 어느 JoinPoint를 사용할 것인지를 결정
        * Advice: 각 JoinPoint에 삽입되어져 동작할 수 있는 코드
        * Interceptor: InterceptorChain 방식의 AOP 툴에서 사용하는 용어로 주로 한개의 호출 메소드를 가지는 Advice
        * Weaving: PointCut에 의해서 결정된 JoinPoint에 지정된 Advice를 삽입하는 과정(CrossCutting)
        * Introduction: 정적인 방식의 AOP 기술
        * Aspect: PointCut + Advice + (Introduction)
* Setting
    * Add dependencies in build.gradle compile 'org.springframework.boot:spring-boot-starter-aop'
* Annotation
    * @EnableAspectJAutoProxy
        * 최상위 패키지에 있는 클래스에 Annotation을 적용해서 AOP를 찾을 수 있게 해준다.
    * @Aspect, @Componet 
        * 해당 클래스가 AOP가 바라보는 관점을 정의하고 bean으로 등록하는 것을 정의
    * @Around + exmaple
        * 메서드의 실행 전/후에 공통로직을 적용하고 싶을 때 사용
        * @Around("execution(* com.example.demo.service.BoardServiceImpl.*(..))") - 어떤 메서드들이 이 AOP를 적용받을 것인지를 정의
          ```java
            @Aspect
            @Component
            public class LogAspect {
                Logger logger =  LoggerFactory.getLogger(LogAspect.class);
                
                //BookService의 모든 메서드
                @Around("execution(* com.StudyBoardCRUD.firstBoard.normalboard.BoardServiceImpl.*(..))")
                /*@Around("execution(* com.StudyBoardCRUD.firstBoard.normalboard.controller..*.*(..))")*/
                /*@Around("execution(* com.StudyBoardCRUD.firstBoard.normalboard..*.*(..))")*/
                public Object logging(ProceedingJoinPoint pjp) throws Throwable {
                    logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
                    Object result = pjp.proceed();
                    logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
                    return result;
                }
            }
            ```
    * @Before 
        * 메서드 실행 전에 사용
    * @After 
        * 메서드 실행 후에 공통 로직을 적용하고 싶을 때 사용
                           
            
* * * 
### 19.12.22 
* * * 
#### Spring 이론 - 2
* Spring의 Bean 관리 방식
    * @RestController, @Service, @Bean 등과 같은 Bean 등록 어노테이션을 사용하면
      이후로 해당 Bean과 동일한 이름을 갖고있는 서비스를 찾아서 매칭시킨다.
      굳이 @Autowired을 이용해 찾아 줄 필요 없이 이름을 매칭시켜주면 된다.
        
#### Lombok 셋팅하기
* Lombok이란?
    * Lombok은 자바에서 @Getter, @Setter 같은 annotation 기반으로 관련 기존 DTO, VO, Domain Class 작성할 때, 멤버 변수에 대한 Getter/Setter Method, Equals(), hashCode(), ToString()과 멤버 변수에 값을 설정하는 생성자 등등을 자동으로 생성해 주는 라이브러리다.
    
    * gradle setting
        ```
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
        ```
      
    * intelliJ 셋팅
        1. cmd + ,
        2. Annotation Processors
        3. Enable annotation processing
    
#### Entity와 DTO
* 차이점
    * Entity는 영속성을 관리(JPA) 
    * DTO는 Entity를 통해 획득한 데이터를 계층간 전달해주는 용도.
      Entity와 동일할 필요는 없으며, 전달시켜야하는 데이터의 형태에 맞춰 값을 수정해도 된다.
      
* * * 
### 19.12.21 
* * * 
#### Exception
* [사용자 정의 예외](https://edu.goorm.io/learn/lecture/41/%EB%B0%94%EB%A1%9C%EC%8B%A4%EC%8A%B5-%EC%83%9D%ED%99%9C%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94-java/lesson/39283/%EB%82%98%EB%A7%8C%EC%9D%98-%EC%98%88%EC%99%B8-%EB%A7%8C%EB%93%A4%EA%B8%B0)
    * checked or unchecked
        * checked - API 호출자가 오류에 대한 답변을 받아서 처리가 가능 할 경우 사용
                    Exception을 상속받아 구현한다.
                    checked exception이기 때문에 try - catch 구문을 이용해 API 호출자가 이용할 수 있는 에러반환 처리를 제공해야한다.
        * unchecked - API 호출자가 오류에 대한 답변을 받아도 따로 처리가 불가능한 경우
                      RuntimeException을 상속받아 구현한다.
                      ex) convertToDatabaseColumn의 암호화 과정 중 오류가 발생했을 경우 이는 서버단의 문제이기 때문에 프론트에서는 처리가 불가능하다. 이런경우 unchecked로 에러를 처리해야한다.
                      
    * 표준 예외 클래스를 이용해서 많은 예외 상황을 표현하는게 가능하다.
      하지만 예의를 직접 만들어 줌으로써 어떤 상황에서 unchecked가 발생하였고, 어떻게 추적할 것인지에 대해명확히 정의할 수 있다.
      
    * 사용자 정의 예외의 장점은 클래스 변수를 이용하여 추가적인 변수를 이용하여 에러상황에서 좀 더 상세한 파라미터 및 상황에 대한 로그를 남길 수 있다는 장점이 있다.
        * example
          ```java
          class DivideException extends Exception {
              public int left;
              public int right;
          
              DivideException(){
                  super();
              }
              DivideException(String message, int left, int right){
                  super(message);
                  this.left = left;
                  this.right = right;
              }
          }
          class Calculator{
              int left, right;
              public void setOprands(int left, int right){
                  this.left = left;
                  this.right = right;
              }
          
              public void divide() throws DivideException{
                  if(this.right == 0){
                      throw new DivideException("0으로 나누는 것은 허용되지 않습니다.");
                  }
                  System.out.print(this.left/this.right);
              }
          }
          
          class Main {
          
              public static void main(String[] args) {
                  Calculator c1 = new Calculator();
                  c1.setOprands(10, 0);
                  try {
                    c1.divide();
                  } catch(DivideException e) {
                    System.out.println(e.getMessage());
                    System.out.println(e.left);
                    System.out.println(e.right);
                  }
              }
          }
          ```
      
    * [sornalint info] MyOwnRuntimeException()을 생성하여 오류를 처리 할 것을 경고하였다.
    
* * * 
### 19.12.20 
* * * 
#### Spring 이론
* DI(Dependency Injection) 이론 - 1 
    * [DI(Dependency Injection)이란 무엇인가?](https://gmlwjd9405.github.io/2018/11/09/dependency-injection.html)
    * 객체 자체가 아니라 Framework에 의해 객체의 의존성이 주입되는 설계 패턴
        * 의존성이 동적으로 주입되므로, 여러 객체간의 결합이 줄어든다.
        * DI는 spring에서 지원하는 IoC의 형태
    * example
        ```java
        /*
            PetOwner 객체는 AnimalType 객체(Dog)에 의존한다.
            PetOwner 생성자에서 new Dog();를 통해 Dog에 의존성을 가진다.
            이 접근법의 문제점(의존성이 위험한 이유)
            PetOwner 객체는 AnimalType 객체의 생성을 제어하기 때문에 두 객체 간에는 긴밀한 결합(tight coupling)이 생기고, tight coupling에 따라 AnimalType 객체를 변경하면 PetOwner객체도 변경된다.
            즉, 하나의 모듈이 바뀌면 의존한 다른 모듈까지 변경 되어야 한다.
            또한 두 객체 사이의 의존성이 존재하면 Unit Test 작성이 어려워 진다.
        */
        public class PetOwner{
            private AnimalType animal;
        
            public PetOwner() {
                this.animal = new Dog();
            }
        }
        ```
      
        ```java
        /*
          인터페이스를 이용하여 구현을 분리시키고, 메인 로직에서 의존성을 주입시킨다.      
        */
        public interface AninalType {
          public void sound();
        }
      
        public class Cat implements AninalType {
          String myName;
          public void setMyName(String name) {
              this.myName = name;
          }
          public void sound() {
              System.out.println("Cat: " + myName + 
               "-Meow");
          }
        }
      
        public class Cat implements AninalType {
          String myName;
          public void setMyName(String name) {
              this.myName = name;
          }
          public void sound() {
              System.out.println("Cat: " + myName + 
               "-Meow");
          }
        }
      
        public class PetOwner {
          public AnimalType animal;
          public PetOwner(AninalType animal) {
              this.animal = animal;
          }
          public void play() {
              animal.sound();
          }
        }
      
        public class MainApp {
          public static void main(String[] args) {
              /* main함수에서 Container를 생성 */ 
              // 설정 파일은 인자로 넣고, 해당 설정 파일에 맞게 bean들을 만든다.
              ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/di/beans/animal.xml");
              // getBean()을 통해 bean의 주소값을 가져온다.  
              PetOwner person = (PerOwner) context.getBean("petOwner");
              person.play();
              context.close();
          } 
        }
        ```

* [생성자 주입을 사용해야 하는 이유, 필드인젝션이 좋지 않은 이유](https://yaboong.github.io/spring/2019/08/29/why-field-injection-is-bad/)
    * 스프링에서 DI 방법 세가지
        ```java
          //Filed Injection
          @Service
          public class StudentServiceImpl implements StudentService {
          
              @Autowired
              private CourseService courseService;
          
              @Override
              public void studentMethod() {
                  courseService.courseMethod();
              }
          
          }
      
          //Setter Base Injection
          @Service
          public class StudentServiceImpl implements StudentService {
          
              private CourseService courseService;
          
              @Autowired
              public void setCourseService(CourseService courseService) {
                  this.courseService = courseService;
              }
          
              @Override
              public void studentMethod() {
                  courseService.courseMethod();
              }
          }
      
          //Constructor Base Injection
          @Service
          public class StudentServiceImpl implements StudentService {
          
              private final CourseService courseService;
          
              @Autowired
              public StudentServiceImpl(CourseService courseService) {
                  this.courseService = courseService;
              }
          
              @Override
              public void studentMethod() {
                  courseService.courseMethod();
              }
          }
        ```
 * Constructor Base Injection 의 장점
    * NullPointerException 을 방지할 수 있다.
    * 주입받을 필드를 final 로 선언 가능하다.
    * (Spring에서의 장점) 생성자 주입을 이용한 순환참조를 컴파일타임에 확인하여 방지 할 수 있다.
    * 테스트 코드를 작성하기 좋다.
    
* * *
### 19.12.18 
* * * 
* 회식으로 스터디 휴무 

* * *
### 19.12.18 
* * * 
#### Spring의 Annotation - 2
* @ResponseStatus의 용도와 사용방법
    * 사용자에게 원하는 http status code와 reason을 반환
      예외처리 함수 앞에 사용하여 오류 발생시 확정된 오류값을 전달한다.
      ```java
        @RestController
        @RequestMapping("/hello")
        public class HelloController {

            @GetMapping("/")
            @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "my page URL changed..")
            public void getMethod() {
            }
        }      
        ```
      
* @Converter의 용도와 사용방법
    * 변환이 필요한 데이터(Ex. 주민등록번호, 이메일, 패스워드... 등등)을 변환시켜줄때 사용하는 기능
      
#### JPA 사용하기 - 2
* JPA의 정의
    * Java Persistence API의 약자
    * Persistence라는 단어는 Java DTO(Data Transfer Object)에게 '없어지지 않고 오랫동안 지속'되는 '영속성(persistence)'을 부여해준다는 의미.
      즉, 데이터를 DB상에 영구적으로 저장해주는 API 
    * 기존 JDBC만을 이용하는 경우 반복적이며 비슷한 SQL문을 많이 만들어야하고, 데이터베이스의 테이블과 자바 객체간의 매핑하는 소모적인 작업을 지속해야 한다.
      JPA를 사용하게 되면 SQL문을 개발자가 만들지 않기 때문에 객체 중심적인 개발로 생산성과 유지보수의 능률이 크게 오르고, 특정 DBMS 문법에 종속적이지 않은 개발이 가능
      또한 JPA의 영속성 컨텍스트는 효율적인 SQL처리에 크게 기여하여 성능상의 이점도 취할 수 있다.
      
* Entity 만들기
    * Entity란?
        * DB에서 영속적으로 저장된 데이터를 자바 객체로 매핑하여 '인스턴스의 형태'로 존재할 수 있게 해주는 데이터
    * Java에서 Entity Class를 작성하는 방법 (차후 게시판 실제 예제로 변경 진행)
        * ```java
             @Entity
             @Table(name = "product")
             @Getter
             @Setter
             public class Product {
                 @Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 private Long id;
                 @Column(length = 100, nullable = false)
                 private String name;
                 @Column(nullable = false)
                 private int price;
             
                 @ManyToOne
                 @JoinColumn(name ="category_id",nullable = false)
                 private Category category;
             
                 @OneToMany(mappedBy = "product")
                 private Set<Cart> carts;
             }
          ```
* JPA의 Annotation
    * @Entity - Entity클래스임을 명시합니다.
    * @Table(name = "table name") - 매핑할 테이블 명을 지정합니다.
    * @Id - 기본키임을 나타냅니다. 모든 Entity클래스는 @Id설정이 필요합니다. 기본키가 복합키로 된 경우는 @Embeddedid를 사용합니다.
    * @GeneratedValue(strategy = GenerationType.IDENTITY) - JPA가 기본키 생성을 하도록 합니다. 
    * @Column -  Entity클래스의 모든 필드는 데이터베이스의 컬럼과 매핑되어 따로 명시하지 않아도 됩니다. 하지만 매핑될 컬럼명이 다르거나, default값이 다른경우에 사용합니다. (이름은 카멜표기법이 소문자 스네이크 표기법으로 전환되고, length는 255, nullable은 true가 default 값입니다.)
    * @JoinColumn - name에 명시한 category_id라는 컬럼명으로Category에 대한 외래키 설정이 됩니다. 참조 되는 컬럼은 Catrgory Entity클래스에서 @Id가 명시된 필드입니다.
    * @OneToOne - 다른 Entity클래스와의 외래키 다대일(N:1)관계를 명시합니다. 
    * @ManyToOne - 다른 Entity클래스와의 외래키 다대일(N:1)관계를 명시합니다. 
    * @OneToMany - 다른 Entity클래스와 일대다(1:N)관계를 명시합니다. mappedBy에는 제네릭스로 명시된 Cart Entity가 외래키 설정에서 사용한 참조변수 이름입니다. 반대편이 Many 설정일 경우에는 반드시 컬렉션프레임워크(List나 Set)을 사용합니다.  방향성에 대한 자세한 내용은 다음 포스팅을 참고하시기 바랍니다. ☞ JPA Entity간의 방향 설정하기
    
* * *
### 19.12.16 
* * * 
#### JavaBeans란?
* JavaBeans의 정의
 * JavaBeans란 자바로 작성된 소프트웨어 컴포넌트를 지칭하는 단어로 이 컴포넌트를 빈(Bean)이라고 부르며 썬사의 JavaBeans API에 정의된 스펙에 따라 만든다.
 * JavaBeans는 자바 관련 소프트웨어 개발에 있어 재사용이 가능한 표준 컴포넌트 모델이다.

* Beans의 정의
  * java 클래스들을 모아놓은 package 
  * Model, View, Controller(MVC패턴 구현)
    * Model - 저장소역할( setXxx(), getXxx() 구현) - java코딩 
    * View - GUI역할(클라이언트에게 보여줄 화면구성 구현 ) - jsp코딩
    * Controller - DAO(데이터처리 담당 - DB연동)역할 , 비즈니스 로직
  * 내부적으로 보이지 않게 처리해야하는 기능 구현 - java코딩, 서블릿문서
  
* Beans 규약
  1. 기본 생성자가 반드시 존재해야한다. (인자가없는 디폴트 생성자)
  2. 속성을 접급한고 꺼내올수있는 setXXX/getXXX메소드를 구성한다.
  3. 속성을 지정(private)해야하는데 속성 이름은 보통 html의 form태그안에서 input 태그의 name속성 값과 같게 정한다.

#### DAO와 DTO(=VO)의 차이점
* DAO의 정의
DAO는 Data Access Object를 의미한다.
즉, 말 그대로 Database에 접근하기위한 객체라고 보면 된다.
데이터 접근 로직과 비즈니스 로직을 분리하기위해 만들어낸 객체라고 생각하면 된다.

* DTO의 정의
DTO는 Data Transfer Object, VO는 Value Object의 약자이다.
계층간 데이터 교환을 위한 자바빈즈

여기서 '계층'이 의미하는 것은 Controller, View, Business Layer, Persistent Layer를 말하며,
각 계층간 데이터 교환을 위한 객체를 DTO 또는 VO라고 말한다. DTO와 VO의 차이점은 VO가 read only 속성을 가지는 것이다.

#### Lombok Annotation 정리
* @Getter
    * 입력되어 있는 요소들의 getter를 자동으로 생성한다.
* @Setter
    * 입력되어 있는 요소들의 setter를 자동으로 생성한다.
* @AllArgsConstructor
    * 모든 요소들의 값을 입력받는 constructor를 자동으로 생성한다.
* @NoArgsConstructor
    * 기본 constructor를 자동으로 생성한다.

#### Spock 
* [Spock으로 테스트코드를 짜보자](http://woowabros.github.io/study/2018/03/01/spock-test.html)
* Spock 이란?
    * 기존 Junit의 보일러 플레이트를 최대한 제거하고, 다양한 케이스를 테스트하기에 적합하게 개발된 기능
    * 테스트 코드를 작성하며 추가적으로 보완해나갈 예정

* * *
### 19.12.17 
* * * 
#### Spring의 Annotation - 1
* @RestController
    * 해당 함수를 REST controller로 만들어주는 기능
    
* @RequestMapping("value")
    * 입력되어있는 value를 컨트롤러 진입의 자원(resource)으로 지정하는 기능
    
* @GetMapping("value")
    * HTTP GET 요청을 특정 메서드에 맵핑하기위한 annnotation 이다.
    * @RequestMapping(method = RequestMethod.GET)의 역할을 대체 하면서, 더 가독성있게 처리해준다.
        * __공식 코드 주석 내용__
        * Annotation for mapping HTTP {@code GET} requests onto specific handler
        * methods.
        * <p>Specifically, {@code @GetMapping} is a <em>composed annotation</em> that
        * acts as a shortcut for {@code @RequestMapping(method = RequestMethod.GET)}.

* @RequestParam(value(or name) = "value", defaultValue = "default value", required = true/false)
    * 보내주는 파라미터의 key에 맞춰 value을 받아주는 기능.
    * required에 따라서 값의 필수 여부가 결정된다.
    
* @Autowired
    * 각 상황의 타입에 맞는 IoC컨테이너 안에 존재하는 Bean을 자동으로 주입한다.
    
* @Service
    * 해당 클래스의 용도를 명시적으로 알려주며, 동시에 해당 클래스를 Bean에 등록시킨다.
    * Service Layer의 용도는 데이터 호출, 연산 처리 등의 비즈니스로직이 주를 이룬다.
    * DDD를 적용하기 위해서는 서비스를 __애플리케이션 계층__, __도메인 계층__, __인프라 계층__ 으로 나누어 용도에 맞게 코드의 역할을 분할시켜준다. 

#### 요청의 반환
* ResponseEntity
    * HTTP의 표준규약 형식에 맞도록 데이터 형식 및 HTTPStatus를 반환하기 위해서 사용한다.
    * 올바른 응답 코드 및 데이터 구성 형식을 갖출수 있게 된다.
    * 표준 규약을 지킬 경우 frond <> back이 서로 에러상황에 맞춰 정상적인 처리를 유도 할 수 있다.
    
#### JPA 사용하기 - 1
* Repository 만들기
    * repository로 사용 할 interface를 만들어 준 뒤 JpaRepository interface를 상속받아 구현한다.
    

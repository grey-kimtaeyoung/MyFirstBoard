# CRUD-board-basic
## 학습 내용 정리
* * *
### 19.12.26 
* * * 
* REST API(REpresentational State Transfer)
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
* BDD(Behavior Driven Development)
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
* Builder 이용하여 DTO 개선하기
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
* AOP(Aspect Oriented Programming) 이론
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
    

# CRUD-board-basic
## 학습 내용 정리
### 19.12.16 
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
    *
* @Setter
    *
* @AllArgsConstructor
    *
* @NoArgsConstructor
    *

#### Spock 
* Spock으로 테스트코드를 짜보자[http://woowabros.github.io/study/2018/03/01/spock-test.html]
* Spock 이란?
    *

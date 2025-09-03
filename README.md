# Java Web MVC Study – JSP/Servlet & MVC 패턴


> **JSP/Servlet 기초부터 MVC1·MVC2 패턴까지**를 단계적으로 정리한 레포지토리입니다.
> JSP 기본 문법, JSTL/EL, 서블릿 동작 원리, MVC 아키텍처 전환, 계층형 설계까지 **웹 기초 역량을 체계화**하는 것을 목표로 했습니다.


## 학습 목표

* JSP/Servlet 기반 **요청–응답 흐름** 이해 (Forward/Redirect, Param/Encoding, Session/Cookie 등)
* **JSTL/EL**로 JSP의 표현 로직 단순화
* **MVC1 → MVC2**로 구조 개선: 관심사 분리(Controller/Model/View)
* Service/DAO/DTO 등 **계층형 구조**로 확장 가능성 확보
* 작은 예제를 통해 **CRUD·유효성 검증·예외 처리** 등 필수 패턴 습득



##  레포지토리 구조

.
├─ JST/                # JSTL & EL 예제 (조건/반복/포맷팅, 표현식 언어)
├─ Jsp/                # JSP 기본 문법, 지시자/스크립틀릿/액션 태그 등
├─ model/              # DTO/VO, DAO, Service 등 Model 계층 예제
├─ mvc1/               # MVC1 패턴 데모 (JSP 중심 흐름, 컨트롤러 역할 일부 포함)
├─ mvc2/               # MVC2 패턴 데모 (Servlet Controller + JSP View)
├─ mvc2_detail/        # MVC2 심화: Front Controller/Command 패턴, 계층화, 예외 처리
└─ servlet/            # 서블릿 기초(요청/응답, 세션/쿠키, 필터/리스너, 업로드 등)



## ✨ 주요 학습 내용 

### `Jsp/`

* JSP 지시자(`page`, `include`, `taglib`), 액션 태그, 스크립틀릿 최소화
* EL(표현언어) 소개 및 JSP에서의 데이터 바인딩

### `JST/`

* JSTL Core(조건/반복), fmt(날짜/숫자 포맷), fn(문자열 함수) 예제
* EL과 결합해 **표현 로직을 JSP로 이동**, 자바 코드 최소화

### `servlet/`

* `HttpServlet` 라이프사이클, `doGet/doPost` 패턴
* 요청 파라미터/인코딩, Redirect vs Forward
* 세션/쿠키 관리, 필터/리스너 기초, 파일 업로드(멀티파트) 예시

### `model/`

* **DTO/VO**로 데이터 객체 정의
* **DAO**로 데이터 접근 모듈화 (JDBC 예시)
* **Service** 계층으로 비즈니스 로직 분리
* Controller와 View에서 **Model 의존 최소화** 패턴

### `mvc1/`

* JSP가 라우팅/표현을 모두 맡는 **MVC1 스타일**
* 빠르지만 규모가 커질수록 유지보수 어려움 → MVC2로 개선 유도

### `mvc2/`

* **Servlet Controller + JSP View**: 역할 분리된 MVC2 기본형
* 요청 분기/검증/모델호출/뷰 렌더링의 표준 흐름 정립

### `mvc2_detail/`

* **Front Controller 패턴**(공통 진입점) + **Command/Action** 구조
* 예외/로그/인증 등 **횡단 관심사 공통 처리** 준비
* Form 유효성 검증, 메시지 처리, 리다이렉션 전략 등 실무형 스타일




## 학습 로드맵

1. `servlet/` – HTTP, 서블릿 라이프사이클, 세션/쿠키
2. `Jsp/` & `JST/` – JSP 기초 + JSTL/EL로 표현 분리
3. `mvc1/` – JSP 중심의 단순 구조로 흐름 파악
4. `model/` – DTO/DAO/Service 등 계층형 설계 적용
5. `mvc2/` – Controller·Model·View 역할 분리
6. `mvc2_detail/` – Front Controller/Command로 확장, 공통처리 정립


## 내가 얻은 것

* **HTTP–서블릿–JSP–JSTL**로 이어지는 **웹 기본기**를 실습으로 내재화
* MVC1에서 **MVC2로 구조 개선**하며 **관심사 분리/테스트 용이성** 체감
* **DTO/DAO/Service 계층화**로 변경에 강한 구조 설계 경험


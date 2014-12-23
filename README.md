2014년 개발 경험 프로젝트
=========

1. 로컬 개발 환경에 Tomcat 서버를 시작한 후 http://localhost:8080으로 접근하면 질문 목록을 확인할 수 있다. http://localhost:8080으로 접근해서 질문 목록이 보이기까지의 소스 코드의 호출 순서 및 흐름을 설명하라.

* 
localhost:8080으로 접근하면, maven에 설정된 경로에 따라서 WEB-INF에 있는 index.jsp가 호출된다. 
index.jsp는 'list.next'라는 서블릿 주소로 리다이렉트되어 있기 때문에 core.mvc 패키지에 '*.next' 어노테이션이 달려 있는 FrontController 서블릿이 호출된다.
FrontController 에서는 service 메소드가 실행되고 RequestMapping에 있는 findController 메소드가 실행되어
요청한 url에 맞는 컨트롤러를 반환받는다. 여기서는 list controller가 반환된다.
list controller의 excute를 실행하면 questions가 매핑된 MovelandView 클래스인 mav가 반환되고 
mav에 있는 view와 model을 이용해 render 함수를 실행한다. 
render함수는 컨트롤러를 만들때 이용했던 요청url에 따라서 리다이렉트를 해줄지 포워드를 해줄지 결정하여 해당하는 jsp파일을 호출한다. 



# DEVFOX_Study
개인 프로젝트

Java 1.8 / Spring 4.3.6

정리할 내용 
1. aJax 406에러 -> aJax로 리스트 받아올 시 뜸 -> 포이치문 까지 정리
3. 데이터 이동 방법들 정리 -> HTML에서 스크립트로 or 스크립트에서 컨트롤러로 or HTML에서 컨트롤러로 or 컨트롤러에서... 등
4. href 데이터 값 2개 이상 전송 방법 정리
5. 페이징 처리 정리
6. 인터셉터 정리
7. @ControllerAdvice, @ExceptionHandler, @ResponseStatus 어노테이션 정리

------------------------------------------------------------

22-09-26
1. DB 테이블 설계 (userInfoVO, boardVO, replyVO)
2. Mybatis 연결, DB연결
3. 회원가입 기능 구현 (아이디 중복 처리(aJax), 유효성검사)
4. 로그인, 로그아웃 기능 구현 (ID, Password)
5. 게시판 기능 구현 (등록)
6. 게시글 기능 구현 (수정, 삭제)
7. 댓글 기능 구현 (등록, 삭제) 
8. 깃허브 연동

해야 할 것
1. 로그인 유효성 검사
2. 주석 달기...
3. 로그인할 시 댓글 기능 활성화
4. 쓸모 없을 것 같은 userInfo테이블의 Name속성 삭제 및 테스트
5. 게시판 간단히 꾸미기...
6. 페이징 처리
7. 검색 기능 추가
8. 인터셉터 추가

------------------------------------------------------------

22-09-27
1. 페이징 처리 완료
2. 검색 기능 추가 완료
3. 게시판 간단히 꾸미기 완료
4. 로그인 유효성 검사 완료

해야 할 것
1. 주석
2. 로그인 댓글 기능
3. Name속성 삭제
4. 인터셉터

------------------------------------------------------------

22-09-28
1. 주석 완료
2. 로그인 댓글 기능 완료
3. Name속성 삭제 완료
4. 전체적인 유효성 검사 및 테스트 완료

해야 할 것
1. 인터셉터 처리

------------------------------------------------------------

22-09-29
1. 인터셉터 처리 완료
2. 404, 500 에러 페이징 처리 추가 및 완료
3. 회귀 테스트 완료

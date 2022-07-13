package kopo.poly;

public class JSPMemo {
/*
     자바스프링 순서
    URL 호출 -> Controller(자바로 만듦) -> Service(자바로 만듦) -> Mapper(자바와 XML 로 만듦) -> DB(오라클)
    JSP <- Controller(자바로 만듦) <- Service(자바로 만듦) <- Mapper(자바와 XML 로 만듦) <- DB(오라클)

    Controller : URL 에서 오는 모든 내용을 받음
                EX) 로그인 할 때 ID PASS 친 다음에 엔터를 치면 데이터가 Controller 로 감
    Service : controller 에서 온 데이터 정제, 백에서 하는 기능을 거의 다 service 에서 처리
    Mapper : 쿼리문 작성해서 DB 에서 데이터 처리하는 로직
    DB : 데이터저장소
    DTO : 자바 파일에서 자바 파일로 넘어갈 때 편하게 해줌
        메서드를 쓸 때 메서드 안에 매개변수를 클래스 형태로 저장해두고 SUM (DTO) 같이 쓸 수 있음
        EX) SUM(int a, int b, int c)
            => DTO 안에 (int a, int b, int c) 저장
                => SUM(DTO)
    mybatis : xml 를 통해서 sql 를 사용할 수 있게한다.


    궁금한 거 (7/6) :
                    model :
                    @reQuestMapping :
                    log.info :
                      <button onclick="location.href='NoticeUpdate?no=<%=rDTO.getNotice_seq()%>'">수정</button> :
                      <div style="">작성자 : <%=CmmUtil.nvl(rDTO.getReg_id())%></div> :

    굼금한 거 (7/7) :
                    (HttpServletRequest request, ModelMap model) :
                    this.getClass().getName() :



*/
}

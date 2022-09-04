package kopo.poly.controller;

import kopo.poly.dto.NoticeDTO;
import kopo.poly.service.INoticeService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j // 로그 사용을 위한 선언
@Controller // 해당 자바 파일이 Controller 라고 알리는 선언
public class NoticeController {
    // Controller 는 service 에게 넘겨야하기 때문에 service 를 찾아야 한다

    @Resource(name = "NoticeService") // @resource 는 service 를 찾아주는 거
    private INoticeService noticeService;

    @GetMapping(value ="index")
    public String indexPage() throws Exception {
        log.info(this.getClass().getName() + " .indexPage Start !!");
        log.info(this.getClass().getName() + " .indexPage End !!");

        return "index"; // index = jsp 파일의 이름
    }

    @GetMapping(value = "noticeInfo") // noticeInfo 는 form 을 호출
    public String noticeInfo() throws Exception {
        log.info(this.getClass().getName() + " .noticeInfo Start!!");
        log.info(this.getClass().getName() + " .noticeInfo End!!");
        return "form";
    }

    @PostMapping(value = "getNoticeData") //
    public String getNoticeData(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .getNoticeData Start!!");
        String title = CmmUtil.nvl(request.getParameter("title"));
        String name = CmmUtil.nvl(request.getParameter("reg_id"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("title : " + title);
        log.info("name : " + name);
        log.info("content : " + contents);

        model.addAttribute("title",title);
        model.addAttribute("name",name);
        model.addAttribute("contents",contents);

        log.info(this.getClass().getName() + " .getNoticeData End");
        return "getNoticeData";
    }

    @RequestMapping(value = "getInsertNotice")
    public String gerInsertNotice(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .getNoticeData Start !! ");
        String reg_id = CmmUtil.nvl(request.getParameter("reg_id"));
        String title = CmmUtil.nvl(request.getParameter("title"));
        String contents = CmmUtil.nvl(request.getParameter("contents"));

        log.info("reg_id : " + reg_id);
        log.info("title : " + title);
        log.info("contents : " + contents);

        NoticeDTO pDTO = new NoticeDTO();   // service 에게 편하게 데이터를 전달하기 위해서 DTO 객체 생성
        pDTO.setReg_id(reg_id);
        pDTO.setTitle(title);   // 내용담기
        pDTO.setContents(contents);

        int res = noticeService.InsertNoticeInfo(pDTO); //
        // 저장되면 1의 값을 안되면 0의 값을 가져옴
        String msg;
        String url = " /getNoticeList";

        if (res>0) {
            msg = "등록에 성공하셨습니다.";
        }else {
            msg = "등록에 실패하셨습니다.";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("url",url);

        log.info(this.getClass().getName() + " .getNoticeData End!!");
        return "redirect";
    }

    @RequestMapping(value = "getNoticeList")
    public String getNoticeList(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .getNoticeList Start!!");

        List<NoticeDTO> rList = noticeService.getNoticeList();  // NoticeDTO == 게시글 하나, 게시글이 여러개있기 때문에 컬렉션 프레임 워크에 넣어준다.

        if (rList == null){
            rList = new ArrayList<>();
        }
        model.addAttribute("rList",rList);

        log.info(this.getClass().getName() + " .getNotice End !!");

        return "noticeList";
    }
    @RequestMapping(value = "NoticeDetail")
    public String NoticeDetail(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .NoticeDetail start !!");
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));

        NoticeDTO pDTO = new NoticeDTO();
        pDTO.setNotice_seq(notice_seq);

        NoticeDTO rDTO = noticeService.getNoticeDetail(pDTO);
        if (rDTO == null){
            model.addAttribute("msg","존재하지 않는 게시물입니다!");
            model.addAttribute("url","getNoticeList");
            return  "redirect";
        }
        model.addAttribute("rDTO",rDTO);

        log.info(this.getClass().getName() + " .NoticeDetail End !!");
        return "noticeDetail";
    }

    @GetMapping(value = "NoticeDelete")
    public String noticeDelete(HttpServletRequest request,Model model) throws Exception{
        log.info(this.getClass().getName() + " .noticeDelete start!!");
        /* url에서 "no"로 보내기 때문에 컨트롤러에서 'no'로 받는다 */
        String notice_seq = CmmUtil.nvl(request.getParameter("no"));
        log.info("notice_seq : "+notice_seq);

        /* NoticeDTO에 객체를 생성하고 그 안에 notice_seq를 담는다 */
        NoticeDTO nDTO = new NoticeDTO();
        nDTO.setNotice_seq(notice_seq);

        /* delete 성공하면 1 실패하면 0 출력 */
        int res = noticeService.noticeDelete(nDTO);

        String msg;
        String url;

        if (res > 0){
            msg = "삭제 성공!";
            url = "getNoticeList";
        }else {
            msg = "삭제 실패...ㅠ";
            url = "NoticeDetail?no" + notice_seq;
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        return "redirect";
    }

    @GetMapping(value = "NoticeUpdate")
    public String NoticeUpdate(HttpServletRequest request, ModelMap model) throws Exception {
        log.info(this.getClass().getName() + " .NoticeUpdate Start!!");
        String Notice_seq = request.getParameter("no");
        log.info(Notice_seq);
        model.addAttribute("Notice_seq",Notice_seq);
        log.info(this.getClass().getName() + " .NoticeUpdate End!!");
        return "editForm";
    }
    @GetMapping(value = "DoNoticeUpdate")
    public String DoNoticeUpdate(HttpServletRequest request, Model model) throws Exception{
        log.info(this.getClass().getName() + " .DoNoticeUpdate Start!!");
        String notice_seq = request.getParameter("Notice_seq");
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        log.info("번호 : " + notice_seq);
        log.info("제목 : " + title);
        log.info("내용 : " + contents);


        NoticeDTO nDTO = new NoticeDTO();
        nDTO.setReg_id(notice_seq);
        nDTO.setTitle(title);
        nDTO.setContents(contents);

        int res = noticeService.noticeUpdate(nDTO);

        String msg,url;
        
        if (res > 0){
            msg = "수정 성공!";
            url = "NoticeDetail?no" + notice_seq;
        }else {
            msg = "수정 실패...ㅠ";
            url = "NoticeDetail?no" + notice_seq;
        }

        model.addAttribute("msg", msg);
        model.addAttribute("url", url);

        log.info(this.getClass().getName() + " .DONoticeUpdate End!!");
        return "redirect";
    }
}

package kopo.poly.controller;

import kopo.poly.dto.UserDTO;
import kopo.poly.service.IUserService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j // 로그 사용을 위한 선언
@Controller // 해당 자바 파일이 Controller 라고 알리는 선언

public class UserController {
    @Resource(name = "UserService")
    private IUserService UserService;

    @GetMapping(value = "UserInfo")
    public String UserInfo() throws Exception{
        log.info(this.getClass().getName() + " .UserInfo Start!!");
        log.info(this.getClass().getName() + " .UserInfo End!!");
        return "userInfo";
    }

    @GetMapping(value = "InsertUserInfo")
    public String insertUserInfo(HttpServletRequest request, Model model) throws Exception {
        log.info(this.getClass().getName() + " .InsertUserInfo Start!!");
        String User_Name = CmmUtil.nvl(request.getParameter("user_name"));
        String User_Id = CmmUtil.nvl(request.getParameter("user_id"));
        String User_Pwd = CmmUtil.nvl(request.getParameter("user_pwd"));
        String User_Email = CmmUtil.nvl(request.getParameter("user_email"));

        log.info(User_Name);
        log.info(User_Id);
        log.info(User_Pwd);
        log.info(User_Email);

        UserDTO uDTO = new UserDTO();
        uDTO.setUser_name(User_Name);
        uDTO.setUser_id(User_Id);
        uDTO.setUser_pwd(User_Pwd);
        uDTO.setUser_email(User_Email);

        int res = UserService.InsertUserInfo(uDTO);

        String msg;
        String url;

        if (res > 0){
            msg = "회원가입 성공!";
            url = "UserLoginPage";
        }else {
            msg = "회원가입 실패...ㅠ";
            url = "UserInfo";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("url",url);

        log.info(this.getClass().getName() + " .InsertUserInfo End!!");
        return "redirect";
    }

    @RequestMapping(value = "UserLoginPage")
    public String UserLoginPage() throws Exception{
        log.info(this.getClass().getName() + " .UserLoginPage Start!!");
        log.info(this.getClass().getName() + " .UserLoginPage End!!");
        return "userLoginPage";
    }

    @RequestMapping(value = "UserLogin")
    public String UserLogin(HttpServletRequest request,Model model) throws Exception {
        log.info(this.getClass().getName() + " .UserLogin Start!!");
        String User_Id = CmmUtil.nvl(request.getParameter("user_id"));
        String User_Pwd = CmmUtil.nvl(request.getParameter("user_pwd"));

        log.info(User_Id);
        log.info(User_Pwd);

        UserDTO uDTO = new UserDTO();
        uDTO.setUser_id(User_Id);
        uDTO.setUser_pwd(User_Pwd);

//        String url, msg;

        UserDTO pDTO = UserService.UserLogin(uDTO);
        log.info(String.valueOf(pDTO));
        if (pDTO == null){
            model.addAttribute("msg","존재하지 않는 아이디입니다!");
            model.addAttribute("url","UserLoginPage");

            log.info(this.getClass().getName() + " .UserLogin End!!");
            return "redirect";
        }else {
            model.addAttribute("msg","로그인 성공!");
            model.addAttribute("url","getNoticeList");

            log.info(this.getClass().getName() + " .UserLogin End!!");
            return "redirect";
        }
    }
    @RequestMapping(value = "UserLogOut")
    public String UserLogOut() throws Exception{
        log.info(this.getClass().getName() + " .UserLogOut Start!!");
        log.info(this.getClass().getName() + " .UserLogOut End!!");
        return "UserLoginPage";
    }
}

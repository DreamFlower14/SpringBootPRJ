package kopo.poly.service.impl;


import kopo.poly.dto.UserDTO;
import kopo.poly.persistance.mapper.INoticeMapper;
import kopo.poly.persistance.mapper.IUserMapper;

import kopo.poly.service.IUserService;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("UserService")
public class UserService implements IUserService {

    private final IUserMapper userMapper;

    @Autowired // resource 랑 같은 역할 Mapper 를 찾아줌
    public UserService(IUserMapper userMapper){ this.userMapper = userMapper;}


    @Override
    public int InsertUserInfo(UserDTO uDTO) throws Exception {
        log.info(this.getClass().getName() + " .InsertUserInfo Start!!");
        int res = userMapper.InsertUserInfo(uDTO);
        log.info(this.getClass().getName() + " .InsertUserInfo Ends!!");
        return res;
    }

    @Override
    public UserDTO UserLogin(UserDTO uDTO) throws Exception {
        log.info(this.getClass().getName() + " .UserLogin Start!!");
        UserDTO iDTO = userMapper.UserLogin(uDTO); // mapper 에 넣고 결과를 iDTO 에 넣는다
        log.info(this.getClass().getName() + " .UserLogin Ends!!");
        return iDTO; // controller 에 보낼거
    }
}
package kopo.poly.service;

import kopo.poly.dto.UserDTO;

public interface IUserService {

    int InsertUserInfo(UserDTO uDTO) throws Exception;

    UserDTO UserLogin(UserDTO uDTO) throws Exception;
}


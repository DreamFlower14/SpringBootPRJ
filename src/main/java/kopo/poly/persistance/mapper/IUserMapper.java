package kopo.poly.persistance.mapper;

import kopo.poly.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface IUserMapper {
    int InsertUserInfo(UserDTO uDTO) throws Exception;

    UserDTO UserLogin(UserDTO oDTO) throws Exception;
}
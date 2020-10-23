package pers.czl.mapper;


import org.apache.ibatis.annotations.Param;
import pers.czl.entity.User;

public interface UserMapper {
    User selectById(@Param("param1") Long id);
}

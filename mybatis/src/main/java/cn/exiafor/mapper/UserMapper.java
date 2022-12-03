package cn.exiafor.mapper;

import cn.exiafor.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 添加用户信息
     */
    int insertUser(@Param("username") String username,
                   @Param("password") String password);

    /**
     * 删除用户信息
     */
    int deleteUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 查询一个实体类对象
     */
    User getUser();

    /**
     * 查询list集合
     */
    List<User> getUserList();

    // 查询功能

    /**
     * 根据用户id查询用户信息
     * @param userId 用户id
     * @return 用户对象
     */
    User getUserById(@Param("userId") int userId);

    /**
     * 查询用户的总记录数
     * @return 记录数
     */
    int getCount();

    /**
     * 根据用户id查询用户信息为map集合
     */
    @MapKey("user_id")
    Map<String, Object> getUserToMap(@Param("userId") int userId);

    /**
     * 模糊查询
     */
    List<User> testMoHu(@Param("moHu") String moHu);
}

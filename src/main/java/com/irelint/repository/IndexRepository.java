package com.irelint.repository;

import com.irelint.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by vincent on 2016-12-23.
 */
@Repository
public interface IndexRepository extends JpaRepository<User,Integer>{
    @Modifying // 说明该方法是修改操作
    // 定义查询
    // @Param注解用于提取参数
    @Query("update User u set u.name=?1 where u.id=?2")
    public void updateInfo(String name,Integer id);


    @Query("select u from User u where u.id=?1 and u.name=?2")
    public User findById(String id,Integer name);
}

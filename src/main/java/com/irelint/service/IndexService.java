package com.irelint.service;

import com.irelint.entity.User;
import com.irelint.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vincent on 2016-12-23.
 */
@Service("userService")
@Transactional
public class IndexService{
        @Autowired
        private IndexRepository repository;
        public void saveUser(User user) {
            repository.saveAndFlush(user);
        }

        public List<User> getUsers() {
            return repository.findAll();
        }
        public User getUserById(){
            return repository.findOne(6);
        }
        public void delUser(Integer id){
            repository.delete(id);
            repository.flush();
        }

        public void updateUser(){
            User user = getUserById();
            user.setName("修改过");
        }
        public void updateInfo(String name,Integer id){
            repository.updateInfo(name,id);
        }
}

package com.song.data;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;

/**
 * 启动时添加测试数据
 */
//@Configuration
public class InitData {
  @Resource
  private UserRepository userRepository;

  /**
   * 初始化数据
   */
  @PostConstruct
  public void init() {
    //System.out.println(userRepository.findUserByIdBefore(3));
    EnumSet<Gender> genders = EnumSet.allOf(Gender.class);
    List<User> users = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      User user = User.builder().name("test" + i)
          .gender(genders.stream().findAny().get()).build();
      users.add(user);
    }
    userRepository.saveAll(users);
  }
}

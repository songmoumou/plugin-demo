package com.song.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author AJohn
 */
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {

  /**
   * /api/user/search/findByName
   */
  List<User> findByName(@Param("name") String name);

  /**
   * 自定义jpa接口
   * http://localhost:8080/api/user/search/findUserByIdBefore?id=3
   */
  List<User> findUserByIdBefore(@Param("id") Integer id);

  /**
   * /api/user/1
   */
  @Override
  @Modifying
  @Query("UPDATE User u SET u.deleted = true WHERE u.id = ?1")
  void deleteById(Integer id);

}
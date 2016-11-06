package com.sync.dao;

import com.sync.jdbc.dao.DaoFactory;
import com.sync.jdbc.dao.UserDao;
import com.sync.jdbc.domain.User;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/3 0003.
 */
public class UserDaoTest {

  public static void main(String[] args) {
    UserDao userDao = DaoFactory.getInstance().getUserDao();

    User user = new User();
    user.setBirthday(new Date());
    user.setName("dao name1");
    user.setMoney(1000.0f);

    userDao.addUser(user);
    //
    //User u = userDao.findUser("dao name1", null);
    //System.out.println(u.getId());

    //User u = userDao.getUser(6);
    //u.setMoney(2000.0f);
    //userDao.update(u);

    //User u1 = userDao.getUser(6);
    //userDao.delete(u1);
  }

}

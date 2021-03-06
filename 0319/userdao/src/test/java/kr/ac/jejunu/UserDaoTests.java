package kr.ac.jejunu;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTests {
    String name = "hulk";
    String password = "1234";

    @Test
    public void findById() throws SQLException, ClassNotFoundException {

        Integer id = 1;

        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();
        User user = userDao.findById(id);

        assertThat(user.getId(),is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(),is(password));
    }

    @Test
    public void insert() throws SQLException, ClassNotFoundException {
        User user = new User();

        user.setName(name);
        user.setPassword(password);

        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao = daoFactory.getUserDao();

        userDao.insert(user);
        assertThat(user.getId(),greaterThan(0));

        User insertedUser = userDao.findById(user.getId());
        assertThat(insertedUser.getName(),is(name));
        assertThat(insertedUser.getPassword(),is(password));

    }

}

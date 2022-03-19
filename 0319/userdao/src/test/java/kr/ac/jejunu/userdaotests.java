package kr.ac.jejunu;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class userdaotests {
    @Test
    public void findById() throws SQLException, ClassNotFoundException {
        Userdao userdao = new Userdao();
        Integer id = 1;
        String name = "hulk";
        String password = "1234";

        User user = userdao.findById(id);

        assertThat(user.getId(),is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(),is(password));
    }
}
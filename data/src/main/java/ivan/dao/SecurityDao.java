package ivan.dao;

import ivan.pojo.Security;

import java.util.List;

public interface SecurityDao {

    List<Security> findByLogin(String login);

}

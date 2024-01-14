package ivan.dao;

import ivan.pojo.Security;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SecurityDaoImpl implements SecurityDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Security> findByLogin(String login) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Security au where au.login=:login", Security.class)
                .setParameter("login", login)
                .list();
    }
}

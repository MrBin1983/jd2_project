package ivan.dao;

import ivan.TestDataConfiguration;
import ivan.pojo.Security;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataConfiguration.class)
public class SecurityDaoImplTest {

    @Autowired
    SecurityDao securityDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByLogin() {
//Given
        String adminLogin = "admin";
        //When
        List<Security> results = securityDao.findByLogin(adminLogin);
        //Then
        assertEquals(1, results.size());
        assertEquals("admin", results.get(0).getPassword());
        assertEquals("ROLE_ADMIN", results.get(0).getRole());
    }
}
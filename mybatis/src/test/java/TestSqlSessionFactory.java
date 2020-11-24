import com.mysql.cj.jdbc.MysqlDataSource;
import com.watero.entity.OrderInfo;
import com.watero.entity.UserInfo;
import com.watero.mapper.OrderInfoMapper;
import com.watero.mapper.UserInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class TestSqlSessionFactory {
    private SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory buildSqlSessionFactoryByCode() throws SQLException {
        DataSource dataSource = this.getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(null);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    @Before
    public void before() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() {
        System.out.println(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Object> selectUserInfoById = sqlSession.selectList("selectUserInfoById", "897238156");
        System.out.println(selectUserInfoById);

        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        UserInfo userInfo = userInfoMapper.selectUserInfoById("897238156");
        System.out.println(userInfo);
    }

    @Test
    public void test2() throws SQLException {
        System.out.println(this.getDataSource());
        Connection connection = this.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        boolean execute = statement.execute("select * from t_user_info");
        ResultSet resultSet = statement.getResultSet();
        resultSet.last(); // 将光标移动到最后一行
        int rowCount = resultSet.getRow();
        System.out.println(rowCount);
    }

    public DataSource getDataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("demo");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setServerTimezone("GMT");
        return dataSource;
    }


    @Test
    public void insertUserInfo() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            UserInfoMapper mapper = sqlSession.getMapper(UserInfoMapper.class);
            int i = mapper.insertUserInfo(new UserInfo("1", "HI", "hi",
                    "123", new Date(), new Date(), false));
            System.out.println(i);
        }
    }

    @Test
    public void insertOrderInfo() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            OrderInfoMapper mapper = sqlSession.getMapper(OrderInfoMapper.class);
            OrderInfo orderInfo = new OrderInfo(null, new Date(),
                    "897238156", 1l, 1l, new Date());
            System.out.println(orderInfo);
            int i = mapper.insertOrderInfo(orderInfo);
            System.out.println(orderInfo);
            sqlSession.commit();

        }
    }

}

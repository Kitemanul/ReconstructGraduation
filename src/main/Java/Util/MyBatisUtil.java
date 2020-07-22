package Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {

    static private SqlSessionFactory sqlSessionFactory;

    static {
        try{
            String resource = "Mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static SqlSession openSqlsession()
    {
        return sqlSessionFactory.openSession();
    }


}

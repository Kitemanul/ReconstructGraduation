package Service.CellerService;

import Dao.Celler.CellerMapper;
import POJO.CellerInOut;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CellerServiceImpl implements CellerService {



    @Override
    public int DeleteCeller(CellerInOut outceller) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        CellerMapper cellerMapper=sqlSession.getMapper(CellerMapper.class);
        int row= cellerMapper.DeleteCeller(outceller);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int EditCeller(CellerInOut outceller, CellerInOut newceller) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        CellerMapper cellerMapper=sqlSession.getMapper(CellerMapper.class);
        int row= cellerMapper.EditCeller(outceller,newceller);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public int AddCeller(CellerInOut celler) {

        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        CellerMapper cellerMapper=sqlSession.getMapper(CellerMapper.class);
        int row= cellerMapper.AddCeller(celler);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    @Override
    public List<CellerInOut> SearchCeller(CellerInOut celler) {

        List<CellerInOut> res=null;
        SqlSession sqlSession=MyBatisUtil.getSqlSession();

        CellerMapper cellerMapper=sqlSession.getMapper(CellerMapper.class);

        res=cellerMapper.SelectAllCeller(celler);

        sqlSession.close();

        return res;
    }
}

package Service.CellerService;

import Dao.BaseDao;
import Dao.Celler.CellerDaoImpl;
import POJO.CellerInOut;

import java.sql.Connection;
import java.util.List;

public class CellerServiceImpl implements CellerService {
    private CellerDaoImpl cellerDao;

    public CellerServiceImpl()
    {
        cellerDao=new CellerDaoImpl();
    }


    @Override
    public int DeleteCeller(CellerInOut outceller) {
        Connection con=BaseDao.getConnection();

        int row=cellerDao.DeleteCeller(con,outceller);

        BaseDao.close(con,null,null);
        return row;
    }

    @Override
    public int EditCeller(CellerInOut outceller, CellerInOut newceller) {
        Connection con=BaseDao.getConnection();

        int row=cellerDao.EditCeller(con,outceller,newceller);

        BaseDao.close(con,null,null);

        return row;
    }

    @Override
    public int AddCeller(CellerInOut celler) {
        Connection con=BaseDao.getConnection();

        int row=cellerDao.AddCeller(con,celler);

        BaseDao.close(con,null,null);
        return row;
    }

    @Override
    public List<CellerInOut> SearchCeller(String[] condition,Object[] objects) {

        Connection con= BaseDao.getConnection();

        List<CellerInOut> res=cellerDao.SelectAllCeller(con,condition,objects);

        BaseDao.close(con,null,null);


        return res;
    }
}

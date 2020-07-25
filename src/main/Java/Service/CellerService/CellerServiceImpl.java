package Service.CellerService;

import Dao.Celler.CellerMapper;
import POJO.CellerInOut;
import Util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CellerServiceImpl implements CellerService {

    CellerMapper cellerMapper;

    public void setCellerMapper(CellerMapper cellerMapper) {
        this.cellerMapper = cellerMapper;
    }

    @Override
    public int DeleteCeller(CellerInOut outceller) {

        return cellerMapper.DeleteCeller(outceller);
    }

    @Override
    public int EditCeller(CellerInOut outceller, CellerInOut newceller) {

        return cellerMapper.EditCeller(outceller,newceller);
    }

    @Override
    public int AddCeller(CellerInOut celler) {

        return cellerMapper.AddCeller(celler);
    }

    @Override
    public List<CellerInOut> SearchCeller(CellerInOut celler) {

        return cellerMapper.SelectAllCeller(celler);
    }
}

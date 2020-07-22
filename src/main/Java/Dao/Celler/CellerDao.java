package Dao.Celler;



import POJO.CellerInOut;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public interface CellerDao {


    public List<CellerInOut> SelectAllCeller(Connection con, String[] condition,Object[] objects);


    public int AddCeller(Connection con,CellerInOut celler);

    public int EditCeller(Connection con,CellerInOut oudceller,CellerInOut newceller);

    public int DeleteCeller(Connection con,CellerInOut oudceller);
}

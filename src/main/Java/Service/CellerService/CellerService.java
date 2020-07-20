package Service.CellerService;

import POJO.CellerInOut;

import java.util.List;

public interface CellerService {

    public List<CellerInOut> SearchCeller(String[] condition,Object[] objects);

    public int AddCeller(CellerInOut celler);

    public int EditCeller(CellerInOut outceller,CellerInOut newceller);

    public int DeleteCeller(CellerInOut outceller);
}

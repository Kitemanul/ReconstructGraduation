package Service.TemperatureService;

import POJO.CellerInOut;
import POJO.WorkShop;

import java.util.List;

public interface TemperatureService {

    public List<WorkShop> SearchTempearture(int rate, CellerInOut in);

    public List<WorkShop> SearchErrorTempearture(WorkShop workShop);
}

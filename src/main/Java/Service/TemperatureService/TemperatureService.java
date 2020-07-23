package Service.TemperatureService;

import POJO.CellerInOut;
import POJO.Temperature;
import POJO.WorkShop;

import java.util.List;

public interface TemperatureService {

    public List<WorkShop> SearchTempearture(int rate, CellerInOut in);

    public List<Temperature> SearchErrorTempearture(Temperature tem);
}

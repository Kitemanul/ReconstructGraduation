package Service.TemperatureService;

import POJO.Temperature;

import java.util.List;

public interface TemperatureService {

    public List<Temperature> SearchTempearture(int rate,Temperature tem);

    public List<Temperature> SearchErrorTempearture(Temperature tem);
}

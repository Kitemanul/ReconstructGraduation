package Dao.Temperature;

import POJO.CellerInOut;
import POJO.Temperature;
import POJO.WorkShop;
import org.apache.ibatis.annotations.Param;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public interface TemperatureMapper {

    List<WorkShop> SearchTemperature(@Param("map") HashMap<String,String> map);

    List<WorkShop> SearchErrorTemperature(@Param("map") HashMap<String,String> map);
}

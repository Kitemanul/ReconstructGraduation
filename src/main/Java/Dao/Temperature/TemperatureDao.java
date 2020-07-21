package Dao.Temperature;

import POJO.Temperature;

import java.sql.Connection;
import java.util.List;

public interface TemperatureDao {

    List<Temperature> SearchTemperature(Connection con,Object[] objects,String jar);
}

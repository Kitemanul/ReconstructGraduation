package POJO;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class WorkShop {

    private int id;
    private Date time;
    private int shopid;
    private int groupid;
    private String jarid;
    private float teperatrue;
    private float rate;

}

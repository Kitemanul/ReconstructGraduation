package POJO;

import java.util.Date;

public class CellerInOut {

    private int id;
    private int period;
    private int groupid;
    private int jarid;
    private Date time;
    private Date intime;
    private Date outtime;
    private Date Etime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getGroupid() {
        return groupid;
    }


    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getJarid() {
        return jarid;
    }

    public void setJarid(int jarid) {
        this.jarid = jarid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public Date getEtime() {
        return Etime;
    }

    public void setEtime(Date etime) {
        Etime = etime;
    }

}

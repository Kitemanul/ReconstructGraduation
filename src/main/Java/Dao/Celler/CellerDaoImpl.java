package Dao.Celler;

import Dao.BaseDao;
import POJO.CellerInOut;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CellerDaoImpl implements CellerDao {
    @Override
    public int DeleteCeller(Connection con, CellerInOut oudceller) {

        PreparedStatement pre=null;
        int row=0;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String sql="delete from dbo.出窖入窖  where 时间=? and 入窖时间=? and 出窖时间=? and 组号=? and 罐号=? and 周期=?";
        try {
            row=BaseDao.Update(con,sql,pre,new Object[]{format.format(oudceller.getTime()),format.format(oudceller.getIntime()),format.format(oudceller.getOuttime()),oudceller.getGroupid(),oudceller.getJarid(),oudceller.getPeriod()});
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.close(null,pre,null);
        }

        return row;
    }

    @Override
    public int EditCeller(Connection con, CellerInOut oudceller, CellerInOut newceller) {

        PreparedStatement pre=null;
        int row=0;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String sql="update 出窖入窖 set 时间=?,周期=?,出窖时间=?,组号=?,罐号=? where 时间=? and 入窖时间=? and 出窖时间=? and 组号=? and 罐号=? and 周期=?";
        try {
            row=BaseDao.Update(con,sql,pre,new Object[]{format.format(newceller.getTime()),newceller.getPeriod(),format.format(newceller.getOuttime()),newceller.getGroupid(),newceller.getJarid(),format.format(oudceller.getTime()),format.format(oudceller.getIntime()),format.format(oudceller.getOuttime()),oudceller.getGroupid(),oudceller.getJarid(),oudceller.getPeriod()});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,pre,null);
        }
        return row;
    }

    @Override
    public List<CellerInOut> SelectAllCeller(Connection con, String[] condition,Object[] objects) {

        PreparedStatement pre=null;
        String sql="select * from 出窖入窖";

        ResultSet set=null;
        List<CellerInOut> res=new ArrayList<>();

        try{
            if(condition.length==0)
            {
                set=BaseDao.Find(con,sql,pre,set,new Object[]{});
                while(set.next())
                {
                    CellerInOut celler=new CellerInOut();
                    celler.setTime(set.getTimestamp("时间"));
                    celler.setPeriod(set.getInt("周期"));
                    celler.setIntime(set.getTimestamp("入窖时间"));
                    celler.setOuttime(set.getTimestamp("出窖时间"));
                    celler.setJarid(set.getInt("罐号"));
                    celler.setGroupid(set.getInt("组号"));
                    res.add(celler);
                }

            }
            else {
                ArrayList<String> list=new ArrayList<>();

                sql=sql+" where 自动编号 >0";

                for(int i=0;i<condition.length;i++)
                {
                    if(condition[i]=="入窖时间"||condition[i]=="出窖时间")
                    {
                        sql=sql+" AND (入窖时间 BETWEEN '"+condition[i]+" 00:00:00:000'"+" AND '"+condition[i]+" 23:59:59:000')";
                        continue;
                    }

                    sql=sql+" and "+condition[i]+"=?";
                }
                set=BaseDao.Find(con,sql,pre,set,objects);
                while(set.next())
                {
                    CellerInOut celler=new CellerInOut();
                    celler.setTime(set.getTime("时间"));
                    celler.setPeriod(set.getInt("周期"));
                    celler.setIntime(set.getTime("入窖时间"));
                    celler.setOuttime(set.getTime("出窖时间"));
                    celler.setJarid(set.getInt("罐号"));
                    celler.setGroupid(set.getInt("组号"));
                    res.add(celler);
                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,pre,set);
        }
        return res;
    }

    @Override
    public int AddCeller(Connection con, CellerInOut celler) {

        PreparedStatement preparedStatement=null;
        int row=0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String sql="Insert into 出窖入窖 (时间,入窖时间,出窖时间,周期,预期时间,组号,罐号) values(?,?,?,?,?,?,?)";
        try {
            row=BaseDao.Update(con,sql,preparedStatement,new Object[]{sf.format(celler.getTime()),sf.format(celler.getIntime()),sf.format(celler.getOuttime()),celler.getPeriod(),sf.format(celler.getEtime()),celler.getGroupid(),celler.getJarid()});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            BaseDao.close(null,preparedStatement,null);
        }
        return row;
    }
}

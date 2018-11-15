package com.lesson.dao;

import com.lesson.model.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuDAO {

    public List<Menu> getAllMenus();

    public List<Menu> getMenuByMidCid(String mid, String cid);

    public int addMenu(int cid, String mname, float price);

    public int updateMenuByMid(int mid, int cid, String mname,  float price);

    public int deleteMenuByMid(int mid);
}

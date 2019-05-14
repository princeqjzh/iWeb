package com.lesson.dao;

import com.lesson.model.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiZhi.Qian on 2018/11/15.
 */
public class MenuDAOImpl implements MenuDAO {
    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<Menu>();

        Menu menu1 = new Menu();
        menu1.setCid(1);
        menu1.setMid(1);
        menu1.setMname("宫保鸡丁");
        menu1.setPrice(22.5f);
        menus.add(menu1);

        Menu menu2 = new Menu();
        menu2.setCid(1);
        menu2.setMid(2);
        menu2.setMname("炸酱面");
        menu2.setPrice(18.0f);
        menus.add(menu2);

        Menu menu3 = new Menu();
        menu3.setCid(1);
        menu3.setMid(3);
        menu3.setMname("卤煮火烧");
        menu3.setPrice(35.0f);
        menus.add(menu3);

        Menu menu4 = new Menu();
        menu4.setCid(2);
        menu4.setMid(4);
        menu4.setMname("红柳大串");
        menu4.setPrice(15.0f);
        menus.add(menu4);

        Menu menu5 = new Menu();
        menu5.setCid(2);
        menu5.setMid(5);
        menu5.setMname("烤馕");
        menu5.setPrice(10.0f);
        menus.add(menu5);

        Menu menu6 = new Menu();
        menu6.setCid(2);
        menu6.setMid(6);
        menu6.setMname("红烧牛肉");
        menu6.setPrice(41.0f);
        menus.add(menu6);

        return menus;
    }

    public List<Menu> getMenuByMidCid(String mid, String cid) {
        List<Menu> menus = new ArrayList<Menu>();

        Menu menu1 = new Menu();
        menu1.setCid(1);
        menu1.setMid(1);
        menu1.setMname("宫保鸡丁");
        menu1.setPrice(22.5f);

        Menu menu2 = new Menu();
        menu2.setCid(1);
        menu2.setMid(2);
        menu2.setMname("炸酱面");
        menu2.setPrice(18.0f);

        Menu menu3 = new Menu();
        menu3.setCid(1);
        menu3.setMid(3);
        menu3.setMname("卤煮火烧");
        menu3.setPrice(35.0f);

        Menu menu4 = new Menu();
        menu4.setCid(2);
        menu4.setMid(4);
        menu4.setMname("红柳大串");
        menu4.setPrice(15.0f);

        Menu menu5 = new Menu();
        menu5.setCid(2);
        menu5.setMid(5);
        menu5.setMname("烤馕");
        menu5.setPrice(10.0f);

        Menu menu6 = new Menu();
        menu6.setCid(2);
        menu6.setMid(6);
        menu6.setMname("红烧牛肉");
        menu6.setPrice(41.0f);

        if(cid != null && cid.equalsIgnoreCase("1")){
            menus.add(menu1);
            menus.add(menu2);
            menus.add(menu3);
        }else if(cid != null && cid.equalsIgnoreCase("2")){
            menus.add(menu4);
            menus.add(menu5);
            menus.add(menu6);
        }else{
            menus.add(menu1);
            menus.add(menu2);
            menus.add(menu3);
            menus.add(menu4);
            menus.add(menu5);
            menus.add(menu6);
        }

        return menus;
    }

    public int addMenu(int cid, String mname, float price) {
        return 0;
    }

    public int updateMenuByMid(int mid, int cid, String mname, float price) {
        return 0;
    }

    public int deleteMenuByMid(int mid) {
        return 0;
    }
}

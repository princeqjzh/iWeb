package com.lesson.dao;

import com.lesson.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiZhi.Qian on 2018/11/15.
 */
@Service
public class CategoryDAOImpl implements CategoryDAO {
    public List<Category> getAllCategories() {
        List <Category> categories = new ArrayList<Category>();

        Category category1 = new Category();
        category1.setCid(1);
        category1.setCname("北京菜");

        Category category2 = new Category();
        category2.setCid(2);
        category2.setCname("新疆菜");

        categories.add(category1);
        categories.add(category2);

        return categories;
    }

    public List<Category> getCategoriesById(int cid) {
        Category category1 = new Category();
        category1.setCid(1);
        category1.setCname("北京菜");

        Category category2 = new Category();
        category2.setCid(2);
        category2.setCname("新疆菜");

        List <Category> categories = new ArrayList<Category>();

        if(cid == 1){
            categories.add(category1);
        }else{
            categories.add(category2);
        }

        return categories;
    }

    public Category getCategoryById(int cid) {
        Category category1 = new Category();
        category1.setCid(1);
        category1.setCname("北京菜");

        Category category2 = new Category();
        category2.setCid(2);
        category2.setCname("新疆菜");

        if(cid == 1){
            return category1;
        }

        return category2;
    }

    public int addCategory(String cname) {
        return 0;
    }

    public int updateCategoryById(int cid, String cname) {
        return 0;
    }

    public int deleteCategoryById(int cid) {
        return 0;
    }
}

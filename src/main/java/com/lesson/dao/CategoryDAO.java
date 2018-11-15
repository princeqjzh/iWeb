package com.lesson.dao;

import com.lesson.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryDAO {

    public List<Category> getAllCategories();

    public List<Category> getCategoriesById(int cid);

    public Category getCategoryById(int cid);

    public int addCategory(String cname);

    public int updateCategoryById(int cid, String cname);

    public int deleteCategoryById(int cid);
}

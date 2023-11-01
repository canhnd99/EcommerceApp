package com.httt.util;

import com.httt.dao.CategoryDAO;
import com.httt.dao.impl.CategoryDAOImpl;

public class CategoryFactory {
	private CategoryFactory() {}

    private static class SingletonHolder {
        static final CategoryDAO INSTANCE = new CategoryDAOImpl();
    }

    public static CategoryDAO getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

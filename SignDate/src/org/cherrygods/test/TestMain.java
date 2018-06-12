package org.cherrygods.test;

import org.cherrygods.utils.DBHelper;

public class TestMain {
    public static void main(String[] args) {
        DBHelper dbHelper = new DBHelper();
        dbHelper.getConnection();
    }
}

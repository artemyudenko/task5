package com.artemyudenko.task5.db;

public enum DBEnum {

    DB_NAME("DB"),
    TABLE_NAME("SHOP_TABLE"),
    ID_COLUMN("id"),
    NAME_COLUMN("name"),
    DESCRIPTION_COLUMN("description"),
    BRANCH_COLUMN("branch"),
    ISIN_COLUMN("is_in");

    public String getS() {
        return s;
    }

    public static String[] getColumnNamesArray() {
        return new String[]{ID_COLUMN.s, NAME_COLUMN.s, DESCRIPTION_COLUMN.s,
                BRANCH_COLUMN.s, ISIN_COLUMN.s};
    }

    DBEnum(String s) {
        this.s = s;
    }

    private String s;
}

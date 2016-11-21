package com.bangduoduo.util;


import java.text.MessageFormat;

public final class DaoUtil {
    /**
     * 数据库类型
     */
    public static final String DATABASE_TYPE_MYSQL = "mysql";
    public static final String DATABASE_TYPE_ORACLE ="oracle";
    public static final String DATABASE_TYPE_SQLSERVER = "sqlserver";

    /**
     * 分页sql
     */
    public static final String MYSQL_SQL = "select * from ({0}) select_table limit {1}, {2}";
    public static final String ORACLE_SQL = "select * from (select row_.*, rownum rownum_ from ({0}) row_ where rownum <= {1}) where rownum_ > {2}";
    public static final String SQLSERVER_SQL = "select * from ( select row_number() over(order by tempColumn) tempRowNumber, * from (select top {1} tempColumn = 0, {0}) t ) tt where tempRowNumber > {2}";

    public static String createPageSql(String dbType, String sql, int page, int pageSize) {
        int beginNum = (page - 1) * pageSize;
        Object[] sqlParams = new Object[3];
        sqlParams[0] = sql;
        sqlParams[1] = beginNum;
        sqlParams[2] = pageSize;

        if(DATABASE_TYPE_MYSQL.equals(dbType)) {
            return MessageFormat.format(MYSQL_SQL, sqlParams);
        }
        int endNum = beginNum + pageSize;
        sqlParams[1] = endNum;
        sqlParams[2] = beginNum;
        if(DATABASE_TYPE_SQLSERVER.equals(dbType)) {
            return MessageFormat.format(SQLSERVER_SQL, sqlParams);
        }
        return MessageFormat.format(ORACLE_SQL, sqlParams);
    }

    public static void main(String[] args) {
        String sql = DaoUtil.createPageSql(DATABASE_TYPE_MYSQL, "SELECT * FROM article", 2, 20);
        System.out.print(sql);
    }
}

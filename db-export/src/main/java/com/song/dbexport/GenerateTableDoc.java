package com.song.dbexport;

import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;

import java.awt.Color;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 数据库文档生成器 Oracle版
 * itext-2.1.7.jar
 * itext-rtf-2.1.7.jar
 *
 * @author cuiyj
 */
public class GenerateTableDoc {
  //键类型字典
  private static Map<String, String> keyType = new HashMap<String, String>();
  //需要导出的目标表
  private static List<String> targetTable = new ArrayList<String>();

  static {
    targetTable.add("COMMON_ADDRESS");//表名
    targetTable.add("L_USER");
  }

  //初始化jdbc
  static {
    try {
      keyType.put("ID", "主键");
      //            keyType.put("C", "Check");
      Class.forName("oracle.jdbc.OracleDriver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  //private static String url = "";//链接url
  private static String url = "jdbc:oracle:thin:@15.56.102.15:1521:orcl";//链接url
  private static String username = "BDPROJECT"; //用户名.需要设置默认表空间哈
  private static String password = "BDPROJECT"; //密码
  private static String schema = "BDPROJECT"; //目标数据库名
  //查询所有表的sql语句
  private static String sql_get_all_tables = "select a.TABLE_NAME,b.COMMENTS from user_tables a,user_tab_comments b WHERE a.TABLE_NAME=b.TABLE_NAME order by TABLE_NAME";    //查询所有字段的sql语句
  private static String sql_get_all_columns = "select T1.column_name,T1.data_type,T1.data_length,t2.comments,T1.NULLABLE,(select max(constraint_type)    from user_constraints x left join user_cons_columns y on x.constraint_name=y.constraint_name where x.table_name=t1.TABLE_NAME and y.COLUMN_NAME=T1.column_name)  from user_tab_cols t1, user_col_comments t2, user_tab_comments t3  where t1.TABLE_NAME=t2.table_name(+)  and t1.COLUMN_NAME=t2.column_name(+)  and t1.TABLE_NAME=t3.table_name(+)  and t1.TABLE_NAME='{table_name}' order by T1.COLUMN_ID ";

  public static void main(String[] args) throws Exception {
    //初始化word文档
    Document document = new Document(PageSize.A4);
    RtfWriter2.getInstance(document, new FileOutputStream("E:/word1.doc"));
    document.open();
    //查询开始
    Connection conn = getConnection();
    //获取所有表
    List tables = getDataBySQL(sql_get_all_tables, conn);
    int i = 1;
    for (Iterator iterator = tables.iterator(); iterator.hasNext(); ) {
      String[] arr = (String[]) iterator.next();
      //循环获取字段信息
      String tableName = arr[0];
      if (!targetTable.contains(tableName)) {
        System.out.print(i + ".正在处理数据表-----------" + arr[0]);
        addTableMetaData(document, arr, i);
        List columns = getDataBySQL(sql_get_all_columns.replace("{table_name}", arr[0]), conn);
        addTableDetail(document, columns);
        addBlank(document);
        System.out.println("...done");
        i++;
      }
    }
    document.close();
    conn.close();
  }

  /**
   * 添加一个空行
   *
   * @param document
   * @throws Exception
   */
  public static void addBlank(Document document) throws Exception {
    Paragraph ph = new Paragraph("");
    ph.setAlignment(Paragraph.ALIGN_LEFT);
    document.add(ph);
  }


  /**
   * 添加包含字段详细信息的表格
   *
   * @param document
   * @param arr1
   * @param columns
   * @throws Exception
   */
  public static void addTableDetail(Document document, List columns) throws Exception {
    Table table = new Table(6);
    table.setWidth(100f);
    table.setBorderWidth(1);
    table.setBorderColor(Color.BLACK);
    table.setPadding(0);
    table.setSpacing(0);
    Cell cell1 = new Cell("序号");// 单元格
    cell1.setHeader(true);

    Cell cell2 = new Cell("列名");// 单元格
    cell2.setHeader(true);

    Cell cell3 = new Cell("类型");// 单元格
    cell3.setHeader(true);

    Cell cell4 = new Cell("长度");// 单元格
    cell4.setHeader(true);

    Cell cell5 = new Cell("键");// 单元格
    cell5.setHeader(true);

    Cell cell6 = new Cell("说明");// 单元格
    cell6.setHeader(true);
    //设置表头格式
    table.setWidths(new float[]{8f, 30f, 15f, 8f, 10f, 29f});
    cell1.setHorizontalAlignment(Cell.ALIGN_CENTER);
    cell1.setBackgroundColor(Color.gray);
    cell2.setHorizontalAlignment(Cell.ALIGN_CENTER);
    cell2.setBackgroundColor(Color.gray);
    cell3.setHorizontalAlignment(Cell.ALIGN_CENTER);
    cell3.setBackgroundColor(Color.gray);
    cell4.setHorizontalAlignment(Cell.ALIGN_CENTER);
    cell4.setBackgroundColor(Color.gray);
    cell5.setHorizontalAlignment(Cell.ALIGN_CENTER);
    cell5.setBackgroundColor(Color.gray);
    cell6.setHorizontalAlignment(Cell.ALIGN_CENTER);
    cell6.setBackgroundColor(Color.gray);
    table.addCell(cell1);
    table.addCell(cell2);
    table.addCell(cell3);
    table.addCell(cell4);
    table.addCell(cell5);
    table.addCell(cell6);
    table.endHeaders();// 表头结束
    int x = 1;
    for (Iterator iterator = columns.iterator(); iterator.hasNext(); ) {
      String[] arr2 = (String[]) iterator.next();
      Cell c1 = new Cell(x + "");
      Cell c2 = new Cell(arr2[0]);
      Cell c3 = new Cell(arr2[1]);
      Cell c4 = new Cell(arr2[2]);

      String key = keyType.get(arr2[5]);
      if (key == null) key = "";
      Cell c5 = new Cell(key);
      Cell c6 = new Cell(arr2[3]);
      c1.setHorizontalAlignment(Cell.ALIGN_CENTER);
      c2.setHorizontalAlignment(Cell.ALIGN_CENTER);
      c3.setHorizontalAlignment(Cell.ALIGN_CENTER);
      c4.setHorizontalAlignment(Cell.ALIGN_CENTER);
      c5.setHorizontalAlignment(Cell.ALIGN_CENTER);
      c6.setHorizontalAlignment(Cell.ALIGN_CENTER);
      table.addCell(c1);
      table.addCell(c2);
      table.addCell(c3);
      table.addCell(c4);
      table.addCell(c5);
      table.addCell(c6);
      x++;
    }
      document.add(table);

  }


  /**
   * 增加表概要信息
   *
   * @param dcument
   * @param arr
   * @param i
   * @throws Exception
   */

  public static void addTableMetaData(Document dcument, String[] arr, int i) throws Exception {

    Paragraph ph = new Paragraph(i + ". 表名: " + arr[0] + "        说明: " + (arr[1] == null ? "" : arr[1]));
    ph.setAlignment(Paragraph.ALIGN_LEFT);
    dcument.add(ph);

  }

  /**
   * 把SQL语句查询出列表
   *
   * @param sql 84      * @param conn
   * @return
   */
  public static List getDataBySQL(String sql, Connection conn) {
    Statement stmt = null;
    ResultSet rs = null;
    List list = new ArrayList();
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      while (rs.next()) {
        String[] arr = new String[rs.getMetaData().getColumnCount()];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = rs.getString(i + 1);

        }
        list.add(arr);

      }

    } catch (SQLException e) {
      e.printStackTrace();

    } finally {
      try {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();

      } catch (SQLException e) {
        e.printStackTrace();

      }

    }
    return list;

  }

  /**
   * 获取数据库连接
   *
   * @return
   */


  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(url, username, password);

    } catch (SQLException e) {
      e.printStackTrace();

    }
    return null;

  }

}
import java.sql.*;

// CRUD (Creation, Reading, Update and Deletion)

public class SQLiteJDBC
{
  public static void main( String args[] )
  {
      // connectDB();
      createDB();
      insertDB();
      selectDB();
      // updateDB();
      deleteDB();
  }

  public static void connectDB()
  {
      try {
          Class.forName("org.sqlite.JDBC");
          Connection c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Conexión abierta con la base de datos");
  }
  public static void createDB()
  {
      try {
          Class.forName("org.sqlite.JDBC");
          Connection c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
          System.out.println("Conexión abierta con la base de datos");

          Statement stmt = c.createStatement();
          String sql = "CREATE TABLE IF NOT EXISTS web_blog " +
                       "(id INTEGER PRIMARY KEY autoincrement," +
                       " nombre     CHAR(50)    NOT NULL, " +
                       " mensaje    TEXT     NOT NULL, " +
                       " fecha      datetime)";
          stmt.executeUpdate(sql);
          stmt.close();
          c.close();
          System.out.println("La tabla ha sido creada!");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
  }

  public static void insertDB()
  {
      try {
          Class.forName("org.sqlite.JDBC");
          Connection c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
          c.setAutoCommit(false);
          System.out.println("Conexión abierta con la base de datos");

          Statement stmt = c.createStatement();
          String sql = "INSERT INTO web_blog (nombre,mensaje,fecha) " +
                       "VALUES ('Lina', 'Hola a todos!!!', datetime())," +
                       " ('Víctor', 'Hola, espero que estén muy bien!!!',datetime());";
          stmt.executeUpdate(sql);
          stmt.close();
          c.commit();
          c.close();
          System.out.println("Los registros han sido creados");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
  }

  public static void selectDB()
  {
        try {
          Class.forName("org.sqlite.JDBC");
          Connection c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
          c.setAutoCommit(false);
          System.out.println("Conexión abierta con la base de datos");

          Statement stmt = c.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
          while ( rs.next() ) {
             int id = rs.getInt("id");
             String nombre = rs.getString("nombre");
             String mensaje = rs.getString("mensaje");
             String fecha = rs.getString("fecha");
             System.out.println( "id : " + id );
             System.out.println( "nombre : " + nombre );
             System.out.println( "mensaje : " + mensaje );
             System.out.println( "Fecha : " + fecha );
             System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
          System.out.println("La operación se realizó satisfactoriamente!!");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
  }

  public static void updateDB()
  {
    try {
      Class.forName("org.sqlite.JDBC");
      Connection c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
      c.setAutoCommit(false);
      System.out.println("Conexión abierta con la base de datos");

      Statement stmt = c.createStatement();
      String sql = "UPDATE web_blog set mensaje = 'Editado por updateDB()' where id=1;";
      stmt.executeUpdate(sql);
      c.commit();

      ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
      while ( rs.next() ) {
         int id = rs.getInt("id");
         String nombre = rs.getString("nombre");
         String mensaje = rs.getString("mensaje");
         String fecha = rs.getString("fecha");
         System.out.println( "id : " + id );
         System.out.println( "nombre : " + nombre );
         System.out.println( "mensaje : " + mensaje );
         System.out.println( "fecha : " + fecha );
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
      System.out.println("La operación se realizó con éxito");
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
  }

  public static void deleteDB()
  {
      try {
          Class.forName("org.sqlite.JDBC");
          Connection c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
          c.setAutoCommit(false);
          System.out.println("Conexión abierta con la base de datos");

          Statement stmt = c.createStatement();
          String sql = "DELETE from web_blog where id=1;";
          stmt.executeUpdate(sql);
          c.commit();

          ResultSet rs = stmt.executeQuery( "SELECT * FROM web_blog;" );
          while ( rs.next() ) {
             int id = rs.getInt("id");
             String nombre = rs.getString("nombre");
             String mensaje = rs.getString("mensaje");
             String fecha = rs.getString("fecha");
             System.out.println( "id : " + id );
             System.out.println( "nombre : " + nombre );
             System.out.println( "mensaje : " + mensaje );
             System.out.println( "fecha : " + fecha );
             System.out.println();
          }
          rs.close();
          stmt.close();
          c.close();
          System.out.println("Operación realizada con éxito!");
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
  }
}
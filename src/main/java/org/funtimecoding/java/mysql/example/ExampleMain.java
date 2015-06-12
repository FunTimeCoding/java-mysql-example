package org.funtimecoding.java.mysql.example;

public class ExampleMain {

    public static void main(String[] args)
    {
        ExampleMain main = new ExampleMain();
        main.run();
    }

    public void run()
    {
        System.out.println("hi");

        // http://www.vogella.com/tutorials/MySQLJava/article.html

        // load driver
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/example?user=example&password=example");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM example.user");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO example.user VALUES (?, ?)");
        preparedStatement.setString(1, "shiin");
        preparedStatement.setString(2, "insecure");
        preparedStatement.executeUpdate();
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String user = resultSet.getString("myuser");
            String website = resultSet.getString("webpage");
            String summery = resultSet.getString("summery");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("Summery: " + summery);
            System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
        }
    }
}

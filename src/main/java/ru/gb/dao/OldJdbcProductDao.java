//package ru.gb.dao;
//
//import ru.gb.entity.Product;
//
//import java.sql.*;
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//public class OldJdbcProductDao implements ProductDao{
//
//    private Connection getConnection() throws SQLException {
//        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/gb_shop", "geek", "geek");
//    }
//
//    private void connectionClose(Connection connection){
//        if(connection == null){
//            return;
//        }
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Iterable<Product> findAll() {
//       Set<Product> result = new HashSet<>();
//
//       Connection connection = null;
//
//        try {
//            connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                final Product product = Product.builder()
//                        .id(resultSet.getLong("id"))
//                        .title(resultSet.getString("title"))
//                        .cost(resultSet.getBigDecimal("cost"))
//                        .manufactureDate(LocalDate.parse(resultSet.getString("manufacture_date")))
//                        .build();
//                result.add(product);
//            }
//            preparedStatement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            connectionClose(connection);
//        }
//        return result;
//    }
//
//    @Override
//    public Product findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public String findTitleById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void insert(Product product) {
//    }
//
//    @Override
//    public void update(Product product) {
//    }
//
//    @Override
//    public void deleteById(Long id) {
//    }
//}

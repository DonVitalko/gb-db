//package ru.gb.dao;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.ResultSetExtractor;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Component;
//import ru.gb.entity.Product;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.HashMap;
//
//@Component
//@RequiredArgsConstructor
//public class NamedParameterJdbcTemplateProductDao implements ProductDao {
//
//    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//    @Override
//    public Iterable<Product> findAll() {
//        String sql = "SELECT * FROM product";
//        return namedParameterJdbcTemplate.query(sql, new ProductMapper());
//
//    }
//
//    @Override
//    public Product findById(Long id) {
//        String sql = "SELECT name, p.id AS product_id, title, cost, manufacture_date, manufacturer_id FROM product p\n" +
//                "JOIN manufacturer m ON p.manufacturer_id=m.id\n" +
//                "WHERE p.id = 2148;";
//        HashMap<String, Object> namedParameters = new HashMap<>();
//        namedParameters.put("productId", id);
//        return (Product) namedParameterJdbcTemplate.query(sql, namedParameters, new ProductExtractor());
//    }
//
//    @Override
//    public String findTitleById(Long id) {
//        String sql = "SELECT title FROM product WHERE id = :productId";
//        HashMap<String, Object> namedParameters = new HashMap<>();
//        namedParameters.put("productId", id);
//        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
//    }
//
//    @Override
//    public void insert(Product product) {
//
//    }
//
//    @Override
//    public void update(Product product) {
//
//    }
//
//    @Override
//    public void deleteById(Long id) {
//    }
//
//    private static class ProductMapper implements RowMapper<Product> {
//
//        @Override
//        public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//            return Product.builder()
//                    .id(resultSet.getLong("id"))
//                    .title(resultSet.getString("title"))
//                    .cost(resultSet.getBigDecimal("cost"))
//                    .manufactureDate(LocalDate.parse(resultSet.getString("manufacture_date")))
//                    .build();
//        }
//    }
//
//    private static class ProductExtractor implements ResultSetExtractor {
//        @Override
//        public Product extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//            Product product = null;
//            while (resultSet.next()) {
//                Long product_id = resultSet.getLong("product_id");
//                if (product == null) {
//                    product = Product.builder()
//                            .id(product_id)
//                            .title(resultSet.getString("title"))
//                            .cost(resultSet.getBigDecimal("cost"))
//                            .manufactureDate(LocalDate.parse(resultSet.getString("manufacture_date")))
//                            .manufacturer_id(resultSet.getLong("manufacturer_id"))
//                            .build();
//                }
//            }
//            return product;
//        }
//    }
//}

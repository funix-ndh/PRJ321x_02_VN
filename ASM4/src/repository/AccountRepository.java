package repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.lang.Nullable;

import mapper.AccountRowMapper;
import model.Account;

public class AccountRepository {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(final DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Nullable
    public Account getAccountByUsername(final String username) {
        final String query = "select * from account where user_mail = ?";
        try {
            return jdbcTemplate.queryForObject(query, new String[] { username }, new AccountRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}

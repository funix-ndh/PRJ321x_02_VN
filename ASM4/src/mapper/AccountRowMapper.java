package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Account;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Account account = new Account();
        account.setEmail(rs.getString("user_mail"));
        account.setPassword(rs.getString("password"));
        account.setUsername(rs.getString("user_name"));
        account.setAccountRole(rs.getString("account_role"));
        account.setAddress(rs.getString("user_address"));
        account.setPhone(rs.getString("user_phone"));
        return account;
    }
}

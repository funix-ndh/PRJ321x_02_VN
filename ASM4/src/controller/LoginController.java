package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Account;
import repository.AccountRepository;

@Controller
public class LoginController {
    private final AccountRepository accountRepository;

    private static final Pattern passwordRegex = Pattern.compile("[a-zA-Z0-9!@#$%^&*]+");
    private static final Pattern emailRegex = Pattern.compile(
            "^([a-zA-Z0-9_.\\-])+@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");

    public LoginController(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/login")
    public ModelAndView home(final HttpServletRequest request) throws NoSuchAlgorithmException {
        final String username = request.getParameter("username");
        final String password = request.getParameter("password");
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            return new ModelAndView("login", "error", "Please enter username and password");
        }
        if (!passwordRegex.matcher(password).matches() || !emailRegex.matcher(username).matches()) {
            return new ModelAndView("login", "error", "Please enter correct format of username and password");
        }
        final Account account = accountRepository.getAccountByUsername(username);
        final MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        final String passwordHash = DatatypeConverter.printHexBinary(md.digest());
        if (account != null && account.getPassword().equals(passwordHash)) {
            return new ModelAndView("welcome", "username", username);
        }
        return new ModelAndView("login", "error", "Username and password is not correct");
    }
}

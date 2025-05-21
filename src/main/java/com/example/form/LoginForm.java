package com.example.form;

import jakarta.validation.constraints.NotNull;

/**
 * ログイン時に使うフォーム.
 *
 */
public class LoginForm {
    /** 従業員のメールアドレス*/
    @NotNull(message = "")
    private String mailAddress;
    /** 従業員のパスワード*/
    private String password;

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

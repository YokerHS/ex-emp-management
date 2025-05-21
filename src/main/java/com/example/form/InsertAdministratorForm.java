package com.example.form;
/**
 * 管理者登録時に使うフォーム.
 *
 */
public class InsertAdministratorForm {
    /** 管理者の名前 */
    private String name;
    /** 管理者のメールアドレス */
    private String mailAddress;
    /** 管理者のパスワード */
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        return "InsertAdministratorForm{" +
                "name='" + name + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

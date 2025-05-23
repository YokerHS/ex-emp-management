package com.example.domain;
/**
 * 管理者情報を表すドメインクラス.
 * administrators　テーブルに対応
 */
public class Administrator {
    /** ID （主キー） */
    private Integer id;
    /** 名前 */
    private String name;
    /** メールアドレス */
    private String mailAddress;
    /** パスワード */
    private String password;

    /**
     * Getter, Setter.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return "Administrator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.example.repository;

import com.example.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * administrator テーブルを操作するリポジトリ.
 */
@Repository
public class AdministratorRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Administrator.class);

    /**
     *管理者の情報を挿入する.
     *
     * @param administrator 管理者の情報
     */
    public void insert(Administrator administrator) {

        SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);

        String sql = """
            INSERT INTO administrators(name, mail_address, password)
            VALUES(:name, :mailAddress, :password);
            """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(sql, param, keyHolder, new String[] {"id"});
        administrator.setId(keyHolder.getKey().intValue());
    }

    /**
     *メールアドレスとパスワードから管理者情報を取得する（1件もしないとnullに返す）.
     *
     * @param mailAddress 管理者のメールアドレス
     * @param password 管理者のパスワード
     * @return 管理者の情報
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password){
        String sql = """
                SELECT id, name, mail_address, password
                FROM administrators
                WHERE mail_address = :mailAddress
                  AND password = :password;
                """;

        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("mailAddress",mailAddress)
                .addValue("password",password);

        List<Administrator> administratorList = template.query(sql,param,ADMINISTRATOR_ROW_MAPPER);

        if (administratorList.isEmpty()) return null;
        return  administratorList.getFirst();

    }

}

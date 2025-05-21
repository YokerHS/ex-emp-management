package com.example.service;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理者関連機能の業務処理を行うサービス.
 *
 * */
@Service
@Transactional
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * 新規 Administrator 追加するメソッド.
     *
     * @param administrator Administrator の情報
     * */
    public void insert(Administrator administrator){
        administratorRepository.insert(administrator);
    }

    /** Administratorのログイン処理メソッド.
     *
     * @param mailAddress Administratorのメールアドレス
     * @param password パスワード
     * */
    public Administrator login(String mailAddress, String password){
        return administratorRepository.findByMailAddressAndPassword(mailAddress,password);
    }
}

package com.example.controller;

import com.example.domain.Administrator;
import com.example.form.InsertAdministratorForm;
import com.example.form.LoginForm;
import com.example.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *管理者関連機能の処理の制御を行うコントローラ.
 *
 */
@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private HttpSession session;

    /**
     * 管理者情報画面に遷移する.
     *
     * @param form フォーム
     * @return 管理者情報画面
     */
    @GetMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form){
        return "administrator/insert";
    }

    /**
     * 管理者情報を登録する.
     *
     * @param form フォーム
     * @return ログイン画面
     */
    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form){
        Administrator administrator = new Administrator();
        BeanUtils.copyProperties(form,administrator);
        administratorService.insert(administrator);
        return "redirect:/";
    }

    /**
     * ログイン画面に移す.
     *
     * @param form　フォーム
     * @return ログイン画面
     */
    @GetMapping("/")
    public String toLogin(LoginForm form){
        return "administrator/login";
    }

    /**
     * ログインをする.
     *
     * @param form フォーム
     * @param model モデル
     * @return 従業員一覧画面(ログイン失敗時はログイン画面に戻る)
     */
    @PostMapping("/login")
    public String login(LoginForm form, Model model){
        Administrator administrator
                        = administratorService.login(
                            form.getMailAddress(),
                            form.getPassword());

        if (administrator == null) {
            model.addAttribute("loginResult","メールアドレスまたはパスワードが間違っています");
            return "administrator/login.html";
        }
        session.setAttribute("administratorName",administrator);
        return "redirect:/employee/showList";
    }

    /**
     * ログアウトをする.
     *
     * @param form フォーム
     * @return ログイン画面
     */
    @GetMapping("/logout")
    public String logout(LoginForm form){
        session.invalidate();
        return "redirect:/";
    }
}

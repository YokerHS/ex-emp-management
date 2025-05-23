package com.example.controller;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.FileStore;
import java.util.List;

/**
 * 従業員関連機能の処理の制御を行うコントローラ.
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private HttpSession session;
    /**
     * 従業員一覧を表示する画面に移す.
     *
     * @param model　モデル
     * @return 　従業員一覧
     */
    @GetMapping("showList")
    public String showList(Model model){
        if (session.getAttribute("administratorName") == null) {
            return "redirect:/";
        }
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList",employeeList);
        return "employee/list";
    }

    /**
     * 従業員の個人情報を表示する画面に移す.
     *
     * @param id　従業員の画面
     * @param model モデル
     * @param form フォーム
     * @return 個人情報を表示する画面
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form){

        if (session.getAttribute("administratorName") == null) {
            return "redirect:/";
        }

        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    /**
     *従業員の情報を変更する.
     *
     * @param form フォーム
     * @return 従業員一覧画面に移す
     */
    @PostMapping("/update")
    public String update(@ModelAttribute("updateEmployeeForm") @Valid UpdateEmployeeForm form,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
            model.addAttribute("employee", employee);
            return "employee/detail";
        }

        Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
        employeeService.update(employee);

        return "redirect:/employee/showList";
    }

}

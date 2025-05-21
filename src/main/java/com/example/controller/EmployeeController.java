package com.example.controller;

import com.example.domain.Employee;
import com.example.form.UpdateEmployeeForm;
import com.example.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 従業員関連機能の処理の制御を行うコントローラ.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 従業員一覧を表示する画面に移す.
     * @param model　モデル
     * @return 　従業員一覧
     */
    @GetMapping("showList")
    public String showList(Model model){
        List<Employee> employeeList = employeeService.showList();
        model.addAttribute("employeeList",employeeList);
        return "employee/list";
    }

    /**
     * 従業員の個人情報を表示する画面に移す
     * @param id　従業員の画面
     * @param model モデル
     * @param form フォーム
     * @return 個人情報を表示する画面
     */
    @GetMapping("/showDetail")
    public String showDetail(String id, Model model, UpdateEmployeeForm form){
        Employee employee = employeeService.showDetail(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "employee/detail";
    }

    @PostMapping("/update")
    public String update(UpdateEmployeeForm form){
        Employee employee = employeeService.showDetail(Integer.parseInt(form.getId()));
        employee.setDependentsCount(Integer.parseInt(form.getDependentsCount()));
        employeeService.update(employee);
        System.out.println(employee.toString());
        return "redirect:/employee/showList";
    }
}

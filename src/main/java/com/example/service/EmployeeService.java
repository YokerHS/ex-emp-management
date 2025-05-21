package com.example.service;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *従業員関連機能の業務処理を行うサービス.
 * 
 */
@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /** 従業員情報を全件取得する.
     *
     * @return 従業員一覧
     */
    public List<Employee> showList(){
        return employeeRepository.findAll();
    }

    /**
     * idにより従業員の情報を取得する.
     *
     * @param id　従業員のID
     * @return 従業員の情報
     */
    public Employee showDetail(Integer id){
        return employeeRepository.findById(id);
    }

    /**
     * 従業員の情報を変更する.
     *
     * @param employee 従業員の新しい情報
     */
    public void update(Employee employee){
        employeeRepository.update(employee);
    }

}

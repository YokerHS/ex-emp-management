package com.example.form;

import jakarta.validation.constraints.Min;

/**
 * 従業員更新ときに使うフォーム.
 *
 */
public class UpdateEmployeeForm {
    /** 従業員ID */
    private String id;

    /** 扶養人数 */
    @Min(0)
    private String dependentsCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDependentsCount() {
        return dependentsCount;
    }

    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeForm{" +
                "id='" + id + '\'' +
                ", dependentsCount='" + dependentsCount + '\'' +
                '}';
    }
}

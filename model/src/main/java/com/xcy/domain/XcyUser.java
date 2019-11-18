package com.xcy.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

//用户
@Entity
@Table(name = "td_xcy_user")
public class XcyUser implements Serializable {

    private static final long serialVersionUID = 5012360600551012206L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(nullable = false, length = 32, unique = true)
    private String id;
	 
    @NotBlank(message = "姓名不能为空")
    @Column(length = 100)
    private String name;

    @NotBlank(message = "年龄不能为空")
    @Column(length = 100)
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

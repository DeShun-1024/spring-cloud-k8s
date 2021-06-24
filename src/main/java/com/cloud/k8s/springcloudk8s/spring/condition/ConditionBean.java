package com.cloud.k8s.springcloudk8s.spring.condition;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ConditionBean {

    private String name;
}

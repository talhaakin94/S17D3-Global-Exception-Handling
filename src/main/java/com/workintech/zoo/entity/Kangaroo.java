package com.workintech.zoo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kangaroo {
    int id;
    String name;
    double height;
    double weight;
    String gender;
    boolean isAggressive;
    public boolean getIsAggressive() {
        return isAggressive;
    }
    public void setIsAggressive(boolean isAggressive) {
        this.isAggressive = isAggressive;
    }
}

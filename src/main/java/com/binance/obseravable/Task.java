package com.binance.obseravable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Task {

    private String description;
    private boolean isComplete;
    private int priority;


    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public int getPriority() {
        return priority;
    }
}

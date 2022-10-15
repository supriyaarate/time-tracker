package com.job.time.tracker.constants;

import java.util.HashMap;
import java.util.Map;

public enum RoleConstants {

	ADMIN(1, "ADMIN"),
	CLIENT(2, "CLIENT");

    private int value;
    private String displayValue;

    private RoleConstants(int value, String displayValue){
        this.value = value;
        this.displayValue = displayValue;
    }

    public static RoleConstants getRole(int status) {
        for (RoleConstants roleConstant : values()) {
            if (roleConstant.value == status) {
                return roleConstant;
            }
        }
        throw new IllegalArgumentException("Invalid Role Status: " + status);
    }

    public static Map<Integer, String> getAllRoles () {
        final Map<Integer, String> map = new HashMap<>();
        for (RoleConstants roleConstant : values()) {
           map.put(roleConstant.value, roleConstant.displayValue);
        }
        return map;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the displayValue
     */
    public String getDisplayValue() {
        return displayValue;
    }

	
	

}

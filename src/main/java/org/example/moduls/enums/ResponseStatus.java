package org.example.moduls.enums;

public enum ResponseStatus {
    OK("OK"),
    ERROR("ERROR");
    private String status;

    ResponseStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}

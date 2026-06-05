package com.common.common_library.constant;

public enum ResponseMessage {

     CREATED("Saved successfully"),
     UPDATED("Updated successfully"),
     DELETED("Deleted Successfully"),
     RETRIEVED("Retrieved Successfully");

    private final String message;

    ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
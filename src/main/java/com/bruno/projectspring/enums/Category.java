package com.bruno.projectspring.enums;


public enum Category {
    REDES("Redes"), FRONT_END("Front-End"), BACK_END("Back-End") ;


    private String value;

    private Category(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    // toString
    @Override
    public String toString() {
        return value;
}

}

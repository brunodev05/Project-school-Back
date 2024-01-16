package com.bruno.projectspring.enums;

import lombok.val;

public enum Category {
    MATEMATICA ("Matemática"), PORTUGUÊS("Português"), BIOLOGIA("Biologia"), QUÍMICA("Química"), FÍSICA("Física"), HISTÓRIA("História"), GEOGRAFIA("Geografia"), ARTES ("Artes");

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

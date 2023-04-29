package models;

import models.base.IConvertable;
import models.base.IFieldModel;

public class Field implements IFieldModel, IConvertable {
    private String name;
    private String value;
    public Field(String name, String value){
        this.name = name;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public String getValue() {
        return value;
    }

    @Override
    public String getModelName() {
        return "field";
    }

    @Override
    public int getPropCount() {
        return 2;
    }

    @Override
    public String getPropName(int index) {
        return switch (index) {
            case 0 -> "name";
            case 1 -> "value";
            default -> "";
        };
    }

    @Override
    public String getPropValue(int index) {
        return switch (index) {
            case 0 -> name;
            case 1 -> value;
            default -> "";
        };
    }

    @Override
    public String toString() {
        return String.format("\"%s\":\"%s\"", getName(), getValue());
    }
}

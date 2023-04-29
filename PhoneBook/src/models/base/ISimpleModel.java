package models.base;

public interface ISimpleModel {
    String getModelName();
    int getPropCount();
    String getPropName(int index);
    String getPropValue(int index);
    String toString();
}

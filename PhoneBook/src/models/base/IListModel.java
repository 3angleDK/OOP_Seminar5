package models.base;

public interface IListModel extends ISimpleModel{
    int getListSize();
    String getListName();
    ISimpleModel getElement(int index);
    boolean addElement(ISimpleModel value);
}

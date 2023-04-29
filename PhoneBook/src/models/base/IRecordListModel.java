package models.base;

public interface IRecordListModel extends IListModel{
    IRecordModel getRecord(int index);
    boolean addRecord(IRecordModel value);
}

package models.base;

import models.Field;

public interface IRecordModel extends IListModel{
    boolean addField(IFieldModel field);
    IFieldModel getField(int index);
}

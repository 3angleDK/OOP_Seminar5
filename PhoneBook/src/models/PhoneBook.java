package models;

import models.base.*;

import java.util.ArrayList;

public class PhoneBook extends ArrayList<IRecordModel> implements IRecordListModel, IConvertable {
    @Override
    public int getListSize() {
        return this.size();
    }

    @Override
    public String getListName() {
        return "records";
    }

    @Override
    public ISimpleModel getElement(int index) {
        return this.get(index);
    }

    @Override
    public boolean addRecord(IRecordModel record){
        return this.addElement(record);
    }
    @Override
    public boolean addElement(ISimpleModel value) {
        if (value instanceof IRecordModel)
            return this.add((IRecordModel)value);
        return false;
    }

    @Override
    public String getModelName() {
        return "phonebook";
    }

    @Override
    public int getPropCount() {
        return 0;
    }

    @Override
    public String getPropName(int index) {
        return "";
    }

    @Override
    public String getPropValue(int index) {
        return "";
    }

    public IRecordModel getRecord(int index){
        return get(index);
    }

    @Override
    public String toString() {
        String result = "";
        for (IRecordModel rec: this) {
            result += rec + "\n";
        }
        return result;
    }

}

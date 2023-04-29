package models;

import models.base.IConvertable;
import models.base.IFieldModel;
import models.base.IRecordModel;
import models.base.ISimpleModel;

import java.util.ArrayList;

public class BookRecord extends ArrayList<IFieldModel> implements IRecordModel, IConvertable {
    public BookRecord(){ super(); }
    public BookRecord(String firstName, String lastName, String phoneNumber){
        this.addField(new Field("First Name", firstName));
        this.addField(new Field("Last Name", lastName));
        this.addField(new Field("Phone Number", phoneNumber));
    }

    @Override
    public String getModelName() {
        return "record";
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

    @Override
    public String toString() {
        String result = "";
        for (IFieldModel field: this) {
            result += field + "; ";
        }
        return result;
    }

    @Override
    public IFieldModel getField(int index) {
        return (IFieldModel)this.getElement(index);
    }
    @Override
    public ISimpleModel getElement(int index) {
        return this.get(index);
    }

    @Override
    public int getListSize() {
        return this.size();
    }

    @Override
    public String getListName() {
        return "fields";
    }

    @Override
    public boolean addField(IFieldModel field) {
        return this.addElement(field);
    }
    @Override
    public boolean addElement(ISimpleModel value) {
        if (value instanceof IFieldModel)
            return this.add((IFieldModel)value);
        return false;
    }

}

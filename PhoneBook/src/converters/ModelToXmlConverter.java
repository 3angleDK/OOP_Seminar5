package converters;

import converters.base.IModelConverter;
import models.PhoneBook;
import models.base.IConvertable;
import models.base.IListModel;
import models.base.ISimpleModel;

//public class ModelToXmlConverter<E extends ISimpleModel & IConvertable> implements IModelConverter {
public class ModelToXmlConverter implements IModelConverter {

    @Override
    public String header() {
        return "<?xml version='1.0' ?>\n";
    }

    @Override
    public String convert(ISimpleModel model) {
        return header() + convertData(model).toString();
    }

    @Override
    public StringBuilder convertData(ISimpleModel model) {
        StringBuilder result = new StringBuilder();
        result.append("<" + model.getModelName() + ">\n");
        for (int i = 0; i < model.getPropCount(); i++) {
            result.append("<property name=\"" + model.getPropName(i) + "\"");
            result.append(" value=\"" + model.getPropValue(i) + "\"/>\n");
        }
        if (model instanceof IListModel){
            for (int i = 0; i < ((IListModel)model).getListSize(); i++) {
                result.append(convertData(((IListModel)model).getElement(i)));
            }
        }
        result.append("<" + model.getModelName() + "/>\n");
        return result;
    }


    @Override
    public ISimpleModel parse(String str) {
        return new PhoneBook();
    }
}

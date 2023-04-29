package converters.base;

import models.base.IConvertable;
import models.base.ISimpleModel;

public interface IModelConverter<E extends ISimpleModel & IConvertable> {

    String convert(E model);
    StringBuilder convertData(E model);
    String header();
    //    E parse(String str);
    ISimpleModel parse(String str);
}
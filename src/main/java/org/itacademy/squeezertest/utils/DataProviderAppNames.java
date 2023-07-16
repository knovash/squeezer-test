package org.itacademy.squeezertest.utils;

import lombok.extern.log4j.Log4j2;
import org.itacademy.squeezertest.models.AppList;
import org.testng.annotations.DataProvider;

import java.util.ResourceBundle;

@Log4j2
public class DataProviderAppNames {

    private final ResourceBundle bundle = ResourceBundle.getBundle("config");
    public final String DATAFILE = bundle.getString("fileAppNames");

    @DataProvider
    public Object[][] appNames() {
        AppList object = JsonUtils.getObjectFromFile(DATAFILE, AppList.class);
//        List<CatalogItem> list = object.getItems();
//        int size = list.size();
        Object[][] data = new Object[1][1];
//        IntStream.range(0, 1)
//                .peek(i -> log.info("DATAPROVIDER ["+ i +"] "+ list.get(i)))
//                .forEach(i -> data[i][0] = list.get(i));
        data[0][0] = object;
        return data;
    }
}

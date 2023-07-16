package org.itacademy.squeezertest.utils;

import lombok.extern.log4j.Log4j2;
import org.itacademy.squeezertest.models.AppList;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.stream.IntStream;

@Log4j2
public class DataProviderSearchItems {

    @DataProvider
    public Object[][] searchItems() {
        AppList object = JsonUtils.getObjectFromFile(Config.getDataFileSearch(), Catalog.class);
        List<CatalogItem> list = object.getItems();
        int size = list.size();
        Object[][] data = new Object[size][1];
        IntStream.range(0, size)
                .peek(i -> log.info("DATAPROVIDER ["+ i +"] "+ list.get(i)))
                .forEach(i -> data[i][0] = list.get(i));
        return data;
    }
}

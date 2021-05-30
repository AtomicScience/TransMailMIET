package ru.techain.TransMail.api.table;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.techain.TransMail.api.LotTableParser;
import ru.techain.TransMail.api.models.EmployeeOrder;


import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealLotableParser implements LotTableParser {
    LotTableParser lotTableParser;
    private List<EmployeeOrder> employees;
    private Map<String, Integer> mapPrizes;

    public RealLotableParser(FileReader fileReader){
        employees = new CsvToBeanBuilder(fileReader)
                .withSeparator(';')
                .withType(EmployeeOrder.class)
                .build()
                .parse();
        employees.remove(0);
        mapPrizes=new HashMap<>();
/*
        employees.forEach(o->{
            mapPrizes.computeIfPresent(o.getNameProduct(),(a,b)->b+=Integer.parseInt(o.getCount()));
            mapPrizes.putIfAbsent(o.getNameProduct(),Integer.parseInt(o.getCount()));
        });
*/
    }
    @Override
    public List<EmployeeOrder> getEmployees() {
        return employees;
    }

    @Override
    public Map<String, Integer> getMapPrizes() {
        return mapPrizes;
    }
}

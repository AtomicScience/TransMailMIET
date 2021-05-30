package ru.techain.TransMail.api.table;

import com.opencsv.bean.CsvToBeanBuilder;
import ru.techain.TransMail.api.FullLotTableParser;
import ru.techain.TransMail.api.models.EmployeeData;
import ru.techain.TransMail.api.models.EmployeeOrder;
import ru.techain.TransMail.api.models.FinalEmployee;

import java.io.FileReader;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RealFullLotTableParser implements FullLotTableParser {
    List<FinalEmployee> finalEmployees;
    Map<String, Integer> finalMapPrizes;

    public RealFullLotTableParser(FileReader Order, FileReader Data) {
        List<EmployeeOrder> orders = new CsvToBeanBuilder(Order)
                .withSeparator(';')
                .withType(EmployeeOrder.class)
                .build()
                .parse();
        orders.remove(0);
        finalMapPrizes = new HashMap<>();

        orders.forEach(o -> {
            finalMapPrizes.computeIfPresent(o.getNameProduct(), (a, b) -> b += Integer.parseInt(o.getCount()));
            finalMapPrizes.putIfAbsent(o.getNameProduct(), Integer.parseInt(o.getCount()));
        });
        List<EmployeeData> dataEmployees = new CsvToBeanBuilder(Data)
                .withSeparator(';')
                .withType(EmployeeData.class)
                .build()
                .parse();
        finalEmployees = new ArrayList<>();
        orders.forEach(o -> {
            String userCode = o.getUserCrocCode();
            Integer count = Integer.parseInt(o.getCount());
            dataEmployees.forEach(item -> {
                if (item.getUserCrocCode().equals(userCode)) {
                    //System.out.println(item.getUserFirstName());
                    finalEmployees.add(new FinalEmployee(item.getUserLastName(), item.getUserFirstName(), item.getUserMiddleName(), item.getEmail(), o.getNameProduct(), count));
                    return;
                }
            });
        });

    }

    @Override
    public List<FinalEmployee> getFinalEmployees() {
        return finalEmployees;
    }

    @Override
    public Map<String, Integer> getFinalMapPrizes() {
        return finalMapPrizes;
    }

    @Override
    public List<FinalEmployee> getFinalEmployeesByProduct(String productName) {
        return finalEmployees.stream().filter(it -> it.getNameProduct().equals(productName))
                .collect(Collectors.toList());
    }
}

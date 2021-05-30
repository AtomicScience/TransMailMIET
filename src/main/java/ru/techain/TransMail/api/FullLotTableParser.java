package ru.techain.TransMail.api;

import ru.techain.TransMail.api.models.EmployeeOrder;
import ru.techain.TransMail.api.models.FinalEmployee;

import java.util.List;
import java.util.Map;

public interface FullLotTableParser {
    List<FinalEmployee> getFinalEmployees();
    Map<String, Integer> getFinalMapPrizes();
}

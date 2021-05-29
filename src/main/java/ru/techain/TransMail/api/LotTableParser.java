package ru.techain.TransMail.api;

import ru.techain.TransMail.api.models.EmployeeOrder;

import java.util.List;
import java.util.Map;

public interface LotTableParser {
     List<EmployeeOrder> getEmployees();
     Map<String, Integer> getMapPrizes();

}

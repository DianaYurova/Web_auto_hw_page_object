package test.resources;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "InputData")
    public static Object[][] inputData() {
        return new Object[][]{
                {"Java вакансии"},
                {"разработчики зарплаты"},
                {"рейтинг it компаний"}
        };
    }

}

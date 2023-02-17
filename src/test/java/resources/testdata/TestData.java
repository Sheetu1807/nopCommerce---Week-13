package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "credentials")
    public Object[][] getDataInvalid() {
        Object[][] data = new Object[][]{
                {"kims@gmail.com", "abc123"}

        };
        return data;
    }

    @DataProvider(name = "validcredentials")
    public Object[][] getDatavalid(){
        Object[][] data1 = new Object[][]{
                {"kims@gmail.com", "abc123"}

        };
        return data1;
    }

    @DataProvider(name="BuildComputer")
    public Object[][] getDatabuild(){
        Object[][] data2 = new Object[][]{
                {"2.2 GHz Intel Pentium Dual-Core E2200", "2 GB", "320 GB", "Vista Home [+$50.00]", "Microsoft Office [+$50.00]"}
        };
        return data2;
    }
}
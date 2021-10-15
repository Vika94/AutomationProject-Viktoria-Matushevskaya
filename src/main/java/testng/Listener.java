package testng;

import driver.CreateDriver;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import properties.PropertyReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static driver.CreateDriver.setDriver;

public class Listener implements ITestListener {

    @Override
    public void onStart(ITestContext context){
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.setProperties(context.getSuite().getParameter("env"));
        setDriver(context.getSuite().getParameter("browser") == null ? "Chrome" : context.getSuite().getParameter("browser"));
        Path path = Paths.get("allure-results");
        try {
            if (Files.exists(path)) {
                Files.walk(path)
                        .sorted(Comparator.reverseOrder())
                        .map(Path::toFile)
                        .forEach(File::delete);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        CreateDriver.quitDriver();
    }

    @Attachment(value = "Screenshots", type = "image/png")
    private byte[] saveScreenshots(byte[] s){
        return s;

    }
}

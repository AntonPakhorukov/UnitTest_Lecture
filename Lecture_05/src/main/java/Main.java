import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Main {
    public static void main(String[] args) throws InterruptedException{
        // подключаем chrome driver, говорим системе, где находится инструмент,
        // с помощью которого будем взаимодействовать с браузером
//        System.setProperty("webdriver.chrome.driver", "D:\\Geek Brains 2022\\UnitTest\\Selenium\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chromedriver", "D:\\Geek Brains 2022\\UnitTest\\Selenium\\chromedriver_win32\\chromedriver.exe");
        // создаем экземпляр chrome драйвера
        WebDriver driver = new ChromeDriver();
        // запрашиваем главную страницу гугла
        driver.get("https://google.com");
        // ищем поле для ввода поискового запроса
        WebElement searchBox = driver.findElement(By.name("q"));
        // вводим в поле GeekBrains
        searchBox.sendKeys("GeekBrains");
        // отправляем форму
        searchBox.submit();
        // ждем 10 секунд
        Thread.sleep(10000);
        // закрываем окно браузера
        driver.close();
    }
}

package testeSite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeSite {
	
	private WebDriver driver;
    
	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/");
	}
	@Test
	public void testeNavegador() {
		
		String[] listaSenhas = {"senha1","xpto","1234"};
				
		for(int tentativa = 0; tentativa < listaSenhas.length;tentativa++) {
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/app-root/div/div/nav/a[2]")).click();
				Thread.sleep(1000);		
				driver.findElement(By.xpath("/html/body/app-root/header/div[1]/div[1]/a/p")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("logar")).click();
				driver.findElement(By.id("login")).sendKeys("teste@teste.com");
				driver.findElement(By.id("senha")).sendKeys(listaSenhas[tentativa]);
				driver.findElement(By.id("enviar")).click();
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
						
		}		
						
	}
}



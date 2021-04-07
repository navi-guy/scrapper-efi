package com.efi.scrapper.scrapp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efi.scrapper.service.TelevisorService;

@Service
public class SagaScrapper {
	@Autowired
    TelevisorService televisorService;
	
	public void scraping(){
		String urlWeb = "https://www.falabella.com.pe/falabella-pe/";
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get(urlWeb);
		System.out.println("Ingreso a la pagina");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@class=\"dy-lb-close\"]")).click();
		List<WebElement> iconoMenu = driver.findElements(By.xpath("//div[@id=\"header-med-categories-menu-CategoryMenu-1df0cec7-821b-4456-ad50-2c712dfbd7b4\"]/div[1]"));
		iconoMenu.get(0).click();//primero pequeño        segundo grande
		List<WebElement> categorias = driver.findElements(By.ByTagName.xpath("//div[@id=\"header-med-categories-menu-CategoryMenu-1df0cec7-821b-4456-ad50-2c712dfbd7b4\"]/div[2]/div[1]/div"));
		//solo se necesita los primero 14
		System.out.println(categorias.get(0).getText());
		categorias.get(0).findElement(By.tagName("span")).click();
		List<WebElement> subMenus = driver.findElements(By.xpath("//*[@id=\"header-med-categories-menu-CategoryMenu-1df0cec7-821b-4456-ad50-2c712dfbd7b4\"]/div[2]/div[1]/div[1]/div[2]/div/div"));
		System.out.println(subMenus.size());
		String cadena = subMenus.get(0).findElement(By.tagName("a")).getAttribute("href");
		System.out.println(cadena);
		WebDriver driver2 = new ChromeDriver(chromeOptions);
		driver2.get(cadena);
		System.out.println("Entro a los televisores");
		List<WebElement> listaTeles = driver2.findElements(By.xpath("//*[@id=\"testId-searchResults-products\"]/div"));
		int id = 1;
		for(WebElement tele:listaTeles){
			String titulo = tele.findElement(By.className("pod-subTitle")).getText();
			televisorService.insertarTelevisor(id,titulo);
			System.out.println("Insertó TV");
			id =+ 1;
		}
		driver2.close();
		driver.close();
	}
}

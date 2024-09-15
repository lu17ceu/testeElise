package automacao.curso;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Cadastrar {
	
@Test

public void cadastrar() {
	WebDriver driver = new ChromeDriver();
    driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    driver.manage().window().maximize();
    
    
	driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste Jorgin");
	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Teste Jorgin Sobrenome");
	driver.findElement(By.id("elementosForm:sexo:0")).click();
    driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
	
    new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Superior");
	new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
	
	driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste"); 
    
	driver.findElement(By.id("elementosForm:cadastrar")).click();
	
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Cadastrado!"));
		
	    Assert.assertEquals("Nome: Teste Jorgin", driver.findElement(By.id("descNome")).getText());
	    Assert.assertEquals("Sobrenome: Teste Jorgin Sobrenome", driver.findElement(By.id("descSobrenome")).getText());
	    Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
	    Assert.assertEquals("Comida: Frango", driver.findElement(By.id("descComida")).getText());
	    Assert.assertEquals("Escolaridade: superior", driver.findElement(By.id("descEscolaridade")).getText());
	    Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
	    Assert.assertEquals("Sugestoes: Teste", driver.findElement(By.id("descSugestoes")).getText());
	    
    driver.quit();
    
	}

}
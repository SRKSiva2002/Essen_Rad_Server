package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/*spice jet application - round trip - select from ' bangalore' to 'delhi'
- select tomorrow date and return date next month. - select adult 5 and currency as USD click on search flight
*/

public class SpiceJetCalendarPopupTest {

	public static void main(String[] args){

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int onYear= 2023; int onDate=11; String onMonth="September";
		int reYear=2024; int reDate=20; String reMonth="March";
		String fCity="DEL"; String tCity="BLR"; String currency="USD";
		driver.get("https://www.spicejet.com/");
		Actions a = new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa' and .='round trip']")).click();
		WebElement fTarget = driver.findElement(By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2' and .='From']"));
		a.moveToElement(fTarget).click().sendKeys(fCity).perform();
		WebElement tTarget = driver.findElement(By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2' and .='To']"));
		a.moveToElement(tTarget).sendKeys(tCity).perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(.,'"+onMonth+"') and contains(.,'"+onYear+"')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and contains(.,'"+onDate+"')]"))).click();
		try {
			driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79' and contains(.,'"+reMonth+"') and contains(.,'"+reYear+"')]/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and contains(.,'"+reDate+"')]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']")).click();
		}
		driver.findElement(By.xpath("//div[.='Passengers']")).click();
		int count=5;
		while (count>1) {
			driver.findElement(By.xpath("//div[.='Adult']/ancestor::div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']//div[@data-testid='Adult-testID-plus-one-cta']/*[@data-testid='svg-img']")).click();
			count--;
		}
		driver.findElement(By.xpath("//div[.='Currency']/following-sibling::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).click();
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-h3f8nf r-u8s1d r-8fdsdq']//descendant::div[@class='css-76zvg2 r-homxoj r-ubezar' and .='"+currency+"']")).click();
		WebElement search = driver.findElement(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-1i10wst r-1kfrs79' and .='Search Flight']"));
		a.moveToElement(search).click().perform();
	}
}

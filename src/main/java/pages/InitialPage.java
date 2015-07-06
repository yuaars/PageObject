package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class InitialPage {
        
    @FindBy(how=How.CSS, using="h1")
    private WebElement Header;
        
        
    @FindBy(how=How.CSS, using="h2")
    private WebElement ListHeader;
        
        
    @FindBy(how=How.LINK_TEXT, using="A/B Testing")
    private WebElement ABLink;
        
        
    @FindBy(how=How.CSS, using="a[href] > img")
    private WebElement GithubLink;
}



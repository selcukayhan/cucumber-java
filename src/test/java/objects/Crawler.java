package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Crawler extends BasePage{

    public Crawler(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "nav-flyout-anchor")
    private WebElement departmentsDropdown;

    @FindBy(id = "nav-link-shopall")
    private WebElement departments;

    @FindBy(xpath = "//*[@id='nav-flyout-shopAll']/div[2]")
    private WebElement departmentsList;



    public Crawler defaultCrawler(WebDriver driver) {
        return this;
    }

    public Crawler getUrlsAndWriteResponseToFileAndUploadToDropbox() {
        new HomePage(driver);
        moveTo(departments);
        WebElement departmentsDropDown = departmentsList;
        List<WebElement> departmentsDropDownListElementContainerElements = departmentsDropDown.findElements(By.tagName("a"));
        int itemCount = departmentsDropDownListElementContainerElements.size();
        System.out.println(itemCount);
        List<String> links = new ArrayList<String>();
        for(WebElement e : departmentsDropDownListElementContainerElements){
            links.add(e.getAttribute("href"));
        }
        writeFileAndUploadToDropbox((ArrayList) links);

        return this;
    }

    public Crawler uploadFileToDropBox(String fileName){
        Dropbox dropboxClient = new Dropbox();
        String path = "/Users/selcuk/Downloads/cucumber-java-example-master/";
        dropboxClient.uploadFile(path + fileName,"/results/"+ fileName);
        return this;
    }

    public Crawler writeFileAndUploadToDropbox(ArrayList links){

        String FNAME = new Date().getTime() + "-results.txt";
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String time = timestamp.toString();

        ArrayList<String> list_copy = new ArrayList();

        list_copy = links ;

        try ( BufferedWriter bw =
                      new BufferedWriter (new FileWriter(FNAME)) )
        {
            for (String line : list_copy) {
                driver.get(line);
                if(driver.getTitle()!=null){
                    bw.write (line + " " + driver.getTitle() + " Status : OK" +  "\n");
                }
                else
                    bw.write ( line + " " + driver.getTitle() + " Status : Dead Link" + "\n");

            }

        } catch (Exception e) {
            e.printStackTrace ();
        }

        uploadFileToDropBox(FNAME);
        return this;
    }

}






















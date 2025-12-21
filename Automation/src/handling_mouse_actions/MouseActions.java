package handling_mouse_actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MouseActions {

    private Actions actions;;

    public MouseActions(WebDriver driver){
        this.actions = new Actions(driver);
    }

    /**
     * This method is used for click on cursor point.
     */
    public void clickOnCursorPoint(){
        actions.click().perform();
    }

    /**
     * This method is used to click on element.
     * @param element <code>{@link WebElement}</code>
     */
    public void clickOnElement(WebElement element){
        actions.click(element).perform();
    }

    /**
     * This method is used to double-click on cursor point.
     */
    public void doubleOnCursorPoint(){
        actions.doubleClick().perform();
    }

    /**
     * This method is used to double-click on element.
     * @param element <code>{@link WebElement}</code>
     */
    public void doubleClickOnElement(WebElement element){
        actions.doubleClick(element).perform();
    }

    /**
     * This method is used to click on hold on cursor point.
     */
    public void clickAndHoldOnCursorPoint(){
        actions.clickAndHold().perform();
    }

    /**
     * This method is used to click and hold on element.
     * @param element <code>{@link WebElement}</code>
     */
    public void clickAndHoldOnElement(WebElement element){
        actions.clickAndHold(element).perform();
    }

    /**
     * This method is used to release the cursor.
     */
    public void release(){
        actions.release().perform();
    }

    /**
     * This method is used to release cursor from the element.
     * @param element <code>{@link WebElement}</code>
     */
    public void releaseElement(WebElement element){
        actions.release(element).perform();
    }

    /**
     * This method is used to enter value.
     * @param value <code>{@link String}</code>
     */
    public void enterValue(String value){
        actions.sendKeys(value).perform();
    }

    /**
     * This method is used to enter value into the element.
     * @param element <code>{@link WebElement}</code>
     * @param value   <code>{@link String}</code>
     */
    public void enterValueIntoElement(WebElement element , String value){
        actions.sendKeys(element, value).perform();
    }

    /**
     * This method is used to drag and drop the element
     * @param source <code>{@link WebElement}</code>
     * @param target <code>{@link WebElement}</code>
     */
    public void dragAndDrop(WebElement source, WebElement target){
        actions.dragAndDrop(source, target).perform();
    }


    /**
     * This method is used to drag and drop element to coordinates.
     * @param element <code>{@link WebElement}</code>
     * @param x <code>int</code>
     * @param y <code>int</code>
     */
    public void dragAndDropElementToCoordinates(WebElement element, int x, int y){
        actions.clickAndHold(element)
                .pause(Duration.ofMillis(500))
                .moveByOffset(x,y)
                .pause(Duration.ofMillis(500))
                .release(element)
                .build()
                .perform();
    }

    /**
     * This method is used to move the cursor to element.
     * @param element <code>{@link WebElement}</code>
     */
    public void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }

    /**
     * This method is used to move by off set.
     * @param xOffSet <code>int</code>
     * @param yOffSet <code>int</code>
     */
    public void moveByOffSet(int xOffSet, int yOffSet){
        actions.moveByOffset(xOffSet,yOffSet).perform();
    }

    /**
     * This method is used to move element to based on off set values.
     * @param element <code>{@link WebElement}</code>
     * @param offSetX <code>int</code>
     * @param offSetY <code>int</code>
     */
    public void moveToElementOffSet(WebElement element, int offSetX, int offSetY){
        actions.moveToElement(element, offSetX, offSetY).perform();
    }

    /**
     * This method is used to perform context click.
     */
    public void contextClick(){
        actions.contextClick().perform();
    }

    /**
     * This method is used to perform context click on element.
     * @param element <code>{@link WebElement}</code>
     */
    public void contextClickOnElement(WebElement element){
        actions.contextClick(element).perform();
    }

    /**
     * This method is used to scroll web page till element.
     * @param element <code>{@link WebElement}</code>
     */
    public void scrollToElement(WebElement element){
        actions.scrollToElement(element).perform();
    }

    /**
     * This method is used to scroll the web page by amount.
     * @param xPx <code>int</code>
     * @param yPx <code>int</code>
     */
    public void scrollByAmount(int xPx, int yPx){
        actions.scrollByAmount(xPx,yPx).perform();
    }

    /**
     * This method is used to press the key down.
     * @param keys <code>{@link Keys}</code>
     */
    public void keyDown(Keys keys){
        actions.keyDown(keys).perform();
    }

    /**
     * This method is used to enter value into field by press the keys.
     * @param element <code>{@link WebElement}</code>
     * @param keys    <code>{@link Keys}</code>
     */
    public void keyDownOnElement(WebElement element , String keys){
        actions.keyDown(element, keys)
                .sendKeys("selenium")
                .keyUp(keys)
                .perform();
    }

    /**
     * This method is used to release key.
     * @param keys <code>{@link Keys}</code>
     */
    public void keyUp(Keys keys){
        actions.keyUp(keys).perform();
    }

    /**
     * This method is used to release keys on element.
     * @param element <code>{@link WebElement}</code>
     * @param keys    <code>{@link Keys}</code>
     */
    public void keyUpOnElement(WebElement element , Keys keys){
        actions.keyUp(element, keys).perform();
    }
}
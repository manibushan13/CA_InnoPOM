//package SA.SeleniumLib;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.InvalidElementStateException;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.StaleElementReferenceException;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
///**
// * 
// * 
// * UI.java : Class implementing basic UI components.
// * 
// * Date Revision Name Change/Description
// * 
// * @author Mani
// * 
// * @version 1.0
// */
//
//public class UI extends SeleniumDriver {
//
//    public void refresh() {
//        driver.navigate().refresh();
//    }
//
//    public void click(String locator) {
//
//        WebElement element = driver.findElement(By.id(locator));
//        element.click();
//
//    }
//
//    // Added by Infosys
//    public void clickByTitle(String locator) {
//
//        WebElement element = driver.findElement(By.partialLinkText(locator));
//        element.click();
//
//    }
//
//    public void clickByCss(String locator) {
//        WebElement element = driver.findElement(By.cssSelector(locator));
//        element.click();
//    }
//
//    public void clickByName(String locator) {
//        WebElement element = driver.findElement(By.name(locator));
//        element.click();
//    }
//
//    public void clickByXpath(String locator) {
//        WebElement element = driver.findElement(By.xpath(locator));
//        element.click();
//    }
//
//    public boolean verifyText(String locator, String text) {
//        try {
//            WebElement element = driver.findElement(By.id(locator));
//
//            if (element.getText().equals(text)) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    public boolean verifyTextByXpath(String locator, String text) {
//        try {
//
//            WebElement element = driver.findElement(By.xpath(locator));
//            if (element.getText().equals(text)) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            logger.info("eception xpath");
//            return false;
//        }
//
//    }
//
//    public boolean verifyTextByCss(String locator, String text) {
//        try {
//
//            WebElement element = driver.findElement(By.cssSelector(locator));
//            if (element.getText().equals(text)) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            logger.info("exception");
//            return false;
//        }
//
//    }
//
//    public boolean verifyTextByName(String locator, String text) {
//        try {
//
//            WebElement element = driver.findElement(By.name(locator));
//            if (element.getText().equals(text)) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            logger.info("eception xpath");
//            return false;
//        }
//
//    }
//
//    // End Of Infosys Code
//
//    public void type(String locator, String text) {
//        WebElement element = driver.findElement(By.id(locator));
//        element.sendKeys(text);
//    }
//
//    public void select(String locator, String option) {
//
//        uidriver.select(locator, option);
//
//    }
//
//    public void exeJS(String jsScr) {
//        super.exeJS(jsScr);
//    }
//
//    public boolean isTextPresent(String locator) {
//        try {
//            WebElement element = driver.findElement(By.id(locator));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    public boolean isElementPresent(String locator) {
//        return isElementPresent(locator, false);
//    }
//
//    public boolean isElementPresent(String locator, boolean type) {
//
//        try {
//            if (!type) {
//                driver.findElement(By.id(locator));
//            } else {
//                driver.findElement(By.partialLinkText(locator));
//            }
//
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    // Added by Infosys
//    public String getCurrentPage(String locator) {
//        int i = 0;
//        do {
//            try {
//                WebElement element = driver.findElement(By.id(locator));
//                return element.getText().toString();
//            } catch (Exception e) {
//
//            }
//        } while (i++ != 3);
//        return "Not Found";
//    }
//
//    public String getCurrentTitle() {
//        int count = 0;
//        do {
//            try {
//                return driver.getTitle();
//            } catch (Exception e) {
//
//            }
//        } while (count < super.maxIteration);
//        return "Not Found";
//    }
//
//    public String getWarningMessage(String locator) {
//
//        WebElement element = driver.findElement(By.xpath(locator));
//        logger.info("element is   :" + element.getText());
//        return element.getText();
//    }
//
//    public boolean isElementPresentByName(String locator) {
//
//        try {
//            WebElement e = driver.findElement(By.name(locator));
//            logger.info("element searched  " + e);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    public String confirmationText(String locator) {
//        WebElement e = driver.findElement(By.id(locator));
//        return e.getText().trim().toString();
//    }
//
//    public boolean isElementPresentByTitle(String locator) {
//
//        try {
//            logger.info("element before searched  ");
//            WebElement e = driver.findElement(By.partialLinkText(locator));
//            logger.info("element searched  " + e);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    public boolean isElementPresentByXPath(String locator) {
//
//        try {
//            driver.findElement(By.xpath(locator));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    public boolean isElementPresentByCss(String locator) {
//
//        try {
//            driver.findElement(By.cssSelector(locator));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }
//
//    public boolean isElementPresentByXpath(String locator) {
//
//        try {
//
//            driver.findElement(By.xpath(locator));
//            return true;
//        }
//
//        catch (Exception e) {
//            return false;
//        }
//    }
//
//    // Added by Infosys
//
//    public UIElement getElement(String locator) {
//        return getElement(locator, false);
//    }
//
//    public UIElement getElement(String locator, boolean type) {
//        int iteration = 0;
//        WebElement element;
//        do {
//            try {
//
//                if (!type) {
//                    element = driver.findElement(By.id(locator));
//                    UIElement uiElement = new UIElement(element);
//                    return uiElement;
//                } else {
//                    element = driver.findElement(By.partialLinkText(locator));
//                    UIElement uiElement = new UIElement(element);
//                    return uiElement;
//                }
//            } catch (Exception e) {
//
//            }
//        } while (iteration++ < super.maxIteration);
//        return null;
//    }
//
//    public UIElement getElementByCss(String locator) {
//        try {
//            WebElement element;
//            element = driver.findElement(By.cssSelector(locator));
//            UIElement uiElement = new UIElement(element);
//            return uiElement;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public UIElement getElementByXpath(String locator) {
//        try {
//            WebElement element;
//            element = driver.findElement(By.xpath(locator));
//            UIElement uiElement = new UIElement(element);
//            return uiElement;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public List<UIElement> getElementListByXpath(String locator) {
//        try {
//            List<WebElement> webElements = driver.findElements(By.xpath(locator));
//            List<UIElement> uiElements = new ArrayList<UIElement>();
//            for (WebElement webElem : webElements) {
//                uiElements.add(new UIElement(webElem));
//            }
//            return uiElements;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public void selectElementFromListByText(String itemToSelect, String locator) {
//        List<UIElement> elements = getElementListByXpath(locator);
//        for (UIElement element : elements) {
//            if (element.text.equals(itemToSelect)) {
//                element.click();
//                break;
//            }
//
//        }
//    }
//
//    public UIElement getElementByName(String locator) {
//        try {
//            WebElement element;
//            element = driver.findElement(By.name(locator));
//            UIElement uiElement = new UIElement(element);
//            return uiElement;
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public boolean isSelected(String locator) {
//        WebElement elementById = driver.findElement(By.id(locator));
//        if (elementById.isSelected()) {
//            return true;
//        } else
//            return false;
//    }
//
//    public boolean isSelectedByName(String locator) {
//        WebElement elementByName = driver.findElement(By.name(locator));
//        if (elementByName.isSelected()) {
//            return true;
//        } else
//            return false;
//    }
//
//    public String getSelectedText(String locator) {
//        WebElement elementById = driver.findElement(By.id(locator));
//        String selectedOption = new Select(elementById).getFirstSelectedOption().getText();
//        return selectedOption;
//
//    }
//
//    // End Of Infosys code
//
//    public boolean isElementEditable(String locator) {
//        return uidriver.isEditable(locator);
//
//    }
//
//    public boolean waitForText(String locator) {
//
//        return waitForText(locator, 200);
//
//    }
//
//    public boolean waitForText(String locator, int timeoutSec) {
//
//        int sec = 0;
//        do {
//            try {
//                if (isTextPresent(locator)) {
//                    return true;
//                }
//            } catch (Exception e) {
//            }
//            try {
//                Thread.sleep(Integer.parseInt("1000"));
//                System.out.print(", " + sec);
//            } catch (InterruptedException e) {
//            }
//
//        } while ((sec++) != timeoutSec);
//        System.out.println("exit");
//        return false;
//    }
//
//    public boolean waitForElement(String locator) {
//
//        return waitForElement(locator, Integer.parseInt("60"), false);
//
//    }
//
//    public boolean waitForElement(String locator, boolean type) {
//
//        return waitForElement(locator, Integer.parseInt("60"), type);
//
//    }
//
//    public boolean waitForElement(String locator, int timeoutSec) {
//        return waitForElement(locator, timeoutSec, false);
//    }
//
//    public boolean waitForElement(String locator, int timeoutSec, boolean type) {
//        logger.info("Wait for " + locator + " for " + timeoutSec + " sec");
//        int sec = 0;
//        do {
//            try {
//                if (isElementPresent(locator, type)) {
//                    return true;
//                } else {
//                    logger.info("Unable to locate the element" + locator);
//                }
//            } catch (Exception e) {
//            }
//            try {
//                Thread.sleep(Integer.parseInt("1000"));
//            } catch (InterruptedException e) {
//            }
//        } while ((sec++) != timeoutSec);
//        return false;
//    }
//
//    // Added by Infosys
//    public boolean waitForElementByXpath(String locator) {
//
//        return waitForElementByXpath(locator, Integer.parseInt("60"));
//
//    }
//
//    public boolean waitForElementByXpath(String locator, int timeoutSec) {
//        logger.info("Wait for " + locator + " for " + timeoutSec + " sec");
//        int sec = 0;
//        do {
//            try {
//                if (isElementPresentByXPath(locator)) {
//                    return true;
//                }
//            } catch (Exception e) {
//            }
//            try {
//                Thread.sleep(Integer.parseInt("1000"));
//            } catch (InterruptedException e) {
//            }
//        } while ((sec++) != timeoutSec);
//        return false;
//    }
//
//    public boolean waitForElementByName(String locator) {
//
//        return waitForElementByName(locator, Integer.parseInt("60"));
//
//    }
//
//    public boolean waitForElementByName(String locator, int timeoutSec) {
//        logger.info("Wait for " + locator + " for " + timeoutSec + " sec");
//        int sec = 0;
//        do {
//            try {
//                if (isElementPresentByName(locator)) {
//                    return true;
//                }
//            } catch (Exception e) {
//            }
//            try {
//                Thread.sleep(Integer.parseInt("1000"));
//            } catch (InterruptedException e) {
//            }
//        } while ((sec++) != timeoutSec);
//        return false;
//    }
//
//    public boolean waitForElementByCss(String locator) {
//
//        return waitForElementByCss(locator, Integer.parseInt("60"));
//
//    }
//
//    public boolean waitForElementByCss(String locator, int timeoutSec) {
//        logger.info("Wait for " + locator + " for " + timeoutSec + " sec");
//        int sec = 0;
//        do {
//            try {
//                if (isElementPresentByCss(locator)) {
//                    return true;
//                }
//            } catch (Exception e) {
//            }
//            try {
//                Thread.sleep(Integer.parseInt("1000"));
//            } catch (InterruptedException e) {
//            }
//        } while ((sec++) != timeoutSec);
//        return false;
//    }
//
//    // End Of Infosys Code
//
//    public void waitForPageToLoad(String timeout) {
//
//        waitForPageLoaded(driver, timeout);
//        driver.switchTo().window(driver.getWindowHandle());
//    }
//
//    public void waitForPageLoaded(WebDriver driver, String timeout) {
//
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor) driver).executeScript(
//                        "return document.readyState").equals("complete");
//
//            }
//        };
//
//        int i = 0;
//        do {
//            try {
//                Wait<WebDriver> wait = new WebDriverWait(driver, Integer.parseInt(timeout));
//                wait.until(expectation);
//                break;
//            } catch (Throwable error) {
//                System.out.println("Timeout waiting for Page Load Request to complete.");
//            }
//        } while (i++ < super.maxIteration);
//
//    }
//
//    public String getCurrentPageURL() {
//        String currentPage = null;
//        waitForPageToLoad(uiTimeout);
//        currentPage = driver.getCurrentUrl();
//        return currentPage;
//    }
//
//    public boolean openNewTab(String url) {
//        driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
//        for (String winHandle : driver.getWindowHandles()) {
//            driver.switchTo().window(winHandle);
//        }
//        try {
//            driver.navigate().to(url);
//        } catch (Exception e) {
//            logger.debug("Exception raised while openings a new tab" + e.getMessage());
//            return false;
//        }
//        return true;
//    }
//
//    public boolean closeLastTab() {
//        try {
//            driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");
//        } catch (Exception e) {
//            logger.debug("Exception raised while closing a new tab" + e.getMessage());
//            return false;
//        }
//        return true;
//    }
//
//    public String labelNameByInput(String inputLocator) {
//
//        return uidriver.getAttribute("//lable[@for='" + inputLocator + "']");
//
//    }
//
//    public String value(String inputLocator1) {
//
//        return uidriver.getAttribute("//div[@id='" + inputLocator1 + "']/@class");
//
//    }
//
//    public String stateOfSubTab(String inputLocator2) {
//
//        return uidriver.getAttribute("//a[@id='" + inputLocator2 + "']/@class");
//
//    }
//
//    public String getClassAttribute(String inputLocator) {
//
//        return uidriver.getAttribute(inputLocator + "/@class");
//
//    }
//
//    public String getInputValue(String uiLocator) {
//
//        return uidriver.getValue(uiLocator);
//
//    }
//
//    public String takeSnap() {
//
//        return uidriver.captureScreenshotToString();
//
//    }
//
//    public class UIObject {
//
//        public String locator;
//        public int maxIteration = 10;
//
//        public UIObject(String locator) {
//
//            this.locator = locator;
//
//        }
//
//        public boolean isPresent() {
//
//            return isElementPresent(this.locator);
//
//        }
//
//        public boolean isDisplayed() {
//            WebElement element = driver.findElement(By.id(this.locator));
//            return element.isDisplayed();
//        }
//
//        // Added by Infosys
//        public boolean isPresentByName() {
//
//            return isElementPresentByName(this.locator);
//        }
//
//        public boolean isPresentByXpath() {
//
//            try {
//                WebElement e = driver.findElement(By.xpath(this.locator));
//                logger.info("element searched  " + e);
//                return true;
//            } catch (Exception e) {
//                return false;
//            }
//        }
//
//        public boolean isActiveByName(int timeOut) {
//            int sec = 0;
//            do {
//                try {
//                    if (getElementByName(this.locator).element.isEnabled()) {
//                        return true;
//                    }
//                } catch (Exception e) {
//                }
//
//                try {
//                    Thread.sleep(Integer.parseInt("1000"));
//
//                } catch (InterruptedException e) {
//                    logger.info("Exception");
//                }
//
//            } while ((sec++) != timeOut);
//            return false;
//        }
//
//        public boolean isActiveByXpath(int timeOut) {
//            int sec = 0;
//            do {
//                try {
//                    if (getElementByXpath(this.locator).element.isEnabled()) {
//                        return true;
//                    }
//                } catch (Exception e) {
//                }
//
//                try {
//                    Thread.sleep(Integer.parseInt("1000"));
//
//                } catch (InterruptedException e) {
//                    logger.info("Exception");
//                }
//
//            } while ((sec++) != timeOut);
//            return false;
//        }
//
//        // End Of Infosys Code
//
//        public boolean isActive() {
//            return getElement(this.locator).element.isEnabled();
//        }
//
//        int staticTimeOut = 5;
//
//        public boolean isActive(int timeOut) {
//            int sec = 0;
//            do {
//                try {
//                    if (getElement(this.locator).element.isEnabled()) {
//                        return true;
//                    }
//                } catch (Exception e) {
//                }
//
//                try {
//                    Thread.sleep(Integer.parseInt("1000"));
//
//                } catch (InterruptedException e) {
//
//                }
//
//            } while ((sec++) != timeOut);
//            return false;
//        }
//
//    }
//
//    public class Button extends UIObject {
//
//        public Button(String locator) {
//
//            super(locator);
//
//        }
//
//        public WebElement waitForClick(int locatorById) {
//            int count = 0;
//            WebElement element = null;
//            WebDriverWait wait = new WebDriverWait(driver, staticTimeOut);
//            do {
//                try {
//                    switch (locatorById) {
//                    case 0:
//                        element = driver.findElement(By.id(locator));
//                        wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
//                        break;
//                    case 1:
//                        element = driver.findElement(By.name(locator));
//                        wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
//                        break;
//                    case 2:
//                        element = driver.findElement(By.xpath(locator));
//                        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
//                        break;
//                    }
//                    break;
//                } catch (Exception e) {
//                    logger.trace("Exception raised" + e.toString());
//                }
//
//            } while (count++ < maxIteration);
//
//            return element;
//        }
//
//        public void click() {
//
//            if (super.isPresent() && super.isActive(staticTimeOut)) {
//                WebElement element = waitForClick(0);
//                element.click();
//                WebDriverWait wait = new WebDriverWait(driver, staticTimeOut);
//                try {
//                    wait.until(ExpectedConditions.stalenessOf(element));
//                } catch (TimeoutException e) {
//                    logger.trace(
//                            "Wait time is sufficient in most of the scenarious, hence getting this exception is very rare. Even if we get this then that is the once which can be ignored. Exception : "
//                                    + e.toString());
//                    // TODO Auto-generated catch block
//                } catch (StaleElementReferenceException e) {
//                    logger.trace(
//                            "Wait time is sufficient in most of the scenarious, hence getting this exception is very rare. Even if we get this then that is the once which can be ignored. Exception : "
//                                    + e.toString());
//                }
//            }
//        }
//
//        public void waitToClick() {
//            WebDriverWait wait = new WebDriverWait(driver, staticTimeOut * 5);
//            wait.until(ExpectedConditions.elementToBeClickable((By.id(super.locator))));
//        }
//
//        // Added by Infosys
//
//        public void clickCancel() {
//
//            if (super.isPresent() && super.isActive(staticTimeOut)) {
//                WebElement element = driver.findElement(By.id(super.locator));
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//            }
//        }
//
//        public void clickByName() {
//
//            if (super.isPresentByName() && super.isActiveByName(staticTimeOut)) {
//                WebElement element = waitForClick(1);
//                element.click();
//                WebDriverWait wait = new WebDriverWait(driver, staticTimeOut);
//                try {
//                    wait.until(ExpectedConditions.stalenessOf(element));
//                } catch (TimeoutException e) {
//                    logger.trace(
//                            "Wait time is sufficient in most of the scenarious, hence getting this exception is very rare. Even if we get this then that is the once which can be ignored. Exception : "
//                                    + e.toString());
//                    // TODO Auto-generated catch block
//                } catch (StaleElementReferenceException e) {
//                    logger.trace(
//                            "Wait time is sufficient in most of the scenarious, hence getting this exception is very rare. Even if we get this then that is the once which can be ignored. Exception : "
//                                    + e.toString());
//                }
//            }
//        }
//
//        public void clickAndUpload(String path) {
//            if (super.isPresentByXpath() && super.isActiveByXpath(staticTimeOut)) {
//                driver.findElement(By.xpath(super.locator)).sendKeys(path);
//            }
//        }
//
//        public void clickAndUploadById(String path) {
//            if (super.isPresent() && super.isActive(staticTimeOut)) {
//                driver.findElement(By.id(super.locator)).sendKeys(path);
//            }
//        }
//
//        public void scrollDown() {
//            WebElement element = driver.findElement(By.xpath(super.locator));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//                    element);
//        }
//
//        public void scrollinView(String id) {
//            WebElement element = driver.findElement(By.id(id));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//                    element);
//        }
//
//        public void scrollinViewbyName(String id) {
//            WebElement element = driver.findElement(By.name(id));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//                    element);
//        }
//
//        public void clickByXpath() {
//
//            if (super.isPresentByXpath()) {
//                WebElement element = waitForClick(2);
//                element.click();
//                WebDriverWait wait = new WebDriverWait(driver, staticTimeOut);
//                try {
//                    wait.until(ExpectedConditions.stalenessOf(element));
//                } catch (TimeoutException e) {
//                    logger.trace(
//                            "Wait time is sufficient in most of the scenarious, hence getting this exception is very rare. Even if we get this then that is the once which can be ignored. Exception : "
//                                    + e.toString());
//                    // TODO Auto-generated catch block
//                } catch (StaleElementReferenceException e) {
//                    logger.trace(
//                            "Wait time is sufficient in most of the scenarious, hence getting this exception is very rare. Even if we get this then that is the once which can be ignored. Exception : "
//                                    + e.toString());
//                }
//            }
//        }
//
//        public void clickByXpathUsingEnter() {
//
//            if (super.isPresentByXpath()) {
//
//                WebElement clickByName = driver.findElement(By.xpath(super.locator));
//                clickByName.sendKeys(Keys.ENTER);
//            }
//        }
//        // End Of Infosys code
//
//    }
//
//    public class CheckBox extends UIObject {
//
//        public CheckBox(String locator) {
//
//            super(locator);
//
//        }
//
//        public boolean isChecked() {
//            boolean selected = false;
//            if (super.isPresent() && super.isActive(staticTimeOut)) {
//                WebElement element = driver.findElement(By.id(super.locator));
//
//                if (element != null) {
//                    selected = element.isSelected();
//                    logger.info("checkbox " + super.locator + " | " + selected);
//                }
//            }
//            return selected;
//        }
//
//        public void check() {
//
//            if (super.isPresent() && super.isActive(staticTimeOut)) {
//
//                WebElement element = driver.findElement(By.id(super.locator));
//                if (element != null) {
//                    if (!element.isSelected()) {
//                        logger.info("checkbox " + super.locator + " | " + element.isSelected());
//                        try {
//                            element.click();
//                        } catch (org.openqa.selenium.WebDriverException e) {
//
//                            if (e.getMessage().contains("Element is not clickable at point")) {
//                                System.out.println("Not clickable");
//                                exeJS("document.getElementById('" + super.locator
//                                        + "').focus();");
//                                element.click();
//                            } else {
//                                throw e;
//                            }
//                        }
//                    } else {
//                        logger.info("checkbox " + super.locator + " | " + element.isSelected());
//                    }
//                }
//            }
//
//        }
//
//        public void scrollDown() {
//            WebElement element = driver.findElement(By.id(super.locator));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//                    element);
//        }
//
//        // Added by Infosys
//        public void uncheckByXpath() {
//
//            if (super.isPresentByXpath()) {
//
//                WebElement element = driver.findElement(By.xpath(super.locator));
//                if (element != null) {
//                    if (element.isSelected()) {
//                        try {
//                            element.click();
//                        } catch (org.openqa.selenium.WebDriverException e) {
//
//                            if (e.getMessage().contains("Element is not clickable at point")) {
//                                System.out.println("Not clickable");
//
//                                element.click();
//                            } else {
//                                throw e;
//                            }
//                        }
//                    }
//                }
//
//            }
//        }
//
//        // End Of Infosys code
//        public void uncheck() {
//
//            if (super.isPresent() && super.isActive(staticTimeOut)) {
//
//                WebElement element = driver.findElement(By.id(super.locator));
//                if (element != null) {
//                    if (element.isSelected()) {
//                        try {
//                            element.click();
//                        } catch (org.openqa.selenium.WebDriverException e) {
//
//                            if (e.getMessage().contains("Element is not clickable at point")) {
//                                System.out.println("Not clickable");
//                                exeJS("document.getElementById('" + super.locator
//                                        + "').focus();");
//                                element.click();
//                            } else {
//                                throw e;
//                            }
//                        }
//                    }
//                }
//
//            }
//
//        }
//
//        public void scrollDownToCheckbox() {
//            WebElement element = driver.findElement(By.id(super.locator));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//                    element);
//        }
//
//        // Added by Infosys
//        public void uncheckByName() {
//
//            if (super.isPresentByName() && super.isActiveByName(staticTimeOut)) {
//
//                WebElement element = driver.findElement(By.name(super.locator));
//                if (element != null) {
//                    if (element.isSelected()) {
//                        try {
//                            element.click();
//                        } catch (org.openqa.selenium.WebDriverException e) {
//
//                            if (e.getMessage().contains("Element is not clickable at point")) {
//                                System.out.println("Not clickable");
//                                exeJS("document.getElementById('" + super.locator
//                                        + "').focus();");
//                                element.click();
//                            } else {
//                                throw e;
//                            }
//                        }
//                    }
//                }
//
//            }
//
//        }
//
//        public void checkByName() {
//            if (super.isPresentByName() && super.isActiveByName(staticTimeOut)) {
//                WebElement element = driver.findElement(By.name(super.locator));
//                if (element != null) {
//                    if (!element.isSelected()) {
//                        try {
//                            element.click();
//                        } catch (org.openqa.selenium.WebDriverException e) {
//
//                            if (e.getMessage().contains("Element is not clickable at point")) {
//                                System.out.println("Not clickable");
//                                exeJS("document.getElementByName('" + super.locator
//                                        + "').focus();");
//                                element.click();
//                            } else {
//                                throw e;
//                            }
//                        }
//                    } else {
//                        logger.info("checkbox " + super.locator + " | " + element.isSelected());
//                    }
//                }
//            }
//
//        }
//
//        public void checkByXpath() {
//
//            if (super.isPresentByXpath()) {
//
//                WebElement element = driver.findElement(By.xpath(super.locator));
//                if (element != null) {
//                    if (!element.isSelected()) {
//                        logger.info("checkbox " + super.locator + " | " + element.isSelected());
//                        try {
//                            element.click();
//                        } catch (org.openqa.selenium.WebDriverException e) {
//
//                            if (e.getMessage().contains("Element is not clickable at point")) {
//                                System.out.println("Not clickable");
//                                exeJS("document.getElementById('" + super.locator
//                                        + "').focus();");
//                                element.click();
//                            } else {
//                                throw e;
//                            }
//                        }
//                    } else {
//                        logger.info("checkbox " + super.locator + " | " + element.isSelected());
//                    }
//                }
//            }
//
//        }
//
//        private int checkboxCount;
//
//        public void checkAllCheckBoxesByXpth() {
//            if (super.isPresentByXpath()) {
//
//                List<WebElement> checkboxList = driver.findElements(By.xpath(super.locator));
//                checkboxCount = checkboxList.size();
//                System.out.println("Number of check boxes are " + checkboxCount);
//                for (int i = 0; i < checkboxCount; i++) {
//                    checkboxList.get(i).click();
//                }
//            }
//
//        }
//        // End Of Infosys code
//
//    }
//
//    public class Radio extends UIObject {
//        public Radio(String locator) {
//            super(locator);
//        }
//
//        public void select() {
//            if (super.isPresent() && isActive(staticTimeOut)) {
//                WebElement element = driver.findElement(By.id(super.locator));
//                try {
//                    element.click();
//                } catch (org.openqa.selenium.WebDriverException e) {
//
//                    if (e.getMessage().contains("Element is not clickable at point")) {
//                        System.out.println("Not clickable");
//                        exeJS("document.getElementById('" + super.locator + "').focus();");
//                        element.click();
//                    } else {
//                        throw e;
//                    }
//                }
//            }
//        }
//
//        // Added by Infosys
//        public void selectByXpath() {
//            if (super.isPresentByXpath() && isActiveByXpath(staticTimeOut)) {
//                WebElement element = driver.findElement(By.xpath(super.locator));
//                try {
//                    if (!element.isSelected())
//                        element.click();
//                } catch (org.openqa.selenium.WebDriverException e) {
//
//                    if (e.getMessage().contains("Element is not clickable at point")) {
//                        System.out.println("Not clickable");
//                        exeJS("document.getElementByXpath('" + super.locator + "').focus();");
//                        element.click();
//                    } else {
//                        throw e;
//                    }
//                }
//            }
//
//        }
//        // End Of Infosys code
//
//    }
//
//    public class Link extends UIObject {
//
//        public Link(String locator) {
//
//            super(locator);
//
//        }
//
//        public boolean isPresent() {
//
//            return isElementPresent(this.locator, true);
//
//        }
//
//        public void click() {
//
//            if (isElementPresent(this.locator, true)) {
//                WebElement element = driver.findElement(By.partialLinkText(super.locator));
//                element.click();
//            }
//
//        }
//        
//        public void clickById() {
//            if (isElementPresent(this.locator)) {
//                WebElement element = driver.findElement(By.id(super.locator));
//                element.click();
//            }
//
//        }
//
//        // Added by Infosys
//        public void clickByXpath() {
//
//            if (isElementPresentByXpath(this.locator)) {
//                WebElement element = driver.findElement(By.xpath(super.locator));
//                element.click();
//            }
//        }
//
//        public void scrollDown() {
//            WebElement element = driver.findElement(By.xpath(super.locator));
//            element.sendKeys(Keys.PAGE_DOWN);
//        }
//
//        // End of Infosys code
//        public String getText() {
//            if (isElementPresent(this.locator, true)) {
//                return uidriver.getText(super.locator);
//            }
//            return null;
//        }
//
//    }
//
//    public class Label extends UIObject {
//
//        public Label(String locator) {
//
//            super(locator);
//
//        }
//
//        public String getText() {
//
//            return uidriver.getText(super.locator);
//        }
//        
//        public String getInnerHtml(){
//			WebElement findElement = driver.findElement(By.id(locator));
//			return findElement.getText();
//		}
//
//    }
//
//    public class TextBox extends UIObject {
//
//        public Label label;
//
//        public TextBox(String locator, String labelLocator) {
//            super(locator);
//            if (labelLocator != null) {
//
//                label = new Label(labelLocator);
//            }
//        }
//
//        public WebElement waitToType(int locatorById) {
//            int count = 0;
//            WebElement element = null;
//            WebDriverWait wait = new WebDriverWait(driver, staticTimeOut * 5);
//            do {
//                try {
//                    switch (locatorById) {
//                    case 0:
//                        element = driver.findElement(By.id(locator));
//                        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
//                        break;
//                    case 1:
//                        element = driver.findElement(By.name(locator));
//                        wait.until(
//                                ExpectedConditions.presenceOfElementLocated(By.name(locator)));
//                        break;
//                    case 2:
//                        element = driver.findElement(By.xpath(locator));
//                        wait.until(
//                                ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//                        break;
//                    }
//                } catch (Exception e) {
//                    logger.trace("Exception raised" + e.toString());
//                }
//
//            } while (count++ < maxIteration);
//            return element;
//        }
//
//        public void type(String inputText) {
//            waitForElement(super.locator, 60);
//            WebElement element = waitToType(0);
//            element.clear();
//            element.sendKeys(inputText);
//        }
//
//        public void scrollinView(String id) {
//            WebElement element = driver.findElement(By.id(id));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
//                    element);
//        }
//
//        public void waitToType() {
//            WebDriverWait wait = new WebDriverWait(driver, staticTimeOut * 5);
//            wait.until(ExpectedConditions.presenceOfElementLocated((By.id(super.locator))));
//        }
//
//        // Added by Infosys
//        public void typeByName(String inputText) {
//            waitForElementByName(super.locator, 60);
//            WebElement element = waitToType(1);
//            if (element.isDisplayed() == true) {
//                element.clear();
//                Actions build = new Actions(driver);
//                build.moveToElement(element).sendKeys("").build().perform();
//                if (element.isEnabled() == true) {
//                    element.sendKeys(inputText);
//                }
//            }
//        }
//
//        public void typeByXpath(String inputText) {
//            waitForElementByXpath(super.locator, 60);
//            WebElement element = waitToType(2);
//            element.clear();
//            element.sendKeys(inputText);
//        }
//
//        /**
//         * This method will type the given text in text box and catch the Exception if element
//         * is not interactable or having invalid state and control will go to next statement
//         * 
//         * @param inputText
//         */
//        public void typeWithCheckElementState(String inputText) {
//            waitForElement(super.locator, 60);
//            WebElement element = waitToType(0);
//            try {
//                element.clear();
//                element.sendKeys(inputText);
//            } catch (InvalidElementStateException exception) {
//                logger.warn("Element " + super.locator + " State is invalid, can not type ");
//            }
//        }
//
//        public void clearTextboxByName() {
//            waitForElementByName(super.locator, 60);
//            WebElement element = waitToType(1);
//            element.clear();
//        }
//
//        public boolean waitForElementByName(String locator, int timeoutSec) {
//            logger.info("Wait for " + locator + " for " + timeoutSec + " sec");
//            int sec = 0;
//            do {
//                try {
//                    if (isElementPresentByName(locator)) {
//                        return true;
//                    }
//                } catch (Exception e) {
//                }
//                try {
//                    Thread.sleep(Integer.parseInt("1000"));
//                } catch (InterruptedException e) {
//                }
//            } while ((sec++) != timeoutSec);
//            return false;
//        }
//
//        // End Of Infosys code
//
//        public boolean isEditable() {
//
//            return uidriver.isEditable(super.locator);
//
//        }
//
//        public String getValue() {
//            String value = null;
//            if (super.isPresent() && super.isDisplayed()) {
//                WebElement element = driver.findElement(By.id(super.locator));
//                value = element.getAttribute("value");
//            }
//            return value;
//        }
//
//        public void click() {
//            // TODO Auto-generated method stub
//            if (super.isPresent()) {
//
//                uidriver.click(super.locator);
//
//            }
//        }
//
//        public void typeKeys(String inputString) {
//            // TODO Auto-generated method stub
//            if (super.isPresent()) {
//                uidriver.typeKeys(super.locator, inputString);
//
//            }
//        }
//
//        public void typeAlias(String inputText) {
//            waitForElement(super.locator, 60);
//            WebElement element = driver.findElement(By.id(super.locator));
//            element.clear();
//            element.sendKeys(inputText);
//            element.sendKeys(Keys.TAB);
//
//        }
//
//        public void typeSSL(String inputText) throws InterruptedException {
//            waitForElement(super.locator, 60);
//            WebElement element = driver.findElement(By.id(super.locator));
//            element.sendKeys(inputText);
//
//        }
//
//        public void typeCTRLDEL(String tb, String inputString) {
//            if (super.isPresent()) {
//
//                WebElement tbelement = driver.findElement(By.xpath(tb));
//
//                new Actions(driver).moveToElement(tbelement).click().perform();
//                tbelement.click();
//                tbelement.sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
//                tbelement.sendKeys(Keys.ARROW_LEFT);
//                tbelement.sendKeys(Keys.DELETE);
//                // TODO - The actual implementation of
//                // "Deleting a char from an editbox using CTRL+DEL key presses" is not working
//                // properly in
//                // selenium
//                // Hence deleted the char using only the Delete key press.
//                // Actions actionObj = new Actions(driver);
//                // actionObj.keyDown(Keys.CONTROL).sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();
//                // actionObj.sendKeys(Keys.chord(Keys.CONTROL, Keys.END)).perform();
//                // actionObj.sendKeys(Keys.ARROW_LEFT).keyDown(Keys.CONTROL).sendKeys(Keys.DELETE).keyUp(Keys.CONTROL).perform();
//                // actionObj.sendKeys(Keys.chord(Keys.CONTROL, Keys.DELETE)).perform();
//
//            }
//        }
//
//    }
//
//    public class MultiSelect extends UIObject {
//
//        String addBtLocator;
//        String resultantSelect;
//
//        public MultiSelect(String locator, String addBtLocator) {
//
//            super(locator);
//            this.addBtLocator = addBtLocator;
//
//        }
//
//        public MultiSelect(String locator, String addBtLocator, String resultantSelect) {
//
//            super(locator);
//            this.resultantSelect = resultantSelect;
//            this.addBtLocator = addBtLocator;
//
//        }
//
//        public void addToSelected(String itemToSelect) {
//            waitForElement(super.locator);
//            if (super.isPresent()) {
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                boolean clearFirst = true;
//                if (clearFirst) {
//                    select.deselectAll();
//                }
//                select.selectByVisibleText(itemToSelect);
//
//                WebElement element = driver.findElement(By.id(addBtLocator));
//                element.click();
//            }
//
//        }
//
//        // Added by Infosys
//        public void addToSelectedModified() {
//            waitForElement(super.locator);
//            if (super.isPresent()) {
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                List<WebElement> list = select.getOptions();
//                int countOfOptionElement = list.size();
//
//                logger.info("no of elements  " + countOfOptionElement);
//
//                if (countOfOptionElement > 0) {
//                    logger.info("inside addToSelectedModified");
//                    boolean clearFirst = true;
//                    if (clearFirst) {
//                        select.deselectAll();
//                    }
//                    for (int i = 0; (i < countOfOptionElement) && (i < 3); i++) {
//
//                        try {
//                            select.selectByValue("" + i);
//                        } catch (Exception e) {
//                            select.selectByValue("dummyOption");
//                        }
//                        WebElement element = driver.findElement(By.id(addBtLocator));
//                        element.click();
//                    }
//                }
//
//            }
//
//        }
//
//        public void addToSelectedModifiedWithCount(Integer count) {
//            waitForElement(super.locator);
//            if (super.isPresent()) {
//
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                List<WebElement> list = select.getOptions();
//                int countOfOptionElement = list.size();
//                logger.info("no of elements  " + countOfOptionElement);
//
//                if (countOfOptionElement > 0) {
//
//                    for (int i = 0; (i < countOfOptionElement) && (i < count); i++) {
//                        try {
//                            select.selectByValue("" + i);
//                        } catch (Exception e) {
//                            select.selectByValue("dummyOption");
//                        }
//                        WebElement element = driver.findElement(By.id(addBtLocator));
//                        element.click();
//                    }
//                }
//
//            }
//
//        }
//
//        // End Of Infosys code
//
//        public void selectFromAdd(String itemToSelect) {
//            waitForElement(super.locator);
//            if (super.isPresent()) {
//                Select select = new Select(driver.findElement(By.id(resultantSelect)));
//                select.selectByVisibleText(itemToSelect);
//            }
//        }
//    }
//
//    public class DropDown extends UIObject {
//
//        public DropDown(String locator) {
//
//            super(locator);
//
//        }
//
//        public void select(String itemToSelect) {
//
//            if (super.isPresent()) {
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                select.selectByVisibleText(itemToSelect);
//                exeJS("document.getElementById('" + super.locator + "').blur();");
//
//            }
//        }
//
//        // Added by Infosys
//        public void selectByName(String itemToSelect) {
//
//            if (super.isPresentByName()) {
//                logger.info("select by name has started.");
//                Select select = new Select(driver.findElement(By.name(super.locator)));
//                select.selectByVisibleText(itemToSelect);
//
//            }
//        }
//
//        // Added by Infosys
//        public void selectAfterDeselectAll(String itemToSelect) {
//
//            if (super.isPresent()) {
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                select.deselectAll();
//                select.selectByVisibleText(itemToSelect);
//                exeJS("document.getElementById('" + super.locator + "').blur();");
//
//            }
//        }
//
//        public int selectByIndex(int i) {
//
//            if (super.isPresentByName()) {
//                logger.info("select by name has started.");
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                select.selectByIndex(i);
//            }
//            return i;
//        }
//
//        // Added by Infosys
//        public int selectByIndexUsingXpath(int i) {
//            if (super.isPresentByXpath()) {
//                logger.info("select by index has started.");
//                Select select = new Select(driver.findElement(By.xpath(super.locator)));
//                select.selectByIndex(i);
//            }
//            return i;
//        }
//
//        public void selectByValue(String itemToSelect) {
//
//            logger.info("Select by Value has started");
//            if (super.isPresentByName()) {
//                Select select = new Select(driver.findElement(By.name(super.locator)));
//                select.selectByValue(itemToSelect);
//
//            }
//        }
//
//        // Added by Infy
//        public void selectByValueById(String itemToSelect) {
//
//            logger.info("Select by Value has started");
//            if (super.isPresent()) {
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                select.selectByValue(itemToSelect);
//
//            }
//        }
//
//        public void selectByXpath(String itemToSelect) {
//            if (super.isPresentByXpath()) {
//                logger.info("select by xpath has started.");
//                Select select = new Select(driver.findElement(By.xpath(super.locator)));
//                select.selectByVisibleText(itemToSelect);
//
//            }
//        }
//
//        public List<WebElement> getOptionElementList() {
//            List<WebElement> option = null;
//            if (super.isPresent()) {
//                option = new ArrayList<WebElement>();
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                for (WebElement elem : select.getOptions()) {
//                    option.add(elem);
//                }
//            }
//            return option;
//        }
//
//        public void selectMultiple() {
//
//            List<WebElement> option = null;
//            if (super.isPresent()) {
//
//                WebElement select = driver.findElement(By.id(super.locator));
//                option = select.findElements(By.tagName("option"));
//
//                for (int i = 0; i < option.size(); i++) {
//                    option.get(i).click();
//                }
//            }
//        }
//
//        public int optionsListCount;
//
//        public void getOptionListWithSiz() {
//            if (super.isPresent()) {
//                WebElement elementById = driver.findElement(By.id(super.locator));
//                List<WebElement> optnList_Id = elementById.findElements(By.tagName("option"));
//                optionsListCount = optnList_Id.size();
//                System.out.println("Number of user directories are " + optionsListCount);
//
//            }
//
//        }
//
//        public int selectOptionFromOptnList;
//
//        public int selectOptionTag(int i) {
//            if (super.isPresent()) {
//                WebElement elementById = driver.findElement(By.id(super.locator));
//                List<WebElement> selectOptn_Id = elementById.findElements(By.tagName("option"));
//                selectOptionFromOptnList = selectOptn_Id.size();
//                System.out.println("Count is " + selectOptionFromOptnList);
//                selectOptn_Id.get(i).click();
//                return selectOptionFromOptnList;
//            }
//            return 0;
//
//        }
//
//        // End Of Infosys Code
//        public List<String> getOptionList() {
//            List<String> option = null;
//            if (super.isPresent()) {
//                option = new ArrayList<String>();
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                for (WebElement elem : select.getOptions()) {
//                    option.add(elem.getText());
//                }
//            }
//            return option;
//        }
//
//        public void selectAndFireEvent(String itemToSelect, String event) {
//            if (super.isPresent()) {
//                uidriver.select(super.locator, itemToSelect);
//                uidriver.fireEvent(super.locator, event);
//            }
//        }
//        
//        //Method added to get the value of the selected option from dropdown
//        public List<String> getSelectedOptionList() {
//            List<String> option = null;
//            if (super.isPresent()) {
//                option = new ArrayList<String>();
//                Select select = new Select(driver.findElement(By.id(super.locator)));
//                for (WebElement elem : select.getAllSelectedOptions()) {
//                    option.add(elem.getText());
//                }
//            }
//            return option;
//        }
//    }
//
//    public class ComboBox extends UIObject {
//
//        public ComboBox(String locator) {
//
//            super(locator);
//
//        }
//
//        public void select(String itemToSelect) {
//
//            if (super.isPresent()) {
//
//                uidriver.select(super.locator, itemToSelect);
//
//            }
//
//        }
//
//    }
//
//    // Added by Infosys
//    public class Image extends UIObject {
//
//        public Image(String locator) {
//            super(locator);
//        }
//
//        public boolean click() {
//            if (super.isPresentByXpath()) {
//                WebElement element = driver.findElement(By.xpath(locator));
//                element.click();
//                return true;
//            } else
//                return false;
//        }
//
//        public boolean clickById() {
//            if (super.isPresent()) {
//                WebElement element = driver.findElement(By.id(locator));
//                element.click();
//                return true;
//            } else
//                return false;
//        }
//    }
//
//    public void waitExplicit() {
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
//    }
//
//    public void pageSourceOpen(String locator) {
//        WebElement element = driver.findElement(By.xpath(locator));
//        element.sendKeys(Keys.CONTROL, "u");
//
//    }
//
//    public void pageSourceClose(String locator) {
//        WebElement element = driver.findElement(By.xpath(locator));
//        element.sendKeys(Keys.CONTROL, "w");
//    }
//
//    public String elementValue(String locator) {
//        WebElement element = driver.findElement(By.xpath(locator));
//        return element.getText();
//    }
//
//}
//// End Of file UI.java

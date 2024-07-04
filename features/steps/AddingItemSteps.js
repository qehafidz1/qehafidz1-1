import { Given, When, Then, Before, After } from "@cucumber/cucumber";
import assert from "assert";

import initDriver from "../../configs/driver.js"
import MainPage from "../../pages/MainPage.js"
import AddingItemPage from "../../pages/AddingAItemPage.js"

let driver;
let mainpage;
let addingItemPage;

Before({ timeout: 6000 * 10000 }, async () => {
    try {
      driver = await initDriver();
      mainpage = new MainPage(driver);
      addingItemPage = new AddingItemPage(driver);
    } catch (error) {
      console.error(error);
    }
  });

Given("I am on the Main Page", async () => {
    const main_Page = await mainpage.getTitle();
    assert.equal(main_Page, "Your Groceries");
})

When("I click the Plus Button", async () => {
    await mainpage.clickPlusButton();
})

Then("Then I am redirected to the Add a new item page", async()=>{
    const checkThatImOnTheAddingItemPage = await AddingItemPage.CheckThatImOnTheAddingItemPage();
    assert.equal(checkThatImOnTheAddingItemPage);
})

After(async () => {
    await driver.deleteSession();
});
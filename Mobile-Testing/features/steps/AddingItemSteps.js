import { Given, When, Then, Before, After } from "@cucumber/cucumber";
import assert from "assert";
import initDriver from "../../configs/driver.js";
import MainPage from "../../pages/MainPage.js";
import AddingPage from "../../pages/AddingPage.js";

let driver;
let mainpage;
let addingItemPage;


// Positive Cases

Before({ timeout: 60000 }, async () => {
    try {
        driver = await initDriver();
        mainpage = new MainPage(driver);
        addingItemPage = new AddingPage(driver);
    } catch (error) {
        console.error("Error during setup:", error);
    }
});

Given("I am on the Main Page", { timeout: 30000 }, async () => {
    const main_Page = await mainpage.CheckThatImOnTheMainPage();
    assert.equal(main_Page, "Your Groceries");
});

When("I click the Plus Button", { timeout: 30000 }, async () => {
    await mainpage.clickPlusButton();
});

Then("I am redirected to the Add a new item page", { timeout: 30000 }, async () => {
    const checkThatImOnTheAddingItemPage = await addingItemPage.CheckThatImOnTheAddingItemPage();
    assert.equal(checkThatImOnTheAddingItemPage, "Add a new item");
});

When("I click Name input bar and type my name", { timeout: 30000 }, async () => {
    const NameInput = 'Samguk';
    await addingItemPage.insertName(NameInput);
    await driver.hideKeyboard();
});

When("I click the quantity input bar and input the item quantity with valid input", { timeout: 30000 }, async () => {
    const QuantityInput = '1';
    await addingItemPage.insertQuantity(QuantityInput);
    await driver.hideKeyboard();
});

When("I click item categories button", { timeout: 30000 }, async () => {
    await addingItemPage.tapItemList();
});

When("I click the categories that i want", { timeout: 30000 }, async () => {
    await addingItemPage.tapItem();
});

When("I click Add Item Button",{ timeout: 30000 }, async () => {
  await addingItemPage.clickAddItem();
})

Then("I redirected to the Main Page",{ timeout: 30000 }, async () => {
  const main_Page = await mainpage.CheckThatImOnTheMainPage();
  assert.equal(main_Page, "Your Groceries");
})


// Negative Test Cases

// Empty Input

When("I click Name input bar and type my name with empty input", { timeout: 30000 }, async () => {
    const NameInput = '';
    await addingItemPage.insertName(NameInput);
    await driver.hideKeyboard();
})

Then("I get an error message which tell that my input is empty",{timeout: 30000 }, async () => {
    const blank_name_input_response = await mainpage.BlankNameInputErrorResponse();
    assert.equal(blank_name_input_response, "Must be between 1 and 50 characters.");
  })

Then("I remain on the Adding a New Item Page", { timeout: 30000 }, async () => {
    const checkThatImOnTheAddingItemPage = await addingItemPage.CheckThatImOnTheAddingItemPage();
    assert.equal(checkThatImOnTheAddingItemPage, "Add a new item");
});  



// Float Input

When("I click the quantity input bar and input the item quantity with float input", { timeout: 30000 }, async () => {
    const QuantityInput = '1.3';
    await addingItemPage.insertQuantity(QuantityInput);
    await driver.hideKeyboard();
});

// Back To Main Menu

When("I click the Back button", { timeout: 30000 }, async () => {
    await addingItemPage.ClickBackButton();
});

After(async () => {
    try {
        await driver.deleteSession();
    } catch (error) {
        console.error("Error during teardown:", error);
    }

});





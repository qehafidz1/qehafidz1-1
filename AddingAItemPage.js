import BasePage from "./basePage.js";

export default class AddingPage extends BasePage{
    constructor(driver) {
        super(driver);
    }

   async CheckThatImOnTheAddingItemPage() {
    const pageTitleComponent = await this.find('//android.view.View[@content-desc="Add a new item"]');

    const pageTitle = await pageTitleComponent.getAttribute('content-desc');
    return pageTitle;
   }

   async insertName(name) {
    const nameContentElement =
      '//android.widget.EditText[@text="Name"]';

    await this.click(nameContentElement);

    await this.type(nameContentElement, name);
    }

   async insertQuantity(quantity) {
    const quantityContentElement = '//android.widget.EditText[@text="1, Quantity"]';

    await this.click(quantityContentElement);

    await this.type(quantityContentElement, quantity);
   }

   async tapItemList() {
    await this.click ('//android.widget.Button[@content-desc="Vegetables"]');
   }

   async tapItem() {
    await this.click ('//android.view.View[@content-desc="Other"]');
   }

   async clickAddItem() {
    await this.click ('//android.widget.Button[@content-desc="Add Item"]');
   }
   
}

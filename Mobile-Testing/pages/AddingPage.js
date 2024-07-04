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
    await this.click ('//android.view.View[@content-desc="Dairy"]');
   }

   async clickAddItem() {
    await this.click ('//android.widget.Button[@content-desc="Add Item"]');
   }
   async BackButton(){
    await this.click('//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button');
   }

  //  async CheckThatInputDataIsCreatedOnTheTable(){
  //    CreatedDataComponent = await this.find('(//android.view.View[@content-desc="Samguk"])')
  //    CreatedData = await CreatedDataComponent.getAttribute('content-desc')
  //    return CreatedData

  //  }
   // Negative Test Function

   async BlankNameInputErrorResponse() {
    const blankNameInputErrorResponseComponent = await this.find('//android.view.View[@content-desc="Must be between 1 and 50 characters."]');
    const blankNameInputErrorResponse = await blankNameInputErrorResponseComponent.getAttribute('content-desc');
    return blankNameInputErrorResponse;
}

async ClickBackButton(){
  await this.click('//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button')
}



}

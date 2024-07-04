import BasePage from "./basePage.js";

export default class MainPage extends BasePage{
    constructor(driver) {
        super(driver);
    }

   async CheckThatImOnTheMainPage() {
    const mainPageComponent = await this.find('//android.view.View[@content-desc="Your Groceries"]');
    const mainpage  = await mainPageComponent.getAttribute('content-desc');
    return mainpage;
   }

   async clickPlusButton() {
    await this.click ('//android.widget.Button');
   }
  
   
}
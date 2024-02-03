package testScripts;
import java.util.Map;
//This test verifies if user is able to create Category

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.IConstantpath;

public class AddCategoryTest extends BaseClass {
	@Test
	public void addCategoryTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickcategoryLink();
		Thread.sleep(3000);

		soft.assertEquals(category.getPageHeader(), "Category");
		
		category.clickNewButton();
		Thread.sleep(3000);

		soft.assertEquals(addCategory.getPageHeader(),"Add New Category");
		
		Map<String,String>map = excel.readFromExcel("Add Category");
		addCategory.setName(map.get("Name"));
		addCategory.clickSave();
				soft.assertEquals(category.getSuccessMessage(), "Success!");
		category.deleteCourse(web,map.get("Name"));
		soft.assertEquals(category.getSuccessMessage(), "Success!");
		if(category.getSuccessMessage().equals("Success!"))
			excel.updatetestStatus("Add Category","Pass", IConstantpath.EXCEL_PATH);
		else
			excel.updatetestStatus("Add Category","Fail", IConstantpath.EXCEL_PATH);
		
		soft.assertAll();
	}

}

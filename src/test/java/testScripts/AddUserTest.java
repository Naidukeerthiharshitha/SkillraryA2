package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;

public class AddUserTest extends BaseClass {
	@Test
	public void addUserTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		
		home.clickUsersTab();
		soft.assertTrue(user.getPageHeader().contains("Users"));
		user.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addUser.getPageHeader(),"Add New User");
		
		Map<String,String> map = excel.readFromExcel("Add User");
		
		addUser.setEmail(map.get("Email"));
		addUser.setPassword(map.get("Password"));
		addUser.setFirstname(map.get("First Name"));
		addUser.setLastname(map.get("Last Name"));
		addUser.setAddress(map.get("Address"));
		addUser.setContactInfo(map.get("contact Info"));
		addUser.uploadPhoto(map.get("Photo"));
		
		addUser.clickSave();
		
		soft.assertEquals(user.getSuccessMessage(), "Success!");
		soft.assertAll();
	}

}

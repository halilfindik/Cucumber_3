package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

public class _06_ApachePOISteps {

    DialogContent dialogContent=new DialogContent();
    @When("User creates citizenship with ApachePOI")
    public void userCreatesCitizenshipWithApachePOI() {
        // Excel'den oku ve citizenship'i create et

        List<List<String>> citizenshipData=ExcelUtility.
                getExcelListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen", 2);

        for (List<String> row : citizenshipData) {
            dialogContent.findAndClick("addButton");
            dialogContent.findAndSend("nameInput", row.get(0));
            dialogContent.findAndSend("shortName", row.get(1));
            dialogContent.findAndClick("saveButton");
            dialogContent.findAndContainsText("successMessage","success");
        }
    }

    @Then("User deletes citizenship with ApachePOI")
    public void userDeletesCitizenshipWithApachePOI() {
        // kaydettiklerini yine excel'den okuyarak sil
        List<List<String>> citizenshipData=ExcelUtility.
                getExcelListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen", 1);

        for (List<String> row : citizenshipData) {
            //System.out.println("satir = " + row);
            //System.out.println("satir.get(0) = " + row.get(0));

            dialogContent.searchAndDelete(row.get(0));
            dialogContent.findAndContainsText("successMessage","success");
        }

    }
}

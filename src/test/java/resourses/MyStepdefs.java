package resourses;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("I have a file {string}")
    public void iHaveAFile(String arg0) {

    }

    @When("I upload file {string} to Dropbox")
    public void iUploadFileToDropbox(String arg0) {
    }

    @Then("I see file {string} successfully uploaded")
    public void iSeeFileSuccessfullyUploaded(String arg0) {
    }

    @Given("I have an uploaded file {string}")
    public void iHaveAnUploadedFile(String arg0) {
    }

    @When("I request metadata of file {string} by its id")
    public void iRequestMetadataOfFileByItsId(String arg0) {
    }

    @Then("I receive metadata for file {string}")
    public void iReceiveMetadataForFile(String arg0) {
    }

    @When("I ask for list of files and folders in {string}")
    public void iAskForListOfFilesAndFoldersIn(String arg0) {
    }

    @Then("I receive list of files and folders")
    public void iReceiveListOfFilesAndFolders() {
    }

    @When("I ask to delete file {string}")
    public void iAskToDeleteFile(String arg0) {
    }

    @Then("I see file {string} is successfully deleted")
    public void iSeeFileIsSuccessfullyDeleted(String arg0) {
    }
}

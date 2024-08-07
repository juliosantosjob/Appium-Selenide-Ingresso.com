package steps;

import actions.SearchMovieActions;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static java.lang.System.out;


public class SearchMovieSteps extends SearchMovieActions {
    private static SearchMovieActions srcMov = new SearchMovieActions();

    @When("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String button) {
        srcMov.clickBtnMovie(button);
        out.println("- The user accesses the \"" + button + "\" tab");
    }

    @When("click on the search magnifying glass")
    public void click_on_the_search_magnifying_glass() {
        srcMov.clickMagnifier();
        out.println("- Click on the search magnifying glass");
    }

    @When("fill in {string}")
    public void fill_in(String nameMovie) {
        srcMov.fillMovie(nameMovie);
        out.println("- Fill in \"" + nameMovie + "\"");
    }

    @When("click on the movie title")
    public void click_on_the_movie_title() {
        srcMov.clickMovieTitle();
        out.println("- Click on the movie title");
    }

    @Then("it displays the information of {string}")
    public void it_displays_the_information_of(String nameMovie) {
        srcMov.seeMovieTitle(nameMovie);
        out.println("- It displays the information of \"" + nameMovie + "\"");
    }
}
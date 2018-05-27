package movies.com.androidmovieapp;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import movies.com.androidmovieapp.activities.MovieDetailActivity;
import movies.com.androidmovieapp.activities.NowPlayingMoviesActivity;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;


@RunWith(AndroidJUnit4.class)
public class MovieDetailActivityEspressoTest {


    @Rule
    public ActivityTestRule<MovieDetailActivity> mActivityRule =
        new ActivityTestRule<>(MovieDetailActivity.class);

    @Test
    public void ensureTextChangesWork() {
//        // Type text and then press the button.
//        onView(withId(R.id.inputField))
//                .perform(typeText("HELLO"), closeSoftKeyboard());
//        onView(withId(R.id.changeText)).perform(click());
//
//        // Check that the text was changed.
//        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
    }

    @Test
    public void checkNavigationToMovieDetailPage() {
        onView(withId(R.id.my_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(3, click()),scrollTo());
        onView(withText("Error Fetching Movie Details")).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfErrorDialogDisplayed() {
        onView(withText("Error Fetching Movie Details")).check(matches(isDisplayed()));
    }
}
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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;


@RunWith(AndroidJUnit4.class)
public class NowPlayingMoviesActivityEspressoTest {



    @Rule
    public ActivityTestRule<NowPlayingMoviesActivity> mActivityRule =
        new ActivityTestRule<>(NowPlayingMoviesActivity.class);

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
        onData(anything()).inAdapterView(withId(R.id.gridView)).atPosition(0).
                onChildView(withId(R.id.ivThumbnail)).perform(click());
        onView(withId(R.id.movieImageView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkIfGridViewDisplayed() {
        onView(withId(R.id.gridView)).check(matches(isDisplayed()));
    }

    @Test
    public void checkMovieDetailActivityIsCalled() {
        onData(anything()).inAdapterView(withId(R.id.gridView)).atPosition(0).perform(click());
        intended(hasComponent(MovieDetailActivity.class.getName()));
    }


}
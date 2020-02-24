package com.abdallah.esseprsoteasting;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Abdallah on 24/02/2020.
 */
public class MainActivityTest {
    String email = "user@code95.info";
    String password = "123456";

    String errorPassword = "123";

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public void testCorrect() {
        Espresso.onView(withId(R.id.emailET)).perform(typeText(email));
        Espresso.onView(withId(R.id.passwordET)).perform(typeText(password));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.loginBTN)).perform(click());
        Espresso.onView(withId(R.id.statusTV)).check(matches(withText(R.string.correct)));
    }

    @Test
    public void testError() {
        Espresso.onView(withId(R.id.emailET)).perform(typeText(email));
        Espresso.onView(withId(R.id.passwordET)).perform(typeText(errorPassword));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.loginBTN)).perform(click());
        Espresso.onView(withId(R.id.statusTV)).check(matches(withText(R.string.error)));
    }



    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

}
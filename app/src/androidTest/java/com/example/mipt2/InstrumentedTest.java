package com.example.mipt2;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
//import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidJUnit4;
import static com.example.mipt2.calc.Utils.removeExcessiveSpacesFromString;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> activityScenarioRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testWhenTextStringIsEnteredToEtUserInput() {
        final String givenString = "Poetry   of logical   ideas  ";
        final String expectedResult = "Poetry of logical ideas";
        final String withoutExcessiveSpaces = removeExcessiveSpacesFromString(givenString);

        onView(withId(R.id.etUserInput)).perform(click(), replaceText(givenString));
        onView(withId(R.id.btnCalc)).perform(click());
        //pataisytas tekstas (pasalinus tarpus) atvaizduojamas etUserInput laukelyje vietoj pries tai buvusio teksto
        onView(withId(R.id.etUserInput)).perform(click(), replaceText(withoutExcessiveSpaces));
        onView(withId(R.id.etUserInput)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenEmptyStringIsEnteredToEtUserInput() {
        final String givenString = "";
        final String expectedResult = "";

        onView(withId(R.id.etUserInput)).perform(click(), replaceText(givenString));
        onView(withId(R.id.btnCalc)).perform(click());
        //kaip ir 34 eiluteje
        onView(withId(R.id.etUserInput)).perform(click(), replaceText(expectedResult));
        onView(withId(R.id.etUserInput)).check(matches(withText(expectedResult)));
    }


}
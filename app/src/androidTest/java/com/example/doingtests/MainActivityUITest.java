package com.example.doingtests;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // ui testas susijes su 3 praktiniu darbu

    @Test
    public void mainActivityTest() {

        onView(allOf(withId(R.id.btn1), withText("1"))).perform(click());
        onView(allOf(withId(R.id.btn2), withText("2"))).perform(click());
        onView(allOf(withId(R.id.btnMultiply), withText("*"))).perform(click());
        onView(allOf(withId(R.id.btn3), withText("3"))).perform(click());
        onView(allOf(withId(R.id.btnEquals), withText("="))).perform(click());

        onView(allOf(withId(R.id.btnAdd), withText("+"))).perform(click());
        onView(allOf(withId(R.id.btn9), withText("9"))).perform(click());
        onView(allOf(withId(R.id.btnEquals), withText("="))).perform(click());

        onView(allOf(withId(R.id.btnSubtract), withText("-"))).perform(click());
        onView(allOf(withId(R.id.btn5), withText("5"))).perform(click());
        onView(allOf(withId(R.id.btn0), withText("0"))).perform(click());
        onView(allOf(withId(R.id.btnEquals), withText("="))).perform(click());

        onView(allOf(withId(R.id.btnClear), withText("C"))).perform(click());
        onView(allOf(withId(R.id.btn9), withText("9"))).perform(click());
        onView(allOf(withId(R.id.btnSqrt), withText("√"))).perform(click());

        onView(allOf(withId(R.id.btnAdd), withText("+"))).perform(click());
        onView(allOf(withId(R.id.btn6), withText("6"))).perform(click());
        onView(allOf(withId(R.id.btnEquals), withText("="))).perform(click());

        onView(allOf(withId(R.id.btnDelete), withText("←"))).perform(click());
        onView(allOf(withId(R.id.btn5), withText("5"))).perform(click());
        onView(allOf(withId(R.id.btnEquals), withText("="))).perform(click());

        onView(allOf(withId(R.id.btnClear), withText("C"))).perform(click());
        onView(allOf(withId(R.id.btn9), withText("9"))).perform(click());
        onView(allOf(withId(R.id.btnDivide), withText("/"))).perform(click());
        onView(allOf(withId(R.id.btn3), withText("3"))).perform(click());
        onView(allOf(withId(R.id.btnEquals), withText("="))).perform(click());

        onView(allOf(withId(R.id.btnMultiply), withText("*"))).perform(click());
        onView(allOf(withId(R.id.btn2), withText("2"))).perform(click());
        onView(allOf(withId(R.id.btnEquals), withText("="))).perform(click());
    }


    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

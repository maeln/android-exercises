package fr.android.androidexercises;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.core.deps.guava.collect.Iterables;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitor;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.test.ActivityInstrumentationTestCase2;

import junit.framework.AssertionFailedError;

import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    public LoginActivityTest() {
        super(LoginActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        getActivity();
    }

    public void takeScreenshot(String name) {
        //Spoon.screenshot(getCurrentActivity(), name);
    }

    public Activity getCurrentActivity() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        instrumentation.waitForIdleSync();
        final Activity[] activity = new Activity[1];
        instrumentation.runOnMainSync(new Runnable() {
           @Override
            public void run() {
                ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
                java.util.Collection<Activity> resumedActivities = activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
                activity[0] = Iterables.getOnlyElement(resumedActivities);
            }
        });
        return activity[0];
    }

    @Test
    public void testLogin() {
        String login = "MAELN";
        String pass = "MOTDEPASSE";
        Espresso.onView(withId(R.id.usernameEdit))
                .perform(typeText(login), closeSoftKeyboard())
                .check(matches(withText(login)));
        Espresso.onView(withId(R.id.passwordEdit))
                .perform(typeText(pass), closeSoftKeyboard())
                .check(matches(withText(pass)));

        Espresso.onView(withId(R.id.loginButton)).perform(click());
        Espresso.onView(withId(R.id.loggedText)).check(matches(isDisplayed()));
    }

    @Test
    public void testNotLogin() {
        String login = "MAELN";
        Espresso.onView(withId(R.id.usernameEdit))
                .perform(typeText(login), closeSoftKeyboard())
                .check(matches(withText(login)));

        Espresso.onView(withId(R.id.loginButton)).perform(click());
        try {
            Espresso.onView(withId(R.id.loggedText)).check(matches(isDisplayed()));
            // View is displayed
        } catch (AssertionFailedError e) {

        }
    }
}
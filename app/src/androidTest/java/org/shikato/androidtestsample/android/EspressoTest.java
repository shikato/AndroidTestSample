package org.shikato.androidtestsample.android;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shikato.androidtestsample.R;
import org.shikato.androidtestsample.TopActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EspressoTest extends ActivityInstrumentationTestCase2<TopActivity> {

    private Activity mActivity;

    public EspressoTest() {
        super(TopActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    @Test
    public void testAddition() {
        // 数字入力
        onView(ViewMatchers.withId(R.id.num1)).perform(typeText("2"));
        onView(withId(R.id.num2)).perform(typeText("20"));

        // 足すボタンクリック
        onView(withId(R.id.equal_button)).perform(click());

        // 計算結果確認
        onView(withId(R.id.result)).check(matches(withText("22")));
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}



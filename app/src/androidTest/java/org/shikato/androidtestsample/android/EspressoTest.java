package org.shikato.androidtestsample.android;

import android.app.Activity;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
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
public class EspressoTest {

    private Activity mActivity;

    @Rule
    public ActivityTestRule<TopActivity> mActivityRule = new ActivityTestRule<>(
            TopActivity.class);


    @Before
    public void setUp() {
        // Activityの取得
        mActivity = mActivityRule.getActivity();
    }

    // @Testが使えるので日本語でテストメソッドが書けるようになった
    @Test
    public void 足し算機能の基本的な挙動() {
        // 数字入力
        onView(ViewMatchers.withId(R.id.num1)).perform(typeText("2"));
        onView(withId(R.id.num2)).perform(typeText("20"));

        // 足すボタンクリック
        onView(withId(R.id.equal_button)).perform(click());

        // 計算結果確認
        onView(withId(R.id.result)).check(matches(withText("22")));
    }
}


package org.shikato.androidtestsample.android;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shikato.androidtestsample.ResultActivity;
import org.shikato.androidtestsample.TopActivity;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RobotiumTest extends ActivityInstrumentationTestCase2<TopActivity> {

    private Activity mActivity;

    public RobotiumTest() {
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
        Solo solo = new Solo(getInstrumentation(), mActivity);

        // 1つめのEditTextに1と入力
        solo.enterText(0, "3");
        // ID指定も可能
        // solo.enterText((EditText)mActivity.findViewById(R.id.num1), "3");

        // 2つめのEditTextに30と入力
        solo.enterText(1, "30");

        // 足すと書かれたボタンを押す
        solo.clickOnButton("=");

        // ResultActivity の起動を確認
        solo.assertCurrentActivity("ResultActivity now.", ResultActivity.class);

        // 計算結果である33と書かれたテキストを確認
        assertThat(solo.searchText("33"), is(true));
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}



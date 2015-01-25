package org.shikato.androidtestsample.android;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shikato.androidtestsample.R;
import org.shikato.androidtestsample.ResultActivity;
import org.shikato.androidtestsample.TopActivity;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityInstrumentationTestCaseTest extends ActivityInstrumentationTestCase2<TopActivity> {

    private Activity mActivity;

    public ActivityInstrumentationTestCaseTest() {
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
        // 数字入力(num1)
        EditText num1 = (EditText)mActivity.findViewById(R.id.num1);
        TouchUtils.clickView(this, num1);
        sendKeys(KeyEvent.KEYCODE_1);

        // 数字入力(num2)
        EditText num2 = (EditText)mActivity.findViewById(R.id.num2);
        TouchUtils.clickView(this, num2);
        sendKeys(KeyEvent.KEYCODE_1);
        sendKeys(KeyEvent.KEYCODE_0);

        // ResultActivityの起動を監視
        Instrumentation.ActivityMonitor monitor =
                new Instrumentation.ActivityMonitor(ResultActivity.class.getCanonicalName(), null, false);
        getInstrumentation().addMonitor(monitor);

        // =ボタンクリック
        Button addBtn = (Button)mActivity.findViewById(R.id.equal_button);
        TouchUtils.clickView(this, addBtn);

        // 起動待ち
        Activity resultActivity = getInstrumentation().waitForMonitorWithTimeout(monitor, 3000L);

        // ResultActivityが起動したか確認
        assertThat(monitor.getHits(), is(1));
        assertThat(resultActivity, notNullValue());

        // 計算結果確認
        TextView result = (TextView)resultActivity.findViewById(R.id.result);
        assertThat(result.getText().toString(), is("11"));
    }


    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}



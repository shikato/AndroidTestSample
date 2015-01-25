package org.shikato.androidtestsample.android;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shikato.androidtestsample.Calc;
import org.shikato.androidtestsample.R;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class JUnit4Test {

    private Context mContext;

    @Before
    public void setUp() throws Exception {
        // Contextを取得
        mContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void add() {
        assertThat(Calc.add(3, 5), is(8));
    }

    @Test
    public void context() {
        // Contextを使ったテスト
        assertThat(mContext.getString(R.string.app_name), is("AndroidTestSample"));
    }
}



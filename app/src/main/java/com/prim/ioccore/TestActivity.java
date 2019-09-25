package com.prim.ioccore;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.prim.lib_ioc.ContentView;
import com.prim.lib_ioc.OnClick;
import com.prim.lib_ioc.ViewInject;

import org.w3c.dom.Text;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2019-09-25 - 10:23
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
@ContentView(value = R.layout.activity_main)
public class TestActivity extends BaseActivity {

    @ViewInject(value = R.id.text1)
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView.setText("Hello World 123");
    }

    @OnClick(value = {R.id.text1})
    public void test() {

    }
}

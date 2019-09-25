package com.prim.ioccore;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.prim.lib_ioc.ContentView;
import com.prim.lib_ioc.OnClick;
import com.prim.lib_ioc.OnLongClick;
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
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

    @OnLongClick(value = {R.id.text1})
    public boolean test(View view) {
        Toast.makeText(this, "注入长按事件完成", Toast.LENGTH_LONG).show();
        return false;
    }
}

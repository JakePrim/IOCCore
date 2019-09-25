package com.prim.ioccore;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prim.lib_ioc.InjectUtils;

/**
 * @author prim
 * @version 1.0.0
 * @desc
 * @time 2019-09-20 - 16:32
 * @contact https://jakeprim.cn
 * @name IOCCore
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.inject(this);
    }
}

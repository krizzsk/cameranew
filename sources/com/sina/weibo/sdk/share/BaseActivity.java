package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class BaseActivity extends Activity {
    private boolean l() {
        Exception e2;
        boolean z;
        Method method;
        try {
            TypedArray obtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            z = ((Boolean) method.invoke(null, obtainStyledAttributes)).booleanValue();
        } catch (Exception e3) {
            e2 = e3;
            z = false;
        }
        try {
            method.setAccessible(false);
        } catch (Exception e4) {
            e2 = e4;
            e2.printStackTrace();
            return z;
        }
        return z;
    }

    private boolean m() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26 && l()) {
            m();
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i2) {
        if (Build.VERSION.SDK_INT == 26 && l()) {
            return;
        }
        super.setRequestedOrientation(i2);
    }
}

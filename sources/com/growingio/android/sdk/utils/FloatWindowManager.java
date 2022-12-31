package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.growingio.android.sdk.collection.CoreInitialize;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
/* loaded from: classes2.dex */
public class FloatWindowManager {
    private static volatile FloatWindowManager floatWindowManager;
    private final String TAG = "GIO.FloatWindowManager";
    private Context mContext;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams params;

    private FloatWindowManager(Context context) {
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
    }

    public static FloatWindowManager getInstance() {
        init(CoreInitialize.coreAppState().getGlobalContext());
        return floatWindowManager;
    }

    private int getParamsType() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            if (i2 >= 26) {
                return 2038;
            }
            if (i2 > 24 || isMIUIV8()) {
                return AdError.CACHE_ERROR_CODE;
            }
            return 2005;
        }
        return AdError.CACHE_ERROR_CODE;
    }

    private static void init(Context context) {
        if (floatWindowManager == null) {
            synchronized (FloatWindowManager.class) {
                if (floatWindowManager == null) {
                    floatWindowManager = new FloatWindowManager(context);
                }
            }
        }
    }

    @TargetApi(19)
    private boolean isMIUIV8() {
        FileInputStream fileInputStream;
        String property;
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains("xiaomi")) {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                Properties properties = new Properties();
                properties.load(fileInputStream);
                property = properties.getProperty("ro.miui.ui.version.name");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (TextUtils.isEmpty(property) || !property.equalsIgnoreCase("V8")) {
                fileInputStream.close();
                return false;
            }
            LogUtil.d("GIO.FloatWindowManager", "is XIAOMI Mobile");
            fileInputStream.close();
            return true;
        }
        return false;
    }

    public void addView(View view, WindowManager.LayoutParams layoutParams) {
        layoutParams.type = getParamsType();
        if (view.getParent() == null) {
            try {
                this.mWindowManager.addView(view, layoutParams);
            } catch (Exception e2) {
                Log.e("GIO.FloatWindowManager", "WindowManager addView Failed:" + e2.toString());
            }
        }
    }

    Display getDefaultDisplay() {
        return this.mWindowManager.getDefaultDisplay();
    }

    public void removeView(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        this.mWindowManager.removeView(view);
    }

    public void updateViewLayout(View view, WindowManager.LayoutParams layoutParams) {
        layoutParams.type = getParamsType();
        try {
            this.mWindowManager.updateViewLayout(view, layoutParams);
        } catch (Exception unused) {
            Log.e("GIO.FloatWindowManager", "WindowManager updateViewLayout Failed");
        }
    }
}

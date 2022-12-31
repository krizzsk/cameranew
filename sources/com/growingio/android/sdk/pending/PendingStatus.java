package com.growingio.android.sdk.pending;

import android.os.Build;
import com.facebook.ads.AdError;
import com.growingio.android.sdk.collection.CoreInitialize;
/* loaded from: classes2.dex */
public class PendingStatus {
    public static final String APP_CIRCLE = "app";
    public static final String DATA_CHECK = "data-check";
    public static int FLOAT_VIEW_TYPE = -1;
    public static final String HEAT_MAP_CIRCLE = "heatmap";
    private static final String MOBILE_DEBUGGER = "debugger";
    private static final int MODEL_APP_CIRCLE = 1;
    private static final int MODEL_APP_CIRCLE_SHOW_CIRCLED = 2;
    private static final int MODEL_APP_CIRCLE_SHOW_HEATMAP = 3;
    private static final int MODEL_DATA_CHECK = 11;
    private static final int MODEL_DEBUGGER = 10;
    private static final int MODEL_NORMAL = 0;
    private static final int MODEL_WEB_CIRCLE = 20;
    private static final String TAG = "GIO.PendingStatus";
    private static final String WEB_CIRCLE = "web";
    private static int mCacheSpecialModel = 0;
    public static boolean mCanShowCircleTag = true;
    private static boolean mIsEnable = false;
    public static boolean mIsHeatMapOn = false;
    public static String mLoginToken;

    public static void disable() {
        mCacheSpecialModel = 0;
        CoreInitialize.growingIOIPC().setSpecialModel(0);
    }

    private static void initFloatType() {
        FLOAT_VIEW_TYPE = 2005;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            FLOAT_VIEW_TYPE = AdError.CACHE_ERROR_CODE;
        } else if (i2 >= 26) {
            FLOAT_VIEW_TYPE = 2038;
        } else if (i2 > 24) {
            FLOAT_VIEW_TYPE = AdError.CACHE_ERROR_CODE;
        } else {
            FLOAT_VIEW_TYPE = 2005;
        }
    }

    public static boolean isAppCircleEnabled() {
        int i2 = mCacheSpecialModel;
        return i2 > 0 && i2 < 10;
    }

    public static boolean isDataCheckEnable() {
        return mCacheSpecialModel == 11;
    }

    public static boolean isDebuggerEnabled() {
        return mCacheSpecialModel == 10 || isDataCheckEnable();
    }

    public static boolean isEnable() {
        return mIsEnable;
    }

    public static boolean isProjection() {
        return isWebCircleEnabled() || isDebuggerEnabled() || isDataCheckEnable();
    }

    public static boolean isValidMultiProcessState() {
        int specialModel;
        if (mCacheSpecialModel == 0 && (specialModel = CoreInitialize.growingIOIPC().getSpecialModel()) != mCacheSpecialModel) {
            mCacheSpecialModel = specialModel;
            return true;
        }
        return false;
    }

    public static boolean isWebCircleEnabled() {
        return mCacheSpecialModel == 20;
    }

    public static void setSpecialModelFromType(String str) {
        initFloatType();
        mIsEnable = true;
        if ("app".equals(str)) {
            mCacheSpecialModel = 1;
        } else if (MOBILE_DEBUGGER.equals(str)) {
            mCacheSpecialModel = 10;
        } else if (WEB_CIRCLE.equals(str)) {
            mCacheSpecialModel = 20;
        } else if (DATA_CHECK.equals(str)) {
            mCacheSpecialModel = 11;
        } else {
            mIsEnable = false;
        }
        CoreInitialize.growingIOIPC().setSpecialModel(mCacheSpecialModel);
    }

    public static void syncModelOnResume() {
        int specialModel = CoreInitialize.growingIOIPC().getSpecialModel();
        mCacheSpecialModel = specialModel;
        mIsEnable = specialModel != 0;
    }
}

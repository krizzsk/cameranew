package com.growingio.android.sdk.utils;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.growingio.android.sdk.utils.rom.RomChecker;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class ContextUtil {
    private static final String TAG = "GIO.ContextUtil";

    private ContextUtil() {
    }

    private static boolean eMUIAddWhiteList(Context context) {
        Object findFieldRecur;
        try {
            Object findField = ReflectUtil.findField(Application.class, (Application) context.getApplicationContext(), "mLoadedApk");
            if (findField == null || (findFieldRecur = ReflectUtil.findFieldRecur(findField, "mReceiverResource")) == null) {
                return false;
            }
            List list = (List) ReflectUtil.findFieldRecur(findFieldRecur, "mWhiteList");
            if (list == null) {
                Map map = (Map) ReflectUtil.findFieldRecur(findFieldRecur, "mWhiteListMap");
                if (map == null) {
                    return false;
                }
                Object obj = map.get("0");
                if (!(obj instanceof List)) {
                    return false;
                }
                list = (List) obj;
            }
            String packageName = context.getPackageName();
            if (list.contains(packageName)) {
                return false;
            }
            list.add(packageName);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void registerReceiver(@NonNull Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        registerReceiver(context, broadcastReceiver, intentFilter, true);
    }

    private static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        try {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable unused) {
            if (z && RomChecker.isHuaweiRom()) {
                if (eMUIAddWhiteList(context)) {
                    LogUtil.d(TAG, "华为: add to WhiteList Success");
                    registerReceiver(context, broadcastReceiver, intentFilter, false);
                    return;
                }
                LogUtil.e(TAG, "华为: add to WhiteList Failed");
            }
        }
    }
}

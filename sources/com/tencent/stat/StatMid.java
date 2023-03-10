package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
/* loaded from: classes3.dex */
public class StatMid {
    private static StatLogger a = com.tencent.stat.common.k.b();
    private static DeviceInfo b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized DeviceInfo a(Context context) {
        DeviceInfo deviceInfo;
        synchronized (StatMid.class) {
            try {
                a a2 = a.a(context);
                DeviceInfo a3 = a(a2.d(DeviceInfo.TAG_FLAG, null));
                StatLogger statLogger = a;
                statLogger.d("get device info from internal storage:" + a3);
                DeviceInfo a4 = a(a2.f(DeviceInfo.TAG_FLAG, null));
                StatLogger statLogger2 = a;
                statLogger2.d("get device info from setting.system:" + a4);
                DeviceInfo a5 = a(a2.b(DeviceInfo.TAG_FLAG, null));
                StatLogger statLogger3 = a;
                statLogger3.d("get device info from SharedPreference:" + a5);
                DeviceInfo a6 = a(a5, a4, a3);
                b = a6;
                if (a6 == null) {
                    b = new DeviceInfo();
                }
                DeviceInfo b2 = n.a(context).b(context);
                if (b2 != null) {
                    b.d(b2.getImei());
                    b.e(b2.getMac());
                    b.b(b2.getUserType());
                }
                deviceInfo = b;
            }
        }
        return deviceInfo;
    }

    static DeviceInfo a(DeviceInfo deviceInfo, DeviceInfo deviceInfo2) {
        if (deviceInfo != null && deviceInfo2 != null) {
            return deviceInfo.a(deviceInfo2) >= 0 ? deviceInfo : deviceInfo2;
        } else if (deviceInfo != null) {
            return deviceInfo;
        } else {
            if (deviceInfo2 != null) {
                return deviceInfo2;
            }
            return null;
        }
    }

    static DeviceInfo a(DeviceInfo deviceInfo, DeviceInfo deviceInfo2, DeviceInfo deviceInfo3) {
        return a(a(deviceInfo, deviceInfo2), a(deviceInfo2, deviceInfo3));
    }

    private static DeviceInfo a(String str) {
        if (str != null) {
            return DeviceInfo.a(com.tencent.stat.common.k.d(str));
        }
        return null;
    }

    public static DeviceInfo getDeviceInfo(Context context) {
        if (context == null) {
            a.error("Context for StatConfig.getDeviceInfo is null.");
            return null;
        }
        if (b == null) {
            a(context);
        }
        return b;
    }

    public static String getMid(Context context) {
        if (b == null) {
            getDeviceInfo(context);
        }
        return b.getMid();
    }

    public static void updateDeviceInfo(Context context, String str) {
        try {
            getDeviceInfo(context);
            b.c(str);
            DeviceInfo deviceInfo = b;
            deviceInfo.a(deviceInfo.a() + 1);
            b.a(System.currentTimeMillis());
            String jSONObject = b.c().toString();
            StatLogger statLogger = a;
            statLogger.d("save DeviceInfo:" + jSONObject);
            String replace = com.tencent.stat.common.k.c(jSONObject).replace("\n", "");
            a a2 = a.a(context);
            a2.c(DeviceInfo.TAG_FLAG, replace);
            a2.e(DeviceInfo.TAG_FLAG, replace);
            a2.a(DeviceInfo.TAG_FLAG, replace);
        } catch (Throwable th) {
            a.e(th);
        }
    }
}

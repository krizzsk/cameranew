package com.bytedance.sdk.openadsdk.utils;

import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
/* compiled from: SimUtils.java */
/* loaded from: classes.dex */
public class w {
    private static boolean a = false;
    private static String b = null;
    private static String c = null;

    /* renamed from: d  reason: collision with root package name */
    private static String f2112d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f2113e = true;

    public static String a() {
        if (!a) {
            d();
        }
        return b;
    }

    public static String b() {
        try {
            if (!a) {
                d();
            }
            Configuration configuration = com.bytedance.sdk.openadsdk.core.o.a().getResources().getConfiguration();
            int i2 = configuration.mcc;
            String valueOf = i2 != 0 ? String.valueOf(i2) : c;
            o.e("MCC", "config=" + configuration.mcc + ",sMCC=" + c);
            if (f2113e) {
                return valueOf;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getMCC");
            sb.append(f2113e ? "有SIM卡" : "无SIM卡,MCC返回null");
            o.e("MCC", sb.toString());
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String c() {
        if (!a) {
            d();
        }
        return f2112d;
    }

    private static void d() {
        String str;
        String str2;
        String str3;
        if (com.bytedance.sdk.openadsdk.core.o.a() == null || a) {
            return;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("phone");
            int simState = telephonyManager.getSimState();
            if (simState == 0) {
                f2113e = false;
            } else if (simState == 1) {
                f2113e = false;
            }
            o.e("MCC", f2113e ? "有SIM卡" : "无SIM卡");
            String str4 = null;
            try {
                str = telephonyManager.getSimOperatorName();
            } catch (Throwable unused) {
                str = null;
            }
            try {
                str2 = telephonyManager.getNetworkOperator();
            } catch (Throwable unused2) {
                str2 = null;
            }
            if (str2 == null || str2.length() < 5) {
                try {
                    str2 = telephonyManager.getSimOperator();
                } catch (Throwable unused3) {
                }
            }
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = null;
            } else {
                str4 = str2.substring(0, 3);
                str3 = str2.substring(3);
            }
            if (!TextUtils.isEmpty(str)) {
                b = str;
            }
            if (!TextUtils.isEmpty(str4)) {
                c = str4;
            }
            if (!TextUtils.isEmpty(str3)) {
                f2112d = str3;
            }
        } catch (Throwable unused4) {
        }
        a = true;
    }
}

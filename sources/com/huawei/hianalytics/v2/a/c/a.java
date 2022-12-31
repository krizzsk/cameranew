package com.huawei.hianalytics.v2.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hianalytics.util.k;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* loaded from: classes2.dex */
public abstract class a {
    public static Long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.valueOf(new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(str).getTime());
        } catch (ParseException unused) {
            com.huawei.hianalytics.b.b.c("V1Common", "timestampAdapter: convertBisdkTime failed to parse time");
            return -1L;
        }
    }

    public static boolean a(Context context) {
        return k.a(k.a(context, "global_v2"), "v1cacheHandleFlag", false);
    }

    public static void b(Context context) {
        SharedPreferences.Editor edit = k.a(context, "global_v2").edit();
        edit.putBoolean("v1cacheHandleFlag", true);
        edit.commit();
    }
}

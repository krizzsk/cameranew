package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.c.a;
import java.util.List;
/* loaded from: classes3.dex */
public final class a {
    private static boolean a = false;
    private static AuthInfo b;

    public static void a(Context context, AuthInfo authInfo) {
        if (a) {
            return;
        }
        if (authInfo != null) {
            b = authInfo;
            com.sina.weibo.sdk.a.a.b().b(context, authInfo.getAppKey());
            a = true;
            return;
        }
        throw new RuntimeException("authInfo must not be null.");
    }

    public static boolean b(Context context) {
        a.C0256a c;
        return a(context) && (c = com.sina.weibo.sdk.c.a.c(context)) != null && c.am >= 10772;
    }

    public static boolean a(Context context) {
        List<ResolveInfo> queryIntentServices;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        return (context == null || (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) == null || queryIntentServices.isEmpty()) ? false : true;
    }

    public static AuthInfo a() {
        if (a) {
            return b;
        }
        throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
}

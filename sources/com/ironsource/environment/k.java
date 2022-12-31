package com.ironsource.environment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
/* compiled from: UrlHandler.java */
/* loaded from: classes2.dex */
public class k {
    public static void a(Context context, String str) throws Exception {
        b(context, str, null);
    }

    public static void b(Context context, String str, String str2) throws Exception {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (!TextUtils.isEmpty(str2)) {
                intent.setPackage(str2);
            }
            context.startActivity(intent);
            return;
        }
        throw new Exception("url is null");
    }
}

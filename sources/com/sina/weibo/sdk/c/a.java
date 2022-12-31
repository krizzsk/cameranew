package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.sina.weibo.sdk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0256a {
        public int am;
        public String packageName = "com.sina.weibo";
        public String al = "com.sina.weibo.SSOActivity";
    }

    public static boolean a(Context context, Intent intent) {
        PackageManager packageManager;
        ResolveInfo resolveActivity;
        if (context == null || (packageManager = context.getPackageManager()) == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            Signature[] signatureArr = packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures;
            if (signatureArr == null) {
                return false;
            }
            for (Signature signature : signatureArr) {
                if ("18da2bf10352443a00a5e046d9fca6bd".equals(d.a(signature.toByteArray()))) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static C0256a c(Context context) {
        List<ResolveInfo> queryIntentServices;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        C0256a c0256a = null;
        if (context != null && (queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0)) != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && serviceInfo.applicationInfo != null && !TextUtils.isEmpty(serviceInfo.packageName)) {
                    String str = resolveInfo.serviceInfo.packageName;
                    C0256a d2 = d(context, str);
                    if (d2 != null) {
                        c0256a = d2;
                    }
                    if ("com.sina.weibo".equals(str) || "com.sina.weibog3".equals(str)) {
                        break;
                    }
                }
            }
        }
        return c0256a;
    }

    private static C0256a d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream open = context.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = open.read(bArr, 0, 4096);
                if (read != -1) {
                    sb.append(new String(bArr, 0, read));
                } else {
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    C0256a c0256a = new C0256a();
                    c0256a.am = jSONObject.optInt("support_api", -1);
                    c0256a.al = jSONObject.optString("authActivityName", null);
                    c0256a.packageName = str;
                    return c0256a;
                }
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}

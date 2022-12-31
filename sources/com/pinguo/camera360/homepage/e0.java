package com.pinguo.camera360.homepage;

import android.content.Context;
import android.content.pm.Signature;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.security.MessageDigest;
import java.util.ArrayList;
/* compiled from: AppSigningUtils.java */
/* loaded from: classes3.dex */
public class e0 {
    public static String a(Context context) {
        ArrayList<String> c = c(context, "SHA256");
        return (c == null || c.size() == 0) ? "" : c.get(0);
    }

    public static String b(Context context) {
        ArrayList<String> c = c(context, "SHA1");
        return (c == null || c.size() == 0) ? "" : c.get(0);
    }

    private static ArrayList<String> c(Context context, String str) {
        String packageName;
        Signature[] e2;
        if (context == null || str == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            e2 = e(context, packageName);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (e2 == null) {
            return null;
        }
        for (Signature signature : e2) {
            String str2 = "error!";
            if ("SHA1".equals(str)) {
                str2 = d(signature, "SHA1");
            } else if ("SHA256".equals(str)) {
                str2 = d(signature, "SHA256");
            }
            arrayList.add(str2);
        }
        return arrayList;
    }

    private static String d(Signature signature, String str) {
        try {
            byte[] digest = MessageDigest.getInstance(str).digest(signature.toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & Draft_75.END_OF_FRAME) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "error!";
        }
    }

    private static Signature[] e(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

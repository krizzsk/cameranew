package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: AppSigning.java */
/* loaded from: classes.dex */
public class c {
    private static HashMap<String, ArrayList<String>> a = new HashMap<>();

    public static ArrayList<String> a(Context context, String str) {
        Signature[] b;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (a.get(str) != null) {
                return a.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : b(context, packageName)) {
                    String str2 = "error!";
                    if (Constants.MD5.equals(str)) {
                        str2 = a(signature, Constants.MD5);
                    } else if ("SHA1".equals(str)) {
                        str2 = a(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = a(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception e2) {
                o.b(e2.toString());
            }
            a.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e2) {
            o.b(e2.toString());
            return null;
        }
    }

    public static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> a2 = a(context, "SHA1");
        if (a2 != null && a2.size() != 0) {
            for (int i2 = 0; i2 < a2.size(); i2++) {
                sb.append(a2.get(i2));
                if (i2 < a2.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & Draft_75.END_OF_FRAME) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1).toString();
            }
            return "error!";
        } catch (Exception e2) {
            o.b(e2.toString());
            return "error!";
        }
    }
}

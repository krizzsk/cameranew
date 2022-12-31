package com.ironsource.sdk.controller;

import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.security.MessageDigest;
import java.util.UUID;
/* compiled from: SecureMessagingService.java */
/* loaded from: classes2.dex */
final class o {
    private String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str) {
        this.a = str;
    }

    private String a(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & Draft_75.END_OF_FRAME);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        return UUID.randomUUID().toString();
    }

    private String d(String str) {
        try {
            return com.ironsource.sdk.utils.e.j(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return e(str);
        }
    }

    private String e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(String str, String str2, String str3) {
        try {
            return str3.equalsIgnoreCase(d(str + str2 + this.a));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}

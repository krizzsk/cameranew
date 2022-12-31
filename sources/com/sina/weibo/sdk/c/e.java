package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.weibo.ssosdk.WeiboSsoSdk;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes3.dex */
public final class e {
    private static char[] ap = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] aq = new byte[256];

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            aq[i2] = -1;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            aq[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            aq[i4] = (byte) ((i4 + 26) - 97);
        }
        for (int i5 = 48; i5 <= 57; i5++) {
            aq[i5] = (byte) ((i5 + 52) - 48);
        }
        byte[] bArr = aq;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static int a(int i2, Context context) {
        return (int) ((i2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static byte[] b(byte[] bArr) {
        boolean z;
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = (bArr[i2] & Draft_75.END_OF_FRAME) << 8;
            int i5 = i2 + 1;
            boolean z2 = true;
            if (i5 < bArr.length) {
                i4 |= bArr[i5] & Draft_75.END_OF_FRAME;
                z = true;
            } else {
                z = false;
            }
            int i6 = i4 << 8;
            int i7 = i2 + 2;
            if (i7 < bArr.length) {
                i6 |= bArr[i7] & Draft_75.END_OF_FRAME;
            } else {
                z2 = false;
            }
            int i8 = i3 + 3;
            char[] cArr = ap;
            int i9 = 64;
            bArr2[i8] = (byte) cArr[z2 ? i6 & 63 : 64];
            int i10 = i6 >> 6;
            int i11 = i3 + 2;
            if (z) {
                i9 = i10 & 63;
            }
            bArr2[i11] = (byte) cArr[i9];
            int i12 = i10 >> 6;
            bArr2[i3 + 1] = (byte) cArr[i12 & 63];
            bArr2[i3 + 0] = (byte) cArr[(i12 >> 6) & 63];
            i2 += 3;
            i3 += 4;
        }
        return bArr2;
    }

    public static String e(Context context, String str) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            return d.a(signatureArr[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String f(Context context, String str) {
        String c;
        com.sina.weibo.sdk.a.a b = com.sina.weibo.sdk.a.a.b();
        if (!TextUtils.isEmpty(b.c)) {
            c = b.c;
        } else {
            c = b.c(context, str);
        }
        if (TextUtils.isEmpty(c)) {
            final com.sina.weibo.sdk.a.a b2 = com.sina.weibo.sdk.a.a.b();
            com.sina.weibo.sdk.a.a.a(context, str);
            new Thread(new Runnable() { // from class: com.sina.weibo.sdk.a.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b2.c = WeiboSsoSdk.getInstance().l().a();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }).start();
            return b2.c;
        }
        return c;
    }

    public static Bundle g(String str) {
        try {
            return i(new URL(str).getQuery());
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Bundle h(String str) {
        try {
            return i(new URI(str).getQuery());
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static Bundle i(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    if (split.length == 2) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                    } else if (split.length == 1) {
                        bundle.putString(URLDecoder.decode(split[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String r() {
        return Build.MANUFACTURER + PGTransHeader.CONNECTOR + Build.MODEL + "_" + Build.VERSION.RELEASE + "_weibosdk_0041005000_android";
    }
}

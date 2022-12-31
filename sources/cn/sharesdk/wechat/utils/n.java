package cn.sharesdk.wechat.utils;

import android.content.ContentResolver;
import android.net.Uri;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: WechatTools.java */
/* loaded from: classes.dex */
public class n {
    private static volatile n a;

    public static n a() {
        if (a == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new n();
                }
            }
        }
        return a;
    }

    public int a(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            if (MobSDK.getContext() != null && str.startsWith(FirebaseAnalytics.Param.CONTENT)) {
                try {
                    return a(MobSDK.getContext().getContentResolver(), Uri.parse(str));
                } catch (Exception unused) {
                }
            }
            return 0;
        }
        return (int) file.length();
    }

    private static int a(ContentResolver contentResolver, Uri uri) {
        SSDKLog.b().d("MicroMsg.SDK.Util", "getFileSize with content url");
        if (contentResolver != null && uri != null) {
            InputStream inputStream = null;
            try {
                try {
                    InputStream openInputStream = contentResolver.openInputStream(uri);
                    if (openInputStream == null) {
                        if (openInputStream != null) {
                            try {
                                openInputStream.close();
                            } catch (IOException e2) {
                                NLog b = SSDKLog.b();
                                b.d(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e2);
                            }
                        }
                        return 0;
                    }
                    int available = openInputStream.available();
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e3) {
                            NLog b2 = SSDKLog.b();
                            b2.d(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e3);
                        }
                    }
                    return available;
                } catch (Exception e4) {
                    NLog b3 = SSDKLog.b();
                    b3.d("MicroMsg.SDK.Util", "getFileSize fail, " + e4.getMessage());
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            NLog b4 = SSDKLog.b();
                            b4.d(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e5);
                        }
                    }
                    return 0;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        NLog b5 = SSDKLog.b();
                        b5.d(OnekeyShare.SHARESDK_TAG, "WechatTools exception" + e6);
                    }
                }
                throw th;
            }
        }
        SSDKLog.b().d("MicroMsg.SDK.Util", "getFileSize fail, resolver or uri is null");
        return 0;
    }
}

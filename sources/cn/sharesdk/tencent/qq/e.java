package cn.sharesdk.tencent.qq;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import java.io.File;
import java.util.HashMap;
/* compiled from: ShareActivity.java */
/* loaded from: classes.dex */
public class e extends FakeActivity {
    private Platform a;
    private String b;
    private PlatformActionListener c;

    /* renamed from: d  reason: collision with root package name */
    private String f267d;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, int i3) {
        String c = c(str, str2, str3, str4, str5, str6, str7, str8, i2, str9, str10, str11, i3);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(c));
        NLog b = SSDKLog.b();
        b.d(OnekeyShare.SHARESDK_TAG, " QQ ShareActivity advancedShare scheme: " + c);
        try {
            int[] a = a();
            ReceiveActivity.setUriScheme(this.b);
            ReceiveActivity.setPlatformActionListener(this.c);
            if (a.length <= 1 || (a[0] < 4 && a[1] < 6)) {
                intent.putExtra(Constants.KEY_REQUEST_CODE, 0);
            }
            intent.putExtra("pkg_name", this.activity.getPackageName());
            this.activity.startActivityForResult(intent, 256);
            if (Build.VERSION.SDK_INT >= 28) {
                SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " QQ ShareActivity Build.VERSION.SDK_INT >= 28 activity.finish ");
                this.activity.finish();
            }
        } catch (Throwable th) {
            PlatformActionListener platformActionListener = this.c;
            if (platformActionListener != null) {
                platformActionListener.onError(this.a, 9, th);
            }
            NLog b2 = SSDKLog.b();
            b2.d(OnekeyShare.SHARESDK_TAG, " QQ ShareActivity catch " + th);
            this.activity.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x033f  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String c(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, int r24) {
        /*
            Method dump skipped, instructions count: 890
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.tencent.qq.e.c(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int):java.lang.String");
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 256 && i3 == 0 && Build.VERSION.SDK_INT < 28) {
            this.c.onCancel(this.a, 9);
        }
        this.activity.finish();
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        SSDKLog.b().d(OnekeyShare.SHARESDK_TAG, " QQ ShareActivity onCreate");
        try {
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(1);
            this.activity.setContentView(linearLayout);
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
        }
        Bundle extras = this.activity.getIntent().getExtras();
        final String string = extras.getString("title");
        final String string2 = extras.getString("titleUrl");
        final String string3 = extras.getString("summary");
        final String string4 = extras.getString("imageUrl");
        final String string5 = extras.getString("musicUrl");
        final String appName = DeviceHelper.getInstance(this.activity).getAppName();
        final String string6 = extras.getString(RemoteConfigConstants.RequestFieldKey.APP_ID);
        final int i2 = extras.getInt("hidden");
        String string7 = extras.getString("imagePath");
        final String string8 = extras.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        final String string9 = extras.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        final String string10 = extras.getString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        final int i3 = extras.getInt("share_type");
        if (i3 == 15) {
            if (b("8.0.8") < 0) {
                PlatformActionListener platformActionListener = this.c;
                if (platformActionListener != null) {
                    platformActionListener.onError(this.a, 9, new Throwable("808以下不支持分享小程序"));
                    return;
                }
                return;
            }
            a(string, string2, string3, string4, string7, string5, appName, string6, i2, string8, string9, string10, i3);
            if (this.c != null) {
                this.c.onComplete(this.a, 9, new HashMap<>());
            }
        } else if (TextUtils.isEmpty(string8) && TextUtils.isEmpty(string9) && TextUtils.isEmpty(string10) && TextUtils.isEmpty(string) && TextUtils.isEmpty(string3) && TextUtils.isEmpty(string2) && ((TextUtils.isEmpty(string7) || !new File(string7).exists()) && !TextUtils.isEmpty(string4))) {
            new Thread() { // from class: cn.sharesdk.tencent.qq.e.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        String downloadBitmap = BitmapHelper.downloadBitmap(((FakeActivity) e.this).activity, string4);
                        NLog b = SSDKLog.b();
                        b.d(OnekeyShare.SHARESDK_TAG, " QQ ShareActivity path: " + downloadBitmap);
                        e.this.b(string, string2, string3, string4, downloadBitmap, string5, appName, string6, i2, string8, string9, string10, i3);
                    }
                }
            }.start();
        } else {
            b(string, string2, string3, string4, string7, string5, appName, string6, i2, string8, string9, string10, i3);
        }
    }

    public void a(Platform platform, PlatformActionListener platformActionListener) {
        this.a = platform;
        this.c = platformActionListener;
    }

    public void a(String str) {
        this.b = "tencent" + str;
        this.f267d = str;
    }

    private void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9, String str10, String str11, int i3) {
        b(str, str2, str3, str4, str5, str6, str7, str8, i2, str9, str10, str11, i3);
    }

    private int[] a() {
        String str;
        try {
            str = MobSDK.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            str = "0";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            try {
                iArr[i2] = ResHelper.parseInt(split[i2]);
            } catch (Throwable th2) {
                SSDKLog.b().d(th2);
                iArr[i2] = 0;
            }
        }
        return iArr;
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null || str2 != null) {
            if (str != null || str2 == null) {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int i2 = 0;
                while (i2 < split.length && i2 < split2.length) {
                    try {
                        int parseInt = Integer.parseInt(split[i2]);
                        int parseInt2 = Integer.parseInt(split2[i2]);
                        if (parseInt < parseInt2) {
                            return -1;
                        }
                        if (parseInt > parseInt2) {
                            return 1;
                        }
                        i2++;
                    } catch (NumberFormatException unused) {
                        return str.compareTo(str2);
                    }
                }
                if (split.length > i2) {
                    return 1;
                }
                return split2.length > i2 ? -1 : 0;
            }
            return -1;
        }
        return 1;
    }

    public static int b(String str) {
        return a(c("com.tencent.mobileqq"), str);
    }

    public static String c(String str) {
        try {
            return MobSDK.getContext().getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}

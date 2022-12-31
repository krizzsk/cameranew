package us.pinguo.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tapjoy.TapjoyConstants;
import java.io.BufferedReader;
import java.io.FileReader;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: SystemUtils.kt */
/* loaded from: classes6.dex */
public final class s {
    public static final s a = new s();
    private static Integer b;
    private static String c;

    /* renamed from: d  reason: collision with root package name */
    private static String f12485d;

    /* renamed from: e  reason: collision with root package name */
    private static String f12486e;

    private s() {
    }

    @SuppressLint({"HardwareIds"})
    public static final String a(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        String str = f12486e;
        if (str != null) {
            return str;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
        f12486e = string;
        return string;
    }

    public static final String b() {
        String readLine;
        boolean x;
        int O;
        CharSequence H0;
        String str = f12485d;
        if (str != null) {
            return str;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
        while (true) {
            readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            x = kotlin.text.t.x(readLine, "Hardware", false, 2, null);
            if (x) {
                readLine = readLine.substring(8);
                kotlin.jvm.internal.s.g(readLine, "this as java.lang.String).substring(startIndex)");
                O = StringsKt__StringsKt.O(readLine, ':', 0, false, 6, null);
                if (O >= 0) {
                    String substring = readLine.substring(O + 1);
                    kotlin.jvm.internal.s.g(substring, "this as java.lang.String).substring(startIndex)");
                    H0 = StringsKt__StringsKt.H0(substring);
                    readLine = H0.toString();
                }
            }
        }
        if (readLine == null) {
            readLine = Build.HARDWARE;
        }
        f12485d = readLine;
        return readLine;
    }

    public static final int c(Activity activity) {
        kotlin.jvm.internal.s.h(activity, "activity");
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return BaseBlurEffect.ROTATION_180;
        }
        return 90;
    }

    private final PackageInfo d(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static final Integer e(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        Integer num = b;
        if (num != null) {
            return num;
        }
        s sVar = a;
        String packageName = context.getPackageName();
        kotlin.jvm.internal.s.g(packageName, "context.packageName");
        PackageInfo d2 = sVar.d(context, packageName);
        if (d2 == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(d2.versionCode);
        b = valueOf;
        return valueOf;
    }

    public static final String f(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        Integer num = b;
        if (num != null) {
            return String.valueOf(num);
        }
        s sVar = a;
        String packageName = context.getPackageName();
        kotlin.jvm.internal.s.g(packageName, "context.packageName");
        PackageInfo d2 = sVar.d(context, packageName);
        if (d2 == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(d2.versionCode);
        b = valueOf;
        return String.valueOf(valueOf);
    }

    public static final String g(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        String str = c;
        if (str != null) {
            return str;
        }
        s sVar = a;
        String packageName = context.getPackageName();
        kotlin.jvm.internal.s.g(packageName, "context.packageName");
        PackageInfo d2 = sVar.d(context, packageName);
        if (d2 == null) {
            return null;
        }
        String str2 = d2.versionName;
        c = str2;
        return str2;
    }

    public static final boolean h(String packageName, Context context) {
        kotlin.jvm.internal.s.h(packageName, "packageName");
        kotlin.jvm.internal.s.h(context, "context");
        return a.d(context, packageName) != null;
    }

    public static final boolean i(String packageName, int i2, Context context) {
        kotlin.jvm.internal.s.h(packageName, "packageName");
        kotlin.jvm.internal.s.h(context, "context");
        PackageInfo d2 = a.d(context, packageName);
        return d2 != null && d2.versionCode >= i2;
    }

    public static final int j(int i2, int i3) {
        boolean z = true;
        if (i3 != -1) {
            int abs = Math.abs(i2 - i3);
            if (Math.min(abs, 360 - abs) < 65) {
                z = false;
            }
        }
        return z ? (((i2 + 45) / 90) * 90) % BaseBlurEffect.ROTATION_360 : i3;
    }
}

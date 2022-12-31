package us.pinguo.foundation.utils;

import android.content.Context;
import android.text.TextUtils;
import com.growingio.android.sdk.utils.NetworkUtil;
import java.io.File;
import java.io.RandomAccessFile;
import us.pinguo.foundation.Conditions;
import us.pinguo.foundation.PackageMode;
/* compiled from: ChannelUtils.java */
/* loaded from: classes4.dex */
public final class i {
    private static String a;
    private static String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelUtils.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Conditions.Configs.values().length];
            a = iArr;
            try {
                iArr[Conditions.Configs.Google.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Conditions.Configs.DebugGoogle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Conditions.Configs.GoogleBeforeL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Conditions.Configs.Huawei.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Conditions.Configs.Anzhi.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Conditions.Configs.Debug.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        Conditions.Configs configs = Conditions.a;
        switch (a.a[configs.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return b(us.pinguo.foundation.e.b(), "GoogleMarket");
            case 4:
                return "智汇云（华为）";
            case 5:
                return "安智市场";
            case 6:
                return "Camera360官方";
            default:
                if (us.pinguo.foundation.a.a == PackageMode.DEV) {
                    return configs == Conditions.Configs.Xiaomi ? "小米" : "Camera360官方";
                }
                return b(us.pinguo.foundation.e.b(), null);
        }
    }

    private static String b(Context context, String str) {
        if (a == null) {
            a = e(context, str);
        }
        return a;
    }

    public static boolean c() {
        return "GoogleMarket".equals(a()) || !TextUtils.isEmpty(b);
    }

    public static boolean d() {
        return "智汇云（华为）".equals(a());
    }

    private static String e(Context context, String str) {
        String str2 = a;
        if (str2 != null) {
            return str2;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir), "r");
            randomAccessFile.seek(randomAccessFile.length() - 2);
            short read = (short) randomAccessFile.read();
            if (read <= 0) {
                return str == null ? NetworkUtil.NETWORK_UNKNOWN : str;
            }
            byte[] bArr = {90, 71, 101, 101, 107};
            byte[] bArr2 = new byte[5];
            randomAccessFile.seek(randomAccessFile.length() - read);
            randomAccessFile.read(bArr2);
            for (int i2 = 0; i2 < 5; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return str == null ? NetworkUtil.NETWORK_UNKNOWN : str;
                }
            }
            byte[] bArr3 = new byte[(read - 2) - 5];
            randomAccessFile.read(bArr3);
            return new String(bArr3);
        } catch (Exception unused) {
            return str == null ? NetworkUtil.NETWORK_UNKNOWN : str;
        }
    }

    public static void f(String str) {
        b = str;
    }
}

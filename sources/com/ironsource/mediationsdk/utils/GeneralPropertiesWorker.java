package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import com.growingio.android.sdk.collection.Constants;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public class GeneralPropertiesWorker implements Runnable {
    private final String a = getClass().getSimpleName();
    private Context b;

    private GeneralPropertiesWorker() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.Object> a() {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.GeneralPropertiesWorker.a():java.util.Map");
    }

    private String b() {
        try {
            String str = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            return "" + i2 + "(" + str + ")";
        } catch (Exception unused) {
            return "";
        }
    }

    private String c() {
        return IronSourceObject.getInstance().u();
    }

    private int d() {
        try {
            Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, this.a + ":getBatteryLevel()", e2);
            return -1;
        }
    }

    private String e() {
        try {
            return this.b.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    private String f() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return "";
        }
    }

    private String h() {
        return Constants.PLATFORM_ANDROID;
    }

    private long i() {
        if (s()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        }
        return -1L;
    }

    private int j() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round(((timeZone.getOffset(GregorianCalendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15) * 15;
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, this.a + ":getGmtMinutesOffset()", e2);
            return 0;
        }
    }

    private long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private String l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            return "";
        }
    }

    private String m() {
        return IronSourceObject.getInstance().x();
    }

    private String n() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                return !networkOperatorName.equals("") ? networkOperatorName : "";
            }
            return "";
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, this.a + ":getMobileCarrier()", e2);
            return "";
        }
    }

    private String o() {
        try {
            return com.ironsource.mediationsdk.k0.a.a().b();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e2);
            return "";
        }
    }

    private String p() {
        try {
            return com.ironsource.mediationsdk.k0.a.a().c();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e2);
            return "";
        }
    }

    private String q() {
        try {
            return com.ironsource.mediationsdk.k0.a.a().d();
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c.i().e(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e2);
            return "";
        }
    }

    private String r() {
        return IronSourceUtils.I();
    }

    private boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean t(int i2) {
        return i2 <= 840 && i2 >= -720 && i2 % 15 == 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.ironsource.mediationsdk.n0.f.b().d(a());
            IronSourceUtils.e0(this.b, com.ironsource.mediationsdk.n0.f.b().e());
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            i2.e(ironSourceTag, "Thread name = " + getClass().getSimpleName(), e2);
        }
    }

    public GeneralPropertiesWorker(Context context) {
        this.b = context.getApplicationContext();
    }
}

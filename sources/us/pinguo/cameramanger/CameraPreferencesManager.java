package us.pinguo.cameramanger;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Camera;
import com.tencent.bugly.crashreport.CrashReport;
import kotlin.jvm.internal.s;
import us.pinguo.cameramanger.info.LensFacing;
/* compiled from: CameraPreferencesManager.kt */
/* loaded from: classes4.dex */
public final class CameraPreferencesManager {
    public static final CameraPreferencesManager a = new CameraPreferencesManager();
    private static SharedPreferences b;

    /* compiled from: CameraPreferencesManager.kt */
    /* loaded from: classes4.dex */
    public static final class CatchedException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CatchedException(String errMsg) {
            super(errMsg);
            s.h(errMsg, "errMsg");
        }
    }

    private CameraPreferencesManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054 A[Catch: all -> 0x0134, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:8:0x0011, B:10:0x0021, B:13:0x002b, B:21:0x0047, B:24:0x004d, B:27:0x0054, B:31:0x0061, B:36:0x0084, B:43:0x00a9, B:47:0x00c5, B:39:0x00a0, B:48:0x011d, B:51:0x012e), top: B:56:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void a() {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.cameramanger.CameraPreferencesManager.a():void");
    }

    public final boolean b(LensFacing lensFacing) {
        Camera.CameraInfo cameraInfo;
        s.h(lensFacing, "lensFacing");
        int numberOfCameras = Camera.getNumberOfCameras();
        int i2 = 0;
        while (i2 < numberOfCameras) {
            int i3 = i2 + 1;
            try {
                cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
            } catch (Exception unused) {
                CrashReport.postCatchedException(new CatchedException("Fail to get camera info, camera num=" + numberOfCameras + ", index=" + i2));
            }
            if (d.a(cameraInfo) == lensFacing) {
                return true;
            }
            i2 = i3;
        }
        return false;
    }

    public final void c(Context context) {
        s.h(context, "context");
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("CameraManagerPref", 0);
        s.g(sharedPreferences, "context.applicationConte…ME, Context.MODE_PRIVATE)");
        b = sharedPreferences;
    }

    public final boolean d() {
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences != null) {
            boolean z = sharedPreferences.getBoolean("KEY_IS_CACHED_99350", false);
            us.pinguo.common.log.a.c(s.q("isCameraParamCached:", Boolean.valueOf(z)), new Object[0]);
            return z;
        }
        s.z("pref");
        throw null;
    }

    public final boolean e(LensFacing facing) {
        s.h(facing, "facing");
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null) {
            s.z("pref");
            throw null;
        }
        return sharedPreferences.getBoolean(facing + "KEY_EXPOSURE_COMPENSATION_SUPPORT", false);
    }

    public final boolean f(LensFacing facing) {
        s.h(facing, "facing");
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null) {
            s.z("pref");
            throw null;
        }
        return sharedPreferences.getBoolean(facing + "KEY_FOCUS_AREA_SUPPORT", false);
    }

    public final boolean g(LensFacing facing) {
        s.h(facing, "facing");
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null) {
            s.z("pref");
            throw null;
        }
        return sharedPreferences.getBoolean(facing + "KEY_METERING_AREA_SUPPORT", false);
    }

    public final boolean h(LensFacing facing) {
        s.h(facing, "facing");
        SharedPreferences sharedPreferences = b;
        if (sharedPreferences == null) {
            s.z("pref");
            throw null;
        }
        return sharedPreferences.getBoolean(facing + "KEY_ZOOM_SUPPORT", false);
    }
}

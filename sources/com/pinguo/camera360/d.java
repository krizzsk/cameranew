package com.pinguo.camera360;

import android.app.Application;
import androidx.work.PeriodicWorkRequest;
import com.growingio.android.sdk.collection.AbstractGrowingIO;
import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tencent.stat.DeviceInfo;
import us.pinguo.advsdk.utils.f;
import us.pinguo.foundation.e;
import us.pinguo.foundation.utils.i;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.util.q;
import us.pinguo.util.s;
import vStudio.Android.Camera360.Conditions;
/* compiled from: GrowingIOManager.java */
/* loaded from: classes3.dex */
public class d {
    public static boolean a;
    public static boolean b;

    static {
        a = e() || CameraBusinessSettingModel.v().x();
        b = Conditions.a();
    }

    public static void a(String str, String str2, String str3) {
        if (b) {
            try {
                User d2 = User.d();
                if (d2 != null && d2.n()) {
                    AbstractGrowingIO.getInstance().setUserId(User.l());
                }
                String d3 = q.d(BaseApplication.d());
                String str4 = (s.a(e.b()) == null || a) ? "" : "";
                if (str == null) {
                    str = "";
                }
                AbstractGrowingIO.getInstance().setAppVariable("net", d3);
                GrowingIO abstractGrowingIO = AbstractGrowingIO.getInstance();
                abstractGrowingIO.setAppVariable("idsInfo", "||" + str + Effect.DIVIDER + str4);
                AbstractGrowingIO.getInstance().setAppVariable("pushId", str2);
                AbstractGrowingIO.getInstance().setAppVariable("gps", str3);
                if (CameraBusinessSettingModel.v().x()) {
                    AbstractGrowingIO.getInstance().setAppVariable(DeviceInfo.TAG_ANDROID_ID, "unknown");
                } else {
                    AbstractGrowingIO.getInstance().setAppVariable(DeviceInfo.TAG_ANDROID_ID, us.pinguo.bigdata.f.a.e(BaseApplication.d()));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void b() {
        if (b) {
            AbstractGrowingIO.getInstance().disableDataCollect();
        }
    }

    public static void c() {
        if (b) {
            AbstractGrowingIO.getInstance().enableDataCollect();
        }
    }

    public static void d(Application application) {
        if (b) {
            Configuration debugMode = new Configuration().trackAllFragments().setChannel(i.a()).setDebugMode(us.pinguo.foundation.d.f10985d);
            debugMode.setFlushInterval(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS);
            if (a) {
                debugMode.disableDataCollect();
            }
            GrowingIO.startWithConfiguration(application, debugMode);
        }
    }

    public static boolean e() {
        return (Conditions.d() || Conditions.e() || Conditions.c()) && new f().a();
    }
}

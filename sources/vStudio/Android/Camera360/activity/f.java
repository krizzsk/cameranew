package vStudio.Android.Camera360.activity;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.k.b.a;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.push.PushPreference;
/* compiled from: FirstLaunchInit.java */
/* loaded from: classes7.dex */
public class f {

    /* compiled from: FirstLaunchInit.java */
    /* loaded from: classes7.dex */
    class a extends AsyncTask<Object, Object, Object> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // us.pinguo.foundation.utils.AsyncTask
        protected Object doInBackground(Object... objArr) {
            String str;
            AdvertisingIdClient.Info advertisingIdInfo;
            a.h.c(CameraBusinessSettingModel.v().s());
            try {
                advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(BaseApplication.d());
            } catch (Throwable unused) {
            }
            if (advertisingIdInfo != null) {
                str = advertisingIdInfo.getId();
                try {
                    a.e.a(str, !advertisingIdInfo.isLimitAdTrackingEnabled());
                } catch (Throwable unused2) {
                }
                com.pinguo.camera360.d.a(str, this.a, ",");
                return null;
            }
            str = null;
            com.pinguo.camera360.d.a(str, this.a, ",");
            return null;
        }
    }

    public static void a() {
        try {
            new a(new PushPreference(BaseApplication.d()).d("clientId", "_")).executeOnPoolExecutor(new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    public static void b(int i2) {
        if ((1 == i2 || 2 == i2) && 1 == i2) {
            a.b.a();
            CameraBusinessSettingModel.v().P(true);
            us.pinguo.foundation.q.a.h(BaseApplication.d());
            CameraBusinessSettingModel.v().E("key_show_guide_auto_effect", true);
            CameraBusinessSettingModel.v().E("key_frame_red_point", false);
            CameraBusinessSettingModel.v().E("key_preview_setting_red_point", false);
        }
    }
}

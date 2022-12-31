package us.pinguo.camera360.App;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.CookieSyncManager;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.c;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.tapjoy.TapjoyConstants;
import java.util.Locale;
import us.pinguo.common.network.HttpRequestQueue;
import us.pinguo.common.network.common.PGNetworkConfig;
import us.pinguo.common.network.common.header.PGUserAgentHeader;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.i;
import us.pinguo.foundation.utils.n0;
import us.pinguo.foundation.utils.v;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.u3dengine.UnityControlCaller;
import us.pinguo.ui.C360BaseImageDownloader;
import us.pinguo.user.u0;
import us.pinguo.util.s;
/* loaded from: classes3.dex */
public class PGInitManager {
    public static final String KEY_CLEAR_FLAG = "key_clear_flag";
    public static final String KEY_ONLINE_NAME = "key_online_name";
    private static final String TAG = "PGInitManager";

    private static void debugChangeQA(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("debug", 0);
        if (sharedPreferences.contains("isQA")) {
            us.pinguo.foundation.d.b = sharedPreferences.getBoolean("isQA", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void initBeforeDex(final PgCameraApplication pgCameraApplication, boolean z) {
        if (z) {
            boolean z2 = us.pinguo.foundation.d.f10987f;
            us.pinguo.common.log.a.n(z2);
            n0.k(pgCameraApplication);
            UnityControlCaller.setContext(pgCameraApplication);
            PayHelp.getInstance().v(z2);
            if (us.pinguo.foundation.d.f10985d) {
                debugChangeQA(pgCameraApplication);
            }
            AsyncTask.init();
            HttpRequestQueue.initInApp(pgCameraApplication, false);
            pgCameraApplication.c(new Runnable() { // from class: us.pinguo.camera360.App.c
                @Override // java.lang.Runnable
                public final void run() {
                    PGInitManager.initImageLoader(PgCameraApplication.this);
                }
            });
            try {
                CookieSyncManager.createInstance(pgCameraApplication);
            } catch (Exception unused) {
            }
            u0.o = CameraBusinessSettingModel.v().x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(context);
        builder.B(us.pinguo.common.imageloader.a.c());
        builder.C(us.pinguo.common.imageloader.a.a());
        builder.v();
        builder.x(10485760);
        builder.w(new d.f.a.a.a.d.c());
        builder.z(new C360BaseImageDownloader(context));
        c.b bVar = new c.b();
        bVar.u(true);
        bVar.v(true);
        builder.u(bVar.t());
        builder.y(new us.pinguo.ui.a(context, us.pinguo.foundation.d.f10985d));
        builder.D(QueueProcessingType.LIFO);
        ImageLoader.getInstance().q(builder.t());
        ImageLoader.getInstance().p(true);
    }

    public static void initNetworkSDK(Application application, Boolean bool) {
        PGUserAgentHeader.Builder builder = new PGUserAgentHeader.Builder();
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        Locale a = v.a();
        builder.appName("camera360").channelName(i.a()).platformName(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE).platformVersion(String.valueOf(Build.VERSION.SDK_INT)).deviceName(Build.MODEL).deviceVersion(Build.VERSION.RELEASE).netLibName("volley").netLibVersion("1.0.2").screenHeight(displayMetrics.heightPixels).screenWidth(displayMetrics.widthPixels).language(a.getLanguage());
        String country = a.getCountry();
        if (!TextUtils.isEmpty(country)) {
            builder.country(country);
        }
        String g2 = s.g(application);
        if (!TextUtils.isEmpty(g2)) {
            builder.appVersionName(g2);
        }
        int intValue = s.e(application).intValue();
        if (intValue >= 0) {
            builder.appVersionCode(intValue);
        }
        if (!bool.booleanValue()) {
            String a2 = j.a.f.e.a(application);
            if (!TextUtils.isEmpty(a2)) {
                builder.deviceId(a2);
            }
        }
        PGNetworkConfig.getInstance().init(BaseApplication.e(), builder.build(), "UTF-8", false, !bool.booleanValue());
    }
}

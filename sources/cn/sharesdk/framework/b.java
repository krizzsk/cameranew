package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.HashMap;
/* compiled from: CheckAppKeyRequestUrl.java */
/* loaded from: classes.dex */
public class b {
    private static String a = "";
    private static volatile b b;
    private DeviceHelper c = DeviceHelper.getInstance(MobSDK.getContext());

    /* renamed from: d  reason: collision with root package name */
    private NetworkHelper f82d = new NetworkHelper();

    /* renamed from: e  reason: collision with root package name */
    private String f83e = MobSDK.checkRequestUrl("api.share.mob.com");

    private b() {
    }

    public static b a() {
        synchronized (b.class) {
            if (b == null) {
                synchronized (b.class) {
                    if (b == null) {
                        b = new b();
                    }
                }
            }
        }
        return b;
    }

    private String c() {
        return this.f83e + "/conf5";
    }

    public void b() {
        try {
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            String appkey = MobSDK.getAppkey();
            if (TextUtils.isEmpty(appkey)) {
                return;
            }
            arrayList.add(new KVPair<>("appkey", appkey));
            arrayList.add(new KVPair<>(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, this.c.getDeviceKey()));
            arrayList.add(new KVPair<>("plat", String.valueOf(this.c.getPlatformCode())));
            arrayList.add(new KVPair<>("apppkg", this.c.getPackageName()));
            arrayList.add(new KVPair<>("appver", String.valueOf(this.c.getAppVersion())));
            arrayList.add(new KVPair<>("sdkver", String.valueOf(ShareSDK.SDK_VERSION_CODE)));
            arrayList.add(new KVPair<>("networktype", this.c.getDetailNetworkTypeForStatic()));
            ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
            arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.a.a.a()));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 10000;
            networkTimeOut.connectionTimeout = 10000;
            HashMap fromJson = new Hashon().fromJson(this.f82d.httpPost(c(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut));
            if (fromJson.containsKey("error")) {
                if (String.valueOf(fromJson.get("error")).contains("'appkey' is illegal")) {
                    a.a = true;
                }
            } else {
                a.b = appkey;
            }
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.d("updateServerConfig " + th, new Object[0]);
        }
    }
}

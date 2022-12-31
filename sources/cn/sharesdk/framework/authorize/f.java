package cn.sharesdk.framework.authorize;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import us.pinguo.common.network.HttpRequest;
/* compiled from: SdkPlusTags.java */
/* loaded from: classes.dex */
public class f {
    private static volatile f a;
    private MobCommunicator b;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, Object> f79h;

    /* renamed from: g  reason: collision with root package name */
    private boolean f78g = false;

    /* renamed from: e  reason: collision with root package name */
    private DeviceHelper f76e = DeviceHelper.getInstance(MobSDK.getContext());
    private String c = MobSDK.getAppkey();

    /* renamed from: d  reason: collision with root package name */
    private String f75d = this.f76e.getDeviceKey();

    /* renamed from: f  reason: collision with root package name */
    private cn.sharesdk.framework.a.b f77f = cn.sharesdk.framework.a.b.a();

    public static f c() {
        synchronized (f.class) {
            if (a == null) {
                synchronized (f.class) {
                    if (a == null) {
                        a = new f();
                    }
                }
            }
        }
        return a;
    }

    private synchronized MobCommunicator e() {
        if (this.b == null) {
            this.b = new MobCommunicator(1024, "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f", "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1");
        }
        return this.b;
    }

    public boolean a() {
        return this.f78g;
    }

    public HashMap<String, Object> b() {
        return this.f79h;
    }

    public void d() throws Throwable {
        cn.sharesdk.framework.b.a.e a2 = cn.sharesdk.framework.b.a.e.a();
        if (this.f78g && a2.g()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KVPair("Content-type", HttpRequest.CONTENT_TYPE_JSON));
            arrayList.add(new KVPair("sign", a(this.c, this.f75d)));
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("appkey", this.c);
            hashMap.put("deviceId", this.f75d);
            String authorize = DeviceAuthorizer.authorize(new SHARESDK());
            hashMap.put("duid", authorize);
            try {
                if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.f75d) && !TextUtils.isEmpty(authorize)) {
                    this.f79h = (HashMap) e().requestSynchronized(hashMap, "http://p.share.mob.com/tags/getTagList", false);
                } else {
                    SSDKLog.b().d("SdkPlusTags request userTags that appkey or deviceId or duid is null", new Object[0]);
                }
            } catch (Exception e2) {
                NLog b = SSDKLog.b();
                b.d("SdkPlusTags request userTags is error T===> " + e2, new Object[0]);
            }
        }
    }

    public void a(boolean z) {
        this.f78g = z;
    }

    private String a(String str, String str2) throws Throwable {
        byte[] rawMD5 = Data.rawMD5(String.format("%s:%s", this.f76e.getDeviceKey(), MobSDK.getAppkey()));
        return Base64.encodeToString(Data.AES128Encode(rawMD5, str + str2), 2);
    }
}

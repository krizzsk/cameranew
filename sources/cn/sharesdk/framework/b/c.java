package cn.sharesdk.framework.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.b.a.e;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.BuglyStrategy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: Protocols.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: i  reason: collision with root package name */
    private static MobCommunicator f102i;
    private e a = e.a();
    private DeviceHelper b = DeviceHelper.getInstance(MobSDK.getContext());
    private NetworkHelper c = new NetworkHelper();

    /* renamed from: d  reason: collision with root package name */
    private Hashon f103d = new Hashon();

    /* renamed from: e  reason: collision with root package name */
    private String f104e;

    /* renamed from: f  reason: collision with root package name */
    private String f105f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f106g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<String, String> f107h;

    public c() {
        try {
            this.f107h = (HashMap) this.a.k("buffered_server_paths");
        } catch (Throwable unused) {
            this.f107h = new HashMap<>();
        }
        h();
    }

    private String e(String str) throws Throwable {
        boolean c = this.a.c();
        boolean d2 = this.a.d();
        StringBuilder sb = new StringBuilder();
        sb.append(Data.urlEncode(this.b.getPackageName(), "utf-8"));
        sb.append(Effect.DIVIDER);
        sb.append(Data.urlEncode(this.b.getAppVersionName(), "utf-8"));
        sb.append(Effect.DIVIDER);
        sb.append(Data.urlEncode(String.valueOf(ShareSDK.SDK_VERSION_CODE), "utf-8"));
        sb.append(Effect.DIVIDER);
        sb.append(Data.urlEncode(String.valueOf(this.b.getPlatformCode()), "utf-8"));
        sb.append(Effect.DIVIDER);
        sb.append(Data.urlEncode(this.b.getDetailNetworkTypeForStatic(), "utf-8"));
        sb.append(Effect.DIVIDER);
        if (c) {
            sb.append(Data.urlEncode(String.valueOf(this.b.getOSVersionInt()), "utf-8"));
            sb.append(Effect.DIVIDER);
            sb.append(Data.urlEncode(this.b.getScreenSize(), "utf-8"));
            sb.append(Effect.DIVIDER);
            sb.append(Data.urlEncode(this.b.getManufacturer(), "utf-8"));
            sb.append(Effect.DIVIDER);
            sb.append(Data.urlEncode(this.b.getModel(), "utf-8"));
            sb.append(Effect.DIVIDER);
            sb.append(Data.urlEncode(this.b.getCarrier(), "utf-8"));
            sb.append(Effect.DIVIDER);
        } else {
            sb.append("|||||");
        }
        if (d2) {
            sb.append(str);
        } else {
            sb.append(str.split("\\|")[0]);
            sb.append("|||||");
        }
        String sb2 = sb.toString();
        SSDKLog.b().i("shorLinkMsg ===>>>>", sb2);
        return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.format("%s:%s", this.b.getDeviceKey(), MobSDK.getAppkey())), sb2), 2);
    }

    private static synchronized MobCommunicator g() {
        MobCommunicator mobCommunicator;
        synchronized (c.class) {
            if (f102i == null) {
                f102i = new MobCommunicator(1024, "bb7addd7e33383b74e82aba9b1d274c73aea6c0c71fcc88730270f630dbe490e1d162004f74e9532f98e17004630fbea9b346de63c23e83a7dfad70dd47cebfd", "288e7c44e01569a905386e6341baabfcde63ec37d0f0835cc662c299a5d0072970808a7fa434f0a51fa581d09d5ec4350ba5d548eafbe1fd956fb3afd678c1fb6134c904668652ec5cceb5d85da337a0f2f13ea457cca74a01b3ba0f4c809ad30d382bba2562ec9b996ae44c3700731c1b914997ef826331759e4084a019a03f");
            }
            mobCommunicator = f102i;
        }
        return mobCommunicator;
    }

    private void h() {
        this.f104e = (this.b.getPackageName() + "/" + this.b.getAppVersionName()) + " ShareSDK/3.9.4 " + ("Android/" + this.b.getOSVersionInt());
        try {
            this.f105f = MobSDK.dynamicModifyUrl("api.share.mob.com");
        } catch (Throwable th) {
            this.f105f = MobSDK.checkRequestUrl("api.share.mob.com");
            SSDKLog.b().d("001 dynamicModifyUrl catch, no problem " + th, new Object[0]);
        }
        this.f106g = true;
    }

    private String i() {
        return this.f105f + "/conn";
    }

    private String j() {
        HashMap<String, String> hashMap = this.f107h;
        if (hashMap != null && hashMap.containsKey("/date")) {
            return this.f107h.get("/date") + "/date";
        }
        return this.f105f + "/date";
    }

    private String k() {
        return this.f105f + "/conf5";
    }

    private String l() {
        try {
            return MobSDK.dynamicModifyUrl("up.mob.com/upload/image");
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("002 dynamicModifyUrl catch, no problem " + th, new Object[0]);
            return MobSDK.checkRequestUrl("up.mob.com/upload/image");
        }
    }

    private String m() {
        HashMap<String, String> hashMap = this.f107h;
        if (hashMap != null && hashMap.containsKey("/log4")) {
            return this.f107h.get("/log4") + "/log4";
        }
        return this.f105f + "/log4";
    }

    private String n() {
        try {
            return MobSDK.dynamicModifyUrl("l.mob.com/url/shareSdkEncryptMapping.do");
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.d("003 dynamicModifyUrl catch, no problem " + th, new Object[0]);
            return MobSDK.checkRequestUrl("l.mob.com/url/shareSdkEncryptMapping.do");
        }
    }

    private String o() {
        HashMap<String, String> hashMap = this.f107h;
        if (hashMap != null && hashMap.containsKey("/snsconf")) {
            return this.f107h.get("/snsconf") + "/snsconf";
        }
        return this.f105f + "/snsconf";
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SSDKLog.b().d("duid === " + str, new Object[0]);
        this.f104e += " " + str;
    }

    public void b(String str) {
        this.f105f = str;
    }

    public HashMap<String, Object> c() throws Throwable {
        String appkey = MobSDK.getAppkey();
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", appkey));
        arrayList.add(new KVPair<>(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, this.b.getDeviceKey()));
        arrayList.add(new KVPair<>("plat", String.valueOf(this.b.getPlatformCode())));
        arrayList.add(new KVPair<>("apppkg", this.b.getPackageName()));
        arrayList.add(new KVPair<>("appver", String.valueOf(this.b.getAppVersion())));
        arrayList.add(new KVPair<>("sdkver", String.valueOf(ShareSDK.SDK_VERSION_CODE)));
        arrayList.add(new KVPair<>("networktype", this.b.getDetailNetworkTypeForStatic()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.a.a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        String httpPost = this.c.httpPost(k(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut);
        try {
            HashMap fromJson = new Hashon().fromJson(httpPost);
            if (fromJson.containsKey("error")) {
                if (String.valueOf(fromJson.get("error")).contains("'appkey' is illegal")) {
                    if (TextUtils.isEmpty(appkey)) {
                        cn.sharesdk.framework.b.a().b();
                    } else {
                        cn.sharesdk.framework.a.a = true;
                    }
                }
            } else if (!TextUtils.isEmpty(appkey)) {
                cn.sharesdk.framework.a.b = appkey;
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
        SSDKLog.b().i(" get server config response == %s", httpPost);
        return this.f103d.fromJson(httpPost);
    }

    public HashMap<String, Object> d() throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
        arrayList.add(new KVPair<>(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, this.b.getDeviceKey()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.a.a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = 10000;
        networkTimeOut.connectionTimeout = 10000;
        return this.f103d.fromJson(this.c.httpPost(o(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut));
    }

    public HashMap<String, Object> f() throws Throwable {
        return this.f103d.fromJson(this.a.i());
    }

    public long b() throws Throwable {
        String str;
        if (this.a.k()) {
            try {
                str = this.c.httpGet(j(), null, null, null);
            } catch (Throwable th) {
                SSDKLog.b().d(th);
                str = "{}";
            }
            HashMap fromJson = this.f103d.fromJson(str);
            if (fromJson.containsKey("timestamp")) {
                try {
                    long currentTimeMillis = System.currentTimeMillis() - ResHelper.parseLong(String.valueOf(fromJson.get("timestamp")));
                    this.a.a("service_time", Long.valueOf(currentTimeMillis));
                    return currentTimeMillis;
                } catch (Throwable th2) {
                    SSDKLog.b().d(th2);
                    return this.a.b();
                }
            }
            return this.a.b();
        }
        return 0L;
    }

    public void a(HashMap<String, String> hashMap) {
        this.f107h = hashMap;
        this.a.a("buffered_server_paths", hashMap);
    }

    public HashMap<String, Object> a() throws Throwable {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", MobSDK.getAppkey()));
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.a.a.a()));
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        networkTimeOut.connectionTimeout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
        String httpPost = this.c.httpPost(i(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut);
        SSDKLog.b().i(" isConnectToServer response == %s", httpPost);
        return this.f103d.fromJson(httpPost);
    }

    public HashMap<String, Object> d(String str) throws Throwable {
        byte[] decode = Base64.decode(str, 2);
        String deviceKey = this.b.getDeviceKey();
        return this.f103d.fromJson(new String(Data.AES128Decode(Data.rawMD5(MobSDK.getAppkey() + ":" + deviceKey), decode), "UTF-8").trim());
    }

    public void b(HashMap<String, Object> hashMap) throws Throwable {
        this.a.g(this.f103d.fromHashMap(hashMap));
    }

    public boolean a(String str, boolean z) {
        try {
            if (MobSDK.isMob()) {
                if (!PortalFollowFeeds.TYPE_NONE.equals(this.b.getDetailNetworkTypeForStatic())) {
                    ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                    arrayList.add(new KVPair<>("m", str));
                    arrayList.add(new KVPair<>("t", z ? "1" : "0"));
                    ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                    arrayList2.add(new KVPair<>("User-Identity", cn.sharesdk.framework.a.a.a()));
                    NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                    networkTimeOut.readTimout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                    networkTimeOut.connectionTimeout = BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH;
                    String httpPost = this.c.httpPost(m(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut);
                    SSDKLog.b().i("> Upload All Log  resp: %s", httpPost);
                    return TextUtils.isEmpty(httpPost) || ((Integer) this.f103d.fromJson(httpPost).get("status")).intValue() == 200;
                }
                throw new IllegalStateException("network is disconnected!");
            }
            return true;
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            return false;
        }
    }

    public ArrayList<cn.sharesdk.framework.b.a.c> e() throws Throwable {
        ArrayList<cn.sharesdk.framework.b.a.c> a = cn.sharesdk.framework.b.a.d.a();
        return a == null ? new ArrayList<>() : a;
    }

    public HashMap<String, Object> c(String str) throws Throwable {
        KVPair<String> kVPair = new KVPair<>("file", str);
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("User-Identity", cn.sharesdk.framework.a.a.a()));
        String httpPost = this.c.httpPost(l(), (ArrayList<KVPair<String>>) null, kVPair, arrayList, (NetworkHelper.NetworkTimeOut) null);
        SSDKLog.b().i("upload file response == %s", httpPost);
        return this.f103d.fromJson(httpPost);
    }

    public HashMap<String, Object> a(String str, ArrayList<String> arrayList, int i2, String str2) throws Throwable {
        if (this.f106g) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new KVPair("key", MobSDK.getAppkey()));
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList2.add(new KVPair("urls", arrayList.get(i3).toString()));
            }
            arrayList2.add(new KVPair("deviceid", this.b.getDeviceKey()));
            arrayList2.add(new KVPair("snsplat", String.valueOf(i2)));
            String e2 = e(str2);
            if (TextUtils.isEmpty(e2)) {
                return null;
            }
            arrayList2.add(new KVPair("m", e2));
            new ArrayList().add(new KVPair("User-Identity", cn.sharesdk.framework.a.a.a()));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 5000;
            networkTimeOut.connectionTimeout = 5000;
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("key", MobSDK.getAppkey());
            ArrayList arrayList3 = new ArrayList();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList3.add(URLEncoder.encode(arrayList.get(i4), "UTF-8"));
            }
            hashMap.put("urls", arrayList3);
            hashMap.put("deviceid", this.b.getDeviceKey());
            hashMap.put("snsplat", Integer.valueOf(i2));
            if (TextUtils.isEmpty(e2)) {
                return null;
            }
            hashMap.put("m", e2);
            HashMap<String, Object> hashMap2 = (HashMap) g().requestSynchronized(hashMap, n(), false);
            SSDKLog.b().i("> SERVER_SHORT_LINK_URL  resp: %s", hashMap2);
            if (hashMap2.size() == 0) {
                this.f106g = false;
                return null;
            } else if (hashMap2.get("data") == null) {
                return null;
            } else {
                return hashMap2;
            }
        }
        return null;
    }

    public void a(cn.sharesdk.framework.b.b.c cVar) throws Throwable {
        cn.sharesdk.framework.b.a.d.a(cVar.toString(), cVar.f88e);
    }

    public void a(ArrayList<String> arrayList) throws Throwable {
        cn.sharesdk.framework.b.a.d.a(arrayList);
    }
}

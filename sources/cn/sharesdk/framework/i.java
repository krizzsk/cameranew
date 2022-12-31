package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
/* compiled from: ShareSDKCoreThread.java */
/* loaded from: classes.dex */
public class i extends cn.sharesdk.framework.utils.f {
    private a b;

    /* renamed from: k  reason: collision with root package name */
    private boolean f128k;

    /* renamed from: j  reason: collision with root package name */
    private boolean f127j = true;
    private HashMap<String, HashMap<String, String>> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<Platform> f121d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Integer> f122e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Integer, String> f123f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, CustomPlatform> f124g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private HashMap<Integer, HashMap<String, Object>> f125h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private HashMap<Integer, Service> f126i = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ShareSDKCoreThread.java */
    /* loaded from: classes.dex */
    public enum a {
        INITIALIZING,
        READY
    }

    private void k() {
        synchronized (this.c) {
            this.c.clear();
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            InputStream inputStream = null;
            try {
                inputStream = MobSDK.getContext().getAssets().open("ShareSDK.xml");
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
            newPullParser.setInput(inputStream, "utf-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    HashMap<String, String> hashMap = new HashMap<>();
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i2 = 0; i2 < attributeCount; i2++) {
                        hashMap.put(newPullParser.getAttributeName(i2), newPullParser.getAttributeValue(i2).trim());
                    }
                    this.c.put(name, hashMap);
                }
            }
            inputStream.close();
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    protected void b(Message message) {
    }

    public boolean b() {
        return h.c();
    }

    public boolean c() {
        return h.d();
    }

    public HashMap<String, Object> d() {
        return h.e();
    }

    @Override // cn.sharesdk.framework.utils.f
    public void e() {
        this.b = a.INITIALIZING;
        SSDKLog.a();
        EventRecorder.prepare();
        k();
        super.e();
    }

    public Platform[] f() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f121d) {
            if (this.b == a.INITIALIZING) {
                this.f121d.wait();
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Platform> it = this.f121d.iterator();
        while (it.hasNext()) {
            Platform next = it.next();
            if (next != null && next.b()) {
                next.a();
                arrayList.add(next);
            }
        }
        h.a(arrayList);
        for (Map.Entry<Integer, CustomPlatform> entry : this.f124g.entrySet()) {
            CustomPlatform value = entry.getValue();
            if (value != null && value.b()) {
                arrayList.add(value);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int size = arrayList.size();
        Platform[] platformArr = new Platform[size];
        for (int i2 = 0; i2 < size; i2++) {
            platformArr[i2] = (Platform) arrayList.get(i2);
        }
        SSDKLog.b().i("sort list use time: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return platformArr;
    }

    public boolean g() {
        return this.f128k;
    }

    public boolean h() {
        synchronized (this.f125h) {
            HashMap<Integer, HashMap<String, Object>> hashMap = this.f125h;
            return hashMap != null && hashMap.size() > 0;
        }
    }

    public boolean i() {
        boolean z = false;
        if (a.READY != this.b) {
            SSDKLog.b().d("Statistics module unopened", new Object[0]);
            return false;
        }
        final cn.sharesdk.framework.b.a a2 = cn.sharesdk.framework.b.a.a();
        HashMap<String, Object> a3 = a(a2, a2.e());
        if (a3 != null && a3.size() > 0) {
            z = a(a3);
        }
        if (z) {
            new Thread() { // from class: cn.sharesdk.framework.i.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        HashMap<String, Object> f2 = a2.f();
                        HashMap a4 = i.this.a(a2, f2);
                        if (a4 == null || a4.size() <= 0 || !i.this.a(a4)) {
                            return;
                        }
                        a2.a(f2);
                    } catch (Throwable th) {
                        SSDKLog.b().w(th);
                    }
                }
            }.start();
        } else {
            try {
                HashMap<String, Object> f2 = a2.f();
                HashMap<String, Object> a4 = a(a2, f2);
                if (a4 != null && a4.size() > 0 && (z = a(a4))) {
                    a2.a(f2);
                }
            } catch (Throwable th) {
                SSDKLog.b().w(th);
            }
        }
        return z;
    }

    public void j() {
        try {
            ResHelper.clearCache(MobSDK.getContext());
        } catch (Throwable th) {
            SSDKLog.b().w(th);
        }
    }

    public void b(boolean z) {
        h.b(z);
    }

    public <T extends Service> T c(Class<T> cls) {
        T cast;
        synchronized (this.f126i) {
            if (this.b == a.INITIALIZING) {
                this.f126i.wait();
            }
            cast = cls.cast(this.f126i.get(Integer.valueOf(cls.hashCode())));
        }
        return cast;
    }

    public void d(Class<? extends CustomPlatform> cls) {
        synchronized (this.f124g) {
            if (this.f124g.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            CustomPlatform newInstance = cls.newInstance();
            this.f124g.put(Integer.valueOf(cls.hashCode()), newInstance);
            if (newInstance != null && newInstance.b()) {
                this.f123f.put(Integer.valueOf(newInstance.getPlatformId()), newInstance.getName());
                this.f122e.put(newInstance.getName(), Integer.valueOf(newInstance.getPlatformId()));
            }
        }
    }

    public void a(Activity activity) {
        h.a(activity);
    }

    public void b(Class<? extends Service> cls) {
        synchronized (this.f126i) {
            int hashCode = cls.hashCode();
            if (this.f126i.containsKey(Integer.valueOf(hashCode))) {
                this.f126i.get(Integer.valueOf(hashCode)).onUnbind();
                this.f126i.remove(Integer.valueOf(hashCode));
            }
        }
    }

    public Activity a() {
        return h.b();
    }

    public void a(boolean z) {
        h.a(z);
    }

    public void a(Context context, ReadQrImageListener readQrImageListener) {
        h.a(context, readQrImageListener);
    }

    public void e(Class<? extends CustomPlatform> cls) {
        int hashCode = cls.hashCode();
        synchronized (this.f124g) {
            this.f124g.remove(Integer.valueOf(hashCode));
        }
    }

    public void a(String str, String str2, String str3, String str4, WaterMarkListener waterMarkListener) {
        h.a(str, str2, str3, str4, waterMarkListener);
    }

    public Bitmap a(String str, int i2, int i3) {
        return h.a(str, i2, i3);
    }

    public void a(HashMap<String, Object> hashMap, MoblinkActionListener moblinkActionListener) {
        try {
            h.a(hashMap, moblinkActionListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCoreThread mobLinkGetMobID " + th, new Object[0]);
        }
    }

    public void b(int i2) {
        NetworkHelper.readTimout = i2;
    }

    public void c(boolean z) {
        this.f128k = z;
    }

    public void a(HashMap<String, Object> hashMap, String str, LoopSharePasswordListener loopSharePasswordListener) {
        try {
            h.a(hashMap, str, loopSharePasswordListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCoreThrad preparePassWord catch: " + th, new Object[0]);
        }
    }

    public int b(String str) {
        synchronized (this.f121d) {
            synchronized (this.f124g) {
                if (this.f122e.containsKey(str)) {
                    return this.f122e.get(str).intValue();
                }
                return 0;
            }
        }
    }

    public String c(int i2) {
        String str;
        synchronized (this.f121d) {
            synchronized (this.f124g) {
                str = this.f123f.get(Integer.valueOf(i2));
            }
        }
        return str;
    }

    public void a(boolean z, LoopSharePasswordListener loopSharePasswordListener) {
        try {
            h.a(z, loopSharePasswordListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCoreThrad readPassWord catch: " + th, new Object[0]);
        }
    }

    public void a(LoopShareResultListener loopShareResultListener) {
        try {
            h.a(loopShareResultListener);
        } catch (Throwable th) {
            NLog b = SSDKLog.b();
            b.e("ShareSDKCoreThrad prepareLoopShare " + th, new Object[0]);
        }
    }

    public String c(String str) {
        if (a.READY != this.b) {
            return null;
        }
        return cn.sharesdk.framework.b.a.a().b(str);
    }

    @Override // cn.sharesdk.framework.utils.f
    protected void a(Message message) {
        synchronized (this.f126i) {
            synchronized (this.f121d) {
                String checkRecord = EventRecorder.checkRecord(ShareSDK.SDK_TAG);
                if (!TextUtils.isEmpty(checkRecord)) {
                    cn.sharesdk.framework.b.a.a().a((HashMap<String, Object>) null);
                    NLog b = SSDKLog.b();
                    b.w("EventRecorder checkRecord result ==" + checkRecord);
                    j();
                }
                EventRecorder.clear();
                this.f121d.clear();
                ArrayList<Platform> a2 = h.a();
                if (a2 != null) {
                    this.f121d.addAll(a2);
                }
                Iterator<Platform> it = this.f121d.iterator();
                while (it.hasNext()) {
                    Platform next = it.next();
                    this.f123f.put(Integer.valueOf(next.getPlatformId()), next.getName());
                    this.f122e.put(next.getName(), Integer.valueOf(next.getPlatformId()));
                }
                h.a(this.a);
                a aVar = a.READY;
                this.b = aVar;
                new Thread() { // from class: cn.sharesdk.framework.i.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        i.this.i();
                    }
                }.start();
                this.b = aVar;
                this.f121d.notify();
                this.f126i.notify();
            }
        }
    }

    public String b(String str, String str2) {
        synchronized (this.c) {
            HashMap<String, String> hashMap = this.c.get(str);
            if (hashMap == null) {
                return null;
            }
            return hashMap.get(str2);
        }
    }

    public void a(Class<? extends Service> cls) {
        synchronized (this.f126i) {
            if (this.f126i.containsKey(Integer.valueOf(cls.hashCode()))) {
                return;
            }
            Service newInstance = cls.newInstance();
            this.f126i.put(Integer.valueOf(cls.hashCode()), newInstance);
            newInstance.onBind();
        }
    }

    public Platform a(String str) {
        Platform[] f2;
        if (str == null || (f2 = f()) == null) {
            return null;
        }
        for (Platform platform : f2) {
            if (str.equals(platform.getName())) {
                return platform;
            }
        }
        return null;
    }

    public void a(int i2) {
        NetworkHelper.connectionTimeout = i2;
    }

    public void a(int i2, Platform platform) {
        h.a(i2, platform);
    }

    public void a(String str, int i2) {
        h.a(str, i2);
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        synchronized (this.c) {
            HashMap<String, String> hashMap2 = this.c.get(str);
            if (hashMap2 == null) {
                hashMap2 = new HashMap<>();
            }
            synchronized (hashMap2) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null) {
                        hashMap2.put(key, String.valueOf(value));
                    }
                }
            }
            this.c.put(str, hashMap2);
        }
        synchronized (this.f121d) {
            if (this.b == a.INITIALIZING) {
                this.f121d.wait();
            }
        }
        Iterator<Platform> it = this.f121d.iterator();
        while (it.hasNext()) {
            Platform next = it.next();
            if (next != null && next.getName().equals(str)) {
                next.a();
                return;
            }
        }
    }

    public void a(List<HashMap<String, Object>> list) {
        synchronized (this.c) {
            for (HashMap<String, Object> hashMap : list) {
                String str = null;
                HashMap<String, String> hashMap2 = new HashMap<>();
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (key.equals("platformName")) {
                        str = String.valueOf(entry.getValue());
                    }
                    if (value != null) {
                        hashMap2.put(key, String.valueOf(value));
                    }
                }
                this.c.put(str, hashMap2);
            }
        }
        synchronized (this.f121d) {
            if (this.b == a.INITIALIZING) {
                this.f121d.wait();
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this.c) {
            this.c.put(str2, this.c.get(str));
        }
    }

    public void a(int i2, int i3) {
        synchronized (this.f125h) {
            this.f125h.put(Integer.valueOf(i3), this.f125h.get(Integer.valueOf(i2)));
        }
    }

    public String a(int i2, String str) {
        synchronized (this.f125h) {
            HashMap<String, Object> hashMap = this.f125h.get(Integer.valueOf(i2));
            String str2 = null;
            if (hashMap == null) {
                return null;
            }
            Object obj = hashMap.get(str);
            if (obj != null) {
                str2 = String.valueOf(obj);
            }
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(cn.sharesdk.framework.b.a aVar, HashMap<String, Object> hashMap) {
        try {
            if (hashMap.containsKey("error")) {
                SSDKLog.b().i("ShareSDK parse sns config ==>>", new Hashon().fromHashMap(hashMap));
                return null;
            } else if (!hashMap.containsKey("res")) {
                SSDKLog.b().d("ShareSDK platform config result ==>>", "SNS configuration is empty");
                return null;
            } else {
                String str = (String) hashMap.get("res");
                if (str == null) {
                    return null;
                }
                return aVar.c(str);
            }
        } catch (Throwable th) {
            SSDKLog.b().w(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> hashMap) {
        synchronized (this.f125h) {
            HashMap<Integer, HashMap<String, Object>> a2 = h.a(hashMap);
            if (a2 == null || a2.size() <= 0) {
                return false;
            }
            this.f125h.clear();
            this.f125h = a2;
            return true;
        }
    }

    public String a(String str, boolean z, int i2, String str2) {
        return a.READY != this.b ? str : cn.sharesdk.framework.b.a.a().a(str, i2, z, str2);
    }

    public String a(Bitmap bitmap) {
        if (a.READY != this.b) {
            return null;
        }
        return cn.sharesdk.framework.b.a.a().a(bitmap);
    }
}

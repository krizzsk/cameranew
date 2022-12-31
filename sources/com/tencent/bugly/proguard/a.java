package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adjust.sdk.Constants;
import com.mp4parser.iso14496.part15.SyncSampleEntry;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.matrix.trace.config.SharePluginInfo;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static Proxy f7917e;
    protected HashMap<String, HashMap<String, byte[]>> a = new HashMap<>();
    protected String b;
    i c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Object> f7918d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        new HashMap();
        this.f7918d = new HashMap<>();
        this.b = "GBK";
        this.c = new i();
    }

    public static void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            f7917e = null;
        } else {
            f7917e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        }
    }

    public static Proxy b() {
        return f7917e;
    }

    public static an b(byte[] bArr) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b = dVar.b(SharePluginInfo.ISSUE_STACK_TYPE, new an());
                if (an.class.isInstance(b)) {
                    return (an) an.class.cast(b);
                }
                return null;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void a(InetAddress inetAddress, int i2) {
        if (inetAddress == null) {
            f7917e = null;
        } else {
            f7917e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i2));
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public static aq a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        aq aqVar = new aq();
        aqVar.a = userInfoBean.f7799e;
        aqVar.f7963e = userInfoBean.f7804j;
        aqVar.f7962d = userInfoBean.c;
        aqVar.c = userInfoBean.f7798d;
        aqVar.f7965g = userInfoBean.o == 1;
        int i2 = userInfoBean.b;
        if (i2 == 1) {
            aqVar.b = (byte) 1;
        } else if (i2 == 2) {
            aqVar.b = (byte) 4;
        } else if (i2 == 3) {
            aqVar.b = (byte) 2;
        } else if (i2 == 4) {
            aqVar.b = (byte) 3;
        } else if (i2 < 10 || i2 >= 20) {
            x.e("unknown uinfo type %d ", Integer.valueOf(i2));
            return null;
        } else {
            aqVar.b = (byte) i2;
        }
        HashMap hashMap = new HashMap();
        aqVar.f7964f = hashMap;
        if (userInfoBean.p >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.p);
            hashMap.put("C01", sb.toString());
        }
        if (userInfoBean.q >= 0) {
            Map<String, String> map = aqVar.f7964f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.q);
            map.put("C02", sb2.toString());
        }
        Map<String, String> map2 = userInfoBean.r;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                Map<String, String> map3 = aqVar.f7964f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                Map<String, String> map5 = aqVar.f7964f;
                map5.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map6 = aqVar.f7964f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f7806l);
        map6.put("A36", sb3.toString());
        Map<String, String> map7 = aqVar.f7964f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f7801g);
        map7.put("F02", sb4.toString());
        Map<String, String> map8 = aqVar.f7964f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f7802h);
        map8.put("F03", sb5.toString());
        Map<String, String> map9 = aqVar.f7964f;
        map9.put("F04", userInfoBean.f7804j);
        Map<String, String> map10 = aqVar.f7964f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f7803i);
        map10.put("F05", sb6.toString());
        Map<String, String> map11 = aqVar.f7964f;
        map11.put("F06", userInfoBean.m);
        Map<String, String> map12 = aqVar.f7964f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f7805k);
        map12.put("F10", sb7.toString());
        x.c("summary type %d vm:%d", Byte.valueOf(aqVar.b), Integer.valueOf(aqVar.f7964f.size()));
        return aqVar;
    }

    public static String a(ArrayList<String> arrayList) {
        int i2;
        int i3;
        int i4;
        StringBuffer stringBuffer = new StringBuffer();
        int i5 = 0;
        while (true) {
            String str = "map";
            if (i5 < arrayList.size()) {
                String str2 = arrayList.get(i5);
                if (str2.equals("java.lang.Integer") || str2.equals("int")) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals(TypedValues.Custom.S_BOOLEAN)) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals(TypedValues.Custom.S_FLOAT)) {
                    str = TypedValues.Custom.S_FLOAT;
                } else if (str2.equals("java.lang.Long") || str2.equals(Constants.LONG)) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else if (str2.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                } else {
                    if (str2.equals("java.lang.String")) {
                        str = TypedValues.Custom.S_STRING;
                    } else if (str2.equals("java.util.List")) {
                        str = "list";
                    } else if (!str2.equals("java.util.Map")) {
                        str = str2;
                    }
                }
                arrayList.set(i5, str);
                i5++;
            } else {
                Collections.reverse(arrayList);
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    String str3 = arrayList.get(i6);
                    if (str3.equals("list")) {
                        arrayList.set(i6 - 1, "<" + arrayList.get(i4));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("map")) {
                        arrayList.set(i6 - 1, "<" + arrayList.get(i3) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        arrayList.set(i6 - 1, "<" + arrayList.get(i2));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t != null) {
            if (!(t instanceof Set)) {
                j jVar = new j();
                jVar.a(this.b);
                jVar.a(t, 0);
                byte[] a = l.a(jVar.a());
                HashMap<String, byte[]> hashMap = new HashMap<>(1);
                ArrayList<String> arrayList = new ArrayList<>(1);
                a(arrayList, t);
                hashMap.put(a(arrayList), a);
                this.f7918d.remove(str);
                this.a.put(str, hashMap);
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    public static ar a(List<UserInfoBean> list, int i2) {
        com.tencent.bugly.crashreport.common.info.a b;
        if (list == null || list.size() == 0 || (b = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b.o();
        ar arVar = new ar();
        arVar.b = b.f7817d;
        arVar.c = b.h();
        ArrayList<aq> arrayList = new ArrayList<>();
        for (UserInfoBean userInfoBean : list) {
            aq a = a(userInfoBean);
            if (a != null) {
                arrayList.add(a);
            }
        }
        arVar.f7969d = arrayList;
        HashMap hashMap = new HashMap();
        arVar.f7970e = hashMap;
        hashMap.put("A7", b.f7820g);
        Map<String, String> map = arVar.f7970e;
        map.put("A6", b.n());
        Map<String, String> map2 = arVar.f7970e;
        map2.put("A5", b.m());
        Map<String, String> map3 = arVar.f7970e;
        StringBuilder sb = new StringBuilder();
        sb.append(b.k());
        map3.put("A2", sb.toString());
        Map<String, String> map4 = arVar.f7970e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b.k());
        map4.put("A1", sb2.toString());
        Map<String, String> map5 = arVar.f7970e;
        map5.put("A24", b.f7822i);
        Map<String, String> map6 = arVar.f7970e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b.l());
        map6.put("A17", sb3.toString());
        Map<String, String> map7 = arVar.f7970e;
        map7.put("A15", b.q());
        Map<String, String> map8 = arVar.f7970e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b.r());
        map8.put("A13", sb4.toString());
        Map<String, String> map9 = arVar.f7970e;
        map9.put("F08", b.w);
        Map<String, String> map10 = arVar.f7970e;
        map10.put("F09", b.x);
        Map<String, String> y = b.y();
        if (y != null && y.size() > 0) {
            for (Map.Entry<String, String> entry : y.entrySet()) {
                Map<String, String> map11 = arVar.f7970e;
                map11.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i2 == 1) {
            arVar.a = (byte) 1;
        } else if (i2 != 2) {
            x.e("unknown up type %d ", Integer.valueOf(i2));
            return null;
        } else {
            arVar.a = (byte) 2;
        }
        return arVar;
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                i iVar = new i(bArr);
                iVar.a("utf-8");
                newInstance.a(iVar);
                return newInstance;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static am a(Context context, int i2, byte[] bArr) {
        String str;
        com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b != null && c != null) {
            try {
                am amVar = new am();
                synchronized (b) {
                    amVar.a = 1;
                    amVar.b = b.f();
                    amVar.c = b.c;
                    amVar.f7936d = b.f7824k;
                    amVar.f7937e = b.m;
                    amVar.f7938f = b.f7819f;
                    amVar.f7939g = i2;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    amVar.f7940h = bArr;
                    amVar.f7941i = b.f7821h;
                    amVar.f7942j = b.f7822i;
                    amVar.f7943k = new HashMap();
                    amVar.f7944l = b.e();
                    amVar.m = c.n;
                    amVar.o = b.h();
                    amVar.p = com.tencent.bugly.crashreport.common.info.b.b(context);
                    amVar.q = System.currentTimeMillis();
                    amVar.r = b.i();
                    amVar.s = b.h();
                    amVar.t = amVar.p;
                    b.getClass();
                    amVar.n = "com.tencent.bugly";
                    Map<String, String> map = amVar.f7943k;
                    map.put("A26", b.s());
                    Map<String, String> map2 = amVar.f7943k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(b.D());
                    map2.put("A62", sb.toString());
                    Map<String, String> map3 = amVar.f7943k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(b.E());
                    map3.put("A63", sb2.toString());
                    Map<String, String> map4 = amVar.f7943k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(b.B);
                    map4.put("F11", sb3.toString());
                    Map<String, String> map5 = amVar.f7943k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(b.A);
                    map5.put("F12", sb4.toString());
                    Map<String, String> map6 = amVar.f7943k;
                    map6.put("D3", b.f7825l);
                    List<com.tencent.bugly.a> list = com.tencent.bugly.b.b;
                    if (list != null) {
                        for (com.tencent.bugly.a aVar : list) {
                            String str2 = aVar.versionKey;
                            if (str2 != null && (str = aVar.version) != null) {
                                amVar.f7943k.put(str2, str);
                            }
                        }
                    }
                    amVar.f7943k.put("G15", z.b("G15", ""));
                    amVar.f7943k.put("D4", z.b("D4", "0"));
                }
                Map<String, String> x = b.x();
                if (x != null) {
                    for (Map.Entry<String, String> entry : x.entrySet()) {
                        amVar.f7943k.put(entry.getKey(), entry.getValue());
                    }
                }
                return amVar;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (obj.getClass().getComponentType().toString().equals("byte")) {
                if (Array.getLength(obj) > 0) {
                    arrayList.add("java.util.List");
                    a(arrayList, Array.get(obj, 0));
                    return;
                }
                arrayList.add("Array");
                arrayList.add("?");
                return;
            }
            throw new IllegalArgumentException("only byte[] is supported");
        } else if (!(obj instanceof Array)) {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                } else {
                    arrayList.add("?");
                }
            } else if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
            } else {
                arrayList.add(obj.getClass().getName());
            }
        } else {
            throw new IllegalArgumentException("can not support Array, please use List");
        }
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.b);
        jVar.a((Map) this.a, 0);
        return l.a(jVar.a());
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a("utf-8");
            dVar.a(1);
            dVar.b("RqdServer");
            dVar.c(SyncSampleEntry.TYPE);
            dVar.a(SharePluginInfo.ISSUE_STACK_TYPE, (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public void a(byte[] bArr) {
        this.c.a(bArr);
        this.c.a(this.b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.a = this.c.a((Map) hashMap, 0, false);
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}

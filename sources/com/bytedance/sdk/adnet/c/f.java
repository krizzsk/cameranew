package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TNCManager.java */
/* loaded from: classes.dex */
public class f implements c {
    private static f c;

    /* renamed from: e  reason: collision with root package name */
    private Context f1208e;

    /* renamed from: f  reason: collision with root package name */
    private e f1209f;
    private long b = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1207d = false;

    /* renamed from: g  reason: collision with root package name */
    private int f1210g = 0;

    /* renamed from: h  reason: collision with root package name */
    private long f1211h = 19700101000L;

    /* renamed from: i  reason: collision with root package name */
    private int f1212i = 0;

    /* renamed from: j  reason: collision with root package name */
    private HashMap<String, Integer> f1213j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    private HashMap<String, Integer> f1214k = new HashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private int f1215l = 0;
    private HashMap<String, Integer> m = new HashMap<>();
    private HashMap<String, Integer> n = new HashMap<>();
    private boolean o = true;
    private Map<String, Integer> p = new HashMap();
    Handler a = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.adnet.c.f.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            f.this.a(message.arg1 != 0);
        }
    };

    private f() {
    }

    private boolean a(int i2) {
        return i2 >= 200 && i2 < 400;
    }

    private void f() {
        SharedPreferences sharedPreferences = this.f1208e.getSharedPreferences("ttnet_tnc_config", 0);
        this.f1210g = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.f1211h = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void g() {
        com.bytedance.sdk.adnet.d.c.b("TNCManager", "resetTNCControlState");
        this.f1212i = 0;
        this.f1213j.clear();
        this.f1214k.clear();
        this.f1215l = 0;
        this.m.clear();
        this.n.clear();
    }

    public void b() {
        this.p.clear();
    }

    public d c() {
        e eVar = this.f1209f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public Map<String, String> d() {
        d c2 = c();
        if (c2 != null) {
            return c2.f1197d;
        }
        return null;
    }

    public e e() {
        return this.f1209f;
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (c == null) {
                c = new f();
            }
            fVar = c;
        }
        return fVar;
    }

    private void b(String str) {
        Map<String, String> d2;
        if (TextUtils.isEmpty(str) || (d2 = d()) == null || !d2.containsValue(str)) {
            return;
        }
        if (this.p.get(str) == null) {
            this.p.put(str, 1);
        } else {
            this.p.put(str, Integer.valueOf(this.p.get(str).intValue() + 1));
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str) && this.p.containsKey(str)) {
            this.p.put(str, 0);
        }
    }

    private boolean d(String str) {
        Map<String, String> d2 = d();
        if (d2 == null) {
            return false;
        }
        String str2 = d2.get(str);
        if (TextUtils.isEmpty(str2) || this.p.get(str2) == null || this.p.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.adnet.d.c.b("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    public synchronized void a(Context context, boolean z) {
        if (!this.f1207d) {
            this.f1208e = context;
            this.o = z;
            this.f1209f = new e(context, z);
            if (z) {
                f();
            }
            com.bytedance.sdk.adnet.d.c.b("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.f1210g + " probeVersion: " + this.f1211h);
            this.f1207d = true;
        }
    }

    private boolean b(int i2) {
        if (i2 < 100 || i2 >= 1000) {
            return true;
        }
        d c2 = c();
        if (c2 == null || TextUtils.isEmpty(c2.m)) {
            return false;
        }
        String str = c2.m;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i2);
        return str.contains(sb.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto Lf8
            java.lang.String r0 = "/network/get_network"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Lf8
            java.lang.String r0 = "/get_domains/v4"
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto Lf8
            java.lang.String r0 = "/ies/speed"
            boolean r0 = r7.contains(r0)
            if (r0 == 0) goto L20
            goto Lf8
        L20:
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L31
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L31
            java.lang.String r2 = r1.getProtocol()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = r1.getHost()     // Catch: java.lang.Throwable -> L2f
            goto L36
        L2f:
            r1 = move-exception
            goto L33
        L31:
            r1 = move-exception
            r2 = r0
        L33:
            r1.printStackTrace()
        L36:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto Lf8
            java.lang.String r1 = "http"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L4c
            java.lang.String r1 = "https"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto Lf8
        L4c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L54
            goto Lf8
        L54:
            boolean r1 = r6.d(r0)
            java.lang.String r3 = "TNCManager"
            if (r1 == 0) goto L71
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, TNC host faild num over limit: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.bytedance.sdk.adnet.d.c.b(r3, r0)
            return r7
        L71:
            java.util.Map r1 = r6.d()
            if (r1 == 0) goto Le4
            boolean r4 = r1.containsKey(r0)
            if (r4 != 0) goto L7e
            goto Le4
        L7e:
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L8b
            return r7
        L8b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "handleHostMapping, match, origin: "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            com.bytedance.sdk.adnet.d.c.b(r3, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r5 = "://"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            boolean r2 = r7.startsWith(r0)
            if (r2 == 0) goto Lcf
            java.lang.String r7 = r7.replaceFirst(r0, r1)
        Lcf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleHostMapping, target: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.adnet.d.c.b(r3, r0)
            return r7
        Le4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleHostMapping, nomatch: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.bytedance.sdk.adnet.d.c.b(r3, r0)
        Lf8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.c.f.a(java.lang.String):java.lang.String");
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, m mVar) {
        if (request == null || mVar == null) {
            return;
        }
        if (this.o) {
            if (com.bytedance.sdk.adnet.d.e.a(this.f1208e)) {
                URL url = null;
                try {
                    url = new URL(request.getUrl());
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String ipAddrStr = request.getIpAddrStr();
                int i2 = (int) mVar.f1258h;
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(ipAddrStr)) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2);
                    d c2 = c();
                    if (c2 != null && c2.b) {
                        a(mVar, host);
                    }
                    if (c2 == null) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2 + " " + this.f1212i + "#" + this.f1213j.size() + "#" + this.f1214k.size() + " " + this.f1215l + "#" + this.m.size() + "#" + this.n.size());
                    if (i2 > 0) {
                        if (a(i2)) {
                            if (this.f1212i > 0 || this.f1215l > 0) {
                                g();
                            }
                            c(host);
                        } else if (!b(i2)) {
                            this.f1215l++;
                            this.m.put(path, 0);
                            this.n.put(ipAddrStr, 0);
                            if (this.f1215l >= c2.f1201h && this.m.size() >= c2.f1202i && this.n.size() >= c2.f1203j) {
                                com.bytedance.sdk.adnet.d.c.b("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i2);
                                a(false, 0L);
                                g();
                            }
                            b(host);
                        }
                    }
                }
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.c.c
    public synchronized void a(Request request, Exception exc) {
        if (request == null || exc == null) {
            return;
        }
        if (this.o) {
            if (com.bytedance.sdk.adnet.d.e.a(this.f1208e)) {
                URL url = null;
                try {
                    url = new URL(request.getUrl());
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String ipAddrStr = request.getIpAddrStr();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    d c2 = c();
                    if (c2 == null) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.c.b("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "# " + this.f1212i + "#" + this.f1213j.size() + "#" + this.f1214k.size() + " " + this.f1215l + "#" + this.m.size() + "#" + this.n.size());
                    this.f1212i = this.f1212i + 1;
                    this.f1213j.put(path, 0);
                    this.f1214k.put(ipAddrStr, 0);
                    if (this.f1212i >= c2.f1198e && this.f1213j.size() >= c2.f1199f && this.f1214k.size() >= c2.f1200g) {
                        com.bytedance.sdk.adnet.d.c.b("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + ipAddrStr);
                        a(false, 0L);
                        g();
                    }
                    b(host);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.bytedance.sdk.adnet.core.m r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.c.f.a(com.bytedance.sdk.adnet.core.m, java.lang.String):void");
    }

    private void a(boolean z, long j2) {
        if (this.a.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.a.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z ? 1 : 0;
        if (j2 > 0) {
            this.a.sendMessageDelayed(obtainMessage, j2);
        } else {
            this.a.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        d c2 = c();
        if (c2 == null) {
            return;
        }
        com.bytedance.sdk.adnet.d.c.b("TNCManager", "doUpdateRemote, " + z);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.b + (c2.f1204k * 1000) > elapsedRealtime) {
            com.bytedance.sdk.adnet.d.c.b("TNCManager", "doUpdateRemote, time limit");
            return;
        }
        this.b = elapsedRealtime;
        com.bytedance.sdk.adnet.a.a.a(this.f1208e).b(com.bytedance.sdk.adnet.d.e.a(this.f1208e));
    }
}

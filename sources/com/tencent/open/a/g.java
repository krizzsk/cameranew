package com.tencent.open.a;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import com.tencent.connect.common.Constants;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.j;
import com.tencent.open.utils.l;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.common.network.HttpRequest;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class g {
    protected static g a;

    /* renamed from: e  reason: collision with root package name */
    protected HandlerThread f8157e;

    /* renamed from: f  reason: collision with root package name */
    protected Handler f8158f;
    protected Random b = new Random();

    /* renamed from: d  reason: collision with root package name */
    protected List<Serializable> f8156d = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g  reason: collision with root package name */
    protected Executor f8159g = j.b();

    /* renamed from: h  reason: collision with root package name */
    protected Executor f8160h = j.b();

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                g.this.b();
            } else if (i2 == 1001) {
                g.this.e();
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    class b implements Runnable {
        final /* synthetic */ Bundle a;
        final /* synthetic */ boolean b;

        b(Bundle bundle, boolean z) {
            this.a = bundle;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String k2 = l.k(com.tencent.open.a.c.b(com.tencent.open.utils.f.a()));
                String k3 = l.k(com.tencent.open.a.c.c(com.tencent.open.utils.f.a()));
                String k4 = l.k(com.tencent.open.a.c.a());
                String k5 = l.k(com.tencent.open.a.c.d(com.tencent.open.utils.f.a()));
                Bundle bundle = new Bundle();
                bundle.putString("uin", Constants.DEFAULT_UIN);
                bundle.putString("imei", k2);
                bundle.putString("imsi", k3);
                bundle.putString(TapjoyConstants.TJC_ANDROID_ID, k5);
                bundle.putString("mac", k4);
                bundle.putString("platform", "1");
                bundle.putString("os_ver", Build.VERSION.RELEASE);
                bundle.putString("position", "");
                bundle.putString("network", com.tencent.open.a.a.a(com.tencent.open.utils.f.a()));
                bundle.putString(IjkMediaMeta.IJKM_KEY_LANGUAGE, com.tencent.open.a.c.b());
                bundle.putString("resolution", com.tencent.open.a.c.a(com.tencent.open.utils.f.a()));
                bundle.putString("apn", com.tencent.open.a.a.b(com.tencent.open.utils.f.a()));
                bundle.putString("model_name", Build.MODEL);
                bundle.putString(TapjoyConstants.TJC_DEVICE_TIMEZONE, TimeZone.getDefault().getID());
                bundle.putString("sdk_ver", Constants.SDK_VERSION);
                bundle.putString("qz_ver", l.d(com.tencent.open.utils.f.a(), Constants.PACKAGE_QZONE));
                bundle.putString("qq_ver", l.c(com.tencent.open.utils.f.a(), "com.tencent.mobileqq"));
                bundle.putString("qua", l.e(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                bundle.putString("packagename", com.tencent.open.utils.f.b());
                bundle.putString("app_ver", l.d(com.tencent.open.utils.f.a(), com.tencent.open.utils.f.b()));
                Bundle bundle2 = this.a;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                g.this.f8156d.add(new com.tencent.open.a.b(bundle));
                int size = g.this.f8156d.size();
                int a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                if (a == 0) {
                    a = 10000;
                }
                if (!g.this.a("report_via", size) && !this.b) {
                    if (g.this.f8158f.hasMessages(1001)) {
                        return;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 1001;
                    g.this.f8158f.sendMessageDelayed(obtain, a);
                    return;
                }
                g.this.e();
                g.this.f8158f.removeMessages(1001);
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class c implements Runnable {
        final /* synthetic */ long a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8161d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f8162e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f8163f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ boolean f8164g;

        c(long j2, String str, String str2, int i2, long j3, long j4, boolean z) {
            this.a = j2;
            this.b = str;
            this.c = str2;
            this.f8161d = i2;
            this.f8162e = j3;
            this.f8163f = j4;
            this.f8164g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
                Bundle bundle = new Bundle();
                String a = com.tencent.open.a.a.a(com.tencent.open.utils.f.a());
                bundle.putString("apn", a);
                bundle.putString("appid", "1000067");
                bundle.putString("commandid", this.b);
                bundle.putString(SharePluginInfo.ISSUE_STACK_TYPE, this.c);
                StringBuilder sb = new StringBuilder();
                sb.append("network=");
                sb.append(a);
                sb.append('&');
                sb.append("sdcard=");
                int i2 = 1;
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append('&');
                sb.append("wifi=");
                sb.append(com.tencent.open.a.a.e(com.tencent.open.utils.f.a()));
                bundle.putString("deviceInfo", sb.toString());
                int a2 = 100 / g.this.a(this.f8161d);
                if (a2 > 0) {
                    i2 = a2 > 100 ? 100 : a2;
                }
                bundle.putString("frequency", i2 + "");
                bundle.putString("reqSize", this.f8162e + "");
                bundle.putString("resultCode", this.f8161d + "");
                bundle.putString("rspSize", this.f8163f + "");
                bundle.putString("timeCost", elapsedRealtime + "");
                bundle.putString("uin", Constants.DEFAULT_UIN);
                g.this.c.add(new com.tencent.open.a.b(bundle));
                int size = g.this.c.size();
                int a3 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Agent_ReportTimeInterval");
                if (a3 == 0) {
                    a3 = 10000;
                }
                if (!g.this.a("report_cgi", size) && !this.f8164g) {
                    if (!g.this.f8158f.hasMessages(1000)) {
                        Message obtain = Message.obtain();
                        obtain.what = 1000;
                        g.this.f8158f.sendMessageDelayed(obtain, a3);
                    }
                }
                g.this.b();
                g.this.f8158f.removeMessages(1000);
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProGuard */
    /* loaded from: classes3.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle c = g.this.c();
                if (c == null) {
                    return;
                }
                int a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_HttpRetryCount");
                if (a == 0) {
                    a = 3;
                }
                SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + a);
                boolean z = false;
                int i2 = 0;
                while (true) {
                    i2++;
                    try {
                        try {
                            try {
                                HttpClient httpClient = HttpUtils.getHttpClient(com.tencent.open.utils.f.a(), null, "https://wspeed.qq.com/w.cgi");
                                HttpPost httpPost = new HttpPost("https://wspeed.qq.com/w.cgi");
                                httpPost.addHeader(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
                                httpPost.setHeader(HttpRequest.HEADER_CONTENT_TYPE, HttpRequest.CONTENT_TYPE_FORM);
                                httpPost.setEntity(new ByteArrayEntity(l.i(HttpUtils.encodeUrl(c))));
                                int statusCode = httpClient.execute(httpPost).getStatusLine().getStatusCode();
                                SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                                if (statusCode != 200) {
                                    break;
                                }
                                com.tencent.open.a.f.a().b("report_cgi");
                                z = true;
                                break;
                            } catch (Exception e2) {
                                SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e2);
                            }
                        } catch (SocketTimeoutException e3) {
                            SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e3);
                            continue;
                        }
                    } catch (ConnectTimeoutException e4) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e4);
                        continue;
                    }
                    

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: ProGuard */
                    /* loaded from: classes3.dex */
                    public class e implements Runnable {
                        e() {
                        }

                        /* JADX WARN: Removed duplicated region for block: B:36:0x00c3 A[Catch: Exception -> 0x00f2, TRY_ENTER, TryCatch #8 {Exception -> 0x00f2, blocks: (B:3:0x0004, B:6:0x000d, B:33:0x00b1, B:36:0x00c3, B:38:0x00d6, B:37:0x00cb, B:21:0x006c, B:26:0x0086, B:30:0x009b, B:31:0x00a5, B:9:0x0038, B:10:0x004a, B:14:0x0054, B:17:0x005f), top: B:48:0x0004, inners: #10, #8, #7 }] */
                        /* JADX WARN: Removed duplicated region for block: B:37:0x00cb A[Catch: Exception -> 0x00f2, TryCatch #8 {Exception -> 0x00f2, blocks: (B:3:0x0004, B:6:0x000d, B:33:0x00b1, B:36:0x00c3, B:38:0x00d6, B:37:0x00cb, B:21:0x006c, B:26:0x0086, B:30:0x009b, B:31:0x00a5, B:9:0x0038, B:10:0x004a, B:14:0x0054, B:17:0x005f), top: B:48:0x0004, inners: #10, #8, #7 }] */
                        /* JADX WARN: Removed duplicated region for block: B:51:0x00b1 A[SYNTHETIC] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void run() {
                            /*
                                Method dump skipped, instructions count: 249
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.e.run():void");
                        }
                    }

                    /* compiled from: ProGuard */
                    /* loaded from: classes3.dex */
                    class f implements Runnable {
                        final /* synthetic */ Bundle a;
                        final /* synthetic */ String b;
                        final /* synthetic */ boolean c;

                        /* renamed from: d  reason: collision with root package name */
                        final /* synthetic */ String f8166d;

                        f(g gVar, Bundle bundle, String str, boolean z, String str2) {
                            this.a = bundle;
                            this.b = str;
                            this.c = z;
                            this.f8166d = str2;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:101:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:122:0x0135 A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:85:0x0137 A[Catch: Exception -> 0x015a, TRY_ENTER, TryCatch #12 {Exception -> 0x015a, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000e, B:10:0x0015, B:12:0x003e, B:13:0x0042, B:15:0x0050, B:19:0x0086, B:85:0x0137, B:86:0x013d, B:35:0x00d6, B:71:0x011a, B:95:0x0153, B:94:0x0150, B:16:0x0064, B:18:0x0072, B:96:0x0154, B:89:0x0145, B:91:0x014b), top: B:111:0x0004, inners: #0 }] */
                        /* JADX WARN: Removed duplicated region for block: B:86:0x013d A[Catch: Exception -> 0x015a, TRY_LEAVE, TryCatch #12 {Exception -> 0x015a, blocks: (B:3:0x0004, B:5:0x0008, B:7:0x000e, B:10:0x0015, B:12:0x003e, B:13:0x0042, B:15:0x0050, B:19:0x0086, B:85:0x0137, B:86:0x013d, B:35:0x00d6, B:71:0x011a, B:95:0x0153, B:94:0x0150, B:16:0x0064, B:18:0x0072, B:96:0x0154, B:89:0x0145, B:91:0x014b), top: B:111:0x0004, inners: #0 }] */
                        @Override // java.lang.Runnable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public void run() {
                            /*
                                Method dump skipped, instructions count: 353
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.f.run():void");
                        }
                    }

                    private g() {
                        this.f8157e = null;
                        if (this.f8157e == null) {
                            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
                            this.f8157e = handlerThread;
                            handlerThread.start();
                        }
                        if (!this.f8157e.isAlive() || this.f8157e.getLooper() == null) {
                            return;
                        }
                        this.f8158f = new a(this.f8157e.getLooper());
                    }

                    public static synchronized g a() {
                        g gVar;
                        synchronized (g.class) {
                            if (a == null) {
                                a = new g();
                            }
                            gVar = a;
                        }
                        return gVar;
                    }

                    protected void b() {
                        this.f8160h.execute(new d());
                    }

                    protected Bundle c() {
                        if (this.c.size() == 0) {
                            return null;
                        }
                        com.tencent.open.a.b bVar = (com.tencent.open.a.b) this.c.get(0);
                        if (bVar == null) {
                            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
                            return null;
                        }
                        String str = bVar.a.get("appid");
                        List<Serializable> a2 = com.tencent.open.a.f.a().a("report_cgi");
                        if (a2 != null) {
                            this.c.addAll(a2);
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
                        if (this.c.size() == 0) {
                            return null;
                        }
                        Bundle bundle = new Bundle();
                        try {
                            bundle.putString("appid", str);
                            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
                            bundle.putString(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, Build.DEVICE);
                            bundle.putString("qua", Constants.SDK_QUA);
                            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
                            for (int i2 = 0; i2 < this.c.size(); i2++) {
                                com.tencent.open.a.b bVar2 = (com.tencent.open.a.b) this.c.get(i2);
                                bundle.putString(i2 + "_1", bVar2.a.get("apn"));
                                bundle.putString(i2 + "_2", bVar2.a.get("frequency"));
                                bundle.putString(i2 + "_3", bVar2.a.get("commandid"));
                                bundle.putString(i2 + "_4", bVar2.a.get("resultCode"));
                                bundle.putString(i2 + "_5", bVar2.a.get("timeCost"));
                                bundle.putString(i2 + "_6", bVar2.a.get("reqSize"));
                                bundle.putString(i2 + "_7", bVar2.a.get("rspSize"));
                                bundle.putString(i2 + "_8", bVar2.a.get(SharePluginInfo.ISSUE_STACK_TYPE));
                                bundle.putString(i2 + "_9", bVar2.a.get("uin"));
                                bundle.putString(i2 + "_10", com.tencent.open.a.c.e(com.tencent.open.utils.f.a()) + "&" + bVar2.a.get("deviceInfo"));
                            }
                            SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
                            return bundle;
                        } catch (Exception e2) {
                            SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e2);
                            return null;
                        }
                    }

                    protected Bundle d() {
                        List<Serializable> a2 = com.tencent.open.a.f.a().a("report_via");
                        if (a2 != null) {
                            this.f8156d.addAll(a2);
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f8156d.size());
                        if (this.f8156d.size() == 0) {
                            return null;
                        }
                        JSONArray jSONArray = new JSONArray();
                        Iterator<Serializable> it = this.f8156d.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObject = new JSONObject();
                            com.tencent.open.a.b bVar = (com.tencent.open.a.b) it.next();
                            for (String str : bVar.a.keySet()) {
                                try {
                                    String str2 = bVar.a.get(str);
                                    if (str2 == null) {
                                        str2 = "";
                                    }
                                    jSONObject.put(str, str2);
                                } catch (JSONException e2) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                                }
                            }
                            jSONArray.put(jSONObject);
                        }
                        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
                        Bundle bundle = new Bundle();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("data", jSONArray);
                            bundle.putString("data", jSONObject2.toString());
                            return bundle;
                        } catch (JSONException e3) {
                            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
                            return null;
                        }
                    }

                    protected void e() {
                        this.f8159g.execute(new e());
                    }

                    public void a(Bundle bundle, String str, boolean z) {
                        if (bundle == null) {
                            return;
                        }
                        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
                        if (a("report_via", str) || z) {
                            this.f8159g.execute(new b(bundle, z));
                        }
                    }

                    public void a(String str, long j2, long j3, long j4, int i2) {
                        a(str, j2, j3, j4, i2, "", false);
                    }

                    public void a(String str, long j2, long j3, long j4, int i2, String str2, boolean z) {
                        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j2 + " | reqSize:" + j3 + " | rspSize: " + j4 + " | responseCode: " + i2 + " | detail: " + str2);
                        if (a("report_cgi", "" + i2) || z) {
                            this.f8160h.execute(new c(j2, str, str2, i2, j3, j4, z));
                        }
                    }

                    protected boolean a(String str, String str2) {
                        int a2;
                        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
                        boolean z = false;
                        if (TextUtils.isEmpty(str)) {
                            return false;
                        }
                        int i2 = 100;
                        if (str.equals("report_cgi")) {
                            try {
                                a2 = a(Integer.parseInt(str2));
                                if (this.b.nextInt(100) < a2) {
                                    z = true;
                                }
                            } catch (Exception unused) {
                                return false;
                            }
                        } else {
                            if (str.equals("report_via")) {
                                a2 = com.tencent.open.a.e.a(str2);
                                if (this.b.nextInt(100) < a2) {
                                    i2 = a2;
                                    z = true;
                                }
                            }
                            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
                            return z;
                        }
                        i2 = a2;
                        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
                        return z;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
                        if (r0 == 0) goto L6;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
                        if (r0 == 0) goto L6;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
                        r1 = r0;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    protected boolean a(java.lang.String r5, int r6) {
                        /*
                            r4 = this;
                            java.lang.String r0 = "report_cgi"
                            boolean r0 = r5.equals(r0)
                            r1 = 5
                            r2 = 0
                            r3 = 0
                            if (r0 == 0) goto L1e
                            android.content.Context r0 = com.tencent.open.utils.f.a()
                            com.tencent.open.utils.g r0 = com.tencent.open.utils.g.a(r0, r2)
                            java.lang.String r2 = "Common_CGIReportMaxcount"
                            int r0 = r0.a(r2)
                            if (r0 != 0) goto L1c
                            goto L38
                        L1c:
                            r1 = r0
                            goto L38
                        L1e:
                            java.lang.String r0 = "report_via"
                            boolean r0 = r5.equals(r0)
                            if (r0 == 0) goto L37
                            android.content.Context r0 = com.tencent.open.utils.f.a()
                            com.tencent.open.utils.g r0 = com.tencent.open.utils.g.a(r0, r2)
                            java.lang.String r2 = "Agent_ReportBatchCount"
                            int r0 = r0.a(r2)
                            if (r0 != 0) goto L1c
                            goto L38
                        L37:
                            r1 = 0
                        L38:
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            r0.<init>()
                            java.lang.String r2 = "-->availableCount, report: "
                            r0.append(r2)
                            r0.append(r5)
                            java.lang.String r5 = " | dataSize: "
                            r0.append(r5)
                            r0.append(r6)
                            java.lang.String r5 = " | maxcount: "
                            r0.append(r5)
                            r0.append(r1)
                            java.lang.String r5 = r0.toString()
                            java.lang.String r0 = "openSDK_LOG.ReportManager"
                            com.tencent.open.log.SLog.d(r0, r5)
                            if (r6 < r1) goto L62
                            r5 = 1
                            return r5
                        L62:
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.a.g.a(java.lang.String, int):boolean");
                    }

                    protected int a(int i2) {
                        if (i2 == 0) {
                            int a2 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencySuccess");
                            if (a2 == 0) {
                                return 10;
                            }
                            return a2;
                        }
                        int a3 = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_CGIReportFrequencyFailed");
                        if (a3 == 0) {
                            return 100;
                        }
                        return a3;
                    }

                    public void a(String str, String str2, Bundle bundle, boolean z) {
                        j.a(new f(this, bundle, str, z, str2));
                    }
                }

package com.bytedance.sdk.adnet.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class Request<T> implements Comparable<Request<T>> {
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_DEPRECATED_GET_OR_POST = -1;
    public static final int METHOD_GET = 0;
    public static final int METHOD_HEAD = 4;
    public static final int METHOD_OPTIONS = 5;
    public static final int METHOD_PATCH = 7;
    public static final int METHOD_POST = 1;
    public static final int METHOD_PUT = 2;
    public static final int METHOD_TRACE = 6;
    @Nullable
    @GuardedBy("mLock")
    protected m.a<T> a;
    protected Handler b;
    private final o.a c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1217d;

    /* renamed from: e  reason: collision with root package name */
    private String f1218e;

    /* renamed from: f  reason: collision with root package name */
    private String f1219f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1220g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f1221h;

    /* renamed from: i  reason: collision with root package name */
    private Integer f1222i;

    /* renamed from: j  reason: collision with root package name */
    private l f1223j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1224k;
    @GuardedBy("mLock")

    /* renamed from: l  reason: collision with root package name */
    private boolean f1225l;
    @GuardedBy("mLock")
    private boolean m;
    private boolean n;
    private com.bytedance.sdk.adnet.face.d o;
    private a.C0044a p;
    private Object q;
    private long r;
    private long s;
    private boolean t;
    private String u;
    private Map<String, Object> v;
    @GuardedBy("mLock")
    private a w;

    /* loaded from: classes.dex */
    interface a {
        void a(Request<?> request);

        void a(Request<?> request, m<?> mVar);
    }

    /* loaded from: classes.dex */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    @Deprecated
    public Request(String str, m.a aVar) {
        this(-1, str, aVar);
    }

    private static int b(String str) {
        Uri parse;
        String host;
        try {
            if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
                return 0;
            }
            return host.hashCode();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract m<T> a(i iVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public VAdError a(VAdError vAdError) {
        return vAdError;
    }

    protected void a(long j2, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(m<T> mVar);

    public Request addExtra(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (this.v == null) {
                this.v = new HashMap();
            }
            this.v.put(str, obj);
        }
        return this;
    }

    public void addMarker(String str) {
        if (o.a.a) {
            this.c.a(str, Thread.currentThread().getId());
        }
    }

    public void build(l lVar) {
        if (lVar != null) {
            lVar.a(this);
        }
    }

    protected Map<String, String> c() throws com.bytedance.sdk.adnet.err.a {
        return null;
    }

    @CallSuper
    public void cancel() {
        synchronized (this.f1221h) {
            this.f1225l = true;
            this.a = null;
        }
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    protected String d() {
        return "UTF-8";
    }

    public void deliverError(m<T> mVar) {
        m.a<T> aVar;
        synchronized (this.f1221h) {
            aVar = this.a;
        }
        if (aVar != null) {
            aVar.b(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        a aVar;
        synchronized (this.f1221h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Nullable
    public m.a getBaseListener() {
        m.a<T> aVar;
        synchronized (this.f1221h) {
            aVar = this.a;
        }
        return aVar;
    }

    public byte[] getBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> c = c();
        if (c == null || c.size() <= 0) {
            return null;
        }
        return a(c, d());
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + d();
    }

    public a.C0044a getCacheEntry() {
        return this.p;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        return Integer.toString(method) + '-' + url;
    }

    public Map<String, Object> getExtra() {
        return this.v;
    }

    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        return Collections.emptyMap();
    }

    public String getIpAddrStr() {
        return this.u;
    }

    public int getMethod() {
        return this.f1217d;
    }

    public long getNetDuration() {
        return this.s;
    }

    @Deprecated
    public byte[] getPostBody() throws com.bytedance.sdk.adnet.err.a {
        Map<String, String> a2 = a();
        if (a2 == null || a2.size() <= 0) {
            return null;
        }
        return a(a2, b());
    }

    public b getPriority() {
        return b.NORMAL;
    }

    public final l getRequestQueue() {
        return this.f1223j;
    }

    public com.bytedance.sdk.adnet.face.d getRetryPolicy() {
        return this.o;
    }

    public final int getSequence() {
        Integer num = this.f1222i;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public long getStartTime() {
        return this.r;
    }

    public Object getTag() {
        return this.q;
    }

    public final int getTimeoutMs() {
        return getRetryPolicy().a();
    }

    public int getTrafficStatsTag() {
        return this.f1220g;
    }

    public String getUrl() {
        return this.f1218e;
    }

    public String getUserAgent() {
        return this.f1219f;
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.f1221h) {
            z = this.m;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f1221h) {
            z = this.f1225l;
        }
        return z;
    }

    public boolean isResponseOnMain() {
        return this.t;
    }

    public void markDelivered() {
        synchronized (this.f1221h) {
            this.m = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(a.C0044a c0044a) {
        this.p = c0044a;
        return this;
    }

    public void setIpAddrStr(String str) {
        this.u = str;
    }

    public void setNetDuration(long j2) {
        this.s = j2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(l lVar) {
        this.f1223j = lVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setResponseOnMain(boolean z) {
        this.t = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(com.bytedance.sdk.adnet.face.d dVar) {
        this.o = dVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i2) {
        this.f1222i = Integer.valueOf(i2);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.f1224k = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.n = z;
        return this;
    }

    public void setStartTime() {
        this.r = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.q = obj;
        return this;
    }

    public void setUrl(String str) {
        this.f1218e = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setUserAgent(String str) {
        this.f1219f = str;
        return this;
    }

    public final boolean shouldCache() {
        return this.f1224k;
    }

    public final boolean shouldRetryServerErrors() {
        return this.n;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(getTrafficStatsTag());
        StringBuilder sb = new StringBuilder();
        sb.append(isCanceled() ? "[X] " : "[ ] ");
        sb.append(getUrl());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(getPriority());
        sb.append(" ");
        sb.append(this.f1222i);
        return sb.toString();
    }

    public Request(int i2, String str, @Nullable m.a aVar) {
        this.c = o.a.a ? new o.a() : null;
        this.f1219f = "VADNetAgent/0";
        this.f1221h = new Object();
        this.f1224k = true;
        this.f1225l = false;
        this.m = false;
        this.n = false;
        this.p = null;
        this.r = 0L;
        this.s = 0L;
        this.t = true;
        this.b = new Handler(Looper.getMainLooper());
        this.f1217d = i2;
        this.f1218e = str;
        this.a = aVar;
        setRetryPolicy(new e());
        this.f1220g = b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final String str) {
        l lVar = this.f1223j;
        if (lVar != null) {
            lVar.c(this);
        }
        if (o.a.a) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.b.post(new Runnable() { // from class: com.bytedance.sdk.adnet.core.Request.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Request.this.c.a(str, id);
                        Request.this.c.a(Request.this.toString());
                    }
                });
                return;
            }
            this.c.a(str, id);
            this.c.a(toString());
        }
    }

    public int compareTo(Request<T> request) {
        b priority = getPriority();
        b priority2 = request.getPriority();
        return priority == priority2 ? this.f1222i.intValue() - request.f1222i.intValue() : priority2.ordinal() - priority.ordinal();
    }

    @Deprecated
    protected String b() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(m<?> mVar) {
        a aVar;
        synchronized (this.f1221h) {
            aVar = this.w;
        }
        if (aVar != null) {
            aVar.a(this, mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        l lVar = this.f1223j;
        if (lVar != null) {
            lVar.a(this, i2);
        }
    }

    @Deprecated
    protected Map<String, String> a() throws com.bytedance.sdk.adnet.err.a {
        return c();
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue(), str));
                    sb.append('&');
                } else {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        synchronized (this.f1221h) {
            this.w = aVar;
        }
    }
}

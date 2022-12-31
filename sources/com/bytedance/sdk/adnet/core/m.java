package com.bytedance.sdk.adnet.core;

import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import java.util.Map;
/* compiled from: Response.java */
/* loaded from: classes.dex */
public class m<T> {
    public final T a;
    public final a.C0044a b;
    public final VAdError c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1254d;

    /* renamed from: e  reason: collision with root package name */
    public long f1255e;

    /* renamed from: f  reason: collision with root package name */
    public long f1256f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, Object> f1257g;

    /* renamed from: h  reason: collision with root package name */
    public long f1258h;

    /* compiled from: Response.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(m<T> mVar);

        void b(m<T> mVar);
    }

    private m(T t, a.C0044a c0044a) {
        this.f1254d = false;
        this.f1255e = 0L;
        this.f1256f = 0L;
        this.f1258h = 0L;
        this.a = t;
        this.b = c0044a;
        this.c = null;
        if (c0044a != null) {
            this.f1258h = c0044a.a;
        }
    }

    public static <T> m<T> a(T t, a.C0044a c0044a) {
        return new m<>(t, c0044a);
    }

    public m b(long j2) {
        this.f1256f = j2;
        return this;
    }

    public static <T> m<T> a(VAdError vAdError) {
        return new m<>(vAdError);
    }

    public boolean a() {
        return this.c == null;
    }

    public m a(long j2) {
        this.f1255e = j2;
        return this;
    }

    public String a(String str, @Nullable String str2) {
        Map<String, String> map;
        String str3;
        a.C0044a c0044a = this.b;
        return (c0044a == null || (map = c0044a.f1265h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    private m(VAdError vAdError) {
        i iVar;
        this.f1254d = false;
        this.f1255e = 0L;
        this.f1256f = 0L;
        this.f1258h = 0L;
        this.a = null;
        this.b = null;
        this.c = vAdError;
        if (0 != 0 || vAdError == null || (iVar = vAdError.networkResponse) == null) {
            return;
        }
        this.f1258h = iVar.a;
    }
}

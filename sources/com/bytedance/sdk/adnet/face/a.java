package com.bytedance.sdk.adnet.face;

import com.bytedance.sdk.adnet.core.Header;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* compiled from: ICache.java */
/* loaded from: classes.dex */
public interface a {

    /* compiled from: ICache.java */
    /* renamed from: com.bytedance.sdk.adnet.face.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0044a {
        public int a;
        public byte[] b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public long f1261d;

        /* renamed from: e  reason: collision with root package name */
        public long f1262e;

        /* renamed from: f  reason: collision with root package name */
        public long f1263f;

        /* renamed from: g  reason: collision with root package name */
        public long f1264g;

        /* renamed from: h  reason: collision with root package name */
        public Map<String, String> f1265h = Collections.emptyMap();

        /* renamed from: i  reason: collision with root package name */
        public List<Header> f1266i;

        public boolean a() {
            return this.f1263f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f1264g < System.currentTimeMillis();
        }
    }

    C0044a a(String str);

    void a();

    void a(String str, C0044a c0044a);
}

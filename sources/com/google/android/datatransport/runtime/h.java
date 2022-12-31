package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.a;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: EventInternal.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class h {

    /* compiled from: EventInternal.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public final a a(String str, int i2) {
            e().put(str, String.valueOf(i2));
            return this;
        }

        public final a b(String str, long j2) {
            e().put(str, String.valueOf(j2));
            return this;
        }

        public final a c(String str, String str2) {
            e().put(str, str2);
            return this;
        }

        public abstract h d();

        protected abstract Map<String, String> e();

        protected abstract a f(Map<String, String> map);

        public abstract a g(Integer num);

        public abstract a h(g gVar);

        public abstract a i(long j2);

        public abstract a j(String str);

        public abstract a k(long j2);
    }

    public static a a() {
        a.b bVar = new a.b();
        bVar.f(new HashMap());
        return bVar;
    }

    public final String b(String str) {
        String str2 = c().get(str);
        return str2 == null ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, String> c();

    @Nullable
    public abstract Integer d();

    public abstract g e();

    public abstract long f();

    public final int g(String str) {
        String str2 = c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long h(String str) {
        String str2 = c().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> i() {
        return Collections.unmodifiableMap(c());
    }

    public abstract String j();

    public abstract long k();

    public a l() {
        a.b bVar = new a.b();
        bVar.j(j());
        bVar.g(d());
        bVar.h(e());
        bVar.i(f());
        bVar.k(k());
        bVar.f(new HashMap(c()));
        return bVar;
    }
}

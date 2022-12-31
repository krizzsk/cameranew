package us.pinguo.processor;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: MakeKls.kt */
/* loaded from: classes6.dex */
public final class d {
    private final String a;
    private final String b;
    private final List<f> c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11759d;

    public d(String key, String params, List<f> makeTextures, boolean z) {
        s.h(key, "key");
        s.h(params, "params");
        s.h(makeTextures, "makeTextures");
        this.a = key;
        this.b = params;
        this.c = makeTextures;
        this.f11759d = z;
    }

    public final String a() {
        return this.a;
    }

    public final List<f> b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final boolean d() {
        return this.f11759d;
    }

    public final void e(boolean z) {
        this.f11759d = z;
    }

    public /* synthetic */ d(String str, String str2, List list, boolean z, int i2, o oVar) {
        this(str, str2, (i2 & 4) != 0 ? u.h() : list, (i2 & 8) != 0 ? false : z);
    }
}

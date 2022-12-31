package us.pinguo.processor;

import android.graphics.Bitmap;
import kotlin.jvm.internal.s;
/* compiled from: MakeKls.kt */
/* loaded from: classes6.dex */
public final class f {
    private final int a;
    private final String b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f11760d;

    public f(int i2, String path, int i3, Bitmap bitmap) {
        s.h(path, "path");
        this.a = i2;
        this.b = path;
        this.c = i3;
        this.f11760d = bitmap;
    }

    public final Bitmap a() {
        return this.f11760d;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }
}

package us.pinguo.common.helper;

import kotlin.jvm.b.r;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.util.v;
/* compiled from: SegmentationHelper.kt */
/* loaded from: classes4.dex */
public final class SegmentationTask {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9918f = s.q(v.e("sky_change"), "/");
    private String a;
    private volatile r<? super String, ? super Boolean, ? super String, ? super Integer, u> b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private int f9919d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f9920e;

    public SegmentationTask(String srcPath, r<? super String, ? super Boolean, ? super String, ? super Integer, u> rVar) {
        s.h(srcPath, "srcPath");
        this.a = srcPath;
        this.b = rVar;
    }

    public final void a() {
        this.f9920e = true;
        this.b = null;
    }

    public final int b() {
        return this.f9919d;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation<? super kotlin.u> r20) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.helper.SegmentationTask.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void f(int i2) {
        this.f9919d = i2;
    }

    public final void g(String str) {
        this.c = str;
    }

    public final void h(String str) {
        s.h(str, "<set-?>");
        this.a = str;
    }
}

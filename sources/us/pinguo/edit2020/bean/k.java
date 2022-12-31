package us.pinguo.edit2020.bean;

import android.graphics.PointF;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.viewmodel.module.BoldType;
/* compiled from: BodyShapingFunction.kt */
/* loaded from: classes4.dex */
public class k implements x {
    private final String a;
    private final String b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10214d;

    /* renamed from: e  reason: collision with root package name */
    private transient boolean f10215e;

    /* renamed from: f  reason: collision with root package name */
    private transient BoldType f10216f;

    /* renamed from: g  reason: collision with root package name */
    private transient float f10217g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10218h;

    /* renamed from: i  reason: collision with root package name */
    private transient PointF f10219i;

    /* renamed from: j  reason: collision with root package name */
    private transient PointF f10220j;

    /* renamed from: k  reason: collision with root package name */
    private transient PointF f10221k;

    /* renamed from: l  reason: collision with root package name */
    private transient PointF f10222l;
    private transient kotlin.jvm.b.s<? super PointF, ? super PointF, ? super Float, ? super Boolean, ? super Float, kotlin.u> m;
    private String n;
    private boolean o;

    public k(String key, String name, int i2, boolean z) {
        kotlin.jvm.internal.s.h(key, "key");
        kotlin.jvm.internal.s.h(name, "name");
        this.a = key;
        this.b = name;
        this.c = i2;
        this.f10214d = z;
        this.f10215e = true;
        this.f10216f = BoldType.BOLD;
        this.f10217g = us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.body_shape_line_width);
        this.n = "";
    }

    public final void A(float f2) {
        this.f10217g = f2;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return this.f10214d;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        return this.b;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return this.c;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        return this.f10218h;
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a;
    }

    public final BoldType g() {
        return this.f10216f;
    }

    public final PointF h() {
        return this.f10220j;
    }

    public final String i() {
        return this.n;
    }

    public final boolean j() {
        return this.o;
    }

    public final PointF k() {
        return this.f10222l;
    }

    public final PointF l() {
        return this.f10221k;
    }

    public final boolean m() {
        return this.f10215e;
    }

    public final kotlin.jvm.b.s<PointF, PointF, Float, Boolean, Float, kotlin.u> n() {
        return this.m;
    }

    public final PointF o() {
        return this.f10219i;
    }

    public final float p() {
        return this.f10217g;
    }

    public final void q(boolean z) {
        this.f10218h = z;
    }

    public final void r(BoldType boldType) {
        kotlin.jvm.internal.s.h(boldType, "<set-?>");
        this.f10216f = boldType;
    }

    public final void s(PointF pointF) {
        this.f10220j = pointF;
    }

    public final void t(String str) {
        kotlin.jvm.internal.s.h(str, "<set-?>");
        this.n = str;
    }

    public final void u(boolean z) {
        this.o = z;
    }

    public final void v(PointF pointF) {
        this.f10222l = pointF;
    }

    public final void w(PointF pointF) {
        this.f10221k = pointF;
    }

    public final void x(boolean z) {
        this.f10215e = z;
    }

    public final void y(kotlin.jvm.b.s<? super PointF, ? super PointF, ? super Float, ? super Boolean, ? super Float, kotlin.u> sVar) {
        this.m = sVar;
    }

    public final void z(PointF pointF) {
        this.f10219i = pointF;
    }
}

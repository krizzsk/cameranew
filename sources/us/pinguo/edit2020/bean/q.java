package us.pinguo.edit2020.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import kotlin.Triple;
import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.BeautyEditData;
/* compiled from: Facial3dFunction.kt */
/* loaded from: classes4.dex */
public final class q implements x {

    /* renamed from: g  reason: collision with root package name */
    public static final a f10240g = new a(null);

    /* renamed from: h  reason: collision with root package name */
    private static final Triple<Integer, Integer, Integer> f10241h = new Triple<>(0, 50, 0);

    /* renamed from: i  reason: collision with root package name */
    private static final ArrayList<String> f10242i;
    private final BeautyEditData a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10243d;

    /* renamed from: e  reason: collision with root package name */
    private int f10244e;

    /* renamed from: f  reason: collision with root package name */
    private int f10245f;

    /* compiled from: Facial3dFunction.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final String a(String key) {
            kotlin.jvm.internal.s.h(key, "key");
            return (!kotlin.jvm.internal.s.c(key, "yanjing") && kotlin.jvm.internal.s.c(key, "lianjia")) ? "contour" : TypedValues.Custom.S_COLOR;
        }

        public final Triple<Integer, Integer, Integer> b() {
            return q.f10241h;
        }

        public final Facial3DFunctionConfig c(String key) {
            kotlin.jvm.internal.s.h(key, "key");
            return kotlin.jvm.internal.s.c(key, "quanbuliti") ? Facial3DFunctionConfig.ALL3D : q.f10242i.contains(key) ? Facial3DFunctionConfig.ONLY3D : Facial3DFunctionConfig.COLOR_AND_3D;
        }
    }

    static {
        ArrayList<String> f2;
        f2 = kotlin.collections.u.f("etou", "xiahe", "meimao", "bizi");
        f10242i = f2;
    }

    public q(BeautyEditData beautyData) {
        kotlin.jvm.internal.s.h(beautyData, "beautyData");
        this.a = beautyData;
        this.b = beautyData.getMinValue();
        this.c = beautyData.getMaxValue();
        this.f10243d = beautyData.getDefaultValue();
        this.f10244e = beautyData.getDefaultValue();
        this.f10245f = beautyData.getDefaultValue();
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        return us.pinguo.foundation.utils.i.c();
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        String string = us.pinguo.foundation.e.b().getString(this.a.getBeautyName());
        kotlin.jvm.internal.s.g(string, "getAppContext().getString(beautyData.beautyName)");
        return string;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return this.a.getBeautyIcon();
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean e() {
        int i2 = this.f10244e;
        int i3 = this.f10243d;
        return (i2 == i3 && this.f10245f == i3) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && kotlin.jvm.internal.s.c(this.a, ((q) obj).a);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        return this.a.getBeautyKey();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public final BeautyEditData i() {
        return this.a;
    }

    public final int j() {
        return this.f10244e;
    }

    public final int k() {
        return this.f10245f;
    }

    public final int l() {
        return this.f10243d;
    }

    public final int m() {
        return this.c;
    }

    public final int n() {
        return this.b;
    }

    public final void o(int i2) {
        this.f10244e = i2;
    }

    public final void p(int i2) {
        this.f10245f = i2;
    }

    public String toString() {
        return "Facial3dFunction(beautyData=" + this.a + ')';
    }
}

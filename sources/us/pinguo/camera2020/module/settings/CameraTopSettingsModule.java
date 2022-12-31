package us.pinguo.camera2020.module.settings;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.model.render.UnityRender;
import us.pinguo.cameramanger.e;
import us.pinguo.cameramanger.info.Flash;
import us.pinguo.repository2020.m;
import us.pinguo.repository2020.u;
/* compiled from: CameraTopSettingsModule.kt */
/* loaded from: classes3.dex */
public final class CameraTopSettingsModule implements LifecycleObserver {
    private final e a;
    private final UnityRender b;
    private final u<Integer> c;

    /* renamed from: d  reason: collision with root package name */
    private final LiveData<Integer> f9235d;

    /* renamed from: e  reason: collision with root package name */
    private int f9236e;

    /* renamed from: f  reason: collision with root package name */
    private final u<Boolean> f9237f;

    /* renamed from: g  reason: collision with root package name */
    private final LiveData<Boolean> f9238g;

    /* renamed from: h  reason: collision with root package name */
    private final MutableLiveData<Boolean> f9239h;

    /* renamed from: i  reason: collision with root package name */
    private final LiveData<Boolean> f9240i;

    /* renamed from: j  reason: collision with root package name */
    private final MutableLiveData<Boolean> f9241j;

    /* renamed from: k  reason: collision with root package name */
    private final LiveData<Boolean> f9242k;

    /* renamed from: l  reason: collision with root package name */
    private final u<Boolean> f9243l;
    private final LiveData<Boolean> m;
    private final u<Boolean> n;
    private final LiveData<Boolean> o;
    private final u<Boolean> p;
    private final LiveData<Boolean> q;
    private final u<Boolean> r;
    private final LiveData<Boolean> s;
    private final u<Integer> t;
    private final LiveData<Integer> u;
    private final u<Boolean> v;
    private final u<Integer> w;

    public CameraTopSettingsModule(e cameraManager, UnityRender unityRender) {
        s.h(cameraManager, "cameraManager");
        s.h(unityRender, "unityRender");
        this.a = cameraManager;
        this.b = unityRender;
        m mVar = m.a;
        u<Integer> i2 = mVar.i();
        this.c = i2;
        this.f9235d = i2;
        this.f9236e = 4;
        Boolean bool = Boolean.TRUE;
        u<Boolean> uVar = new u<>(bool);
        this.f9237f = uVar;
        this.f9238g = uVar;
        MutableLiveData<Boolean> t = mVar.t();
        this.f9239h = t;
        this.f9240i = t;
        MutableLiveData<Boolean> s = mVar.s();
        this.f9241j = s;
        this.f9242k = s;
        u<Boolean> x = mVar.x();
        this.f9243l = x;
        this.m = x;
        u<Boolean> uVar2 = new u<>(bool);
        this.n = uVar2;
        this.o = uVar2;
        u<Boolean> b = mVar.b();
        this.p = b;
        this.q = b;
        u<Boolean> uVar3 = new u<>(bool);
        this.r = uVar3;
        this.s = uVar3;
        u<Integer> u = mVar.u();
        this.t = u;
        this.u = u;
        this.v = mVar.y();
        this.w = mVar.g();
    }

    private final void o(int i2) {
        if (s.c(this.v.getValue(), Boolean.TRUE)) {
            if (i2 == 0) {
                this.a.a(Flash.OFF);
            } else if (i2 != 1) {
            } else {
                this.a.a(Flash.OFF);
            }
        } else if (i2 == 0) {
            this.a.a(Flash.OFF);
        } else if (i2 == 1) {
            this.a.a(Flash.ON);
        } else if (i2 == 2) {
            this.a.a(Flash.AUTO);
        } else if (i2 != 3) {
        } else {
            this.a.f(true);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void removeStickerObservation(LifecycleOwner lifecycleOwner) {
    }

    public static /* synthetic */ void u(CameraTopSettingsModule cameraTopSettingsModule, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = null;
        }
        cameraTopSettingsModule.t(bool);
    }

    public static /* synthetic */ void w(CameraTopSettingsModule cameraTopSettingsModule, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        cameraTopSettingsModule.v(num);
    }

    public final void a(boolean z) {
        Boolean value = this.n.getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        if (value.booleanValue() == z) {
            return;
        }
        this.n.postValue(Boolean.valueOf(z));
        this.b.z0(z && s.c(this.f9243l.getValue(), Boolean.TRUE));
    }

    public final void b(boolean z) {
        Boolean value = this.f9237f.getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        if (value.booleanValue() == z) {
            return;
        }
        this.f9237f.setValue(Boolean.valueOf(z));
        o(((!z || (r3 = this.c.getValue()) == null) ? 0 : 0).intValue());
    }

    public final void c(boolean z) {
        Boolean value = this.f9241j.getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        if (value.booleanValue() == z) {
            return;
        }
        this.f9241j.postValue(Boolean.valueOf(z));
    }

    public final LiveData<Boolean> d() {
        return this.s;
    }

    public final LiveData<Boolean> e() {
        return this.q;
    }

    public final u<Integer> f() {
        return this.w;
    }

    public final LiveData<Boolean> g() {
        return this.m;
    }

    public final LiveData<Boolean> h() {
        return this.o;
    }

    public final LiveData<Boolean> i() {
        return this.f9238g;
    }

    public final LiveData<Integer> j() {
        return this.f9235d;
    }

    public final LiveData<Boolean> k() {
        return this.f9242k;
    }

    public final LiveData<Boolean> l() {
        return this.f9240i;
    }

    public final LiveData<Integer> m() {
        return this.u;
    }

    public final u<Boolean> n() {
        return this.v;
    }

    public final void p(int i2) {
        this.f9236e = i2;
    }

    public final void q(int i2) {
        this.t.setValue(Integer.valueOf(i2));
    }

    public final void r(boolean z) {
        Boolean value = this.p.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        if (z != value.booleanValue()) {
            this.p.setValue(Boolean.valueOf(z));
        }
    }

    public final void s() {
        u<Boolean> uVar = this.v;
        Boolean value = uVar.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        uVar.setValue(Boolean.valueOf(!value.booleanValue()));
    }

    public final void t(Boolean bool) {
        Boolean value = this.f9243l.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        if (bool == null) {
            boolean z = !booleanValue;
            this.f9243l.postValue(Boolean.valueOf(z));
            this.b.z0(z);
            return;
        }
        if (!s.c(bool, Boolean.valueOf(booleanValue))) {
            this.f9243l.postValue(bool);
        }
        this.b.z0(bool.booleanValue());
    }

    public final void v(Integer num) {
        Integer value = this.c.getValue();
        if (value == null) {
            value = 0;
        }
        int intValue = value.intValue();
        if (num == null) {
            int i2 = (intValue + 1) % this.f9236e;
            this.c.postValue(Integer.valueOf(i2));
            o(i2);
            return;
        }
        if (intValue != num.intValue()) {
            this.c.postValue(num);
        }
        o(num.intValue());
    }

    public final void x() {
        Boolean value = this.f9239h.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        this.f9239h.setValue(Boolean.valueOf(!value.booleanValue()));
    }
}

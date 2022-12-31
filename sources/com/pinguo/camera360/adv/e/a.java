package com.pinguo.camera360.adv.e;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.pinguo.camera360.adv.e.c.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import us.pinguo.admobvista.AdvPGManager;
import us.pinguo.admobvista.d.a;
import us.pinguo.advsdk.a.l;
import us.pinguo.advsdk.manager.f;
/* compiled from: PGAdvPresenter.java */
/* loaded from: classes3.dex */
public class a implements l {
    private Context a;
    private String b;
    private WeakReference<ViewGroup> c;

    /* renamed from: d  reason: collision with root package name */
    private f f6152d;

    /* renamed from: e  reason: collision with root package name */
    private InterfaceC0236a f6153e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, Object> f6154f;

    /* renamed from: g  reason: collision with root package name */
    a.InterfaceC0352a f6155g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<Activity> f6156h;

    /* compiled from: PGAdvPresenter.java */
    /* renamed from: com.pinguo.camera360.adv.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0236a {
        void a(int i2, String str);

        void onSuccess();
    }

    public a(Context context, String str, ViewGroup viewGroup) {
        this.a = context.getApplicationContext();
        this.b = str;
        this.c = new WeakReference<>(viewGroup);
        c();
    }

    private void a(us.pinguo.advsdk.a.b bVar) {
        if (this.c.get() == null) {
            us.pinguo.advsdk.utils.b.a("PGAdvPresenter onPGNativeSuccess activity destroy ");
            return;
        }
        us.pinguo.advsdk.utils.b.a("onPGNativeSuccess");
        WeakReference<Activity> weakReference = this.f6156h;
        if (weakReference != null && weakReference.get() != null) {
            c a = b.a(this.f6156h.get(), bVar, this.c.get(), this.b);
            if (a != null) {
                a.c(this.f6154f);
                a.d(this.f6155g);
                a.a();
            }
            InterfaceC0236a interfaceC0236a = this.f6153e;
            if (interfaceC0236a != null) {
                interfaceC0236a.onSuccess();
                return;
            }
            return;
        }
        us.pinguo.advsdk.utils.b.a("noActivity Found");
    }

    private void c() {
        f loadEngin = AdvPGManager.getInstance().getLoadEngin(this.a, this.b);
        this.f6152d = loadEngin;
        if (loadEngin == null) {
            return;
        }
        loadEngin.B(this);
    }

    public void b() {
        f fVar = this.f6152d;
        if (fVar != null) {
            fVar.B(null);
        }
    }

    public void d(l lVar) {
        f fVar = this.f6152d;
        if (fVar != null) {
            fVar.B(lVar);
            this.f6152d.r(this.a, false);
        } else if (lVar != null) {
            lVar.onPGNativeFailed(0, "ad closed");
        }
    }

    public void e(InterfaceC0236a interfaceC0236a) {
        this.f6153e = interfaceC0236a;
    }

    public void f(a.InterfaceC0352a interfaceC0352a) {
        this.f6155g = interfaceC0352a;
    }

    public void g(Activity activity) {
        if (this.f6152d == null) {
            return;
        }
        this.f6156h = new WeakReference<>(activity);
        this.f6152d.B(this);
        this.f6152d.r(activity, false);
    }

    public void h(Activity activity, us.pinguo.advsdk.a.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f6156h = new WeakReference<>(activity);
        a(bVar);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onAdDestroy(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeClick(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeFailed(int i2, String str) {
        InterfaceC0236a interfaceC0236a = this.f6153e;
        if (interfaceC0236a != null) {
            interfaceC0236a.a(i2, str);
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeSuccess(us.pinguo.advsdk.a.b bVar) {
        a(bVar);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoClose(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoFailed(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoSuccess(us.pinguo.advsdk.a.b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadFailed(int i2, String str) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadSuccess(us.pinguo.advsdk.a.b bVar) {
    }
}

package us.pinguo.admobvista.d;

import android.app.Activity;
import android.view.ViewGroup;
import java.util.Map;
/* compiled from: AbsNativeLayout.java */
/* loaded from: classes3.dex */
public abstract class a {
    protected ViewGroup a;
    protected Activity b;
    protected InterfaceC0352a c;

    /* renamed from: d  reason: collision with root package name */
    protected Map<String, Object> f9004d;

    /* compiled from: AbsNativeLayout.java */
    /* renamed from: us.pinguo.admobvista.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0352a {
        void onShow();
    }

    public a(Activity activity, ViewGroup viewGroup) {
        this.b = activity;
        this.a = viewGroup;
    }

    public abstract void a();

    public void b() {
        InterfaceC0352a interfaceC0352a = this.c;
        if (interfaceC0352a == null) {
            return;
        }
        interfaceC0352a.onShow();
    }

    public void c(Map<String, Object> map) {
        this.f9004d = map;
    }

    public void d(InterfaceC0352a interfaceC0352a) {
        this.c = interfaceC0352a;
    }
}

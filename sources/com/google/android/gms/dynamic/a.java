package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.dynamic.c;
import java.util.LinkedList;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class a<T extends c> {
    private T a;
    private Bundle b;
    private LinkedList<InterfaceC0139a> c;

    /* renamed from: d  reason: collision with root package name */
    private final e<T> f3698d = new g(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* renamed from: com.google.android.gms.dynamic.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0139a {
        void a(c cVar);

        int getState();
    }

    public static void o(FrameLayout frameLayout) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Context context = frameLayout.getContext();
        int f2 = googleApiAvailability.f(context);
        String d2 = com.google.android.gms.common.internal.e.d(context, f2);
        String c = com.google.android.gms.common.internal.e.c(context, f2);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(d2);
        linearLayout.addView(textView);
        Intent b = googleApiAvailability.b(context, f2, null);
        if (b != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(c);
            linearLayout.addView(button);
            button.setOnClickListener(new k(context, b));
        }
    }

    private final void s(Bundle bundle, InterfaceC0139a interfaceC0139a) {
        T t = this.a;
        if (t != null) {
            interfaceC0139a.a(t);
            return;
        }
        if (this.c == null) {
            this.c = new LinkedList<>();
        }
        this.c.add(interfaceC0139a);
        if (bundle != null) {
            Bundle bundle2 = this.b;
            if (bundle2 == null) {
                this.b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f3698d);
    }

    private final void u(int i2) {
        while (!this.c.isEmpty() && this.c.getLast().getState() >= i2) {
            this.c.removeLast();
        }
    }

    protected abstract void a(e<T> eVar);

    public T b() {
        return this.a;
    }

    protected void c(FrameLayout frameLayout) {
        o(frameLayout);
    }

    public void d(Bundle bundle) {
        s(bundle, new i(this, bundle));
    }

    public View e(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        s(bundle, new h(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.a == null) {
            c(frameLayout);
        }
        return frameLayout;
    }

    public void f() {
        T t = this.a;
        if (t != null) {
            t.onDestroy();
        } else {
            u(1);
        }
    }

    public void g() {
        T t = this.a;
        if (t != null) {
            t.d();
        } else {
            u(2);
        }
    }

    public void h(Activity activity, Bundle bundle, Bundle bundle2) {
        s(bundle2, new f(this, activity, bundle, bundle2));
    }

    public void i() {
        T t = this.a;
        if (t != null) {
            t.onLowMemory();
        }
    }

    public void j() {
        T t = this.a;
        if (t != null) {
            t.onPause();
        } else {
            u(5);
        }
    }

    public void k() {
        s(null, new l(this));
    }

    public void l(Bundle bundle) {
        T t = this.a;
        if (t != null) {
            t.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void m() {
        s(null, new j(this));
    }

    public void n() {
        T t = this.a;
        if (t != null) {
            t.onStop();
        } else {
            u(4);
        }
    }
}

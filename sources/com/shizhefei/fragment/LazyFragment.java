package com.shizhefei.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class LazyFragment extends BaseFragment {

    /* renamed from: f  reason: collision with root package name */
    private Bundle f7121f;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f7123h;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7120e = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7122g = true;

    /* renamed from: i  reason: collision with root package name */
    private int f7124i = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f7125j = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.shizhefei.fragment.BaseFragment
    @Deprecated
    public final void c0(Bundle bundle) {
        boolean z;
        super.c0(bundle);
        this.f7121f = bundle;
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f7122g = arguments.getBoolean("intent_boolean_lazyLoad", this.f7122g);
        }
        int i2 = this.f7124i;
        if (i2 == -1) {
            z = getUserVisibleHint();
        } else {
            z = i2 == 1;
        }
        if (this.f7122g) {
            if (z && !this.f7120e) {
                this.f7120e = true;
                f0(bundle);
                return;
            }
            LayoutInflater layoutInflater = this.a;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(a0());
            }
            FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
            this.f7123h = frameLayout;
            View e0 = e0(layoutInflater, frameLayout);
            if (e0 != null) {
                this.f7123h.addView(e0);
            }
            this.f7123h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            super.d0(this.f7123h);
            return;
        }
        this.f7120e = true;
        f0(bundle);
    }

    protected View e0(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return null;
    }

    protected void f0(Bundle bundle) {
    }

    protected void g0() {
    }

    protected void h0() {
    }

    protected void i0() {
    }

    protected void j0() {
    }

    protected void k0() {
    }

    @Override // com.shizhefei.fragment.BaseFragment, androidx.fragment.app.Fragment
    @Deprecated
    public final void onDestroyView() {
        super.onDestroyView();
        if (this.f7120e) {
            g0();
        }
        this.f7120e = false;
    }

    @Override // com.shizhefei.fragment.BaseFragment, androidx.fragment.app.Fragment
    @Deprecated
    public final void onPause() {
        super.onPause();
        if (this.f7120e) {
            j0();
        }
    }

    @Override // com.shizhefei.fragment.BaseFragment, androidx.fragment.app.Fragment
    @Deprecated
    public final void onResume() {
        super.onResume();
        if (this.f7120e) {
            k0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public final void onStart() {
        super.onStart();
        if (this.f7120e && !this.f7125j && getUserVisibleHint()) {
            this.f7125j = true;
            h0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated
    public final void onStop() {
        super.onStop();
        if (this.f7120e && this.f7125j && getUserVisibleHint()) {
            this.f7125j = false;
            i0();
        }
    }

    @Override // com.shizhefei.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.f7124i = z ? 1 : 0;
        if (z && !this.f7120e && b0() != null) {
            this.f7120e = true;
            f0(this.f7121f);
            k0();
        }
        if (!this.f7120e || b0() == null) {
            return;
        }
        if (z) {
            this.f7125j = true;
            h0();
            return;
        }
        this.f7125j = false;
        i0();
    }
}

package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.HashSet;
@Instrumented
/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {
    private com.bumptech.glide.f a;
    private final com.bumptech.glide.manager.a b;
    private final k c;

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<SupportRequestManagerFragment> f817d;

    /* renamed from: e  reason: collision with root package name */
    private SupportRequestManagerFragment f818e;

    /* loaded from: classes.dex */
    private class b implements k {
        private b(SupportRequestManagerFragment supportRequestManagerFragment) {
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void a0(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f817d.add(supportRequestManagerFragment);
    }

    private void e0(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f817d.remove(supportRequestManagerFragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.manager.a b0() {
        return this.b;
    }

    public com.bumptech.glide.f c0() {
        return this.a;
    }

    public k d0() {
        return this.c;
    }

    public void f0(com.bumptech.glide.f fVar) {
        this.a = fVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        SupportRequestManagerFragment i2 = j.f().i(getActivity().getSupportFragmentManager());
        this.f818e = i2;
        if (i2 != this) {
            i2.a0(this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        SupportRequestManagerFragment supportRequestManagerFragment = this.f818e;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.e0(this);
            this.f818e = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        com.bumptech.glide.f fVar = this.a;
        if (fVar != null) {
            fVar.s();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VdsAgent.onFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VdsAgent.onFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.b.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.b.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(com.bumptech.glide.manager.a aVar) {
        this.c = new b();
        this.f817d = new HashSet<>();
        this.b = aVar;
    }
}

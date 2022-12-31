package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.HashSet;
@Instrumented
@TargetApi(11)
/* loaded from: classes.dex */
public class RequestManagerFragment extends Fragment {
    private final com.bumptech.glide.manager.a a;
    private final k b;
    private com.bumptech.glide.f c;

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<RequestManagerFragment> f815d;

    /* renamed from: e  reason: collision with root package name */
    private RequestManagerFragment f816e;

    /* loaded from: classes.dex */
    private class b implements k {
        private b(RequestManagerFragment requestManagerFragment) {
        }
    }

    public RequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.f815d.add(requestManagerFragment);
    }

    private void e(RequestManagerFragment requestManagerFragment) {
        this.f815d.remove(requestManagerFragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.manager.a b() {
        return this.a;
    }

    public com.bumptech.glide.f c() {
        return this.c;
    }

    public k d() {
        return this.b;
    }

    public void f(com.bumptech.glide.f fVar) {
        this.c = fVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        RequestManagerFragment h2 = j.f().h(getActivity().getFragmentManager());
        this.f816e = h2;
        if (h2 != this) {
            h2.a(this);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a.b();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        RequestManagerFragment requestManagerFragment = this.f816e;
        if (requestManagerFragment != null) {
            requestManagerFragment.e(this);
            this.f816e = null;
        }
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        com.bumptech.glide.f fVar = this.c;
        if (fVar != null) {
            fVar.s();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        VdsAgent.onFragmentPause(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        VdsAgent.onFragmentResume(this);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.a.c();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.a.d();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        com.bumptech.glide.f fVar = this.c;
        if (fVar != null) {
            fVar.t(i2);
        }
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }

    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(com.bumptech.glide.manager.a aVar) {
        this.b = new b();
        this.f815d = new HashSet<>();
        this.a = aVar;
    }
}

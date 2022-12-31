package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.LinkedHashSet;
/* JADX INFO: Access modifiers changed from: package-private */
@Instrumented
/* loaded from: classes2.dex */
public abstract class PickerFragment<S> extends Fragment {
    protected final LinkedHashSet<i<S>> a = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a0(i<S> iVar) {
        return this.a.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0() {
        this.a.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
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
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

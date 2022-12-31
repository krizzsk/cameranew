package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
@Instrumented
/* loaded from: classes2.dex */
public class IronsourceLifecycleFragment extends Fragment {
    private a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Activity activity);

        void b(Activity activity);

        void c(Activity activity);
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.b(getActivity());
        }
    }

    private void b(a aVar) {
        if (aVar != null) {
            aVar.a(getActivity());
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            aVar.c(getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IronsourceLifecycleFragment d(Activity activity) {
        return (IronsourceLifecycleFragment) activity.getFragmentManager().findFragmentByTag("com.ironsource.lifecycle.IronsourceLifecycleFragment");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null || fragmentManager.findFragmentByTag("com.ironsource.lifecycle.IronsourceLifecycleFragment") != null) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        IronsourceLifecycleFragment ironsourceLifecycleFragment = new IronsourceLifecycleFragment();
        FragmentTransaction add = beginTransaction.add(ironsourceLifecycleFragment, "com.ironsource.lifecycle.IronsourceLifecycleFragment");
        VdsAgent.onFragmentTransactionAdd(beginTransaction, ironsourceLifecycleFragment, "com.ironsource.lifecycle.IronsourceLifecycleFragment", add);
        add.commit();
        fragmentManager.executePendingTransactions();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        this.a = aVar;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.a);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.a = null;
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    public void onPause() {
        VdsAgent.onFragmentPause(this);
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        VdsAgent.onFragmentResume(this);
        super.onResume();
        b(this.a);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.a);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

package com.pinguo.camera360.homepage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: ActivityUtils.kt */
/* loaded from: classes3.dex */
public final class d0 {
    public static final d0 a = new d0();

    private d0() {
    }

    public final void a(FragmentManager fragmentManager, Fragment fragment, int i2, Bundle bundle) {
        kotlin.jvm.internal.s.h(fragmentManager, "fragmentManager");
        kotlin.jvm.internal.s.h(fragment, "fragment");
        kotlin.jvm.internal.s.h(bundle, "bundle");
        fragment.setArguments(bundle);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        kotlin.jvm.internal.s.g(beginTransaction, "fragmentManager.beginTransaction()");
        VdsAgent.onFragmentTransactionAdd(beginTransaction, i2, fragment, beginTransaction.add(i2, fragment));
        beginTransaction.commitAllowingStateLoss();
    }
}

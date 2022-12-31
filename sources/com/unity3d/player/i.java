package com.unity3d.player;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
@Instrumented
/* loaded from: classes3.dex */
public final class i extends Fragment {
    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestPermissions(new String[]{getArguments().getString("PermissionNames")}, 96489);
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        VdsAgent.onFragmentPause(this);
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 96489) {
            return;
        }
        if (strArr.length == 0) {
            requestPermissions(new String[]{getArguments().getString("PermissionNames")}, 96489);
            return;
        }
        FragmentTransaction beginTransaction = getActivity().getFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.commit();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        VdsAgent.onFragmentResume(this);
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

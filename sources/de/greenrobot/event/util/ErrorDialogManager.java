package de.greenrobot.event.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import de.greenrobot.event.c;
/* loaded from: classes3.dex */
public class ErrorDialogManager {
    public static b<?> a;

    @Instrumented
    @TargetApi(11)
    /* loaded from: classes3.dex */
    public static class HoneycombManagerFragment extends Fragment {
        private c a;

        @Override // android.app.Fragment
        public void onHiddenChanged(boolean z) {
            super.onHiddenChanged(z);
            VdsAgent.onFragmentHiddenChanged(this, z);
        }

        @Override // android.app.Fragment
        public void onPause() {
            VdsAgent.onFragmentPause(this);
            this.a.m(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            VdsAgent.onFragmentResume(this);
            super.onResume();
            ErrorDialogManager.a.a.a();
            throw null;
        }

        @Override // android.app.Fragment
        public void setUserVisibleHint(boolean z) {
            super.setUserVisibleHint(z);
            VdsAgent.setFragmentUserVisibleHint(this, z);
        }
    }

    @Instrumented
    /* loaded from: classes3.dex */
    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {
        private c a;
        private boolean b;

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            ErrorDialogManager.a.a.a();
            throw null;
        }

        @Override // androidx.fragment.app.Fragment
        public void onHiddenChanged(boolean z) {
            super.onHiddenChanged(z);
            VdsAgent.onFragmentHiddenChanged(this, z);
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            VdsAgent.onFragmentPause(this);
            this.a.m(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            VdsAgent.onFragmentResume(this);
            super.onResume();
            if (this.b) {
                this.b = false;
            } else {
                ErrorDialogManager.a.a.a();
                throw null;
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void setUserVisibleHint(boolean z) {
            super.setUserVisibleHint(z);
            VdsAgent.setFragmentUserVisibleHint(this, z);
        }
    }
}

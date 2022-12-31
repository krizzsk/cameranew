package com.google.android.gms.common.api.internal;

import android.content.Intent;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
@Instrumented
/* loaded from: classes2.dex */
public final class zzc extends Fragment implements i {
    private Map<String, LifecycleCallback> a = Collections.synchronizedMap(new ArrayMap());

    static {
        new WeakHashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.b(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        for (Map.Entry<String, LifecycleCallback> entry : this.a.entrySet()) {
            entry.getValue().c(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.d();
        }
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
    public final void onResume() {
        VdsAgent.onFragmentResume(this);
        super.onResume();
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.a.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().f(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

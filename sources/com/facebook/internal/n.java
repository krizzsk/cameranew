package com.facebook.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentWrapper.java */
/* loaded from: classes.dex */
public class n {
    private Fragment a;
    private android.app.Fragment b;

    public n(Fragment fragment) {
        y.l(fragment, "fragment");
        this.a = fragment;
    }

    public final Activity a() {
        Fragment fragment = this.a;
        if (fragment != null) {
            return fragment.getActivity();
        }
        return this.b.getActivity();
    }

    public android.app.Fragment b() {
        return this.b;
    }

    public Fragment c() {
        return this.a;
    }

    public void d(Intent intent, int i2) {
        Fragment fragment = this.a;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i2);
        } else {
            this.b.startActivityForResult(intent, i2);
        }
    }

    public n(android.app.Fragment fragment) {
        y.l(fragment, "fragment");
        this.b = fragment;
    }
}

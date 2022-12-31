package com.facebook;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl;
/* compiled from: CallbackManager.java */
/* loaded from: classes.dex */
public interface d {

    /* compiled from: CallbackManager.java */
    /* loaded from: classes.dex */
    public static class a {
        public static d a() {
            return new CallbackManagerImpl();
        }
    }

    boolean onActivityResult(int i2, int i3, Intent intent);
}

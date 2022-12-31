package com.growingio.android.sdk.debugger;

import android.net.Uri;
/* loaded from: classes2.dex */
public interface DebuggerEventListener {
    void onExit();

    void onFirstLaunch(Uri uri);

    void onLoginSuccess();

    void onPagePause();

    void onPageResume();
}

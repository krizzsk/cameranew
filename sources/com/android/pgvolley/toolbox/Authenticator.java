package com.android.pgvolley.toolbox;

import com.android.pgvolley.AuthFailureError;
/* loaded from: classes.dex */
public interface Authenticator {
    String getAuthToken() throws AuthFailureError;

    void invalidateAuthToken(String str);
}

package com.android.pgvolley;
/* loaded from: classes.dex */
public interface Network {
    NetworkResponse performRequest(Request<?> request) throws VolleyError;
}

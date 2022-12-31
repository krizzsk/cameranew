package com.android.pgvolley.toolbox;

import com.android.pgvolley.Cache;
/* loaded from: classes.dex */
public class NoCache implements Cache {
    @Override // com.android.pgvolley.Cache
    public void clear() {
    }

    @Override // com.android.pgvolley.Cache
    public Cache.Entry get(String str) {
        return null;
    }

    @Override // com.android.pgvolley.Cache
    public void initialize() {
    }

    @Override // com.android.pgvolley.Cache
    public void invalidate(String str, boolean z) {
    }

    @Override // com.android.pgvolley.Cache
    public void put(String str, Cache.Entry entry) {
    }

    @Override // com.android.pgvolley.Cache
    public void remove(String str) {
    }
}

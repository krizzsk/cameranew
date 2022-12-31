package com.android.pgvolley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.pgvolley.Cache;
import com.android.pgvolley.NetworkResponse;
import com.android.pgvolley.Request;
import com.android.pgvolley.Response;
/* loaded from: classes.dex */
public class ClearCacheRequest extends Request<Object> {
    private final Cache mCache;
    private final Runnable mCallback;

    public ClearCacheRequest(Cache cache, Runnable runnable) {
        super(0, null, null);
        this.mCache = cache;
        this.mCallback = runnable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public void deliverResponse(Object obj) {
    }

    @Override // com.android.pgvolley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }

    @Override // com.android.pgvolley.Request
    public boolean isCanceled() {
        this.mCache.clear();
        if (this.mCallback != null) {
            new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.mCallback);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.pgvolley.Request
    public Response<Object> parseNetworkResponse(NetworkResponse networkResponse) {
        return null;
    }
}

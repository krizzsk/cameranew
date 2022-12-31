package com.growingio.android.sdk.monitor.context;
/* loaded from: classes2.dex */
public class SingletonContextManager implements ContextManager {
    private final Context context = new Context();

    @Override // com.growingio.android.sdk.monitor.context.ContextManager
    public void clear() {
        this.context.clear();
    }

    @Override // com.growingio.android.sdk.monitor.context.ContextManager
    public Context getContext() {
        return this.context;
    }
}

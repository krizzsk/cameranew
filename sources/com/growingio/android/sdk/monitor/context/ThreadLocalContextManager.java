package com.growingio.android.sdk.monitor.context;
/* loaded from: classes2.dex */
public class ThreadLocalContextManager implements ContextManager {
    private final ThreadLocal<Context> context = new ThreadLocal<Context>() { // from class: com.growingio.android.sdk.monitor.context.ThreadLocalContextManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Context initialValue() {
            return new Context();
        }
    };

    @Override // com.growingio.android.sdk.monitor.context.ContextManager
    public void clear() {
        this.context.remove();
    }

    @Override // com.growingio.android.sdk.monitor.context.ContextManager
    public Context getContext() {
        return this.context.get();
    }
}

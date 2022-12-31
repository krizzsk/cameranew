package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class a<T> implements b<T> {
    protected final DataHolder mDataHolder;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        release();
    }

    @Override // com.google.android.gms.common.data.b
    public abstract T get(int i2);

    @Override // com.google.android.gms.common.data.b
    public int getCount() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    public Bundle getMetadata() {
        return this.mDataHolder.Q();
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.mDataHolder;
        return dataHolder == null || dataHolder.isClosed();
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new c(this);
    }

    @Override // com.google.android.gms.common.api.f
    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new f(this);
    }
}

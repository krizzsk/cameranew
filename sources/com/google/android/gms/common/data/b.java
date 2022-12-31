package com.google.android.gms.common.data;

import java.io.Closeable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public interface b<T> extends com.google.android.gms.common.api.f, Closeable, Iterable<T> {
    T get(int i2);

    int getCount();
}

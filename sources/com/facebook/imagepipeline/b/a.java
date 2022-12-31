package com.facebook.imagepipeline.b;

import com.facebook.common.references.SharedReference;
import javax.annotation.Nullable;
/* compiled from: CloseableReferenceLeakTracker.java */
/* loaded from: classes.dex */
public interface a {
    void a(SharedReference<Object> sharedReference, @Nullable Throwable th);

    boolean b();
}

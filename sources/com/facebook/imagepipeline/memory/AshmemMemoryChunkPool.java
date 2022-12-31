package com.facebook.imagepipeline.memory;

import android.annotation.TargetApi;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@com.facebook.common.internal.d
@TargetApi(27)
/* loaded from: classes.dex */
public class AshmemMemoryChunkPool extends u {
    @com.facebook.common.internal.d
    public AshmemMemoryChunkPool(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var) {
        super(cVar, c0Var, d0Var);
    }

    @Override // com.facebook.imagepipeline.memory.u
    /* renamed from: E */
    public a z(int i2) {
        return new a(i2);
    }
}

package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class NativeMemoryChunkPool extends u {
    @com.facebook.common.internal.d
    public NativeMemoryChunkPool(com.facebook.common.memory.c cVar, c0 c0Var, d0 d0Var) {
        super(cVar, c0Var, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.u
    /* renamed from: E */
    public NativeMemoryChunk z(int i2) {
        return new NativeMemoryChunk(i2);
    }
}

package us.pinguo.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileIOUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileIOUtils", f = "FileIOUtils.kt", i = {0, 0, 0}, l = {194}, m = "writeFileFromBytes", n = {"file", "bytes", "append"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes6.dex */
public final class FileIOUtils$writeFileFromBytes$4 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileIOUtils$writeFileFromBytes$4(Continuation<? super FileIOUtils$writeFileFromBytes$4> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileIOUtils.h(null, null, false, this);
    }
}

package us.pinguo.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileIOUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileIOUtils", f = "FileIOUtils.kt", i = {0}, l = {26, 26}, m = "writeFileFromStream", n = {"inputStream"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class FileIOUtils$writeFileFromStream$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileIOUtils$writeFileFromStream$1(Continuation<? super FileIOUtils$writeFileFromStream$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileIOUtils.m(null, null, this);
    }
}

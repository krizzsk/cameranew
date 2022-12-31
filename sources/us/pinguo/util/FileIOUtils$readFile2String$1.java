package us.pinguo.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileIOUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileIOUtils", f = "FileIOUtils.kt", i = {}, l = {287, 287}, m = "readFile2String", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FileIOUtils$readFile2String$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileIOUtils$readFile2String$1(Continuation<? super FileIOUtils$readFile2String$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileIOUtils.g(null, this);
    }
}

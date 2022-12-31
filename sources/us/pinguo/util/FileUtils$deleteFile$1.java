package us.pinguo.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileUtils", f = "FileUtils.kt", i = {}, l = {233, 233}, m = "deleteFile", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FileUtils$deleteFile$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileUtils$deleteFile$1(Continuation<? super FileUtils$deleteFile$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileUtils.l(null, this);
    }
}

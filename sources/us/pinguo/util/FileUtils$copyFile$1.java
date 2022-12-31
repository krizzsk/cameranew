package us.pinguo.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileUtils", f = "FileUtils.kt", i = {0, 0, 1}, l = {43, 49}, m = "copyFile", n = {"srcFile", "destFile", "inStream"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes6.dex */
public final class FileUtils$copyFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileUtils$copyFile$1(Continuation<? super FileUtils$copyFile$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileUtils.c(null, null, this);
    }
}

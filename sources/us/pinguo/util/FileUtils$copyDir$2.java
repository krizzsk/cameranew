package us.pinguo.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileUtils", f = "FileUtils.kt", i = {0, 0, 1, 1, 2, 2}, l = {96, 99, 105, 109}, m = "copyDir", n = {"srcDir", "destDir", "srcDir", "destDir", "srcDir", "destDir"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes6.dex */
public final class FileUtils$copyDir$2 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileUtils$copyDir$2(Continuation<? super FileUtils$copyDir$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileUtils.a(null, null, this);
    }
}

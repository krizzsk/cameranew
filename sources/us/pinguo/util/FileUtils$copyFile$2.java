package us.pinguo.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileUtils", f = "FileUtils.kt", i = {0}, l = {63, 63, 63}, m = "copyFile", n = {"dest"}, s = {"L$0"})
/* loaded from: classes6.dex */
public final class FileUtils$copyFile$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileUtils$copyFile$2(Continuation<? super FileUtils$copyFile$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileUtils.d(null, null, this);
    }
}

package us.pinguo.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileIOUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileIOUtils", f = "FileIOUtils.kt", i = {0, 0, 0}, l = {133}, m = "writeFileFromString", n = {"file", FirebaseAnalytics.Param.CONTENT, "append"}, s = {"L$0", "L$1", "Z$0"})
/* loaded from: classes6.dex */
public final class FileIOUtils$writeFileFromString$4 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileIOUtils$writeFileFromString$4(Continuation<? super FileIOUtils$writeFileFromString$4> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileIOUtils.p(null, null, false, this);
    }
}

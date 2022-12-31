package us.pinguo.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileIOUtils.kt */
@DebugMetadata(c = "us.pinguo.util.FileIOUtils", f = "FileIOUtils.kt", i = {0, 0}, l = {107, 107}, m = "writeFileFromString", n = {FirebaseAnalytics.Param.CONTENT, "append"}, s = {"L$0", "Z$0"})
/* loaded from: classes6.dex */
public final class FileIOUtils$writeFileFromString$2 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileIOUtils$writeFileFromString$2(Continuation<? super FileIOUtils$writeFileFromString$2> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FileIOUtils.r(null, null, false, this);
    }
}

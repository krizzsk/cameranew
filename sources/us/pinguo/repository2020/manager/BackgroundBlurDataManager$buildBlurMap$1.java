package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundBlurDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BackgroundBlurDataManager$buildBlurMap$1", f = "BackgroundBlurDataManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {358, 371}, m = "invokeSuspend", n = {"backgroundBlurMaterialTables", "backgroundBlur", "pid", "backgroundBlurMaterialTables", "backgroundBlurShape", "pid"}, s = {"L$0", "L$2", "L$3", "L$0", "L$2", "L$3"})
/* loaded from: classes6.dex */
public final class BackgroundBlurDataManager$buildBlurMap$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackgroundBlurDataManager$buildBlurMap$1(Continuation<? super BackgroundBlurDataManager$buildBlurMap$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundBlurDataManager$buildBlurMap$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundBlurDataManager$buildBlurMap$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0187  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x01e1 -> B:109:0x01e7). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00ae -> B:47:0x00fc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00e5 -> B:46:0x00ed). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:99:0x01b8 -> B:110:0x01f4). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BackgroundBlurDataManager$buildBlurMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

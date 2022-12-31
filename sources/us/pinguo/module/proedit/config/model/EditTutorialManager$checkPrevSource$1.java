package us.pinguo.module.proedit.config.model;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* compiled from: EditTutorialManager.kt */
@DebugMetadata(c = "us.pinguo.module.proedit.config.model.EditTutorialManager$checkPrevSource$1", f = "EditTutorialManager.kt", i = {0, 0, 1}, l = {66, 67}, m = "invokeSuspend", n = {"prevSourceList", "s", "prevSourceList"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes5.dex */
final class EditTutorialManager$checkPrevSource$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EditTutorialManager$checkPrevSource$1(Continuation<? super EditTutorialManager$checkPrevSource$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditTutorialManager$checkPrevSource$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditTutorialManager$checkPrevSource$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0082 -> B:11:0x0048). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            int r1 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$0
            java.lang.String[] r5 = (java.lang.String[]) r5
            kotlin.j.b(r10)
            r10 = r5
            r5 = r9
            r8 = r4
            r4 = r1
            r1 = r8
            goto L48
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            int r1 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r9.L$0
            java.lang.String[] r6 = (java.lang.String[]) r6
            kotlin.j.b(r10)
            r7 = r5
            r5 = r9
            r8 = r4
            r4 = r1
            r1 = r8
            goto L63
        L3c:
            kotlin.j.b(r10)
            us.pinguo.edit2020.manager.TutorialDownloadManager r10 = us.pinguo.edit2020.manager.TutorialDownloadManager.a
            java.lang.String[] r10 = r10.e()
            r1 = 0
            int r4 = r10.length
            r5 = r9
        L48:
            if (r1 >= r4) goto L84
            r6 = r10[r1]
            int r1 = r1 + 1
            r5.L$0 = r10
            r5.L$1 = r6
            r5.I$0 = r1
            r5.I$1 = r4
            r5.label = r3
            java.lang.Object r7 = us.pinguo.util.FileUtils.o(r6, r5)
            if (r7 != r0) goto L5f
            return r0
        L5f:
            r8 = r6
            r6 = r10
            r10 = r7
            r7 = r8
        L63:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L82
            java.io.File r10 = new java.io.File
            r10.<init>(r7)
            r5.L$0 = r6
            r7 = 0
            r5.L$1 = r7
            r5.I$0 = r1
            r5.I$1 = r4
            r5.label = r2
            java.lang.Object r10 = us.pinguo.util.FileUtils.j(r10, r5)
            if (r10 != r0) goto L82
            return r0
        L82:
            r10 = r6
            goto L48
        L84:
            kotlin.u r10 = kotlin.u.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.module.proedit.config.model.EditTutorialManager$checkPrevSource$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package us.pinguo.edit2020.viewmodel.module;

import com.growingio.android.sdk.monitor.BuildConfig;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.SelfDefMakeup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditMakeupModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditSelfDefMakeup$1", f = "EditMakeupModule.kt", i = {}, l = {BuildConfig.VERSION_CODE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditMakeupModule$renderEditSelfDefMakeup$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $faceIndex;
    final /* synthetic */ SelfDefMakeup $selfDefMakeup;
    final /* synthetic */ String $selfDefMakeupDir;
    int label;
    final /* synthetic */ EditMakeupModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditMakeupModule$renderEditSelfDefMakeup$1(String str, SelfDefMakeup selfDefMakeup, EditMakeupModule editMakeupModule, int i2, Continuation<? super EditMakeupModule$renderEditSelfDefMakeup$1> continuation) {
        super(2, continuation);
        this.$selfDefMakeupDir = str;
        this.$selfDefMakeup = selfDefMakeup;
        this.this$0 = editMakeupModule;
        this.$faceIndex = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditMakeupModule$renderEditSelfDefMakeup$1(this.$selfDefMakeupDir, this.$selfDefMakeup, this.this$0, this.$faceIndex, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditMakeupModule$renderEditSelfDefMakeup$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
        r2 = kotlin.text.StringsKt__StringsKt.p0(r11, new java.lang.String[]{","}, false, 0, 6, null);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L1b
            if (r2 != r3) goto L13
            kotlin.j.b(r18)
            r2 = r18
            goto L2b
        L13:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L1b:
            kotlin.j.b(r18)
            us.pinguo.repository2020.manager.BeautyInstallManager r2 = us.pinguo.repository2020.manager.BeautyInstallManager.a
            java.lang.String r4 = r0.$selfDefMakeupDir
            r0.label = r3
            java.lang.Object r2 = r2.e(r4, r0)
            if (r2 != r1) goto L2b
            return r1
        L2b:
            us.pinguo.repository2020.entity.SelfDefMakeupParam r2 = (us.pinguo.repository2020.entity.SelfDefMakeupParam) r2
            if (r2 != 0) goto L30
            goto L9c
        L30:
            java.lang.String r1 = r0.$selfDefMakeupDir
            us.pinguo.repository2020.entity.SelfDefMakeup r4 = r0.$selfDefMakeup
            us.pinguo.edit2020.viewmodel.module.EditMakeupModule r5 = r0.this$0
            int r6 = r0.$faceIndex
            us.pinguo.u3dengine.api.MakeupMaterial r7 = new us.pinguo.u3dengine.api.MakeupMaterial
            java.lang.String r8 = r2.getBundle()
            java.lang.String r1 = kotlin.jvm.internal.s.q(r1, r8)
            r8 = 1117782016(0x42a00000, float:80.0)
            java.lang.String r9 = r2.getDeformation()
            if (r9 != 0) goto L4c
            java.lang.String r9 = "0"
        L4c:
            java.lang.String r10 = "#FFFFFF"
            r7.<init>(r1, r10, r8, r9)
            java.lang.String r11 = r2.getBundle()
            r1 = 0
            if (r11 != 0) goto L5a
        L58:
            r2 = 0
            goto L79
        L5a:
            java.lang.String r2 = ","
            java.lang.String[] r12 = new java.lang.String[]{r2}
            r13 = 0
            r14 = 0
            r15 = 6
            r16 = 0
            java.util.List r2 = kotlin.text.l.p0(r11, r12, r13, r14, r15, r16)
            if (r2 != 0) goto L6c
            goto L58
        L6c:
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L75
            goto L58
        L75:
            int r2 = java.lang.Integer.parseInt(r2)
        L79:
            r4.setType(r2)
            us.pinguo.edit2020.model.EditRender r2 = us.pinguo.edit2020.viewmodel.module.EditMakeupModule.c(r5)
            r2.T(r6, r7)
            java.lang.Integer[] r2 = r4.getEditMakeupCurrentValues()
            r3 = 80
            if (r2 != 0) goto L8c
            goto L99
        L8c:
            int r4 = r5.C()
            r2 = r2[r4]
            if (r2 != 0) goto L95
            goto L99
        L95:
            int r3 = r2.intValue()
        L99:
            r5.k(r3, r1)
        L9c:
            kotlin.u r1 = kotlin.u.a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditSelfDefMakeup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

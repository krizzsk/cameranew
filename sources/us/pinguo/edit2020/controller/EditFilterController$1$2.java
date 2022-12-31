package us.pinguo.edit2020.controller;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.HashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.FilterGestureView;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.SkyParamsRecord;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFilterController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.EditFilterController$1$2", f = "EditFilterController.kt", i = {1}, l = {197, 199, 200, 221, 222}, m = "invokeSuspend", n = {"pkgId"}, s = {"L$0"})
/* loaded from: classes4.dex */
public final class EditFilterController$1$2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ FilterEntry $entry;
    final /* synthetic */ String $filterId;
    Object L$0;
    int label;
    final /* synthetic */ EditFilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFilterController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.EditFilterController$1$2$1", f = "EditFilterController.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.EditFilterController$1$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ String $filterId;
        final /* synthetic */ String $pkgId;
        final /* synthetic */ boolean $textureVisible;
        int label;
        final /* synthetic */ EditFilterController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EditFilterController editFilterController, String str, String str2, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = editFilterController;
            this.$filterId = str;
            this.$pkgId = str2;
            this.$textureVisible = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$filterId, this.$pkgId, this.$textureVisible, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            ConstraintLayout constraintLayout;
            EditFilterModule editFilterModule;
            SkyParamsRecord skyParamsRecord;
            EditFilterModule editFilterModule2;
            FilterPanelView v0;
            EditFilterModule editFilterModule3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                constraintLayout = this.this$0.u;
                ((FilterGestureView) constraintLayout.findViewById(R.id.filterGestureView)).setRectMinSize(us.pinguo.common.widget.i.a.b(Boxing.boxInt(24)));
                editFilterModule = this.this$0.v;
                skyParamsRecord = editFilterModule.G().get(this.$filterId);
                if (skyParamsRecord == null) {
                    editFilterModule2 = this.this$0.v;
                    String str = this.$pkgId;
                    String str2 = this.$filterId;
                    this.label = 1;
                    obj = editFilterModule2.b0(str, str2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.this$0.j1(skyParamsRecord.getTransparent(), skyParamsRecord.getMix(), skyParamsRecord.getDefaultTemperature(), skyParamsRecord.getTemperature(), skyParamsRecord.getTexture());
                this.this$0.n1(this.$textureVisible);
                v0 = this.this$0.v0();
                v0.setDisableSeekbar(true);
                this.this$0.f1(false);
                return kotlin.u.a;
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            skyParamsRecord = (SkyParamsRecord) obj;
            editFilterModule3 = this.this$0.v;
            editFilterModule3.G().put(this.$filterId, skyParamsRecord);
            this.this$0.j1(skyParamsRecord.getTransparent(), skyParamsRecord.getMix(), skyParamsRecord.getDefaultTemperature(), skyParamsRecord.getTemperature(), skyParamsRecord.getTexture());
            this.this$0.n1(this.$textureVisible);
            v0 = this.this$0.v0();
            v0.setDisableSeekbar(true);
            this.this$0.f1(false);
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFilterController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.EditFilterController$1$2$2", f = "EditFilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.EditFilterController$1$2$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ boolean $isTemplateFilterAdjust;
        int label;
        final /* synthetic */ EditFilterController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(EditFilterController editFilterController, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = editFilterController;
            this.$isTemplateFilterAdjust = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$isTemplateFilterAdjust, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ConstraintLayout constraintLayout;
            FilterPanelView v0;
            ConstraintLayout constraintLayout2;
            FilterPanelView v02;
            FilterPanelView v03;
            EditFilterModule editFilterModule;
            HashMap hashMap;
            HashMap hashMap2;
            FilterPanelView v04;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                constraintLayout = this.this$0.u;
                int i2 = R.id.filterGestureView;
                ((FilterGestureView) constraintLayout.findViewById(i2)).setRectMinSize(us.pinguo.common.widget.i.a.b(Boxing.boxInt(20)));
                v0 = this.this$0.v0();
                if (v0.p()) {
                    constraintLayout2 = this.this$0.u;
                    FilterGestureView filterGestureView = (FilterGestureView) constraintLayout2.findViewById(i2);
                    kotlin.jvm.internal.s.g(filterGestureView, "fragmentLayout.filterGestureView");
                    filterGestureView.setVisibility(4);
                    VdsAgent.onSetViewVisibility(filterGestureView, 4);
                    v02 = this.this$0.v0();
                    v02.setDisableSeekbar(false);
                    if (this.$isTemplateFilterAdjust) {
                        v04 = this.this$0.v0();
                        v04.S(true);
                    } else {
                        v03 = this.this$0.v0();
                        v03.P(true);
                    }
                    editFilterModule = this.this$0.v;
                    editFilterModule.G().clear();
                    hashMap = this.this$0.C;
                    hashMap.clear();
                    hashMap2 = this.this$0.D;
                    hashMap2.clear();
                }
                this.this$0.z1();
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFilterController$1$2(EditFilterController editFilterController, FilterEntry filterEntry, String str, Continuation<? super EditFilterController$1$2> continuation) {
        super(2, continuation);
        this.this$0 = editFilterController;
        this.$entry = filterEntry;
        this.$filterId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFilterController$1$2(this.this$0, this.$entry, this.$filterId, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFilterController$1$2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cc A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L38
            if (r1 == r7) goto L34
            if (r1 == r6) goto L2b
            if (r1 == r5) goto L26
            if (r1 == r4) goto L21
            if (r1 != r3) goto L19
            goto L26
        L19:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L21:
            kotlin.j.b(r13)
            goto Lb3
        L26:
            kotlin.j.b(r13)
            goto Lcd
        L2b:
            java.lang.Object r1 = r12.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.j.b(r13)
        L32:
            r9 = r1
            goto L74
        L34:
            kotlin.j.b(r13)
            goto L4c
        L38:
            kotlin.j.b(r13)
            us.pinguo.edit2020.controller.EditFilterController r13 = r12.this$0
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r13 = us.pinguo.edit2020.controller.EditFilterController.J1(r13)
            us.pinguo.repository2020.entity.FilterEntry r1 = r12.$entry
            r12.label = r7
            java.lang.Object r13 = r13.W(r1, r12)
            if (r13 != r0) goto L4c
            return r0
        L4c:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r13 = kotlin.jvm.internal.s.c(r13, r1)
            if (r13 == 0) goto L94
            us.pinguo.repository2020.entity.FilterEntry r13 = r12.$entry
            java.lang.String r1 = r13.getPkgId()
            if (r1 != 0) goto L61
            kotlin.u r13 = kotlin.u.a
            return r13
        L61:
            us.pinguo.edit2020.controller.EditFilterController r13 = r12.this$0
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r13 = us.pinguo.edit2020.controller.EditFilterController.J1(r13)
            java.lang.String r3 = r12.$filterId
            r12.L$0 = r1
            r12.label = r6
            java.lang.Object r13 = r13.V(r1, r3, r12)
            if (r13 != r0) goto L32
            return r0
        L74:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r10 = r13.booleanValue()
            kotlinx.coroutines.g2 r13 = kotlinx.coroutines.z0.c()
            us.pinguo.edit2020.controller.EditFilterController$1$2$1 r1 = new us.pinguo.edit2020.controller.EditFilterController$1$2$1
            us.pinguo.edit2020.controller.EditFilterController r7 = r12.this$0
            java.lang.String r8 = r12.$filterId
            r11 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            r12.L$0 = r2
            r12.label = r5
            java.lang.Object r13 = kotlinx.coroutines.j.g(r13, r1, r12)
            if (r13 != r0) goto Lcd
            return r0
        L94:
            us.pinguo.edit2020.controller.EditFilterController r13 = r12.this$0
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r13 = us.pinguo.edit2020.controller.EditFilterController.J1(r13)
            us.pinguo.repository2020.u r13 = r13.y()
            java.lang.Object r13 = r13.getValue()
            us.pinguo.repository2020.entity.FilterEntry r13 = (us.pinguo.repository2020.entity.FilterEntry) r13
            us.pinguo.edit2020.controller.EditFilterController r1 = r12.this$0
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r1 = us.pinguo.edit2020.controller.EditFilterController.J1(r1)
            r12.label = r4
            java.lang.Object r13 = r1.Z(r13, r12)
            if (r13 != r0) goto Lb3
            return r0
        Lb3:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            kotlinx.coroutines.g2 r1 = kotlinx.coroutines.z0.c()
            us.pinguo.edit2020.controller.EditFilterController$1$2$2 r4 = new us.pinguo.edit2020.controller.EditFilterController$1$2$2
            us.pinguo.edit2020.controller.EditFilterController r5 = r12.this$0
            r4.<init>(r5, r13, r2)
            r12.label = r3
            java.lang.Object r13 = kotlinx.coroutines.j.g(r1, r4, r12)
            if (r13 != r0) goto Lcd
            return r0
        Lcd:
            kotlin.u r13 = kotlin.u.a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.EditFilterController$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

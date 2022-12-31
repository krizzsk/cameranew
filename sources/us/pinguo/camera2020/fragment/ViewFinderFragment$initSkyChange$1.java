package us.pinguo.camera2020.fragment;

import com.facebook.ads.AdError;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$initSkyChange$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ FilterEntry $entry;
    final /* synthetic */ String $itemId;
    final /* synthetic */ String $pkgId;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$initSkyChange$1$1", f = "ViewFinderFragment.kt", i = {}, l = {AdError.INTERSTITIAL_AD_TIMEOUT, 2010}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$initSkyChange$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ FilterEntry $entry;
        final /* synthetic */ String $itemId;
        final /* synthetic */ String $pkgId;
        int label;
        final /* synthetic */ ViewFinderFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ViewFinderFragment viewFinderFragment, String str, String str2, FilterEntry filterEntry, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = viewFinderFragment;
            this.$pkgId = str;
            this.$itemId = str2;
            this.$entry = filterEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$pkgId, this.$itemId, this.$entry, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Object Z3;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                CameraViewModel cameraViewModel = this.this$0.f9174j;
                if (cameraViewModel == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                CameraFilterModule cameraFilterModule = cameraViewModel.getCameraFilterModule();
                String str = this.$pkgId;
                String str2 = this.$itemId;
                this.label = 1;
                if (CameraFilterModule.K(cameraFilterModule, str, str2, null, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.j.b(obj);
                return kotlin.u.a;
            } else {
                kotlin.j.b(obj);
            }
            ViewFinderFragment viewFinderFragment = this.this$0;
            FilterEntry filterEntry = this.$entry;
            this.label = 2;
            Z3 = viewFinderFragment.Z3(filterEntry, false, this);
            if (Z3 == coroutine_suspended) {
                return coroutine_suspended;
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$initSkyChange$1(ViewFinderFragment viewFinderFragment, String str, String str2, FilterEntry filterEntry) {
        super(1);
        this.this$0 = viewFinderFragment;
        this.$pkgId = str;
        this.$itemId = str2;
        this.$entry = filterEntry;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        r0 = r9.this$0.J1();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invoke(boolean r10) {
        /*
            r9 = this;
            us.pinguo.camera2020.fragment.ViewFinderFragment r0 = r9.this$0
            us.pinguo.common.filter.controller.FilterController r0 = us.pinguo.camera2020.fragment.ViewFinderFragment.t0(r0)
            if (r0 != 0) goto L9
            goto Lc
        L9:
            r0.l1(r10)
        Lc:
            if (r10 == 0) goto L30
            us.pinguo.camera2020.fragment.ViewFinderFragment r10 = r9.this$0
            androidx.lifecycle.LifecycleCoroutineScope r0 = us.pinguo.camera2020.fragment.ViewFinderFragment.g0(r10)
            if (r0 != 0) goto L17
            goto L30
        L17:
            kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.z0.b()
            r2 = 0
            us.pinguo.camera2020.fragment.ViewFinderFragment$initSkyChange$1$1 r10 = new us.pinguo.camera2020.fragment.ViewFinderFragment$initSkyChange$1$1
            us.pinguo.camera2020.fragment.ViewFinderFragment r4 = r9.this$0
            java.lang.String r5 = r9.$pkgId
            java.lang.String r6 = r9.$itemId
            us.pinguo.repository2020.entity.FilterEntry r7 = r9.$entry
            r8 = 0
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r4 = 2
            r5 = 0
            kotlinx.coroutines.j.d(r0, r1, r2, r3, r4, r5)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$initSkyChange$1.invoke(boolean):void");
    }
}

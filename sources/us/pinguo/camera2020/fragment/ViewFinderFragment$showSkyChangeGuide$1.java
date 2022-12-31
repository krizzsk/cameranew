package us.pinguo.camera2020.fragment;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.fragment.ViewFinderFragment$showSkyChangeGuide$1;
import us.pinguo.camera2020.view.CameraRootLayout;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.widget.SkyChangeGuideView;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$showSkyChangeGuide$1", f = "ViewFinderFragment.kt", i = {}, l = {2019}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$showSkyChangeGuide$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ FilterEntry $entry;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$showSkyChangeGuide$1$1", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$showSkyChangeGuide$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ ViewFinderFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ViewFinderFragment viewFinderFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = viewFinderFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-2  reason: not valid java name */
        public static final void m70invokeSuspend$lambda2(final ViewFinderFragment viewFinderFragment) {
            View t0;
            FilterController filterController = viewFinderFragment.u;
            if (filterController == null || (t0 = filterController.t0()) == null) {
                return;
            }
            int i2 = R.id.gvSkyChange;
            SkyChangeGuideView gvSkyChange = (SkyChangeGuideView) viewFinderFragment._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(gvSkyChange, "gvSkyChange");
            gvSkyChange.setVisibility(0);
            VdsAgent.onSetViewVisibility(gvSkyChange, 0);
            Rect rect = new Rect();
            t0.getGlobalVisibleRect(rect);
            ((SkyChangeGuideView) viewFinderFragment._$_findCachedViewById(i2)).e(rect.left, rect.top, t0.getWidth(), t0.getHeight(), true);
            ((SkyChangeGuideView) viewFinderFragment._$_findCachedViewById(i2)).c().setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.camera2020.fragment.k0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean m71invokeSuspend$lambda2$lambda1$lambda0;
                    m71invokeSuspend$lambda2$lambda1$lambda0 = ViewFinderFragment$showSkyChangeGuide$1.AnonymousClass1.m71invokeSuspend$lambda2$lambda1$lambda0(ViewFinderFragment.this, view, motionEvent);
                    return m71invokeSuspend$lambda2$lambda1$lambda0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-2$lambda-1$lambda-0  reason: not valid java name */
        public static final boolean m71invokeSuspend$lambda2$lambda1$lambda0(ViewFinderFragment viewFinderFragment, View view, MotionEvent motionEvent) {
            LifecycleCoroutineScope J1;
            int i2 = R.id.gvSkyChange;
            SkyChangeGuideView gvSkyChange = (SkyChangeGuideView) viewFinderFragment._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(gvSkyChange, "gvSkyChange");
            if (gvSkyChange.getVisibility() == 0) {
                J1 = viewFinderFragment.J1();
                if (J1 != null) {
                    kotlinx.coroutines.l.d(J1, z0.b(), null, new ViewFinderFragment$showSkyChangeGuide$1$1$1$1$1$1(null), 2, null);
                }
                SkyChangeGuideView gvSkyChange2 = (SkyChangeGuideView) viewFinderFragment._$_findCachedViewById(i2);
                kotlin.jvm.internal.s.g(gvSkyChange2, "gvSkyChange");
                gvSkyChange2.setVisibility(8);
                VdsAgent.onSetViewVisibility(gvSkyChange2, 8);
            }
            return false;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CameraRootLayout cameraRootLayout;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                cameraRootLayout = this.this$0.x;
                if (cameraRootLayout != null) {
                    final ViewFinderFragment viewFinderFragment = this.this$0;
                    us.pinguo.foundation.ui.c.b(cameraRootLayout, new Runnable() { // from class: us.pinguo.camera2020.fragment.l0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ViewFinderFragment$showSkyChangeGuide$1.AnonymousClass1.m70invokeSuspend$lambda2(ViewFinderFragment.this);
                        }
                    });
                    return kotlin.u.a;
                }
                kotlin.jvm.internal.s.z("cameraRootLayout");
                throw null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$showSkyChangeGuide$1(ViewFinderFragment viewFinderFragment, FilterEntry filterEntry, Continuation<? super ViewFinderFragment$showSkyChangeGuide$1> continuation) {
        super(2, continuation);
        this.this$0 = viewFinderFragment;
        this.$entry = filterEntry;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ViewFinderFragment$showSkyChangeGuide$1(this.this$0, this.$entry, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$showSkyChangeGuide$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        r3 = r10.this$0.J1();
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 != r3) goto L10
            kotlin.j.b(r11)
            goto L32
        L10:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L18:
            kotlin.j.b(r11)
            us.pinguo.camera2020.fragment.ViewFinderFragment r11 = r10.this$0
            us.pinguo.camera2020.viewmodel.CameraViewModel r11 = us.pinguo.camera2020.fragment.ViewFinderFragment.q0(r11)
            if (r11 == 0) goto L7a
            us.pinguo.common.filter.CameraFilterModule r11 = r11.getCameraFilterModule()
            us.pinguo.repository2020.entity.FilterEntry r1 = r10.$entry
            r10.label = r3
            java.lang.Object r11 = r11.W(r1, r10)
            if (r11 != r0) goto L32
            return r0
        L32:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r11 = kotlin.jvm.internal.s.c(r11, r0)
            if (r11 == 0) goto L77
            us.pinguo.repository2020.utils.o r4 = us.pinguo.repository2020.utils.o.a
            r6 = 1
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = "isCameraFirstSkyChange"
            boolean r11 = us.pinguo.repository2020.utils.o.b(r4, r5, r6, r7, r8, r9)
            if (r11 == 0) goto L77
            us.pinguo.camera2020.fragment.ViewFinderFragment r11 = r10.this$0
            us.pinguo.common.filter.controller.FilterController r11 = us.pinguo.camera2020.fragment.ViewFinderFragment.t0(r11)
            r0 = 0
            if (r11 != 0) goto L55
        L53:
            r3 = 0
            goto L5b
        L55:
            boolean r11 = r11.K0()
            if (r11 != r3) goto L53
        L5b:
            if (r3 == 0) goto L77
            us.pinguo.camera2020.fragment.ViewFinderFragment r11 = r10.this$0
            androidx.lifecycle.LifecycleCoroutineScope r3 = us.pinguo.camera2020.fragment.ViewFinderFragment.g0(r11)
            if (r3 != 0) goto L66
            goto L77
        L66:
            kotlinx.coroutines.g2 r4 = kotlinx.coroutines.z0.c()
            r5 = 0
            us.pinguo.camera2020.fragment.ViewFinderFragment$showSkyChangeGuide$1$1 r6 = new us.pinguo.camera2020.fragment.ViewFinderFragment$showSkyChangeGuide$1$1
            us.pinguo.camera2020.fragment.ViewFinderFragment r11 = r10.this$0
            r6.<init>(r11, r2)
            r7 = 2
            r8 = 0
            kotlinx.coroutines.j.d(r3, r4, r5, r6, r7, r8)
        L77:
            kotlin.u r11 = kotlin.u.a
            return r11
        L7a:
            java.lang.String r11 = "cameraViewModel"
            kotlin.jvm.internal.s.z(r11)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.fragment.ViewFinderFragment$showSkyChangeGuide$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

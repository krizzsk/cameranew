package us.pinguo.camera2020.view;

import android.content.Context;
import android.content.DialogInterface;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
import us.pinguo.camera2020.view.StickerViewController$handleStickerItemClicked$1;
import us.pinguo.repository2020.database.sticker.StickerManager;
import us.pinguo.repository2020.database.sticker.StickerState;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerViewController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.StickerViewController$handleStickerItemClicked$1", f = "StickerViewController.kt", i = {}, l = {192, 193}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class StickerViewController$handleStickerItemClicked$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $id;
    final /* synthetic */ CameraStickerModule $module;
    int label;
    final /* synthetic */ StickerViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerViewController.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.view.StickerViewController$handleStickerItemClicked$1$1", f = "StickerViewController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.view.StickerViewController$handleStickerItemClicked$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $id;
        final /* synthetic */ CameraStickerModule $module;
        final /* synthetic */ StickerState $state;
        int label;
        final /* synthetic */ StickerViewController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StickerState stickerState, String str, StickerViewController stickerViewController, Context context, CameraStickerModule cameraStickerModule, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$state = stickerState;
            this.$id = str;
            this.this$0 = stickerViewController;
            this.$context = context;
            this.$module = cameraStickerModule;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
        public static final void m72invokeSuspend$lambda0(StickerViewController stickerViewController, String str, DialogInterface dialogInterface, int i2) {
            VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
            if (i2 == -1) {
                us.pinguo.repository2020.m.a.S(true);
                stickerViewController.k0(str);
            }
            dialogInterface.cancel();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$state, this.$id, this.this$0, this.$context, this.$module, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                StickerState stickerState = this.$state;
                if (stickerState == StickerState.NOT_DOWNLOADED) {
                    if (StickerManager.a.U(this.$id)) {
                        this.this$0.k0(this.$id);
                        return kotlin.u.a;
                    } else if (!us.pinguo.util.q.e(this.$context)) {
                        us.pinguo.foundation.utils.k0.a.a(R.string.network_not_available);
                        return kotlin.u.a;
                    } else {
                        Context context = this.$context;
                        kotlin.jvm.internal.s.g(context, "context");
                        if (us.pinguo.util.q.h(context) || us.pinguo.repository2020.m.a.C()) {
                            this.this$0.k0(this.$id);
                        } else {
                            Context context2 = this.$context;
                            int i2 = R.string.filter_download_dialog_content;
                            int i3 = R.string.filter_download_dialog_bt_pos;
                            int i4 = R.string.filter_download_dialog_bt_neg;
                            final StickerViewController stickerViewController = this.this$0;
                            final String str = this.$id;
                            us.pinguo.foundation.utils.w.i(context2, i2, i3, i4, new DialogInterface.OnClickListener() { // from class: us.pinguo.camera2020.view.f1
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i5) {
                                    StickerViewController$handleStickerItemClicked$1.AnonymousClass1.m72invokeSuspend$lambda0(StickerViewController.this, str, dialogInterface, i5);
                                }
                            });
                        }
                    }
                } else if (stickerState == StickerState.AVAILABLE) {
                    CameraStickerModule.L(this.$module, this.$id, false, 2, null);
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewController$handleStickerItemClicked$1(CameraStickerModule cameraStickerModule, String str, StickerViewController stickerViewController, Context context, Continuation<? super StickerViewController$handleStickerItemClicked$1> continuation) {
        super(2, continuation);
        this.$module = cameraStickerModule;
        this.$id = str;
        this.this$0 = stickerViewController;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StickerViewController$handleStickerItemClicked$1(this.$module, this.$id, this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StickerViewController$handleStickerItemClicked$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            CameraStickerModule cameraStickerModule = this.$module;
            String str = this.$id;
            this.label = 1;
            obj = cameraStickerModule.w(str, this);
            if (obj == coroutine_suspended) {
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
        kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1((StickerState) obj, this.$id, this.this$0, this.$context, this.$module, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}

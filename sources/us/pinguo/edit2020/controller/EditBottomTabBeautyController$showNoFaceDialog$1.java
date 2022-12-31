package us.pinguo.edit2020.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
import us.pinguo.common.widget.tab.PGEditBottomTabLayout;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditBottomTabBeautyController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.EditBottomTabBeautyController$showNoFaceDialog$1", f = "EditBottomTabBeautyController.kt", i = {}, l = {1484}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditBottomTabBeautyController$showNoFaceDialog$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ boolean $useRetouch;
    int label;
    final /* synthetic */ EditBottomTabBeautyController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBottomTabBeautyController$showNoFaceDialog$1(EditBottomTabBeautyController editBottomTabBeautyController, boolean z, Continuation<? super EditBottomTabBeautyController$showNoFaceDialog$1> continuation) {
        super(2, continuation);
        this.this$0 = editBottomTabBeautyController;
        this.$useRetouch = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m88invokeSuspend$lambda0(AppCompatActivity appCompatActivity, EditBottomTabBeautyController editBottomTabBeautyController, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        us.pinguo.foundation.utils.d0.a(appCompatActivity);
        if (i2 == -2) {
            ((PGEditBottomTabLayout) editBottomTabBeautyController.b.findViewById(R.id.bottomTabLayout)).G();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditBottomTabBeautyController$showNoFaceDialog$1(this.this$0, this.$useRetouch, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditBottomTabBeautyController$showNoFaceDialog$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        y2 y2Var;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            this.label = 1;
            if (DelayKt.b(500L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        if (this.this$0.f10326e.S()) {
            y2Var = this.this$0.f10331j;
            if (y2Var != null) {
                y2Var.h(true);
            }
            if (this.$useRetouch) {
                this.this$0.g1();
            }
            return kotlin.u.a;
        }
        Context context = this.this$0.f10330i;
        final AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity == null) {
            return kotlin.u.a;
        }
        us.pinguo.foundation.utils.d0.b(appCompatActivity);
        View inflate = View.inflate(this.this$0.f10330i, R.layout.layout_no_face_dialog, null);
        Context context2 = this.this$0.f10330i;
        int i3 = R.string.no_face_dialog_button_text;
        final EditBottomTabBeautyController editBottomTabBeautyController = this.this$0;
        AlertDialog e2 = us.pinguo.foundation.utils.w.e(context2, inflate, -999, i3, new DialogInterface.OnClickListener() { // from class: us.pinguo.edit2020.controller.y0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                EditBottomTabBeautyController$showNoFaceDialog$1.m88invokeSuspend$lambda0(AppCompatActivity.this, editBottomTabBeautyController, dialogInterface, i4);
            }
        });
        e2.setCancelable(false);
        e2.setCanceledOnTouchOutside(false);
        return kotlin.u.a;
    }
}

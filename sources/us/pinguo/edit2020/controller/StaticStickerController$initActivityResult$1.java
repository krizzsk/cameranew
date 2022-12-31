package us.pinguo.edit2020.controller;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import java.io.Serializable;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.widget.DrawerPanelView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController$initActivityResult$1", f = "StaticStickerController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StaticStickerController$initActivityResult$1 extends SuspendLambda implements kotlin.jvm.b.p<ActivityResult, Continuation<? super kotlin.u>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$initActivityResult$1(StaticStickerController staticStickerController, Continuation<? super StaticStickerController$initActivityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        StaticStickerController$initActivityResult$1 staticStickerController$initActivityResult$1 = new StaticStickerController$initActivityResult$1(this.this$0, continuation);
        staticStickerController$initActivityResult$1.L$0 = obj;
        return staticStickerController$initActivityResult$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(ActivityResult activityResult, Continuation<? super kotlin.u> continuation) {
        return ((StaticStickerController$initActivityResult$1) create(activityResult, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            Intent data = ((ActivityResult) this.L$0).getData();
            if (data != null) {
                StaticStickerController staticStickerController = this.this$0;
                String stringExtra = data.getStringExtra("s_type");
                if (kotlin.jvm.internal.s.c(stringExtra, "use_sticker")) {
                    String stringExtra2 = data.getStringExtra("s_result");
                    int N = staticStickerController.b.N(stringExtra2);
                    staticStickerController.f10428f.y(stringExtra2);
                    staticStickerController.f10428f.C();
                    staticStickerController.B0(N);
                } else if (kotlin.jvm.internal.s.c(stringExtra, "refresh")) {
                    Serializable serializableExtra = data.getSerializableExtra("deleted_stickers");
                    List<String> list = serializableExtra instanceof List ? (List) serializableExtra : null;
                    if (list != null) {
                        staticStickerController.b.f0(list);
                    }
                    staticStickerController.f10428f.B();
                    DrawerPanelView.z(staticStickerController.f10428f, null, 1, null);
                    staticStickerController.f10428f.C();
                }
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

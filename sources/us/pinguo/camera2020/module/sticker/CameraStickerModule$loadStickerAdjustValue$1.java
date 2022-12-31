package us.pinguo.camera2020.module.sticker;

import android.content.SharedPreferences;
import java.util.HashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.foundation.e;
import us.pinguo.repository2020.database.sticker.StickerManager;
import us.pinguo.repository2020.database.sticker.StickerRenderData;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraStickerModule.kt */
@DebugMetadata(c = "us.pinguo.camera2020.module.sticker.CameraStickerModule$loadStickerAdjustValue$1", f = "CameraStickerModule.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraStickerModule$loadStickerAdjustValue$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ CameraStickerModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStickerModule$loadStickerAdjustValue$1(String str, CameraStickerModule cameraStickerModule, Continuation<? super CameraStickerModule$loadStickerAdjustValue$1> continuation) {
        super(2, continuation);
        this.$id = str;
        this.this$0 = cameraStickerModule;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new CameraStickerModule$loadStickerAdjustValue$1(this.$id, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((CameraStickerModule$loadStickerAdjustValue$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        HashMap hashMap;
        HashMap hashMap2;
        Float makeupDisplayStrength;
        Float filterDisplayStrength;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            StickerManager stickerManager = StickerManager.a;
            String str = this.$id;
            this.label = 1;
            obj = stickerManager.F(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        StickerRenderData stickerRenderData = (StickerRenderData) obj;
        SharedPreferences sharedPreferences = e.b().getSharedPreferences("sticker_preference", 0);
        hashMap = this.this$0.f9245d;
        String q = s.q(this.$id, "_filter");
        float f2 = 0.7f;
        if (stickerRenderData != null && (filterDisplayStrength = stickerRenderData.getFilterDisplayStrength()) != null) {
            f2 = filterDisplayStrength.floatValue();
        }
        float f3 = 100;
        hashMap.put("filter", Boxing.boxInt(sharedPreferences.getInt(q, (int) (f2 * f3))));
        hashMap2 = this.this$0.f9245d;
        String q2 = s.q(this.$id, "_makeup");
        float f4 = 0.8f;
        if (stickerRenderData != null && (makeupDisplayStrength = stickerRenderData.getMakeupDisplayStrength()) != null) {
            f4 = makeupDisplayStrength.floatValue();
        }
        hashMap2.put("makeup", Boxing.boxInt(sharedPreferences.getInt(q2, (int) (f4 * f3))));
        return u.a;
    }
}

package us.pinguo.repository2020.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.MaterialResponse;
import us.pinguo.repository2020.entity.StyleMakeup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDataManager$buildStyleMakeupMap$1", f = "BeautyDataManager.kt", i = {0, 0}, l = {TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE}, m = "invokeSuspend", n = {"installIds", "styleMakeup"}, s = {"L$0", "L$2"})
/* loaded from: classes6.dex */
public final class BeautyDataManager$buildStyleMakeupMap$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ Boolean $isEnterCamera;
    final /* synthetic */ List<String> $layouts;
    final /* synthetic */ MaterialResponse<StyleMakeup> $material;
    final /* synthetic */ List<StyleMakeup> $suites;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyDataManager$buildStyleMakeupMap$1(Boolean bool, List<StyleMakeup> list, List<String> list2, MaterialResponse<StyleMakeup> materialResponse, Continuation<? super BeautyDataManager$buildStyleMakeupMap$1> continuation) {
        super(2, continuation);
        this.$isEnterCamera = bool;
        this.$suites = list;
        this.$layouts = list2;
        this.$material = materialResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDataManager$buildStyleMakeupMap$1(this.$isEnterCamera, this.$suites, this.$layouts, this.$material, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDataManager$buildStyleMakeupMap$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ef  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0166 -> B:69:0x0187). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x017e -> B:68:0x0185). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.manager.BeautyDataManager$buildStyleMakeupMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}

package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.bean.v;
import us.pinguo.edit2020.bean.w;
import us.pinguo.repository2020.manager.AdjustRepository;
import us.pinguo.u3dengine.edit.AdjustRenderData;
import us.pinguo.u3dengine.edit.NativeAdjustEntity;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: AdjustModule.kt */
/* loaded from: classes4.dex */
final class AdjustModule$functions$1$function$2 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ v $hsl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustModule$functions$1$function$2(v vVar) {
        super(0);
        this.$hsl = vVar;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        w wVar = this.$hsl.o().get(this.$hsl.p());
        s.g(wVar, "hsl.colorInfo[hsl.currentColorIndex]");
        w wVar2 = wVar;
        AdjustRenderData a = AdjustRepository.a.a();
        String colorKey = wVar2.m().getColorKey();
        String colorKey2 = wVar2.m().getColorKey();
        NativeAdjustEntity nativeAdjustEntity = new NativeAdjustEntity(0, colorKey, colorKey2, (wVar2.g() / 100.0f) + ',' + (wVar2.i() / 100.0f) + ',' + (wVar2.h() / 100.0f) + ",0", 3);
        a.getAdjust().clear();
        a.getAdjust().add(nativeAdjustEntity);
        UnityEditCaller.Adjustment.setAdjustValue(a);
    }
}

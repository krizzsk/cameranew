package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.edit2020.bean.f0;
import us.pinguo.edit2020.bean.g0;
import us.pinguo.repository2020.manager.AdjustRepository;
import us.pinguo.u3dengine.edit.AdjustRenderData;
import us.pinguo.u3dengine.edit.ColorOptionMode;
import us.pinguo.u3dengine.edit.NativeAdjustEntity;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: AdjustModule.kt */
/* loaded from: classes4.dex */
final class AdjustModule$functions$1$function$3 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ f0 $optionalColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustModule$functions$1$function$3(f0 f0Var) {
        super(0);
        this.$optionalColor = f0Var;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AdjustRenderData a = AdjustRepository.a.a();
        ColorOptionMode colorOptionMode = ColorOptionMode.Relative;
        String key = colorOptionMode.getKey();
        NativeAdjustEntity nativeAdjustEntity = new NativeAdjustEntity(0, key, key, this.$optionalColor.q() == colorOptionMode ? "1" : "0", 2);
        a.getAdjust().clear();
        a.getAdjust().add(nativeAdjustEntity);
        UnityEditCaller.Adjustment.setAdjustValue(a);
        a.getAdjust().clear();
        for (g0 g0Var : this.$optionalColor.o()) {
            String l2 = g0Var.l();
            StringBuilder sb = new StringBuilder();
            sb.append(g0Var.h().b() / 100.0f);
            sb.append(',');
            sb.append(g0Var.k().b() / 100.0f);
            sb.append(',');
            sb.append(g0Var.m().b() / 100.0f);
            sb.append(',');
            sb.append(g0Var.g().b() / 100.0f);
            a.getAdjust().add(new NativeAdjustEntity(0, l2, l2, sb.toString(), 3));
        }
        UnityEditCaller.Adjustment.setAdjustValue(a);
    }
}

package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.repository2020.manager.AdjustRepository;
import us.pinguo.u3dengine.edit.AdjustRenderData;
import us.pinguo.u3dengine.edit.BaseAdjustType;
import us.pinguo.u3dengine.edit.NativeAdjustEntity;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: AdjustModule.kt */
/* loaded from: classes4.dex */
final class AdjustModule$functions$1$function$4 extends Lambda implements kotlin.jvm.b.a<u> {
    final /* synthetic */ us.pinguo.edit2020.bean.a $func;
    final /* synthetic */ BaseAdjustType $type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustModule$functions$1$function$4(BaseAdjustType baseAdjustType, us.pinguo.edit2020.bean.a aVar) {
        super(0);
        this.$type = baseAdjustType;
        this.$func = aVar;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NativeAdjustEntity nativeAdjustEntity;
        NativeAdjustEntity nativeAdjustEntity2;
        AdjustRepository adjustRepository = AdjustRepository.a;
        AdjustRenderData a = adjustRepository.a();
        NativeAdjustEntity[] b = adjustRepository.b();
        BaseAdjustType baseAdjustType = this.$type;
        int length = b.length;
        int i2 = 0;
        while (true) {
            nativeAdjustEntity = null;
            if (i2 >= length) {
                nativeAdjustEntity2 = null;
                break;
            }
            nativeAdjustEntity2 = b[i2];
            if (s.c(nativeAdjustEntity2.getName(), baseAdjustType.getParam())) {
                break;
            }
            i2++;
        }
        if (nativeAdjustEntity2 != null) {
            us.pinguo.edit2020.bean.a aVar = this.$func;
            nativeAdjustEntity2.setValue(String.valueOf(aVar.g() / aVar.i()));
            nativeAdjustEntity = nativeAdjustEntity2;
        }
        NativeAdjustEntity nativeAdjustEntity3 = new NativeAdjustEntity(0, "chromatic_intensity", "chromatic_intensity", "0.65", 0);
        a.getAdjust().clear();
        a.getAdjust().add(nativeAdjustEntity);
        a.getAdjust().add(nativeAdjustEntity3);
        UnityEditCaller.Adjustment.setAdjustValue(a);
    }
}

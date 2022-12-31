package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.u;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditAutoBeautifyModule.kt */
/* loaded from: classes4.dex */
/* synthetic */ class EditAutoBeautifyModule$getAutoBeautifyFunctions$1 extends FunctionReferenceImpl implements l<Float, u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EditAutoBeautifyModule$getAutoBeautifyFunctions$1(Object obj) {
        super(1, obj, UnityEditCaller.AutoBeauty.class, "setAutoSoftSkinValue", "setAutoSoftSkinValue(F)V", 0);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Float f2) {
        invoke(f2.floatValue());
        return u.a;
    }

    public final void invoke(float f2) {
        UnityEditCaller.AutoBeauty.setAutoSoftSkinValue(f2);
    }
}

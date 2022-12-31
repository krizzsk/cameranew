package us.pinguo.edit2020.viewmodel.module;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.u3dengine.edit.EditModel;
/* compiled from: EditBeautyModule.kt */
/* loaded from: classes4.dex */
final class EditBeautyModule$onSkinRefreshUnityPrepared$1 extends Lambda implements l<EditModel, u> {
    final /* synthetic */ kotlin.jvm.b.a<u> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditBeautyModule$onSkinRefreshUnityPrepared$1(kotlin.jvm.b.a<u> aVar) {
        super(1);
        this.$callback = aVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(EditModel editModel) {
        invoke2(editModel);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(EditModel it) {
        s.h(it, "it");
        if (it == EditModel.SoftSkin) {
            this.$callback.invoke();
        }
    }
}

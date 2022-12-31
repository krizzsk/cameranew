package us.pinguo.picker.image;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
/* compiled from: PickManager.kt */
/* loaded from: classes5.dex */
final class PickManager$syncInRange$2 extends Lambda implements l<Boolean, u> {
    final /* synthetic */ l<Boolean, u> $post;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PickManager$syncInRange$2(l<? super Boolean, u> lVar) {
        super(1);
        this.$post = lVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
        invoke2(bool);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        this.$post.invoke(bool);
    }
}

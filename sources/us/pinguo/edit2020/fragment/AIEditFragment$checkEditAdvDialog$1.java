package us.pinguo.edit2020.fragment;

import android.net.Uri;
import kotlin.jvm.internal.Lambda;
/* compiled from: AIEditFragment.kt */
/* loaded from: classes4.dex */
final class AIEditFragment$checkEditAdvDialog$1 extends Lambda implements kotlin.jvm.b.l<Uri, kotlin.u> {
    final /* synthetic */ AIEditFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AIEditFragment$checkEditAdvDialog$1(AIEditFragment aIEditFragment) {
        super(1);
        this.this$0 = aIEditFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Uri uri) {
        invoke2(uri);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Uri uri) {
        kotlin.jvm.internal.s.h(uri, "uri");
        this.this$0.n0(uri);
    }
}

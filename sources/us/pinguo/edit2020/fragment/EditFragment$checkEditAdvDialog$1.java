package us.pinguo.edit2020.fragment;

import android.net.Uri;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$checkEditAdvDialog$1 extends Lambda implements kotlin.jvm.b.l<Uri, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$checkEditAdvDialog$1(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Uri uri) {
        invoke2(uri);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Uri uri) {
        kotlin.jvm.internal.s.h(uri, "uri");
        this.this$0.k1(uri);
    }
}

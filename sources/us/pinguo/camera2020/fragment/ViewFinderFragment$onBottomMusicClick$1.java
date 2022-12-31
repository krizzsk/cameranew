package us.pinguo.camera2020.fragment;

import android.content.Intent;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
/* loaded from: classes3.dex */
public final class ViewFinderFragment$onBottomMusicClick$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$onBottomMusicClick$1(ViewFinderFragment viewFinderFragment) {
        super(0);
        this.this$0 = viewFinderFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.startActivityForResult(new Intent("us.pinguo.camera360.MUSIC_LIST"), 1001);
    }
}

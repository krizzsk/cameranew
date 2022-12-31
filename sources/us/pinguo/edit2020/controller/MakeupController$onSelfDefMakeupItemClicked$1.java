package us.pinguo.edit2020.controller;

import android.view.View;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import us.pinguo.repository2020.entity.SelfDefMakeupMaterial;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MakeupController.kt */
/* loaded from: classes4.dex */
public final class MakeupController$onSelfDefMakeupItemClicked$1 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ int $currentFaceIndex;
    final /* synthetic */ Ref$BooleanRef $isNeedDownload;
    final /* synthetic */ View $itemView;
    final /* synthetic */ int $lastFaceIndex;
    final /* synthetic */ SelfDefMakeupMaterial $selfDefMakeupMaterial;
    final /* synthetic */ int $selfDefMakeupTab;
    final /* synthetic */ MakeupController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MakeupController$onSelfDefMakeupItemClicked$1(Ref$BooleanRef ref$BooleanRef, MakeupController makeupController, int i2, int i3, int i4, View view, SelfDefMakeupMaterial selfDefMakeupMaterial) {
        super(1);
        this.$isNeedDownload = ref$BooleanRef;
        this.this$0 = makeupController;
        this.$selfDefMakeupTab = i2;
        this.$currentFaceIndex = i3;
        this.$lastFaceIndex = i4;
        this.$itemView = view;
        this.$selfDefMakeupMaterial = selfDefMakeupMaterial;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        if (z) {
            this.$isNeedDownload.element = false;
            this.this$0.d0(this.$selfDefMakeupTab, this.$currentFaceIndex, this.$lastFaceIndex, this.$itemView, this.$selfDefMakeupMaterial);
        }
    }
}

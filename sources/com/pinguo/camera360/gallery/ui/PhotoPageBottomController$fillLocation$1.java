package com.pinguo.camera360.gallery.ui;

import android.widget.TextView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.gallery.ui.PhotoPageBottomController;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import us.pinguo.inspire.module.profile.GeoResp;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PhotoPageBottomController.kt */
/* loaded from: classes3.dex */
public final class PhotoPageBottomController$fillLocation$1 extends Lambda implements kotlin.jvm.b.l<GeoResp, kotlin.u> {
    final /* synthetic */ PhotoPageBottomController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoPageBottomController$fillLocation$1(PhotoPageBottomController photoPageBottomController) {
        super(1);
        this.this$0 = photoPageBottomController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(GeoResp geoResp) {
        invoke2(geoResp);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(GeoResp it) {
        CharSequence h0;
        PhotoPageBottomController.c cVar;
        PhotoPageBottomController.c cVar2;
        PhotoPageBottomController.c cVar3;
        kotlin.jvm.internal.s.h(it, "it");
        StringBuilder sb = new StringBuilder();
        String str = it.info.country;
        kotlin.jvm.internal.s.g(str, "it.info.country");
        if (str.length() > 0) {
            sb.append(it.info.country);
            sb.append(" - ");
        }
        String str2 = it.info.province;
        kotlin.jvm.internal.s.g(str2, "it.info.province");
        if (str2.length() > 0) {
            sb.append(it.info.province);
            sb.append(" - ");
        }
        String str3 = it.info.city;
        kotlin.jvm.internal.s.g(str3, "it.info.city");
        if (str3.length() > 0) {
            sb.append(it.info.city);
        }
        h0 = StringsKt__StringsKt.h0(sb, " - ");
        if (h0.length() > 0) {
            cVar2 = this.this$0.f6464i;
            cVar2.c().setText(h0);
            cVar3 = this.this$0.f6464i;
            TextView c = cVar3.c();
            c.setVisibility(0);
            VdsAgent.onSetViewVisibility(c, 0);
            return;
        }
        cVar = this.this$0.f6464i;
        TextView c2 = cVar.c();
        c2.setVisibility(8);
        VdsAgent.onSetViewVisibility(c2, 8);
    }
}

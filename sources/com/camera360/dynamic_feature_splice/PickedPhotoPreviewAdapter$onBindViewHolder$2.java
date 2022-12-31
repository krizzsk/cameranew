package com.camera360.dynamic_feature_splice;

import android.graphics.Bitmap;
import android.os.Handler;
import com.camera360.dynamic_feature_splice.PickedPhotoPreviewAdapter;
import kotlin.jvm.internal.Lambda;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PickedPhotoPreviewAdapter.kt */
/* loaded from: classes8.dex */
public final class PickedPhotoPreviewAdapter$onBindViewHolder$2 extends Lambda implements kotlin.jvm.b.l<Bitmap, kotlin.u> {
    final /* synthetic */ PickedPhotoPreviewAdapter.a $holder;
    final /* synthetic */ PickedPhotoPreviewAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickedPhotoPreviewAdapter$onBindViewHolder$2(PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter, PickedPhotoPreviewAdapter.a aVar) {
        super(1);
        this.this$0 = pickedPhotoPreviewAdapter;
        this.$holder = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m13invoke$lambda0(PickedPhotoPreviewAdapter this$0, PickedPhotoPreviewAdapter.a holder, Bitmap it) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(it, "$it");
        if (this$0.j()) {
            return;
        }
        holder.b().setImageBitmap(it);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Bitmap it) {
        Handler handler;
        kotlin.jvm.internal.s.h(it, "it");
        if (this.this$0.j()) {
            return;
        }
        handler = this.this$0.c;
        final PickedPhotoPreviewAdapter pickedPhotoPreviewAdapter = this.this$0;
        final PickedPhotoPreviewAdapter.a aVar = this.$holder;
        handler.post(new Runnable() { // from class: com.camera360.dynamic_feature_splice.w
            @Override // java.lang.Runnable
            public final void run() {
                PickedPhotoPreviewAdapter$onBindViewHolder$2.m13invoke$lambda0(PickedPhotoPreviewAdapter.this, aVar, it);
            }
        });
    }
}

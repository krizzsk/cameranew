package com.camera360.dynamic_feature_splice;

import android.graphics.Bitmap;
import android.os.Handler;
import com.camera360.dynamic_feature_splice.SplicePickPhotoItemAdapter;
import kotlin.jvm.internal.Lambda;
import us.pinguo.picker.image.PickManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SplicePickPhotoItemAdapter.kt */
/* loaded from: classes8.dex */
public final class SplicePickPhotoItemAdapter$onBindViewHolder$1 extends Lambda implements kotlin.jvm.b.l<Bitmap, kotlin.u> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ SplicePickPhotoItemAdapter.a $holder;
    final /* synthetic */ boolean $isClickable;
    final /* synthetic */ boolean $ischecked;
    final /* synthetic */ us.pinguo.picker.image.gallery.m $mediaItem;
    final /* synthetic */ int $position;
    final /* synthetic */ SplicePickPhotoItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplicePickPhotoItemAdapter$onBindViewHolder$1(SplicePickPhotoItemAdapter splicePickPhotoItemAdapter, SplicePickPhotoItemAdapter.a aVar, int i2, boolean z, boolean z2, us.pinguo.picker.image.gallery.m mVar, String str) {
        super(1);
        this.this$0 = splicePickPhotoItemAdapter;
        this.$holder = aVar;
        this.$position = i2;
        this.$ischecked = z;
        this.$isClickable = z2;
        this.$mediaItem = mVar;
        this.$filePath = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m16invoke$lambda0(SplicePickPhotoItemAdapter this$0, SplicePickPhotoItemAdapter.a holder, int i2, Bitmap bitmap, boolean z, boolean z2, us.pinguo.picker.image.gallery.m mediaItem, String filePath) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(holder, "$holder");
        kotlin.jvm.internal.s.h(bitmap, "$bitmap");
        kotlin.jvm.internal.s.h(mediaItem, "$mediaItem");
        if (this$0.h() || holder.f() != i2) {
            return;
        }
        holder.a().setImageBitmap(bitmap);
        this$0.v(holder, z, z2);
        PickManager pickManager = PickManager.a;
        int j2 = mediaItem.j();
        int g2 = mediaItem.g();
        kotlin.jvm.internal.s.g(filePath, "filePath");
        Boolean e2 = pickManager.e(j2, g2, filePath);
        if (kotlin.jvm.internal.s.c(e2, Boolean.FALSE)) {
            this$0.v(holder, z, false);
            holder.b().setVisibility(0);
        } else if (e2 == null) {
            pickManager.f(filePath, mediaItem.h(), new SplicePickPhotoItemAdapter$onBindViewHolder$1$1$1(this$0, holder, i2, z));
        }
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Bitmap bitmap) {
        Handler handler;
        kotlin.jvm.internal.s.h(bitmap, "bitmap");
        if (this.this$0.h() || this.$holder.f() != this.$position) {
            return;
        }
        handler = this.this$0.f2171g;
        final SplicePickPhotoItemAdapter splicePickPhotoItemAdapter = this.this$0;
        final SplicePickPhotoItemAdapter.a aVar = this.$holder;
        final int i2 = this.$position;
        final boolean z = this.$ischecked;
        final boolean z2 = this.$isClickable;
        final us.pinguo.picker.image.gallery.m mVar = this.$mediaItem;
        final String str = this.$filePath;
        handler.post(new Runnable() { // from class: com.camera360.dynamic_feature_splice.u0
            @Override // java.lang.Runnable
            public final void run() {
                SplicePickPhotoItemAdapter$onBindViewHolder$1.m16invoke$lambda0(SplicePickPhotoItemAdapter.this, aVar, i2, bitmap, z, z2, mVar, str);
            }
        });
    }
}

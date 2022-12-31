package us.pinguo.picker.image.adapter;

import android.graphics.Bitmap;
import android.os.Handler;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.picker.image.adapter.PickPhotoSetAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PickPhotoSetAdapter.kt */
/* loaded from: classes5.dex */
public final class PickPhotoSetAdapter$onBindViewHolder$1 extends Lambda implements l<Bitmap, u> {
    final /* synthetic */ PickPhotoSetAdapter.a $holder;
    final /* synthetic */ PickPhotoSetAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickPhotoSetAdapter$onBindViewHolder$1(PickPhotoSetAdapter pickPhotoSetAdapter, PickPhotoSetAdapter.a aVar) {
        super(1);
        this.this$0 = pickPhotoSetAdapter;
        this.$holder = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m198invoke$lambda0(PickPhotoSetAdapter this$0, Bitmap it, PickPhotoSetAdapter.a holder) {
        s.h(this$0, "this$0");
        s.h(it, "$it");
        s.h(holder, "$holder");
        if (this$0.f()) {
            return;
        }
        holder.b().setImageBitmap(it);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Bitmap it) {
        Handler handler;
        s.h(it, "it");
        if (this.this$0.f()) {
            return;
        }
        handler = this.this$0.c;
        final PickPhotoSetAdapter pickPhotoSetAdapter = this.this$0;
        final PickPhotoSetAdapter.a aVar = this.$holder;
        handler.post(new Runnable() { // from class: us.pinguo.picker.image.adapter.f
            @Override // java.lang.Runnable
            public final void run() {
                PickPhotoSetAdapter$onBindViewHolder$1.m198invoke$lambda0(PickPhotoSetAdapter.this, it, aVar);
            }
        });
    }
}

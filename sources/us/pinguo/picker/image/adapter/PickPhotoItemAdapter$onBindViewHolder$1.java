package us.pinguo.picker.image.adapter;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.picker.image.PickManager;
import us.pinguo.picker.image.adapter.PickPhotoItemAdapter;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.picker.ImagePickerConfigModel;
import us.pinguo.picker.image.view.CheckImageView;
/* compiled from: PickPhotoItemAdapter.kt */
/* loaded from: classes5.dex */
final class PickPhotoItemAdapter$onBindViewHolder$1 extends Lambda implements l<Bitmap, u> {
    final /* synthetic */ String $filePath;
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    final /* synthetic */ m $mediaItem;
    final /* synthetic */ Ref$IntRef $p;
    final /* synthetic */ CheckImageView $pickCheck;
    final /* synthetic */ PickPhotoItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickPhotoItemAdapter$onBindViewHolder$1(PickPhotoItemAdapter pickPhotoItemAdapter, RecyclerView.ViewHolder viewHolder, Ref$IntRef ref$IntRef, m mVar, String str, CheckImageView checkImageView) {
        super(1);
        this.this$0 = pickPhotoItemAdapter;
        this.$holder = viewHolder;
        this.$p = ref$IntRef;
        this.$mediaItem = mVar;
        this.$filePath = str;
        this.$pickCheck = checkImageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m197invoke$lambda0(PickPhotoItemAdapter this$0, RecyclerView.ViewHolder holder, Ref$IntRef p, Bitmap bitmap, m mediaItem, String filePath, CheckImageView pickCheck) {
        ImagePickerConfigModel j2;
        s.h(this$0, "this$0");
        s.h(holder, "$holder");
        s.h(p, "$p");
        s.h(bitmap, "$bitmap");
        s.h(mediaItem, "$mediaItem");
        if (this$0.h()) {
            return;
        }
        PickPhotoItemAdapter.a aVar = (PickPhotoItemAdapter.a) holder;
        if (aVar.e() != p.element) {
            return;
        }
        aVar.a().setImageBitmap(bitmap);
        PickManager pickManager = PickManager.a;
        int j3 = mediaItem.j();
        int g2 = mediaItem.g();
        s.g(filePath, "filePath");
        Boolean e2 = pickManager.e(j3, g2, filePath);
        if (s.c(e2, Boolean.FALSE)) {
            pickCheck.setVisibility(4);
            View c = aVar.c();
            c.setVisibility(0);
            VdsAgent.onSetViewVisibility(c, 0);
            View b = aVar.b();
            b.setVisibility(0);
            VdsAgent.onSetViewVisibility(b, 0);
        } else if (e2 == null) {
            pickCheck.setVisibility(4);
            View c2 = aVar.c();
            c2.setVisibility(4);
            VdsAgent.onSetViewVisibility(c2, 4);
            pickManager.f(filePath, mediaItem.h(), new PickPhotoItemAdapter$onBindViewHolder$1$1$1(this$0, holder, p, pickCheck));
        } else {
            s.g(pickCheck, "pickCheck");
            j2 = this$0.j();
            int i2 = j2.c() ? 0 : 8;
            pickCheck.setVisibility(i2);
            VdsAgent.onSetViewVisibility(pickCheck, i2);
            View c3 = aVar.c();
            c3.setVisibility(4);
            VdsAgent.onSetViewVisibility(c3, 4);
        }
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Bitmap bitmap) {
        Handler handler;
        s.h(bitmap, "bitmap");
        if (this.this$0.h() || ((PickPhotoItemAdapter.a) this.$holder).e() != this.$p.element) {
            return;
        }
        handler = this.this$0.f11648g;
        final PickPhotoItemAdapter pickPhotoItemAdapter = this.this$0;
        final RecyclerView.ViewHolder viewHolder = this.$holder;
        final Ref$IntRef ref$IntRef = this.$p;
        final m mVar = this.$mediaItem;
        final String str = this.$filePath;
        final CheckImageView checkImageView = this.$pickCheck;
        handler.post(new Runnable() { // from class: us.pinguo.picker.image.adapter.d
            @Override // java.lang.Runnable
            public final void run() {
                PickPhotoItemAdapter$onBindViewHolder$1.m197invoke$lambda0(PickPhotoItemAdapter.this, viewHolder, ref$IntRef, bitmap, mVar, str, checkImageView);
            }
        });
    }
}

package us.pinguo.inspire.module.comment.cell;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.inspire.widget.photopager.InfoTouchImageView;
/* compiled from: ImageInfoCell.kt */
/* loaded from: classes9.dex */
final class ImageInfoCell$onBindViewHolder$2 extends Lambda implements kotlin.jvm.b.l<Bitmap, kotlin.u> {
    final /* synthetic */ Ref$ObjectRef<InfoTouchImageView> $photoImageView;
    final /* synthetic */ ImageInfoCell this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageInfoCell$onBindViewHolder$2(Ref$ObjectRef<InfoTouchImageView> ref$ObjectRef, ImageInfoCell imageInfoCell) {
        super(1);
        this.$photoImageView = ref$ObjectRef;
        this.this$0 = imageInfoCell;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        Ref$ObjectRef<InfoTouchImageView> ref$ObjectRef = this.$photoImageView;
        ImageInfoCell imageInfoCell = this.this$0;
        ref$ObjectRef.element.setImageBitmap(bitmap);
        imageInfoCell.doBlur(bitmap);
    }
}

package us.pinguo.picker.image.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import us.pinguo.picker.image.R;
/* compiled from: ImagePickerActivity.kt */
/* loaded from: classes5.dex */
final class ImagePickerActivity$emptyView$2 extends Lambda implements kotlin.jvm.b.a<View> {
    final /* synthetic */ ImagePickerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickerActivity$emptyView$2(ImagePickerActivity imagePickerActivity) {
        super(0);
        this.this$0 = imagePickerActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m199invoke$lambda0(ImagePickerActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        this$0.H0();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final View invoke() {
        View inflate = LayoutInflater.from(this.this$0).inflate(R.layout.picker_no_photo_layout, (ViewGroup) null, false);
        final ImagePickerActivity imagePickerActivity = this.this$0;
        inflate.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.picker.image.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImagePickerActivity$emptyView$2.m199invoke$lambda0(ImagePickerActivity.this, view);
            }
        });
        return inflate;
    }
}

package us.pinguo.picker.image.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.picker.image.adapter.PickPhotoItemAdapter;
import us.pinguo.picker.image.picker.ImagePickerConfigModel;
import us.pinguo.picker.image.view.CheckImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PickPhotoItemAdapter.kt */
/* loaded from: classes5.dex */
public final class PickPhotoItemAdapter$onBindViewHolder$1$1$1 extends Lambda implements l<Boolean, u> {
    final /* synthetic */ RecyclerView.ViewHolder $holder;
    final /* synthetic */ Ref$IntRef $p;
    final /* synthetic */ CheckImageView $pickCheck;
    final /* synthetic */ PickPhotoItemAdapter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickPhotoItemAdapter$onBindViewHolder$1$1$1(PickPhotoItemAdapter pickPhotoItemAdapter, RecyclerView.ViewHolder viewHolder, Ref$IntRef ref$IntRef, CheckImageView checkImageView) {
        super(1);
        this.this$0 = pickPhotoItemAdapter;
        this.$holder = viewHolder;
        this.$p = ref$IntRef;
        this.$pickCheck = checkImageView;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
        invoke2(bool);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        ImagePickerConfigModel j2;
        if (this.this$0.h() || ((PickPhotoItemAdapter.a) this.$holder).e() != this.$p.element) {
            return;
        }
        if (s.c(bool, Boolean.FALSE)) {
            this.$pickCheck.setVisibility(4);
            View c = ((PickPhotoItemAdapter.a) this.$holder).c();
            c.setVisibility(0);
            VdsAgent.onSetViewVisibility(c, 0);
            View b = ((PickPhotoItemAdapter.a) this.$holder).b();
            b.setVisibility(0);
            VdsAgent.onSetViewVisibility(b, 0);
            return;
        }
        CheckImageView pickCheck = this.$pickCheck;
        s.g(pickCheck, "pickCheck");
        j2 = this.this$0.j();
        int i2 = j2.c() ? 0 : 8;
        pickCheck.setVisibility(i2);
        VdsAgent.onSetViewVisibility(pickCheck, i2);
        View c2 = ((PickPhotoItemAdapter.a) this.$holder).c();
        c2.setVisibility(4);
        VdsAgent.onSetViewVisibility(c2, 4);
    }
}

package us.pinguo.edit2020.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.LanFitTextView;
/* compiled from: CommonEditItemAdapter.kt */
/* loaded from: classes4.dex */
public class b0 extends RecyclerView.ViewHolder {
    private final AppCompatImageView a;
    private final TextView b;
    private final AppCompatImageView c;

    /* renamed from: d  reason: collision with root package name */
    private final AppCompatImageView f10124d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f10125e;

    /* renamed from: f  reason: collision with root package name */
    private final View f10126f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        AppCompatImageView appCompatImageView = (AppCompatImageView) itemView.findViewById(R.id.imgFunctionIcon);
        kotlin.jvm.internal.s.g(appCompatImageView, "itemView.imgFunctionIcon");
        this.a = appCompatImageView;
        LanFitTextView lanFitTextView = (LanFitTextView) itemView.findViewById(R.id.txtFunctionName);
        kotlin.jvm.internal.s.g(lanFitTextView, "itemView.txtFunctionName");
        this.b = lanFitTextView;
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) itemView.findViewById(R.id.imgVipIcon);
        kotlin.jvm.internal.s.g(appCompatImageView2, "itemView.imgVipIcon");
        this.c = appCompatImageView2;
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) itemView.findViewById(R.id.viewAppliedTag);
        kotlin.jvm.internal.s.g(appCompatImageView3, "itemView.viewAppliedTag");
        this.f10124d = appCompatImageView3;
        TextView textView = (TextView) itemView.findViewById(R.id.txtValue);
        kotlin.jvm.internal.s.g(textView, "itemView.txtValue");
        this.f10125e = textView;
        this.f10126f = itemView.findViewById(R.id.vRedDot);
    }

    public final AppCompatImageView a() {
        return this.a;
    }

    public final AppCompatImageView b() {
        return this.c;
    }

    public final TextView c() {
        return this.b;
    }

    public final TextView d() {
        return this.f10125e;
    }

    public final AppCompatImageView e() {
        return this.f10124d;
    }

    public final View f() {
        return this.f10126f;
    }
}

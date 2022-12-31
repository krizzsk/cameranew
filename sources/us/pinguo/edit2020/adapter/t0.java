package us.pinguo.edit2020.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
import us.pinguo.edit2020.R;
/* compiled from: BackgroundTemplateAdapter.kt */
/* loaded from: classes4.dex */
public final class t0 extends RecyclerView.ViewHolder {
    private final SimpleDraweeView a;
    private final ImageView b;
    private final ImageView c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f10146d;

    /* renamed from: e  reason: collision with root package name */
    private final View f10147e;

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f10148f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f10149g;

    /* renamed from: h  reason: collision with root package name */
    private final FilterPackageDownloadView f10150h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f10151i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f10152j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.h(itemView, "itemView");
        this.a = (SimpleDraweeView) itemView.findViewById(R.id.imgMain);
        this.b = (ImageView) itemView.findViewById(R.id.imgDownloadIcon);
        this.c = (ImageView) itemView.findViewById(R.id.imgCirclePalette);
        this.f10146d = (ImageView) itemView.findViewById(R.id.imgVip);
        this.f10147e = itemView.findViewById(R.id.viewMask);
        this.f10148f = (ImageView) itemView.findViewById(R.id.imgNull);
        this.f10149g = (ImageView) itemView.findViewById(R.id.imgAdj);
        this.f10150h = (FilterPackageDownloadView) itemView.findViewById(R.id.progressView);
        this.f10151i = (TextView) itemView.findViewById(R.id.txtDescription);
        this.f10152j = (TextView) itemView.findViewById(R.id.txtNull);
    }

    public final ImageView a() {
        return this.f10149g;
    }

    public final ImageView b() {
        return this.b;
    }

    public final SimpleDraweeView c() {
        return this.a;
    }

    public final ImageView d() {
        return this.f10148f;
    }

    public final ImageView e() {
        return this.c;
    }

    public final ImageView f() {
        return this.f10146d;
    }

    public final FilterPackageDownloadView g() {
        return this.f10150h;
    }

    public final TextView h() {
        return this.f10151i;
    }

    public final TextView i() {
        return this.f10152j;
    }

    public final View j() {
        return this.f10147e;
    }
}

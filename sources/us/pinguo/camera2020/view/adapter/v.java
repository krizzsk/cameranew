package us.pinguo.camera2020.view.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import us.pinguo.camera2020.R;
import us.pinguo.common.filter.view.FilterPackageDownloadView;
/* compiled from: StickerRecyclerAdapter.kt */
/* loaded from: classes3.dex */
public final class v extends RecyclerView.ViewHolder {
    private final SimpleDraweeView a;
    private final ImageView b;
    private final ImageView c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f9380d;

    /* renamed from: e  reason: collision with root package name */
    private final FilterPackageDownloadView f9381e;

    /* renamed from: f  reason: collision with root package name */
    private final View f9382f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(View view) {
        super(view);
        kotlin.jvm.internal.s.h(view, "view");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.imgStickerIcon);
        kotlin.jvm.internal.s.g(simpleDraweeView, "view.imgStickerIcon");
        this.a = simpleDraweeView;
        ImageView imageView = (ImageView) view.findViewById(R.id.imgVipIcon);
        kotlin.jvm.internal.s.g(imageView, "view.imgVipIcon");
        this.b = imageView;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imgMusicIcon);
        kotlin.jvm.internal.s.g(imageView2, "view.imgMusicIcon");
        this.c = imageView2;
        ImageView imageView3 = (ImageView) view.findViewById(R.id.imgDownloadIcon);
        kotlin.jvm.internal.s.g(imageView3, "view.imgDownloadIcon");
        this.f9380d = imageView3;
        FilterPackageDownloadView filterPackageDownloadView = (FilterPackageDownloadView) view.findViewById(R.id.pgDownloading);
        kotlin.jvm.internal.s.g(filterPackageDownloadView, "view.pgDownloading");
        this.f9381e = filterPackageDownloadView;
        View findViewById = view.findViewById(R.id.stickerRedDot);
        kotlin.jvm.internal.s.g(findViewById, "view.stickerRedDot");
        this.f9382f = findViewById;
    }

    public final ImageView a() {
        return this.f9380d;
    }

    public final ImageView b() {
        return this.c;
    }

    public final SimpleDraweeView c() {
        return this.a;
    }

    public final ImageView d() {
        return this.b;
    }

    public final FilterPackageDownloadView e() {
        return this.f9381e;
    }

    public final View f() {
        return this.f9382f;
    }
}

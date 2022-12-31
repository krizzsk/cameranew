package us.pinguo.inspire.widget.videocell;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import java.io.File;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.widget.video.WorkDetailVideoView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.util.q;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* compiled from: InspireBaseVideoCell.java */
/* loaded from: classes9.dex */
public abstract class d<T, VH extends us.pinguo.widget.common.cell.recycler.c> extends us.pinguo.inspire.cell.recycler.a<T, VH> {
    private static final float MAX_RATE = 1.7777778f;
    private static final float MIN_RATE = 0.5625f;
    private static int mScreenWidth = us.pinguo.foundation.t.b.a.j(Inspire.a());
    private us.pinguo.inspire.b0.a mClickVideoListener;
    private boolean mDefaultSilent;
    private boolean mIsSilent;
    private String mOriginUrl;
    protected f mPresenter;
    private us.pinguo.inspire.b0.b videoLoadCompleteListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InspireBaseVideoCell.java */
    /* loaded from: classes9.dex */
    public class a implements com.nostra13.universalimageloader.core.k.a {
        final /* synthetic */ InspireVideoView a;

        a(InspireVideoView inspireVideoView) {
            this.a = inspireVideoView;
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingCancelled(String str, View view) {
            us.pinguo.common.log.a.m("baseVideoCell", "onLoadingCancelled", new Object[0]);
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            us.pinguo.common.log.a.m("baseVideoCell", "onLoadingComplete", new Object[0]);
            if (view == null || bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                return;
            }
            d.this.refreshVideoSize(bitmap.getWidth(), bitmap.getHeight());
            b bVar = new b();
            bVar.a = bitmap.getWidth();
            bVar.b = bitmap.getHeight();
            d.this.showPhoto(this.a, bVar, str);
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            us.pinguo.common.log.a.m("baseVideoCell", "onLoadingFailed", new Object[0]);
        }

        @Override // com.nostra13.universalimageloader.core.k.a
        public void onLoadingStarted(String str, View view) {
            us.pinguo.common.log.a.m("baseVideoCell", "onLoadingStarted", new Object[0]);
        }
    }

    /* compiled from: InspireBaseVideoCell.java */
    /* loaded from: classes9.dex */
    public static class b {
        public int a;
        public int b;
        public int c;
    }

    public d(T t) {
        super(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        this.mClickVideoListener.a(this);
    }

    private void onBindVideoView(us.pinguo.widget.common.cell.recycler.c cVar) {
        String videoUrl = getVideoUrl();
        InspireVideoView videoView = getVideoView(cVar);
        if (!TextUtils.isEmpty(videoUrl)) {
            if (videoView == null) {
                return;
            }
            b containerSize = getContainerSize();
            if (containerSize != null) {
                showHotVideoPhoto(videoView, containerSize, videoUrl);
            } else {
                showPhoto(videoView, getViewSize(), videoUrl);
            }
            showCoverView();
            us.pinguo.inspire.b0.b bVar = this.videoLoadCompleteListener;
            if (bVar != null) {
                bVar.a(videoUrl);
            }
        }
        this.mIsSilent = this.mDefaultSilent;
        refreshSilent();
        cVar.setOnClickListener(R.id.iv_play_video_view, new View.OnClickListener() { // from class: us.pinguo.inspire.widget.videocell.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.b(view);
            }
        });
        if (videoView != null) {
            if (q.h(cVar.itemView.getContext())) {
                videoView.c();
            } else {
                videoView.l();
            }
        }
    }

    private void refreshSilent() {
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public VH createViewHolder(ViewGroup viewGroup) {
        return null;
    }

    public us.pinguo.inspire.b0.a getClickVideoListener() {
        return this.mClickVideoListener;
    }

    protected b getContainerSize() {
        return null;
    }

    public InspireVideoView getInspireVideoView() {
        VH vh = this.mViewHolder;
        if (vh != null) {
            return getVideoView(vh);
        }
        return null;
    }

    protected b getMayBeVideoSize() {
        return null;
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    protected String getShowKey() {
        return null;
    }

    @Override // us.pinguo.inspire.cell.recycler.a
    protected String getTimeKey() {
        return null;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    public us.pinguo.inspire.b0.b getVideoLoadCompleteListener() {
        return this.videoLoadCompleteListener;
    }

    public abstract String getVideoUrl();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract InspireVideoView getVideoView(us.pinguo.widget.common.cell.recycler.c cVar);

    public BaseVideoTextureView getVideoView() {
        InspireVideoView videoView;
        VH vh = this.mViewHolder;
        if (vh == null || (videoView = getVideoView(vh)) == null) {
            return null;
        }
        return videoView.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract b getViewSize();

    public boolean isSilent() {
        return this.mIsSilent;
    }

    protected abstract void onBindOtherView(us.pinguo.widget.common.cell.recycler.c cVar);

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        onBindVideoView(cVar);
        onBindOtherView(cVar);
    }

    public void onVideoPrepared() {
    }

    public void onVideoStart() {
        float f2;
        int i2;
        b viewSize = getViewSize();
        if (viewSize != null && (viewSize.a <= 1 || viewSize.b <= 1)) {
            InspireVideoView videoView = getVideoView(this.mViewHolder);
            File file = ImageLoader.getInstance().m().get(this.mOriginUrl);
            if (file != null && file.exists()) {
                WorkDetailVideoView b2 = videoView.b();
                b2.e();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                int i3 = viewSize.c;
                if (i3 != 90 && i3 != 270) {
                    f2 = options.outWidth;
                    i2 = options.outHeight;
                } else {
                    f2 = options.outHeight;
                    i2 = options.outWidth;
                }
                float f3 = f2 / i2;
                if (f3 < MIN_RATE) {
                    f3 = MIN_RATE;
                }
                int measuredWidth = videoView.getMeasuredWidth() > 0 ? videoView.getMeasuredWidth() : mScreenWidth;
                int i4 = (int) (measuredWidth / f3);
                if (f3 < 0.75f) {
                    i4 = (int) (mScreenWidth / 0.75f);
                    measuredWidth = (int) (i4 * f3);
                }
                b2.setVideoSize(measuredWidth, i4);
                refreshVideoSize(measuredWidth, i4);
            }
        }
        InspireVideoView videoView2 = getVideoView(this.mViewHolder);
        if (videoView2 != null) {
            videoView2.b().a(true);
            videoView2.k();
            videoView2.n();
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b, us.pinguo.widget.common.cell.recycler.c.a
    public void onViewRecycled() {
        super.onViewRecycled();
        this.mPresenter = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refreshVideoSize(int i2, int i3) {
    }

    public void setClickVideoListener(us.pinguo.inspire.b0.a aVar) {
        this.mClickVideoListener = aVar;
    }

    public void setDefaultSilent(boolean z) {
        this.mDefaultSilent = z;
    }

    public void setPresenter(f fVar) {
        this.mPresenter = fVar;
    }

    public void setSilent(boolean z) {
        this.mIsSilent = z;
        if (this.mViewHolder != null) {
            refreshSilent();
        }
    }

    public void setVideoLoadCompleteListener(us.pinguo.inspire.b0.b bVar) {
        this.videoLoadCompleteListener = bVar;
    }

    public void showCoverView() {
        InspireVideoView videoView;
        VH vh = this.mViewHolder;
        if (vh == null || (videoView = getVideoView(vh)) == null) {
            return;
        }
        videoView.b().a(false);
        videoView.k();
    }

    protected void showHotVideoPhoto(InspireVideoView inspireVideoView, b bVar, String str) {
        float f2;
        int i2;
        int i3;
        int i4 = bVar.c;
        if (i4 != 90 && i4 != 270) {
            f2 = bVar.a;
            i2 = bVar.b;
        } else {
            f2 = bVar.b;
            i2 = bVar.a;
        }
        float f3 = f2 / i2;
        PhotoImageView a2 = inspireVideoView.a();
        WorkDetailVideoView b2 = inspireVideoView.b();
        b mayBeVideoSize = getMayBeVideoSize();
        if (mayBeVideoSize != null) {
            i3 = mayBeVideoSize.b;
            int i5 = mayBeVideoSize.a;
            int i6 = bVar.b;
            int i7 = i3 > i6 ? (-(i3 - i6)) / 2 : 0;
            int i8 = bVar.a;
            inspireVideoView.setVideoMargin(i7, i5 > i8 ? (-(i5 - i8)) / 2 : 0);
            r6 = i5;
        } else {
            i3 = 0;
        }
        inspireVideoView.setRate(f3);
        b2.setRotation(bVar.c);
        int i9 = bVar.c;
        if (i9 != 90 && i9 != 270) {
            b2.setVideoSize(r6, i3);
        } else {
            b2.setVideoSize(i3, r6);
        }
        b2.setCoverView(a2);
        b viewSize = getViewSize();
        int i10 = viewSize.b;
        int i11 = viewSize.a;
        if (i10 * i11 < i3 * r6) {
            r6 = i11;
            i3 = i10;
        }
        a2.setVideoImageUrl(str, r6, i3);
        a2.setSize(bVar.a, bVar.b);
    }

    protected void showPhoto(InspireVideoView inspireVideoView, b bVar, String str) {
        float f2;
        int i2;
        int i3;
        if (bVar.a > 1 && bVar.b > 1) {
            mScreenWidth = us.pinguo.foundation.t.b.a.j(inspireVideoView.getContext());
            int i4 = bVar.c;
            if (i4 != 90 && i4 != 270) {
                f2 = bVar.a;
                i2 = bVar.b;
            } else {
                f2 = bVar.b;
                i2 = bVar.a;
            }
            float f3 = f2 / i2;
            int measuredWidth = inspireVideoView.getMeasuredWidth() > 0 ? inspireVideoView.getMeasuredWidth() : mScreenWidth;
            int i5 = (int) (measuredWidth / f3);
            int i6 = (f3 > 0.75f ? 1 : (f3 == 0.75f ? 0 : -1));
            if (i6 < 0) {
                i5 = (int) (mScreenWidth / 0.75f);
                measuredWidth = (int) (i5 * f3);
            }
            PhotoImageView a2 = inspireVideoView.a();
            a2.setVisibility(0);
            WorkDetailVideoView b2 = inspireVideoView.b();
            b mayBeVideoSize = getMayBeVideoSize();
            if (mayBeVideoSize != null) {
                i5 = mayBeVideoSize.b;
                measuredWidth = mayBeVideoSize.a;
                int i7 = bVar.b;
                int i8 = i5 > i7 ? (-(i5 - i7)) / 2 : 0;
                int i9 = bVar.a;
                inspireVideoView.setVideoMargin(i8, measuredWidth > i9 ? (-(measuredWidth - i9)) / 2 : 0);
            }
            if (i6 < 0) {
                f3 = 0.75f;
            }
            inspireVideoView.setRate(f3);
            b2.setRotation(bVar.c);
            int i10 = bVar.c;
            if (i10 != 90 && i10 != 270) {
                b2.setVideoSize(measuredWidth, i5);
            } else {
                b2.setVideoSize(i5, measuredWidth);
            }
            b2.setCoverView(a2);
            int i11 = bVar.b;
            if (i11 <= 1 || (i3 = bVar.a) <= 1 || i11 * i3 >= i5 * measuredWidth) {
                i3 = measuredWidth;
                i11 = i5;
            }
            a2.setVideoImageUrl(str, i3, i11);
            if (mayBeVideoSize != null) {
                a2.setSize(bVar.a, bVar.b);
                return;
            } else {
                a2.setSize(measuredWidth, i5);
                return;
            }
        }
        String addQiNiuSuffix = PhotoImageView.addQiNiuSuffix(str, 0, 0, true);
        this.mOriginUrl = addQiNiuSuffix;
        ImageLoader.getInstance().i(addQiNiuSuffix, inspireVideoView.a(), new a(inspireVideoView));
    }

    public void showPlayView() {
        InspireVideoView videoView;
        VH vh = this.mViewHolder;
        if (vh == null || (videoView = getVideoView(vh)) == null) {
            return;
        }
        videoView.l();
    }
}

package us.pinguo.inspire.module.comment.cell;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.comment.IInfoView;
import us.pinguo.inspire.module.comment.widget.InfoVideoView;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.user.util.f;
import vStudio.Android.Camera360.R;
/* compiled from: VideoInfoCell.kt */
/* loaded from: classes9.dex */
public final class VideoInfoCell extends ContentInfoCell implements f.b, IVideoInfo {
    private final us.pinguo.user.util.f mDoubleClickDetector;
    private Bitmap mWebpSnapshot;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoInfoCell(InspireWork data) {
        super(data);
        kotlin.jvm.internal.s.h(data, "data");
        this.mDoubleClickDetector = new us.pinguo.user.util.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doThumnailBlur(Bitmap bitmap) {
        doBlur(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m177onBindViewHolder$lambda0(VideoInfoCell this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        IInfoView infoView = this$0.getInfoView();
        boolean z = false;
        if (infoView != null && infoView.isCommentLayoutShowing()) {
            z = true;
        }
        if (z) {
            return;
        }
        this$0.mDoubleClickDetector.d(view, this$0);
    }

    @Override // us.pinguo.inspire.y.a.b
    public us.pinguo.inspire.y.a.c createViewHolder(ViewGroup parent) {
        kotlin.jvm.internal.s.h(parent, "parent");
        return new us.pinguo.inspire.y.a.c(LayoutInflater.from(parent.getContext()).inflate(R.layout.info_video_cell, parent, false));
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public View getShareElement() {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        InfoVideoView infoVideoView = mViewHolder == null ? null : (InfoVideoView) mViewHolder.a(R.id.info_video_view);
        if (infoVideoView == null) {
            return null;
        }
        return infoVideoView.getContentLayout();
    }

    @Override // us.pinguo.inspire.y.a.b
    public int getType() {
        return BaseInfoCell.Companion.getTYPE_VIDEO();
    }

    @Override // us.pinguo.inspire.module.comment.cell.IVideoInfo
    public String getVideoUrl() {
        return getMData().getWorkUrl();
    }

    @Override // us.pinguo.inspire.module.comment.cell.IVideoInfo
    public InfoVideoView getVideoView() {
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        if (mViewHolder == null) {
            return null;
        }
        return (InfoVideoView) mViewHolder.a(R.id.info_video_view);
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public boolean isContentPreparedForShare() {
        return true;
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public boolean isFullScreen(View root) {
        kotlin.jvm.internal.s.h(root, "root");
        us.pinguo.inspire.y.a.c mViewHolder = getMViewHolder();
        InfoVideoView infoVideoView = mViewHolder == null ? null : (InfoVideoView) mViewHolder.a(R.id.info_video_view);
        BaseVideoTextureView videoView = infoVideoView != null ? infoVideoView.getVideoView() : null;
        int[] iArr = new int[2];
        if (videoView != null) {
            videoView.getLocationInWindow(iArr);
        }
        if (iArr[0] <= 0) {
            return (videoView == null ? 0 : videoView.getHeight()) >= root.getHeight();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.module.comment.cell.ContentInfoCell, us.pinguo.inspire.module.comment.cell.BaseInfoCell, us.pinguo.inspire.y.a.b
    public void onBindViewHolder(us.pinguo.inspire.y.a.c viewHolder) {
        kotlin.jvm.internal.s.h(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder);
        InfoVideoView infoVideoView = (InfoVideoView) viewHolder.a(R.id.info_video_view);
        View a = viewHolder.a(R.id.iv_progress_video_view);
        kotlin.jvm.internal.s.g(a, "viewHolder.getView(R.id.iv_progress_video_view)");
        infoVideoView.setVideoProgressView(a);
        View contentLayout = infoVideoView.getContentLayout();
        us.pinguo.inspire.util.transition.h hVar = us.pinguo.inspire.util.transition.h.a;
        ViewCompat.setTransitionName(contentLayout, hVar.i(getMData()));
        if (hVar.q(getMData())) {
            infoVideoView.getContentLayout().setTag(R.id.tag_rotated, Float.valueOf(90.0f));
        } else {
            infoVideoView.getContentLayout().setTag(R.id.tag_rotated, null);
        }
        String workUrl = getMData().getWorkUrl();
        kotlin.jvm.internal.s.g(workUrl, "mData.getWorkUrl()");
        infoVideoView.loadCover(workUrl, getMData().getWidth(), getMData().getHeight(), new com.nostra13.universalimageloader.core.k.c() { // from class: us.pinguo.inspire.module.comment.cell.VideoInfoCell$onBindViewHolder$1
            @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                super.onLoadingComplete(str, view, bitmap);
                if (bitmap != null) {
                    VideoInfoCell.this.doThumnailBlur(bitmap);
                }
            }
        });
        infoVideoView.getVideoView().setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoInfoCell.m177onBindViewHolder$lambda0(VideoInfoCell.this, view);
            }
        });
        if (getShowTransition()) {
            setShowTransition(false);
            ViewCompat.setTransitionName(viewHolder.b, "blurBg");
        }
    }

    @Override // us.pinguo.user.util.f.b
    public void onDoubleClick(View view) {
        f.b onDoubleClickListener = getOnDoubleClickListener();
        if (onDoubleClickListener == null) {
            return;
        }
        onDoubleClickListener.onDoubleClick(getVideoView());
    }

    @Override // us.pinguo.user.util.f.b
    public void onSingleClick(View view) {
        f.b onDoubleClickListener = getOnDoubleClickListener();
        if (onDoubleClickListener == null) {
            return;
        }
        onDoubleClickListener.onSingleClick(getVideoView());
    }

    @Override // us.pinguo.inspire.y.a.b
    public void onViewRecycled() {
        super.onViewRecycled();
    }

    public final void setWebpSnapshot(Bitmap bitmap) {
        kotlin.jvm.internal.s.h(bitmap, "bitmap");
        this.mWebpSnapshot = bitmap;
    }
}

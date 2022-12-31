package us.pinguo.inspire.module.comment.cell;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.model.InspireWorkBulkLoader;
import us.pinguo.inspire.module.comment.FeedsInfoFragment;
import us.pinguo.inspire.module.comment.widget.FlingDownViewPager;
import us.pinguo.inspire.module.comment.widget.InfoVideoView;
import vStudio.Android.Camera360.R;
/* compiled from: VideoAdInfoCell.kt */
/* loaded from: classes9.dex */
public final class VideoAdInfoCell extends BaseInfoCell implements IVideoInfo {
    private final InspireWorkBulkLoader.AdVideo adData;
    private final String taskId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoAdInfoCell(InspireWorkBulkLoader.AdVideo adData, String taskId) {
        super(new InspireWork());
        kotlin.jvm.internal.s.h(adData, "adData");
        kotlin.jvm.internal.s.h(taskId, "taskId");
        this.adData = adData;
        this.taskId = taskId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m175onBindViewHolder$lambda0(VideoAdInfoCell this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        FlingDownViewPager flingDownViewPager = (FlingDownViewPager) view.getRootView().findViewById(R.id.feeds_detail_viewpager);
        int currentItem = flingDownViewPager.getCurrentItem();
        PagerAdapter adapter = flingDownViewPager.getAdapter();
        Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getCount());
        kotlin.jvm.internal.s.e(valueOf);
        int i2 = currentItem + 1;
        if (valueOf.intValue() > i2) {
            flingDownViewPager.setCurrentItem(i2, true);
        }
        us.pinguo.foundation.statistics.h.a.M(FeedsInfoFragment.Companion.getElement_id(), "pass", "", this$0.taskId, "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m176onBindViewHolder$lambda1(VideoAdInfoCell this$0, View view) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (TextUtils.isEmpty(this$0.adData.adGotoUrl)) {
            return;
        }
        us.pinguo.foundation.statistics.h.a.M(FeedsInfoFragment.Companion.getElement_id(), "learn_more", "", this$0.taskId, "click");
        us.pinguo.foundation.interaction.c c = AppGoto.getInstance().c(this$0.adData.adGotoUrl);
        c.c("force_inner_browser", true);
        c.b(view.getContext());
    }

    @Override // us.pinguo.inspire.y.a.b
    public us.pinguo.inspire.y.a.c createViewHolder(ViewGroup parent) {
        kotlin.jvm.internal.s.h(parent, "parent");
        return new us.pinguo.inspire.y.a.c(LayoutInflater.from(parent.getContext()).inflate(R.layout.info_video_ad_cell, parent, false));
    }

    public final InspireWorkBulkLoader.AdVideo getAdData() {
        return this.adData;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    @Override // us.pinguo.inspire.y.a.b
    public int getType() {
        return BaseInfoCell.Companion.getTYPE_VIDEO_AD();
    }

    @Override // us.pinguo.inspire.module.comment.cell.IVideoInfo
    public String getVideoUrl() {
        String str = this.adData.workUrl;
        kotlin.jvm.internal.s.g(str, "adData.workUrl");
        return str;
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
        return false;
    }

    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell
    public boolean isFullScreen(View root) {
        kotlin.jvm.internal.s.h(root, "root");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.module.comment.cell.BaseInfoCell, us.pinguo.inspire.y.a.b
    public void onBindViewHolder(us.pinguo.inspire.y.a.c viewHolder) {
        kotlin.jvm.internal.s.h(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder);
        InfoVideoView infoVideoView = (InfoVideoView) viewHolder.a(R.id.info_video_view);
        View a = viewHolder.a(R.id.iv_progress_video_view);
        kotlin.jvm.internal.s.g(a, "viewHolder.getView(R.id.iv_progress_video_view)");
        infoVideoView.setVideoProgressView(a);
        infoVideoView.getCoverImg().setSimpleImageLoadingListener(new com.nostra13.universalimageloader.core.k.c() { // from class: us.pinguo.inspire.module.comment.cell.VideoAdInfoCell$onBindViewHolder$1
            @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                if (bitmap != null) {
                    VideoAdInfoCell.this.doBlur(bitmap);
                }
            }
        });
        String str = this.adData.workUrl;
        kotlin.jvm.internal.s.g(str, "adData.workUrl");
        InspireWorkBulkLoader.AdVideo adVideo = this.adData;
        infoVideoView.loadCover(str, adVideo.width, adVideo.height, null);
        if (getShowTransition()) {
            InspireWorkBulkLoader.AdVideo adVideo2 = this.adData;
            infoVideoView.setupVideoSize(adVideo2.width, adVideo2.height, 0);
            setShowTransition(false);
            ViewCompat.setTransitionName(viewHolder.b, "blurBg");
        }
        viewHolder.b(R.id.dialog_video_pass_res_0x7d060073, new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoAdInfoCell.m175onBindViewHolder$lambda0(VideoAdInfoCell.this, view);
            }
        });
        if (TextUtils.isEmpty(this.adData.adGotoUrl)) {
            viewHolder.e(R.id.dialog_video_detail, 8);
            return;
        }
        viewHolder.e(R.id.dialog_video_detail, 0);
        viewHolder.b(R.id.dialog_video_detail, new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.cell.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoAdInfoCell.m176onBindViewHolder$lambda1(VideoAdInfoCell.this, view);
            }
        });
    }
}

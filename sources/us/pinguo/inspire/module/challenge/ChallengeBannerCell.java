package us.pinguo.inspire.module.challenge;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireTaskBulkLoader;
import us.pinguo.inspire.module.feeds.cell.FeedsBannerCell;
import vStudio.Android.Camera360.R;
/* compiled from: ChallengeBannerCell.kt */
/* loaded from: classes9.dex */
public final class ChallengeBannerCell extends FeedsBannerCell implements View.OnClickListener {
    private InspireTaskBulkLoader.TaskListBanner bannerData;
    private com.nostra13.universalimageloader.core.c imageOptions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeBannerCell(List<? extends AdvItem> advItems, String advConfig) {
        super(advItems, advConfig);
        s.h(advItems, "advItems");
        s.h(advConfig, "advConfig");
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsBannerCell, us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        us.pinguo.widget.common.cell.recycler.c createViewHolder = super.createViewHolder(viewGroup);
        View inflate = LayoutInflater.from(viewGroup == null ? null : viewGroup.getContext()).inflate(R.layout.challenge_banner_cell, viewGroup, false);
        ((FrameLayout) inflate.findViewById(R.id.banner_container)).addView(createViewHolder.itemView);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.challenge_banner_bottom_img);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.nostra13.universalimageloader.core.c t = com.nostra13.universalimageloader.core.c.t();
        this.imageOptions = t;
        BitmapFactory.Options u = t == null ? null : t.u();
        if (u != null) {
            u.inDensity = 320;
        }
        com.nostra13.universalimageloader.core.c cVar = this.imageOptions;
        BitmapFactory.Options u2 = cVar != null ? cVar.u() : null;
        if (u2 != null) {
            u2.inTargetDensity = imageView.getResources().getDisplayMetrics().densityDpi;
        }
        return new us.pinguo.widget.common.cell.recycler.c(inflate);
    }

    public final InspireTaskBulkLoader.TaskListBanner getBannerData() {
        return this.bannerData;
    }

    public final com.nostra13.universalimageloader.core.c getImageOptions() {
        return this.imageOptions;
    }

    @Override // us.pinguo.inspire.module.feeds.cell.FeedsBannerCell, us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c viewHolder) {
        s.h(viewHolder, "viewHolder");
        super.onBindViewHolder(viewHolder);
        viewHolder.setOnClickListener(R.id.challenge_banner_bottom_img, this);
        updadeBannerData();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        String str;
        s.h(v, "v");
        if (v.getId() == R.id.challenge_banner_bottom_img) {
            InspireTaskBulkLoader.TaskListBanner taskListBanner = this.bannerData;
            if (TextUtils.isEmpty(taskListBanner == null ? null : taskListBanner.gotoUrl)) {
                str = s.q(Inspire.f11205f, "/challengeRank/index.html");
            } else {
                InspireTaskBulkLoader.TaskListBanner taskListBanner2 = this.bannerData;
                s.e(taskListBanner2);
                str = taskListBanner2.gotoUrl;
                s.g(str, "{\n                    ba…gotoUrl\n                }");
            }
            us.pinguo.foundation.interaction.c c = AppGoto.getInstance().c(str);
            c.c("force_inner_browser", true);
            c.b(v.getContext());
            us.pinguo.foundation.statistics.h.a.B0("challenge_task_list_rank_entrence", "click");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onShow() {
        String str;
        super.onShow();
        us.pinguo.common.log.a.d("ChallengeBannerCell", "show", new Object[0]);
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        AdvItem advItem = this.mCurrentAdvItem;
        String str2 = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
        if (advItem != null && (str = advItem.advId) != null) {
            str2 = str;
        }
        cVar.A0("challenge_task_list_page_top_banner", str2, "show");
    }

    public final void setBannerData(InspireTaskBulkLoader.TaskListBanner taskListBanner) {
        this.bannerData = taskListBanner;
    }

    public final void setImageOptions(com.nostra13.universalimageloader.core.c cVar) {
        this.imageOptions = cVar;
    }

    public final void updadeBannerData() {
        VH vh = this.mViewHolder;
        if (vh == 0) {
            return;
        }
        s.e(vh);
        ImageView imageView = (ImageView) vh.getView(R.id.challenge_banner_bottom_img);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        InspireTaskBulkLoader.TaskListBanner taskListBanner = this.bannerData;
        if (TextUtils.isEmpty(taskListBanner == null ? null : taskListBanner.imgUrl)) {
            imageView.setVisibility(8);
            return;
        }
        imageView.setVisibility(0);
        ImageLoader imageLoader = ImageLoader.getInstance();
        InspireTaskBulkLoader.TaskListBanner taskListBanner2 = this.bannerData;
        imageLoader.f(taskListBanner2 != null ? taskListBanner2.imgUrl : null, imageView, this.imageOptions);
    }
}

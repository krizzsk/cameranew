package us.pinguo.inspire.module.feeds.cell;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Collection;
import java.util.List;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.challenge.ChallengeBannerCell;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import us.pinguo.inspire.widget.fresco.WebpDraweeView;
import us.pinguo.ui.widget.banner.BannerView;
import us.pinguo.widget.common.cell.recycler.DiffMode;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsBannerCell extends us.pinguo.widget.common.cell.recycler.b<List<AdvItem>, us.pinguo.widget.common.cell.recycler.c> implements AdapterView.OnItemClickListener, us.pinguo.user.recycler.a, AdapterView.OnItemSelectedListener {
    public static final float BANNER_RATE = 2.142857f;
    private static int TIME_SPACE = 30000;
    private static long mLastTime;
    private FeedsBannerAdapter mAdapter;
    private String mAdvConfig;
    protected AdvItem mCurrentAdvItem;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class FeedsBannerAdapter extends us.pinguo.ui.widget.banner.b<AdvItem> {
        private int TYPE_BRAND;
        private int TYPE_MV;
        private int TYPE_PG;
        private float mBannerRate;
        private ImageView.ScaleType mScaleType;

        public FeedsBannerAdapter(float f2) {
            ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
            this.mScaleType = scaleType;
            this.TYPE_BRAND = 1;
            this.TYPE_MV = 2;
            this.TYPE_PG = 3;
            this.mBannerRate = f2;
            this.mScaleType = scaleType;
        }

        @Override // us.pinguo.ui.widget.banner.b
        public int getAutoScrollTime(int i2) {
            if (getItem(i2) != null) {
                return (int) (getItem(i2).duration * 1000.0d);
            }
            return 0;
        }

        @Override // us.pinguo.ui.widget.banner.a, android.widget.Adapter
        public int getCount() {
            if (getRealCount() > 1) {
                return Integer.MAX_VALUE;
            }
            return getRealCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i2) {
            AdvItem item = getItem(i2);
            if (AdvConstants.ADV_TYPE_MV.equals(item.advType)) {
                return this.TYPE_MV;
            }
            if (AdvConstants.ADV_TYPE_PINGUO.equals(item.advType)) {
                return this.TYPE_PG;
            }
            return this.TYPE_BRAND;
        }

        @Override // us.pinguo.ui.widget.banner.b
        public int getRealCount() {
            return super.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r5v3, types: [us.pinguo.inspire.widget.fresco.WebpDraweeView, android.widget.ImageView, us.pinguo.inspire.widget.fresco.QiNiuDraweeView] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v6 */
        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            AdvItem item = getItem(i2);
            FeedsBannerCell.this.mCurrentAdvItem = item;
            ?? r5 = view;
            if (view != null) {
                boolean z = view instanceof WebpDraweeView;
                r5 = view;
                if (!z) {
                    r5 = 0;
                }
            }
            if (r5 == 0) {
                r5 = new WebpDraweeView(viewGroup.getContext());
                int j2 = us.pinguo.foundation.t.b.a.j(viewGroup.getContext());
                int i3 = (int) (j2 / this.mBannerRate);
                r5.setImageSize(j2, i3);
                r5.setLayoutParams(new Gallery.LayoutParams(j2, i3));
            }
            WebpDraweeView webpDraweeView = r5;
            String str = item.imageUrl;
            if (str != null && !str.isEmpty()) {
                webpDraweeView.setWebp(InspirePublishFragment.FILE_HEADER + item.downloadedFilePath, true);
            } else {
                webpDraweeView.setWebp("res://" + Inspire.a().getPackageName() + "/" + item.imgDefault, true);
            }
            return r5;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
        }

        @Override // us.pinguo.ui.widget.banner.a, android.widget.Adapter
        public AdvItem getItem(int i2) {
            if (getRealCount() != 0) {
                i2 %= getRealCount();
            }
            return (AdvItem) super.getItem(i2);
        }

        public FeedsBannerAdapter(float f2, ImageView.ScaleType scaleType) {
            this.mScaleType = ImageView.ScaleType.FIT_XY;
            this.TYPE_BRAND = 1;
            this.TYPE_MV = 2;
            this.TYPE_PG = 3;
            this.mBannerRate = f2;
            this.mScaleType = scaleType;
        }
    }

    public FeedsBannerCell(List<AdvItem> list, String str) {
        super(list);
        this.mAdvConfig = str;
        TIME_SPACE = AdvConfigManager.getInstance().GetAttachValue("feedInterval", 30) * 1000;
    }

    public static FeedsBannerCell getBannerCell(String str) {
        return null;
    }

    public static ChallengeBannerCell getChallengeBabberCell(String str) {
        List<AdvItem> bannerData = us.pinguo.librouter.c.d.b().getInterface().a().getBannerData(str);
        if (bannerData == null) {
            return null;
        }
        return new ChallengeBannerCell(bannerData, str);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        BannerView bannerView = (BannerView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.banner_layout, viewGroup, false);
        int j2 = (int) (us.pinguo.foundation.t.b.a.j(viewGroup.getContext()) / 2.142857f);
        if (((RecyclerView) viewGroup).getLayoutManager() instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, j2);
            layoutParams.setFullSpan(true);
            bannerView.setLayoutParams(layoutParams);
        } else {
            bannerView.setLayoutParams(new ViewGroup.LayoutParams(-1, j2));
        }
        FeedsBannerAdapter feedsBannerAdapter = new FeedsBannerAdapter(2.142857f);
        this.mAdapter = feedsBannerAdapter;
        feedsBannerAdapter.addAll((Collection) this.mData);
        bannerView.b(false);
        bannerView.setOnItemSelectedListener(this);
        bannerView.setOnItemClickListener(this);
        bannerView.setAutoScroll(true);
        bannerView.setAdapter(this.mAdapter);
        return new us.pinguo.widget.common.cell.recycler.c(bannerView);
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public DiffMode getDiffMode() {
        return DiffMode.UNIQUE;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        ViewGroup.LayoutParams layoutParams = cVar.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
        ((BannerView) cVar.getView(us.pinguo.ui.R.id.banner_view)).c();
        if (this.mAdapter == null) {
            this.mAdapter = new FeedsBannerAdapter(2.142857f);
        }
        if (this.mData == 0 || this.mAdapter.getCount() != 0 || ((List) this.mData).size() <= 0) {
            return;
        }
        this.mAdapter.addAll((Collection) this.mData);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AdvItem item = this.mAdapter.getItem(i2);
        if (item != null) {
            AppGoto.getInstance().d(item).b(adapterView.getContext());
            item.exePvTaskClick();
            us.pinguo.foundation.statistics.h.a.A0("challenge_task_list_page_top_banner", item.advId, "click");
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.mAdapter.getItem(i2);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        FeedsBannerAdapter feedsBannerAdapter;
        if (this.mViewHolder == 0 || (feedsBannerAdapter = this.mAdapter) == null) {
            return;
        }
        feedsBannerAdapter.clear();
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
        FeedsBannerAdapter feedsBannerAdapter;
        if (this.mViewHolder == 0 || (feedsBannerAdapter = this.mAdapter) == null) {
            return;
        }
        feedsBannerAdapter.addAll((Collection) this.mData);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(0, 0, 0, 0);
        return true;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void updateData(List<AdvItem> list) {
        FeedsBannerAdapter feedsBannerAdapter;
        super.updateData((FeedsBannerCell) list);
        if (System.currentTimeMillis() - mLastTime >= TIME_SPACE && "1c076547816bd43efd2931b1ed8e1fc1".equals(this.mAdvConfig)) {
            mLastTime = System.currentTimeMillis();
        }
        if (list == null || list.size() <= 0 || (feedsBannerAdapter = this.mAdapter) == null) {
            return;
        }
        feedsBannerAdapter.set(list);
    }
}

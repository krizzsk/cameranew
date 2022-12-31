package us.pinguo.inspire.module.discovery.cell;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.growingio.android.sdk.collection.GrowingIO;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import us.pinguo.foundation.statistics.FeedStat;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.cell.recycler.f;
import us.pinguo.inspire.model.InspireWork;
import us.pinguo.inspire.module.MissionDetail.TriangleView;
import us.pinguo.inspire.module.discovery.type.DiscoverySquareCellType;
import us.pinguo.inspire.module.feeds.model.FeedsList;
import us.pinguo.inspire.widget.like.LikeImageView;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.widet.PortraitImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryWaterFallWorkCell extends ADiscoveryWaterFallCell<InspireWork, c> {
    private static final int CELL_OFFSET;
    private static int HEIGHT_OF_OTHER_VIEW = 0;
    private static final int MAX_SHOW_RANKING = 100;
    private final int[] RES;
    private int mHeight;
    private boolean mShowRanking;
    public FeedStat mStat;
    private View.OnClickListener onClickListener;

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            HEIGHT_OF_OTHER_VIEW = us.pinguo.foundation.t.b.a.a(Inspire.a(), 32.0f);
        } else {
            HEIGHT_OF_OTHER_VIEW = us.pinguo.foundation.t.b.a.a(Inspire.a(), 38.0f);
        }
        CELL_OFFSET = us.pinguo.foundation.t.b.a.a(Inspire.a(), 8.0f);
    }

    public DiscoveryWaterFallWorkCell(InspireWork inspireWork) {
        super(inspireWork);
        this.RES = new int[]{R.drawable.muilt_photo2, R.drawable.muilt_photo3, R.drawable.muilt_photo4, R.drawable.muilt_photo5, R.drawable.muilt_photo6, R.drawable.muilt_photo7, R.drawable.muilt_photo8, R.drawable.muilt_photo9};
        this.onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryWaterFallWorkCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.a.C0(((InspireWork) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData).workId, "click");
                l.c("Community_Portal_Feed_Click", DiscoveryWaterFallWorkCell.this.mStat);
                if (((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData != null) {
                    FeedsList.setFeedsList(DiscoveryWaterFallWorkCell.this.mAdapter.getCells(), DiscoveryWaterFallWorkCell.this);
                    DiscoveryWaterFallWorkCell discoveryWaterFallWorkCell = DiscoveryWaterFallWorkCell.this;
                    FeedsList.enterDetailPage(view.getContext(), "", "", (InspireWork) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData, "from_discovery", discoveryWaterFallWorkCell.mAdapter, discoveryWaterFallWorkCell);
                }
            }
        };
    }

    private void checkShowRanking(c cVar) {
        int i2 = ((InspireWork) this.mData).ranking;
        View view = cVar.getView(R.id.discovery_ranking_layout);
        if (this.mShowRanking && i2 > 0 && i2 < 100) {
            view.setVisibility(0);
            TriangleView triangleView = (TriangleView) cVar.getView(R.id.discovery_ranking_tri);
            if (i2 == 1) {
                triangleView.setColor(-143062);
            } else if (i2 == 2) {
                triangleView.setColor(-5654598);
            } else if (i2 != 3) {
                triangleView.setColor(1275068416);
            } else {
                triangleView.setColor(-2117762);
            }
            triangleView.invalidate();
            ((TextView) cVar.getView(R.id.discovery_ranking_txt)).setText(String.valueOf(i2));
            return;
        }
        view.setVisibility(8);
    }

    @Override // us.pinguo.inspire.module.discovery.cell.IWaterFallCell
    public void addHeight(int i2) {
        this.mHeight = getImageViewHeight() + i2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.discovery_square_waterfall, viewGroup);
    }

    public int getImageViewHeight() {
        int i2 = (this.mScreenWidth - CELL_OFFSET) / 2;
        if (((InspireWork) this.mData).getHeight() == 0 || ((InspireWork) this.mData).getWidth() == 0) {
            return i2;
        }
        double height = (((InspireWork) this.mData).getHeight() * 1.0d) / ((InspireWork) this.mData).getWidth();
        if (height > 1.3333333333333333d) {
            height = 1.3333333333333333d;
        }
        if (height < 0.75d) {
            height = 0.75d;
        }
        return (int) (i2 * height);
    }

    @Override // us.pinguo.inspire.module.discovery.cell.IWaterFallCell
    public int getItemViewHeight() {
        return getImageViewHeight() + HEIGHT_OF_OTHER_VIEW;
    }

    @Override // us.pinguo.inspire.module.discovery.cell.IWaterFallCell
    public int getMinHeight() {
        return (((this.mScreenWidth - CELL_OFFSET) / 2) / 2) + HEIGHT_OF_OTHER_VIEW;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        int i2 = this.mHeight;
        if (i2 == 0) {
            i2 = getImageViewHeight();
        }
        return DiscoverySquareCellType.WATER_FALL_WORK.ordinal() + i2;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(c cVar) {
        View view;
        h.a.C0(((InspireWork) this.mData).workId, "show");
        GrowingIO.setViewContent(cVar.itemView, ((InspireWork) this.mData).workId);
        PhotoImageView photoImageView = (PhotoImageView) cVar.getView(R.id.iv_photo_waterfall_work_cell);
        PortraitImageView portraitImageView = (PortraitImageView) cVar.getView(R.id.piv_sender_waterfall_work_cell);
        portraitImageView.setUserType(0);
        portraitImageView.setMark(0);
        int i2 = (this.mScreenWidth - CELL_OFFSET) / 2;
        int i3 = this.mHeight;
        if (i3 == 0) {
            i3 = getImageViewHeight();
        }
        int i4 = i3;
        photoImageView.setSize(i2, i4);
        T t = this.mData;
        if (((InspireWork) t).workType == 2) {
            cVar.show(R.id.iv_work_type_waterfall_work_cell);
            T t2 = this.mData;
            if (((InspireWork) t2).width > 1 && ((InspireWork) t2).height > 1) {
                String workUrl = ((InspireWork) t2).getWorkUrl();
                T t3 = this.mData;
                photoImageView.setVideoImageUrl(workUrl, ((InspireWork) t3).width, ((InspireWork) t3).height, i2, i4);
            } else {
                ImageLoader.getInstance().i(PhotoImageView.addQiNiuSuffix(((InspireWork) t2).getWorkUrl(), 0, 0, true), photoImageView, new com.nostra13.universalimageloader.core.k.a() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryWaterFallWorkCell.1
                    @Override // com.nostra13.universalimageloader.core.k.a
                    public void onLoadingCancelled(String str, View view2) {
                    }

                    @Override // com.nostra13.universalimageloader.core.k.a
                    public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
                        if (view2 == null || bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
                            return;
                        }
                        if (((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData != null) {
                            ((InspireWork) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData).width = bitmap.getWidth();
                            ((InspireWork) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData).height = bitmap.getHeight();
                        }
                        view2.requestLayout();
                    }

                    @Override // com.nostra13.universalimageloader.core.k.a
                    public void onLoadingFailed(String str, View view2, FailReason failReason) {
                    }

                    @Override // com.nostra13.universalimageloader.core.k.a
                    public void onLoadingStarted(String str, View view2) {
                    }
                });
            }
            cVar.setImageResource(R.id.iv_work_type_waterfall_work_cell, R.drawable.waterfall_video);
        } else {
            f.c(cVar, R.id.iv_photo_waterfall_work_cell, ((InspireWork) t).getWorkUrl());
            int membersCount = ((InspireWork) this.mData).getMembersCount();
            if (membersCount <= 9 && membersCount >= 2) {
                cVar.show(R.id.iv_work_type_waterfall_work_cell);
                cVar.setImageResource(R.id.iv_work_type_waterfall_work_cell, this.RES[membersCount - 2]);
            } else {
                cVar.hide(R.id.iv_work_type_waterfall_work_cell);
            }
        }
        T t4 = this.mData;
        if (((InspireWork) t4).authorInfo != null) {
            if (!TextUtils.isEmpty(((InspireWork) t4).authorInfo.avatar)) {
                cVar.show(R.id.piv_sender_waterfall_work_cell);
                f.c(cVar, R.id.piv_sender_waterfall_work_cell, ((InspireWork) this.mData).authorInfo.avatar);
            } else {
                cVar.hide(R.id.piv_sender_waterfall_work_cell);
            }
            if (!TextUtils.isEmpty(((InspireWork) this.mData).authorInfo.nickname)) {
                cVar.show(R.id.tv_sender_name_waterfall_work_cell);
                cVar.setText(R.id.tv_sender_name_waterfall_work_cell, ((InspireWork) this.mData).authorInfo.nickname);
            } else {
                cVar.hide(R.id.tv_sender_name_waterfall_work_cell);
            }
            portraitImageView.setUserType(((InspireWork) this.mData).authorInfo.type);
            portraitImageView.setMark(((InspireWork) this.mData).authorInfo.mark);
            portraitImageView.setUserId(((InspireWork) this.mData).authorId);
        } else {
            if (!TextUtils.isEmpty(((InspireWork) t4).authorAvatar)) {
                cVar.show(R.id.piv_sender_waterfall_work_cell);
                f.c(cVar, R.id.piv_sender_waterfall_work_cell, ((InspireWork) this.mData).authorAvatar);
            } else {
                cVar.hide(R.id.piv_sender_waterfall_work_cell);
            }
            if (!TextUtils.isEmpty(((InspireWork) this.mData).authorName)) {
                cVar.show(R.id.tv_sender_name_waterfall_work_cell);
                cVar.setText(R.id.tv_sender_name_waterfall_work_cell, ((InspireWork) this.mData).authorName);
            } else {
                cVar.hide(R.id.tv_sender_name_waterfall_work_cell);
            }
            portraitImageView.setUserId(((InspireWork) this.mData).authorId);
            T t5 = this.mData;
            if (((InspireWork) t5).authorInfo != null) {
                portraitImageView.setUserType(((InspireWork) t5).authorInfo.type);
                portraitImageView.setMark(((InspireWork) this.mData).authorInfo.mark);
            }
        }
        if (cVar != null && (view = cVar.itemView) != null) {
            view.setOnClickListener(this.onClickListener);
        }
        LikeImageView likeImageView = (LikeImageView) cVar.getView(R.id.liv_water_fall_cell);
        T t6 = this.mData;
        likeImageView.k((us.pinguo.inspire.widget.like.a) t6, R.drawable.icon_square_unlike, R.drawable.icon_square_like, ((InspireWork) t6).workId, this, cVar.itemView, this.onClickListener, (ImageView) cVar.getView(R.id.iv_like_anim_waterfall_work_cell));
        checkShowRanking(this.mViewHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onHide() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.widget.common.cell.recycler.b
    public void onShow() {
        View view;
        FeedStat feedStat;
        VH vh = this.mViewHolder;
        if (vh == 0 || (view = vh.itemView) == null || view.getContext() == null || (feedStat = this.mStat) == null) {
            return;
        }
        l.c("Community_Portal_Feed_Show", feedStat);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void releaseResource() {
        super.releaseResource();
        VH vh = this.mViewHolder;
        if (vh != 0) {
            ((PhotoImageView) vh.getView(R.id.iv_photo_waterfall_work_cell)).setImageBitmap(null);
        }
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public void reloadResource() {
        VH vh = this.mViewHolder;
        if (vh != 0) {
            T t = this.mData;
            if (((InspireWork) t).workType == 2) {
                f.g(vh, R.id.iv_photo_waterfall_work_cell, ((InspireWork) t).getWorkUrl());
            } else {
                f.c(vh, R.id.iv_photo_waterfall_work_cell, ((InspireWork) t).getWorkUrl());
            }
        }
    }

    @Override // us.pinguo.inspire.module.discovery.cell.IWaterFallCell
    public void setHeight(int i2) {
        this.mHeight = i2 - HEIGHT_OF_OTHER_VIEW;
    }

    public void setShowRanking(boolean z) {
        this.mShowRanking = z;
    }

    public void setStat(FeedStat feedStat) {
        this.mStat = feedStat;
    }

    public DiscoveryWaterFallWorkCell(InspireWork inspireWork, boolean z) {
        super(inspireWork);
        this.RES = new int[]{R.drawable.muilt_photo2, R.drawable.muilt_photo3, R.drawable.muilt_photo4, R.drawable.muilt_photo5, R.drawable.muilt_photo6, R.drawable.muilt_photo7, R.drawable.muilt_photo8, R.drawable.muilt_photo9};
        this.onClickListener = new View.OnClickListener() { // from class: us.pinguo.inspire.module.discovery.cell.DiscoveryWaterFallWorkCell.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.a.C0(((InspireWork) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData).workId, "click");
                l.c("Community_Portal_Feed_Click", DiscoveryWaterFallWorkCell.this.mStat);
                if (((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData != null) {
                    FeedsList.setFeedsList(DiscoveryWaterFallWorkCell.this.mAdapter.getCells(), DiscoveryWaterFallWorkCell.this);
                    DiscoveryWaterFallWorkCell discoveryWaterFallWorkCell = DiscoveryWaterFallWorkCell.this;
                    FeedsList.enterDetailPage(view.getContext(), "", "", (InspireWork) ((us.pinguo.widget.common.cell.recycler.b) DiscoveryWaterFallWorkCell.this).mData, "from_discovery", discoveryWaterFallWorkCell.mAdapter, discoveryWaterFallWorkCell);
                }
            }
        };
    }
}

package us.pinguo.inspire.module.discovery.cell;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.discovery.entity.RecommendBanner;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.widget.common.cell.recycler.c;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class RecommendBannerCell extends us.pinguo.widget.common.cell.recycler.b<RecommendBanner, c> {
    private int mHeight;
    private int mWidth;

    public RecommendBannerCell(RecommendBanner recommendBanner) {
        super(recommendBanner);
        int j2 = us.pinguo.foundation.t.b.a.j(Inspire.a());
        this.mWidth = j2;
        this.mHeight = (int) (j2 * 0.64f);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public c createViewHolder(ViewGroup viewGroup) {
        return createHolderByLayout(R.layout.recommend_banner_cell, viewGroup);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 231;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(final c cVar) {
        PhotoImageView photoImageView = (PhotoImageView) cVar.getView(R.id.piv_cover_recommend_banner_cell);
        photoImageView.setSize(this.mWidth, this.mHeight);
        photoImageView.setSimpleImageLoadingListener(new com.nostra13.universalimageloader.core.k.c() { // from class: us.pinguo.inspire.module.discovery.cell.RecommendBannerCell.1
            @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                super.onLoadingComplete(str, view, bitmap);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.show(R.id.ll_cover_and_desc_recommend_banner_cell);
                }
            }

            @Override // com.nostra13.universalimageloader.core.k.c, com.nostra13.universalimageloader.core.k.a
            public void onLoadingStarted(String str, View view) {
                super.onLoadingStarted(str, view);
                cVar.hide(R.id.ll_cover_and_desc_recommend_banner_cell);
            }
        });
        photoImageView.setImageUri(((RecommendBanner) this.mData).cover, R.drawable.recommend_loading_icon);
        cVar.setText(R.id.tv_desc_nice_work_cell, ((RecommendBanner) this.mData).desc);
        cVar.setText(R.id.tv_detail_nice_work_cell, ((RecommendBanner) this.mData).detail);
    }
}

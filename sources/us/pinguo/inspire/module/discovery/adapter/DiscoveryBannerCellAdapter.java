package us.pinguo.inspire.module.discovery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.discovery.entity.dicovery.DiscoveryBannerItem;
import us.pinguo.inspire.widget.videocell.InspireVideoView;
import us.pinguo.inspire.widget.videocell.g.a;
import us.pinguo.ui.uilview.PhotoImageView;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class DiscoveryBannerCellAdapter extends a<DiscoveryBannerItem> {
    private static final int AUTO_SCROLL_SECONDS = 5;
    public static final int TYPE_PHOTO = 0;
    public static final int TYPE_VIDEO = 1;
    private int height;
    private int screenWidth;

    public DiscoveryBannerCellAdapter() {
        int j2 = us.pinguo.foundation.t.b.a.j(Inspire.a());
        this.screenWidth = j2;
        this.height = (int) (j2 * 0.73333335f);
    }

    private void fillPhotoView(View view, DiscoveryBannerItem discoveryBannerItem) {
        PhotoImageView photoImageView = (PhotoImageView) view.findViewById(R.id.piv_discovery_square_banner_cell);
        photoImageView.setSize(this.screenWidth, this.height);
        photoImageView.setImageUri(discoveryBannerItem.url);
    }

    private void fillVideoView(View view, DiscoveryBannerItem discoveryBannerItem) {
        a.C0413a c0413a = new a.C0413a(this);
        c0413a.b = discoveryBannerItem.height;
        c0413a.a = discoveryBannerItem.width;
        showPhoto((InspireVideoView) view.findViewById(R.id.ivv_discovery_square_banner_cell), c0413a, discoveryBannerItem.url);
    }

    @Override // us.pinguo.ui.widget.banner.b
    public int getAutoScrollTime(int i2) {
        return getItem(i2) != null ? 5000 : 0;
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
        return "video".equals(getItem(i2).media) ? 1 : 0;
    }

    @Override // us.pinguo.ui.widget.banner.b
    public int getRealCount() {
        return super.getCount();
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        DiscoveryBannerItem item = getItem(i2);
        int itemViewType = getItemViewType(i2);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discovery_square_banner_cell, (ViewGroup) null);
        }
        View view2 = (PhotoImageView) view.findViewById(R.id.piv_discovery_square_banner_cell);
        InspireVideoView inspireVideoView = (InspireVideoView) view.findViewById(R.id.ivv_discovery_square_banner_cell);
        if (itemViewType == 0) {
            view2.setVisibility(0);
            inspireVideoView.setVisibility(8);
            fillPhotoView(view2, item);
        } else if (1 == itemViewType) {
            view2.setVisibility(8);
            inspireVideoView.setVisibility(0);
            fillVideoView(inspireVideoView, item);
        }
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // us.pinguo.ui.widget.banner.a, android.widget.Adapter
    public DiscoveryBannerItem getItem(int i2) {
        if (getRealCount() != 0) {
            i2 %= getRealCount();
        }
        return (DiscoveryBannerItem) super.getItem(i2);
    }
}

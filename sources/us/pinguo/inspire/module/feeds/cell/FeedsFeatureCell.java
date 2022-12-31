package us.pinguo.inspire.module.feeds.cell;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import org.slf4j.Marker;
import us.pinguo.admobvista.StaticsAdv.InspireStaticeConfig;
import us.pinguo.advconfigdata.Statictis.AdvStaticsticManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.module.feeds.view.FeatureGridView;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class FeedsFeatureCell extends us.pinguo.widget.common.cell.recycler.b<List<AdvItem>, us.pinguo.widget.common.cell.recycler.c> implements FeatureGridView.OnItemClick, us.pinguo.user.recycler.a {
    public FeedsFeatureCell(List<AdvItem> list) {
        super(list);
    }

    private void setFeatures(us.pinguo.widget.common.cell.recycler.c cVar) {
        String str;
        T t = this.mData;
        if (t == 0) {
            return;
        }
        int size = ((List) t).size();
        FeatureGridView.Feature[] featureArr = new FeatureGridView.Feature[size];
        int i2 = 0;
        while (i2 < size) {
            String str2 = null;
            AdvItem advItem = i2 < ((List) this.mData).size() ? (AdvItem) ((List) this.mData).get(i2) : null;
            if (advItem != null) {
                if (!TextUtils.isEmpty(advItem.downloadedIconPath)) {
                    str2 = InspirePublishFragment.FILE_HEADER + advItem.downloadedIconPath;
                } else if (!TextUtils.isEmpty(advItem.iconUrl)) {
                    str2 = advItem.iconUrl;
                }
                str = advItem.content;
            } else {
                str = null;
            }
            if (!us.pinguo.librouter.c.d.b().getInterface().a().isInteractionAppWall(advItem) || us.pinguo.librouter.c.d.b().getInterface().a().isValidAppWall(advItem)) {
                featureArr[i2] = new FeatureGridView.Feature(str2, str, advItem.imgDefault);
                String str3 = advItem.advId + Marker.ANY_NON_NULL_MARKER + advItem.imageUrl;
                AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey(InspireStaticeConfig.HOME_FUNCTION__DISPLAY, str3);
                AdvStaticsticManager.GetInstance().GetStaticInterface().ReportU(InspireStaticeConfig.HOME_FUNCTION__DISPLAY, str3);
                if (us.pinguo.librouter.c.d.b().getInterface().a().isInteractionAppWall(advItem)) {
                    AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey(InspireStaticeConfig.HOME_FUNCTION_APPWALL_DISPLAY, str3);
                    AdvStaticsticManager.GetInstance().GetStaticInterface().ReportU(InspireStaticeConfig.HOME_FUNCTION_APPWALL_DISPLAY, str3);
                }
            }
            i2++;
        }
        FeatureGridView featureGridView = (FeatureGridView) cVar.getView(R.id.feeds_feature_grid);
        featureGridView.setFeatures(featureArr);
        featureGridView.setOnItemClick(this);
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public us.pinguo.widget.common.cell.recycler.c createViewHolder(ViewGroup viewGroup) {
        return new us.pinguo.widget.common.cell.recycler.c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.feeds_features_layout, viewGroup, false));
    }

    @Override // us.pinguo.user.recycler.a
    public boolean drawDecoration(Rect rect, Canvas canvas, View view, RecyclerView recyclerView, RecyclerView.State state) {
        return false;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    public int getType() {
        return 1;
    }

    @Override // us.pinguo.widget.common.cell.recycler.b
    protected void onBindViewHolder(us.pinguo.widget.common.cell.recycler.c cVar) {
        setFeatures(cVar);
    }

    @Override // us.pinguo.inspire.module.feeds.view.FeatureGridView.OnItemClick
    public void onItemClick(View view, int i2) {
        T t = this.mData;
        if (t == 0) {
            return;
        }
        AdvItem advItem = i2 < ((List) t).size() ? (AdvItem) ((List) this.mData).get(i2) : null;
        if (advItem != null) {
            AppGoto.getInstance().d(advItem).b(view.getContext());
            String str = advItem.advId + Marker.ANY_NON_NULL_MARKER + advItem.imageUrl;
            AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey(InspireStaticeConfig.HOME_FUNCTION__CLICK, str);
            AdvStaticsticManager.GetInstance().GetStaticInterface().ReportU(InspireStaticeConfig.HOME_FUNCTION__CLICK, str);
            if (us.pinguo.librouter.c.d.b().getInterface().a().isInteractionAppWall(advItem)) {
                AdvStaticsticManager.GetInstance().GetStaticInterface().ReportBDNoKey(InspireStaticeConfig.HOME_FUNCTION_APPWALL_CLICK, str);
                AdvStaticsticManager.GetInstance().GetStaticInterface().ReportU(InspireStaticeConfig.HOME_FUNCTION_APPWALL_CLICK, str);
            }
            if ("app://camera360/cameraopen?cameraId=c205e3582b514d6fb5c21a953e1e901e".equals(advItem.interactionUri)) {
                l.onEvent(view.getContext(), "pc_feed_feature_camera_click");
            } else if ("app://camera360/cameraopen?cameraId=bc833a31761642e78dc09c16e4366dd8".equals(advItem.interactionUri)) {
                l.onEvent(view.getContext(), "pc_feed_feature_selfie_click");
            } else if ("app://camera360/photo".equals(advItem.interactionUri)) {
                l.onEvent(view.getContext(), "pc_feed_feature_gallery_click");
            }
        }
    }

    @Override // us.pinguo.user.recycler.a
    public boolean setDecorationRect(us.pinguo.widget.common.cell.recycler.b bVar, us.pinguo.widget.common.cell.recycler.b bVar2, Rect rect, Rect rect2) {
        rect.set(0, 0, 0, rect2.bottom);
        return true;
    }
}

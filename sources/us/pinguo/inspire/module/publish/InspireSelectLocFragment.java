package us.pinguo.inspire.module.publish;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.common.network.BaseResponse;
import us.pinguo.inspire.base.easyload.EasySpListFragment;
import us.pinguo.inspire.module.message.category.cell.SelectLocCell;
import us.pinguo.inspire.module.publish.cell.SelectNoLocCell;
import us.pinguo.inspire.module.publish.vo.LocationInfo;
import us.pinguo.inspire.module.publish.vo.SelectLocResp;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InspireSelectLocFragment extends EasySpListFragment<SelectLocResp> {
    private LocationInfo mLocationInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> appendCells(SelectLocResp selectLocResp) {
        return null;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected HashMap<String, String> getParam() {
        HashMap<String, String> hashMap = new HashMap<>();
        LocationInfo locationInfo = this.mLocationInfo;
        if (locationInfo != null) {
            hashMap.put(BigAlbumStore.PhotoColumns.LATITUDE, locationInfo.lat);
            hashMap.put(BigAlbumStore.PhotoColumns.LONGITUDE, this.mLocationInfo.lon);
        }
        return hashMap;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected Type getType() {
        return new com.google.gson.t.a<BaseResponse<SelectLocResp>>() { // from class: us.pinguo.inspire.module.publish.InspireSelectLocFragment.1
        }.getType();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected String getUrl() {
        return "/task/getGeo/poi";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public void initConfig() {
        super.initConfig();
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    protected void initTitle() {
        setTitle(R.string.title_select_loc);
    }

    @Override // us.pinguo.inspire.base.easyload.EasySpListFragment
    public boolean isLoadMoreEnable(SelectLocResp selectLocResp) {
        return false;
    }

    @Override // us.pinguo.inspire.base.easyload.EasyListFragment, us.pinguo.inspire.base.BaseAbsListFragment, us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mLocationInfo = (LocationInfo) getSafeArguments().getParcelable("extra_location_info");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.inspire.base.easyload.EasyListFragment
    public List<us.pinguo.widget.common.cell.recycler.b> createCells(SelectLocResp selectLocResp) {
        ArrayList arrayList = new ArrayList();
        if (this.mLocationInfo != null) {
            LocationInfo locationInfo = new LocationInfo();
            LocationInfo locationInfo2 = this.mLocationInfo;
            locationInfo.lat = locationInfo2.lat;
            locationInfo.lon = locationInfo2.lon;
            locationInfo.placeId = locationInfo2.placeId;
            Context b = us.pinguo.foundation.e.b();
            int i2 = us.pinguo.user.R.string.hide_location;
            locationInfo.poi = b.getString(i2);
            SelectNoLocCell selectNoLocCell = new SelectNoLocCell(locationInfo);
            arrayList.add(selectNoLocCell);
            if (!TextUtils.isEmpty(this.mLocationInfo.poi) && !us.pinguo.foundation.e.b().getString(i2).equals(this.mLocationInfo.poi)) {
                SelectLocCell selectLocCell = new SelectLocCell(this.mLocationInfo);
                selectLocCell.setSelected(true);
                arrayList.add(selectLocCell);
            } else {
                selectNoLocCell.setSelected(true);
            }
        }
        if (selectLocResp != null && !us.pinguo.foundation.utils.k.a(selectLocResp.list)) {
            for (LocationInfo locationInfo3 : selectLocResp.list) {
                LocationInfo locationInfo4 = this.mLocationInfo;
                if (locationInfo4 == null || TextUtils.isEmpty(locationInfo4.poi) || !this.mLocationInfo.poi.equals(locationInfo3.poi)) {
                    arrayList.add(new SelectLocCell(locationInfo3));
                }
            }
        }
        return arrayList;
    }
}

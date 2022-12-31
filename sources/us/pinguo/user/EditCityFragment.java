package us.pinguo.user;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.inspire.module.profile.entry.BaseGeoEntry;
import us.pinguo.inspire.module.profile.entry.GeoCity;
import us.pinguo.inspire.module.profile.entry.GeoProvince;
import us.pinguo.user.a1.h;
/* loaded from: classes6.dex */
public class EditCityFragment extends EditAreaFragment implements h.b {
    private String n;
    private GeoProvince o;
    private String p;

    @Override // us.pinguo.user.a1.h.b
    public <T extends BaseGeoEntry> void M(T t) {
        GeoCity geoCity = (GeoCity) t;
        String str = this.p;
        String str2 = this.n;
        GeoProvince geoProvince = this.o;
        us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.b(EditCountryFragment.m0(str, str2, geoProvince.name, geoProvince.code, geoCity.name, geoCity.code)));
        FragmentActivity activity = getActivity();
        getActivity();
        activity.setResult(-1);
        getActivity().finish();
    }

    @Override // us.pinguo.user.EditAreaFragment
    protected String f0() {
        return getActivity().getString(R.string.edit_area);
    }

    public List<us.pinguo.widget.common.cell.recycler.b> g0(List<GeoCity> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            us.pinguo.user.a1.e eVar = new us.pinguo.user.a1.e(list.get(i2));
            eVar.e(this);
            arrayList.add(eVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.EditAreaFragment, us.pinguo.user.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        List<us.pinguo.widget.common.cell.recycler.b> g0 = g0(this.o.city);
        if (g0 != null) {
            this.f12338d.addAll(g0);
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.n = getArguments().getString("KEY_COUNTRY");
        this.o = (GeoProvince) getArguments().getParcelable("KEY_PROVINCE");
        this.p = getArguments().getString("KEY_COUNTRY_NAME");
    }
}

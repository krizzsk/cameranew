package us.pinguo.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.inspire.module.profile.entry.BaseGeoEntry;
import us.pinguo.inspire.module.profile.entry.GeoCity;
import us.pinguo.inspire.module.profile.entry.GeoCountry;
import us.pinguo.inspire.module.profile.entry.GeoProvince;
import us.pinguo.user.a1.h;
/* loaded from: classes6.dex */
public class EditProvinceFragment extends EditAreaFragment implements h.b {
    private String n;
    private GeoCountry o;
    private List<GeoProvince> p = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements us.pinguo.foundation.proxy.c {
        final /* synthetic */ Activity a;

        a(Activity activity) {
            this.a = activity;
        }

        @Override // us.pinguo.foundation.proxy.c
        public void onActivityResult(int i2, Intent intent) {
            Activity activity = this.a;
            if (i2 == -1) {
                activity.setResult(-1);
                this.a.finish();
            }
        }
    }

    public static void h0(Activity activity, GeoProvince geoProvince, String str, String str2) {
        Intent intent = new Intent(activity, InspireContentActivity.class);
        intent.putExtra(InspireContentActivity.FRAGMENT_NAME, EditCityFragment.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_PROVINCE", geoProvince);
        bundle.putString("KEY_COUNTRY", str2);
        bundle.putString("KEY_COUNTRY_NAME", str);
        intent.putExtras(bundle);
        ((InspireRedirectActivity) activity).startActivityForResult(intent, new a(activity));
    }

    private boolean i0(GeoProvince geoProvince) {
        if (geoProvince != null && geoProvince.city.size() <= 1) {
            GeoCity geoCity = geoProvince.city.get(0);
            return "0".equals(geoCity.code) && "".equals(geoCity.name);
        }
        return false;
    }

    @Override // us.pinguo.user.a1.h.b
    public <T extends BaseGeoEntry> void M(T t) {
        GeoProvince geoProvince = (GeoProvince) t;
        if (i0(geoProvince)) {
            us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.b(EditCountryFragment.m0(this.o.name, this.n, geoProvince.name, geoProvince.code, "", "0")));
            FragmentActivity activity = getActivity();
            getActivity();
            activity.setResult(-1);
            getActivity().finish();
            return;
        }
        h0(getActivity(), geoProvince, this.o.name, this.n);
    }

    @Override // us.pinguo.user.EditAreaFragment
    protected String f0() {
        return getActivity().getString(R.string.edit_area);
    }

    public List<us.pinguo.widget.common.cell.recycler.b> g0(List<GeoProvince> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            us.pinguo.user.a1.i iVar = new us.pinguo.user.a1.i(list.get(i2));
            iVar.e(this);
            arrayList.add(iVar);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.EditAreaFragment, us.pinguo.user.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        List<us.pinguo.widget.common.cell.recycler.b> g0 = g0(this.p);
        if (g0 != null) {
            this.f12338d.addAll(g0);
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.n = getArguments().getString("KEY_COUNTRY");
        GeoCountry geoCountry = (GeoCountry) getArguments().getParcelable("KEY_PROVINCE_LIST");
        this.o = geoCountry;
        this.p.addAll(geoCountry.province);
    }
}

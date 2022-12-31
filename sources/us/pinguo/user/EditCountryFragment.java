package us.pinguo.user;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.matrix.report.Issue;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action1;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.dialog.SinglePermissionDialog;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.model.InspireGeo;
import us.pinguo.inspire.module.profile.GeoCode;
import us.pinguo.inspire.module.profile.GeoManager;
import us.pinguo.inspire.module.profile.GeoResp;
import us.pinguo.inspire.module.profile.UserInfoLoader;
import us.pinguo.inspire.module.profile.entry.BaseGeoEntry;
import us.pinguo.inspire.module.profile.entry.GeoCity;
import us.pinguo.inspire.module.profile.entry.GeoCountry;
import us.pinguo.inspire.module.profile.entry.GeoProvince;
import us.pinguo.inspire.module.profile.entry.LocationGroup;
import us.pinguo.permissionlib.PermissionManager;
import us.pinguo.user.EditCountryFragment;
import us.pinguo.user.a1.g;
import us.pinguo.user.a1.h;
/* loaded from: classes6.dex */
public class EditCountryFragment extends EditAreaFragment implements h.b {
    private PermissionManager n;
    private AlertDialog o = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements us.pinguo.foundation.dialog.c {
        final /* synthetic */ String[] a;

        a(String[] strArr) {
            this.a = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(String[] strArr, String[] strArr2) {
            if (strArr.length > 0) {
                EditCountryFragment.this.k0();
                us.pinguo.foundation.statistics.h.b.e0("yes");
                return;
            }
            us.pinguo.foundation.statistics.h.b.e0("no");
        }

        @Override // us.pinguo.foundation.dialog.c
        public void a() {
            us.pinguo.foundation.statistics.h.b.e0("no");
        }

        @Override // us.pinguo.foundation.dialog.c
        public void b() {
            EditCountryFragment.this.n.u(new us.pinguo.permissionlib.c.a() { // from class: us.pinguo.user.k
                @Override // us.pinguo.permissionlib.c.a
                public final void a(String[] strArr, String[] strArr2) {
                    EditCountryFragment.a.this.d(strArr, strArr2);
                }
            }, this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements GeoManager.GeoResultListener {
        b() {
        }

        @Override // us.pinguo.inspire.module.profile.GeoManager.GeoResultListener
        public void onError(Throwable th) {
            EditCountryFragment.this.B0();
        }

        @Override // us.pinguo.inspire.module.profile.GeoManager.GeoResultListener
        public void onResult(GeoResp geoResp) {
            List cells = EditCountryFragment.this.f12338d.getCells();
            if (cells.size() > 0) {
                us.pinguo.widget.common.cell.recycler.b bVar = (us.pinguo.widget.common.cell.recycler.b) cells.get(0);
                if (bVar instanceof us.pinguo.user.a1.g) {
                    bVar.updateData(geoResp);
                    return;
                }
                EditCountryFragment.this.f12338d.add(0, new us.pinguo.user.a1.g(geoResp));
            }
        }
    }

    private void A0(boolean z) {
        AlertDialog alertDialog = this.o;
        if (alertDialog == null || !alertDialog.isShowing()) {
            us.pinguo.foundation.statistics.h.b.T();
            this.n.w("android.permission.ACCESS_FINE_LOCATION");
            final String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
            us.pinguo.user.util.n.i();
            if (this.n.o("android.permission.ACCESS_FINE_LOCATION")) {
                if (z) {
                    this.o = us.pinguo.permissionlib.a.a.c(us.pinguo.inspire.util.u.b(this.n), getContext(), new DialogInterface.OnClickListener() { // from class: us.pinguo.user.q
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            EditCountryFragment.this.x0(strArr, dialogInterface, i2);
                        }
                    });
                    return;
                }
                return;
            }
            SinglePermissionDialog singlePermissionDialog = new SinglePermissionDialog();
            singlePermissionDialog.e0(new a(strArr));
            FragmentManager childFragmentManager = getChildFragmentManager();
            singlePermissionDialog.show(childFragmentManager, Issue.ISSUE_REPORT_TAG);
            VdsAgent.showDialogFragment(singlePermissionDialog, childFragmentManager, Issue.ISSUE_REPORT_TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        List cells = this.f12338d.getCells();
        if (cells.size() > 0) {
            us.pinguo.widget.common.cell.recycler.b bVar = (us.pinguo.widget.common.cell.recycler.b) cells.get(0);
            if (bVar instanceof us.pinguo.user.a1.g) {
                ((us.pinguo.user.a1.g) bVar).f();
                return;
            }
            us.pinguo.user.a1.g gVar = new us.pinguo.user.a1.g(null);
            gVar.f();
            this.f12338d.add(0, gVar);
        }
    }

    private boolean j0(boolean z) {
        int checkSelfPermission = ContextCompat.checkSelfPermission(ActivityRecorder.getInstance().d(), "android.permission.ACCESS_FINE_LOCATION");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(us.pinguo.foundation.e.b(), "android.permission.ACCESS_COARSE_LOCATION");
        if (checkSelfPermission == 0 || checkSelfPermission2 == 0) {
            return true;
        }
        A0(z);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        us.pinguo.librouter.b.b.b().getInterface().d(true);
        GeoManager.getCurrentGeo(new b());
    }

    public static GeoResp m0(String str, String str2, String str3, String str4, String str5, String str6) {
        GeoResp geoResp = new GeoResp();
        GeoCode geoCode = new GeoCode();
        geoCode.country = str2;
        geoCode.province = str4;
        geoCode.city = str6;
        geoResp.codes = geoCode;
        InspireGeo inspireGeo = new InspireGeo();
        inspireGeo.country = str;
        inspireGeo.city = str5;
        inspireGeo.province = str3;
        geoResp.info = inspireGeo;
        return geoResp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void q0() {
        if (j0(true)) {
            k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public /* synthetic */ void s0(List list) {
        List<us.pinguo.widget.common.cell.recycler.b> cells = getCells(list);
        if (cells != null) {
            this.f12338d.addAll(cells);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void t0(Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(String[] strArr, String[] strArr2) {
        if (strArr.length > 0) {
            k0();
            us.pinguo.foundation.statistics.h.b.e0("yes");
            return;
        }
        us.pinguo.foundation.statistics.h.b.e0("no");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(String[] strArr, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            this.n.u(new us.pinguo.permissionlib.c.a() { // from class: us.pinguo.user.l
                @Override // us.pinguo.permissionlib.c.a
                public final void a(String[] strArr2, String[] strArr3) {
                    EditCountryFragment.this.v0(strArr2, strArr3);
                }
            }, strArr);
        } else {
            us.pinguo.foundation.statistics.h.b.e0("no");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void z0(int i2, Intent intent) {
        if (i2 == -1) {
            getActivity().finish();
        }
    }

    @Override // us.pinguo.user.a1.h.b
    public <T extends BaseGeoEntry> void M(T t) {
        GeoCountry geoCountry = (GeoCountry) t;
        if (o0(geoCountry)) {
            Intent intent = new Intent(getActivity(), InspireContentActivity.class);
            intent.putExtra(InspireContentActivity.FRAGMENT_NAME, EditProvinceFragment.class.getName());
            Bundle bundle = new Bundle();
            bundle.putString("KEY_COUNTRY", geoCountry.code);
            bundle.putParcelable("KEY_PROVINCE_LIST", geoCountry);
            intent.putExtras(bundle);
            ((InspireRedirectActivity) getActivity()).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.user.o
                @Override // us.pinguo.foundation.proxy.c
                public final void onActivityResult(int i2, Intent intent2) {
                    EditCountryFragment.this.z0(i2, intent2);
                }
            });
        } else if (n0(geoCountry)) {
            EditProvinceFragment.h0(getActivity(), geoCountry.province.get(0), geoCountry.name, geoCountry.code);
        } else {
            us.pinguo.foundation.r.d.a().b(new us.pinguo.user.event.b(m0(geoCountry.name, geoCountry.code, "", "0", "", "0")));
            getActivity().finish();
        }
    }

    @Override // us.pinguo.user.EditAreaFragment
    protected String f0() {
        return getActivity().getString(R.string.edit_location);
    }

    public List<us.pinguo.widget.common.cell.recycler.b> getCells(List<LocationGroup> list) {
        ArrayList arrayList = new ArrayList();
        us.pinguo.user.a1.g gVar = new us.pinguo.user.a1.g(null);
        gVar.e(new g.b() { // from class: us.pinguo.user.n
            @Override // us.pinguo.user.a1.g.b
            public final void a() {
                EditCountryFragment.this.q0();
            }
        });
        arrayList.add(gVar);
        for (int i2 = 0; i2 < list.size(); i2++) {
            LocationGroup locationGroup = list.get(i2);
            List<GeoCountry> list2 = locationGroup.country;
            if (list != null) {
                arrayList.add(new us.pinguo.user.a1.f(locationGroup.group));
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    us.pinguo.user.a1.h hVar = new us.pinguo.user.a1.h(list2.get(i3));
                    hVar.e(this);
                    arrayList.add(hVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.user.EditAreaFragment, us.pinguo.user.BaseAbsListFragment
    public void initRecycleView(RecyclerView recyclerView, us.pinguo.widget.common.cell.recycler.a aVar) {
        super.initRecycleView(recyclerView, aVar);
        l0();
        if (j0(false)) {
            k0();
        }
    }

    public void l0() {
        addSubscription(new UserInfoLoader().getCountryListInfo(getContext()).subscribe(new Action1() { // from class: us.pinguo.user.p
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                EditCountryFragment.this.s0((List) obj);
            }
        }, m.a));
    }

    public boolean n0(GeoCountry geoCountry) {
        GeoProvince geoProvince;
        List<GeoCity> list;
        if (geoCountry == null) {
            return false;
        }
        return (geoCountry.province.size() == 1 && (geoProvince = geoCountry.province.get(0)) != null && (list = geoProvince.city) != null && list.size() == 1 && geoProvince.city.get(0).code.equals("0")) ? false : true;
    }

    public boolean o0(GeoCountry geoCountry) {
        List<GeoProvince> list;
        if (geoCountry == null || (list = geoCountry.province) == null || list.size() == 0) {
            return false;
        }
        return (geoCountry.province.size() == 1 && geoCountry.province.get(0).code.equals("0")) ? false : true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 6816) {
            this.n.r(i2, i3, intent);
            return;
        }
        getActivity();
        if (i3 == -1) {
            getActivity().finish();
        }
    }

    @Override // us.pinguo.user.BaseAbsListFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.n = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PermissionManager permissionManager = this.n;
        if (permissionManager != null) {
            permissionManager.d();
            this.n = null;
        }
    }

    @Override // us.pinguo.user.BaseAbsListFragment, us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        GeoManager.unsubscription();
        AlertDialog alertDialog = this.o;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.o = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.n.s(i2, strArr, iArr);
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.n.v();
    }
}

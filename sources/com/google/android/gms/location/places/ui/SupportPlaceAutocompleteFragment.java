package com.google.android.gms.location.places.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.R;
import com.google.android.gms.location.places.ui.a;
import com.google.android.gms.maps.model.LatLngBounds;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
@Instrumented
@Deprecated
/* loaded from: classes2.dex */
public class SupportPlaceAutocompleteFragment extends Fragment {
    private View a;
    private View b;
    private EditText c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3716d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f3717e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private AutocompleteFilter f3718f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private c f3719g;

    private final void d0() {
        boolean z = !this.c.getText().toString().isEmpty();
        View view = this.b;
        int i2 = z ? 0 : 8;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        int connectionStatusCode;
        try {
            a.C0165a c0165a = new a.C0165a(2);
            c0165a.b(this.f3717e);
            c0165a.c(this.f3718f);
            c0165a.e(this.c.getText().toString());
            c0165a.d(1);
            Intent a = c0165a.a(getActivity());
            this.f3716d = true;
            startActivityForResult(a, 30421);
            connectionStatusCode = -1;
        } catch (GooglePlayServicesNotAvailableException e2) {
            connectionStatusCode = e2.errorCode;
            Log.e("Places", "Could not open autocomplete activity", e2);
        } catch (GooglePlayServicesRepairableException e3) {
            connectionStatusCode = e3.getConnectionStatusCode();
            Log.e("Places", "Could not open autocomplete activity", e3);
        }
        if (connectionStatusCode != -1) {
            GoogleApiAvailability.getInstance().m(getActivity(), connectionStatusCode, 30422);
        }
    }

    public void a0(CharSequence charSequence) {
        this.c.setText(charSequence);
        d0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f3716d = false;
        if (i2 == 30421) {
            if (i3 == -1) {
                com.google.android.gms.location.places.a a = a.a(getActivity(), intent);
                c cVar = this.f3719g;
                if (cVar != null) {
                    cVar.a(a);
                }
                a0(a.getName().toString());
            } else if (i3 == 2) {
                Status b = a.b(getActivity(), intent);
                c cVar2 = this.f3719g;
                if (cVar2 != null) {
                    cVar2.b(b);
                }
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.a = inflate.findViewById(R.id.place_autocomplete_search_button);
        this.b = inflate.findViewById(R.id.place_autocomplete_clear_button);
        this.c = (EditText) inflate.findViewById(R.id.place_autocomplete_search_input);
        i iVar = new i(this);
        this.a.setOnClickListener(iVar);
        this.c.setOnClickListener(iVar);
        this.b.setOnClickListener(new h(this));
        d0();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.a = null;
        this.b = null;
        this.c = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VdsAgent.onFragmentPause(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VdsAgent.onFragmentResume(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

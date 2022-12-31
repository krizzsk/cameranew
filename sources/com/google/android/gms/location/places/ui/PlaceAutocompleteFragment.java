package com.google.android.gms.location.places.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
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
@TargetApi(12)
@Deprecated
/* loaded from: classes2.dex */
public class PlaceAutocompleteFragment extends Fragment {
    private View a;
    private View b;
    private EditText c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3712d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f3713e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private AutocompleteFilter f3714f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private c f3715g;

    private final void d() {
        boolean z = !this.c.getText().toString().isEmpty();
        View view = this.b;
        int i2 = z ? 0 : 8;
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        int connectionStatusCode;
        try {
            a.C0165a c0165a = new a.C0165a(2);
            c0165a.b(this.f3713e);
            c0165a.c(this.f3714f);
            c0165a.e(this.c.getText().toString());
            c0165a.d(1);
            Intent a = c0165a.a(getActivity());
            this.f3712d = true;
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

    public void a(CharSequence charSequence) {
        this.c.setText(charSequence);
        d();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.f3712d = false;
        if (i2 == 30421) {
            if (i3 == -1) {
                com.google.android.gms.location.places.a a = a.a(getActivity(), intent);
                c cVar = this.f3715g;
                if (cVar != null) {
                    cVar.a(a);
                }
                a(a.getName().toString());
            } else if (i3 == 2) {
                Status b = a.b(getActivity(), intent);
                c cVar2 = this.f3715g;
                if (cVar2 != null) {
                    cVar2.b(b);
                }
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.a = inflate.findViewById(R.id.place_autocomplete_search_button);
        this.b = inflate.findViewById(R.id.place_autocomplete_clear_button);
        this.c = (EditText) inflate.findViewById(R.id.place_autocomplete_search_input);
        g gVar = new g(this);
        this.a.setOnClickListener(gVar);
        this.c.setOnClickListener(gVar);
        this.b.setOnClickListener(new f(this));
        d();
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.a = null;
        this.b = null;
        this.c = null;
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        VdsAgent.onFragmentHiddenChanged(this, z);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        VdsAgent.onFragmentPause(this);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        VdsAgent.onFragmentResume(this);
    }

    @Override // android.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        VdsAgent.setFragmentUserVisibleHint(this, z);
    }
}

package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.maps.g.g;
import com.google.android.gms.maps.g.r;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class StreetViewPanoramaView extends FrameLayout {

    /* loaded from: classes2.dex */
    static class a implements com.google.android.gms.dynamic.c {
        private final ViewGroup a;
        private final g b;
        private View c;

        public a(ViewGroup viewGroup, g gVar) {
            q.j(gVar);
            this.b = gVar;
            q.j(viewGroup);
            this.a = viewGroup;
        }

        public final void a(e eVar) {
            try {
                this.b.g(new m(this, eVar));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void d() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.c
        public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.c
        public final View f(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                com.google.android.gms.maps.g.q.b(bundle, bundle2);
                this.b.onCreate(bundle2);
                com.google.android.gms.maps.g.q.b(bundle2, bundle);
                this.c = (View) com.google.android.gms.dynamic.d.y0(this.b.getView());
                this.a.removeAllViews();
                this.a.addView(this.c);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onDestroy() {
            try {
                this.b.onDestroy();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onLowMemory() {
            try {
                this.b.onLowMemory();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onPause() {
            try {
                this.b.onPause();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onResume() {
            try {
                this.b.onResume();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                com.google.android.gms.maps.g.q.b(bundle, bundle2);
                this.b.onSaveInstanceState(bundle2);
                com.google.android.gms.maps.g.q.b(bundle2, bundle);
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onStart() {
            try {
                this.b.onStart();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void onStop() {
            try {
                this.b.onStop();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    static class b extends com.google.android.gms.dynamic.a<a> {

        /* renamed from: e  reason: collision with root package name */
        private final ViewGroup f3733e;

        /* renamed from: f  reason: collision with root package name */
        private final Context f3734f;

        /* renamed from: g  reason: collision with root package name */
        private com.google.android.gms.dynamic.e<a> f3735g;

        /* renamed from: h  reason: collision with root package name */
        private final StreetViewPanoramaOptions f3736h;

        /* renamed from: i  reason: collision with root package name */
        private final List<e> f3737i = new ArrayList();

        b(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.f3733e = viewGroup;
            this.f3734f = context;
            this.f3736h = streetViewPanoramaOptions;
        }

        @Override // com.google.android.gms.dynamic.a
        protected final void a(com.google.android.gms.dynamic.e<a> eVar) {
            this.f3735g = eVar;
            if (eVar == null || b() != null) {
                return;
            }
            try {
                c.a(this.f3734f);
                this.f3735g.a(new a(this.f3733e, r.a(this.f3734f).g0(com.google.android.gms.dynamic.d.z0(this.f3734f), this.f3736h)));
                for (e eVar2 : this.f3737i) {
                    b().a(eVar2);
                }
                this.f3737i.clear();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        new b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new b(this, context, null);
    }
}

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
import com.google.android.gms.maps.g.r;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MapView extends FrameLayout {

    /* loaded from: classes2.dex */
    static class a implements com.google.android.gms.dynamic.c {
        private final ViewGroup a;
        private final com.google.android.gms.maps.g.d b;
        private View c;

        public a(ViewGroup viewGroup, com.google.android.gms.maps.g.d dVar) {
            q.j(dVar);
            this.b = dVar;
            q.j(viewGroup);
            this.a = viewGroup;
        }

        public final void a(d dVar) {
            try {
                this.b.f(new j(this, dVar));
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        @Override // com.google.android.gms.dynamic.c
        public final void d() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.c
        public final void e(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        @Override // com.google.android.gms.dynamic.c
        public final View f(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
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
        private final ViewGroup f3724e;

        /* renamed from: f  reason: collision with root package name */
        private final Context f3725f;

        /* renamed from: g  reason: collision with root package name */
        private com.google.android.gms.dynamic.e<a> f3726g;

        /* renamed from: h  reason: collision with root package name */
        private final GoogleMapOptions f3727h;

        /* renamed from: i  reason: collision with root package name */
        private final List<d> f3728i = new ArrayList();

        b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.f3724e = viewGroup;
            this.f3725f = context;
            this.f3727h = googleMapOptions;
        }

        @Override // com.google.android.gms.dynamic.a
        protected final void a(com.google.android.gms.dynamic.e<a> eVar) {
            this.f3726g = eVar;
            if (eVar == null || b() != null) {
                return;
            }
            try {
                c.a(this.f3725f);
                com.google.android.gms.maps.g.d O = r.a(this.f3725f).O(com.google.android.gms.dynamic.d.z0(this.f3725f), this.f3727h);
                if (O == null) {
                    return;
                }
                this.f3726g.a(new a(this.f3724e, O));
                for (d dVar : this.f3728i) {
                    b().a(dVar);
                }
                this.f3728i.clear();
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            } catch (GooglePlayServicesNotAvailableException unused) {
            }
        }
    }

    public MapView(Context context) {
        super(context);
        new b(this, context, null);
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new b(this, context, GoogleMapOptions.n(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new b(this, context, GoogleMapOptions.n(context, attributeSet));
        setClickable(true);
    }
}

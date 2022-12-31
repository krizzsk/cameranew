package us.pinguo.inspire;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;
import us.pinguo.foundation.base.InspireBaseActivity;
import us.pinguo.inspire.CountryZoneMoreActivity;
import us.pinguo.inspire.profile.CountryZone;
import us.pinguo.inspire.widget.quicksidebar.QuickSideBarTipsView;
import us.pinguo.inspire.widget.quicksidebar.QuickSideBarView;
import us.pinguo.user.ui.view.CompatibleToolbar;
/* loaded from: classes4.dex */
public class CountryZoneMoreActivity extends InspireBaseActivity implements us.pinguo.inspire.widget.quicksidebar.a.a {

    /* renamed from: j  reason: collision with root package name */
    private static String f11195j = "CountryZoneMoreActivity_ZONE_NAME_KEY";

    /* renamed from: k  reason: collision with root package name */
    private static String f11196k = "CountryZoneMoreActivity_ZONE_CC_KEY";
    private ArrayList<CountryZone> a;
    private RecyclerView b;
    private QuickSideBarTipsView c;

    /* renamed from: d  reason: collision with root package name */
    private QuickSideBarView f11197d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Integer> f11198e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    ArrayList<String> f11199f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    List<CountryZone.ListBean> f11200g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private TextView f11201h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f11202i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends us.pinguo.inspire.x.a<RecyclerView.ViewHolder> implements com.timehop.stickyheadersrecyclerview.b<RecyclerView.ViewHolder> {

        /* loaded from: classes4.dex */
        class a extends RecyclerView.ViewHolder {
            private TextView a;

            public a(b bVar, View view) {
                super(view);
                this.a = (TextView) view.findViewById(us.pinguo.user.R.id.tv_index);
            }
        }

        /* renamed from: us.pinguo.inspire.CountryZoneMoreActivity$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        class C0400b extends RecyclerView.ViewHolder {
            private TextView a;
            private TextView b;

            public C0400b(b bVar, View view) {
                super(view);
                this.b = (TextView) view.findViewById(us.pinguo.user.R.id.zone_name);
                this.a = (TextView) view.findViewById(us.pinguo.user.R.id.zone_number);
            }
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void g(int i2, View view) {
            VdsAgent.lambdaOnClick(view);
            CountryZone.ListBean e2 = e(i2);
            Inspire.c().edit().putString(CountryZoneMoreActivity.f11195j, e2.b()).putInt(CountryZoneMoreActivity.f11196k, e2.a()).commit();
            Intent intent = new Intent();
            intent.putExtra("returnData", e2);
            CountryZoneMoreActivity.this.setResult(0, intent);
            CountryZoneMoreActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public /* synthetic */ void i(int i2, View view) {
            VdsAgent.lambdaOnClick(view);
            CountryZone.ListBean e2 = e(i2);
            Inspire.c().edit().putString(CountryZoneMoreActivity.f11195j, e2.b()).putInt(CountryZoneMoreActivity.f11196k, e2.a()).commit();
            Intent intent = new Intent();
            intent.putExtra("returnData", e2);
            CountryZoneMoreActivity.this.setResult(0, intent);
            CountryZoneMoreActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public /* synthetic */ void k(int i2, View view) {
            VdsAgent.lambdaOnClick(view);
            CountryZone.ListBean e2 = e(i2);
            Inspire.c().edit().putString(CountryZoneMoreActivity.f11195j, e2.b()).putInt(CountryZoneMoreActivity.f11196k, e2.a()).commit();
            Intent intent = new Intent();
            intent.putExtra("returnData", e2);
            CountryZoneMoreActivity.this.setResult(0, intent);
            CountryZoneMoreActivity.this.finish();
        }

        @Override // com.timehop.stickyheadersrecyclerview.b
        public RecyclerView.ViewHolder a(ViewGroup viewGroup) {
            return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(us.pinguo.user.R.layout.zone_view_header, viewGroup, false));
        }

        @Override // com.timehop.stickyheadersrecyclerview.b
        public void b(RecyclerView.ViewHolder viewHolder, int i2) {
            ((a) viewHolder).a.setText(e(i2).group);
        }

        @Override // com.timehop.stickyheadersrecyclerview.b
        public long c(int i2) {
            return e(i2).group.charAt(0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i2) {
            C0400b c0400b = (C0400b) viewHolder;
            c0400b.b.setText(e(i2).b());
            TextView textView = c0400b.a;
            textView.setText(Marker.ANY_NON_NULL_MARKER + e(i2).a());
            c0400b.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CountryZoneMoreActivity.b.this.g(i2, view);
                }
            });
            c0400b.a.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CountryZoneMoreActivity.b.this.i(i2, view);
                }
            });
            c0400b.b.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CountryZoneMoreActivity.b.this.k(i2, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new C0400b(this, LayoutInflater.from(viewGroup.getContext()).inflate(us.pinguo.user.R.layout.zone_view_item, viewGroup, false));
        }
    }

    private void initViews() {
        CompatibleToolbar compatibleToolbar = (CompatibleToolbar) findViewById(us.pinguo.user.R.id.zone_more_toolbar);
        compatibleToolbar.setTitle(us.pinguo.user.R.string.country_zone_text);
        compatibleToolbar.setNavigationIcon(us.pinguo.ui.R.drawable.navigation_back_black);
        compatibleToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CountryZoneMoreActivity.this.t0(view);
            }
        });
        this.f11202i = (TextView) findViewById(us.pinguo.user.R.id.current_zone_name);
        this.f11201h = (TextView) findViewById(us.pinguo.user.R.id.current_zone_number);
        String string = Inspire.c().getString(f11195j, getString(us.pinguo.c360.i18n.R.string.default_country_zone));
        int i2 = Inspire.c().getInt(f11196k, 86);
        this.f11202i.setText(string);
        TextView textView = this.f11201h;
        textView.setText(Marker.ANY_NON_NULL_MARKER + i2);
        this.b = (RecyclerView) findViewById(us.pinguo.user.R.id.recyclerView);
        this.c = (QuickSideBarTipsView) findViewById(us.pinguo.user.R.id.quickSideBarTipsView);
        QuickSideBarView quickSideBarView = (QuickSideBarView) findViewById(us.pinguo.user.R.id.quickSideBarView);
        this.f11197d = quickSideBarView;
        quickSideBarView.setOnQuickSideBarTouchListener(this);
        int i3 = 0;
        this.b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ArrayList<CountryZone> arrayList = this.a;
        if (arrayList != null) {
            Iterator<CountryZone> it = arrayList.iterator();
            while (it.hasNext()) {
                CountryZone next = it.next();
                String a2 = next.a();
                for (CountryZone.ListBean listBean : next.b()) {
                    if (!this.f11198e.containsKey(a2)) {
                        this.f11198e.put(a2, Integer.valueOf(i3));
                    }
                    listBean.group = a2;
                    this.f11200g.add(listBean);
                    i3++;
                }
                this.f11199f.add(a2);
            }
        }
        this.f11197d.setLetters(this.f11199f);
        b bVar = new b();
        bVar.addAll(this.f11200g);
        this.b.setAdapter(bVar);
        this.b.addItemDecoration(new com.timehop.stickyheadersrecyclerview.c(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0(View view) {
        VdsAgent.lambdaOnClick(view);
        onBackPressed();
    }

    @Override // us.pinguo.inspire.widget.quicksidebar.a.a
    public void V(String str, int i2, float f2) {
        this.c.setText(str, i2, f2);
        if (this.f11198e.containsKey(str)) {
            this.b.scrollToPosition(this.f11198e.get(str).intValue());
        }
    }

    @Override // us.pinguo.inspire.widget.quicksidebar.a.a
    public void e(boolean z) {
        QuickSideBarTipsView quickSideBarTipsView = this.c;
        int i2 = z ? 0 : 4;
        quickSideBarTipsView.setVisibility(i2);
        VdsAgent.onSetViewVisibility(quickSideBarTipsView, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(us.pinguo.user.R.layout.country_zone_more_layout);
        this.a = getIntent().getParcelableArrayListExtra("countryZones");
        initViews();
    }
}

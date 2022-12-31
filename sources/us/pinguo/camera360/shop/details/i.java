package us.pinguo.camera360.shop.details;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.camera360.shop.StoreActivity2;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.data.show.BaseShow;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.camera360.shop.data.show.UnlockType;
import us.pinguo.camera360.shop.data.show.s;
import us.pinguo.camera360.shop.data.show.u;
import us.pinguo.camera360.shop.details.TopicDetailsView;
import us.pinguo.camera360.shop.details.i;
import us.pinguo.camera360.shop.view.details.DetailsLoadView;
import us.pinguo.camera360.shop.view.details.TopicImageLoaderView;
import us.pinguo.foundation.utils.n0;
import us.pinguo.ui.widget.RoundRecImageView;
import vStudio.Android.Camera360.R;
/* compiled from: TopicDetailPresenter.java */
/* loaded from: classes4.dex */
public class i extends us.pinguo.camera360.shop.details.e {
    private d b;
    private ShowTopic c;

    /* renamed from: d  reason: collision with root package name */
    private DetailsLoadView f9696d;

    /* renamed from: e  reason: collision with root package name */
    private List<BaseShow> f9697e = new ArrayList(6);

    /* renamed from: f  reason: collision with root package name */
    private u f9698f;

    /* renamed from: g  reason: collision with root package name */
    private Context f9699g;

    /* renamed from: h  reason: collision with root package name */
    private f f9700h;

    /* renamed from: i  reason: collision with root package name */
    private GridLayoutManager f9701i;

    /* renamed from: j  reason: collision with root package name */
    private TopicDetailsView.b f9702j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TopicDetailPresenter.java */
    /* loaded from: classes4.dex */
    public class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return i.this.b.getItemViewType(i2) == 1 ? 3 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TopicDetailPresenter.java */
    /* loaded from: classes4.dex */
    public class b implements s {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void a() {
            if (i.this.m()) {
                i.this.f9696d.d();
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void b(List<ShowScene> list) {
            if (i.this.m()) {
                ShowTopic e2 = i.this.f9698f.e(this.a);
                if (e2 == null) {
                    i.this.f9696d.d();
                } else {
                    i.this.q(e2, a.b.c);
                }
            }
        }

        @Override // us.pinguo.camera360.shop.data.show.s
        public void c(Exception exc) {
            if (i.this.m()) {
                i.this.f9696d.d();
            }
            String name = b.class.getName();
            us.pinguo.common.log.a.e(name, "requestShowDetail error e=" + exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TopicDetailPresenter.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ShowPkg.Status.values().length];
            b = iArr;
            try {
                iArr[ShowPkg.Status.uninstalled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ShowPkg.Status.installed.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ShowPkg.Status.installing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ShowPkg.Status.failed.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[UnlockType.values().length];
            a = iArr2;
            try {
                iArr2[UnlockType.FREE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[UnlockType.MEMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[UnlockType.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[UnlockType.PAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TopicDetailPresenter.java */
    /* loaded from: classes4.dex */
    public class d extends RecyclerView.Adapter {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TopicDetailPresenter.java */
        /* loaded from: classes4.dex */
        public class a extends RecyclerView.ViewHolder {
            public TextView a;
            public TextView b;
            public TextView c;

            /* renamed from: d  reason: collision with root package name */
            public ImageView f9703d;

            /* renamed from: e  reason: collision with root package name */
            public RoundRecImageView f9704e;

            /* renamed from: f  reason: collision with root package name */
            public View f9705f;

            public a(d dVar, View view) {
                super(view);
                this.a = (TextView) view.findViewById(R.id.store_topic_details_bt);
                this.b = (TextView) view.findViewById(R.id.store_topic_details_name_tv);
                this.c = (TextView) view.findViewById(R.id.store_details_effect_count_tv);
                this.f9704e = (RoundRecImageView) view.findViewById(R.id.store_details_effect_icon);
                this.f9703d = (ImageView) view.findViewById(R.id.store_details_effect_icon_new_flag);
                this.f9705f = view.findViewById(R.id.text_area);
            }
        }

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(a aVar, ShowPkg showPkg, View view) {
            VdsAgent.lambdaOnClick(view);
            if (aVar.f9703d.getVisibility() == 0) {
                showPkg.clearRedPoint();
                aVar.f9703d.setVisibility(4);
            }
            a.b.p(a.b.a, showPkg.getId(), a.b.f6820d);
            ((StoreActivity2) i.this.f9699g).n1(showPkg, a.b.f6820d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public /* synthetic */ void h(ShowPkg.Status status, ShowPkg showPkg, a aVar, View view) {
            VdsAgent.lambdaOnClick(view);
            if (status == ShowPkg.Status.installed) {
                g gVar = i.this.a;
                if (gVar != null) {
                    gVar.X(showPkg);
                    return;
                }
                return;
            }
            if (aVar.f9703d.getVisibility() == 0) {
                showPkg.clearRedPoint();
                aVar.f9703d.setVisibility(4);
            }
            a.b.p(a.b.a, showPkg.getId(), a.b.f6820d);
            ((StoreActivity2) i.this.f9699g).n1(showPkg, a.b.f6820d);
        }

        private void i(final a aVar, final ShowPkg showPkg) {
            aVar.a.setTextColor(i.this.f9699g.getResources().getColor(R.color.primary_gray_color));
            final ShowPkg.Status j2 = FilterOperateManager.h().j(showPkg.getId());
            int i2 = c.b[j2.ordinal()];
            String str = "";
            if (i2 == 1) {
                if (i.this.f9698f == null) {
                    i.this.f9698f = u.b();
                }
                if (i.this.f9698f.j(showPkg)) {
                    int i3 = c.a[showPkg.getType().ordinal()];
                    if (i3 == 1) {
                        str = i.this.f9699g.getString(R.string.shop_item_free);
                    } else if (i3 == 2 || i3 == 3) {
                        str = i.this.f9699g.getString(R.string.store_item_unlock);
                    } else if (i3 != 4) {
                        us.pinguo.common.log.a.u("", "Invalid unlockType:" + showPkg.getType(), new Object[0]);
                    } else {
                        str = showPkg.getPayInfo().price;
                    }
                    aVar.a.setText(str);
                } else {
                    int i4 = c.a[showPkg.getType().ordinal()];
                    if (i4 == 1 || i4 == 2 || i4 == 3) {
                        str = i.this.f9699g.getString(R.string.store_pkg_free);
                    } else if (i4 == 4) {
                        str = i.this.f9699g.getString(R.string.store_pkg_download);
                    } else {
                        us.pinguo.common.log.a.u("", "Invalid unlockType:" + showPkg.getType(), new Object[0]);
                    }
                    aVar.a.setText(str);
                }
            } else if (i2 == 2) {
                aVar.a.setTextColor(i.this.f9699g.getResources().getColor(R.color.primary_text_blue));
                aVar.f9705f.setBackgroundResource(R.drawable.store_details_title_btn_ripple);
                aVar.a.setText(i.this.f9699g.getString(R.string.str_use));
            } else if (i2 == 3) {
                aVar.a.setText(i.this.f9699g.getString(R.string.store_pkg_details_downloading));
            } else if (i2 != 4) {
                us.pinguo.common.log.a.u("", "Invalid state:" + j2, new Object[0]);
            } else {
                aVar.a.setText(R.string.store_pkg_download);
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.details.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.d.this.f(aVar, showPkg, view);
                }
            });
            aVar.f9705f.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.details.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i.d.this.h(j2, showPkg, aVar, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return i.this.f9697e.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            return ((BaseShow) i.this.f9697e.get(i2)) instanceof ShowTopic ? 1 : 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            if (viewHolder.getItemViewType() == 1) {
                e eVar = (e) viewHolder;
                eVar.a.setDefaultImage(R.color.primary_default_img);
                eVar.a.setImageUrl(((ShowTopic) i.this.f9697e.get(i2)).getBanner());
                return;
            }
            a aVar = (a) viewHolder;
            ShowPkg showPkg = (ShowPkg) i.this.f9697e.get(i2);
            aVar.b.setText(showPkg.getName());
            TextView textView = aVar.c;
            textView.setText(showPkg.getCount() + "");
            aVar.f9704e.setImageResource(R.color.primary_default_img);
            aVar.f9704e.setImageUri(showPkg.getIcon());
            aVar.f9704e.setRoundPx(n0.d(3.0f));
            if (showPkg.hasRedPoint()) {
                aVar.f9703d.setVisibility(0);
            }
            i(aVar, showPkg);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 1) {
                return new e(i.this, LayoutInflater.from(i.this.f9699g).inflate(R.layout.store_topic_details_item_banner, viewGroup, false));
            }
            return new a(this, LayoutInflater.from(i.this.f9699g).inflate(R.layout.store_topic_details_card_item, viewGroup, false));
        }
    }

    /* compiled from: TopicDetailPresenter.java */
    /* loaded from: classes4.dex */
    class e extends RecyclerView.ViewHolder {
        private TopicImageLoaderView a;

        public e(i iVar, View view) {
            super(view);
            this.a = (TopicImageLoaderView) view.findViewById(R.id.store_details_topic_item_banner_tilv);
        }
    }

    private void j(String str) {
        if (this.f9698f == null) {
            this.f9698f = u.b();
        }
        ShowTopic e2 = this.f9698f.e(str);
        if (e2 == null) {
            this.f9696d.e();
            if (this.f9698f.r(new b(str), true)) {
                return;
            }
            this.f9696d.d();
            return;
        }
        q(e2, a.b.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        return this.f9700h.isShowing();
    }

    public void i(us.pinguo.foundation.p.b bVar) {
        f fVar = (f) bVar;
        this.f9700h = fVar;
        TopicDetailsView.b bVar2 = (TopicDetailsView.b) fVar.b();
        this.f9702j = bVar2;
        this.f9696d = bVar2.c();
        this.f9699g = this.f9700h.getContext();
        this.b = new d();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f9699g, 3);
        this.f9701i = gridLayoutManager;
        gridLayoutManager.setOrientation(1);
        this.f9701i.setSpanSizeLookup(new a());
        this.f9702j.e(this.b, this.f9701i);
    }

    public void k() {
        this.f9702j.d();
        this.f9700h = null;
        this.f9699g = null;
        this.f9702j = null;
        this.a = null;
    }

    public void l(String str) {
        j(str);
        this.f9700h.a();
    }

    public void n(ShowPkg showPkg) {
        int indexOf = this.f9697e.indexOf(showPkg);
        if (indexOf != -1) {
            this.b.notifyItemChanged(indexOf);
        }
    }

    public void o(View view) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.onDetailViewCloseClick(view);
        }
    }

    public void p() {
        this.f9697e.clear();
        this.b.notifyDataSetChanged();
    }

    public void q(BaseShow baseShow, String str) {
        if (baseShow == null) {
            return;
        }
        if (baseShow instanceof ShowTopic) {
            this.c = (ShowTopic) baseShow;
            a.b.r(a.b.a, baseShow.getId());
            this.f9702j.f(this.c.getTopicName());
            this.f9697e.add(this.c);
            this.f9696d.b();
            if (this.c.getPkgs() != null) {
                this.f9697e.addAll(this.c.getPkgs());
            }
            this.b.notifyDataSetChanged();
            this.f9700h.a();
            return;
        }
        throw new IllegalArgumentException("baseShow must be instance of ShowTopic");
    }

    public void r(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (int i3 = 0; i3 < this.f9697e.size(); i3++) {
            if (str.equals(this.f9697e.get(i3).getId())) {
                this.b.notifyItemChanged(i3);
                return;
            }
        }
    }
}

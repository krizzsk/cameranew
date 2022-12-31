package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import java.util.List;
import us.pinguo.camera360.shop.StoreActivity2;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowScene;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.camera360.shop.data.show.UnlockType;
import us.pinguo.ui.widget.CommonRoundImageLoaderView;
import us.pinguo.ui.widget.RoundRecImageView;
import vStudio.Android.Camera360.R;
/* compiled from: StoreCardRVAdapter.java */
/* loaded from: classes3.dex */
public class j extends RecyclerView.Adapter {
    private ShowScene a;
    private Context b;
    private LayoutInflater c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9582d;

    /* renamed from: e  reason: collision with root package name */
    private int f9583e;

    /* compiled from: StoreCardRVAdapter.java */
    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
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
                b[ShowPkg.Status.failed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ShowPkg.Status.installing.ordinal()] = 4;
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

    /* compiled from: StoreCardRVAdapter.java */
    /* loaded from: classes3.dex */
    class b extends RecyclerView.ViewHolder {
        public TextView a;
        public TextView b;
        public TextView c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f9584d;

        /* renamed from: e  reason: collision with root package name */
        public CommonRoundImageLoaderView f9585e;

        /* renamed from: f  reason: collision with root package name */
        public View f9586f;

        /* renamed from: g  reason: collision with root package name */
        public View f9587g;

        /* renamed from: h  reason: collision with root package name */
        public View f9588h;

        public b(j jVar, View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.store_topic_details_bt);
            this.b = (TextView) view.findViewById(R.id.store_topic_details_name_tv);
            this.c = (TextView) view.findViewById(R.id.store_details_effect_count_tv);
            this.f9585e = (CommonRoundImageLoaderView) view.findViewById(R.id.store_details_effect_icon);
            this.f9584d = (ImageView) view.findViewById(R.id.store_details_effect_icon_new_flag);
            this.f9586f = view.findViewById(R.id.text_area);
            this.f9587g = view.findViewById(R.id.iv_store_vip_icon);
            this.f9588h = view.findViewById(R.id.iv_store_free_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StoreCardRVAdapter.java */
    /* loaded from: classes3.dex */
    public class c extends RecyclerView.ViewHolder {
        public RoundRecImageView a;
        public TextView b;
        public ImageView c;

        public c(j jVar, View view) {
            super(view);
            this.a = (RoundRecImageView) view.findViewById(R.id.store_topic_item_banner_ilv);
            this.b = (TextView) view.findViewById(R.id.store_topic_item_name_tv);
            this.c = (ImageView) view.findViewById(R.id.store_topic_item_new_iv);
        }
    }

    public j(ShowScene showScene, Context context, int i2) {
        boolean z = false;
        this.f9582d = false;
        this.a = showScene;
        this.b = context;
        this.f9583e = i2;
        this.c = LayoutInflater.from(context);
        ShowScene showScene2 = this.a;
        if (showScene2 != null && showScene2.getTopicList() != null && this.a.getTopicList().size() > 0) {
            z = true;
        }
        this.f9582d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(c cVar, ShowTopic showTopic, View view) {
        VdsAgent.lambdaOnClick(view);
        if (cVar.c.getVisibility() == 0) {
            showTopic.clearRedPoint();
            cVar.c.setVisibility(4);
        }
        a.b.q(a.b.a, showTopic.getId());
        ((StoreActivity2) this.b).o1(showTopic);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(ShowPkg showPkg, View view) {
        VdsAgent.lambdaOnClick(view);
        a.b.p(a.b.a, showPkg.getId(), a.b.c);
        ((StoreActivity2) this.b).n1(showPkg, a.b.c);
        us.pinguo.foundation.statistics.h.a.p(us.pinguo.camera360.shop.data.k.c(showPkg), us.pinguo.camera360.shop.data.k.d(), showPkg.getId(), "click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j(ShowPkg.Status status, ShowPkg showPkg, View view) {
        VdsAgent.lambdaOnClick(view);
        if (status == ShowPkg.Status.installed) {
            us.pinguo.foundation.statistics.h.a.p(us.pinguo.camera360.shop.data.k.c(showPkg), us.pinguo.camera360.shop.data.k.d(), showPkg.getId(), "use");
            ((StoreActivity2) this.b).l1(showPkg.getId());
            return;
        }
        us.pinguo.foundation.statistics.h.a.p(us.pinguo.camera360.shop.data.k.c(showPkg), us.pinguo.camera360.shop.data.k.d(), showPkg.getId(), "click");
        a.b.p(a.b.a, showPkg.getId(), a.b.c);
        ((StoreActivity2) this.b).n1(showPkg, a.b.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ShowScene showScene = this.a;
        if (showScene == null) {
            return 0;
        }
        return showScene.getShowPkgs().size() + (this.f9582d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        return (this.a.getTopicList().size() == 0 || i2 != 0) ? 2 : 1;
    }

    public void k(String str) {
        ShowScene showScene = this.a;
        if (showScene == null || str == null) {
            return;
        }
        List<ShowPkg> showPkgs = showScene.getShowPkgs();
        int i2 = 0;
        while (true) {
            if (i2 >= showPkgs.size()) {
                i2 = -1;
                break;
            } else if (str.equals(showPkgs.get(i2).getId())) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            if (this.f9582d) {
                i2++;
            }
            notifyItemChanged(i2);
        }
    }

    public void l(UnlockType unlockType) {
        ShowScene showScene = this.a;
        if (showScene != null) {
            List<ShowPkg> showPkgs = showScene.getShowPkgs();
            for (int i2 = 0; i2 < showPkgs.size(); i2++) {
                if (showPkgs.get(i2).getType() == unlockType) {
                    notifyItemChanged(this.f9582d ? i2 + 1 : i2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0270  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r17, int r18) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera360.shop.cardsviewpager.j.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new c(this, this.c.inflate(R.layout.store_cord_topic_item, viewGroup, false));
        }
        return new b(this, this.c.inflate(R.layout.store_card_pkg_item, viewGroup, false));
    }
}

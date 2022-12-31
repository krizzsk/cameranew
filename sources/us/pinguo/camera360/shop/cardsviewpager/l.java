package us.pinguo.camera360.shop.cardsviewpager;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.k.b.a;
import com.pinguo.camera360.vip.VipManager;
import kotlin.jvm.internal.s;
import us.pinguo.camera360.shop.StoreActivity2;
import us.pinguo.camera360.shop.data.install.FilterOperateManager;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.UnlockType;
import us.pinguo.camera360.shop.data.show.u;
import us.pinguo.ui.widget.CommonFixRateRoundImageView;
import vStudio.Android.Camera360.R;
/* compiled from: StoreVipAdapter.kt */
/* loaded from: classes3.dex */
public final class l extends RecyclerView.ViewHolder {
    private final Context a;
    private final CommonFixRateRoundImageView b;
    private final TextView c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f9589d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f9590e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f9591f;

    /* renamed from: g  reason: collision with root package name */
    private final View f9592g;

    /* renamed from: h  reason: collision with root package name */
    private final View f9593h;

    /* compiled from: StoreVipAdapter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ShowPkg.Status.values().length];
            iArr[ShowPkg.Status.uninstalled.ordinal()] = 1;
            iArr[ShowPkg.Status.installed.ordinal()] = 2;
            iArr[ShowPkg.Status.failed.ordinal()] = 3;
            iArr[ShowPkg.Status.installing.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[UnlockType.values().length];
            iArr2[UnlockType.FREE.ordinal()] = 1;
            iArr2[UnlockType.MEMBER.ordinal()] = 2;
            iArr2[UnlockType.SHARE.ordinal()] = 3;
            iArr2[UnlockType.PAY.ordinal()] = 4;
            b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(View itemView, Context context) {
        super(itemView);
        s.h(itemView, "itemView");
        s.h(context, "context");
        this.a = context;
        this.b = (CommonFixRateRoundImageView) itemView.findViewById(R.id.iv_store_vip_banner);
        this.c = (TextView) itemView.findViewById(R.id.tv_vip_effect_name);
        this.f9589d = (TextView) itemView.findViewById(R.id.store_details_effect_count_tv);
        this.f9590e = (TextView) itemView.findViewById(R.id.tv_vip_unlock);
        this.f9591f = (TextView) itemView.findViewById(R.id.tv_vip_free);
        this.f9592g = itemView.findViewById(R.id.layout_store_vip_image);
        this.f9593h = itemView.findViewById(R.id.text_layout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ShowPkg showPkg, l this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(showPkg, "$showPkg");
        s.h(this$0, "this$0");
        showPkg.clearRedPoint();
        us.pinguo.foundation.statistics.h.a.p(us.pinguo.camera360.shop.data.k.c(showPkg), us.pinguo.camera360.shop.data.k.d(), showPkg.getId(), "click");
        ((StoreActivity2) this$0.a).n1(showPkg, a.b.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ShowPkg showPkg, l this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(showPkg, "$showPkg");
        s.h(this$0, "this$0");
        showPkg.clearRedPoint();
        us.pinguo.foundation.statistics.h.a.p(us.pinguo.camera360.shop.data.k.c(showPkg), us.pinguo.camera360.shop.data.k.d(), showPkg.getId(), "click");
        ((StoreActivity2) this$0.a).n1(showPkg, a.b.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ShowPkg showPkg, ShowPkg.Status status, l this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(showPkg, "$showPkg");
        s.h(this$0, "this$0");
        showPkg.clearRedPoint();
        if (status == ShowPkg.Status.installed) {
            us.pinguo.foundation.statistics.h.a.p(us.pinguo.camera360.shop.data.k.c(showPkg), us.pinguo.camera360.shop.data.k.d(), showPkg.getId(), "use");
            ((StoreActivity2) this$0.a).l1(showPkg.getId());
            return;
        }
        us.pinguo.foundation.statistics.h.a.p(us.pinguo.camera360.shop.data.k.c(showPkg), us.pinguo.camera360.shop.data.k.d(), showPkg.getId(), "click");
        ((StoreActivity2) this$0.a).n1(showPkg, a.b.c);
    }

    public final void a(final ShowPkg showPkg) {
        s.h(showPkg, "showPkg");
        this.b.setImageResource(R.color.primary_default_img);
        this.b.setImageUrl(showPkg.getVipBanner());
        this.c.setText(showPkg.getName());
        this.f9589d.setText(String.valueOf(showPkg.getCount()));
        this.f9592g.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.cardsviewpager.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.b(ShowPkg.this, this, view);
            }
        });
        final ShowPkg.Status j2 = FilterOperateManager.h().j(showPkg.getId());
        this.f9593h.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.cardsviewpager.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.c(ShowPkg.this, this, view);
            }
        });
        this.f9591f.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.cardsviewpager.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.d(ShowPkg.this, j2, this, view);
            }
        });
        boolean e2 = VipManager.a.e(true);
        boolean j3 = u.b().j(showPkg);
        this.f9591f.setTextColor(this.a.getResources().getColor(R.color.store_item_color));
        int i2 = j2 == null ? -1 : a.a[j2.ordinal()];
        String str = "";
        boolean z = false;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    this.f9591f.setText(this.a.getString(R.string.install_failed));
                } else if (i2 != 4) {
                    us.pinguo.common.log.a.u("", s.q("Invalid state:", j2), new Object[0]);
                } else {
                    this.f9591f.setText(this.a.getString(R.string.store_pkg_details_downloading));
                }
            } else if (!e2 && j3 && showPkg.getType() == UnlockType.PAY) {
                this.f9591f.setText(this.a.getString(R.string.vip_free));
            } else {
                this.f9591f.setTextColor(this.a.getResources().getColor(R.color.primary_text_blue));
                this.f9591f.setText(this.a.getString(R.string.str_use));
            }
        } else if (!e2 && j3) {
            this.f9591f.setText(this.a.getString(R.string.vip_free));
        } else {
            this.f9591f.setText(this.a.getString(R.string.free_download));
        }
        boolean z2 = (showPkg.getVip() != 0 && e2) || !j3;
        UnlockType type = showPkg.getType();
        int i3 = type != null ? a.b[type.ordinal()] : -1;
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                str = this.a.getString(R.string.store_item_unlock);
                s.g(str, "context.getString(R.string.store_item_unlock)");
            } else if (i3 != 4) {
                us.pinguo.common.log.a.u("", s.q("Invalid unlockType:", showPkg.getType()), new Object[0]);
            } else {
                str = showPkg.getPayInfo().price;
                s.g(str, "showPkg.payInfo.price");
            }
            z = z2;
        } else {
            str = this.a.getString(R.string.shop_item_free);
            s.g(str, "context.getString(R.string.shop_item_free)");
        }
        this.f9590e.setText(str);
        if (z) {
            TextView textView = this.f9590e;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            return;
        }
        TextView textView2 = this.f9590e;
        textView2.setPaintFlags(textView2.getPaintFlags() & (-17));
    }
}

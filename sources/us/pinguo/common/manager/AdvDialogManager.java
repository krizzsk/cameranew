package us.pinguo.common.manager;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.List;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.camera2020.view.dialog.HomeAdvDialog;
import us.pinguo.common.widget.ColorAnimDraweeView;
import us.pinguo.foundation.f;
import us.pinguo.foundation.interaction.AppGoto;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.c;
import us.pinguo.foundation.utils.y;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: AdvDialogManager.kt */
/* loaded from: classes4.dex */
public final class AdvDialogManager {
    private HomeAdvDialog a;
    private boolean b;

    private final String[] b(String str, String[] strArr) {
        int length = strArr.length;
        return length >= 4 ? new String[]{str, strArr[0], strArr[1], strArr[2], strArr[3]} : length >= 3 ? new String[]{str, strArr[0], strArr[1], strArr[2]} : length >= 2 ? new String[]{str, strArr[0], strArr[1]} : length >= 1 ? new String[]{str, strArr[0]} : new String[]{str};
    }

    private final void c(ColorAnimDraweeView colorAnimDraweeView) {
        if (this.b && colorAnimDraweeView.getVisibility() != 0) {
            c.a(colorAnimDraweeView, 0.0f, 1.0f, 300L, null);
            colorAnimDraweeView.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(AdvDialogManager advDialogManager, String str, String str2, FragmentActivity fragmentActivity, l lVar, kotlin.jvm.b.a aVar, int i2, Object obj) {
        kotlin.jvm.b.a<u> aVar2 = aVar;
        if ((i2 & 16) != 0) {
            aVar2 = null;
        }
        advDialogManager.h(str, str2, fragmentActivity, lVar, aVar2);
    }

    public static /* synthetic */ void k(AdvDialogManager advDialogManager, ColorAnimDraweeView colorAnimDraweeView, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        advDialogManager.j(colorAnimDraweeView, z);
    }

    public static final void l(AdvDialogManager this$0, AdvItem item, ColorAnimDraweeView previewAdView, String value, String[] prefs, String prefKey, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        s.h(item, "$item");
        s.h(previewAdView, "$previewAdView");
        s.h(value, "$value");
        s.h(prefKey, "$prefKey");
        this$0.b = false;
        AdvConfigManager.getInstance().addGuidDisplayCount(item);
        h.a.h0("shot_btn_popup", item.advId, "click");
        AppGoto.getInstance().d(item).b(previewAdView.getContext());
        s.g(prefs, "prefs");
        AdvPrefUtil.getInstance().putString(prefKey, y.d(this$0.b(value, prefs), ";"));
        previewAdView.setVisibility(4);
    }

    public final void d(ColorAnimDraweeView previewAdView) {
        s.h(previewAdView, "previewAdView");
        if (previewAdView.getVisibility() == 0) {
            previewAdView.setTag(Integer.valueOf(previewAdView.getVisibility()));
            previewAdView.setVisibility(4);
        }
    }

    public final void f(ColorAnimDraweeView previewAdView) {
        s.h(previewAdView, "previewAdView");
        if (previewAdView.getTag() != null) {
            previewAdView.setVisibility(0);
            previewAdView.setTag(null);
        }
    }

    public final void g(String guid, String popUpPage, FragmentActivity fragmentActivity, boolean z) {
        AdvItem d2;
        s.h(guid, "guid");
        s.h(popUpPage, "popUpPage");
        if (f.e() && (d2 = b.a.d(guid, popUpPage, z)) != null) {
            HomeAdvDialog homeAdvDialog = new HomeAdvDialog();
            this.a = homeAdvDialog;
            if (homeAdvDialog != null) {
                String str = d2.downloadedFilePath;
                s.g(str, "advItem.downloadedFilePath");
                homeAdvDialog.o0(str);
            }
            HomeAdvDialog homeAdvDialog2 = this.a;
            if (homeAdvDialog2 != null) {
                homeAdvDialog2.q0(new AdvDialogManager$showAdvDialog$1$1(d2, this, fragmentActivity));
            }
            HomeAdvDialog homeAdvDialog3 = this.a;
            if (homeAdvDialog3 != null) {
                homeAdvDialog3.p0(new AdvDialogManager$showAdvDialog$1$2(d2));
            }
            kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new AdvDialogManager$showAdvDialog$1$3(fragmentActivity, this, d2, null), 3, null);
        }
    }

    public final void h(String guid, String popUpPage, FragmentActivity fragmentActivity, l<? super Uri, u> onConfirmClick, kotlin.jvm.b.a<u> aVar) {
        AdvItem e2;
        s.h(guid, "guid");
        s.h(popUpPage, "popUpPage");
        s.h(onConfirmClick, "onConfirmClick");
        if (f.e() && (e2 = b.e(b.a, guid, popUpPage, false, 4, null)) != null) {
            HomeAdvDialog homeAdvDialog = new HomeAdvDialog();
            this.a = homeAdvDialog;
            if (homeAdvDialog != null) {
                String str = e2.downloadedFilePath;
                s.g(str, "advItem.downloadedFilePath");
                homeAdvDialog.o0(str);
            }
            HomeAdvDialog homeAdvDialog2 = this.a;
            if (homeAdvDialog2 != null) {
                homeAdvDialog2.q0(new AdvDialogManager$showEditAdvDialog$1$1(e2, this, onConfirmClick, fragmentActivity));
            }
            HomeAdvDialog homeAdvDialog3 = this.a;
            if (homeAdvDialog3 != null) {
                homeAdvDialog3.p0(new AdvDialogManager$showEditAdvDialog$1$2(aVar, e2));
            }
            kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new AdvDialogManager$showEditAdvDialog$1$3(fragmentActivity, this, e2, null), 3, null);
        }
    }

    public final void j(final ColorAnimDraweeView previewAdView, boolean z) {
        s.h(previewAdView, "previewAdView");
        this.b = false;
        previewAdView.setVisibility(4);
        List<AdvItem> items = AdvConfigManager.getInstance().getItems("14e89b8dbb648f81fb8d7960ddde7806");
        if (items.isEmpty()) {
            return;
        }
        final String[] f2 = y.f(AdvPrefUtil.getInstance().getString("key_preview_ad_above_btn", null), ";");
        for (AdvItem advItem : items) {
            final AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(advItem);
            if (loadDownloadedImage != null) {
                final String str = us.pinguo.util.u.d(System.currentTimeMillis(), AdvTimeUtils.DATE_FORMAT_DAY) + '_' + ((Object) loadDownloadedImage.advId);
                if (y.c(f2, str) < 0) {
                    previewAdView.setImageURI(s.q(InspirePublishFragment.FILE_HEADER, loadDownloadedImage.downloadedIconPath));
                    previewAdView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.manager.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AdvDialogManager.l(AdvDialogManager.this, loadDownloadedImage, previewAdView, str, f2, r6, view);
                        }
                    });
                    this.b = true;
                    if (z) {
                        previewAdView.setTag(0);
                        previewAdView.setVisibility(4);
                    } else {
                        c(previewAdView);
                    }
                    h.a.h0("shot_btn_popup", loadDownloadedImage.advId, "show");
                    return;
                }
            }
        }
    }
}

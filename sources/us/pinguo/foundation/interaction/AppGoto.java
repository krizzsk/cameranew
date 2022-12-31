package us.pinguo.foundation.interaction;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.advconfigdata.database.AdvItem;
/* loaded from: classes4.dex */
public class AppGoto {
    private List<us.pinguo.foundation.interaction.a> a;

    /* loaded from: classes4.dex */
    private static final class b {
        private static final AppGoto a = new AppGoto();
    }

    public static AppGoto getInstance() {
        return b.a;
    }

    public AppGoto a(us.pinguo.foundation.interaction.a aVar) {
        this.a.add(aVar);
        return this;
    }

    public c b(Uri uri) {
        if (!uri.isHierarchical()) {
            return new e();
        }
        for (us.pinguo.foundation.interaction.a aVar : this.a) {
            if (aVar.d(uri)) {
                return new c(uri, aVar);
            }
        }
        return new c(uri, new us.pinguo.foundation.interaction.b());
    }

    public c c(String str) {
        return b(Uri.parse(str));
    }

    public c d(AdvItem advItem) {
        if (TextUtils.isEmpty(advItem.interactionUri) && "appwall".equals(advItem.advType)) {
            advItem.interactionUri = us.pinguo.foundation.constant.a.a;
        }
        c b2 = b(Uri.parse(advItem.interactionUri));
        Bundle bundle = new Bundle();
        bundle.putString("applist_type", String.valueOf(advItem.advProvider));
        bundle.putString("applist_unit_id", advItem.mvId);
        bundle.putBoolean("force_inner_browser", advItem.forceInnerBrowser);
        b2.d(bundle);
        return b2;
    }

    public c e(d dVar) {
        if (TextUtils.isEmpty(dVar.d()) && "appwall".equals(dVar.b())) {
            dVar.f(us.pinguo.foundation.constant.a.a);
        }
        c b2 = b(Uri.parse(dVar.d()));
        Bundle bundle = new Bundle();
        bundle.putString("applist_type", String.valueOf(dVar.a()));
        bundle.putString("applist_unit_id", dVar.e());
        bundle.putBoolean("force_inner_browser", dVar.c().booleanValue());
        b2.d(bundle);
        return b2;
    }

    private AppGoto() {
        this.a = new ArrayList();
    }
}

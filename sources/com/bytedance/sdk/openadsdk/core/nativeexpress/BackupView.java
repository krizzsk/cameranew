package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes.dex */
public abstract class BackupView extends FrameLayout {
    protected Context a;
    protected com.bytedance.sdk.openadsdk.core.d.h b;
    protected com.bytedance.sdk.openadsdk.dislike.b c;

    /* renamed from: d  reason: collision with root package name */
    protected TTDislikeDialogAbstract f1689d;

    /* renamed from: e  reason: collision with root package name */
    protected String f1690e;

    /* renamed from: f  reason: collision with root package name */
    protected int f1691f;

    /* renamed from: g  reason: collision with root package name */
    protected int f1692g;

    public BackupView(@NonNull Context context) {
        super(context);
        this.f1690e = "embeded_ad";
        setTag("tt_express_backup_fl_tag_26");
    }

    public void a() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f1689d;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            VdsAgent.showDialog(tTDislikeDialogAbstract);
            return;
        }
        com.bytedance.sdk.openadsdk.dislike.b bVar = this.c;
        if (bVar != null) {
            bVar.showDislikeDialog();
        }
    }

    protected abstract void a(int i2, com.bytedance.sdk.openadsdk.core.d.f fVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDescription() {
        if (TextUtils.isEmpty(this.b.G())) {
            return !TextUtils.isEmpty(this.b.H()) ? this.b.H() : "";
        }
        return this.b.G();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
        if (hVar == null) {
            return "";
        }
        if (hVar.K() == null || TextUtils.isEmpty(this.b.K().b())) {
            return !TextUtils.isEmpty(this.b.w()) ? this.b.w() : "";
        }
        return this.b.K().b();
    }

    public float getRealHeight() {
        return ac.b(this.a, this.f1692g);
    }

    public float getRealWidth() {
        return ac.b(this.a, this.f1691f);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTitle() {
        if (this.b.K() != null && !TextUtils.isEmpty(this.b.K().b())) {
            return this.b.K().b();
        }
        if (TextUtils.isEmpty(this.b.w())) {
            return !TextUtils.isEmpty(this.b.G()) ? this.b.G() : "";
        }
        return this.b.w();
    }

    public void setDislikeInner(TTAdDislike tTAdDislike) {
        if (tTAdDislike instanceof com.bytedance.sdk.openadsdk.dislike.b) {
            this.c = (com.bytedance.sdk.openadsdk.dislike.b) tTAdDislike;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.d.h hVar;
        if (tTDislikeDialogAbstract != null && (hVar = this.b) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(hVar);
        }
        this.f1689d = tTDislikeDialogAbstract;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.a.b bVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.a;
            com.bytedance.sdk.openadsdk.core.d.h hVar = this.b;
            String str = this.f1690e;
            bVar = new com.bytedance.sdk.openadsdk.core.a.a(context, hVar, str, ab.a(str));
        } else {
            Context context2 = this.a;
            com.bytedance.sdk.openadsdk.core.d.h hVar2 = this.b;
            String str2 = this.f1690e;
            bVar = new com.bytedance.sdk.openadsdk.core.a.b(context2, hVar2, str2, ab.a(str2));
        }
        view.setOnTouchListener(bVar);
        view.setOnClickListener(bVar);
        bVar.a(new a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.a
            public void a(int i2, com.bytedance.sdk.openadsdk.core.d.f fVar) {
                BackupView.this.a(i2, fVar);
            }
        });
    }
}

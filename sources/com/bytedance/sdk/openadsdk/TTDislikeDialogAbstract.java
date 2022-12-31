package com.bytedance.sdk.openadsdk;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
/* loaded from: classes.dex */
public abstract class TTDislikeDialogAbstract extends Dialog {
    private View a;
    private h b;

    public TTDislikeDialogAbstract(@NonNull Context context) {
        super(context);
    }

    private void a() {
        if (this.b == null || this.a == null) {
            return;
        }
        int[] tTDislikeListViewIds = getTTDislikeListViewIds();
        if (tTDislikeListViewIds != null && tTDislikeListViewIds.length > 0) {
            for (int i2 : tTDislikeListViewIds) {
                View findViewById = this.a.findViewById(i2);
                if (findViewById != null) {
                    if (findViewById instanceof TTDislikeListView) {
                        ((TTDislikeListView) findViewById).setMaterialMeta(this.b);
                    } else {
                        throw new IllegalArgumentException("getTTDislikeListViewIds找到的view类型异常，请检查");
                    }
                } else {
                    throw new IllegalArgumentException("getTTDislikeListViewIds提供的id找不到view，请检查");
                }
            }
            return;
        }
        throw new IllegalArgumentException("dislike选项列表为空，请设置TTDislikeListView");
    }

    public abstract int getLayoutId();

    public abstract ViewGroup.LayoutParams getLayoutParams();

    public abstract int[] getTTDislikeListViewIds();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) null);
        this.a = inflate;
        if (inflate != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            View view = this.a;
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            setContentView(view, layoutParams);
            a();
            return;
        }
        throw new IllegalArgumentException("getLayoutId布局文件id可能异常，请检查");
    }

    public void setMaterialMeta(h hVar) {
        this.b = hVar;
        a();
    }

    public TTDislikeDialogAbstract(@NonNull Context context, int i2) {
        super(context, i2);
    }
}

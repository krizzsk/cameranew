package com.pinguo.camera360.homepage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.ui.widget.FixedRateImageLoaderView;
import vStudio.Android.Camera360.R;
/* compiled from: UpdateDialog.kt */
/* loaded from: classes3.dex */
public final class UpdateDialog extends DialogFragment {
    public Map<Integer, View> a = new LinkedHashMap();
    private Context b;
    private AdvItem c;

    /* renamed from: d  reason: collision with root package name */
    private AdvItem f6775d;

    private final String b0() {
        try {
            Context context = this.b;
            kotlin.jvm.internal.s.e(context);
            String packageName = context.getPackageName();
            kotlin.jvm.internal.s.g(packageName, "mContext!!.getPackageName()");
            Context context2 = this.b;
            kotlin.jvm.internal.s.e(context2);
            String str = context2.getPackageManager().getPackageInfo(packageName, 0).versionName;
            kotlin.jvm.internal.s.g(str, "mContext!!.getPackageMan…fo(pkName, 0).versionName");
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(UpdateDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.a.c("unforce_update", "click_not_now");
        Dialog dialog = this$0.getDialog();
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(UpdateDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.a.c("unforce_update", "click_update_now");
        Dialog dialog = this$0.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        AdvItem advItem = this$0.c;
        String str = advItem == null ? null : advItem.interactionUri;
        kotlin.jvm.internal.s.e(str);
        this$0.m0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(UpdateDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        us.pinguo.foundation.statistics.h.a.c("force_update", "click_update_now");
        AdvItem advItem = this$0.f6775d;
        String str = advItem == null ? null : advItem.interactionUri;
        kotlin.jvm.internal.s.e(str);
        this$0.m0(str);
    }

    private final void m0(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri parse = Uri.parse(str);
        kotlin.jvm.internal.s.g(parse, "parse(url)");
        intent.setData(parse);
        startActivity(intent);
    }

    public void _$_clearFindViewByIdCache() {
        this.a.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        */
    public final boolean a0(java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.UpdateDialog.a0(java.lang.String, java.lang.String):boolean");
    }

    public final boolean c0() {
        AdvItem advItem = this.f6775d;
        if (advItem != null) {
            return a0(advItem != null ? advItem.at : null, b0());
        }
        AdvItem advItem2 = this.c;
        if (advItem2 == null || com.pinguo.camera360.adv.c.c) {
            return false;
        }
        if ((advItem2 == null ? null : Integer.valueOf(advItem2.displayCount)) != null) {
            AdvItem advItem3 = this.c;
            Integer valueOf = advItem3 == null ? null : Integer.valueOf(advItem3.displayCount);
            kotlin.jvm.internal.s.e(valueOf);
            if (valueOf.intValue() > 0) {
                AdvItem advItem4 = this.c;
                Integer valueOf2 = advItem4 == null ? null : Integer.valueOf(advItem4.displayCount);
                kotlin.jvm.internal.s.e(valueOf2);
                int intValue = valueOf2.intValue();
                AdvConfigManager advConfigManager = AdvConfigManager.getInstance();
                AdvItem advItem5 = this.c;
                kotlin.jvm.internal.s.e(advItem5);
                if (intValue <= advConfigManager.getGuidDisplayCount(advItem5.guid, "1e6d82ea76b94425b4935623e1db5354")) {
                    return false;
                }
            }
        }
        AdvItem advItem6 = this.c;
        return a0(advItem6 != null ? advItem6.at : null, b0());
    }

    public final void j0(AdvItem advItem) {
        this.f6775d = advItem;
    }

    public final void k0(Context context) {
        this.b = context;
    }

    public final void l0(AdvItem advItem) {
        this.c = advItem;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.s.h(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_update_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        kotlin.jvm.internal.s.h(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f6775d == null) {
            if (this.c == null) {
                return;
            }
            TextView textView = (TextView) _$_findCachedViewById(R.id.title);
            AdvItem advItem = this.c;
            textView.setText(advItem == null ? null : advItem.popTitle);
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.msg);
            AdvItem advItem2 = this.c;
            textView2.setText(advItem2 == null ? null : advItem2.popContent);
            int i2 = R.id.positive;
            TextView textView3 = (TextView) _$_findCachedViewById(i2);
            AdvItem advItem3 = this.c;
            textView3.setText(advItem3 == null ? null : advItem3.popBtnText);
            int i3 = R.id.negative;
            TextView textView4 = (TextView) _$_findCachedViewById(i3);
            AdvItem advItem4 = this.c;
            textView4.setText(advItem4 == null ? null : advItem4.btnText);
            AdvItem advItem5 = this.c;
            if (TextUtils.isEmpty(advItem5 == null ? null : advItem5.imageUrl)) {
                Context context = getContext();
                kotlin.jvm.internal.s.e(context);
                ((FixedRateImageLoaderView) _$_findCachedViewById(R.id.image)).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.update_dialog));
            } else {
                FixedRateImageLoaderView fixedRateImageLoaderView = (FixedRateImageLoaderView) _$_findCachedViewById(R.id.image);
                AdvItem advItem6 = this.c;
                fixedRateImageLoaderView.setImageUrl(advItem6 == null ? null : advItem6.imageUrl);
            }
            ((TextView) _$_findCachedViewById(i3)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UpdateDialog.g0(UpdateDialog.this, view2);
                }
            });
            AdvItem advItem7 = this.c;
            str = advItem7 != null ? advItem7.interactionUri : null;
            kotlin.jvm.internal.s.e(str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ((TextView) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    UpdateDialog.h0(UpdateDialog.this, view2);
                }
            });
            return;
        }
        TextView textView5 = (TextView) _$_findCachedViewById(R.id.negative);
        textView5.setVisibility(8);
        VdsAgent.onSetViewVisibility(textView5, 8);
        TextView textView6 = (TextView) _$_findCachedViewById(R.id.title);
        AdvItem advItem8 = this.f6775d;
        textView6.setText(advItem8 == null ? null : advItem8.popTitle);
        TextView textView7 = (TextView) _$_findCachedViewById(R.id.msg);
        AdvItem advItem9 = this.f6775d;
        textView7.setText(advItem9 == null ? null : advItem9.popContent);
        int i4 = R.id.positive;
        TextView textView8 = (TextView) _$_findCachedViewById(i4);
        AdvItem advItem10 = this.f6775d;
        textView8.setText(advItem10 == null ? null : advItem10.popBtnText);
        AdvItem advItem11 = this.f6775d;
        if (TextUtils.isEmpty(advItem11 == null ? null : advItem11.imageUrl)) {
            Context context2 = getContext();
            kotlin.jvm.internal.s.e(context2);
            ((FixedRateImageLoaderView) _$_findCachedViewById(R.id.image)).setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.update_dialog));
        } else {
            FixedRateImageLoaderView fixedRateImageLoaderView2 = (FixedRateImageLoaderView) _$_findCachedViewById(R.id.image);
            AdvItem advItem12 = this.f6775d;
            fixedRateImageLoaderView2.setImageUrl(advItem12 == null ? null : advItem12.imageUrl);
        }
        AdvItem advItem13 = this.f6775d;
        str = advItem13 != null ? advItem13.interactionUri : null;
        kotlin.jvm.internal.s.e(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((TextView) _$_findCachedViewById(i4)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.homepage.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UpdateDialog.i0(UpdateDialog.this, view2);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        kotlin.jvm.internal.s.h(manager, "manager");
        if (c0()) {
            if (this.f6775d == null) {
                if (this.c != null) {
                    AdvConfigManager.getInstance().addGuidDisplayCount(this.c);
                    us.pinguo.foundation.statistics.h.a.c("unforce_update", "show");
                }
            } else {
                us.pinguo.foundation.statistics.h.a.c("force_update", "show");
            }
            com.pinguo.camera360.adv.c.c = true;
            super.show(manager, str);
            VdsAgent.showDialogFragment(this, manager, str);
        }
    }
}

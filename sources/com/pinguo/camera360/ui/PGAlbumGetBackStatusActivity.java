package com.pinguo.camera360.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.homepage.HomePageActivity;
import com.pinguo.camera360.request.AlbumGetBackStatusInfo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
import us.pinguo.foundation.base.BaseActivity;
import vStudio.Android.Camera360.R;
/* compiled from: PGAlbumGetBackStatusActivity.kt */
/* loaded from: classes3.dex */
public final class PGAlbumGetBackStatusActivity extends BaseActivity {
    public Map<Integer, View> a = new LinkedHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(PGAlbumGetBackStatusActivity this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        Intent intent = new Intent();
        intent.setClass(this$0, HomePageActivity.class);
        intent.setFlags(67108864);
        this$0.startActivity(intent);
        this$0.finish();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Spanned fromHtml;
        super.onCreate(bundle);
        setContentView(R.layout.activity_pgalbum_get_back_status);
        ((TitleBarLayout) _$_findCachedViewById(R.id.title_bar_layout)).setTiTleText(getString(R.string.text_submit_feedback));
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(NotificationCompat.CATEGORY_EMAIL);
        AlbumGetBackStatusInfo.AlbumGetBackStatus albumGetBackStatus = AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_NONE;
        int intExtra = intent.getIntExtra("status", albumGetBackStatus.status);
        if (!TextUtils.isEmpty(stringExtra)) {
            x xVar = x.a;
            String string = getResources().getString(R.string.text_album_get_back_status_hint);
            s.g(string, "resources.getString(R.st…bum_get_back_status_hint)");
            String format = String.format(string, Arrays.copyOf(new Object[]{"<br /><font color=\"#4487F2\">" + ((Object) stringExtra) + "</font>  <br />  "}, 1));
            s.g(format, "format(format, *args)");
            fromHtml = Html.fromHtml(format);
            s.g(fromHtml, "fromHtml(String.format(r…ack_status_hint), param))");
        } else {
            x xVar2 = x.a;
            String string2 = getResources().getString(R.string.text_album_get_back_status_hint);
            s.g(string2, "resources.getString(R.st…bum_get_back_status_hint)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{"<br /><font color=\"#4487F2\"></font>  <br />  "}, 1));
            s.g(format2, "format(format, *args)");
            fromHtml = Html.fromHtml(format2);
            s.g(fromHtml, "fromHtml(String.format(r…ack_status_hint), param))");
        }
        int i2 = R.id.btn_back_to_homepage;
        ((Button) _$_findCachedViewById(i2)).setOnClickListener(new View.OnClickListener() { // from class: com.pinguo.camera360.ui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGAlbumGetBackStatusActivity.r0(PGAlbumGetBackStatusActivity.this, view);
            }
        });
        if (intExtra == albumGetBackStatus.status) {
            ((TextView) _$_findCachedViewById(R.id.tv_album_get_back_status)).setText(getString(R.string.text_submit_succtss));
            Button button = (Button) _$_findCachedViewById(i2);
            button.setVisibility(0);
            VdsAgent.onSetViewVisibility(button, 0);
            ((ImageView) _$_findCachedViewById(R.id.iv_album_get_back_status)).setImageResource(R.drawable.vector_album_get_back_finish);
        } else if (intExtra == AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_HANDING.status) {
            ((TextView) _$_findCachedViewById(R.id.tv_album_get_back_status)).setText(getString(R.string.text_handing));
            ((ImageView) _$_findCachedViewById(R.id.iv_album_get_back_status)).setImageResource(R.drawable.img_album_get_back_status_handling);
            Button button2 = (Button) _$_findCachedViewById(i2);
            button2.setVisibility(8);
            VdsAgent.onSetViewVisibility(button2, 8);
        } else if (intExtra == AlbumGetBackStatusInfo.AlbumGetBackStatus.ALBUM_GET_BACK_STATUS_FINISHED.status) {
            ((ImageView) _$_findCachedViewById(R.id.iv_album_get_back_status)).setImageResource(R.drawable.vector_album_get_back_finish);
            ((TextView) _$_findCachedViewById(R.id.tv_album_get_back_status)).setText(getString(R.string.text_complete));
            Button button3 = (Button) _$_findCachedViewById(i2);
            button3.setVisibility(8);
            VdsAgent.onSetViewVisibility(button3, 8);
            if (!TextUtils.isEmpty(stringExtra)) {
                String str = "<br /><font color=\"#4487F2\">" + ((Object) stringExtra) + "</font><br />";
                x xVar3 = x.a;
                String string3 = getResources().getString(R.string.text_album_get_back_status_finish_hint);
                s.g(string3, "resources.getString(R.st…_back_status_finish_hint)");
                String format3 = String.format(string3, Arrays.copyOf(new Object[]{str}, 1));
                s.g(format3, "format(format, *args)");
                fromHtml = Html.fromHtml(format3);
                s.g(fromHtml, "fromHtml(String.format(r…tus_finish_hint), param))");
            } else {
                x xVar4 = x.a;
                String string4 = getResources().getString(R.string.text_album_get_back_status_finish_hint);
                s.g(string4, "resources.getString(R.st…_back_status_finish_hint)");
                String format4 = String.format(string4, Arrays.copyOf(new Object[]{"<br /><font color=\"#4487F2\"></font>  <br />  "}, 1));
                s.g(format4, "format(format, *args)");
                fromHtml = Html.fromHtml(format4);
                s.g(fromHtml, "fromHtml(String.format(r…tus_finish_hint), param))");
            }
        }
        ((TextView) _$_findCachedViewById(R.id.tv_album_get_back_status_hint)).setText(fromHtml);
    }
}

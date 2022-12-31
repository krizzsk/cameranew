package com.pinguo.camera360.adv.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.c;
import us.pinguo.admobvista.d.a;
import us.pinguo.advconfigdata.AdvConfigManager;
import vStudio.Android.Camera360.R;
/* loaded from: classes3.dex */
public class AlbumGIFAdvActivity extends Activity implements a.InterfaceC0352a {
    private String a;
    private boolean b = false;
    @BindView
    RelativeLayout mAdvLayout;
    @BindView
    GifImageView mAlbumGiftBgGifview;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements pl.droidsonroids.gif.a {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // pl.droidsonroids.gif.a
        public void a(int i2) {
            this.a.j(65535);
            AlbumGIFAdvActivity.this.mAlbumGiftBgGifview.setImageDrawable(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements pl.droidsonroids.gif.a {
        final /* synthetic */ c a;
        final /* synthetic */ c b;

        b(c cVar, c cVar2) {
            this.a = cVar;
            this.b = cVar2;
        }

        @Override // pl.droidsonroids.gif.a
        public void a(int i2) {
            if (AlbumGIFAdvActivity.this.b) {
                this.a.stop();
                AlbumGIFAdvActivity.this.mAlbumGiftBgGifview.setImageDrawable(this.b);
            }
        }
    }

    private void b() {
        int j2 = us.pinguo.foundation.t.b.a.j(this);
        int i2 = us.pinguo.foundation.t.b.a.h(this) >= 1280 ? BaseBlurEffect.ROTATION_180 : 60;
        int a2 = us.pinguo.foundation.t.b.a.a(this, i2 != 180 ? 275 - (BaseBlurEffect.ROTATION_180 - i2) : 275) - (j2 / 2);
        if (a2 < 0) {
            a2 = 0;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mAlbumGiftBgGifview.getLayoutParams();
        layoutParams.setMargins(0, a2, 0, 0);
        layoutParams.height = j2;
        try {
            String downFilePath = AdvConfigManager.getInstance().getDownFilePath("http://dispatcher.c360dn.com/album_gif_type_1.gif");
            String downFilePath2 = AdvConfigManager.getInstance().getDownFilePath("http://dispatcher.c360dn.com/album_gif_type_2.gif");
            String downFilePath3 = AdvConfigManager.getInstance().getDownFilePath("http://dispatcher.c360dn.com/album_gif_type_3.gif");
            c cVar = new c(downFilePath);
            c cVar2 = new c(downFilePath2);
            c cVar3 = new c(downFilePath3);
            cVar.a(new a(cVar2));
            cVar2.j(65535);
            this.mAlbumGiftBgGifview.setImageDrawable(cVar);
            cVar2.a(new b(cVar2, cVar3));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        com.pinguo.camera360.adv.e.a aVar = new com.pinguo.camera360.adv.e.a(this, this.a, this.mAdvLayout);
        aVar.f(this);
        aVar.g(this);
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_album_fullscreen_adv);
        if (!us.pinguo.admobvista.c.a.a()) {
            finish();
            return;
        }
        this.a = getIntent().getStringExtra("unit_Id");
        ButterKnife.bind(this);
        b();
        c();
    }

    @Override // us.pinguo.admobvista.d.a.InterfaceC0352a
    public void onShow() {
        this.b = true;
    }
}

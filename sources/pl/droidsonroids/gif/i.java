package pl.droidsonroids.gif;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.RequiresApi;
import pl.droidsonroids.gif.GifTextureView;
/* compiled from: PlaceholderDrawingSurfaceTextureListener.java */
@RequiresApi(14)
/* loaded from: classes3.dex */
class i implements TextureView.SurfaceTextureListener {
    private final GifTextureView.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GifTextureView.b bVar) {
        this.a = bVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Surface surface = new Surface(surfaceTexture);
        Canvas lockCanvas = surface.lockCanvas(null);
        this.a.a(lockCanvas);
        surface.unlockCanvasAndPost(lockCanvas);
        surface.release();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}

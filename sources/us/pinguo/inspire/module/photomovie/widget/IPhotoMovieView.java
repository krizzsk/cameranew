package us.pinguo.inspire.module.photomovie.widget;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hw.photomovie.render.GLTextureView;
import us.pinguo.foundation.VideoMusic;
/* compiled from: IPhotoMovieView.kt */
/* loaded from: classes9.dex */
public interface IPhotoMovieView extends us.pinguo.foundation.p.b {
    FragmentActivity getActivity();

    Fragment getFragment();

    GLTextureView getGLTextureView();

    void hideMusicLayout();

    void onMusicChanged(VideoMusic videoMusic);
}

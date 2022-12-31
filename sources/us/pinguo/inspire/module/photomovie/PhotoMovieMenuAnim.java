package us.pinguo.inspire.module.photomovie;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.hw.photomovie.PhotoMovieFactory$PhotoMovieType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomView;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieMusicCell;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieMusicLayout;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieTransferLayout;
import us.pinguo.ui.widget.j;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoMovieMenuAnim.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieMenuAnim {
    public static final Companion Companion = new Companion(null);
    private static final long MENU_ANIM_DURATION = 400;
    private PhotoMovieBottomView bottomLayout;
    private final PhotoMovieFragment fragment;
    private PhotoMovieMusicLayout musicLayout;
    private PhotoMovieTransferLayout tranferLayout;

    /* compiled from: PhotoMovieMenuAnim.kt */
    /* loaded from: classes9.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }

        public final long getMENU_ANIM_DURATION() {
            return PhotoMovieMenuAnim.MENU_ANIM_DURATION;
        }
    }

    public PhotoMovieMenuAnim(PhotoMovieFragment fragment) {
        s.h(fragment, "fragment");
        this.fragment = fragment;
        this.bottomLayout = fragment.getMBottomLayout();
    }

    private final boolean checkClickArea(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return motionEvent.getRawY() > ((float) iArr[1]);
    }

    private final void hideMenu(final View view) {
        this.bottomLayout.setVisibility(0);
        view.animate().setDuration(MENU_ANIM_DURATION).alpha(0.0f).translationY(view.getHeight()).setListener(new j() { // from class: us.pinguo.inspire.module.photomovie.PhotoMovieMenuAnim$hideMenu$1
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        }).start();
    }

    private final void showMenu(View view, float f2) {
        this.bottomLayout.setVisibility(8);
        view.setAlpha(0.0f);
        view.setTranslationY(f2);
        view.setVisibility(0);
        view.animate().setDuration(MENU_ANIM_DURATION).alpha(1.0f).translationY(0.0f).setListener(null).start();
    }

    public final boolean dispatchTouchEvent(MotionEvent ev) {
        s.h(ev, "ev");
        if (ev.getAction() != 0) {
            return false;
        }
        PhotoMovieTransferLayout photoMovieTransferLayout = this.tranferLayout;
        if (photoMovieTransferLayout != null && photoMovieTransferLayout.getVisibility() == 0) {
            PhotoMovieTransferLayout photoMovieTransferLayout2 = this.tranferLayout;
            s.e(photoMovieTransferLayout2);
            if (!checkClickArea(photoMovieTransferLayout2, ev)) {
                PhotoMovieTransferLayout photoMovieTransferLayout3 = this.tranferLayout;
                s.e(photoMovieTransferLayout3);
                hideMenu(photoMovieTransferLayout3);
                return true;
            }
        }
        PhotoMovieMusicLayout photoMovieMusicLayout = this.musicLayout;
        if (photoMovieMusicLayout != null && photoMovieMusicLayout.getVisibility() == 0) {
            PhotoMovieMusicLayout photoMovieMusicLayout2 = this.musicLayout;
            s.e(photoMovieMusicLayout2);
            if (!checkClickArea(photoMovieMusicLayout2, ev)) {
                PhotoMovieMusicLayout photoMovieMusicLayout3 = this.musicLayout;
                s.e(photoMovieMusicLayout3);
                hideMenu(photoMovieMusicLayout3);
                return true;
            }
        }
        return false;
    }

    public final PhotoMovieFragment getFragment() {
        return this.fragment;
    }

    public final PhotoMovieMusicLayout getMusicLayout() {
        return this.musicLayout;
    }

    public final void hideMusicLayout() {
        PhotoMovieMusicLayout photoMovieMusicLayout = this.musicLayout;
        s.e(photoMovieMusicLayout);
        hideMenu(photoMovieMusicLayout);
    }

    public final void setMusicLayout(PhotoMovieMusicLayout photoMovieMusicLayout) {
        this.musicLayout = photoMovieMusicLayout;
    }

    public final void showFilterMenu() {
    }

    public final void showMusicMenu() {
        Resources resources;
        if (this.musicLayout == null) {
            View view = this.fragment.getView();
            ViewStub viewStub = view == null ? null : (ViewStub) view.findViewById(R.id.photo_movie_music_stub);
            PhotoMovieMusicLayout photoMovieMusicLayout = (PhotoMovieMusicLayout) (viewStub != null ? viewStub.inflate() : null);
            this.musicLayout = photoMovieMusicLayout;
            if (photoMovieMusicLayout != null) {
                photoMovieMusicLayout.setVisibility(8);
            }
            List<VideoMusic> localMusicList = this.fragment.getMPresenter().getLocalMusicList();
            ArrayList arrayList = new ArrayList(localMusicList.size());
            for (VideoMusic music : localMusicList) {
                s.g(music, "music");
                arrayList.add(new PhotoMovieMusicCell(music));
            }
            PhotoMovieMusicLayout photoMovieMusicLayout2 = this.musicLayout;
            if (photoMovieMusicLayout2 != null) {
                photoMovieMusicLayout2.setLocalMusicCell(arrayList);
            }
            PhotoMovieMusicLayout photoMovieMusicLayout3 = this.musicLayout;
            if (photoMovieMusicLayout3 != null) {
                photoMovieMusicLayout3.select(this.fragment.getMPresenter().getPlayingMusicName());
            }
        }
        PhotoMovieMusicLayout photoMovieMusicLayout4 = this.musicLayout;
        if (photoMovieMusicLayout4 != null) {
            photoMovieMusicLayout4.setCallback(this.fragment.getMPresenter());
        }
        PhotoMovieMusicLayout photoMovieMusicLayout5 = this.musicLayout;
        if (photoMovieMusicLayout5 != null) {
            photoMovieMusicLayout5.setPlayingMusic(this.fragment.getMPresenter().getPlayingMusicName());
        }
        PhotoMovieMusicLayout photoMovieMusicLayout6 = this.musicLayout;
        s.e(photoMovieMusicLayout6);
        PhotoMovieMusicLayout photoMovieMusicLayout7 = this.musicLayout;
        float f2 = 0.0f;
        if (photoMovieMusicLayout7 != null && (resources = photoMovieMusicLayout7.getResources()) != null) {
            f2 = resources.getDimensionPixelSize(R.dimen.photo_movie_music_height);
        }
        showMenu(photoMovieMusicLayout6, f2);
    }

    public final void showTransferMenu() {
        Resources resources;
        if (this.tranferLayout == null) {
            View view = this.fragment.getView();
            ViewStub viewStub = view == null ? null : (ViewStub) view.findViewById(R.id.photo_movie_transfer_stub);
            PhotoMovieTransferLayout photoMovieTransferLayout = (PhotoMovieTransferLayout) (viewStub != null ? viewStub.inflate() : null);
            this.tranferLayout = photoMovieTransferLayout;
            if (photoMovieTransferLayout != null) {
                photoMovieTransferLayout.setVisibility(8);
            }
        }
        PhotoMovieTransferLayout photoMovieTransferLayout2 = this.tranferLayout;
        if (photoMovieTransferLayout2 != null) {
            photoMovieTransferLayout2.setCallback(this.fragment.getMPresenter());
        }
        PhotoMovieTransferLayout photoMovieTransferLayout3 = this.tranferLayout;
        if (photoMovieTransferLayout3 != null) {
            PhotoMovieFactory$PhotoMovieType photoMovieFactory$PhotoMovieType = this.fragment.getMPresenter().mCurType;
            s.g(photoMovieFactory$PhotoMovieType, "fragment.mPresenter.mCurType");
            photoMovieTransferLayout3.selectTransfer(photoMovieFactory$PhotoMovieType);
        }
        PhotoMovieTransferLayout photoMovieTransferLayout4 = this.tranferLayout;
        s.e(photoMovieTransferLayout4);
        PhotoMovieTransferLayout photoMovieTransferLayout5 = this.tranferLayout;
        float f2 = 0.0f;
        if (photoMovieTransferLayout5 != null && (resources = photoMovieTransferLayout5.getResources()) != null) {
            f2 = resources.getDimensionPixelSize(R.dimen.photo_movie_transfer_height);
        }
        showMenu(photoMovieTransferLayout4, f2);
    }
}

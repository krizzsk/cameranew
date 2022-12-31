package us.pinguo.inspire.module.photomovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hw.photomovie.render.GLTextureView;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.VideoMusic;
import us.pinguo.foundation.base.InspireRedirectActivity;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.foundation.statistics.h;
import us.pinguo.inspire.R;
import us.pinguo.inspire.module.photomovie.widget.IPhotoMovieView;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomCallback;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomView;
import us.pinguo.inspire.module.photomovie.widget.PhotoMovieMusicLayout;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: PhotoMovieFragment.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieFragment extends SubscriptionFragment implements IPhotoMovieView, PhotoMovieBottomCallback {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public PhotoMovieBottomView mBottomLayout;
    public PhotoMovieMenuAnim mMenuAnim;
    public PhotoMoviePresenter mPresenter;

    private final void requestPhotos() {
        Intent intent = new Intent();
        intent.setClassName(requireActivity(), "com.pinguo.camera360.gallery.photopick.PhotoPickActivity");
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_COUNT_LIMIT, 20);
        intent.putExtra(InspirePublishFragment.KEY_PHOTO_PICK_MODE_VALUE, 4);
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type us.pinguo.foundation.base.InspireRedirectActivity");
        ((InspireRedirectActivity) activity).startActivityForResult(intent, new us.pinguo.foundation.proxy.c() { // from class: us.pinguo.inspire.module.photomovie.a
            @Override // us.pinguo.foundation.proxy.c
            public final void onActivityResult(int i2, Intent intent2) {
                PhotoMovieFragment.m185requestPhotos$lambda0(PhotoMovieFragment.this, i2, intent2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestPhotos$lambda-0  reason: not valid java name */
    public static final void m185requestPhotos$lambda0(PhotoMovieFragment this$0, int i2, Intent intent) {
        s.h(this$0, "this$0");
        if (i2 == -1) {
            if (intent.hasExtra("photo_path")) {
                this$0.getMPresenter().onVideoSelected(intent.getStringExtra("photo_path"));
                return;
            }
            this$0.getMPresenter().onPhotoSelected(intent.getStringArrayListExtra("photo_path_list"));
            return;
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
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

    public final boolean dispatchTouchEvent(MotionEvent ev) {
        s.h(ev, "ev");
        return getMMenuAnim().dispatchTouchEvent(ev);
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.IPhotoMovieView
    public Fragment getFragment() {
        return this;
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.IPhotoMovieView
    public GLTextureView getGLTextureView() {
        GLTextureView photo_movie_gl = (GLTextureView) _$_findCachedViewById(R.id.photo_movie_gl);
        s.g(photo_movie_gl, "photo_movie_gl");
        return photo_movie_gl;
    }

    public final PhotoMovieBottomView getMBottomLayout() {
        PhotoMovieBottomView photoMovieBottomView = this.mBottomLayout;
        if (photoMovieBottomView != null) {
            return photoMovieBottomView;
        }
        s.z("mBottomLayout");
        throw null;
    }

    public final PhotoMovieMenuAnim getMMenuAnim() {
        PhotoMovieMenuAnim photoMovieMenuAnim = this.mMenuAnim;
        if (photoMovieMenuAnim != null) {
            return photoMovieMenuAnim;
        }
        s.z("mMenuAnim");
        throw null;
    }

    public final PhotoMoviePresenter getMPresenter() {
        PhotoMoviePresenter photoMoviePresenter = this.mPresenter;
        if (photoMoviePresenter != null) {
            return photoMoviePresenter;
        }
        s.z("mPresenter");
        throw null;
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.IPhotoMovieView
    public void hideMusicLayout() {
        getMMenuAnim().hideMusicLayout();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        getMPresenter().onActivityResult(i2, i3, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        s.h(inflater, "inflater");
        return inflater.inflate(vStudio.Android.Camera360.R.layout.fragment_photo_movie, viewGroup, false);
    }

    @Override // us.pinguo.foundation.base.SubscriptionFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getMPresenter().detachView();
        _$_clearFindViewByIdCache();
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomCallback
    public void onFilterClick() {
        getMMenuAnim().showFilterMenu();
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.IPhotoMovieView
    public void onMusicChanged(VideoMusic videoMusic) {
        PhotoMovieMusicLayout musicLayout;
        PhotoMovieMenuAnim mMenuAnim = getMMenuAnim();
        if (mMenuAnim == null || (musicLayout = mMenuAnim.getMusicLayout()) == null) {
            return;
        }
        musicLayout.select(videoMusic == null ? null : videoMusic.h());
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomCallback
    public void onMusicClick() {
        getMMenuAnim().showMusicMenu();
        us.pinguo.foundation.statistics.c cVar = h.a;
        String playingMusicName = getMPresenter().getPlayingMusicName();
        if (playingMusicName == null) {
            playingMusicName = "";
        }
        cVar.m0("pic_video_edit", "bgm_btn", "", playingMusicName, "click", getMPresenter().getTransitionTypeNameForStat(), getMPresenter().getWorkId());
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomCallback
    public void onNextClick() {
        getMPresenter().saveVideo();
        us.pinguo.foundation.statistics.c cVar = h.a;
        String playingMusicName = getMPresenter().getPlayingMusicName();
        if (playingMusicName == null) {
            playingMusicName = "";
        }
        cVar.S("pic_video_edit", "next", "", playingMusicName, "click", getMPresenter().getPhotoCount(), getMPresenter().getTransitionTypeNameForStat(), getMPresenter().getWorkId());
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getMPresenter().onPause();
        ((GLTextureView) _$_findCachedViewById(R.id.photo_movie_gl)).l();
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getMPresenter().onResume();
        ((GLTextureView) _$_findCachedViewById(R.id.photo_movie_gl)).m();
    }

    @Override // us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomCallback
    public void onTransferClick() {
        getMMenuAnim().showTransferMenu();
        us.pinguo.foundation.statistics.c cVar = h.a;
        String playingMusicName = getMPresenter().getPlayingMusicName();
        if (playingMusicName == null) {
            playingMusicName = "";
        }
        cVar.m0("pic_video_edit", "transition", "", playingMusicName, "click", getMPresenter().getTransitionTypeNameForStat(), getMPresenter().getWorkId());
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        s.h(view, "view");
        super.onViewCreated(view, bundle);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.photo_movie_bottom);
        Objects.requireNonNull(_$_findCachedViewById, "null cannot be cast to non-null type us.pinguo.inspire.module.photomovie.widget.PhotoMovieBottomView");
        setMBottomLayout((PhotoMovieBottomView) _$_findCachedViewById);
        getMBottomLayout().setCallback(this);
        setMMenuAnim(new PhotoMovieMenuAnim(this));
        setMPresenter(new PhotoMoviePresenter());
        getMPresenter().attachView(this);
        requestPhotos();
    }

    public final void setMBottomLayout(PhotoMovieBottomView photoMovieBottomView) {
        s.h(photoMovieBottomView, "<set-?>");
        this.mBottomLayout = photoMovieBottomView;
    }

    public final void setMMenuAnim(PhotoMovieMenuAnim photoMovieMenuAnim) {
        s.h(photoMovieMenuAnim, "<set-?>");
        this.mMenuAnim = photoMovieMenuAnim;
    }

    public final void setMPresenter(PhotoMoviePresenter photoMoviePresenter) {
        s.h(photoMoviePresenter, "<set-?>");
        this.mPresenter = photoMoviePresenter;
    }
}

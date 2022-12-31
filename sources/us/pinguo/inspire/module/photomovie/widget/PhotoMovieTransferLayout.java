package us.pinguo.inspire.module.photomovie.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.hw.photomovie.PhotoMovieFactory$PhotoMovieType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import us.pinguo.inspire.R;
/* compiled from: PhotoMovieTransferLayout.kt */
/* loaded from: classes9.dex */
public final class PhotoMovieTransferLayout extends RelativeLayout implements View.OnClickListener {
    public Map<Integer, View> _$_findViewCache;
    private PhotoMovieTransferCallback callback;

    /* compiled from: PhotoMovieTransferLayout.kt */
    /* loaded from: classes9.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PhotoMovieFactory$PhotoMovieType.values().length];
            iArr[PhotoMovieFactory$PhotoMovieType.HORIZONTAL_TRANS.ordinal()] = 1;
            iArr[PhotoMovieFactory$PhotoMovieType.VERTICAL_TRANS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieTransferLayout(Context context) {
        super(context);
        s.h(context, "context");
        this._$_findViewCache = new LinkedHashMap();
    }

    private final void setTextAutoSize() {
        ((AppCompatTextView) _$_findCachedViewById(R.id.photo_movie_transfer_horizon_txt)).setAutoSizeTextTypeUniformWithConfiguration(6, 11, 1, 2);
        ((AppCompatTextView) _$_findCachedViewById(R.id.photo_movie_transfer_vertical_txt)).setAutoSizeTextTypeUniformWithConfiguration(6, 11, 1, 2);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
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

    public final PhotoMovieTransferCallback getCallback() {
        return this.callback;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        if (valueOf != null && valueOf.intValue() == vStudio.Android.Camera360.R.id.photo_movie_transfer_horizon) {
            PhotoMovieTransferCallback photoMovieTransferCallback = this.callback;
            if (photoMovieTransferCallback != null) {
                photoMovieTransferCallback.onTransferSelect(PhotoMovieFactory$PhotoMovieType.HORIZONTAL_TRANS);
            }
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_horizon)).setSelected(true);
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_vertical)).setSelected(false);
        } else if (valueOf != null && valueOf.intValue() == vStudio.Android.Camera360.R.id.photo_movie_transfer_vertical) {
            PhotoMovieTransferCallback photoMovieTransferCallback2 = this.callback;
            if (photoMovieTransferCallback2 != null) {
                photoMovieTransferCallback2.onTransferSelect(PhotoMovieFactory$PhotoMovieType.VERTICAL_TRANS);
            }
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_horizon)).setSelected(false);
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_vertical)).setSelected(true);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_horizon)).setOnClickListener(this);
        ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_vertical)).setOnClickListener(this);
        setTextAutoSize();
    }

    public final void selectTransfer(PhotoMovieFactory$PhotoMovieType type) {
        s.h(type, "type");
        int i2 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i2 == 1) {
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_horizon)).setSelected(true);
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_vertical)).setSelected(false);
        } else if (i2 != 2) {
        } else {
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_horizon)).setSelected(false);
            ((FrameLayout) _$_findCachedViewById(R.id.photo_movie_transfer_vertical)).setSelected(true);
        }
    }

    public final void setCallback(PhotoMovieTransferCallback photoMovieTransferCallback) {
        this.callback = photoMovieTransferCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieTransferLayout(Context context, AttributeSet attr) {
        super(context, attr);
        s.h(context, "context");
        s.h(attr, "attr");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoMovieTransferLayout(Context context, AttributeSet attr, int i2) {
        super(context, attr, i2);
        s.h(context, "context");
        s.h(attr, "attr");
        this._$_findViewCache = new LinkedHashMap();
    }
}

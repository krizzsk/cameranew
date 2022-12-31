package us.pinguo.camera2020.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.InputQueue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.s;
/* compiled from: PgWindow.kt */
/* loaded from: classes3.dex */
public final class PgWindow extends Window {
    private View a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PgWindow(Context context) {
        super(context);
        s.h(context, "context");
    }

    @Override // android.view.Window
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void closeAllPanels() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void closePanel(int i2) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public View getCurrentFocus() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public View getDecorView() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public LayoutInflater getLayoutInflater() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public int getNavigationBarColor() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public int getStatusBarColor() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public int getVolumeControlStream() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void invalidatePanelMenu(int i2) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean isFloating() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    protected void onActive() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.view.Window
    public void openPanel(int i2, KeyEvent keyEvent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public View peekDecorView() {
        View view = this.a;
        if (view != null) {
            return view;
        }
        throw new Exception("no decor view attached");
    }

    @Override // android.view.Window
    public boolean performContextMenuIdentifierAction(int i2, int i3) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean performPanelIdentifierAction(int i2, int i3, int i4) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean performPanelShortcut(int i2, int i3, KeyEvent keyEvent, int i4) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void restoreHierarchyState(Bundle bundle) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public Bundle saveHierarchyState() {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setBackgroundDrawable(Drawable drawable) {
        View view = this.a;
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    @Override // android.view.Window
    public void setChildDrawable(int i2, Drawable drawable) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setChildInt(int i2, int i3) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setContentView(int i2) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setDecorCaptionShade(int i2) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setFeatureDrawable(int i2, Drawable drawable) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setFeatureDrawableAlpha(int i2, int i3) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setFeatureDrawableResource(int i2, int i3) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setFeatureDrawableUri(int i2, Uri uri) {
    }

    @Override // android.view.Window
    public void setFeatureInt(int i2, int i3) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setNavigationBarColor(int i2) {
    }

    @Override // android.view.Window
    public void setResizingCaptionDrawable(Drawable drawable) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setStatusBarColor(int i2) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setTitle(CharSequence charSequence) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setTitleColor(int i2) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setVolumeControlStream(int i2) {
    }

    @Override // android.view.Window
    public boolean superDispatchGenericMotionEvent(MotionEvent motionEvent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean superDispatchKeyShortcutEvent(KeyEvent keyEvent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean superDispatchTouchEvent(MotionEvent motionEvent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public boolean superDispatchTrackballEvent(MotionEvent motionEvent) {
        View view = this.a;
        if (view == null) {
            return false;
        }
        return view.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window
    public void takeInputQueue(InputQueue.Callback callback) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void takeKeyEvents(boolean z) {
        View view = this.a;
        if (view == null) {
            return;
        }
        view.setFocusable(z);
    }

    @Override // android.view.Window
    public void takeSurface(SurfaceHolder.Callback2 callback2) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void togglePanel(int i2, KeyEvent keyEvent) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setContentView(View view) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }

    @Override // android.view.Window
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new NotImplementedError("An operation is not implemented: not implemented");
    }
}

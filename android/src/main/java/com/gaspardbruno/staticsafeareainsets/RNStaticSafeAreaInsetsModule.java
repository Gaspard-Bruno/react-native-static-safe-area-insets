package com.gaspardbruno.staticsafeareainsets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.uimanager.PixelUtil;

import java.util.Map;
import java.util.HashMap;

import android.content.Context;
import android.content.res.Resources;
import android.view.Surface;
import android.view.WindowInsets;
import android.view.View;
import android.os.Build;
import android.app.Activity;
import android.view.WindowManager;

public class RNStaticSafeAreaInsetsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext mReactContext;
  private final WindowManager mWindowManager;

  public RNStaticSafeAreaInsetsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    mReactContext = reactContext;
    mWindowManager = (WindowManager) reactContext.getSystemService(Context.WINDOW_SERVICE);
  }

  @Override
  public String getName() {
    return "RNStaticSafeAreaInsets";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    // Window insets are parts of the window that are covered by system views (status bar,
    // navigation bar, notches). There are no apis the get these values for android < M so we
    // do a best effort polyfill.
    EdgeInsets windowInsets = new EdgeInsets(0, 0, 0, 0);
    final Activity activity = getCurrentActivity();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      final View view = activity.getWindow().getDecorView();
      final WindowInsets insets = view.getRootWindowInsets();
      windowInsets = new EdgeInsets(
          insets.getSystemWindowInsetTop(),
          insets.getSystemWindowInsetRight(),
          insets.getSystemWindowInsetBottom(),
          insets.getSystemWindowInsetLeft());
    }
    final Resources resources = mReactContext.getResources();
    final int rotation = mWindowManager.getDefaultDisplay().getRotation();
    float statusBarHeight = 0;
    int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      statusBarHeight = PixelUtil.toDIPFromPixel(resources.getDimensionPixelSize(resourceId));
    }
    float navbarHeight = 0;
    resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
    if (resourceId > 0) {
      navbarHeight = PixelUtil.toDIPFromPixel(resources.getDimensionPixelSize(resourceId));
    }
    // Fix for views drawing under the navbar & statusbar
    windowInsets = new EdgeInsets(
        windowInsets.top != 0 ? windowInsets.top : statusBarHeight,
        windowInsets.right != 0 ? windowInsets.right : rotation == Surface.ROTATION_90 ? navbarHeight : 0,
        windowInsets.bottom != 0 ? windowInsets.bottom : rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180 ? navbarHeight : 0,
        windowInsets.left != 0 ? windowInsets.left : rotation == Surface.ROTATION_270 ? navbarHeight : 0);


    // Calculate the part of the root view that overlaps with window insets.
    if (activity != null) {
      final View rootView = activity.getWindow().getDecorView().getRootView();
      final View contentView = rootView.findViewById(android.R.id.content);
      final float windowWidth = rootView.getWidth();
      final float windowHeight = rootView.getHeight();
      final int[] windowLocation = new int[2];
      contentView.getLocationInWindow(windowLocation);
      windowInsets.top = Math.max(windowInsets.top - windowLocation[1], 0);
      windowInsets.left = Math.max(windowInsets.left - windowLocation[0], 0);
      windowInsets.bottom = Math.max(windowLocation[1] + contentView.getHeight() + windowInsets.bottom - windowHeight, 0);
      windowInsets.right = Math.max(windowLocation[0] + contentView.getWidth() + windowInsets.right - windowWidth, 0);
    }

    constants.put("safeAreaInsetsTop", windowInsets.top);
    constants.put("safeAreaInsetsBottom", windowInsets.bottom);
    constants.put("safeAreaInsetsLeft", windowInsets.left);
    constants.put("safeAreaInsetsRight", windowInsets.right);

    return constants;
  }
}

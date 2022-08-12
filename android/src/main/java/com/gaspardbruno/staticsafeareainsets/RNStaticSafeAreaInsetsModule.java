package com.gaspardbruno.staticsafeareainsets;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

import java.util.Map;
import java.util.HashMap;

import android.view.WindowInsets;
import android.view.View;
import android.view.WindowInsetsController;
import android.os.Build;
import android.app.Activity;
import android.graphics.Insets;

public class RNStaticSafeAreaInsetsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNStaticSafeAreaInsetsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNStaticSafeAreaInsets";
  }

  @Override
  public Map<String, Object> getConstants() {
    return this._getSafeAreaInsets();
  }

  private Map<String, Object> _getSafeAreaInsets() {
    final Map<String, Object> constants = new HashMap<>();

    if (getCurrentActivity() != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      final Activity activity = getCurrentActivity();
      final View view = activity.getWindow().getDecorView();
      final WindowInsets insets = view.getRootWindowInsets();

      final Boolean isFullscreen = (view.getSystemUiVisibility() & View.SYSTEM_UI_FLAG_IMMERSIVE) == View.SYSTEM_UI_FLAG_IMMERSIVE;

      if (insets != null && isFullscreen) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
          final Insets insets30 = insets.getInsets(WindowInsets.Type.systemGestures());

          constants.put("safeAreaInsetsTop", (float) insets30.top);
          constants.put("safeAreaInsetsBottom", (float) insets30.bottom);
          constants.put("safeAreaInsetsLeft", (float) insets30.left);
          constants.put("safeAreaInsetsRight", (float) insets30.right);
        } else {
          constants.put("safeAreaInsetsTop", PixelUtil.toDIPFromPixel(insets.getSystemWindowInsetTop()));
          constants.put("safeAreaInsetsBottom", PixelUtil.toDIPFromPixel(insets.getSystemWindowInsetBottom()));
          constants.put("safeAreaInsetsLeft", PixelUtil.toDIPFromPixel(insets.getSystemWindowInsetLeft()));
          constants.put("safeAreaInsetsRight", PixelUtil.toDIPFromPixel(insets.getSystemWindowInsetRight()));
        }
      } else {
        constants.put("safeAreaInsetsTop", 0f);
        constants.put("safeAreaInsetsBottom", 0f);
        constants.put("safeAreaInsetsLeft", 0f);
        constants.put("safeAreaInsetsRight", 0f);
      }
    } else {
      constants.put("safeAreaInsetsTop", 0f);
      constants.put("safeAreaInsetsBottom", 0f);
      constants.put("safeAreaInsetsLeft", 0f);
      constants.put("safeAreaInsetsRight", 0f);
    }

    return constants;
  }

  @ReactMethod
  public void getSafeAreaInsets(Callback cb) {
    Map<String, Object> constants = this._getSafeAreaInsets();
    WritableMap map = new WritableNativeMap();

    map.putInt("safeAreaInsetsTop", ((Float) constants.get("safeAreaInsetsTop")).intValue());
    map.putInt("safeAreaInsetsBottom", ((Float) constants.get("safeAreaInsetsBottom")).intValue());
    map.putInt("safeAreaInsetsLeft", ((Float) constants.get("safeAreaInsetsLeft")).intValue());
    map.putInt("safeAreaInsetsRight", ((Float) constants.get("safeAreaInsetsRight")).intValue());

    cb.invoke(map);
  }
}

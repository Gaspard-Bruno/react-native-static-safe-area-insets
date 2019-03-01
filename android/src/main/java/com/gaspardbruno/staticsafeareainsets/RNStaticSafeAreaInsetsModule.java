package com.gaspardbruno.staticsafeareainsets;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

import java.util.Map;
import java.util.HashMap;

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
    final Map<String, Object> constants = new HashMap<>();
    constants.put("safeAreaInsetsTop", 0);
    constants.put("safeAreaInsetsBottom", 0);
    constants.put("safeAreaInsetsLeft", 0);
    constants.put("safeAreaInsetsRight", 0);
    return constants;
  }
}

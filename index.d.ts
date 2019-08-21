declare module "react-native-static-safe-area-insets" {
  class StaticSafeAreaInsets {
    public static safeAreaInsetsTop: number;
    public static safeAreaInsetsBottom: number;
    public static safeAreaInsetsLeft: number;
    public static safeAreaInsetsRight: number;
    getSafeAreaInsets() : {
      top: number;
      bottom: number;
      left: number;
      right: number;
    };
  }

  export default StaticSafeAreaInsets;
}

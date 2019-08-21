declare module 'react-native-static-safe-area-insets' {
  class StaticSafeAreaInsets {
    public static safeAreaInsetsTop: number;
    public static safeAreaInsetsBottom: number;
    public static safeAreaInsetsLeft: number;
    public static safeAreaInsetsRight: number;
    public static getSafeAreaInsetsTop(callback:(value:number) => void): void;
    public static getSafeAreaInsetsBottom(callback:(value:number) => void): void;
    public static getSafeAreaInsetsLeft(callback:(value:number) => void): void;
    public static getSafeAreaInsetsRight(callback:(value:number) => void): void;
  }

  export default StaticSafeAreaInsets;
}

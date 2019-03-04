# React Native Static Safe Area Insets

React Native package that exposes the Safe Area insets as constants (iOS and Android notch are supported).

## Getting started

`$ yarn add react-native-static-safe-area-insets`

### Automatic installation

`$ react-native link react-native-static-safe-area-insets`

#### If pods are being used in iOS

`$ cd ios && pod install && cd ..`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-static-safe-area-insets` and add `RNStaticSafeAreaInsets.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNStaticSafeAreaInsets.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.gaspardbruno.staticsafeareainsets.RNStaticSafeAreaInsetsPackage;` to the imports at the top of the file
  - Add `new RNStaticSafeAreaInsetsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-static-safe-area-insets'
  	project(':react-native-static-safe-area-insets').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-static-safe-area-insets/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-static-safe-area-insets')
  	```


## Usage
```javascript
import StaticSafeAreaInsets from 'react-native-static-safe-area-insets';

console.log('SafeArea insets top:', StaticSafeAreaInsets.safeAreaInsetsTop)
// SafeArea insets top: 44

console.log('SafeArea insets bottom:', StaticSafeAreaInsets.safeAreaInsetsBottom)
// SafeArea insets bottom: 34

console.log('SafeArea insets left:', StaticSafeAreaInsets.safeAreaInsetsLeft)
// SafeArea insets left: 44

console.log('SafeArea insets right:', StaticSafeAreaInsets.safeAreaInsetsRight)
// SafeArea insets right: 44
```

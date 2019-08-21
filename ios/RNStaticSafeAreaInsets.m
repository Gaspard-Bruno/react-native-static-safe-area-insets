#import "RNStaticSafeAreaInsets.h"
#import <UIKit/UIKit.h>

@implementation RNStaticSafeAreaInsets

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

+ (BOOL)requiresMainQueueSetup
{
  return YES;
}

- (NSDictionary *)constantsToExport
{
    if (@available(iOS 11.0, *)) {
        return @{
                 @"safeAreaInsetsTop": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.top),
                 @"safeAreaInsetsBottom": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.bottom),
                 @"safeAreaInsetsLeft": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.left),
                 @"safeAreaInsetsRight": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.right),
                 @"getSafeAreaInsetsTop": @(self.getSafeAreaInsetsTop),
                 @"getSafeAreaInsetsBottom": @(self.getSafeAreaInsetsBottom),
                 @"getSafeAreaInsetsLeft": @(self.getSafeAreaInsetsLeft),
                 @"getSafeAreaInsetsRight": @(self.getSafeAreaInsetsRight)
                 };
    } else {
        return @{
                 @"safeAreaInsetsTop": @(0),
                 @"safeAreaInsetsBottom": @(0),
                 @"safeAreaInsetsLeft": @(0),
                 @"safeAreaInsetsRight": @(0),
                 @"getSafeAreaInsetsTop": @(self.getSafeAreaInsetsTop),
                 @"getSafeAreaInsetsBottom": @(self.getSafeAreaInsetsBottom),
                 @"getSafeAreaInsetsLeft": @(self.getSafeAreaInsetsLeft),
                 @"getSafeAreaInsetsRight": @(self.getSafeAreaInsetsRight)
                 };
    }
}

- (float) getSafeAreaInsetsTop
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.top);
    } else {
        return @(0);
    }
}

- (float) getSafeAreaInsetsBottom
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.bottom);
    } else {
        return @(0);
    }
}

- (float) getSafeAreaInsetsLeft
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.left);
    } else {
        return @(0);
    }
}

- (float) getSafeAreaInsetsRight
{
    if (@available(iOS 11.0, *)) {
        return @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.right);
    } else {
        return @(0);
    }
}

@end

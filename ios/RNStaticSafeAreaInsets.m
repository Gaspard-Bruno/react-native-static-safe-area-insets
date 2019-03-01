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
                 @"safeAreaInsetsBottom": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.bottom)
                 };
    } else {
        return @{
                 @"safeAreaInsetsTop": @(0),
                 @"safeAreaInsetsBottom": @(0),
                 };
    }
}

@end

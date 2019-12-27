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
    return self.getSafeAreaInsets;
}

- (NSDictionary *) getSafeAreaInsets
{
    if (@available(iOS 11.0, *)) {
        return @{
            @"safeAreaInsetsTop": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.top),
            @"safeAreaInsetsBottom": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.bottom),
            @"safeAreaInsetsLeft": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.left),
            @"safeAreaInsetsRight": @(UIApplication.sharedApplication.keyWindow.safeAreaInsets.right)
        };
    } else {
        return @{
            @"safeAreaInsetsTop": @(0),
            @"safeAreaInsetsBottom": @(0),
            @"safeAreaInsetsLeft": @(0),
            @"safeAreaInsetsRight": @(0),
        };
    }
}

RCT_EXPORT_METHOD(getSafeAreaInsets:(RCTResponseSenderBlock)callback){
    callback(@[self.getSafeAreaInsets]);
}

@end

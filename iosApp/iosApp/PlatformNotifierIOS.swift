import UIKit
import UserNotifications
import shared

public class PlatformNotifierIOS: PlatformNotifier {

    public func register(
        completionHandler: @escaping (String?, Error?) -> Void
    ) {
        UNUserNotificationCenter.current()
            .requestAuthorization(options: [.alert, .sound]) { granted, error in
                guard granted else { return }
                DispatchQueue.main.async {
                    UIApplication.shared.registerForRemoteNotifications()
                }
                completionHandler(nil, error)
            }
    }

    public func unregister() {
        UNUserNotificationCenter.current()
            .removeAllDeliveredNotifications()
    }

    public func getToken() -> String {
        return ""
    }
}
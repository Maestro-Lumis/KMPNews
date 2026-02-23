import SwiftUI
import shared

class NewsListVm: ObservableObject {
    @Published var news: [NewsItem] = []

    private lazy var vm: NewsViewModel? = {
        let vm = NewsViewModel()
        return vm
    }()

    func getNews() {
        // Загрузка данных через общую ViewModel
    }
}
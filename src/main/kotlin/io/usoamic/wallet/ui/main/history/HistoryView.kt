package io.usoamic.wallet.ui.main.history

import io.usoamic.wallet.UsoamicWallet
import io.usoamic.wallet.commonslib.models.history.TransactionItem
import io.usoamic.wallet.extensions.fx.progressWhen
import io.usoamic.wallet.extensions.observe
import io.usoamic.wallet.ui.base.BaseVmView
import io.usoamic.wallet.util.BuildConfig
import io.usoamic.wallet.values.R
import javafx.geometry.Pos
import javafx.scene.control.TableView
import javafx.scene.layout.StackPane
import tornadofx.*
import java.time.format.DateTimeFormatter

class HistoryView : BaseVmView<HistoryViewModel>(R.string.TITLE_HISTORY_SCREEN) {
    private val formatter = DateTimeFormatter.ofPattern(BuildConfig.DATE_FORMAT)
    private var historyItems = observableListOf<TransactionsInfo>()

    override val root: StackPane = stackpane {
        progressWhen {
            viewModel.ldProgress
        }
        vbox {
            hiddenWhen { viewModel.ldProgress }

            tableview<TransactionsInfo> {
                items = historyItems

                alignment = Pos.CENTER
                readonlyColumn(R.string.ID, TransactionsInfo::id)
                readonlyColumn(R.string.TYPE, TransactionsInfo::type)
                readonlyColumn(R.string.ADDRESS, TransactionsInfo::address)
                readonlyColumn(R.string.AMOUNT, TransactionsInfo::amount)
                readonlyColumn(R.string.DATE, TransactionsInfo::date)

                columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
            }
        }
    }

    override fun inject() {
        UsoamicWallet.component.historySubcomponent.create().inject(this)
    }

    override fun initObservers() {
        super.initObservers()
        observe(viewModel.ldData, ::setDate)
    }

    private fun setDate(list: List<TransactionItem>) {
        var id = 0
        with(historyItems) {
            removeAll()
            addAll(
                list.map {
                    id++
                    it.toInfo(id, formatter)
                }
            )
        }
    }

    override fun onRefresh() {
        super.onRefresh()
        viewModel.onRefresh()
    }
}
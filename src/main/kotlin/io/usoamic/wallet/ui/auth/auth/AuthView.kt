package io.usoamic.wallet.ui.auth.auth

import io.usoamic.wallet.extensions.fx.replaceWithSlideLeft
import io.usoamic.wallet.ui.auth.add.AddView
import io.usoamic.wallet.ui.auth.create.CreateView
import io.usoamic.wallet.ui.base.BaseView
import io.usoamic.wallet.values.R
import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import tornadofx.*

class AuthView : BaseView() {
    override val root: StackPane = stackpane {
        paddingHorizontal = 50.0
        vbox(10) {
            pane()
            alignment = Pos.CENTER
            imageview(R.image.IC_USOAMIC) {
                fitHeight = 200.0
                fitWidth = 200.0
            }
            label(R.string.APP_NAME) {
                vboxConstraints {
                    marginBottom = 15.0
                }
            }

            button(R.string.ADD_ACCOUNT) {
                fitToParentWidth()
                action {
                    replaceWithSlideLeft<AddView>()
                }
            }
            button(R.string.CREATE_ACCOUNT) {
                fitToParentWidth()

                action {
                    replaceWithSlideLeft<CreateView>()
                }
            }
        }
    }

}
package io.usoamic.wallet.ui.base

import io.usoamic.validateutilkt.error.*
import io.usoamic.wallet.commons.models.base.ErrorArguments
import io.usoamic.wallet.extensions.observe
import io.usoamic.wallet.values.R
import javafx.scene.Node
import javax.inject.Inject

abstract class BaseVmView<T : BaseViewModel>(title: String = R.string.APP_NAME, icon: Node? = null) : BaseView(title, icon) {
    @Inject
    lateinit var viewModel: T

    init {
        initObservers()
    }


    protected open fun showError(error: ErrorArguments) {
        val str = when (error.throwable) {
            is EmptyAddressError -> R.string.EMPTY_ADDRESS
            is EmptyAppIdError -> R.string.EMPTY_APP_ID
            is EmptyCommentError -> R.string.EMPTY_COMMENT
            is EmptyConfirmPasswordError -> R.string.EMPTY_CONFIRM_PASSWORD
            is EmptyDescriptionError -> R.string.EMPTY_DESCRIPTION
            is EmptyMnemonicPhraseError -> R.string.EMPTY_MNEMONIC_PHRASE
            is EmptyNoteContentError -> R.string.EMPTY_NOTE_CONTENT
            is EmptyPasswordError -> R.string.EMPTY_PASSWORD
            is EmptyPrivateKeyError -> R.string.EMPTY_PRIVATE_KEY
            is EmptyPurchaseIdError -> R.string.EMPTY_PURCHASE_ID
            is EmptyValueError -> R.string.EMPTY_VALUE
            is InvalidAddressError -> R.string.INVALID_ADDRESS
            is InvalidIdError -> R.string.INVALID_ID
            is InvalidMnemonicPhraseError -> R.string.INVALID_MNEMONIC_PHRASE
            is InvalidPrivateKeyError -> R.string.INVALID_PRIVATE_KEY
            is InvalidValueError -> R.string.INVALID_VALUE
            is PasswordsDoNotMatchError -> R.string.PASSWORDS_DO_NOT_MATCH
            is PrivateKeyRequiredError -> R.string.PRIVATE_KEY_REQUIRED
            else -> null
        }
        val message = str ?: error.message ?: R.string.UNKNOWN_ERROR
        val isFinish = (error is ErrorArguments.Fatal)
        showErrorDialog(message, isFinish)
    }

    protected open fun initObservers() {
        observe(viewModel.ldThrowable, ::showError)
        observe(viewModel.ldError, ::showErrorDialog)
    }

    override fun onUndock() {
        viewModel.onCleared()
        super.onUndock()
    }
}
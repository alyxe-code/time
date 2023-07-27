package ru.alyxe.time.core.viewmodel

import androidx.lifecycle.ViewModelStoreOwner
import org.koin.core.component.KoinScopeComponent

interface KoinViewModelStoreOwner : KoinScopeComponent, ViewModelStoreOwner
